/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import MVC.HttpConnect;
import static MVC.NewSoundAndSpeech.generateEnglishSpeech;
import static MVC.NewSoundAndSpeech.playStream;
import static MVC.NewSoundAndSpeech.readStream;
import static MVC.NewSoundAndSpeech.renewAccessToken;
import static MVC.NewSoundAndSpeech.setupStream;
import static MVC.NewSoundAndSpeech.writeData;
import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import static javax.script.ScriptEngine.FILENAME;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;


/**
 *
 * @author zhuhongbo
 */
public class SpeechMenu {
  final static String KEY1 = "47e3817047634a4fb7935267bbb00069";
  final static String KEY2 = "e2d5cca5879e48f69a246b86a2aa43a9";
  
  static String TEXT   = "Select";
  static String LANG = "en-GB";
  static String GENDER = "Male";
  static String ARTIST= "(en-GB, George, Apollo)";
  
  static String token;
  static byte[] speech;
  
  final static String OUTPUT = "output.wav";
  final static String FORMAT = "riff-16khz-16bit-mono-pcm";

  private final static String FILENAME = "output.wav";
  
  public static void changeText( Menu menu ){
	  switch(menu){
		case ONE:
                    TEXT = "Where to mode";
			break;
		  
		case TWO:
                    TEXT = "Trip computer mode";
			break;
			
		case THREE:
                    TEXT = "Map mode";
			break;
			
		case FOUR:
                    TEXT = "Speech mode";
			break;
			
		case FIVE:
                    TEXT = "Satellite mode";
			break;
                
                case SIX:
                    TEXT = "About mode";
			break;        
		
		default:
            break;		
	  }
  }
  
  public static void openSpeech(Menu menu) throws Exception {
    
    changeText(menu);
      
    token  = renewAccessToken( KEY1 );
    
    speech = generateEnglishSpeech( token,  TEXT,   LANG
                                        , GENDER, ARTIST, FORMAT );	

    writeData( speech, OUTPUT );
    AudioInputStream stm = setupStream( FILENAME );
    playStream( stm, readStream( stm ) );
  }
  
   /*
   * Generate sound.
   */
  public static void main( String[] argv ) throws Exception {
        openSpeech(Menu.ONE);
	openSpeech(Menu.TWO);
        openSpeech(Menu.THREE);
	openSpeech(Menu.FOUR);
        openSpeech(Menu.FIVE);
	openSpeech(Menu.SIX);
  }

} 

