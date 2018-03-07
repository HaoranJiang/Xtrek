
package MVC;

import MVC.Model;
import MVC.Controller;
import static MVC.Model.situation;
import static MVC.Model.menu;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 *  View
 * 
 * @author Haoran Jiang 2018.
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     * @param model
     * @param controller
     */
    public View(Model model, Controller controller) {
        initComponents();
        
        onButton.addActionListener((ActionListener) controller);
        upButton.addActionListener((ActionListener) controller);
        downButton.addActionListener((ActionListener) controller);
        selectButton.addActionListener((ActionListener) controller);
        menuButton.addActionListener((ActionListener) controller);
        TSPanel = new SatellitePanel();
        aboutPanel = new AboutModePanel();
        whereToPanel = new WhereToView();
        tripComputerPanel = new TripComputerView();
        screenPanel.add(TSPanel,"card 7");
        screenPanel.add(aboutPanel,"card15");
        screenPanel.add(whereToPanel,"card16");
        screenPanel.add(tripComputerPanel,"card18");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upButton = new javax.swing.JButton();
        onButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();
        menuButton = new javax.swing.JButton();
        screenPanel = new javax.swing.JPanel();
        offPanel = new javax.swing.JPanel();
        menu1Panel = new javax.swing.JPanel();
        menu1 = new javax.swing.JLabel();
        menu2Panel = new javax.swing.JPanel();
        menu2 = new javax.swing.JLabel();
        menu3Panel = new javax.swing.JPanel();
        menu3 = new javax.swing.JLabel();
        menu4Panel = new javax.swing.JPanel();
        menu4 = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        menu5 = new javax.swing.JLabel();
        menu6Panel = new javax.swing.JPanel();
        menu6 = new javax.swing.JLabel();
        mapPanel = new javax.swing.JPanel();
        jEditorPane1 = new javax.swing.JEditorPane();
        speechPanel = new javax.swing.JPanel();
        smenu1Panel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        smenu2Panel = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        smenu3Panel = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        smenu4Panel = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        smenu5Panel = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        smenu6Panel = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/up.PNG"))); // NOI18N
        upButton.setBorder(null);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 74, 46, 55));

        onButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/on.PNG"))); // NOI18N
        onButton.setBorder(null);
        onButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonActionPerformed(evt);
            }
        });
        getContentPane().add(onButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, 60));

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/down.PNG"))); // NOI18N
        downButton.setBorder(null);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 131, 44, 53));

        selectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/select.PNG"))); // NOI18N
        selectButton.setBorder(null);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(selectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, 50, 71));

        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/back.PNG"))); // NOI18N
        menuButton.setBorder(null);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 81, 43, 74));

        screenPanel.setBackground(new java.awt.Color(255, 255, 255));
        screenPanel.setLayout(new java.awt.CardLayout());

        offPanel.setBackground(new java.awt.Color(0, 0, 0));
        screenPanel.add(offPanel, "card3");

        menu1Panel.setBackground(new java.awt.Color(255, 255, 255));
        menu1Panel.setRequestFocusEnabled(false);

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu1.PNG"))); // NOI18N

        javax.swing.GroupLayout menu1PanelLayout = new javax.swing.GroupLayout(menu1Panel);
        menu1Panel.setLayout(menu1PanelLayout);
        menu1PanelLayout.setHorizontalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu1PanelLayout.setVerticalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu1Panel, "card4");
        menu1Panel.getAccessibleContext().setAccessibleDescription("");

        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu2.PNG"))); // NOI18N

        javax.swing.GroupLayout menu2PanelLayout = new javax.swing.GroupLayout(menu2Panel);
        menu2Panel.setLayout(menu2PanelLayout);
        menu2PanelLayout.setHorizontalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu2PanelLayout.setVerticalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu2Panel, "card4");

        menu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu3.PNG"))); // NOI18N

        javax.swing.GroupLayout menu3PanelLayout = new javax.swing.GroupLayout(menu3Panel);
        menu3Panel.setLayout(menu3PanelLayout);
        menu3PanelLayout.setHorizontalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu3PanelLayout.setVerticalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu3Panel, "card5");

        menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu4.PNG"))); // NOI18N

        javax.swing.GroupLayout menu4PanelLayout = new javax.swing.GroupLayout(menu4Panel);
        menu4Panel.setLayout(menu4PanelLayout);
        menu4PanelLayout.setHorizontalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu4PanelLayout.setVerticalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu4Panel, "card5");

        menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu5.PNG")));

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu5Panel, "card5");

        menu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/menu6.PNG"))); // NOI18N

        javax.swing.GroupLayout menu6PanelLayout = new javax.swing.GroupLayout(menu6Panel);
        menu6Panel.setLayout(menu6PanelLayout);
        menu6PanelLayout.setHorizontalGroup(
            menu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu6PanelLayout.setVerticalGroup(
            menu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu6Panel, "card5");

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jEditorPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
            .addGroup(mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jEditorPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        );

        screenPanel.add(mapPanel, "card5");

        speechPanel.setLayout(new java.awt.CardLayout());

        jLabel8.setAlignmentX(4.0F);
        jLabel8.setAlignmentY(2.0F);

        javax.swing.GroupLayout smenu1PanelLayout = new javax.swing.GroupLayout(smenu1Panel);
        smenu1Panel.setLayout(smenu1PanelLayout);
        smenu1PanelLayout.setHorizontalGroup(
            smenu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
        );
        smenu1PanelLayout.setVerticalGroup(
            smenu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
        );

        speechPanel.add(smenu1Panel, "card2");

        javax.swing.GroupLayout smenu2PanelLayout = new javax.swing.GroupLayout(smenu2Panel);
        smenu2Panel.setLayout(smenu2PanelLayout);
        smenu2PanelLayout.setHorizontalGroup(
            smenu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smenu2PanelLayout.createSequentialGroup()
                .addComponent(jLabel57)
                .addGap(0, 203, Short.MAX_VALUE))
        );
        smenu2PanelLayout.setVerticalGroup(
            smenu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        speechPanel.add(smenu2Panel, "card3");

        javax.swing.GroupLayout smenu3PanelLayout = new javax.swing.GroupLayout(smenu3Panel);
        smenu3Panel.setLayout(smenu3PanelLayout);
        smenu3PanelLayout.setHorizontalGroup(
            smenu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel58)
        );
        smenu3PanelLayout.setVerticalGroup(
            smenu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smenu3PanelLayout.createSequentialGroup()
                .addComponent(jLabel58)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        speechPanel.add(smenu3Panel, "card4");

        javax.swing.GroupLayout smenu4PanelLayout = new javax.swing.GroupLayout(smenu4Panel);
        smenu4Panel.setLayout(smenu4PanelLayout);
        smenu4PanelLayout.setHorizontalGroup(
            smenu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel59)
        );
        smenu4PanelLayout.setVerticalGroup(
            smenu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smenu4PanelLayout.createSequentialGroup()
                .addComponent(jLabel59)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        speechPanel.add(smenu4Panel, "card5");

        javax.swing.GroupLayout smenu5PanelLayout = new javax.swing.GroupLayout(smenu5Panel);
        smenu5Panel.setLayout(smenu5PanelLayout);
        smenu5PanelLayout.setHorizontalGroup(
            smenu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60)
        );
        smenu5PanelLayout.setVerticalGroup(
            smenu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smenu5PanelLayout.createSequentialGroup()
                .addComponent(jLabel60)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        speechPanel.add(smenu5Panel, "card6");

        javax.swing.GroupLayout smenu6PanelLayout = new javax.swing.GroupLayout(smenu6Panel);
        smenu6Panel.setLayout(smenu6PanelLayout);
        smenu6PanelLayout.setHorizontalGroup(
            smenu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61)
        );
        smenu6PanelLayout.setVerticalGroup(
            smenu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smenu6PanelLayout.createSequentialGroup()
                .addComponent(jLabel61)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        speechPanel.add(smenu6Panel, "card7");

        screenPanel.add(speechPanel, "card13");

        getContentPane().add(screenPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 203, 245));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/blank.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 360, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed

    }//GEN-LAST:event_upButtonActionPerformed

    private void onButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onButtonActionPerformed

    }//GEN-LAST:event_onButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        
    }//GEN-LAST:event_downButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
      
    }//GEN-LAST:event_selectButtonActionPerformed

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
       
    }//GEN-LAST:event_menuButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton downButton;
    public static javax.swing.JEditorPane jEditorPane1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel57;
    public static javax.swing.JLabel jLabel58;
    public static javax.swing.JLabel jLabel59;
    public static javax.swing.JLabel jLabel60;
    public static javax.swing.JLabel jLabel61;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel mapPanel;
    public static javax.swing.JLabel menu1;
    public static javax.swing.JPanel menu1Panel;
    public static javax.swing.JLabel menu2;
    public static javax.swing.JPanel menu2Panel;
    public static javax.swing.JLabel menu3;
    public static javax.swing.JPanel menu3Panel;
    public static javax.swing.JLabel menu4;
    public static javax.swing.JPanel menu4Panel;
    public static javax.swing.JLabel menu5;
    public static javax.swing.JPanel menu5Panel;
    public static javax.swing.JLabel menu6;
    public static javax.swing.JPanel menu6Panel;
    public static javax.swing.JButton menuButton;
    public static javax.swing.JPanel offPanel;
    public static javax.swing.JButton onButton;
    public static javax.swing.JPanel screenPanel;
    public static javax.swing.JButton selectButton;
    public static javax.swing.JPanel smenu1Panel;
    public static javax.swing.JPanel smenu2Panel;
    public static javax.swing.JPanel smenu3Panel;
    public static javax.swing.JPanel smenu4Panel;
    public static javax.swing.JPanel smenu5Panel;
    public static javax.swing.JPanel smenu6Panel;
    public static javax.swing.JPanel speechPanel;
    public static javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
    public static SatellitePanel TSPanel;
    public static AboutModePanel aboutPanel;
    public static WhereToView whereToPanel; 
    public static TripComputerView tripComputerPanel;
}