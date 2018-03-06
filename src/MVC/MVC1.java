/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javax.swing.JFrame;

/**
 *
 * @author harry
 */
public class MVC1 {
    public static void main(String[] argv){

        SatelliteModel model = new SatelliteModel();
        SatelliteController controller = new SatelliteController(model);
        SatellitePanel view = new SatellitePanel(controller,model);
       SatelliteController.connect();
        
        JFrame jframe = new JFrame();
        jframe.add(view);
        jframe.pack();
        jframe.setVisible(true);
        
      
    }
}
