package Users;


import Log.Login;
import Process.ConfirmRetailerRequirements;
import Process.RequestRequerments;
import ViewEntityTables.ViewRequerments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 91979
 */
public class Retailers extends javax.swing.JFrame {
    private Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private String name;
    private String userType;
    private int id;
    /**
     * Creates new form Admin
     */
    public Retailers() {
        initComponents();
        this.con = Login.connection();
    }
    
    public Retailers(String name, int id,String userType,Connection con) {
        initComponents();
        jUserId.setText(String.valueOf(id));
        jUserName.setText(name);
        this.con= con;
        this.name = name;
        this.userType = userType; 
        this.id=id;
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jUserId = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jbtnRequest = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jbtnStatus = new javax.swing.JButton();
        jbtnConfirm = new javax.swing.JButton();
        jbtnConfirm1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Retailer Page");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("User Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Name");

        jUserId.setBackground(new java.awt.Color(255, 204, 204));
        jUserId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserId.setForeground(new java.awt.Color(153, 153, 255));
        jUserId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserId.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jUserName.setBackground(new java.awt.Color(255, 204, 204));
        jUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserName.setForeground(new java.awt.Color(153, 153, 255));
        jUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbtnRequest.setBackground(new java.awt.Color(153, 204, 255));
        jbtnRequest.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnRequest.setForeground(new java.awt.Color(0, 0, 255));
        jbtnRequest.setText("Request RequerMents");
        jbtnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRequestActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jbtnStatus.setBackground(new java.awt.Color(153, 204, 255));
        jbtnStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnStatus.setForeground(new java.awt.Color(0, 0, 255));
        jbtnStatus.setText("Status");
        jbtnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStatusActionPerformed(evt);
            }
        });

        jbtnConfirm.setBackground(new java.awt.Color(153, 204, 255));
        jbtnConfirm.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnConfirm.setForeground(new java.awt.Color(0, 0, 255));
        jbtnConfirm.setText("Confirm");
        jbtnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmActionPerformed(evt);
            }
        });

        jbtnConfirm1.setBackground(new java.awt.Color(153, 204, 255));
        jbtnConfirm1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnConfirm1.setForeground(new java.awt.Color(0, 0, 255));
        jbtnConfirm1.setText("View Sent Material");
        jbtnConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirm1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtnConfirm1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRequest)
                    .addComponent(jbtnStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnConfirm1)
                    .addComponent(jbtnConfirm))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.gc();
        this.setVisible(false);
        new Log.Login(con).setVisible(true); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRequestActionPerformed
        System.gc();
        this.setVisible(false);
        new RequestRequerments(name,id,userType,con).setVisible(true);
    }//GEN-LAST:event_jbtnRequestActionPerformed
    
    private void jbtnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStatusActionPerformed
        System.gc();
        this.setVisible(false);
        new ViewRequerments(name,id,userType,con,"View").setVisible(true);
    }//GEN-LAST:event_jbtnStatusActionPerformed

    private void jbtnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmActionPerformed
        System.gc();
        this.setVisible(false);
        new ConfirmRetailerRequirements(name,id,userType,con,"Confirm").setVisible(true); 
    }//GEN-LAST:event_jbtnConfirmActionPerformed

    private void jbtnConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirm1ActionPerformed
        System.gc();
        this.setVisible(false);
        new ConfirmRetailerRequirements(name,id,userType,con,"View").setVisible(true);
    }//GEN-LAST:event_jbtnConfirm1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Retailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retailers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retailers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jUserId;
    private javax.swing.JLabel jUserName;
    private javax.swing.JButton jbtnConfirm;
    private javax.swing.JButton jbtnConfirm1;
    private javax.swing.JButton jbtnRequest;
    private javax.swing.JButton jbtnStatus;
    // End of variables declaration//GEN-END:variables
}