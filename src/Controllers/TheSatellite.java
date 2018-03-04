package Controllers;

import UI.*;
import gnu.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import gnu.io.CommPortIdentifier;
import java.awt.Color;
import java.awt.Font;

/**
 * @author Harry Sun (Group L WorkPackage 5)
 * @last_update 04/03/2018
 * @function open and read NMEA message from serial port, and display it on Satellite UI
 */
public class TheSatellite implements Runnable, SerialPortEventListener{
    
    static SerialPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    static double latitude;     //latitude
    static char   direction;    // direction of latitude
    static double longitude;    // longitude
    static char   dir;          // direction of longitude
    static String time;         // time last update the position
    static boolean signal;      // indicates whether there is signal
    
    /* Open serial port*/
    public TheSatellite(){        
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
    
public void run(){
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
public static void update(){
    try{
        byte[] buffer  = new byte[ 1024 ];
        String s;
        int    n;             
        while( ( n = in.read( buffer ) ) > -1 ) {
        s = new String( buffer, 0, n ); 
        
        // no available message.. 
        if (s.startsWith("$GPGLL,,,")){
            signal = false;
            displayNoSignal();
        }
        // available message..
        else if (s.startsWith("$GPGLL")){
            signal = true;
            direction= s.charAt(18);      // direnction of latitude 	
            dir      = s.charAt(32);      // direnction of longitude
            /* Conver NMEA message */
            latitude  = converter(s.substring(7,9),s.substring(9,11),s.substring(12,17));
            longitude = converter(s.substring(20,23),s.substring(23,25),s.substring(26,31));
            time     =  convertTime(s.substring(34,36),s.substring(36,38),s.substring(38,40));
            displayTime();
            displayPosition();  
            }
        }
   }catch(IOException e){System.out.println(e);}      
}

/* Convert NMEA string message into decimal degrees */
private static double converter(String degree, String minute, String second){
    Integer degrees  = Integer.valueOf(degree);
    Integer minites  = Integer.valueOf(minute);
    double seconds  = 60*0.00001*(Integer.valueOf(second));
    double posi = degrees + minites/60.0 + seconds / 3600.0;
    if (direction=='S') 
        posi = (-1) * posi;
    if (dir=='W')
        posi = (-1) * posi;
    return posi;
}

/* Convert NMEA string message into time*/
private static String convertTime(String hour, String minute, String second){
    return ((((hour.concat(":")).concat(minute)).concat(":")).concat(second));
}

/* Round a value to certain decimal places */
private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

/* Display no signal in the UI */
private static void displayNoSignal(){
    if (signal == false){
        XtrekUI.Latitude.setText("      No signal!");
        XtrekUI.Latitude.setForeground(Color.red);
        XtrekUI.Longitude.setText("      No signal!"); 
        XtrekUI.Longitude.setForeground(Color.red);
    }
}

/* Display the newly read position*/
private static void displayPosition(){
    if (signal == true){
        XtrekUI.Latitude.setText("Latitude: "+round(Math.abs(latitude),4)+" , "+direction);
        Font f = new Font("MS Reference San Serif",Font.BOLD,18);
        XtrekUI.Latitude.setFont(f);
        XtrekUI.Latitude.setForeground(Color.green);
        XtrekUI.Longitude.setText("Longitude: "+round(Math.abs(longitude),4)+" , "+dir);
        XtrekUI.Longitude.setForeground(Color.green);
        XtrekUI.Longitude.setFont(f);
    }
}

/* Display time*/
private static void displayTime(){
    XtrekUI.Time.setText(time);
    XtrekUI.Time.setForeground(Color.green);
}

/* Public method, return latitude */
public static double getLatitude(){
    return (latitude); 
}

/* Public method, return longitude */
public static double getLongitude(){  
        return(longitude); 
}

/* Public method, return position containing latitude and longitude */
public static String getPosition(){
    String position = "" + latitude + ","+longitude;
    return position;
}

/* Public method, return time*/
public static String getTime(){
        return(time);
}

/* Disconnect the port */
public void disconnect(){
    try{
        serialPort.removeEventListener();
        serialPort.close();
        in.close();
        signal = false;
    }catch(Exception e){}               
}

/* Public method, to connect port and try to get GPS location */
public static void connect(){
      portList = CommPortIdentifier.getPortIdentifiers();
      
      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals("COM4")){
                TheSatellite reader = new TheSatellite();
            }
      }
      }
  }
    

}       
        
    
    
    
    

