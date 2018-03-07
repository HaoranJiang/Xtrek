/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import java.util.Observable; 
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.*;
import java.util.*;
/**
 *
 * @author 20521
 */
enum Keys{KEY_A,KEY_B,KEY_C,KEY_D,KEY_E,KEY_F,KEY_G,KEY_H,KEY_I,KEY_J,KEY_K,KEY_L,KEY_M,KEY_N,KEY_O,
         KEY_P,KEY_Q,KEY_R,KEY_S,KEY_T,KEY_U,KEY_V,KEY_W,KEY_X,KEY_Y,KEY_Z,KEY_SPACE,KEY_NEXT,KEY_SUB1,
         KEY_ONE,KEY_TWO,KEY_THREE,KEY_FOUR,KEY_FIVE,KEY_SIX,KEY_SEVEN,KEY_EIGHT,KEY_NINE,KEY_ZERO,KEY_DELETE,KEY_PREV,KEY_SUB2};




public class WP2Model extends Observable{
    static whereToView wheretoview;
    static tripComputerView tripcomputerview;
    static Keys keys;
    final static String ORIGIN      = "50.7268,-3.5174";
    final static String DESTINATION = "Cathedral Green, Exeter";
    final static String REGION      = "uk";
    final static String MODE        = "walking"; /* "driving" */
    final static String key= "AIzaSyCMMwL7rLUZdfDuB-_X6R11jQ57ZzMN0Xg";
    static String s;
    static String odometer;
    static String moving_time;
    static HashMap<String,String> route = new HashMap<String,String>(20);
            
    public WP2Model(whereToView wheretoview,tripComputerView tripcomputerview,Keys keys){
        this.wheretoview = wheretoview;
        this.keys = keys;
        this.tripcomputerview = tripcomputerview;
        setChanged();
        notifyObservers(wheretoview);
        notifyObservers(key);
    };
    
    
}
