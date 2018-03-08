package MVC;



import static MVC.View.TSPanel;
import static MVC.View.aboutPanel;
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

//
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.*;
import java.util.*;


/**
 *
 * Model.
 * 
 * @author Haoran Jiang 2018.
 */





public class Model{
    static Menu menu;
    static Situation situation;
    static Keys keys;
    static String textdisp;
    static boolean firstClickedWT;
    static boolean submitClicked;
    static int second;
    static int minute;
    static int hour;
    static String MODE;
    static String odometer;
    static int t;
    static double latitude;
    static double longitude;
    static char   dOLatitude;  // direction of latitude
    static char   dOLongitude;  // direction of longitude
    static boolean signal;
    static String time;
    static enum Menu {ONE, TWO, THREE, FOUR, FIVE, SIX};
    static enum Situation {OFF, MENU, WHERETO, TRIPCOMPUTER, MAP, SPEECH, SATELLITE, ABOUTME};
    static enum Keys{KEY_A,KEY_B,KEY_C,KEY_D,KEY_E,KEY_F,KEY_G,KEY_H,KEY_I,KEY_J,KEY_K,KEY_L,KEY_M,KEY_N,KEY_O,
         KEY_P,KEY_Q,KEY_R,KEY_S,KEY_T,KEY_U,KEY_V,KEY_W,KEY_X,KEY_Y,KEY_Z,KEY_SPACE,KEY_NEXT,KEY_SUB1,
         KEY_ONE,KEY_TWO,KEY_THREE,KEY_FOUR,KEY_FIVE,KEY_SIX,KEY_SEVEN,KEY_EIGHT,KEY_NINE,KEY_ZERO,KEY_DELETE,KEY_PREV,KEY_SUB2};
    static HashMap<String,String> route;
    /**
     *
     * @param menu
     * @param situation
     */

    public Model(Menu menu, Situation situation){
        Model.menu = menu;
        Model.situation = situation;
    }

    public Model(Menu menu, Situation situation,Keys keys){
        Model.menu = menu;
        Model.situation = situation;
        Model.keys = keys;
        time = "";
        textdisp = "";
        firstClickedWT = true;
        submitClicked = false;
        second = 0;
        minute = 0;
        hour = 0;
        MODE = "walking";
        odometer = "0";
        t = 0;
        route = new HashMap<>();

    }

    public void openAndClose(){
        
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate(); 
        if (situation == Situation.OFF){  
            screenPanel.add(View.menu1Panel);
            situation = Situation.MENU;
            
        } else {         
            situation = Situation.OFF;
            View.screenPanel.add(View.offPanel);           
        }
        
        menu = Menu.ONE;
        screenPanel.repaint();
        screenPanel.revalidate();
        
    }
    
    public void goUp(){
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate(); 
        
        switch(situation){
            case MENU:{
            switch (menu) {
                case ONE:
                    screenPanel.add(menu2Panel);
                    menu = Menu.TWO;
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
            screenPanel.repaint();
            screenPanel.revalidate();
            
            }
            
            case WHERETO:
                
                WhereToView.jPanelKeyBoard.removeAll();
                WhereToView.jPanelKeyBoard.repaint();
                WhereToView.jPanelKeyBoard.revalidate();
                switch(keys){
                    case KEY_A: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyB);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                            
                            
                            keys = Keys.KEY_B;
                            break;
            
                    case KEY_B: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyC);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_C;
                            break;
                    case KEY_C: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyD);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_D;
                            break;
                    case KEY_D: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyE);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_E;
                            break;
                    case KEY_E: 
                            screenPanel.add(whereToPanel);
                            WhereToView.jTextFieldDestination.setText(textdisp);
                            WhereToView.jPanelKeyBoard.add(WhereToView.jPanelKeyF);
                            WhereToView.jPanelKeyBoard.repaint();
                            WhereToView.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_F;
                            break;
                    case KEY_F: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyG);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_G;
                            break;
                    case KEY_G: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyH);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_H;
                            break;
                    case KEY_H: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyI);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_I;
                            break;   
                    case KEY_I: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyJ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_J;
                            break;  
                    case KEY_J: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyK);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_K;
                            break;
                    case KEY_K: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyL);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();  
                    
                            keys = Keys.KEY_L;
                            break;
                    case KEY_L: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyM);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_M;
                            break;
                    case KEY_M: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyN);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys =Keys.KEY_N;
                            break;
                    case KEY_N: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyO);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_O;
                            break;
                    case KEY_O: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyP);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_P;
                            break;
                    case KEY_P: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyQ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Q;
                            break;
                    case KEY_Q: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyR);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_R;
                            break;
                    case KEY_R: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyS);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_S;
                            break;
                    case KEY_S: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyT);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_T;
                            break;
                    case KEY_T: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyU);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_U;
                            break;
                    case KEY_U: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyV);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_V;
                            break;
                    case KEY_V: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyW);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_W;
                            break;
                    case KEY_W: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyX);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys =Keys.KEY_X;
                            break;
                    case KEY_X: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyY);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Y;
                            break;
                    case KEY_Y: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyZ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Z;
                            break;
                    case KEY_Z: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySpace);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_SPACE;
                            break;
                    case KEY_SPACE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyNext);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_NEXT;
                            break;
                    case KEY_NEXT: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelAlphaKeyBoard);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitHighlight);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_SUB1;
                            break;
            
                    case KEY_SUB1: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyA);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitButton);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_A;
                            
                            break;
                    
            //numeric keyboard
                    case KEY_ONE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyTwo);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_TWO;
                            break;
                    case KEY_TWO: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyThree);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_THREE;
                            break;
                    case KEY_THREE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyFour);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_FOUR;
                            break;
                    case KEY_FOUR: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyFive);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_FIVE;
                            break;
                    case KEY_FIVE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySix);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_SIX;
                            break;
                    case KEY_SIX: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySeven);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_SEVEN;
                            break;
                    case KEY_SEVEN: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyEight);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_EIGHT;
                            break;
                    case KEY_EIGHT: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyNine);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_NINE;
                            break;
                    case KEY_NINE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyZero);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_ZERO;
                            break;
                    case KEY_ZERO: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyDel);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_DELETE;
                            break;
                    case KEY_DELETE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyPrev);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_PREV;
                            break;
                    case KEY_PREV: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelNumKeyBoard);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitHighlight);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                    
                            keys = Keys.KEY_SUB2;
                            break;
                    
                    case KEY_SUB2:
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyOne);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitButton);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_ONE;
                            break;
                }
                screenPanel.repaint();
                screenPanel.revalidate();
            }
        
        
    }
    
    public void goDown(){
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate();
        switch(situation){
            case MENU:{
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
        }   
            case WHERETO:
                WhereToView.jPanelKeyBoard.removeAll();
                whereToPanel.jPanelKeyBoard.repaint();
                whereToPanel.jPanelKeyBoard.revalidate();
                switch(keys){
                    case KEY_A: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelAlphaKeyBoard);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitHighlight);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                            
                            
                            keys = Keys.KEY_SUB1;
                            break;
            
                    case KEY_B: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyA);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_A;
                            break;
                    case KEY_C: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyB);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_B;
                            break;
                    case KEY_D: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyC);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_C;
                            break;
                    case KEY_E: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyD);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_D;
                            break;
                    case KEY_F: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyE);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_E;
                            break;
                    case KEY_G: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyF);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_F;
                            break;
                    case KEY_H: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyG);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_G;
                            break;   
                    case KEY_I: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyH);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_H;
                            break;  
                    case KEY_J: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyI);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_I;
                            break;
                    case KEY_K: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyJ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();  
                    
                            keys = Keys.KEY_J;
                            break;
                    case KEY_L: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyK);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_K;
                            break;
                    case KEY_M: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyL);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys =Keys.KEY_L;
                            break;
                    case KEY_N: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyM);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_M;
                            break;
                    case KEY_O: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyN);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_N;
                            break;
                    case KEY_P: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyO);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_O;
                            break;
                    case KEY_Q: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyP);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_P;
                            break;
                    case KEY_R: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyQ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Q;
                            break;
                    case KEY_S: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyR);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_R;
                            break;
                    case KEY_T: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyS);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_S;
                            break;
                    case KEY_U: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyT);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_T;
                            break;
                    case KEY_V: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyU);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_U;
                            break;
                    case KEY_W: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyV);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys =Keys.KEY_V;
                            break;
                    case KEY_X: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyW);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_W;
                            break;
                    case KEY_Y: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyX);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_X;
                            break;
                    case KEY_Z: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyY);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Y;
                            break;
                    case KEY_SPACE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyZ);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_Z;
                            break;
                    case KEY_NEXT: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySpace);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                            
                    
                            keys = Keys.KEY_SPACE;
                            break;
            
                    case KEY_SUB1: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyNext);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitButton);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_NEXT;
                            
                            break;
                    
            //numeric keyboard
                    case KEY_ONE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelNumKeyBoard);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitHighlight);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_SUB2;
                            break;
                    case KEY_TWO: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyOne);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_ONE;
                            break;
                    case KEY_THREE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyTwo);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_TWO;
                            break;
                    case KEY_FOUR: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyThree);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_THREE;
                            break;
                    case KEY_FIVE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyFour);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_FOUR;
                            break;
                    case KEY_SIX: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyFive);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_FIVE;
                            break;
                    case KEY_SEVEN: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySix);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_SIX;
                            break;
                    case KEY_EIGHT: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeySeven);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_SEVEN;
                            break;
                    case KEY_NINE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyEight);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_EIGHT;
                            break;
                    case KEY_ZERO: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyNine);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_NINE;
                            break;
                    case KEY_DELETE: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyZero);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            keys = Keys.KEY_ZERO;
                            break;
                    case KEY_PREV: 
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyDel);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                    
                            keys = Keys.KEY_DELETE;
                            break;
                    
                    case KEY_SUB2:
                            screenPanel.add(whereToPanel);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            View.whereToPanel.jPanelKeyBoard.add(View.whereToPanel.jPanelKeyPrev);
                            View.whereToPanel.jPanelKeyBoard.repaint();
                            View.whereToPanel.jPanelKeyBoard.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.removeAll();
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            View.whereToPanel.jPanelSubmit.add(View.whereToPanel.jPanelSubmitButton);
                            View.whereToPanel.jPanelSubmit.repaint();
                            View.whereToPanel.jPanelSubmit.revalidate();
                    
                            keys = Keys.KEY_PREV;
                            break;
                }
                screenPanel.repaint();
                screenPanel.revalidate();
        }
    }
    
    public void backMenu(){
        if (situation != Situation.MENU && situation != Situation.OFF) {
            situation = Situation.MENU;
            
            screenPanel.removeAll();
            screenPanel.repaint();
            screenPanel.revalidate();
            
        // add panel
            switch (menu) {
                case ONE:
                    screenPanel.add(menu1Panel);
                    firstClickedWT = true;
                    break;
                    
                case TWO:
                    screenPanel.add(menu2Panel);
                    
                    break;
                    
                case THREE:
                    screenPanel.add(menu3Panel);
                    break;
                    
                case FOUR:
                    screenPanel.add(menu4Panel);
                    break;
                    
                case FIVE:
                    screenPanel.add(menu5Panel);
                    break;
                    
                case SIX:
                    screenPanel.add(menu6Panel);
                    break;
                    
                default:
                    break;
            }
            screenPanel.repaint();
            screenPanel.revalidate();
        }
        
    }
    
    public void select(){
        if (null != situation) // TODO add your handling code here:
        switch (situation) {
            case MENU:
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                switch (menu) {
                    case ONE:
                        screenPanel.add(whereToPanel);
                        situation = Situation.WHERETO;
                        break;

                    case TWO:
                        screenPanel.add(tripComputerPanel);
                        situation = Situation.TRIPCOMPUTER;
                        break;

                    case THREE:
                        screenPanel.add(mapPanel);
                        situation = Situation.MAP;
                        break;

                    case FOUR:
                        screenPanel.add(speechPanel);
                        situation = Situation.SPEECH;
                        break;

                    case FIVE:
                        screenPanel.add(TSPanel);
                        situation = Situation.SATELLITE;
                        break;

                    case SIX:
                        screenPanel.add(aboutPanel);
                        situation = Situation.ABOUTME;
                        break;

                    default:
                        break;
            }
                
            case WHERETO:
                if(firstClickedWT){screenPanel.add(whereToPanel);
                whereToPanel.jTextFieldDestination.setText(textdisp);
                firstClickedWT = false;}else{
                whereToPanel.jTextFieldDestination.setText(textdisp);
                switch(keys){
                    case KEY_A: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "A");
                            textdisp = textdisp + "A";
                            break;
            
                    case KEY_B: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "B");
                            textdisp = textdisp + "B";
                            break;
                    case KEY_C: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "C");
                            textdisp = textdisp + "C";
                            break;
                    case KEY_D: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "D");
                            textdisp = textdisp + "D";
                            break;
                    case KEY_E: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "E");
                            textdisp = textdisp + "E";
                            break;
                    case KEY_F: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "F");
                            textdisp = textdisp + "F";
                            break;
                    case KEY_G: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "G");
                            textdisp = textdisp + "G";;
                            break;
                    case KEY_H: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "H");
                            textdisp = textdisp + "H";
                            break;   
                    case KEY_I: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "I");
                            textdisp = textdisp + "I";
                            break;  
                    case KEY_J: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "J");
                            textdisp = textdisp + "J";
                            break;
                    case KEY_K: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "K");
                            textdisp = textdisp + "K";
                            break;
                    case KEY_L: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "L");
                            textdisp = textdisp + "L";
                            break;
                    case KEY_M: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "M");
                            textdisp = textdisp + "M";
                            break;
                    case KEY_N: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "N");
                            textdisp = textdisp + "N";
                            break;
                    case KEY_O: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "O");
                            textdisp = textdisp + "O";
                            break;
                    case KEY_P: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "P");
                            textdisp = textdisp + "P";
                            break;
                    case KEY_Q: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "Q");
                            textdisp = textdisp + "Q";
                            break;
                    case KEY_R: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "R");
                            textdisp = textdisp + "R";
                            break;
                    case KEY_S: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "S");
                            textdisp = textdisp + "S";
                            break;
                    case KEY_T: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "T");
                            textdisp = textdisp + "T";
                            break;
                    case KEY_U: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "U");
                            textdisp = textdisp + "U";
                            break;
                    case KEY_V: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "V");
                            textdisp = textdisp + "V";
                            break;
                    case KEY_W: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "W");
                            textdisp = textdisp + "W";
                            break;
                    case KEY_X: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "X");
                            textdisp = textdisp + "X";
                            break;
                    case KEY_Y: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "Y");
                            textdisp = textdisp + "Y";
                            break;
                    case KEY_Z: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "Z");
                            textdisp = textdisp + "Z";
                            break;
                    case KEY_SPACE: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + " ");
                            textdisp = textdisp + " ";
                            break;
                    case KEY_NEXT: 
                            WhereToView.jPanelKeyBoard.removeAll();
                            whereToPanel.jPanelKeyBoard.repaint();
                            whereToPanel.jPanelKeyBoard.revalidate();
                    
                            whereToPanel.jPanelKeyBoard.add(whereToPanel.jPanelKeyPrev);
                            whereToPanel.jPanelKeyBoard.repaint();
                            whereToPanel.jPanelKeyBoard.revalidate();
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            
                            keys = Keys.KEY_PREV;
                            
                            break;
            
                    case KEY_SUB1: 
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            route.clear();
                            if(submitClicked == false){
                                String s0 ="50.735459,-3.533207";
                                String s1 ="CATHEDRAL GREEN EXETER";
                    
            
                                
                            try {
                                displayOdem(s0,s1);
                                movingTimeIncease();
                                displaySpeed();
                                System.out.println(textdisp);
                                
                                findInstruction(s0,textdisp);
                                
                                submitClicked = true;
                                textdisp = "";
                                whereToPanel.jTextFieldDestination.setText(textdisp);
                            } catch (JSONException ex) {
                                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                            }
                              
                            System.out.println(route);
                                    
                        
                        
                            }
                            else{
                                odometer = "0 KM";
                                tripComputerPanel.odemDisplay.setText(odometer);
                                t = 0;
                                String s0 ="50.735459,-3.533207";
                                String s1 ="50.722932 -3.530193";
                    
            
                                {   
                                    try {
                                        displayOdem(s0,textdisp);
                                        System.out.println(textdisp);
                                
                                        findInstruction(s0,textdisp);
                                
                                        textdisp = "";
                                        whereToPanel.jTextFieldDestination.setText(textdisp);
                                    } catch (JSONException ex) {
                                        Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                System.out.println(route);
                        
                            }
                            
                            break;
                    
            //numeric keyboard
                    case KEY_ONE: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "1");
                            textdisp = textdisp + "1";
                            break;
                    case KEY_TWO: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "2");
                            textdisp = textdisp + "2";
                            break;
                    case KEY_THREE: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "3");
                            textdisp = textdisp + "3";
                            break;
                    case KEY_FOUR: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "4");
                            textdisp = textdisp + "4";
                            break;
                    case KEY_FIVE: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "5");
                            textdisp = textdisp + "5";
                            break;
                    case KEY_SIX: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "6");
                            textdisp = textdisp + "6";
                            break;
                    case KEY_SEVEN: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "7");
                            textdisp = textdisp + "7";
                            break;
                    case KEY_EIGHT: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "8");
                            textdisp = textdisp + "8";
                            break;
                    case KEY_NINE: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "9");
                            textdisp = textdisp + "9";
                            break;
                    case KEY_ZERO: 
                            whereToPanel.jTextFieldDestination.setText(textdisp + "0");
                            textdisp = textdisp + "0";
                            break;
                    case KEY_DELETE: 
                            textdisp = textdisp.substring(0, textdisp.length()-1);
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            break;
                    case KEY_PREV: 
                            whereToPanel.jPanelKeyBoard.removeAll();
                            whereToPanel.jPanelKeyBoard.repaint();
                            whereToPanel.jPanelKeyBoard.revalidate();
                    
                            whereToPanel.jPanelKeyBoard.add(whereToPanel.jPanelKeyNext);
                            whereToPanel.jPanelKeyBoard.repaint();
                            whereToPanel.jPanelKeyBoard.revalidate();
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                    
                            keys = Keys.KEY_NEXT;
                            break;
                    
                    case KEY_SUB2:
                            whereToPanel.jTextFieldDestination.setText(textdisp);
                            route.clear();
                            if(submitClicked == false){
                                String s0 ="50.735459,-3.533207";
                                String s1 ="CATHEDRAL GREEN EXETER";
                    
            
                                
                            try {
                                displayOdem(s0,s1);
                                movingTimeIncease();
                                displaySpeed();
                                System.out.println(textdisp);
                                
                                findInstruction(s0,textdisp);
                                
                                submitClicked = true;
                                textdisp = "";
                                whereToPanel.jTextFieldDestination.setText(textdisp);
                            } catch (JSONException ex) {
                                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                            }
                              
                            System.out.println(route);
                                    
                        
                        
                            }
                            else{
                                odometer = "0 KM";
                                tripComputerPanel.odemDisplay.setText(odometer);
                                t = 0;
                                String s0 ="50.735459,-3.533207";
                                String s1 ="50.722932 -3.530193";
                    
            
                                {   
                                    try {
                                        displayOdem(s0,textdisp);
                                        System.out.println(textdisp);
                                
                                        findInstruction(s0,textdisp);
                                
                                        textdisp = "";
                                        whereToPanel.jTextFieldDestination.setText(textdisp);
                                    } catch (JSONException ex) {
                                        Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                System.out.println(route);
                            } 
                            break;
                }
                screenPanel.repaint();
                screenPanel.revalidate();
                }
        }
    }
    public String  getPosition(){
        String position = "" + latitude + longitude;
        return position;
    }
    
    public void movingTimeIncease(){
        
        Thread time = new Thread(){
        public void run(){
        for(;;){
            String str_s = Integer.toString(second);
            String str_m = Integer.toString(minute);
            String str_h = Integer.toString(hour);
            tripComputerPanel.timeDisplay.setText(str_h+"Hour    "+str_m+"Min    "+str_s+"Sec");
            try{sleep(1000);}catch(InterruptedException e){}
            
            second++;
            if(second==60){
                minute++;
                second = 0;
            }
            if(minute==60){
                hour++;
                minute = 0;
            }
        }
        }
        };
        time.start();
    }
    
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
            } catch ( Exception ex ) {System.out.println( ex ); System.exit( 1 ); return null;}
    }
    
    
    public String calculateOdem(String start,String end)throws JSONException{
        byte[] directions = readDirections(start,end);
        String s = new String(directions);
        JSONObject obj = new JSONObject(s);
        JSONArray routes = (JSONArray) obj.getJSONArray("routes");
        JSONObject child1 = (JSONObject) routes.getJSONObject(0);
        JSONArray legs = (JSONArray) child1.getJSONArray("legs");
        JSONObject child2 = (JSONObject) legs.getJSONObject(0);
        JSONObject distance = (JSONObject) child2.get("distance");
        String dis = distance.getString("text");
        return dis;
    }
    
    
    
    public void displayOdem(String start,String end)throws JSONException{
        String odem = calculateOdem(start,end);
        odometer = odem;
        tripComputerPanel.odemDisplay.setText(odometer);
        
    }
    
    public void displaySpeed(){
        
        Thread speed = new Thread(){
            public void run(){
               for(;;){
                   
                   try{sleep(1000);}catch(InterruptedException e){}
                   
                   t++;
                   
                   String pureSpeed = odometer.substring(0,odometer.length()-3);
                   Double distanceValue = Double.parseDouble(pureSpeed);
                   Double speedValue = distanceValue/t*3600;
                   String speedInKmh = Double.toString(speedValue) + "   KM/H";
                   
                   tripComputerPanel.speedDisplay.setText(speedInKmh);
               
               
               }
            
            }
        };
        
        speed.start();
        
        //speedDisplay.setText("");
    }
    
    public void findInstruction(String s1,String s2) throws JSONException{
        String s = new String(readDirections(s1, s2));
        System.out.println(s);
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
            String lat = Double.toString(end_location.getDouble("lat"));
            String lng = Double.toString(end_location.getDouble("lng"));
            String location = lat+","+lng;
            
            //instruction
            String html_instruction = StringEscapeUtils.unescapeJava(step.getString("html_instructions"));
            String instruction = Jsoup.parse(html_instruction).text();
            
            //add map
            route.put(location,instruction);
        }
    }
            
            
            
            
            
        
            
       
    
}
