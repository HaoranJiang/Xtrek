package MVC;



/**
 *@MVC - view. Display latitude/longitude/time. Refreshed by controller.
 * @authorYukun Sun (Group L WorkPackage 5)
 */
public class SatellitePanel extends javax.swing.JPanel {

    public SatellitePanel(){ initComponents();}


    @SuppressWarnings("unchecked")
  
    private void initComponents() {

        latitude = new javax.swing.JTextField();
        longitude = new javax.swing.JTextField();
        time = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(203, 245));
        setMinimumSize(new java.awt.Dimension(203, 245));
        setPreferredSize(new java.awt.Dimension(203, 245));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        latitude.setEditable(false);
        latitude.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        latitude.setBorder(null);
        add(latitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 60));

        longitude.setEditable(false);
        longitude.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        longitude.setBorder(null);
        add(longitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 50));

        time.setEditable(false);
        time.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        time.setBorder(null);
        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 200, 40));
    }


    // Variables declaration
    static javax.swing.JTextField latitude;
    static javax.swing.JTextField longitude;
    static javax.swing.JTextField time;



    


   
}
