/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import static UI.tripComputer.calculateOdem;
import static UI.tripComputer.readDirections;
import static java.lang.Thread.sleep;
import java.util.Observable; 
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.*;
import java.util.*;
import javaapplication1.HttpConnect;
/**
 *
 * @author 20521
 */
enum Keys{KEY_A,KEY_B,KEY_C,KEY_D,KEY_E,KEY_F,KEY_G,KEY_H,KEY_I,KEY_J,KEY_K,KEY_L,KEY_M,KEY_N,KEY_O,
         KEY_P,KEY_Q,KEY_R,KEY_S,KEY_T,KEY_U,KEY_V,KEY_W,KEY_X,KEY_Y,KEY_Z,KEY_SPACE,KEY_NEXT,KEY_SUB1,
         KEY_ONE,KEY_TWO,KEY_THREE,KEY_FOUR,KEY_FIVE,KEY_SIX,KEY_SEVEN,KEY_EIGHT,KEY_NINE,KEY_ZERO,KEY_DELETE,KEY_PREV,KEY_SUB2};




public class WP2Model extends Observable{
    static whereToView wheretoview;
    static tripComputerView tripcomputerview;
    static Keys keys;
    final static String ORIGIN      = "50.7268,-3.5174";
    final static String DESTINATION = "Cathedral Green, Exeter";
    final static String REGION      = "uk";
    final static String MODE        = "walking"; /* "driving" */
    final static String key= "AIzaSyCMMwL7rLUZdfDuB-_X6R11jQ57ZzMN0Xg";
    static boolean tripComputerRun= false;
    static int t = 0;
    static int second = 0;
    static int minute = 0;
    static int hour = 0;
    static String odometer = "0";
    static boolean submitClicked = false;
    static HashMap<String,String> route = new HashMap<String,String>(20);
            
    public WP2Model(whereToView wheretoview,tripComputerView tripcomputerview,Keys keys){
        this.wheretoview = wheretoview;
        this.keys = keys;
        this.tripcomputerview = tripcomputerview;
        setChanged();
        notifyObservers(wheretoview);
        notifyObservers(key);
        notifyObservers(tripcomputerview);
    };
    
    
    
    
    public static void movingTimeIncease(){
        
        Thread time = new Thread(){
        public void run(){
        for(;;){
            String str_s = Integer.toString(second);
            String str_m = Integer.toString(minute);
            String str_h = Integer.toString(hour);
            tripComputerView.timeDisplay.setText(str_h+"Hour    "+str_m+"Min    "+str_s+"Sec");
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
              + "&" + "mode"        + "=" + MODE
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
        odometer = odem;
        tripComputerView.odemDisplay.setText(odometer);
    
    }
    
    public static void displaySpeed(){
        
        Thread speed = new Thread(){
            public void run(){
               for(;;){
                   
                   try{sleep(1000);}catch(InterruptedException e){}
                   
                   XtrekUI.t++;
                   
                   String pureSpeed = odometer.substring(0,odometer.length()-3);
                   Double distanceValue = Double.parseDouble(pureSpeed);
                   Double speedValue = distanceValue/t*3600;
                   String speedInKmh = Double.toString(speedValue) + "   KM/H";
                   
                   tripComputerView.speedDisplay.setText(speedInKmh);
               
               
               }
            
            }
        };
        
        speed.start();
        
        //speedDisplay.setText("");
    } 
    
    static void findInstruction(String s1,String s2) throws JSONException{
        String s = new String(readDirections(s1,s2));
        
        JSONObject obj = new JSONObject(s);
        JSONArray routes = (JSONArray) obj.get("routes");
        JSONObject child1 = (JSONObject) routes.getJSONObject(0);
        JSONArray legs = (JSONArray) child1.get("legs");
        JSONObject child2 = (JSONObject) legs.getJSONObject(0);
        JSONArray steps = (JSONArray)child2.getJSONArray("steps");
        
        int t= 0;
        for(int i = 0;i<steps.length();i++){
            JSONObject step = steps.getJSONObject(i);
            //end location
            JSONObject end_location = (JSONObject)step.getJSONObject("end_location");
            String lat = Double.toString(end_location.getDouble("lat"));
            String lng = Double.toString(end_location.getDouble("lng"));
            String location = lat+","+lng;
            
            //instruction
            String html_instruction = StringEscapeUtils.unescapeJava(step.getString("html_instructions"));
            String instruction = Jsoup.parse(html_instruction).text();
            
            //add map
            route.put(location,instruction);
            
            
            
            
            
        
            
        }
        
    }
}