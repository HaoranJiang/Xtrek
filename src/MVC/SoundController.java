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
public class SoundController {
  final static String KEY1 = "47e3817047634a4fb7935267bbb00069";
  final static String KEY2 = "e2d5cca5879e48f69a246b86a2aa43a9";
  
  static String Text;
  static String Lang;
  static String Gender;
  static String Artist;
  
  static String token;
  static byte[] speech;
  
  static Thread readEnglish;
  static Thread readFrench;
  static Thread readGerman;
  static Thread readItalian;
  static Thread readSpanish;
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";
  static final double NAUTICAL_MILE = 1.15077945;
  static final double MILE_TO_METER = 1609.344;
  static final int DEST_DISTANCE = 5;
  static final int ROUTE_DISTANCE = 5;
  
  // I have created my own route
  static HashMap<String,String> route = new HashMap<String,String>();
  
  
  // I have added custom key and value pairs to this route
  public static void addKeyValuePair() {
  
    // route.put("50.7269971,-3.5180801", "Turn right");
    //route.put("50.7269972,-3.5180801", "Turn right");
    //route.put("50.7269973,-3.5180801", "Turn right");
    //route.put("50.7269974,-3.5180801", "Turn right");
    //route.put("50.7269975,-3.5180801", "Turn right");
    //route.put("50.7269976,-3.5180801", "Turn right");
    route.put("50.7269977,-3.5180801", "Turn right on Sylvan Rd or left on Loopy Ln");
  }
  
  public static void alterText(String text) {
      
  }
  
  // I have created my own currentLocation
  public static String currentLocation = "50.7269977,-3.5180801";
  
  // I have created my own destination 
  public static String destination = "50.1269977,-3.1180801";
  
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
      //String currentLocation = Model.getPosition();
      List splitCurrentLocation = splitPlace(currentLocation);
      
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
  static AudioInputStream setupStream( String name ) {
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
  static ByteArrayOutputStream readStream( AudioInputStream stm ) {
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
  static void playStream( AudioInputStream stm, ByteArrayOutputStream bos ) {
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
  public static void changeLanguage( int s ){
	  switch(s){
		case 1:
			Lang   = "en-GB";
			Gender = "Male";
			Artist = "(en-GB, George, Apollo)";	
			break;
		  
		case 2:
			Lang   = "fr-FR";
			Gender = "Female";
			Artist = "(fr-FR, HortenseRUS)";
			break;
			
		case 3:
			Lang   = "de-DE";
			Gender = "Male";
			Artist = "(de-DE, Stefan, Apollo)";
			break;
			
		case 4:
			Lang   = "it-IT";
			Gender = "Male";
			Artist = "(it-IT, Cosimo, Apollo)";
			break;
			
		case 5:
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
  public static void open(int ss) throws Exception {
    changeLanguage(ss);
    token  = renewAccessToken( KEY1 );
    switch(ss) {
		case 1:
                    speech = generateEnglishSpeech( token,  Text,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
		  
		case 2:
                    
                    String frenchText;
                    Translator frenchTranslator = new Translator();
                    OutputCapturer.start();
                    frenchTranslator.translate("en", "fr", Text);
                    frenchText = OutputCapturer.stop();  
                    
                    speech = generateFrenchSpeech( token,  frenchText,   Lang
                                        , Gender, Artist, FORMAT );	
                    break;
			
		case 3:
                    String germanText;
                    Translator germanTranslator = new Translator();
                    OutputCapturer.start();
                    germanTranslator.translate("en", "de", Text);
                    germanText = OutputCapturer.stop();  
                    
                    speech = generateGermanSpeech( token,  germanText,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
			
		case 4:
                    String italianText;
                    Translator italianTranslator = new Translator();
                    OutputCapturer.start();
                    italianTranslator.translate("en", "it", Text);
                    italianText = OutputCapturer.stop();  
                    
                    speech = generateItalianSpeech( token,  italianText,   Lang
                                        , Gender, Artist, FORMAT );
                    break;
			
		case 5:
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
  
  /*
   * Speaks the directions in English.
   */
  public static void englishDirectionsReader() throws Exception {
       
      //stopAll();
      readEnglish = new Thread(){
          @Override
          public void run(){
              
                try{
                  
                    
                  
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = route.get(key);
                              String englishText = String.valueOf(value);
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
                              Boolean foundOne = Arrays.asList(englishText.split(" ")).contains(keyword1);
                              if(foundOne){
                                  String newKeyword1 = "Road";
                                  englishText = englishText.replaceAll("Rd", newKeyword1);
                              }
                              Boolean foundTwo = Arrays.asList(englishText.split(" ")).contains(keyword2);
                              if (foundTwo) {
                                  String newKeyword2 = "Lane";
                                  englishText = englishText.replaceAll("Ln", newKeyword2);
                              }
                              Boolean foundThree = Arrays.asList(englishText.split(" ")).contains(keyword3);
                              if(foundThree){
                                  String newKeyword3 = "West";
                                  englishText = englishText.replaceAll(" W ", newKeyword3);
                              }

                              Boolean foundFour = Arrays.asList(englishText.split(" ")).contains(keyword4);
                              if(foundFour){
                                  String newKeyword4 = "North";
                                  englishText = englishText.replaceAll(" N ", newKeyword4);
                              }

                              Boolean foundFive = Arrays.asList(englishText.split(" ")).contains(keyword5);
                              if(foundFive){
                                  String newKeyword5 = "East";
                                  englishText = englishText.replaceAll(" E ", newKeyword5);
                              }

                              Boolean foundSix = Arrays.asList(englishText.split(" ")).contains(keyword6);
                              if(foundSix){
                                  String newKeyword6 = "South";
                                  englishText = englishText.replaceAll(" S ", newKeyword6);
                              }
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = englishText;
                                      open(1);
                                      TimeUnit.SECONDS.sleep(5);
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                          }
                      });
                  }
                  // When the current location is within 5m of the destination.
                  Text = "You have reached your destination";
                  open(1);
			  } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }
      }
      };
      
        // stopAll();
        
        readEnglish.start();
      //readEnglish.notify();
      
  }
  private static void stopAll(){
        try{
          readSpanish.wait();
          readGerman.wait();
          readFrench.wait();
          readEnglish.wait();
          readItalian.wait();
      }catch(Exception e){}
  }
  
  /*
   * Speaks the directions in English.
   */
  public static void frenchDirectionsReader() throws Exception {
       
      readFrench = new Thread(){
          @Override
          public void run(){
              try {
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = route.get(key);
                              String frenchText = String.valueOf(value);
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
                              Boolean foundOne = Arrays.asList(frenchText.split(" ")).contains(keyword1);
                              if(foundOne){
                                  String newKeyword1 = "Road";
                                  frenchText = frenchText.replaceAll("Rd", newKeyword1);
                              }
                              Boolean foundTwo = Arrays.asList(frenchText.split(" ")).contains(keyword2);
                              if (foundTwo) {
                                  String newKeyword2 = "Lane";
                                  frenchText = frenchText.replaceAll("Ln", newKeyword2);
                              }
                              Boolean foundThree = Arrays.asList(frenchText.split(" ")).contains(keyword3);
                              if(foundThree){
                                  String newKeyword3 = "West";
                                  frenchText = frenchText.replaceAll(" W ", newKeyword3);
                              }

                              Boolean foundFour = Arrays.asList(frenchText.split(" ")).contains(keyword4);
                              if(foundFour){
                                  String newKeyword4 = "North";
                                  frenchText = frenchText.replaceAll(" N ", newKeyword4);
                              }

                              Boolean foundFive = Arrays.asList(frenchText.split(" ")).contains(keyword5);
                              if(foundFive){
                                  String newKeyword5 = "East";
                                  frenchText = frenchText.replaceAll(" E ", newKeyword5);
                              }

                              Boolean foundSix = Arrays.asList(frenchText.split(" ")).contains(keyword6);
                              if(foundSix){
                                  String newKeyword6 = "South";
                                  frenchText = frenchText.replaceAll(" S ", newKeyword6);
                              }
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = frenchText;
                                      open(2);
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                          }
                      });
                  }
                  // When the current location is within 5m of the destination.
                  Text = "You have reached your destination";
                  open(2);
			  } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }
      }
      };
      
        stopAll();
        
        readFrench.start();
      //readFrench.notify();
      
  }
  
  
  /*
   * Speaks the directions in English.
   */
  public static void germanDirectionsReader() throws Exception {
       
      readGerman = new Thread(){
          @Override
          public void run(){
              try {
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = route.get(key);
                              String germanText = String.valueOf(value);
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
                              Boolean foundOne = Arrays.asList(germanText.split(" ")).contains(keyword1);
                              if(foundOne){
                                  String newKeyword1 = "Road";
                                  germanText = germanText.replaceAll("Rd", newKeyword1);
                              }
                              Boolean foundTwo = Arrays.asList(germanText.split(" ")).contains(keyword2);
                              if (foundTwo) {
                                  String newKeyword2 = "Lane";
                                  germanText = germanText.replaceAll("Ln", newKeyword2);
                              }
                              
                              Boolean foundThree = Arrays.asList(germanText.split(" ")).contains(keyword3);
                              if(foundThree){
                                String newKeyword3 = "West";
                                germanText = germanText.replaceAll(" W ", newKeyword3);
                              }
              
                              Boolean foundFour = Arrays.asList(germanText.split(" ")).contains(keyword4);
                              if(foundFour){
                                String newKeyword4 = "North";
                                germanText = germanText.replaceAll(" N ", newKeyword4);
                              }
              
                              Boolean foundFive = Arrays.asList(germanText.split(" ")).contains(keyword5);
                              if(foundFive){
                                String newKeyword5 = "East";
                                germanText = germanText.replaceAll(" E ", newKeyword5);
                              }
              
                              Boolean foundSix = Arrays.asList(germanText.split(" ")).contains(keyword6);
                              if(foundSix){
                                String newKeyword6 = "South";
                                germanText = germanText.replaceAll(" S ", newKeyword6);
                              }
                              
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = germanText;
                                      open(3);
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                          }
                      });
                  }
                  // When the current location is within 5m of the destination.
                  Text = "You have reached your destination";
                  open(3);
			  } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }
      }
      };
      
        stopAll();
        
        readGerman.start();
      //readGerman.notify();
      
  }
  
  
  /*
   * Speaks the directions in English.
   */
  public static void ItalianDirectionsReader() throws Exception {
       
      readItalian = new Thread(){
          @Override
          public void run(){
              try {
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = route.get(key);
                              String italianText = String.valueOf(value);
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
                              Boolean foundOne = Arrays.asList(italianText.split(" ")).contains(keyword1);
                              if(foundOne){
                                  String newKeyword1 = "Road";
                                  italianText = italianText.replaceAll("Rd", newKeyword1);
                              }
                              Boolean foundTwo = Arrays.asList(italianText.split(" ")).contains(keyword2);
                              if (foundTwo) {
                                  String newKeyword2 = "Lane";
                                  italianText = italianText.replaceAll("Ln", newKeyword2);
                              }
                              
                              Boolean foundThree = Arrays.asList(italianText.split(" ")).contains(keyword3);
                              if(foundThree){
                                  String newKeyword3 = "West";
                                  italianText = italianText.replaceAll(" W ", newKeyword3);
                              }

                              Boolean foundFour = Arrays.asList(italianText.split(" ")).contains(keyword4);
                              if(foundFour){
                                  String newKeyword4 = "North";
                                  italianText = italianText.replaceAll(" N ", newKeyword4);
                              }

                              Boolean foundFive = Arrays.asList(italianText.split(" ")).contains(keyword5);
                              if(foundFive){
                                  String newKeyword5 = "East";
                                  italianText = italianText.replaceAll(" E ", newKeyword5);
                              }

                              Boolean foundSix = Arrays.asList(italianText.split(" ")).contains(keyword6);
                              if(foundSix){
                                  String newKeyword6 = "South";
                                  italianText = italianText.replaceAll(" S ", newKeyword6);
                              }
                              
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = italianText;
                                      open(4);
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                          }
                      });
                  }
                  // When the current location is within 5m of the destination.
                  Text = "You have reached your destination";
                  open(4);
			  } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }
      }
      };
      
        stopAll();
        
        readItalian.start();
      //readItalian.notify();
      
  }
  
  
  /*
   * Speaks the directions in English.
   */
  public static void spanishDirectionsReader() throws Exception {
      
      stopAll();
      readSpanish = new Thread(){
          @Override
          public void run(){
              try {
                  while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = route.get(key);
                              String spanishText = String.valueOf(value);
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
                              Boolean foundOne = Arrays.asList(spanishText.split(" ")).contains(keyword1);
                              if(foundOne){
                                  String newKeyword1 = "Road";
                                  spanishText = spanishText.replaceAll("Rd", newKeyword1);
                              }
                              Boolean foundTwo = Arrays.asList(spanishText.split(" ")).contains(keyword2);
                              if (foundTwo) {
                                  String newKeyword2 = "Lane";
                                  spanishText = spanishText.replaceAll("Ln", newKeyword2);
                              }
                              Boolean foundThree = Arrays.asList(spanishText.split(" ")).contains(keyword3);
                              if(foundThree){
                                  String newKeyword3 = "West";
                                  spanishText = spanishText.replaceAll(" W ", newKeyword3);
                              }

                              Boolean foundFour = Arrays.asList(spanishText.split(" ")).contains(keyword4);
                              if(foundFour){
                                  String newKeyword4 = "North";
                                  spanishText = spanishText.replaceAll(" N ", newKeyword4);
                              }

                              Boolean foundFive = Arrays.asList(spanishText.split(" ")).contains(keyword5);
                              if(foundFive){
                                  String newKeyword5 = "East";
                                  spanishText = spanishText.replaceAll(" E ", newKeyword5);
                              }

                              Boolean foundSix = Arrays.asList(spanishText.split(" ")).contains(keyword6);
                              if(foundSix){
                                  String newKeyword6 = "South";
                                  spanishText = spanishText.replaceAll(" S ", newKeyword6);
                              }
                              /* If the distance to a route point is less than or
                              * equal to 10m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = spanishText;
                                      open(5);
                                      TimeUnit.SECONDS.sleep(5);
                                  } catch (Exception ex) {
                                      Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
                                  }
                              }
                          }
                      });
                  }
                  // When the current location is within 5m of the destination.
                  Text = "You have reached your destination";
                  open(5);
			  } catch (Exception ex) {
                  Logger.getLogger(NewSoundAndSpeech.class.getName()).log(Level.SEVERE, null, ex);
              }
      }
      };
      
        //stopAll();
        
        readSpanish.start();
      //readEnglish.notify();
      
  }
  
  /*
   * Generate sound.
   */
  public static void main( String[] argv ) throws Exception {
      
      addKeyValuePair(); 
      englishDirectionsReader();
      //spanishDirectionsReader();
      synchronized(readEnglish){
        readEnglish.notify();
      }
      
    
  }
} 

