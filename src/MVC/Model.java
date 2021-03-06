package MVC;



import static MVC.Maps.getMap;
import static MVC.Maps.moveTo;
import static MVC.Maps.zoomIn;
import static MVC.Maps.zoomOut;
import static MVC.ModelViewController.SatController;
import static MVC.NewSoundAndSpeech.FORMAT;
import static MVC.NewSoundAndSpeech.KEY1;

import static MVC.NewSoundAndSpeech.changeLanguage;
import static MVC.NewSoundAndSpeech.distance;
import static MVC.NewSoundAndSpeech.generateLanguage;
import static MVC.NewSoundAndSpeech.playStream;
import static MVC.NewSoundAndSpeech.splitPlace;
import static MVC.SpeechPanel.smenu1;
import static MVC.SpeechPanel.smenu2;
import static MVC.SpeechPanel.smenu3;
import static MVC.SpeechPanel.smenu4;
import static MVC.SpeechPanel.smenu5;
import static MVC.SpeechPanel.smenu6;
import static MVC.SpeechPanel.speP;
import static MVC.View.TSPanel;
import static MVC.View.aboutPanel;
import static MVC.View.mapImage;
import static MVC.View.mapPanel;
import static MVC.View.menu1Panel;
import static MVC.View.menu2Panel;
import static MVC.View.menu3Panel;
import static MVC.View.menu4Panel;
import static MVC.View.menu5Panel;
import static MVC.View.menu6Panel;
import static MVC.View.screenPanel;
import static MVC.View.speechPanel;

import static MVC.View.tripComputerPanel;
import static MVC.View.whereToPanel;
import java.io.File;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static MVC.NewSoundAndSpeech.read;
import static MVC.NewSoundAndSpeech.readStream;
import static MVC.NewSoundAndSpeech.renewAccessToken;
import static MVC.NewSoundAndSpeech.setupStream;
import static MVC.NewSoundAndSpeech.token;


import java.io.IOException;



//
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.*;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;


/**
 *
 * Model.
 * 
 * @author Haoran Jiang 2018.
 */




enum Menu {ONE, TWO, THREE, FOUR, FIVE, SIX};
enum Situation {OFF, MENU, WHERETO, TRIPCOMPUTER, MAP, SPEECH, SATELLITE, ABOUTME};
enum Keys{KEY_A,KEY_B,KEY_C,KEY_D,KEY_E,KEY_F,KEY_G,KEY_H,KEY_I,KEY_J,KEY_K,KEY_L,KEY_M,KEY_N,KEY_O,
         KEY_P,KEY_Q,KEY_R,KEY_S,KEY_T,KEY_U,KEY_V,KEY_W,KEY_X,KEY_Y,KEY_Z,KEY_SPACE,KEY_NEXT,
         KEY_ONE,KEY_TWO,KEY_THREE,KEY_FOUR,KEY_FIVE,KEY_SIX,KEY_SEVEN,KEY_EIGHT,KEY_NINE,KEY_ZERO,KEY_DELETE,KEY_PREV};
 enum SpeechMenuOrder {ONE, TWO, THREE, FOUR, FIVE, SIX};
 enum Language {ENGLISH, FRENCH, GERMAN, ITALIAN, SPANISH};

public class Model{
    static Menu menu;
    static Situation situation;
    static Keys keys;
    static SpeechMenuOrder speechMenu ;
    static String textdisp;   //text content of user interface in whereto part
    static boolean wtFirstClicked;    //identify whether navigation has been started 
    static boolean firstClickedWT;    
    static Double stationaryRange;    //acceptable range of stationary state
    static int second;                //value of seconds of moving time 
    static int minute;                //value of minutes of moving time
    static int hour;                  //value of hours of moving time
    static String MODE;               //mode of transit(default:walking)
    static Double odometer;           
    static Double odemInKM;           //odometer with KM unit
    static int t;                     //time duration of each navigation
    static String currentPosition;    //coordinate of current position
    static String initialPosition;    
    
    static double latitude;
    static double longitude;
    static char   dOLatitude;  // direction of latitude
    static char   dOLongitude;  // direction of longitude
    static boolean signal;
    static String time;
    static Language currentLanguage;

  
    public static LinkedHashMap<String,String> route;      //a hash map which stores all of the position and instruction pairs
    /**
     *@param keys a instance of enum class which identify key state in whereto part
     * @param menu
     * @param situation
     */

    

    public Model(Menu menu, Situation situation,Keys keys, SpeechMenuOrder speechMenu){
        // model constructer
        Model.menu = menu;
        Model.situation = situation;
        Model.keys = keys; 
        this.speechMenu = speechMenu;
        time = "";
        textdisp = "";
        wtFirstClicked = false;
        firstClickedWT = true;
        stationaryRange = 0.0;
        second = 0;
        minute = 0;
        hour = 0;
        MODE = "walking";
        odometer = 0.0;
        odemInKM = 0.0;
        t = 0;
        currentPosition = "";
        initialPosition = "";
        
        route = new LinkedHashMap<>();
        speechMenu = SpeechMenuOrder.ONE;

    }

    public void openAndClose(){
        /*
        function can help to open and close the screen on the device
        @ author Haoran Jiang
        */
        
        screenPanel.removeAll();    // refresh the screen panel
        screenPanel.repaint();
        screenPanel.revalidate(); 
        
        if (situation == Situation.OFF){   // if screen is closed, then open it
            screenPanel.add(View.menu1Panel);
            situation = Situation.MENU;
            SatController.connect();
            
        } else {         
            situation = Situation.OFF;
            View.screenPanel.add(View.offPanel);   // if else, adding a black panel to screen
            SatController.disconnect();         
        }
        
        menu = Menu.ONE;  // reset menu order to page one
        screenPanel.repaint();
        screenPanel.revalidate();
        
    }
    
    public void goUp(){
         
        /*
        the function makes the UI can have "up" action on different situation, like menu mode and speech mode
        @ author Haoran Jiang
        */
        
        switch(situation){   // switch situation to change different funtionality for "up" action
            
            case MENU:{
                screenPanel.removeAll(); // refresh screen panel
                screenPanel.repaint();
                screenPanel.revalidate();
            switch (menu) { // add different panel on different situation
                case ONE:
                    screenPanel.add(menu2Panel); // add menu panel on screen panel
                    menu = Menu.TWO; // set specific menu order
                    break;

                case TWO:
                    screenPanel.add(menu3Panel);
                    menu = Menu.THREE;
                    break;

                case THREE:
                    screenPanel.add(menu4Panel);
                    menu = Menu.FOUR;
                    break;

                case FOUR:
                    screenPanel.add(menu5Panel);
                    menu = Menu.FIVE;
                    break;

                case FIVE:
                    screenPanel.add(menu6Panel);
                    menu = Menu.SIX;
                    break;

                case SIX:
                    screenPanel.add(menu1Panel);
                    menu = Menu.ONE;
                    break;

                default:
                    break;
            }            
            screenPanel.repaint(); // refresh screen panel
            screenPanel.revalidate();
            break;
            
            }
            
            case WHERETO:{                                                                //line 228-578 author siqi wang 
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                
                WhereToView.jPanelKeyBoard.removeAll();  //refresh keyboard panel
                WhereToView.jPanelKeyBoard.repaint();
                WhereToView.jPanelKeyBoard.revalidate();
                switch(keys){
                    case KEY_A: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);          //set user typing to display form
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyB);       //change to next key in keyboard panel
                            
                            
                            
                            keys = Keys.KEY_B;                                            //set the current key state after clicking button
                            break;
            
                    case KEY_B: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyC);
                            
                    
                            keys = Keys.KEY_C;
                            break;
                    case KEY_C: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyD);
                            
                    
                            keys = Keys.KEY_D;
                            break;
                    case KEY_D: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyE);
                            
                    
                            keys = Keys.KEY_E;
                            break;
                    case KEY_E: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyF);
                            
                    
                            keys = Keys.KEY_F;
                            break;
                    case KEY_F: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyG);
                           
                    
                            keys = Keys.KEY_G;
                            break;
                    case KEY_G: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyH);
                            
                    
                            keys = Keys.KEY_H;
                            break;
                    case KEY_H: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyI);
                            
                    
                            keys = Keys.KEY_I;
                            break;   
                    case KEY_I: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyJ);
                            
                    
                            keys = Keys.KEY_J;
                            break;  
                    case KEY_J: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyK);
                            
                    
                            keys = Keys.KEY_K;
                            break;
                    case KEY_K: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyL);
                            
                    
                            keys = Keys.KEY_L;
                            break;
                    case KEY_L: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyM);
                            
                    
                            keys = Keys.KEY_M;
                            break;
                    case KEY_M: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyN);
                            
                    
                            keys =Keys.KEY_N;
                            break;
                    case KEY_N: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyO);
                            
                    
                            keys = Keys.KEY_O;
                            break;
                    case KEY_O: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyP);
                            
                    
                            keys = Keys.KEY_P;
                            break;
                    case KEY_P: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyQ);
                            
                    
                            keys = Keys.KEY_Q;
                            break;
                    case KEY_Q: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyR);
                            
                    
                            keys = Keys.KEY_R;
                            break;
                    case KEY_R: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyS);
                            
                    
                            keys = Keys.KEY_S;
                            break;
                    case KEY_S: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyT);
                            
                    
                            keys = Keys.KEY_T;
                            break;
                    case KEY_T: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyU);
                            
                    
                            keys = Keys.KEY_U;
                            break;
                    case KEY_U: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyV);
                            
                    
                            keys = Keys.KEY_V;
                            break;
                    case KEY_V: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyW);
                            
                    
                            keys = Keys.KEY_W;
                            break;
                    case KEY_W: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyX);
                            
                    
                            keys =Keys.KEY_X;
                            break;
                    case KEY_X: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyY);
                            
                    
                            keys = Keys.KEY_Y;
                            break;
                    case KEY_Y: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyZ);
                            
                    
                            keys = Keys.KEY_Z;
                            break;
                    case KEY_Z: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySpace);
                            
                    
                            keys = Keys.KEY_SPACE;
                            break;
                    case KEY_SPACE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyNext);
                            
                    
                            keys = Keys.KEY_NEXT;
                            break;
                    case KEY_NEXT: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyA);
                            
                    
                            
                    
                            keys = Keys.KEY_A;
                            break;
            
                    
                    
            //numeric keyboard
                    case KEY_ONE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyTwo);
                            
                    
                            keys = Keys.KEY_TWO;
                            break;
                    case KEY_TWO: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyThree);
                            
                    
                            keys = Keys.KEY_THREE;
                            break;
                    case KEY_THREE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyFour);
                           
                    
                            keys = Keys.KEY_FOUR;
                            break;
                    case KEY_FOUR: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyFive);
                            
                    
                            keys = Keys.KEY_FIVE;
                            break;
                    case KEY_FIVE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySix);
                            
                    
                            keys = Keys.KEY_SIX;
                            break;
                    case KEY_SIX: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySeven);
                            
                    
                            keys = Keys.KEY_SEVEN;
                            break;
                    case KEY_SEVEN: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyEight);
                            
                    
                            keys = Keys.KEY_EIGHT;
                            break;
                    case KEY_EIGHT: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyNine);
                            
                    
                            keys = Keys.KEY_NINE;
                            break;
                    case KEY_NINE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyZero);
                            
                    
                            keys = Keys.KEY_ZERO;
                            break;
                    case KEY_ZERO: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyDel);
                            
                    
                            keys = Keys.KEY_DELETE;
                            break;
                    case KEY_DELETE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyPrev);
                            
                    
                            keys = Keys.KEY_PREV;
                            break;
                    case KEY_PREV: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyOne);
                            
                    
                            
                    
                    
                            keys = Keys.KEY_ONE;
                            break;
                    
                    
                   
                }
                WhereToView.jPanelKeyBoard.repaint();
                WhereToView.jPanelKeyBoard.revalidate();
              
            }
                screenPanel.repaint();
                screenPanel.revalidate();
                break;
        
            case SPEECH :{
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                
                speP.removeAll();
                speP.repaint();
                speP.revalidate();
                switch (speechMenu) {
                
                case ONE:
                    speP.add(smenu6);
                    screenPanel.add(speP);
                    //speP.add(smenu2);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.SIX;
                    break;
                case TWO:
                    speP.add(smenu1);
                    screenPanel.add(speP);
                    //speP.add(smenu3);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.ONE;
                    break;
                case THREE:
                    speP.add(smenu2);
                    screenPanel.add(speP);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.TWO;
                    break;
                case FOUR:
                    speP.add(smenu3);
                    screenPanel.add(speP);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.THREE;
                    break;
                case FIVE:
                    speP.add(smenu4);
                    screenPanel.add(speP);                 
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.FOUR;
                    break;
                case SIX: 
                    speP.add(smenu5);
                    screenPanel.add(speP);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.FIVE;
                    break;
                default:
                    break;
        
           
            } 
            screenPanel.repaint();
            screenPanel.revalidate();
            break;
        }
            
            case MAP:{
                try{
                    moveTo(); // change to current coordinate from satellite
                    zoomOut(); // zoom out the size of map
                    getMap();
                    } catch (Exception e){
                        System.out.println("You should press it slowly!");
                    }
                File file =new File("output.png");
                String path = file.getAbsolutePath();
                ImageIcon icon = new ImageIcon(path);
                icon.getImage().flush(); // refresh the image on panel
                mapImage.setIcon(icon); 
                mapImage.repaint();
            }
        
        
    }}
    
    public void goDown(){
        /*
        the function makes the UI can have "down" action on different situation, like menu mode and speech mode
        @ author Haoran Jiang
        */
        
        switch(situation){
            
            case MENU:{
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
            switch (menu) {
                case ONE:
                    screenPanel.add(menu6Panel);
                    menu = Menu.SIX;
                    break;

                case TWO:
                    screenPanel.add(menu1Panel);
                    menu = Menu.ONE;
                    break;

                case THREE:
                    screenPanel.add(menu2Panel);
                    menu = Menu.TWO;
                    break;

                case FOUR:
                    screenPanel.add(menu3Panel);
                    menu = Menu.THREE;
                    break;

                case FIVE:
                    screenPanel.add(menu4Panel);
                    menu = Menu.FOUR;
                    break;

                case SIX:
                    screenPanel.add(menu5Panel);
                    menu = Menu.FIVE;
                    break;

                default:
                    break;
            }   
            screenPanel.repaint();
            screenPanel.revalidate();
            break;
        }   
            case WHERETO:{                                                                 //line 713-1060 author siqi wang
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                WhereToView.jPanelKeyBoard.removeAll();
                WhereToView.jPanelKeyBoard.repaint();
                WhereToView.jPanelKeyBoard.revalidate();
                switch(keys){
                    case KEY_A: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyNext);     //change to previous key in keyboard panel
                            
                    
                            
                            
                            
                            keys = Keys.KEY_NEXT;
                            break;
            
                    case KEY_B: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyA);
                            
                    
                            keys = Keys.KEY_A;
                            break;
                    case KEY_C: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyB);
                            
                    
                            keys = Keys.KEY_B;
                            break;
                    case KEY_D: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyC);
                            
                    
                            keys = Keys.KEY_C;
                            break;
                    case KEY_E: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyD);
                            
                    
                            keys = Keys.KEY_D;
                            break;
                    case KEY_F: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyE);
                            
                    
                            keys = Keys.KEY_E;
                            break;
                    case KEY_G: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyF);
                            
                    
                            keys = Keys.KEY_F;
                            break;
                    case KEY_H: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyG);
                            
                    
                            keys = Keys.KEY_G;
                            break;   
                    case KEY_I: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyH);
                            
                    
                            keys = Keys.KEY_H;
                            break;  
                    case KEY_J: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyI);
                            
                    
                            keys = Keys.KEY_I;
                            break;
                    case KEY_K: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyJ);
                            
                    
                            keys = Keys.KEY_J;
                            break;
                    case KEY_L: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyK);
                            
                    
                            keys = Keys.KEY_K;
                            break;
                    case KEY_M: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyL);
                            
                    
                            keys =Keys.KEY_L;
                            break;
                    case KEY_N: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyM);
                            
                    
                            keys = Keys.KEY_M;
                            break;
                    case KEY_O: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyN);
                            
                    
                            keys = Keys.KEY_N;
                            break;
                    case KEY_P: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyO);
                            
                    
                            keys = Keys.KEY_O;
                            break;
                    case KEY_Q: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyP);
                            
                    
                            keys = Keys.KEY_P;
                            break;
                    case KEY_R: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyQ);
                            
                    
                            keys = Keys.KEY_Q;
                            break;
                    case KEY_S: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyR);
                            
                    
                            keys = Keys.KEY_R;
                            break;
                    case KEY_T: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyS);
                            
                    
                            keys = Keys.KEY_S;
                            break;
                    case KEY_U: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyT);
                            
                    
                            keys = Keys.KEY_T;
                            break;
                    case KEY_V: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyU);
                            
                    
                            keys = Keys.KEY_U;
                            break;
                    case KEY_W: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyV);
                            
                    
                            keys =Keys.KEY_V;
                            break;
                    case KEY_X: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyW);
                            
                    
                            keys = Keys.KEY_W;
                            break;
                    case KEY_Y: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyX);
                            
                    
                            keys = Keys.KEY_X;
                            break;
                    case KEY_Z: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyY);
                            
                    
                            keys = Keys.KEY_Y;
                            break;
                    case KEY_SPACE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyZ);
                            
                    
                            keys = Keys.KEY_Z;
                            break;
                    case KEY_NEXT: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySpace);
                            
                            
                    
                            keys = Keys.KEY_SPACE;
                            break;
            
                    
                    
            //numeric keyboard
                    case KEY_ONE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyPrev);
                            
                    
                            
                    
                            keys = Keys.KEY_PREV;
                            break;
                    case KEY_TWO: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyOne);
                            
                    
                            keys = Keys.KEY_ONE;
                            break;
                    case KEY_THREE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyTwo);
                            
                    
                            keys = Keys.KEY_TWO;
                            break;
                    case KEY_FOUR: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyThree);
                            
                    
                            keys = Keys.KEY_THREE;
                            break;
                    case KEY_FIVE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyFour);
                            
                    
                            keys = Keys.KEY_FOUR;
                            break;
                    case KEY_SIX: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyFive);
                            
                    
                            keys = Keys.KEY_FIVE;
                            break;
                    case KEY_SEVEN: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySix);
                            
                    
                            keys = Keys.KEY_SIX;
                            break;
                    case KEY_EIGHT: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeySeven);
                            
                    
                            keys = Keys.KEY_SEVEN;
                            break;
                    case KEY_NINE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyEight);
                            
                            keys = Keys.KEY_EIGHT;
                            break;
                    case KEY_ZERO: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyNine);
                            
                    
                            keys = Keys.KEY_NINE;
                            break;
                    case KEY_DELETE: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyZero);
                            
                    
                            keys = Keys.KEY_ZERO;
                            break;
                    case KEY_PREV: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyDel);
                            
                    
                    
                            keys = Keys.KEY_DELETE;
                            break;
                    
                    
                }
                WhereToView.jPanelKeyBoard.repaint();
                WhereToView.jPanelKeyBoard.revalidate();
            }
                screenPanel.repaint();
                screenPanel.revalidate();
                break;
                
                case SPEECH:{
                    screenPanel.removeAll();
                    screenPanel.repaint();
                    screenPanel.revalidate();
           
                    speP.removeAll();
                speP.repaint();
                speP.revalidate();
                switch (speechMenu) {
                
                case ONE:
                    speP.add(smenu2);
                    screenPanel.add(speP);
                    //speP.add(smenu2);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.TWO;
                    break;
                case TWO:
                    speP.add(smenu3);
                    screenPanel.add(speP);
                    //speP.add(smenu3);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.THREE;
                    break;
                case THREE:
                    speP.add(smenu4);
                    screenPanel.add(speP); 
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.FOUR;
                    break;
                case FOUR:
                    speP.add(smenu5);
                    screenPanel.add(speP);
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.FIVE;
                    break;
                case FIVE:
                    speP.add(smenu6);
                    screenPanel.add(speP);      
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.SIX;
                    break;
                case SIX:
                    speP.add(smenu1);
                    screenPanel.add(speP);       
                    speP.repaint();
                    speP.revalidate();
                    speechMenu = SpeechMenuOrder.ONE;
                    break;
                default:
                    break;
        
           
            } 
            screenPanel.repaint();
            screenPanel.revalidate();
            break;
            
            
        }
                case MAP:{
                    try{
                    moveTo();
                    zoomIn();
                    getMap();
                    } catch (Exception e){
                        System.out.println("You should press it slowly!");
                    }
                    File file =new File("output.png");
                    String path = file.getAbsolutePath();
                    ImageIcon icon = new ImageIcon(path);
                    icon.getImage().flush();
                    mapImage.setIcon(icon); 
                    mapImage.repaint();
                }
        
        
    }
        
    }
    
    /*
    method can use on the backmenu button, that can help UI to back to the menu page when on the other situation except "off"
    @ author Haoran Jiang
    */
    public void backMenu(){
        if (situation != Situation.MENU && situation != Situation.OFF) { // only if on the "off" and "menu" situation, it will not work
            situation = Situation.MENU;   // reset the situation to MENU
            screenPanel.removeAll();
            screenPanel.repaint();     // refresh the screen panel
            screenPanel.revalidate();
            
        // add panel
            switch (menu) {                                         
                case ONE:                                                               //line1161-1240 author siqi wang
                    String textdisp = WhereToView.jTextFieldDestination.getText();
                    //WhereToView.jTextFieldDestination.setText(textdisp);
                    screenPanel.add(menu1Panel);
                    if (!"".equals(textdisp)){                                
                                   
                    route.clear();
                    t = 0;
                    odometer = 0.0;
                    tripComputerPanel.odemDisplay.setText("0.0 KM");
                    tripComputerPanel.speedDisplay.setText("0.0 KM/H");

                   
                        
                    
                    if(wtFirstClicked == false){
                        initialPosition =getPosition();
                                
                                
                    
                                
                    try {
                        findInstruction(initialPosition,textdisp);
                        displayOdem();
                        movingTimeIncease();
                        dynamicTime();
                        displaySpeed();
                                
                                
                                
                                
                        wtFirstClicked = true;
                        textdisp = "";
                        WhereToView.jTextFieldDestination.setText(textdisp);
                        } catch (JSONException ex) {
                            if(initialPosition.equals("0.0,0.0")){System.out.println("Please check your GPS signal");}
                            else{
                                System.out.println("Please type a detailed and legal destination");
                            } 
                        
                        }
                            
                    System.out.println(route);
                    NewSoundAndSpeech.my_route = route;
                                    
                        
                        
                    }
                    else{
                        tripComputerPanel.odemDisplay.setText(Double.toString(odemInKM)+" KM");
                        t = 0;                                                                  //if navigation was started again, odometer and time will be set to zero
                        odometer = 0.0;
                    
            
                        {   
                            try {
                                initialPosition = getPosition();
                                findInstruction(initialPosition,textdisp);
                                
                                        
                                
                                textdisp = "";
                                whereToPanel.jTextFieldDestination.setText(textdisp);
                            } catch (JSONException ex) {
                                if(initialPosition.equals("0.0,0.0")){System.out.println("Please check your GPS signal");}
                                else{
                                    System.out.println("Please type a detailed and legal destination");
                                } 
                            }
                        }

                        
                    }
                   
                    }else{
                        System.out.print("Please enter a destination.");
                    }
            
                    firstClickedWT = true;
                    break;
                    
                case TWO:
                    screenPanel.add(menu2Panel); // afte back to menu, it will show the orginal page on the screen panel.
                    firstClickedWT = true;
                    break;
                    
                case THREE:
                    screenPanel.add(menu3Panel);
                    firstClickedWT = true;
                    break;
                    
                case FOUR:
                    screenPanel.add(menu4Panel);
                    firstClickedWT = true;
                    break;
                    
                case FIVE:
                    screenPanel.add(menu5Panel);
                    firstClickedWT = true;
                    break;
                    
                case SIX:
                    screenPanel.add(menu6Panel);
                    firstClickedWT = true;
                    break;
                    
                default:
                    break;
            }
            screenPanel.repaint();
            screenPanel.revalidate();  //refresh the screen panel
        }
        
    }
    
    /*
    the method can used on the select button, that makes the UI can have "select" action on different situation, like menu mode and speech mode
    @ author Haoran Jiang
    */
    public void select() throws Exception{
        if (null != situation) 
        switch (situation) {  // change the situation to make method have different functionality
            case MAP:
                moveTo();   // change the coordinate to current location
                File file =new File("output.png");
                String path = file.getAbsolutePath();
                ImageIcon icon = new ImageIcon(path);
                icon.getImage().flush();   // refresh the screen panel
                mapImage.setIcon(icon); 
                mapImage.repaint();
                break;
            
            case MENU:
                screenPanel.removeAll();
                screenPanel.repaint();  // refresh the screen panel
                screenPanel.revalidate();
                switch (menu) {
                    case ONE:                     
                        screenPanel.add(whereToPanel);
                        speechMenu("menuOne.wav");   // add a speech for the page one
                        situation = Situation.WHERETO; // set the specific situation orer
                        break;

                    case TWO:
                        
                        screenPanel.add(tripComputerPanel);
                        speechMenu("menuTwo.wav");
                        situation = Situation.TRIPCOMPUTER;
                        break;

                    case THREE:
                        
                        screenPanel.add(mapPanel);
                        speechMenu("menuThree.wav");
                        situation = Situation.MAP;
                        break;

                    case FOUR:
                        
                        screenPanel.add(speechPanel);
                        speechMenu("menuFour.wav");
                        situation = Situation.SPEECH;
                        break;

                    case FIVE:
                        
                        screenPanel.add(TSPanel);
                        speechMenu("menuFive.wav");
                        if (SatelliteController.connected == false)
                            SatelliteController.generateSound(SatelliteController.NOT_CONNECTED);
                         if (SatelliteController.signal == false && SatelliteController.connected == true)
                            SatelliteController.generateSound(SatelliteController.NO_SIGNAL);
                        situation = Situation.SATELLITE;
                        break;

                    case SIX:
                        
                        screenPanel.add(aboutPanel);
                        speechMenu("menuSix.wav");
                        situation = Situation.ABOUTME;
                        break;

                    default:
                        break;
            }                screenPanel.repaint();
                screenPanel.revalidate();
                break;
                
            case WHERETO:{                                                      //line 1349-1546 author siqi wang     
                if(firstClickedWT){screenPanel.add(whereToPanel);               // check that function of select button at this moment(enter to whereto interface or select a key on virtual keyboard)
                WhereToView.jTextFieldDestination.setText(textdisp);
                firstClickedWT = false;
                } else{
                //WhereToView.jTextFieldDestination.setText(textdisp);
                textdisp = WhereToView.jTextFieldDestination.getText();
                switch(keys){
                    
                    case KEY_A: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "A");       //add the corresponding letter to display form
                            textdisp = textdisp + "A";
                            break;
            
                    case KEY_B: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "B");
                            textdisp = textdisp + "B";
                            break;
                    case KEY_C: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "C");
                            textdisp = textdisp + "C";
                            break;
                    case KEY_D: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "D");
                            textdisp = textdisp + "D";
                            break;
                    case KEY_E: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "E");
                            textdisp = textdisp + "E";
                            break;
                    case KEY_F: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "F");
                            textdisp = textdisp + "F";
                            break;
                    case KEY_G: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "G");
                            textdisp = textdisp + "G";;
                            break;
                    case KEY_H: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "H");
                            textdisp = textdisp + "H";
                            break;   
                    case KEY_I: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "I");
                            textdisp = textdisp + "I";
                            break;  
                    case KEY_J: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "J");
                            textdisp = textdisp + "J";
                            break;
                    case KEY_K: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "K");
                            textdisp = textdisp + "K";
                            break;
                    case KEY_L: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "L");
                            textdisp = textdisp + "L";
                            break;
                    case KEY_M: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "M");
                            textdisp = textdisp + "M";
                            break;
                    case KEY_N: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "N");
                            textdisp = textdisp + "N";
                            break;
                    case KEY_O: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "O");
                            textdisp = textdisp + "O";
                            break;
                    case KEY_P: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "P");
                            textdisp = textdisp + "P";
                            break;
                    case KEY_Q: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "Q");
                            textdisp = textdisp + "Q";
                            break;
                    case KEY_R: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "R");
                            textdisp = textdisp + "R";
                            break;
                    case KEY_S: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "S");
                            textdisp = textdisp + "S";
                            break;
                    case KEY_T: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "T");
                            textdisp = textdisp + "T";
                            break;
                    case KEY_U: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "U");
                            textdisp = textdisp + "U";
                            break;
                    case KEY_V: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "V");
                            textdisp = textdisp + "V";
                            break;
                    case KEY_W: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "W");
                            textdisp = textdisp + "W";
                            break;
                    case KEY_X: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "X");
                            textdisp = textdisp + "X";
                            break;
                    case KEY_Y: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "Y");
                            textdisp = textdisp + "Y";
                            break;
                    case KEY_Z: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "Z");
                            textdisp = textdisp + "Z";
                            break;
                    case KEY_SPACE: 
                            WhereToView.jTextFieldDestination.setText(textdisp + " ");
                            textdisp = textdisp + " ";
                            break;
                    case KEY_NEXT: 
                            WhereToView.jPanelKeyBoard.removeAll();                         //move to numeric keyboard
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyPrev);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            
                            keys = Keys.KEY_PREV;
                            
                            break;
            
                    
                    
            //numeric keyboard
                    case KEY_ONE: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "1");
                            textdisp = textdisp + "1";
                            break;
                    case KEY_TWO: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "2");
                            textdisp = textdisp + "2";
                            break;
                    case KEY_THREE: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "3");
                            textdisp = textdisp + "3";
                            break;
                    case KEY_FOUR: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "4");
                            textdisp = textdisp + "4";
                            break;
                    case KEY_FIVE: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "5");
                            textdisp = textdisp + "5";
                            break;
                    case KEY_SIX: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "6");
                            textdisp = textdisp + "6";
                            break;
                    case KEY_SEVEN: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "7");
                            textdisp = textdisp + "7";
                            break;
                    case KEY_EIGHT: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "8");
                            textdisp = textdisp + "8";
                            break;
                    case KEY_NINE: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "9");
                            textdisp = textdisp + "9";
                            break;
                    case KEY_ZERO: 
                            WhereToView.jTextFieldDestination.setText(textdisp + "0");
                            textdisp = textdisp + "0";
                            break;
                    case KEY_DELETE: 
                            textdisp = textdisp.substring(0, textdisp.length()-1);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            break;
                    case KEY_PREV: 
                            WhereToView.jPanelKeyBoard.removeAll();                              //move to alphabetic keyboard
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            WhereToView.jPanelKeyBoard.add(whereToPanel.jPanelKeyNext);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                            WhereToView.jTextFieldDestination.setText(textdisp);
                    
                            keys = Keys.KEY_NEXT;
                            break;
                    
                    
                }}
                screenPanel.repaint();
                screenPanel.revalidate();
                break;
                }
case SPEECH:
    NewSoundAndSpeech.task();



         switch(speechMenu){
            case TWO:
                try {
                    generateLanguage(NewSoundAndSpeech.ENGLISH);
                    try{
                        if (read.isAlive()) {
                             read.interrupt();
                        }
                    }finally{
                    currentLanguage= Language.ENGLISH;
                    NewSoundAndSpeech.directionsReader(currentLanguage);
                   }
                } catch (Exception e) {
                    ;
                }
                break;
            case THREE:
                try {
                    generateLanguage(NewSoundAndSpeech.FRENCH);
                   try{
                        if (read.isAlive()) {
                             read.interrupt();
                    } 
                    }finally{
                    currentLanguage= Language.FRENCH;
                    NewSoundAndSpeech.directionsReader(currentLanguage);
                   }
                } catch (Exception e) {
                    ;
                }
                break;
            case FOUR:
                try {
                    generateLanguage(NewSoundAndSpeech.GERMAN);
                   try{
                        if (read.isAlive()) {
                             read.interrupt();
                        } 
                    }finally{
                    currentLanguage= Language.GERMAN;
                    NewSoundAndSpeech.directionsReader(currentLanguage);
                   }} catch (Exception e) {
                    ;
                }
                break;
            case FIVE:
                try{
                    generateLanguage(NewSoundAndSpeech.ITALIAN);
                   try{
                        if (read.isAlive()) {
                             read.interrupt();
                        } 
                    }finally{
                    currentLanguage= Language.ITALIAN;
                    NewSoundAndSpeech.directionsReader(currentLanguage);
                   } } catch (Exception e) {
                    ;
                }
                break;
            case SIX:
                 try {
                     generateLanguage(NewSoundAndSpeech.SPANISH);
                   try{
                        if (read.isAlive()) {
                             read.interrupt();
                        } 
                    }finally{
                    currentLanguage= Language.SPANISH;
                    NewSoundAndSpeech.directionsReader(currentLanguage);
                   } } catch (Exception e) {
                    ;
                }
                break;   
        }
                screenPanel.repaint();
                screenPanel.revalidate();
                
        }
    }
    /**
     * @author YuKun Sun
     * Return position in String form "(latitude,longitude)" 
     */
    public static String  getPosition(){
        String position = "" + latitude +","+ longitude;
        return position;
    }
    
    public static String  getLongitude(){
        String position = "" +  longitude;
        return position;
    }
    
    public static String  getLatitude(){
        String position = "" + latitude;
        return position;
    }
    
    /**
     * Run a thread which record moving time dynamically
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    public void movingTimeIncease(){                                                         
        
        Thread movingTime = new Thread(){
        public void run(){
        for(;;){
            String str_s = Integer.toString(second);
            String str_m = Integer.toString(minute);
            String str_h = Integer.toString(hour);
            tripComputerPanel.timeDisplay.setText(str_h+"Hour   "+str_m+"Min   "+str_s+"Sec");
            try{sleep(1000);}catch(InterruptedException e){}
            
            second++;
            if(second==60){            //each 60s will be evaluated to 1 minute
                minute++;
                second = 0;
            }
            if(minute==60){            //each 60m will be evaluated to 1 hour
                hour++;
                minute = 0;
            }
        }
        }
        };
        movingTime.start();             //start moving time thread
    }
    
    
    /**
     * Generate best route solution from start position to end position
     * @param start A string refer to address of start position
     * @param end A string refer to address of end position
     * @return A byte array contains json response
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    public byte[] readDirections(String start,String end){
        try {
            final String encOrigin      = URLEncoder.encode( start,      "UTF-8" );
            final String encDestination = URLEncoder.encode( end, "UTF-8" );
            final String method = "GET";
            final String url 
            = ( "https://maps.googleapis.com/maps/api/directions/json"
              + "?" + "origin"      + "=" + encOrigin
              + "&" + "destination" + "=" + encDestination
              + "&" + "mode"        + "=" + MODE
              + "&" + "key"         + "=" + "AIzaSyCMMwL7rLUZdfDuB-_X6R11jQ57ZzMN0Xg"
              );
            final byte[] body
             = {}; 
            final String[][] headers
             = {};
            byte[] response = HttpConnect.httpConnect( method, url, headers, body );
            return response;
            } catch ( Exception ex ) {System.out.println( ex ); return null;}
    }
    
    
    
    /**
     * Run a thread which display odometer in real time dynamically.
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    public void displayOdem(){
        Thread odemInReal = new Thread(){
            public void run(){
                for(;;){
                    try{sleep(6000);}catch(InterruptedException e){}               //update odometer by 6s
                    
                    currentPosition = getPosition();
                    Double distanceIn6s = realDist(initialPosition,currentPosition);         //Calculate distance moved in 6s
                    if(distanceIn6s<3.0){odometer = odometer+0.0;}else{
                    odometer = odometer+distanceIn6s;}
                    odemInKM = 1.0*odometer/1000;
                    Double roundOdemInKM = round(odemInKM,3);
                    tripComputerPanel.odemDisplay.setText(Double.toString(roundOdemInKM)+" KM");
                    initialPosition = currentPosition;
                }
            }
        };
        odemInReal.start();
    }
    
    /**
     * Run a thread which display speed in real time dynamically.
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    public void displaySpeed(){
        
        Thread speed = new Thread(){
            public void run(){
                   for(;;){
                   
                   try{sleep(6000);}catch(InterruptedException e){}
                   
                   
                   
                   //String pureSpeed = odometer.substring(0,odometer.length()-3);
                   //Double distanceValue = Double.parseDouble(pureSpeed);
                   Double speedValue = odometer/t*3.6;                                //convert m/s to km/h
                   Double roundSpeedValue = round(speedValue,2);                      // round to second decimal places
                   String speedInKmh = Double.toString(roundSpeedValue) + "   KM/H";
                   
                   tripComputerPanel.speedDisplay.setText(speedInKmh);
                   
                   
                   }
               }
            
            };
        speed.start();
    }
    
    /**
     * Calculate the distance from positionA to positionB in real time
     * @param positionA start position called positionA
     * @param positionB end position called positionB
     * @return a double value of distance
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    public double realDist(String positionA,String positionB) {
      
      List splitPlaceA = splitPlace(positionA);
      
      List splitPlaceB = splitPlace(positionB);
      
      String placeALattitude = splitPlaceA.get(0).toString();
              
      String placeALongitude = splitPlaceA.get(1).toString();
              
      String placeBLattitude = splitPlaceB.get(0).toString();
              
      String placeBLongitude = splitPlaceB.get(1).toString();
      
      double placeALattitudeValue = Double.parseDouble(placeALattitude);
      
      double placeALongitudeValue = Double.parseDouble(placeALongitude);
      
      double placeBLattitudeValue = Double.parseDouble(placeBLattitude);
      
      double placeBLongitudeValue = Double.parseDouble(placeBLongitude);
      
      return distance(placeBLattitudeValue, placeBLongitudeValue, placeALattitudeValue, placeALongitudeValue, 'M');
      
  }
   
    /*
    Run a thread which update time duration of each navigation.
    @author Siqi Wang(Group L WorkPackage 2)
    */
    public  void dynamicTime(){
        Thread dt = new Thread(){
            public void run(){
                for(;;){
                    try{sleep(1000);}catch(InterruptedException e){}
                    t++;
                }
            
            }
        
        };
        dt.start();
    
    }
    
    /**
     * Add all of position and instruction pairs of route from start position to end position
     * @param s1 coordinate of start position
     * @param s2 coordinate of end position
     * @throws JSONException 
     * @author Siqi Wang(Group L WorkPackage 2)
     */
    
    public void findInstruction(String s1,String s2) throws JSONException{
        String s = new String(readDirections(s1, s2));
        JSONObject obj = new JSONObject(s);
        JSONArray routes = (JSONArray) obj.get("routes");
        JSONObject child1 = (JSONObject) routes.getJSONObject(0);
        JSONArray legs = (JSONArray) child1.get("legs");
        JSONObject child2 = (JSONObject) legs.getJSONObject(0);
        JSONArray steps = (JSONArray)child2.getJSONArray("steps");
        
        
        for(int i = 0;i<steps.length();i++){
            JSONObject step = steps.getJSONObject(i);
            //end location
            JSONObject end_location = (JSONObject)step.getJSONObject("end_location");
            String lat = Double.toString((end_location.getDouble("lat")));
            String lng = Double.toString((end_location.getDouble("lng")));
            String location = lat+","+lng;
            if(i == (steps.length()-1))                         // get last end location
                    NewSoundAndSpeech.destination = location;  // set it to be destination 
            //instruction
            String html_instruction = StringEscapeUtils.unescapeJava(step.getString("html_instructions"));
            String instruction = Jsoup.parse(html_instruction).text();
            
            //add map
            route.put(location,instruction);
        }
        
    }
            
   /**
     * @ helper function - Round a value to certain decimal places 
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }    
    
    /*
    function can help menu mode to read the name of different situation
    @ author Haoran Jiang
    */
    public static void speechMenu(String name) throws Exception {
        Thread menuThread = new Thread(){ // use an another thread to avoid delaying UI
           @Override
           public void run(){
               AudioInputStream stm = setupStream( name ); // read the pre-recorded audio file
               playStream( stm, readStream( stm ) );
           }
        };
        menuThread.start(); // start thread 
      
    

    }
        
            
       
    
}
