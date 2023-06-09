package ViewEntityTables;


import Log.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 91979
 */
public class ViewProduct extends javax.swing.JFrame {
    private Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private String name;
    private String userType;
    private int id;
    /**
     * Creates new form Admin
     */
    public ViewProduct() {
        initComponents();
        this.con = Login.connection();
        }
    
    public ViewProduct(String name, int id,String userType,Connection con) {
       initComponents();
       jUserId.setText(String.valueOf(id));
       jUserName.setText(name);
       this.con= con;
       this.name = name;
       this.userType = userType;
       this.id=id;
       loadTableAutomatic(userType);
     }
        private void loadTableAutomatic(String userType){
            String sql = "";
            if(userType.equals("Admin")){
                sql = "select * from StoreTable";
            }else if(userType.equals("Receving")){
                 sql = "select * from StoreTable";
            }else if(userType.equals("Quality")){
                 sql = "select * from StoreTable";
            }
            else if(userType.equals("Billing")){
                 sql = "select * from StoreTable";
            }
            else if(userType.equals("Vendor")){
                 sql = "select * from RequestGRN";
            }
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c = rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jtableProduct.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=1;i<=c;i++){
                    v.add(rs.getString("tracking_id"));
                    v.add(rs.getString("Prod_Id"));
                    v.add(rs.getString("Prod_Name"));
                    v.add(rs.getString("Description"));
                    v.add(rs.getString("Costprice"));
                    v.add(rs.getString("RetailPrice"));
                    v.add(rs.getString("Qty"));
                    v.add(rs.getString("Quality"));
                    v.add(rs.getString("vehicleno"));
                    v.add(rs.getString("Reciving"));
                    v.add(rs.getString("Remarks"));
                }
                df.addRow(v);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
        private void loadTable(){
           String sql = "select * from TransferTable";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c = rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jtableProduct.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=1;i<=c;i++){
                    v.add(rs.getString("tracking_id"));
                    v.add(rs.getString("Prod_Id"));
                    v.add(rs.getString("Prod_Name"));
                    v.add(rs.getString("Description"));
                    v.add(rs.getString("Costprice"));
                    v.add(rs.getString("RetailPrice"));
                    v.add(rs.getString("Qty"));
                    v.add(rs.getString("Quality"));
                    v.add(rs.getString("vehicleno"));
                    v.add(rs.getString("Reciving"));
                    v.add(rs.getString("Remarks"));
                }
                df.addRow(v);
            }
        
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
        jbtnProduct = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtableProduct = new javax.swing.JTable();
        jchkTransfer = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("view Products");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("User Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1101, 8, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1101, 37, -1, -1));

        jUserId.setBackground(new java.awt.Color(255, 204, 204));
        jUserId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserId.setForeground(new java.awt.Color(153, 153, 255));
        jUserId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserId.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 8, 131, 17));

        jUserName.setBackground(new java.awt.Color(255, 204, 204));
        jUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserName.setForeground(new java.awt.Color(153, 153, 255));
        jUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1164, 37, 131, 17));

        jbtnProduct.setBackground(new java.awt.Color(153, 204, 255));
        jbtnProduct.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnProduct.setForeground(new java.awt.Color(0, 0, 255));
        jbtnProduct.setText("Back");
        jbtnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProductActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jtableProduct.setBackground(new java.awt.Color(51, 255, 204));
        jtableProduct.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtableProduct.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtableProduct.setForeground(new java.awt.Color(255, 153, 153));
        jtableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TrackID", "Prod_ID", "Prod_Name", "Description", "Costprice", "RetailPrice", "Qty", "Quality", "Vehicle No", "Reciving", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableProduct.setGridColor(new java.awt.Color(102, 255, 255));
        jtableProduct.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jtableProduct.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jtableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableProductjtableProductMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtableProduct);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 104, 1287, 419));

        jchkTransfer.setBackground(new java.awt.Color(51, 51, 255));
        jchkTransfer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jchkTransfer.setText("View TransferTable");
        jchkTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkTransferActionPerformed(evt);
            }
        });
        jPanel1.add(jchkTransfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(783, 66, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("If you want to see Transfer pending ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 8, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Please check in this below check Box");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 37, -1, -1));

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
  private void checkUserType(String name, int id,String userType){
        System.gc();
        this.setVisible(false);
        switch (userType) {
            case "Admin" -> new Users.Admin(name,id,userType,con).setVisible(true);
            case "Receving" -> new Users.Receving(name,id,userType,con).setVisible(true);
            case "Quality" -> new Users.Quality(name,id,userType,con).setVisible(true);
            case "Vendor" -> new Users.Vendor(name,id,userType,con).setVisible(true);
            case "Billing" -> new Users.Billing(name,id,userType,con).setVisible(true);
            default -> JOptionPane.showMessageDialog(this, "Something went wrong");
        }
    }
    private void jbtnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProductActionPerformed
       checkUserType(name,id,userType);
    }//GEN-LAST:event_jbtnProductActionPerformed

    private void jtableProductjtableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableProductjtableProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtableProductjtableProductMouseClicked

    private void jchkTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkTransferActionPerformed
       if(jchkTransfer.isSelected()){
           loadTable();
       }else{
           loadTableAutomatic(this.userType);
       }
    }//GEN-LAST:event_jchkTransferActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jUserId;
    private javax.swing.JLabel jUserName;
    private javax.swing.JButton jbtnProduct;
    private javax.swing.JCheckBox jchkTransfer;
    private javax.swing.JTable jtableProduct;
    // End of variables declaration//GEN-END:variables
}
