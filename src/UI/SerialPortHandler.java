/*
 * @Author Harry
 */
package UI;


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
 *
 * @author harry
 */
public class SerialPortHandler implements Runnable, SerialPortEventListener{
    static SerialPort serialPort;
    static InputStream in;
    static Thread readThread;
    static CommPortIdentifier portID;
    static Enumeration portList;
    static double latitude; //latitude
    static char direction;
    static double longitude; //longitude
    static char dir;
    static String time;
    static boolean signal;
    public SerialPortHandler(){        
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
                 

public static void update(){
        try{
        byte[] buffer  = new byte[ 1024 ];
        String s;
        int    n;
               
        while( ( n = in.read( buffer ) ) > -1 ) {
       // n = in.read(buffer);
        s = new String( buffer, 0, n ); 
        //System.out.println(s);
        if (s.startsWith("$GPGLL,,,")){
            displayNoSignal();
            signal = false;
        }
        else if (s.startsWith("$GPGLL")){
            //System.out.println(s);
            signal = true;
            Integer degrees  = Integer.valueOf(s.substring(7,9)); //latitude degrees
            Integer minites  = Integer.valueOf(s.substring(9,11));//latitude minutes		  
            double seconds  = 60*0.00001*(Integer.valueOf(s.substring(12,17))); //latitude seconds, returned 
                                                                                 //string is in the form of 0.xxxxx mins 
                                                                                //therefore *60*0.00001 to convert to seconds 
            direction= s.charAt(18); // direnction of latitude 				   
            latitude = degrees + minites/60.0 + seconds / 3600.0;
            if (direction=='S')
                latitude = (-1) * latitude; // convert latitude to nagetive if direction is South 
            
            Integer deg  = Integer.valueOf(s.substring(20,23)); //longitude degrees
            Integer min  = Integer.valueOf(s.substring(23,25));//longitude minutes		  
            double sec  = 60*0.00001*(Integer.valueOf(s.substring(26,31))); //longitude seconds, returned 
									 //string is in the form of 0.xxxxx mins 
									//therefore *60*0.00001 to convert to seconds 
            dir = s.charAt(32); // direnction of longitude			   
            longitude = deg + min/60.0 + sec / 3600.0;

            if (dir=='W')
                longitude = (-1) * longitude; // convert longitude to nagetive if direction is West 
           
             time     = (((s.substring(34,36).concat(":")).
                        concat(s.substring(36,38))).
                        concat(":")).concat(s.substring(38,40));//time 
            XtrekUI.Time.setText(time);
            XtrekUI.Time.setForeground(Color.green);
            displayPosition();  // display the updated postion to UI screen
        }
        }
        }catch(IOException e){System.out.println(e);}
       
        
    }

public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
private static void displayNoSignal(){
    XtrekUI.Latitude.setText("      No signal!");
    XtrekUI.Latitude.setForeground(Color.red);
    XtrekUI.Longitude.setText("      No signal!"); 
    XtrekUI.Longitude.setForeground(Color.red);
}

private static void displayPosition(){
    XtrekUI.Latitude.setText("Latitude: "+round(Math.abs(latitude),4)+" , "+direction);
    Font f = new Font("MS Reference San Serif",Font.BOLD,18);
    XtrekUI.Latitude.setFont(f);
    XtrekUI.Latitude.setForeground(Color.green);
    XtrekUI.Longitude.setText("Longitude: "+round(Math.abs(longitude),4)+" , "+dir);
    XtrekUI.Longitude.setForeground(Color.green);
    XtrekUI.Longitude.setFont(f);
}


public static double getLatitude(){
        return (latitude); // get latitude withour direction 
    }

public static double getLongitude(){  
        return(longitude); // get longitude without direction 
    }
public static String getPosition(){
    String position = "" + latitude + ","+longitude;
    return position;
}
public static String getTime(){
        return(time);
    }
public void disconnect(){
    try{
        serialPort.removeEventListener();
        serialPort.close();
        in.close();
        signal = false;
    }catch(Exception e){}               
    }

public static void connect(){
      portList = CommPortIdentifier.getPortIdentifiers();
      
      while(portList.hasMoreElements()){
          portID = (CommPortIdentifier)portList.nextElement();
          if (portID.getPortType() == CommPortIdentifier.PORT_SERIAL){
            if(portID.getName().equals("COM4")){
                SerialPortHandler reader = new SerialPortHandler();
            }
      }
      }
  }
    
}       
        
    
    
    
    

