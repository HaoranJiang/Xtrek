package MVC;

import static MVC.Model.getPosition;


import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit; 

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;



/*
 * Speech generation using Microsoft Cognitive Services.
 *
 *
 * @author Charles Roberts, 2018.
 *
 */
public class NewSoundAndSpeech {
  final static String KEY1 = "47e3817047634a4fb7935267bbb00069";
  final static String KEY2 = "e2d5cca5879e48f69a246b86a2aa43a9";
  
  static String Text;
  static String Lang;
  static String Gender;
  static String Artist;
  
  static String text;
  
  public static Thread read;
  
  static String token;
  static byte[] speech;
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";
  static final double NAUTICAL_MILE = 1.15077945;
  static final double MILE_TO_METER = 1609.344;
  static final int DEST_DISTANCE = 25;
  static final int ROUTE_DISTANCE = 25;
  
  // I have created my own route
  //static HashMap<String,String> my_route = new HashMap<String,String>();
  public static LinkedHashMap<String,String> my_route;
  
  // I have added custom key and value pairs to this route
  public static void addKeyValuePair() {
  
    // route.put("50.7269971,-3.5180801", "Turn right");
    // route.put("50.7269972,-3.5180801", "Turn right");
    // route.put("50.7269973,-3.5180801", "Turn right");
    // route.put("50.7269974,-3.5180801", "Turn right");
    // route.put("50.7269975,-3.5180801", "Turn right");
    // route.put("50.7269976,-3.5180801", "Turn right");
    my_route.put("50.7269977,-3.5180801", "Turn S on Sylvan Rd or left on Soopy Ln");
  }
  
  public static String alterText(String text) {
      // Search the directions String here for Rd or Ln
      String keyword1 = "Rd";
      String keyword2 = "Ln";
      String keyword3 = "W";
      String keyword4 = "N";
      String keyword5 = "E";
      String keyword6 = "S";
      /*
       * If the String contains "Rd" then this is changed to "Road" and
       * if the String contains "Ln" then this is changed to "Road".
       */
      Boolean foundOne = Arrays.asList(text.split(" ")).contains(keyword1);
      if(foundOne){
      String newKeyword1 = "Road";
        text = text.replaceAll("Rd", newKeyword1);
      }
      Boolean foundTwo = Arrays.asList(text.split(" ")).contains(keyword2);
      if (foundTwo) {
        String newKeyword2 = "Lane";
        text = text.replaceAll("Ln", newKeyword2);
      }
      Boolean foundThree = Arrays.asList(text.split(" ")).contains(keyword3);
      if(foundThree){
        String newKeyword3 = "West";
        text = text.replaceAll(" W ", newKeyword3);
      }

      Boolean foundFour = Arrays.asList(text.split(" ")).contains(keyword4);
      if(foundFour){
        String newKeyword4 = "North";
        text = text.replaceAll(" N ", newKeyword4);
      }

      Boolean foundFive = Arrays.asList(text.split(" ")).contains(keyword5);
      if(foundFive){
        String newKeyword5 = "East";
        text = text.replaceAll(" E ", newKeyword5);
      }

      Boolean foundSix = Arrays.asList(text.split(" ")).contains(keyword6);
      if(foundSix){
        String newKeyword6 = "South";
        text = text.replaceAll(" S ", newKeyword6);
      }
      return text;
  }
  
  // I have created my own currentLocation
  public static String currentLocation = Model.getPosition();
  
  // I have created my own destination 


  public static String destination = "50.726206,-3.516181";

  
  
  
  /*  
   * This function returns a list containing the lattitude and longitude
   * of the chosen place. 
   */
  public static List splitPlace(String place) {
      
      List<String> separate = new ArrayList<String>();
      
      String[] parts = place.split(",");
      String lattitude = parts[0]; 
      String longitude = parts[1]; 
  
      separate.add(lattitude);
      separate.add(longitude);
      
      return separate;
      
  }
  
  
  /*  
   * This function finds the distance between the currentLocation and the chosen
   * place.
   */
  public static double realDistance(String place) {
      
      List splitCurrentLocation = splitPlace(Model.getPosition());
      
      List splitPlace = splitPlace(place);
      
      String placeLattitude = splitPlace.get(0).toString();
              
      String placeLongitude = splitPlace.get(1).toString();
              
      String currentLattitude = splitCurrentLocation.get(0).toString();
              
      String currentLongitude = splitCurrentLocation.get(1).toString();
      
      double placeLattitudeValue = Double.parseDouble(placeLattitude);
      
      double placeLongitudeValue = Double.parseDouble(placeLongitude);
      
      double currentLattitudeValue = Double.parseDouble(currentLattitude);
      
      double currentLongitudeValue = Double.parseDouble(currentLongitude);
      
      return distance(placeLattitudeValue, placeLongitudeValue, currentLattitudeValue, currentLongitudeValue, 'M');
      
  }
  
  /*  
   * This function finds the distance between two points using their lattitude 
   * and longitude values in the unit that is chosen.
   * The return distance is multiplied by sin(90 - current latitude) to get the 
   * exact distance (see https://en.wikipedia.org/wiki/Decimal_degrees for more information).
   */
  public static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * NAUTICAL_MILE;
      if (unit == 'M') {
        dist = dist * MILE_TO_METER;
      }

      return (dist*Math.sin(deg2rad(90)-deg2rad(lat1)));   
  }

  // This function converts decimal degrees to radians             
  public static double deg2rad(double deg) {
    return (deg * Math.PI / 180.0);
  }
    
  // This function converts radians to decimal degrees             
  public static double rad2deg(double rad) {
    return (rad * 180.0 / Math.PI);
  }
  
  /*
   * Renew an access token --- they expire after 10 minutes.
   */
  static String renewAccessToken( String key1 ) {
    final String method = "POST";
    final String url = 
      "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
    final byte[] body = {}; 
    final String[][] headers
      = { { "Ocp-Apim-Subscription-Key", key1                          }
        , { "Content-Length"           , String.valueOf( body.length ) }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return new String( response ); 
  }
  
  /*
   * Synthesize English text to English Speech.
   */
  static byte[] generateEnglishSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format ) {
      
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    final byte[] body
      = ( "<speak version='1.0' xml:lang='en-GB'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
    final String[][] headers
      = { { "Content-Type"             , "application/ssml+xml"        }
        , { "Content-Length"           , String.valueOf( body.length ) }
        , { "Authorization"            , "Bearer " + token             }
        , { "X-Microsoft-OutputFormat" , format                        }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  } 
  
  /*
   * Synthesize French text to French Speech.
   */
  static byte[] generateFrenchSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format ) {
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    final byte[] body
      = ( "<speak version='1.0' xml:lang='fr-FR'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
    final String[][] headers
      = { { "Content-Type"             , "application/ssml+xml"        }
        , { "Content-Length"           , String.valueOf( body.length ) }
        , { "Authorization"            , "Bearer " + token             }
        , { "X-Microsoft-OutputFormat" , format                        }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  }     
  
  /*
   * Synthesize German text to German Speech.
   */
  static byte[] generateGermanSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format ) {
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    final byte[] body
      = ( "<speak version='1.0' xml:lang='de-DE'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
    final String[][] headers
      = { { "Content-Type"             , "application/ssml+xml"        }
        , { "Content-Length"           , String.valueOf( body.length ) }
        , { "Authorization"            , "Bearer " + token             }
        , { "X-Microsoft-OutputFormat" , format                        }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  }
  
  /*
   * Synthesize Italian text to Italian Speech.
   */
  static byte[] generateItalianSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format ) {
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    final byte[] body
      = ( "<speak version='1.0' xml:lang='it-IT'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
    final String[][] headers
      = { { "Content-Type"             , "application/ssml+xml"        }
        , { "Content-Length"           , String.valueOf( body.length ) }
        , { "Authorization"            , "Bearer " + token             }
        , { "X-Microsoft-OutputFormat" , format                        }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  }
  
  /*
   * Synthesize Spanish text to Spanish Speech.
   */
  static byte[] generateSpanishSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format ) {
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    final byte[] body
      = ( "<speak version='1.0' xml:lang='es-ES'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
    final String[][] headers
      = { { "Content-Type"             , "application/ssml+xml"        }
        , { "Content-Length"           , String.valueOf( body.length ) }
        , { "Authorization"            , "Bearer " + token             }
        , { "X-Microsoft-OutputFormat" , format                        }
        };
    byte[] response = HttpConnect.httpConnect( method, url, headers, body );
    return response;
  }

  /*
   * Write data to file.
   */
  static void writeData( byte[] buffer, String name ) {
    try {
      File             file = new File( name );
      FileOutputStream fos  = new FileOutputStream( file );
      DataOutputStream dos  = new DataOutputStream( fos ); 
      dos.write( buffer );
      dos.flush();
      dos.close();
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 ); return;
    }
  }
  
 /*
  * Sound generation.
  */
  private final static String FILENAME = "output.wav";

  /*
   * Set up stream. 
   */
  public static AudioInputStream setupStream( String name ) {
    try {
      File             file = new File( name );
      AudioInputStream stm  = AudioSystem.getAudioInputStream( file );
      return stm;
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 ); return null;
    }
  }

  /*
   * Read stream.
   */
  public static ByteArrayOutputStream readStream( AudioInputStream stm ) {
    try {
      AudioFormat           af  = stm.getFormat();
      ByteArrayOutputStream bos = new ByteArrayOutputStream();

      int  bufferSize = (int) af.getSampleRate() * af.getFrameSize();
      byte buffer[]   = new byte[ bufferSize ];

      for (;;) {
        int n = stm.read( buffer, 0, buffer.length );
        if ( n > 0 ) {
           bos.write( buffer, 0, n );
        } else {
          break;
        }
      }

      return bos;
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 ); return null;
    }
  }

  /*
   * Play stream.
   */
  public static void playStream( AudioInputStream stm, ByteArrayOutputStream bos ) {
    try {
      AudioFormat    af   = stm.getFormat();
      byte[]         ba   = bos.toByteArray();
      DataLine.Info  info = new DataLine.Info( SourceDataLine.class, af );
      SourceDataLine line = (SourceDataLine) AudioSystem.getLine( info );

      line.open( af );
      line.start();
      line.write( ba, 0, ba.length );
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 );
    }
  }
  
  /*
   * Changes what language that the text is read as. 
   */
  public static void changeLanguage(Language language){
	  switch(language){
		case ENGLISH:
			Lang   = "en-GB";
			Gender = "Male";
			Artist = "(en-GB, George, Apollo)";	
			break;
		  
		case FRENCH:
			Lang   = "fr-FR";
			Gender = "Female";
			Artist = "(fr-FR, HortenseRUS)";
			break;
			
		case GERMAN:
			Lang   = "de-DE";
			Gender = "Male";
			Artist = "(de-DE, Stefan, Apollo)";
			break;
			
		case ITALIAN:
			Lang   = "it-IT";
			Gender = "Male";
			Artist = "(it-IT, Cosimo, Apollo)";
			break;
			
		case SPANISH:
			Lang   = "es-ES";
			Gender = "Male";
			Artist = "(es-ES, Pablo, Apollo)";
			break;
		
		default:
            break;		
	  }
  }
  
  /*
   * Translates and speaks the text. 
   */
  public static void open(Language language) throws Exception {
    changeLanguage(language);
    token  = renewAccessToken( KEY1 );
    while(!Thread.currentThread().isInterrupted()){
    switch(language) {
		case ENGLISH:
                    speech = generateEnglishSpeech( token,  Text,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
		  
		case FRENCH:
                    
                    String frenchText;
                    Translator frenchTranslator = new Translator();
                    OutputCapturer.start();
                    frenchTranslator.translate("en", "fr", Text);
                    frenchText = OutputCapturer.stop();  
                    
                    speech = generateFrenchSpeech( token,  frenchText,   Lang
                                        , Gender, Artist, FORMAT );	
                    break;
			
		case GERMAN:
                    String germanText;
                    Translator germanTranslator = new Translator();
                    OutputCapturer.start();
                    germanTranslator.translate("en", "de", Text);
                    germanText = OutputCapturer.stop();  
                    
                    speech = generateGermanSpeech( token,  germanText,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
			
		case ITALIAN:
                    String italianText;
                    Translator italianTranslator = new Translator();
                    OutputCapturer.start();
                    italianTranslator.translate("en", "it", Text);
                    italianText = OutputCapturer.stop();  
                    
                    speech = generateItalianSpeech( token,  italianText,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
			
		case SPANISH:
                    String spanishText;
                    Translator spanishTranslator = new Translator();
                    OutputCapturer.start();
                    spanishTranslator.translate("en", "es", Text);
                    spanishText = OutputCapturer.stop();  
                    
                    speech = generateSpanishSpeech( token,  spanishText,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
		
		default:
                    break;
	  }
    writeData( speech, OUTPUT );
    AudioInputStream stm = setupStream( FILENAME );
    playStream( stm, readStream( stm ) );
  }
  }
  

  
  /*
   * Speaks the directions in the desird language. 
   */
  public static synchronized void directionsReader(Language language) throws Exception {
      read = new Thread(){
          @Override
          public void run(){
              while(!Thread.currentThread().isInterrupted()){
                try {
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      my_route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = my_route.get(key);
                              String text = String.valueOf(value);
                              text = alterText(text);
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = text;
                                      open(language);
                                      TimeUnit.SECONDS.sleep(10);
                                      
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                              
                              
                          }
                      });
                  }
                
                  // When the current location is within 25m of the destination.
                  Text = "You have reached your destination";
                  open(language);
                  
		 } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }}
      }
      };
     if (!read.isAlive()){
        read.start();
     }
  }
  
  /*
   * Generate sound.
   */
  public static void main( String[] argv ) throws Exception {

  }
} 

