/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

/**
 *
 * @author veaca
 */
public class AntigaGUI extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 5579447777026975043L;

    /**
     * Creates new form UnitConverter
     */
    public AntigaGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoxConvertFrom = new javax.swing.JComboBox<>();
        BoxTo = new javax.swing.JComboBox<>();
        TextConvertFrom = new javax.swing.JTextField();
        TextTo = new javax.swing.JTextField();
        LabelConvertFrom = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PanelBottom = new javax.swing.JPanel();
        LabelDevs = new javax.swing.JLabel();
        LabelSI400 = new javax.swing.JLabel();
        PanelBottom1 = new javax.swing.JPanel();
        LabelName = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Close = new javax.swing.JMenuItem();
        MenuHelp = new javax.swing.JMenu();
        Help = new javax.swing.JMenuItem();
        Disclaimer = new javax.swing.JMenuItem();
        Credits = new javax.swing.JMenuItem();

        /* 
        BoxConvertFrom = new javax.swing.JComboBox<>();
        BoxTo = new javax.swing.JComboBox<>();
        //TextConvertFrom = new javax.swing.JTextField();
        //TextTo = new javax.swing.JTextField();
        //LabelConvertFrom = new javax.swing.JLabel();
        //jLabel2 = new javax.swing.JLabel();
        //PanelBottom = new javax.swing.JPanel();
        LabelDevs = new javax.swing.JLabel();
        LabelSI400 = new javax.swing.JLabel();
        //PanelBottom1 = new javax.swing.JPanel();
        LabelName = new javax.swing.JLabel();
        //MenuBar = new javax.swing.JMenuBar();
        //MenuFile = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        //Close = new javax.swing.JMenuItem();
        //MenuHelp = new javax.swing.JMenu();
        //Help = new javax.swing.JMenuItem();
        //Disclaimer = new javax.swing.JMenuItem();
        Credits = new javax.swing.JMenuItem();
        */

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        /* From Unity Box */
        BoxConvertFrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        BoxConvertFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centimetre (cm)", "Decametre (dam)", "Decimetre (dm)", "Hectometre (hm)", "Inch (in)", "Kilimetre (km)", "Metre (m)", "Micometre (?m)" }));

        /* To Unity Box */
        BoxTo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        //BoxTo.setModel(new javax.swing.DefaultComboBoxModel<>();

        TextConvertFrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        TextTo.setEditable(false);
        TextTo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        LabelConvertFrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelConvertFrom.setText("ConvertFrom");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("to");

        PanelBottom.setBackground(new java.awt.Color(153, 153, 153));
        PanelBottom.setPreferredSize(new java.awt.Dimension(0, 60));

        LabelDevs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelDevs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDevs.setText("Developed by Ana, Larissa, Verussa and Vinicius");

        LabelSI400.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelSI400.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSI400.setText("Project developed for the SI400 discipline at the Faculdade de Tecnologia taught by André F. de Angelis");

        javax.swing.GroupLayout PanelBottomLayout = new javax.swing.GroupLayout(PanelBottom);
        PanelBottom.setLayout(PanelBottomLayout);
        PanelBottomLayout.setHorizontalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelDevs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelSI400, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelBottomLayout.setVerticalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBottomLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(LabelSI400, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelDevs, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelBottom1.setBackground(new java.awt.Color(153, 153, 153));
        PanelBottom1.setPreferredSize(new java.awt.Dimension(0, 60));

        LabelName.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        LabelName.setText("UnitConverter");

        javax.swing.GroupLayout PanelBottom1Layout = new javax.swing.GroupLayout(PanelBottom1);
        PanelBottom1.setLayout(PanelBottom1Layout);
        PanelBottom1Layout.setHorizontalGroup(
            PanelBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBottom1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelName)
                .addGap(190, 190, 190))
        );
        PanelBottom1Layout.setVerticalGroup(
            PanelBottom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBottom1Layout.createSequentialGroup()
                .addComponent(LabelName)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        MenuFile.setText("File");

        jMenuItem2.setText("jMenuItem2");
        MenuFile.add(jMenuItem2);
        MenuFile.add(jSeparator1);

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        MenuFile.add(Close);

        MenuBar.add(MenuFile);

        MenuHelp.setText("Help");

        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });
        MenuHelp.add(Help);

        Disclaimer.setText("Disclaimer");
        MenuHelp.add(Disclaimer);

        Credits.setText("Credits");
        MenuHelp.add(Credits);

        MenuBar.add(MenuHelp);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            .addComponent(PanelBottom1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelConvertFrom)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BoxConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelBottom1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelConvertFrom)
                    .addComponent(TextConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoxConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(PanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void exec() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AntigaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntigaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntigaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntigaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntigaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxConvertFrom;
    private javax.swing.JComboBox<String> BoxTo;
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Credits;
    private javax.swing.JMenuItem Disclaimer;
    private javax.swing.JMenuItem Help;
    private javax.swing.JLabel LabelConvertFrom;
    private javax.swing.JLabel LabelDevs;
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel LabelSI400;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuHelp;
    private javax.swing.JPanel PanelBottom;
    private javax.swing.JPanel PanelBottom1;
    private javax.swing.JTextField TextConvertFrom;
    private javax.swing.JTextField TextTo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}