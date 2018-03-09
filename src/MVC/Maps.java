package MVC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
  final static String SIZE      = "300x300";     /* Size              */
 

          
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
        + "&" + "size"   + "=" + size
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
