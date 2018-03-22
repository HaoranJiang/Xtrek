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
  // API keys for the Microsoft Cognitive Services API
  final static String KEY1 = "a89f18480dcb445badddd290b4a2a168";
  final static String KEY2 = "e0cddeeff74d40b9a03e8f7acc20b02b";
  
  static String Text;
  static String Lang;
  static String Gender;
  static String Artist;
  
  static String text;
  
  public static Thread read;
  
  public static String token;
  static byte[] speech;
  
  // Audio files for each language selection in Speech Mode.
  public static final String ENGLISH = "src/Sounds/English.wav";        // location of the pre-recorded file
  public static final String FRENCH = "src/Sounds/French.wav";
  public static final String GERMAN = "src/Sounds/German.wav";
  public static final String ITALIAN = "src/Sounds/Italian.wav";
  public static final String SPANISH = "src/Sounds/Spanish.wav";
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";
  
  static final double NAUTICAL_MILE = 1.15077945;
  static final double MILE_TO_METER = 1609.344;
  
  // Distance to the destination when the directions are spoken.
  static final int DEST_DISTANCE = 25;
  // Distance to a route lcation point when the directions are spoken.
  static final int ROUTE_DISTANCE = 10;
  
   static byte[] body;
  
  public static LinkedHashMap<String,String> my_route;
  
  /*
   * This method searches through the directions and chnages certain phrses to 
   * ones that are more comprehendable. 
   */
  
  public static String alterText(String text) {
      // Search the directions String here for Rd or Ln
      String keyword1 = "Rd";
      String keyword2 = "Ln";
      String keyword3 = "W";
      String keyword4 = "N";
      String keyword5 = "E";
      String keyword6 = "S";
      
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
  
  
  public static String currentLocation = Model.getPosition();
  
  public static String destination;

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
  static byte[] generateSpeech( String token,  String text
                              , String lang,   String gender
                              , String artist, String format, Language language ) {
      
    final String method = "POST";
    final String url = "https://speech.platform.bing.com/synthesize";
    
    switch (language) {
 
        case ENGLISH:
            body
      = ( "<speak version='1.0' xml:lang='en-GB'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
        break;
        case FRENCH:
            body
      = ( "<speak version='1.0' xml:lang='fr-FR'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
        break;
        case GERMAN:
            body
      = ( "<speak version='1.0' xml:lang='de-DE'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
        break;
        case ITALIAN:
            body
      = ( "<speak version='1.0' xml:lang='it-IT'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
        break;
        case SPANISH:
            body
      = ( "<speak version='1.0' xml:lang='es-ES'>"
        + "<voice xml:lang='" + lang   + "' "
        + "xml:gender='"      + gender + "' "
        + "name='Microsoft Server Speech Text to Speech Voice "
        + artist + "'>"
        + text
        + "</voice></speak>" ).getBytes(); 
        break;
        default:
    break;
            
    }
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
      System.out.println( ex ); return;
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
      System.out.println( ex ); return null;
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
      System.out.println( ex ); return null;
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
      System.out.println( ex ); 
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
   * Plays a pe-recorded audi file.
   */
  public static void generateLanguage(String filename){
        Thread reading = new Thread(){
           @Override
           public void run(){
               AudioInputStream stm = setupStream( filename );
               playStream( stm, readStream( stm ) );
           }
        };
        reading.start();
        
    }
    
    /*
     * This function ensures that the renewAccessToken() method is called
     * every nine minutes. 
     */
    public static void task(){
     TimerTask task = new TimerTask(){
          @Override
          public void run(){
                  token = renewAccessToken(KEY1);
      }
      };
      Timer timer = new Timer();
      timer.schedule(task,new Date(),540000);
              
    }
  /*
   * Translates and speaks the text. 
   */
  public static void open(Language language) throws Exception {
    changeLanguage(language);
    switch(language) {
		case ENGLISH:
                    speech = generateSpeech( token,  Text,   Lang
                                        , Gender, Artist, FORMAT,Language.ENGLISH);
                    break;
		  
		case FRENCH:
                    
                    String frenchText;
                    Translator frenchTranslator = new Translator();
                    OutputCapturer.start();
                    frenchTranslator.translate("en", "fr", Text);
                    frenchText = OutputCapturer.stop();  
                    
                    speech = generateSpeech( token,  frenchText,   Lang
                                        , Gender, Artist, FORMAT,Language.FRENCH );	
                    break;
			
		case GERMAN:
                    String germanText;
                    Translator germanTranslator = new Translator();
                    OutputCapturer.start();
                    germanTranslator.translate("en", "de", Text);
                    germanText = OutputCapturer.stop();  
                    
                    speech = generateSpeech( token,  germanText,   Lang
                                        , Gender, Artist, FORMAT,Language.GERMAN );
                    break;
			
		case ITALIAN:
                    String italianText;
                    Translator italianTranslator = new Translator();
                    OutputCapturer.start();
                    italianTranslator.translate("en", "it", Text);
                    italianText = OutputCapturer.stop();  
                    
                    speech = generateSpeech( token,  italianText,   Lang
                                        , Gender, Artist, FORMAT,Language.ITALIAN );
                    break;
			
		case SPANISH:
                    String spanishText;
                    Translator spanishTranslator = new Translator();
                    OutputCapturer.start();
                    spanishTranslator.translate("en", "es", Text);
                    spanishText = OutputCapturer.stop();  
                    
                    speech = generateSpeech( token,  spanishText,   Lang
                                        , Gender, Artist, FORMAT,Language.SPANISH );
                    break;
		
		default:
                    break;
	  }
    writeData( speech, OUTPUT );
    AudioInputStream stm = setupStream( FILENAME );
    playStream( stm, readStream( stm ) );
  
  }
  

  
  /*
   * Speaks the directions in the desird language during the route.  
   */
  public static synchronized void directionsReader(Language language) throws Exception {
      System.out.println(destination);
        read = new Thread(){
          @Override
          public void run(){
              while(!Thread.currentThread().isInterrupted()){
                try {
                    //System.out.println(destination);
                    while (realDistance(destination) > DEST_DISTANCE) {
                      //String currentLocation = getPosition();
                      my_route.keySet().forEach(new Consumer<String>() {
                          @Override
                          public void accept(String key) {
                              String value = my_route.get(key);
                              String text = String.valueOf(value);
                              text = alterText(text);
                              
                              /* If the distance to a route point is less than or
                              * equal to 25m then the corresponding directions are spoken.
                              */
                              if (realDistance(key) <= ROUTE_DISTANCE) {
                                  try {
                                      Text = text;
                                      open(language);
                                      my_route.remove(key);                         
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
                  read.interrupt();
                  
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

