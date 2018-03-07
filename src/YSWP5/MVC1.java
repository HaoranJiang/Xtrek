/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YSWP5;

import javax.swing.JFrame;

/**
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class MVC1 {
    public static void main(String[] argv){
        
        SatellitePanel view = new SatellitePanel();
        MVC.Model model = new MVC.Model();
        SatelliteController controller = new SatelliteController(model,view);          
        controller.connect();

        
        
        JFrame jframe = new JFrame();
        jframe.add(view);
        jframe.pack();
        jframe.setVisible(true);
        
        
        
      
    }
}
