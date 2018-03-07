/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import UI.XtrekUI.*; 
import java.lang.*;
import static java.lang.Thread.sleep;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.HttpConnect;
import org.json.*;
/**
 *
 * @author 20521
 */
public class tripComputer {
    

public static void movingTimeIncease(){
        
        Thread time = new Thread(){
        public void run(){
        for(;;){
            String str_s = Integer.toString(XtrekUI.second);
            String str_m = Integer.toString(XtrekUI.minute);
            String str_h = Integer.toString(XtrekUI.hour);
            XtrekUI.timeDisplay.setText(str_h+"Hour    "+str_m+"Min    "+str_s+"Sec");
            try{sleep(1000);}catch(InterruptedException e){}
            
            XtrekUI.second++;
            if(XtrekUI.second==60){
                XtrekUI.minute++;
                XtrekUI.second = 0;
            }
            if(XtrekUI.minute==60){
                XtrekUI.hour++;
                XtrekUI.minute = 0;
            }
        }
        }
        };
        time.start();
    }
    
    public static byte[] readDirections(String start,String end){
        try {
            final String encOrigin      = URLEncoder.encode( start,      "UTF-8" );
            final String encDestination = URLEncoder.encode( end, "UTF-8" );
            final String method = "GET";
            final String url 
            = ( "https://maps.googleapis.com/maps/api/directions/json"
              + "?" + "origin"      + "=" + encOrigin
              + "&" + "destination" + "=" + encDestination
              + "&" + "mode"        + "=" + XtrekUI.MODE
              );
            final byte[] body
             = {}; 
            final String[][] headers
             = {};
            byte[] response = HttpConnect.httpConnect( method, url, headers, body );
            return response;
            } catch ( Exception ex ) {return null;}
    }
    
    public static String calculateOdem(String start,String end)throws JSONException{
        byte[] directions = readDirections(start,end);
        String s = new String(directions);
        JSONObject obj = new JSONObject(s);
        JSONArray routes = (JSONArray) obj.getJSONArray("routes");
        JSONObject child1 = (JSONObject) routes.getJSONObject(0);
        JSONArray legs = (JSONArray) child1.getJSONArray("legs");
        JSONObject child2 = (JSONObject) legs.getJSONObject(0);
        JSONObject distance = (JSONObject) child2.get("distance");
        String dis = distance.getString("text");
        return dis;
    }
    
    public static void displayOdem(String start,String end)throws JSONException{
        String odem = calculateOdem(start,end);
        XtrekUI.odometer = odem;
        XtrekUI.odemDisplay.setText(XtrekUI.odometer);
    
    }
    
    public static void displaySpeed(){
        
        Thread speed = new Thread(){
            public void run(){
               for(;;){
                   
                   try{sleep(1000);}catch(InterruptedException e){}
                   
                   XtrekUI.t++;
                   
                   String pureSpeed = XtrekUI.odometer.substring(0,XtrekUI.odometer.length()-3);
                   Double distanceValue = Double.parseDouble(pureSpeed);
                   Double speedValue = distanceValue/XtrekUI.t*3600;
                   String speedInKmh = Double.toString(speedValue) + "   KM/H";
                   
                   XtrekUI.speedDisplay.setText(speedInKmh);
               
               
               }
            
            }
        };
        
        speed.start();
        
        //speedDisplay.setText("");
    }    
}
