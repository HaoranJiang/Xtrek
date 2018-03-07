package MVC;



/**
 *
 * @author Yukun Sun (Group L WorkPackage 5)
 */
public class AboutModePanel extends javax.swing.JPanel {

    /**
     * Creates new form AboutModePanel
     */
    public AboutModePanel() {
        initComponents();
    }



    private void initComponents() {

        year = new javax.swing.JLabel();
        university = new javax.swing.JLabel();
        XTrek = new javax.swing.JLabel();
        group = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(203, 245));
        setMinimumSize(new java.awt.Dimension(203, 245));
        setPreferredSize(new java.awt.Dimension(203, 245));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        year.setText("(c)2018");
        add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 85, -1));

        university.setText("ECM2415 University of Exeter");
        add(university, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));


        XTrek.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        XTrek.setText("XTrek");
        add(XTrek, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 145, 73));

        group.setText("Group L");
        add(group, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
    }


    // Variables declaration 
    private javax.swing.JLabel XTrek;
    private javax.swing.JLabel group;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel university;
    private javax.swing.JLabel year;
    
}
