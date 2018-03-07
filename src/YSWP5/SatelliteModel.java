
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
