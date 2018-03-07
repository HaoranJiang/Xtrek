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
    private double latitude;
    private double longitude;
    private char   dOLatitude;  // direction of latitude
    private char   dOLongitude;  // direction of longitude
    private boolean signal;
    private String time;
    
    public SatelliteModel(){
             
    }
    
    
    public void updateSignal(boolean signal){
        this.signal = signal;
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
