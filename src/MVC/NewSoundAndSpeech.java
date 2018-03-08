package MVC;

import static MVC.Model.getPosition;
import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit; 

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
  final static String KEY1 = "5bfb30a4061e46afb5c4d832555dc8ae";
  final static String KEY2 = "091446841a3040408c7400aebbbca030";
  
  static String TEXT;
  static String LANG;
  static String GENDER;
  static String ARTIST;
  
  static String token;
  static byte[] speech;
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";
  
  // I have created my own route
  static HashMap<String,String> route = new HashMap<String,String>();
  
  
  // I have added custom key and value pairs to this route
  public static void addKeyValuePair() {
  
    route.put("50.7269971,-3.5180801", "Turn right");
    route.put("50.7269972,-3.5180801", "Turn right");
    route.put("50.7269973,-3.5180801", "Turn right");
    route.put("50.7269974,-3.5180801", "Turn right");
    route.put("50.7269975,-3.5180801", "Turn right");
    route.put("50.7269976,-3.5180801", "Turn right");
    route.put("50.7269977,-3.5180801", "Turn right");
  }
  
  /* I have created a variable called currentLocation to hold a fake current 
  location.
  */
 

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
			LANG   = "en-GB";
			GENDER = "Male";
			ARTIST = "(en-GB, George, Apollo)";	
			break;
		  
		case 2:
			LANG   = "fr-FR";
			GENDER = "Female";
			ARTIST = "(fr-FR, HortenseRUS)";
			break;
			
		case 3:
			LANG   = "de-DE";
			GENDER = "Male";
			ARTIST = "(de-DE, Stefan, Apollo)";
			break;
			
		case 4:
			LANG   = "it-IT";
			GENDER = "Male";
			ARTIST = "(it-IT, Cosimo, Apollo)";
			break;
			
		case 5:
			LANG   = "es-ES";
			GENDER = "Male";
			ARTIST = "(es-ES, Pablo, Apollo)";
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
                    speech = generateEnglishSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
		  
		case 2:
                    
                    String frenchText;
                    Translator frenchTranslator = new Translator();
                    OutputCapturer.start();
                    frenchTranslator.translate("en", "fr", TEXT);
                    frenchText = OutputCapturer.stop();  
                    
                    speech = generateFrenchSpeech( token,  frenchText,   LANG
                                        , GENDER, ARTIST, FORMAT );	
                    break;
			
		case 3:
                    String germanText;
                    Translator germanTranslator = new Translator();
                    OutputCapturer.start();
                    germanTranslator.translate("en", "de", TEXT);
                    germanText = OutputCapturer.stop();  
                    
                    speech = generateGermanSpeech( token,  germanText,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
			
		case 4:
                    String italianText;
                    Translator italianTranslator = new Translator();
                    OutputCapturer.start();
                    italianTranslator.translate("en", "it", TEXT);
                    italianText = OutputCapturer.stop();  
                    
                    speech = generateItalianSpeech( token,  italianText,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
			
		case 5:
                    String spanishText;
                    Translator spanishTranslator = new Translator();
                    OutputCapturer.start();
                    spanishTranslator.translate("en", "es", TEXT);
                    spanishText = OutputCapturer.stop();  
                    
                    speech = generateSpanishSpeech( token,  spanishText,   LANG
                                        , GENDER, ARTIST, FORMAT );
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
   * Waits 30 seconds before repeating the command. 
   */
  public static void englishDirectionsReader() throws Exception {
      while (true) {
          String currentLocation = getPosition();
          for (String key : route.keySet()) {
              String value = route.get(key);
              String englishText = String.valueOf(value);
              if (currentLocation.equals(key)) {
                  TEXT = englishText;
                  open(1);
                  TimeUnit.SECONDS.sleep(30);
              }
          }
      }
  }
  
  /*
   * Speaks the directions in French.
   * Waits 30 seconds before repeating the command. 
   */
  public static void frenchDirectionsReader() throws Exception {
      while (true) {
          String currentLocation = getPosition();
          for (String key : route.keySet()) {
              String value = route.get(key);
              String englishText = String.valueOf(value);
              if (currentLocation.equals(key)) {
                  TEXT = englishText;
                  open(2);
                  TimeUnit.SECONDS.sleep(30);
              }
          }
      }
  }
  
  /*
   * Speaks the directions in German.
   * Waits 30 seconds before repeating the command.
   */
  public static void germanDirectionsReader() throws Exception {
      while (true) {
          String currentLocation = getPosition();
          for (String key : route.keySet()) {
              String value = route.get(key);
              String englishText = String.valueOf(value);
              if (currentLocation.equals(key)) {
                  TEXT = englishText;
                  open(3);
                  TimeUnit.SECONDS.sleep(30);
              }
          }
      }
  }
  
  /*
   * Speaks the directions in Italian.
   * Waits 30 seconds before repeating the command.
   */
  public static void italianDirectionsReader() throws Exception {
      while (true) {
          String currentLocation = getPosition();
          for (String key : route.keySet()) {
              String value = route.get(key);
              String englishText = String.valueOf(value);
              if (currentLocation.equals(key)) {
                  TEXT = englishText;
                  open(4);
                  TimeUnit.SECONDS.sleep(30);
              }
          }
      }
  }
  
  /*
   * Speaks the directions in Spanish.
   * Waits 30 seconds before repeating the command.
   */
  public static void spanishDirectionsReader() throws Exception {
      while (true) {
          String currentLocation = getPosition();
          for (String key : route.keySet()) {
              String value = route.get(key);
              String englishText = String.valueOf(value);
              if (currentLocation.equals(key)) {
                  TEXT = englishText;
                  open(5);
                  TimeUnit.SECONDS.sleep(30);
              }
          }
      }
  }
  
  /*
   * Generate sound.
   */
  public static void main( String[] argv ) throws Exception {
      addKeyValuePair();
      spanishDirectionsReader();
  }
} 