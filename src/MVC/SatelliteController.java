
package MVC;


import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.util.Enumeration;
import gnu.io.*;
import java.io.IOException;
import java.util.TooManyListenersException;

/**
 * @MVC - Controller: SatelliteController controls model and view(SatellitePanel)
 * @functions Connectin to port, reading GPS message, updating latitude/longitude/direction in model, 
 * and displaying them in the panel(view). 
 * @author - Yukun Sun (Group L WorkPackage 5)
 */

public class SatelliteController implements Runnable, SerialPortEventListener{
    private MVC.Model model;
    private SatellitePanel view;
    
    static SerialPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    
    /* Constuctor: initialize model and view */
    public SatelliteController(MVC.Model model,SatellitePanel view){
        this.model = model;
        this.view = view;
    }
    
  /** 
    * Connect to the port and call the SatelliteController method to start reading
    * @exception UnsatisfiedLinkError: Probably caused by using wrong (32/64) version of rxtxSerial.dll file 
    * @exception NoClassDefFoundError: Probably caused by using wrong (32/64) version of rxtxSerial.dll file
    */ 
    public void connect(){
    try{
      portList = CommPortIdentifier.getPortIdentifiers();

      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals("COM4")){     // Windows 10: COM4
                SatelliteController reader = new SatelliteController();
                return;
            }  
          }
        }
        }catch(UnsatisfiedLinkError | NoClassDefFoundError e){System.out.println("rxtxSerial File has wrong version! Please read the README.txt and change it.");
        }

      SatellitePanel.updateView(false, 0, 'a', 0,'a', false);   // not connected with GPS device
      Model.signal = false;
    } 
    /**
     * Open serial port and start a reading thread 
     * @exception PortInUseException Port is being used by another app (can be caused by opening the app twice.
     * @exception TooManyListenersException Too many listeners are added to the port( can be caused by opening the app twice).
     * @exception UnsupportedCommOperationException COM port not supported.
     */
    public SatelliteController() {        
       try{
            serialPort = (SerialPort)portID.open("TheSatellite",3000);
       }catch(PortInUseException e){System.out.println("Port is being used by another application! Please turn off and restart! ");}
       try{
           in  = serialPort.getInputStream();
       }catch(IOException e){System.out.println(e);}
       try{
           serialPort.addEventListener(this);
        }catch(TooManyListenersException e){System.out.println("Too many listener added!Please check if you have opened the project twice!");}
        serialPort.notifyOnDataAvailable(true);     
        try{
            serialPort.setSerialPortParams(
                9600,
                SerialPort.DATABITS_8,SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
            
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        }catch(UnsupportedCommOperationException e){System.out.println(e);}
            readThread = new Thread(this);
            readThread.start();    
     
 }
    @Override
    @SuppressWarnings("empty-statement")
    public void run() {
        try{
            Thread.sleep(20000);
        }catch(InterruptedException e){};   
    }

   /**
     * Handling events.Read and update data when data is available .
     * @param event serial port event
     */
    @Override
    public void serialEvent(SerialPortEvent event){
        switch(event.getEventType()){
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: break;
            case SerialPortEvent.DATA_AVAILABLE:
                update();
                break;
        }
  }
    /**
     * Read from the input stream, convert messages and update position .
     * @exception IOException input/output exception
     */
    public void update(){
    try{
        byte[] buffer  = new byte[ 128 ];
        String s;
        int    n;             
        while( ( n = in.read( buffer ) ) > -1 ) {
        s = new String( buffer, 0, n ); 

        // no available message.. 
        if (s.startsWith("$GPGLL,,,")){
            Model.signal = false; 
            SatellitePanel.updateView(false, 0, 'a', 0,'a',true); // connected but no signal
        }
        // available message.. update model and view
        else if (s.startsWith("$GPGLL")){       
            Model.signal = true;
            // Convert NMEA latitude, longitude message.
            // An example NMEA message:
            // substring index of 7-9/20-23 : degree of latitude/longitude
            // substring index of 9-11/23-25: minite of latitude/longitude
            // substring index of 12-17/38-40 : seconds of latitude/longitude
            // index of 18/32: direction of latitude/longitude
            double latitude  = converter(s.substring(7,9),s.substring(9,11),s.substring(12,17));
            double longitude = converter(s.substring(20,23),s.substring(23,25),s.substring(26,31));
            // String time     =  convertTime(s.substring(34,36),s.substring(36,38),s.substring(38,40));
            Model.latitude = latitude;
            Model.dOLatitude= s.charAt(18);
            Model.longitude= longitude;
            Model.dOLongitude=s.charAt(32);
            if (Model.dOLatitude == 'S') // change to negative for South and West
                Model.latitude *= -1;
            if (Model.dOLongitude == 'W')
                Model.longitude *= -1;
            SatellitePanel.updateView(true, latitude, Model.dOLatitude, longitude, Model.dOLongitude,true);
            }
        }
    }catch(IOException e){}
   }


   /** 
    *  Convert NMEA DMS Geographic coordinate system string message into decimal degrees
    *  @see https://www.latlong.net/degrees-minutes-seconds-to-decimal-degrees.
    */
    private double converter(String degree, String minute, String second){
        Integer degrees  = Integer.valueOf(degree);
        Integer minites  = Integer.valueOf(minute);
        /* TODO: NMEA seconds String message is 5 digit long, divide by 100000 */
        double seconds  = 60/100000*(Integer.valueOf(second));  
        double posi = degrees + minites/60.0 + seconds / 3600.0; // Decimal Degrees = degrees + (minutes/60) + (seconds/3600)

    return posi;
} 

    /**
     * Disconnect the port, remove listeners and close input stream.
     * @exception IOException input/output exception
     */
    public void disconnect(){
        try{ 
            if(Model.signal == true){
                serialPort.removeEventListener();                 
                serialPort.close();
                in .close();
            }
            Model.signal = false;
        }catch(IOException e){}               
}

    
    
}
