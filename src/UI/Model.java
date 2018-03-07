package UI;
import UI.Situation;
import UI.Menu;
import UI.View;
import static UI.View.aboutPanel;
import static UI.View.mapPanel;
import static UI.View.menu1Panel;
import static UI.View.menu2Panel;
import static UI.View.menu3Panel;
import static UI.View.menu4Panel;
import static UI.View.menu5Panel;
import static UI.View.menu6Panel;
import static UI.View.offPanel;
import static UI.View.screenPanel;
import static UI.View.speechPanel;
import static UI.View.tripComputerPanel;
import static UI.View.whereToPanel;
import static UI.XtrekUI.TSPanel;

import java.util.Observable;

/**
 *
 * Model.
 * 
 * @author Haoran Jiang 2018.
 */


public class Model extends Observable{
    static Menu menu;
    static Situation situation;
    
    /**
     *
     * @param menu
     * @param situation
     */
    public Model(Menu menu, Situation situation){
        this.menu = menu;
        this.situation = situation;
    }
    
    public void openAndClose(){
        
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate(); 
        if (situation == Situation.OFF){  
            screenPanel.add(menu1Panel);
            situation = Situation.MENU;
            
        } else {         
            situation = Situation.OFF;
            screenPanel.add(offPanel);
        }
        
        menu = Menu.ONE;
        screenPanel.repaint();
        screenPanel.revalidate();
        
    }
    
    public void goUp(){
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate(); 
        
        if (situation == Situation.MENU){
            switch (menu) {
                case ONE:
                    screenPanel.add(menu2Panel);
                    menu = Menu.TWO;
                    break;

                case TWO:
                    screenPanel.add(menu3Panel);
                    menu = Menu.THREE;
                    break;

                case THREE:
                    screenPanel.add(menu4Panel);
                    menu = Menu.FOUR;
                    break;

                case FOUR:
                    screenPanel.add(menu5Panel);
                    menu = Menu.FIVE;
                    break;

                case FIVE:
                    screenPanel.add(menu6Panel);
                    menu = Menu.SIX;
                    break;

                case SIX:
                    screenPanel.add(menu1Panel);
                    menu = Menu.ONE;
                    break;

                default:
                    break;
            }            
            screenPanel.repaint();
            screenPanel.revalidate();
            
        }
    }
    
    public void goDown(){
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate();
        if (situation == Situation.MENU){
            switch (menu) {
                case ONE:
                    screenPanel.add(menu6Panel);
                    menu = Menu.SIX;
                    break;

                case TWO:
                    screenPanel.add(menu1Panel);
                    menu = Menu.ONE;
                    break;

                case THREE:
                    screenPanel.add(menu2Panel);
                    menu = Menu.TWO;
                    break;

                case FOUR:
                    screenPanel.add(menu3Panel);
                    menu = Menu.THREE;
                    break;

                case FIVE:
                    screenPanel.add(menu4Panel);
                    menu = Menu.FOUR;
                    break;

                case SIX:
                    screenPanel.add(menu5Panel);
                    menu = Menu.FIVE;
                    break;

                default:
                    break;
            }   
            screenPanel.removeAll();
            screenPanel.repaint();
            screenPanel.revalidate();
        }   
    }
    
    public void backMenu(){
        if (situation != Situation.MENU && situation != Situation.OFF) {
            situation = Situation.MENU;
            
            screenPanel.removeAll();
            screenPanel.repaint();
            screenPanel.revalidate();
            
        // add panel
            switch (menu) {
                case ONE:
                    screenPanel.add(menu1Panel);
                    break;
                    
                case TWO:
                    screenPanel.add(menu2Panel);
                    break;
                    
                case THREE:
                    screenPanel.add(menu3Panel);
                    break;
                    
                case FOUR:
                    screenPanel.add(menu4Panel);
                    break;
                    
                case FIVE:
                    screenPanel.add(menu5Panel);
                    break;
                    
                case SIX:
                    screenPanel.add(menu6Panel);
                    break;
                    
                default:
                    break;
            }
            screenPanel.repaint();
            screenPanel.revalidate();
        }
        
    }
    
    public void select(){
        if (null != situation) // TODO add your handling code here:
        switch (situation) {
            case MENU:
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                switch (menu) {
                    case ONE:
                        screenPanel.add(whereToPanel);
                        situation = Situation.WHERETO;
                        break;

                    case TWO:
                        screenPanel.add(tripComputerPanel);
                        situation = Situation.TRIPCOMPUTER;
                        break;

                    case THREE:
                        screenPanel.add(mapPanel);
                        situation = Situation.MAP;
                        break;

                    case FOUR:
                        screenPanel.add(speechPanel);
                        situation = Situation.SPEECH;
                        break;

                    case FIVE:
                        screenPanel.add(TSPanel);
                        situation = Situation.SATELLITE;
                        break;

                    case SIX:
                        screenPanel.add(aboutPanel);
                        situation = Situation.ABOUTME;
                        break;

                    default:
                        break;
            }
        }
    }
    
}
