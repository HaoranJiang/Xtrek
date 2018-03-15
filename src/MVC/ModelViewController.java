/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import static MVC.Model.speechMenu;
import static MVC.View.TSPanel;



/**
 * @author Haoran Jiang 2018.
 */

public class ModelViewController {
    private static Menu menu = Menu.ONE;
    private static Situation situation = Situation.OFF;
    private static Keys keys = Keys.KEY_A;
    private static SpeechMenuOrder speechMenu = SpeechMenuOrder.ONE;
    public static SatelliteController SatController;
    public static void main( String[] argv ) {
        Model model = new Model(menu, situation,keys,speechMenu);
        Controller controller = new Controller(model);
        View view = new View(model, controller);     
        SatController = new SatelliteController(model,TSPanel);          
        
        

        
        view.setVisible( true );
        
    }
    
}
