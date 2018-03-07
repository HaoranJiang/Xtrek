/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;





/**
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class SatelliteModel {
    static double latitude;
    static double longitude;
    static char   dOLatitude;  // direction of latitude
    static char   dOLongitude;  // direction of longitude
    static boolean signal;
    static String time;
    
    public SatelliteModel(){
        latitude = 0;
        longitude= 0;
        dOLatitude= 'a';
        dOLongitude='a';
        signal = false;
        time = "";
        
        
    }
    
    
    public void updateSignal(boolean signal){
        SatelliteModel.signal = signal;
        System.out.println("Updated");
    }
    
    public void updateLatitude(double latitude, char direction) {      
        if (dOLatitude =='S'){
            this.latitude = (-1) * latitude;
        }else{
        this.latitude = latitude;
        }
        this.dOLatitude = direction;
 

    }
    
    public void updateLongitude(double longitude, char direction) { 
        if (dOLongitude =='W'){
            this.longitude = (-1) * longitude;
        }else{
            this.longitude = longitude;
        }
        this.dOLongitude = direction;
        
    }
    
    public void updateTime(String time){
        this.time = time;

    }
    
    public boolean getSignal(){return signal;}
    public double  getLatitude(){return latitude;}
    public double  getLongitude(){return longitude;}
    public char    getDOLatitude(){return dOLatitude;}
    public char    getDOLongitude(){return dOLongitude;}
    public String  getTime(){return time;}
    public String  getPosition(){
        String position = "" + latitude + longitude;
        return position;
    }

}
