/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;


import java.util.Observable;



/**
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class SatelliteModel extends Observable {
    static double latitude;
    static double longitude;
    static char   dOLatitude;  // direction of latitude
    static char   dOLongitude;  // direction of longitude
    static boolean signal;
    static String time;
    
    public SatelliteModel(){
             
    }
    
    
    public void updateSignal(boolean signal){
        SatelliteModel.signal = signal;
        setChanged();
        notifyObservers();
    }
    
    public void updateLatitude(double latitude, char direction) {
        SatelliteModel.latitude = latitude;
        SatelliteModel.dOLatitude = direction;
        if (dOLatitude =='S') 
            latitude = (-1) * latitude;
        setChanged();
        notifyObservers( latitude );
        notifyObservers( dOLatitude );
    }
    public void updateLongitude(double longitude, char direction) {
        SatelliteModel.longitude = longitude;
        SatelliteModel.dOLongitude = direction;
        if (dOLongitude =='W') 
            longitude = (-1) * longitude;
        setChanged();
        notifyObservers( longitude );
        notifyObservers( dOLongitude );
    }
    public void updateTime(String time){
        SatelliteModel.time = time;
        setChanged();
        notifyObservers( time );
    }

}
