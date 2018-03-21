package MVC;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * About mode panel. Added standard picture.
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

        pic = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(203, 245));
        setMinimumSize(new java.awt.Dimension(203, 245));
        setPreferredSize(new java.awt.Dimension(203, 245));
        setLayout(new AbsoluteLayout());

        pic.setSize(203,245);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/about_png.PNG"))); // the sample picture
        add(pic, new AbsoluteConstraints(0, 0, 203, 245));
    }


    // Variables declaration 
    private javax.swing.JLabel pic;
    
}
