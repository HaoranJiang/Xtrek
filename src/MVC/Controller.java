package MVC;


import MVC.Model;
import static MVC.View.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * Controller.
 * 
 * @author Haoran Jiang 2018.
 */
class Controller implements ActionListener{
    private Model model;
    
    public Controller( Model model ){
        this.model = model;
    }
    
    private void onButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        model.openAndClose();
    }        
    
    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        model.goUp();
    }
    
    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        model.goDown();
    }  
    
    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        model.select();
    }
    
    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        model.backMenu();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource()== onButton)
         {
            model.openAndClose();
         }
     else if (evt.getSource()== upButton)
         {
            model.goUp();
         }
     else if (evt.getSource()== downButton)
         {
            model.goDown();
         }
     else if (evt.getSource()== menuButton)
         {
            model.backMenu();
         }
     else if (evt.getSource()== selectButton)
         {
            model.select();
         } //To change body of generated methods, choose Tools | Templates.
    }
}