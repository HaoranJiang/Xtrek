package MVC;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * @MVC - view. Display latitude/longitude/time. Refreshed by controller.
 * @author - Yukun Sun (Group L WorkPackage 5)
 */
public class SatellitePanel extends javax.swing.JPanel {

    public SatellitePanel(){ initComponents();}


    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        latitude = new javax.swing.JTextField();
        longitude = new javax.swing.JTextField();


        setMaximumSize(new java.awt.Dimension(203, 245));
        setMinimumSize(new java.awt.Dimension(203, 245));
        setPreferredSize(new java.awt.Dimension(203, 245));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        latitude.setEditable(false);
        latitude.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        latitude.setBorder(null);
        add(latitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200,70));

        longitude.setEditable(false);
        longitude.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        longitude.setBorder(null);
        add(longitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 70));


    }
    /**
     * @param signal signal of the port
     * @param latitude latitude
     * @param dOLatitude direction of latitude
     * @param longitude  longitude
     * @param dOLongitude direction of longitude
     * @param connected connected to the USB
     * @function update position in view 
     * @case 1 - if both signal and connected are false, display not connected
     * @case 2 - if connected is true, signal is false, display no signal
     * @case 3 - if both signal and connected are true, display position
     */   
    public static void updateView(boolean signal,double latitude,char dOLatitude,double longitude,
            char dOLongitude,boolean connected){

        if( signal == true ){                           // connected and have signal
            SatellitePanel.latitude.setText(round(Math.abs(latitude),4)+"  "+dOLatitude); // round output view into 4 decimals and take the absolute value
            SatellitePanel.longitude.setText(" "+round(Math.abs(longitude),4)+"  "+dOLongitude);   
            SatellitePanel.latitude.setFont(new Font("Arial", Font.BOLD, 40));
            SatellitePanel.longitude.setFont(new Font("Arial", Font.BOLD, 40));
            SatellitePanel.latitude.setForeground(Color.black);
            SatellitePanel.longitude.setForeground(Color.black);   
        }     
        else if (connected == true){                      // connected but no signal
            SatellitePanel.latitude.setText(" Cannot determine position!");
            SatellitePanel.longitude.setText("  No signal!");
            SatellitePanel.latitude.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            SatellitePanel.longitude.setFont(new Font("Trebuchet MS", Font.BOLD, 36));
            SatellitePanel.latitude.setForeground(Color.red);
            SatellitePanel.longitude.setForeground(Color.red);   
        }
        else{                                            // not connected
            SatellitePanel.latitude.setText(" Cannot determine position!");
            SatellitePanel.longitude.setText(" Not connected!");
            SatellitePanel.latitude.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
            SatellitePanel.longitude.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
            SatellitePanel.latitude.setForeground(Color.red);
            SatellitePanel.longitude.setForeground(Color.red);             
        }
    }
    /**
     * @ helper function - Round a value to certain decimal places 
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }

    // Variables declaration
    static javax.swing.JTextField latitude;
    static javax.swing.JTextField longitude;




    


   
}
