package MVC;

import static MVC.SpeechPanel.smenu1;
import static MVC.SpeechPanel.smenu2;
import static MVC.SpeechPanel.smenu3;
import static MVC.SpeechPanel.smenu4;
import static MVC.SpeechPanel.smenu5;
import static MVC.SpeechPanel.smenu6;
import static MVC.SpeechPanel.speP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Charles Roberts, 2018.
 */



public class speechModel {
    static SpeechMenuOrder speechMenuOrder;
    

    public speechModel( SpeechMenuOrder speechMenuOrder ){
        speechModel.speechMenuOrder = speechMenuOrder;
    }
    
    public void speechGoUp(){
        //remove panel
            speP.removeAll();
            speP.repaint();
            speP.revalidate();
           switch (speechMenuOrder) {
                case ONE:
                    speP.add(smenu2);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.TWO;
                    break;
                case TWO:
                    speP.add(smenu3);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.THREE;
                    break;
                case THREE:
                    speP.add(smenu4);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.FOUR;
                    break;
                case FOUR:
                    speP.add(smenu5);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.FIVE;
                    break;
                case FIVE:
                    speP.add(smenu6);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.SIX;
                    break;
                case SIX:
                    speP.add(smenu1);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.ONE;
                    break;
                default:
                    break;
        }
    }
    
    /**
     *
     */

    public void speechGoDown(){
            speP.removeAll();
            speP.repaint();
            speP.revalidate();
            switch (speechMenuOrder) {
                case ONE:
                    speP.add(smenu6);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.SIX;
                    break;
                case TWO:
                    speP.add(smenu1);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.ONE;
                    break;
                case THREE:
                    speP.add(smenu2);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.TWO;
                    break;
                case FOUR:
                    speP.add(smenu3);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.THREE;
                    break;
                case FIVE:
                    speP.add(smenu4);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.FOUR;
                    break;
                case SIX:
                    speP.add(smenu5);
                    speP.repaint();
                    speP.revalidate();
                    speechMenuOrder = SpeechMenuOrder.FIVE;
                    break;
                default:
                    break;
    }
        
    }
    
    public void speechSelect(){
        //NewSoundAndSpeech a = new NewSoundAndSpeech();
        switch(speechMenuOrder){
            case TWO:
                try {
                    NewSoundAndSpeech.englishDirectionsReader();
                } catch (Exception e) {
                    ;
                }
                break;
            case THREE:
                try {
                    NewSoundAndSpeech.frenchDirectionsReader();
                } catch (Exception e) {
                    ;
                }
                break;
            case FOUR:
                try {
                    NewSoundAndSpeech.germanDirectionsReader();
                } catch (Exception e) {
                    ;
                }
                break;
            case FIVE:
                try {
                    NewSoundAndSpeech.italianDirectionsReader();
                } catch (Exception e) {
                    ;
                }
                break;
            case SIX:
                 try {
                    NewSoundAndSpeech.spanishDirectionsReader();
                } catch (Exception e) {
                    ;
                }
                break;   
        }
    }
    
}
