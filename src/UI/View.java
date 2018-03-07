package UI;

import static UI.Model.situation;
import static UI.Model.menu;
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
     */
    public View(Model model, Controller controller) {
        initComponents();
        
        onButton.addActionListener((ActionListener) controller);
        upButton.addActionListener((ActionListener) controller);
        downButton.addActionListener((ActionListener) controller);
        selectButton.addActionListener((ActionListener) controller);
        menuButton.addActionListener((ActionListener) controller);
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
        jLabel2 = new javax.swing.JLabel();
        menu2Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menu3Panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        menu4Panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        menu5Panel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menu6Panel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        whereToPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        aboutPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
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
        tripComputerPanel = new javax.swing.JPanel();
        tripComputerTime = new javax.swing.JLabel();
        timeDisplay = new javax.swing.JTextField();
        tripComputerOdem = new javax.swing.JLabel();
        odemDisplay = new javax.swing.JTextField();
        tripComputerSpeed = new javax.swing.JLabel();
        speedDisplay = new javax.swing.JTextField();
        TSPanel = new javax.swing.JPanel();
        Latitude = new javax.swing.JTextArea();
        Longitude = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        Time = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/+.PNG"))); // NOI18N
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });
        getContentPane().add(upButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 74, 46, 55));

        onButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Xtrek - 副本 (2).PNG"))); // NOI18N
        onButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonActionPerformed(evt);
            }
        });
        getContentPane().add(onButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, 60));

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/-.PNG"))); // NOI18N
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 131, 44, 53));

        selectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/select.PNG"))); // NOI18N
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(selectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, 50, 71));

        menuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.PNG"))); // NOI18N
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu1.PNG"))); // NOI18N

        javax.swing.GroupLayout menu1PanelLayout = new javax.swing.GroupLayout(menu1Panel);
        menu1Panel.setLayout(menu1PanelLayout);
        menu1PanelLayout.setHorizontalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu1PanelLayout.setVerticalGroup(
            menu1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu1Panel, "card4");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu2.PNG"))); // NOI18N

        javax.swing.GroupLayout menu2PanelLayout = new javax.swing.GroupLayout(menu2Panel);
        menu2Panel.setLayout(menu2PanelLayout);
        menu2PanelLayout.setHorizontalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu2PanelLayout.setVerticalGroup(
            menu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu2Panel, "card4");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu3.PNG"))); // NOI18N

        javax.swing.GroupLayout menu3PanelLayout = new javax.swing.GroupLayout(menu3Panel);
        menu3Panel.setLayout(menu3PanelLayout);
        menu3PanelLayout.setHorizontalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu3PanelLayout.setVerticalGroup(
            menu3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu3Panel, "card5");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu4.PNG"))); // NOI18N

        javax.swing.GroupLayout menu4PanelLayout = new javax.swing.GroupLayout(menu4Panel);
        menu4Panel.setLayout(menu4PanelLayout);
        menu4PanelLayout.setHorizontalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu4PanelLayout.setVerticalGroup(
            menu4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu4Panel, "card5");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu5.PNG"))); // NOI18N

        javax.swing.GroupLayout menu5PanelLayout = new javax.swing.GroupLayout(menu5Panel);
        menu5Panel.setLayout(menu5PanelLayout);
        menu5PanelLayout.setHorizontalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu5PanelLayout.setVerticalGroup(
            menu5PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu5Panel, "card5");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu6.PNG"))); // NOI18N

        javax.swing.GroupLayout menu6PanelLayout = new javax.swing.GroupLayout(menu6Panel);
        menu6Panel.setLayout(menu6PanelLayout);
        menu6PanelLayout.setHorizontalGroup(
            menu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu6PanelLayout.setVerticalGroup(
            menu6PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        screenPanel.add(menu6Panel, "card5");

        whereToPanel.setPreferredSize(new java.awt.Dimension(203, 245));

        jPanel2.setPreferredSize(new java.awt.Dimension(203, 34));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/text.png"))); // NOI18N

        jTextField1.setPreferredSize(new java.awt.Dimension(200, 32));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel12)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(203, 212));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_a.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        jPanel3.add(jPanel5, "card2");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_b.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel4, "card3");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_c.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, "card4");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_d.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel8, "card5");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_e.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel9, "card6");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_f.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel10, "card7");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_g.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel11, "card8");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_h.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel12, "card9");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_i.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel13, "card10");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_j.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel14, "card11");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_k.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel27)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel15, "card12");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_l.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel16, "card13");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_m.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel17, "card14");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_n.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel30)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel30)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel18, "card15");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_o.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel31)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel31)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel19, "card16");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_p.png"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel32)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel32)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel20, "card17");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_q.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel33)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel33)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel21, "card18");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_r.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel34)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel34)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel22, "card19");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_s.png"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel35)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel35)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel23, "card20");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_t.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel36)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel36)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel24, "card21");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_u.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel37)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel37)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel25, "card22");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_v.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel38)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel38)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel26, "card23");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_w.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel39)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel39)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel27, "card24");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_x.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel40)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel40)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel28, "card25");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_y.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel41)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel41)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel29, "card26");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_z.png"))); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel42)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel42)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel30, "card27");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_space.png"))); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel43)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel43)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel31, "card28");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_next.png"))); // NOI18N

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel32Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel44)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel32Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel44)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel32, "card29");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel45)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel45)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel33, "card30");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel46)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel46)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel34, "card31");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel47)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel47)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel35, "card32");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_4.png"))); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel48)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel48)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel36, "card33");

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel49)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel49)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel37, "card34");

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_6.png"))); // NOI18N

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel50)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel50)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel38, "card35");

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel51)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel51)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel39, "card36");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_8.png"))); // NOI18N

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel52)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel52)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel40, "card37");

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_9.png"))); // NOI18N

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel53)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel53)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel41, "card38");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_0.png"))); // NOI18N

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel54)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel54)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel42, "card39");

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_del.png"))); // NOI18N

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel55)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel55)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel43, "card40");

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key_prev.png"))); // NOI18N

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel56)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel56)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel3.add(jPanel44, "card41");

        javax.swing.GroupLayout whereToPanelLayout = new javax.swing.GroupLayout(whereToPanel);
        whereToPanel.setLayout(whereToPanelLayout);
        whereToPanelLayout.setHorizontalGroup(
            whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(whereToPanelLayout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whereToPanelLayout.setVerticalGroup(
            whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
            .addGroup(whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(whereToPanelLayout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 211, Short.MAX_VALUE)))
            .addGroup(whereToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, whereToPanelLayout.createSequentialGroup()
                    .addGap(0, 33, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        screenPanel.add(whereToPanel, "card14");

        aboutPanel.setMaximumSize(new java.awt.Dimension(203, 245));
        aboutPanel.setMinimumSize(new java.awt.Dimension(203, 245));
        aboutPanel.setPreferredSize(new java.awt.Dimension(203, 245));
        aboutPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                aboutPanelMouseMoved(evt);
            }
        });
        aboutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("(c)2018");
        aboutPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("ECM2415 University of Exeter");
        aboutPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 50));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AM.png"))); // NOI18N
        jLabel16.setMaximumSize(new java.awt.Dimension(100, 98));
        jLabel16.setMinimumSize(new java.awt.Dimension(100, 98));
        aboutPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 90, 90));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        jLabel17.setText("   XTrek");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        aboutPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        screenPanel.add(aboutPanel, "card15");

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech1.png"))); // NOI18N
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

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech2.png"))); // NOI18N

        javax.swing.GroupLayout smenu2PanelLayout = new javax.swing.GroupLayout(smenu2Panel);
        smenu2Panel.setLayout(smenu2PanelLayout);
        smenu2PanelLayout.setHorizontalGroup(
            smenu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smenu2PanelLayout.createSequentialGroup()
                .addComponent(jLabel57)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        smenu2PanelLayout.setVerticalGroup(
            smenu2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        speechPanel.add(smenu2Panel, "card3");

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech3.png"))); // NOI18N

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

        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech4.png"))); // NOI18N

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

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech5.png"))); // NOI18N

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

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speech6.png"))); // NOI18N

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

        tripComputerPanel.setPreferredSize(new java.awt.Dimension(203, 245));

        tripComputerTime.setText("moving time");

        timeDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeDisplayActionPerformed(evt);
            }
        });

        tripComputerOdem.setText("trip odem");
        tripComputerOdem.setToolTipText("");

        odemDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odemDisplayActionPerformed(evt);
            }
        });

        tripComputerSpeed.setText("speed");

        speedDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedDisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tripComputerPanelLayout = new javax.swing.GroupLayout(tripComputerPanel);
        tripComputerPanel.setLayout(tripComputerPanelLayout);
        tripComputerPanelLayout.setHorizontalGroup(
            tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tripComputerTime, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(timeDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tripComputerOdem, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(odemDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tripComputerSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(speedDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );
        tripComputerPanelLayout.setVerticalGroup(
            tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tripComputerPanelLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(tripComputerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tripComputerPanelLayout.createSequentialGroup()
                    .addGap(0, 198, Short.MAX_VALUE)
                    .addComponent(timeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tripComputerPanelLayout.createSequentialGroup()
                    .addComponent(tripComputerOdem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 213, Short.MAX_VALUE)))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tripComputerPanelLayout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(odemDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tripComputerPanelLayout.createSequentialGroup()
                    .addContainerGap(83, Short.MAX_VALUE)
                    .addComponent(tripComputerSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(133, Short.MAX_VALUE)))
            .addGroup(tripComputerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tripComputerPanelLayout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addComponent(speedDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        screenPanel.add(tripComputerPanel, "card14");

        TSPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Latitude.setEditable(false);
        Latitude.setColumns(20);
        Latitude.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        Latitude.setRows(5);
        TSPanel.add(Latitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 60));

        Longitude.setEditable(false);
        Longitude.setColumns(20);
        Longitude.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        Longitude.setRows(5);
        TSPanel.add(Longitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("My Location");
        TSPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        Time.setEditable(false);
        Time.setColumns(20);
        Time.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 18)); // NOI18N
        Time.setRows(5);
        TSPanel.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, 30));

        screenPanel.add(TSPanel, "card14");

        getContentPane().add(screenPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 203, 245));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Xtrek - 副本 - 副本.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 360, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void onButton(){
        screenPanel.removeAll();
        screenPanel.repaint();
        screenPanel.revalidate();            
        //add panel
        if (situation == UI.Situation.OFF){
            screenPanel.add(menu1Panel);
            
        } else {
            screenPanel.add(offPanel);
        }
        screenPanel.repaint();
        screenPanel.revalidate();
    }
    
    public void upButton(){
        switch (situation) {
            case MENU:
                // TODO add your handling code here:
                //remove panel
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                //add panel
                // change to menu mode
                switch (menu) {
                    case ONE:
                        screenPanel.add(menu2Panel);
                        break;
                        
                    case TWO:
                        screenPanel.add(menu3Panel);
                        break;
                        
                    case THREE:
                        screenPanel.add(menu4Panel);
                        break;
                        
                    case FOUR:
                        screenPanel.add(menu5Panel);
                        break;
                        
                    case FIVE:
                        screenPanel.add(menu6Panel);
                        break;
                        
                    case SIX:
                        screenPanel.add(menu1Panel);
                        break;
                        
                    default:
                        break;
                }
                screenPanel.repaint();
                screenPanel.revalidate();
                // change to whereTo mode
                break;
        }
    }
    
    public void downButton(){
        
        switch (situation) {
            case MENU:
                // TODO add your handling code here:
                //remove panel
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                //add panel
                // change to menu mode
                switch (menu) {
                    case ONE:
                        screenPanel.add(menu6Panel);
                        break;
                        
                    case TWO:
                        screenPanel.add(menu1Panel);
                        break;
                        
                    case THREE:
                        screenPanel.add(menu2Panel);
                        break;
                        
                    case FOUR:
                        screenPanel.add(menu3Panel);
                        break;
                        
                    case FIVE:
                        screenPanel.add(menu4Panel);
                        break;
                        
                    case SIX:
                        screenPanel.add(menu5Panel);
                        break;
                        
                    default:
                        break;
                }
                screenPanel.repaint();
                screenPanel.revalidate();
                // change to whereTo mode
                break;
        }
    }
    
    public void menuButton(){
        // TODO add your handling code here:
        // this button helps you to back to menu panel
        if (situation != Situation.MENU && situation != Situation.OFF) {
             // TODO add your handling code here:
        //remove panel
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
    
    public void selectButton(){
        if (null != situation) // TODO add your handling code here:
        switch (situation) {
            case MENU:
                screenPanel.removeAll();
                screenPanel.repaint();
                screenPanel.revalidate();
                switch (menu) {
                    case ONE:
                        screenPanel.add(whereToPanel);
                        break;
                        
                    case TWO:
                        screenPanel.add(tripComputerPanel);
                        break;
                        
                    case THREE:
                        screenPanel.add(mapPanel);
                        break;
                        
                    case FOUR:
                        screenPanel.add(speechPanel);
                        break;
                        
                    case FIVE:
                        screenPanel.add(TSPanel);
                        break;
                        
                    case SIX:
                        screenPanel.add(aboutPanel);
                        break;
                        
                    default:
                        break;
                        
                }
                screenPanel.repaint();
                screenPanel.revalidate();
                break;
        }           
    }
    
    private void aboutPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutPanelMouseMoved

    }//GEN-LAST:event_aboutPanelMouseMoved

    private void timeDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeDisplayActionPerformed

    private void odemDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odemDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_odemDisplayActionPerformed

    private void speedDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_speedDisplayActionPerformed

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
    public static javax.swing.JTextArea Latitude;
    public static javax.swing.JTextArea Longitude;
    public static javax.swing.JPanel TSPanel;
    public static javax.swing.JTextArea Time;
    static javax.swing.JPanel aboutPanel;
    static javax.swing.JButton downButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    static javax.swing.JPanel mapPanel;
    static javax.swing.JPanel menu1Panel;
    static javax.swing.JPanel menu2Panel;
    static javax.swing.JPanel menu3Panel;
    static javax.swing.JPanel menu4Panel;
    static javax.swing.JPanel menu5Panel;
    static javax.swing.JPanel menu6Panel;
    static javax.swing.JButton menuButton;
    private javax.swing.JTextField odemDisplay;
    static javax.swing.JPanel offPanel;
    static javax.swing.JButton onButton;
    static javax.swing.JPanel screenPanel;
    static javax.swing.JButton selectButton;
    private javax.swing.JPanel smenu1Panel;
    private javax.swing.JPanel smenu2Panel;
    private javax.swing.JPanel smenu3Panel;
    private javax.swing.JPanel smenu4Panel;
    private javax.swing.JPanel smenu5Panel;
    private javax.swing.JPanel smenu6Panel;
    static javax.swing.JPanel speechPanel;
    private javax.swing.JTextField speedDisplay;
    private javax.swing.JTextField timeDisplay;
    private javax.swing.JLabel tripComputerOdem;
    static javax.swing.JPanel tripComputerPanel;
    private javax.swing.JLabel tripComputerSpeed;
    private javax.swing.JLabel tripComputerTime;
    static javax.swing.JButton upButton;
    static javax.swing.JPanel whereToPanel;
    // End of variables declaration//GEN-END:variables
}