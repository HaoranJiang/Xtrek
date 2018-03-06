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
public class SatelliteView extends JPanel implements Observer{
    private final SatelliteModel model;
    public SatelliteView(SatelliteController controller, SatelliteModel model){
        this.model = model;
        model.addObserver(this);
    }
   

    @Override
    public void update(Observable o, Object arg) {
       if (model ==o){
           if (SatelliteModel.signal == true){                          // data available
                Font f = new Font("MS Reference San Serif",Font.BOLD,18);
                XtrekUI.Latitude.setText("Latitude: "+round(Math.abs(SatelliteModel.latitude),4)+" , "+SatelliteModel.dOLatitude);          
                XtrekUI.Latitude.setFont(f);
                XtrekUI.Latitude.setForeground(Color.green);
                XtrekUI.Longitude.setText("Longitude: "+round(Math.abs(SatelliteModel.longitude),4)+" , "+SatelliteModel.dOLongitude);
                XtrekUI.Longitude.setForeground(Color.green);
                XtrekUI.Longitude.setFont(f);
           }
           else{                                            // no signal
                XtrekUI.Latitude.setText("      No signal!");
                XtrekUI.Latitude.setForeground(Color.red);
                XtrekUI.Longitude.setText("      No signal!"); 
                XtrekUI.Longitude.setForeground(Color.red);
           }
       }
    }
    /* Round a value to certain decimal places */
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }
}
