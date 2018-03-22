package MVC;


import static MVC.NewSoundAndSpeech.playStream;
import static MVC.NewSoundAndSpeech.readStream;
import static MVC.NewSoundAndSpeech.setupStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.InputStream;
import java.util.Enumeration;
import gnu.io.*;
import java.io.IOException;
import java.util.TooManyListenersException;
import javax.sound.sampled.AudioInputStream;

/**
 * This Satellite Controller class is used to connect to serial port, reading, parsing NMEA message,
 * updating latitude/longitude/direction in model and displaying them in the panel(view).
 * This class implements Runnable,therefore, it is able to create its own thread for reading NMEA message, without crashing the main UI thread.
 * @MVC - Controller: SatelliteController controls model and view(SatellitePanel)
 * @author - Yukun Sun, 2018. 
 */

public class SatelliteController implements Runnable, SerialPortEventListener{
    private MVC.Model model;
    private SatellitePanel view;
    
    private static final String GLL = "$GPGLL";          // GLL message
    private static final String GLL_VOID = "V";          // void sign
    private static final int    TIME_OUT = 2000;
    private static final int    BUFFER_SIZE = 128;
    private static final int    DATA_RATE= 9600;
    private static final double MINUTE_TO_HOUR = 60.0;
    
    private static final String WINDOWS10_PORT = "COM4";   // windows 10 default serial port 
    private static final String LINUX_PORT =   "/dev/ttySO"; // linux default serial port
    private static final String OS_PORT =      "????";     // os default serial port
    private static final String WINDOWS7_PORT = "COM3";    // windows 7 default serial port
    
    public static final String NO_SIGNAL = "src/Sounds/nosignal.wav";        // location of the pre-recorded file
    public static final String NOT_CONNECTED = "src/Sounds/notconnected.wav";
            
    static RXTXPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    static boolean connected;
    static boolean signal;
    String PortName;
    
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
        // change the connecting port name based on operating system
        String osname = System.getProperty("os.name","").toLowerCase(); // get opeating system name
        if (osname.startsWith("windows 10")){  
            PortName = WINDOWS10_PORT;
        }else if(osname.startsWith("linux")){ 
            PortName = LINUX_PORT;
        }else if(osname.startsWith("mac")){  
            PortName = OS_PORT;
        }else if(osname.startsWith("windows 7")){ 
            PortName = WINDOWS7_PORT;
        }else{
            System.out.println("Sorry, your operating system is not supported!");
        }

      portList = CommPortIdentifier.getPortIdentifiers();

      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals(PortName)){    
                SatelliteController reader = new SatelliteController();
                return;
            }  
          }
        }
        }catch(UnsatisfiedLinkError | NoClassDefFoundError e){
            System.out.println("Hint: rxtxSerial File has wrong version! Please read the README.txt and change it.");
        }
      // not connected with dongle
      connected = false;
      signal = false;
      SatellitePanel.updateView(connected, 0, 'a', 0,'a', signal);   
    } 
    /**
     * Open serial port and start a reading thread. 
     * Add event listner, notify when there are available messages.
     */
    public SatelliteController() {        
       try{
            serialPort = (RXTXPort)portID.open("TheSatellite",TIME_OUT);
       }catch(PortInUseException e){
           System.out.println("Hint: Port is being used by another application! Please turn off and restart! ");
       }
       try{
           in  = serialPort.getInputStream();
       }catch(Exception e){System.out.println(e);}
       try{
           serialPort.addEventListener(this);
        }catch(TooManyListenersException e){
            System.out.println("Hint: Too many listener added!Please check if you have opened the project twice!");
        }
        serialPort.notifyOnDataAvailable(true);     
        try{
            serialPort.setSerialPortParams(
                DATA_RATE,
                SerialPort.DATABITS_8,SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
            
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
        }catch(UnsupportedCommOperationException e){
            System.out.println("Not supported!");
        }
            connected = true;    // connected to the serial port
            readThread = new Thread(this);
            readThread.start();    // start read thread for reading NMEA messages
     
 }
    @Override
    public void run() {
        try{
            Thread.sleep(20000);
        }catch(InterruptedException e){};   
    }

   /**
     * Handling events.Read and update data when data is available .
     * @param event serial port event containing 11 fields
     * @see https://docs.oracle.com/cd/E17802_01/products/products/javacomm/reference/api/javax/comm/SerialPortEvent.html
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
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY: 
                // no signal, update view!
                SatellitePanel.updateView(signal, 0, 'a', 0,'a',connected);
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                // availeble date, update!
                update();
                break;
        }
  }
    /**
     * Read from the input stream, parses messages and update position .
     */
    public synchronized void update(){
    try{    
        byte[] buffer  = new byte[ BUFFER_SIZE ];
        String msg;
        int    n;             
        while( ( n = in.read( buffer ) ) > -1 ) {
        msg = new String( buffer, 0, n ); 
        // GLL message...
        if (msg.startsWith(GLL)){   
            if(msg.contains(GLL_VOID)){   // message contains "V" : void message, display no signal
                signal = false; 
                SatellitePanel.updateView(signal, 0, 'a', 0,'a',connected); // connected but no signal
            }else{ 
             
            signal = true;                 
            // connected and have available message         
            // Convert NMEA latitude, longitude message.
            // An example NMEA message:$GPGLL,5043.61007,N,00331.04761,W,204703.00,A,A*7E
            // substring of 7-9/20-23 : degree of latitude/longitude (50 / 003 in the example)
            // substring of 9-17/23-31: minite of latitude/longitude (43.61007 minutes / 31.04761 minutes in the example)
            // index of 18/32: direction of latitude/longitude (N / W in the example)
            double latitude  = converter(msg.substring(7,9),msg.substring(9,17));
            double longitude = converter(msg.substring(20,23),msg.substring(23,31));
            
            // update model location..
            Model.latitude = latitude;
            Model.dOLatitude= msg.charAt(18);
            Model.longitude= longitude;
            Model.dOLongitude=msg.charAt(32);
            if (Model.dOLatitude == 'S') // South and West coordinates should be negative
                Model.latitude *= -1;
            if (Model.dOLongitude == 'W')
                Model.longitude *= -1;
            SatellitePanel.updateView(signal, latitude, Model.dOLatitude, longitude, Model.dOLongitude,connected);
            }
        }
        } 
    }catch(IOException e){}
    
}
    /** 
     * Generate pre-recorded sound when there is no signal or the dongle is not connected.
     */
    public static void generateSound(String filename){
        Thread reading = new Thread(){
           @Override
           public void run(){
               AudioInputStream stm = setupStream( filename );
               playStream( stm, readStream( stm ) );
           }
        };
        reading.start();
        
    }

   /** 
    *  Convert NMEA DMS Geographic coordinate system string message into decimal degrees
    *  @see https://www.latlong.net/degrees-minutes-seconds-to-decimal-degrees.
    */
    private double converter(String degree, String minute){
        Float degrees  = Float.valueOf(degree);
        Float minites  = Float.valueOf(minute);
        double posi = degrees + minites/MINUTE_TO_HOUR;

    return posi;
} 
    
    /**
     * Disconnect the port, remove listeners and close input stream,
     * Force quit without calling the disconnect() method will procude "getCommModemFailed" error. 
     * But rxtx library seems to have a problem with closing port in multi-thread applications. The IOLocked variable is not synchronized. 
     * @see https://issues.apache.org/jira/browse/DIRMINA-813 for this problem. This CloseThread class use workaround one solution. 
     */
    class CloseThread extends Thread { 
        public void run() { 
            serialPort.removeEventListener(); 
            serialPort.close(); 
        }
} 
        public void disconnect() {
            try { 
                if (serialPort != null) { 
                    serialPort.getInputStream().close(); 
                    serialPort.getOutputStream().close(); 
                    new CloseThread().start(); 
                }
             } catch (Exception e) {} 
        }
 


 
}
