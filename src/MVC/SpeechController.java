package MVC;

import static MVC.SpeechView.jButton1;
import static MVC.SpeechView.jButton3;
import static MVC.SpeechView.jButton4;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charles Roberts, 2018.
 */
public class SpeechController implements ActionListener {
    private Model model;
    
    public SpeechController( Model model ){
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton3)
        {
            model.goUp();
        }
        else if (e.getSource() == jButton4)
        {
            model.goDown();
        }
        else if (e.getSource() == jButton1)
        {
            try {
                model.select();
            } catch (Exception ex) {
                Logger.getLogger(SpeechController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
