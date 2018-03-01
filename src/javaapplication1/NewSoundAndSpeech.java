package javaapplication1;

import javaapplication1.HttpConnect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javaapplication1.SoundAndSpeech;
import javaapplication1.Translator;
import javaapplication1.OutputCapturer;

/*
 * Speech generation using Microsoft Cognitive Services.
 */
public class NewSoundAndSpeech {
  final static String KEY1 = "5bfb30a4061e46afb5c4d832555dc8ae";
  final static String KEY2 = "091446841a3040408c7400aebbbca030";
  
  static String TEXT   = "Frankly, my dear, I don't give a damn!";
  static String LANG;
  static String GENDER;
  static String ARTIST;
  
  static String token;
  static byte[] speech;
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";

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
      = ( "<speak version='1.0' xml:lang='en-US'>"
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
  
  public static void open(int ss) throws Exception {
    changeLanguage(ss);
    token  = renewAccessToken( KEY1 );
    switch(ss) {
		case 1:
                    speech = generateEnglishSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );	
                    break;
		  
		case 2:
                    Translator frenchTranslator = new Translator();
                    OutputCapturer.start();
                    frenchTranslator.translate("en", "fr", TEXT);
                    TEXT = OutputCapturer.stop();  
                    
                    speech = generateFrenchSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );	
                    break;
			
		case 3:
                    Translator germanTranslator = new Translator();
                    OutputCapturer.start();
                    germanTranslator.translate("en", "de", TEXT);
                    TEXT = OutputCapturer.stop();  
                    speech = generateGermanSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
			
		case 4:
                    Translator italianTranslator = new Translator();
                    OutputCapturer.start();
                    italianTranslator.translate("en", "it", TEXT);
                    TEXT = OutputCapturer.stop();  
                    
                    speech = generateItalianSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
			
		case 5:
                    Translator spanishTranslator = new Translator();
                    OutputCapturer.start();
                    spanishTranslator.translate("en", "es", TEXT);
                    TEXT = OutputCapturer.stop();  
                    speech = generateSpanishSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );
                    break;
		
		default:
                    break;
	  }
    writeData( speech, OUTPUT );
    AudioInputStream stm = setupStream( FILENAME );
    playStream( stm, readStream( stm ) );
  }
  
    public static void newOpen(int ss) throws Exception {
        switch(ss) {
            case 1:
                        open(1);
                        break;
                    case 2:
                        open(2);
                        break;
                    case 3:
                        open(3);
                        break;
                    case 4:
                        open(4);
                        break;
                    case 5:
                        open(5);
                        break;
                        
        }
    }
  
   /*
   * Generate sound.
   */
  public static void main( String[] argv ) throws Exception {
	open(2);
      
  }
} 