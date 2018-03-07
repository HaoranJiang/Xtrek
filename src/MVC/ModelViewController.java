/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import MVC.Model.Menu;
import MVC.Model.Situation;
import static MVC.View.TSPanel;



/**
 *
 * @author Haoran Jiang 2018.
 */
public class ModelViewController {
    private static Menu menu = Menu.ONE;
    private static Situation situation = Situation.OFF;
    
    public static void main( String[] argv ) {
        Model model = new Model(menu, situation);
        Controller controller = new Controller(model);
        View view = new View(model, controller);
        
       SatelliteController SatelliteController = new SatelliteController(model,TSPanel);          
        SatelliteController.connect();
        

        
        view.setVisible( true );
        
    }
    
}
