package MVC;

import static MVC.Model.getLatitude;
import static MVC.Model.getLongitude;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.net.URL;
import static jdk.nashorn.internal.objects.NativeArray.map;

/*
 * Maps obtained using the Google Mapping Service.
 *
 * See https://developers.google.com/maps/documentation/static-maps/intro 
 *
 * zihan
 */
public class Maps {
  final static String OUTPUT    = "output.png";  /* Ouput file        */
  static String LATITUDE  = "50.7371";     /* Exeter, latitude  */
  static String LONGITUDE = "-3.5351";     /* Exeter, longitude */
  static String ZOOM      = "13";          /* 0 .. 21           */
  final static String SIZE      = "203x245";     /* Size              */
  final static String API_KEY = "AIzaSyDkH2-ZSQl09udvKzhG5i598K9RXrIehH4";
          
  static byte[] readData( String latitude
                        , String longitude
                        , String zoom
                        , String size
                        ) {
    final String method = "GET";
    final String url
      = ( "https://maps.googleapis.com/maps/api/staticmap"
        + "?" + "center" + "=" + latitude + "," + longitude
        + "&" + "zoom"   + "=" + zoom
        + "&" + "size"   + "=" + size +"&key="+API_KEY
        );
    final byte[] body
        = {};
    final String[][] headers
        = {};
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  }

  /*
   * zoom in and out 
   */
  
  static void zoomIn(){
      int value = Integer.parseInt(ZOOM) + 1;
      if (value < 22 ){
        ZOOM = "" + value;
      }
  }
  
  static void zoomOut(){
      int value = Integer.parseInt(ZOOM) - 1;
      if (value > -1){
          ZOOM = "" + value;
      }   
  }
  
  /*
  * Move the map
  */
  static void moveTo(){
      
      LONGITUDE = getLongitude();
      LATITUDE = getLatitude();
     
  }
  
  /*
  * Calculate the turning angle between locations
   */

  
  static double calculateAngle(double x1, double y1, double x2, double y2)
{
    double lat1 = Double.parseDouble(LATITUDE);
    double lon1 = Double.parseDouble(LONGITUDE);
    double radian = calculateAngle(lat1, lon1, 50.7260, -3.5332);
    x1 = deg2rad(x1);
    x2 = deg2rad(x2);
    y1 = deg2rad(y1);
    y2 = deg2rad(y2);
    double x = cos(x2)*sin(abs(y2 - y1));
    double y = cos(x1)*sin(x2) - sin(x1)*cos(x2)*cos(abs(y2 - y1));
    double angle = Math.toDegrees(Math.atan2(x, y)); 
    angle = 360 - angle;
    return angle;
    
}	

  public static double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
  }
  
  
  
  /*
   * Write map data.
   */
  
  static void writeData( String file, byte[] data ) {
    try {
      OutputStream os = new FileOutputStream( file );
      os.write( data, 0, data.length );
      os.close();
    } catch ( IOException ex ) {
      ex.printStackTrace(); System.exit( 1 );
    }
  }


  
  
  /*
   * Download map data.
   */
  public static void getMap() {
    final byte[] data = readData( LATITUDE, LONGITUDE, ZOOM, SIZE ); 
    writeData( OUTPUT, data );      
  }
}
