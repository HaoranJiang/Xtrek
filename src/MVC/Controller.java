package MVC;



import static MVC.View.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Override
    /*
    method can help to link right method with right button
    */
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
            try {
                model.select();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
         } //To change body of generated methods, choose Tools | Templates.
    }
}