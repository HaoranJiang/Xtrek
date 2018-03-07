/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Menu;
import UI.Situation;
import javax.swing.JFrame;
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
        

        
        view.setVisible( true );
        
    }
    
}
