
package MVC;


import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.util.Enumeration;
import gnu.io.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.TooManyListenersException;
/**
 * @MVC - Controller: SatelliteController controls model and view(SatellitePanel)
 * It has functions of updating latitude/longitude/direction in model, and displaying
 * them in the panel(view). 
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class SatelliteController implements Runnable, SerialPortEventListener{
    private MVC.Model model;
    private SatellitePanel view;
    
    static SerialPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    
    public SatelliteController(MVC.Model model,SatellitePanel view){
        this.model = model;
        this.view = view;
    }
    
      /* Public static method, to connect port and try to get GPS location */
    public void connect(){
      portList = CommPortIdentifier.getPortIdentifiers();

      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals("COM4")){
                SatelliteController reader = new SatelliteController();
                return;
            }  
          }
     }
      // not connected with GPS device
      updateView(false, 0, 'a', 0,'a', "");     
    } 
    /* Open serial port*/
    public SatelliteController(){        
       try{
            serialPort = (SerialPort)portID.open("TheSatellite",3000);
       }catch(PortInUseException e){System.out.println(e);}
       try{
           in  = serialPort.getInputStream();
       }catch(IOException e){System.out.println(e);}
       try{
           serialPort.addEventListener(this);
        }catch(TooManyListenersException e){System.out.println(e);}
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
        }catch(InterruptedException e){System.out.println(e);};   
    }

    /* Read data from serial port, only read the message when there is data available */
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
    /* Read from the serial port, convert messages and update position */
    public void update(){
    try{
        byte[] buffer  = new byte[ 128 ];
        String s;
        int    n;             
        while( ( n = in.read( buffer ) ) > -1 ) {
        s = new String( buffer, 0, n ); 
        // no available message.. 
        if (s.startsWith("$GPGLL,,,")){
            model.signal = false; 
            updateView(false, 0, 'a', 0,'a', ""); 
        }
        // available message..
        else if (s.startsWith("$GPGLL")){       
            //System.out.println("Updating...");
            Model.signal = true;
            /* Convert NMEA message */
            double latitude  = converter(s.substring(7,9),s.substring(9,11),s.substring(12,17));
            double longitude = converter(s.substring(20,23),s.substring(23,25),s.substring(26,31));
            String time     =  convertTime(s.substring(34,36),s.substring(36,38),s.substring(38,40));
            Model.latitude = latitude;
            Model.dOLatitude= s.charAt(18);
            Model.longitude= longitude;
            Model.dOLongitude=s.charAt(32);
            if (Model.dOLatitude == 'S')
                Model.latitude *= -1;
            if (Model.dOLongitude == 'W')
                Model.longitude *= -1;
            Model.time    = time;
            updateView(true, latitude, Model.dOLatitude, longitude, Model.dOLongitude, time);
            }
        }
    }catch(IOException e){}
   }
    /* update position in view*/   
    public void updateView(boolean signal,double latitude,char dOLatitude,double longitude,
            char dOLongitude, String time){
        Font f = new Font("MS Reference San Serif",Font.BOLD,18);
        if( signal == true ){
            SatellitePanel.latitude.setText("Latitude: "+round(Math.abs(latitude),4)+" , "+dOLatitude);
            SatellitePanel.longitude.setText("Longitude: "+round(Math.abs(longitude),4)+" , "+dOLongitude);
            SatellitePanel.latitude.setFont(f);
            SatellitePanel.longitude.setFont(f);
            SatellitePanel.latitude.setForeground(Color.green);
            SatellitePanel.longitude.setForeground(Color.green);
            SatellitePanel.time.setText(time);                 
        }
        else{
            SatellitePanel.latitude.setText("       No signal!");
            SatellitePanel.longitude.setText("       No signal!");
            SatellitePanel.time.setText("  Last signal at: "+Model.time);
            SatellitePanel.latitude.setForeground(Color.red);
            SatellitePanel.longitude.setForeground(Color.red);
        }
    }
        /**
     * @ helper function : Round a value to certain decimal places 
     */
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }

   /* Convert NMEA string message into decimal degrees */
    private double converter(String degree, String minute, String second){
        Integer degrees  = Integer.valueOf(degree);
        Integer minites  = Integer.valueOf(minute);
        double seconds  = 60*0.00001*(Integer.valueOf(second));
        double posi = degrees + minites/60.0 + seconds / 3600.0;

    return posi;
} 
    /* Convert NMEA string message into time*/
    private String convertTime(String hour, String minute, String second){
        return ((((hour.concat(":")).concat(minute)).concat(":")).concat(second));
}
    /* Disconnect the port */
    public void disconnect(){
        try{
            serialPort.removeEventListener();
            serialPort.close();
            in.close();
            Model.signal = false;
        }catch(IOException e){}               
}

    
    
}
