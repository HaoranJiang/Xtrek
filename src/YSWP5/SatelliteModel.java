/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YSWP5;





/**
 * @MVC - model. Stores latitude/longitude/direction, updated by controller.
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

    public String  getPosition(){
        String position = "" + latitude + longitude;
        return position;
    }

}
