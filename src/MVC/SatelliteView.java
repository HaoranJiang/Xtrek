/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import UI.XtrekUI;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class SatelliteView extends JPanel {
   
    public SatelliteView(){
 
    }
   


    /* Round a value to certain decimal places */
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }
}
