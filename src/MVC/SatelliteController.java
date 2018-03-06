/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class SatelliteController implements Runnable, SerialPortEventListener{
    private SatelliteModel model;
    private boolean signal;
    static SerialPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    
    public SatelliteController(SatelliteModel model){
        this.model = model;
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
            signal = false; 
            model.updateSignal(false);      
        }
        // available message..
        else if (s.startsWith("$GPGLL")){
            System.out.println("Updating...");
            signal = true;
            model.updateSignal(true);
            	
            /* Convert NMEA message */
            double latitude  = converter(s.substring(7,9),s.substring(9,11),s.substring(12,17));
            double longitude = converter(s.substring(20,23),s.substring(23,25),s.substring(26,31));
            String time     =  convertTime(s.substring(34,36),s.substring(36,38),s.substring(38,40));
            model.updateLatitude(latitude, s.charAt(18));
            
            model.updateLongitude(longitude,s.charAt(32));
            model.updateTime(time);
            }
        }
    }catch(IOException e){}
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
            signal = false;
            model.updateSignal(false);
        }catch(IOException e){}               
}
  /* Public method, to connect port and try to get GPS location */
    public static void connect(){
      portList = CommPortIdentifier.getPortIdentifiers();
      
      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals("COM4")){
                SatelliteController reader = new SatelliteController();
            }
      }
      }
  }  
    
    
}
