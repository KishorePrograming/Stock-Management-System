package ViewEntityTables;


import Users.*;
import Log.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
public class ViewUsers extends javax.swing.JFrame {
    private Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private String name;
    private String userType;
    private int id;
    private String tId;
    /**
     * Creates new form Admin
     */
    public ViewUsers() {
        initComponents();
        this.con = Login.connection();
      
        insertCountUser();
      
    }
    
    public ViewUsers(String name, int id,String userType,Connection con) {
       initComponents();
       jUserId.setText(String.valueOf(id));
       jUserName.setText(name);
       this.con= con;
       this.name = name;
       this.userType = userType;
       this.id=id;
       userTable();
       insertCountUser();
       jbtnUpdate.setEnabled(false);
       jbtnDelete.setEnabled(false);
       jtxtName.setEditable(false);
       jtxtUserType.setEditable(false);
       jtxtPassword.setEditable(false);
       }
    private void userTable(){
        try {
            pst = con.prepareStatement("select * from Login");
            rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int c = rsm.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)jtableUser.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int i=1;i<=c;i++){
                    v.add(rs.getString("userid"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("usertype"));
                }
                df.addRow(v);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void insertCountUser() {
    try{
    int a = methodInsert("Admin",jAdCount);
    int r =  methodInsert("Receving",jRec);
    int q = methodInsert("Quality",jQual);
    int v = methodInsert("Vendor",jVendor);
    int b = methodInsert("Billing",jBill);
    int re = methodInsert("Retailers",jRetailer);
    int total= a+r+q+v+b+re;
    jTotal.setText(String.valueOf(total)); 
        }catch(Exception e){
           System.out.println(e.getMessage());
        }
  }
    private int methodInsert(String type,JLabel lbl){
    String sql = "Select count(userType) count from Login where userType= ? group by userType";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, type);
            rs = pst.executeQuery();
            rs.next();
            lbl.setText(String.valueOf(Integer.parseInt(rs.getString("count"))));
            return Integer.parseInt(rs.getString("count"));
        } catch (SQLException ex) {
            Logger.getLogger(ViewUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jAdCount = new javax.swing.JLabel();
        jRec = new javax.swing.JLabel();
        jQual = new javax.swing.JLabel();
        jVendor = new javax.swing.JLabel();
        jBill = new javax.swing.JLabel();
        jTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableUser = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtxtName = new javax.swing.JTextField();
        jtxtUserType = new javax.swing.JTextField();
        jbtnUpdate = new javax.swing.JButton();
        jbtnClear = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jtxtPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jRetailer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Admin Page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 19, -1, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("User Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 13, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 42, -1, -1));

        jUserId.setBackground(new java.awt.Color(255, 204, 204));
        jUserId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserId.setForeground(new java.awt.Color(153, 153, 255));
        jUserId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserId.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 13, 131, 17));

        jUserName.setBackground(new java.awt.Color(255, 204, 204));
        jUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserName.setForeground(new java.awt.Color(153, 153, 255));
        jUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 42, 131, 17));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 255));
        jLabel4.setText("Quality Count");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Admin Count");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("Receving Count");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setText("Billing Count");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 255));
        jLabel8.setText("Vendor Count");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 255));
        jLabel10.setText("UserType");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 447, -1, -1));

        jAdCount.setBackground(new java.awt.Color(255, 204, 204));
        jAdCount.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jAdCount.setForeground(new java.awt.Color(153, 153, 255));
        jAdCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAdCount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jAdCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jAdCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 85, 25));

        jRec.setBackground(new java.awt.Color(255, 204, 204));
        jRec.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRec.setForeground(new java.awt.Color(153, 153, 255));
        jRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRec.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 85, 25));

        jQual.setBackground(new java.awt.Color(255, 204, 204));
        jQual.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jQual.setForeground(new java.awt.Color(153, 153, 255));
        jQual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jQual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jQual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jQual, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 85, 25));

        jVendor.setBackground(new java.awt.Color(255, 204, 204));
        jVendor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jVendor.setForeground(new java.awt.Color(153, 153, 255));
        jVendor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jVendor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVendor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 85, 25));

        jBill.setBackground(new java.awt.Color(255, 204, 204));
        jBill.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jBill.setForeground(new java.awt.Color(153, 153, 255));
        jBill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBill.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 85, 25));

        jTotal.setBackground(new java.awt.Color(255, 204, 204));
        jTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTotal.setForeground(new java.awt.Color(153, 153, 255));
        jTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 85, 25));

        jLabel11.setBackground(new java.awt.Color(0, 255, 204));
        jLabel11.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Users counts");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, 40));

        jButton6.setBackground(new java.awt.Color(153, 204, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 8, -1, -1));

        jtableUser.setBackground(new java.awt.Color(51, 255, 204));
        jtableUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtableUser.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtableUser.setForeground(new java.awt.Color(255, 153, 153));
        jtableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Name", "UserType"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableUser.setGridColor(new java.awt.Color(102, 255, 255));
        jtableUser.setSelectionBackground(new java.awt.Color(0, 255, 255));
        jtableUser.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jtableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableUser);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 70, 531, 364));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 255));
        jLabel12.setText("Total======>");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 255));
        jLabel13.setText("Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 370, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 255));
        jLabel14.setText("Password");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 410, -1, -1));

        jtxtName.setBackground(new java.awt.Color(102, 255, 204));
        jtxtName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtName.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(jtxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 369, 154, -1));

        jtxtUserType.setBackground(new java.awt.Color(102, 255, 204));
        jtxtUserType.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtUserType.setForeground(new java.awt.Color(0, 0, 255));
        jtxtUserType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtUserTypeFocusLost(evt);
            }
        });
        jPanel1.add(jtxtUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 446, 154, -1));

        jbtnUpdate.setBackground(new java.awt.Color(153, 204, 255));
        jbtnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnUpdate.setForeground(new java.awt.Color(0, 0, 255));
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 446, -1, -1));

        jbtnClear.setBackground(new java.awt.Color(153, 204, 255));
        jbtnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnClear.setForeground(new java.awt.Color(0, 0, 255));
        jbtnClear.setText("Clear");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 446, -1, -1));

        jbtnDelete.setBackground(new java.awt.Color(153, 204, 255));
        jbtnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnDelete.setForeground(new java.awt.Color(0, 0, 255));
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 446, -1, -1));

        jtxtPassword.setBackground(new java.awt.Color(102, 255, 204));
        jtxtPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtPassword.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 408, 154, 26));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setText("Retilers");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jRetailer.setBackground(new java.awt.Color(255, 204, 204));
        jRetailer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRetailer.setForeground(new java.awt.Color(153, 153, 255));
        jRetailer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jRetailer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jRetailer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jRetailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 85, 25));

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.gc();
        this.setVisible(false);
        new Admin(name,id,userType,con).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jtableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableUserMouseClicked
       DefaultTableModel df = (DefaultTableModel)jtableUser.getModel();
       int selectIndex = jtableUser.getSelectedRow();
       String name1=df.getValueAt(selectIndex, 1).toString();
       jtxtName.setText(name1);
       String usertype = df.getValueAt(selectIndex, 2).toString();
       jtxtUserType.setText(usertype);
       tId = df.getValueAt(selectIndex, 0).toString();
       try{
       String sql = "select (password) from Login where userid=? and name = ? and usertype = ?";    
       pst = con.prepareStatement(sql);
       pst.setString(1, tId);
       pst.setString(2, name1);
       pst.setString(3, usertype);
       rs = pst.executeQuery();
       boolean check = rs.next();
       if(check){
         String pass=rs.getString("password");
         jtxtPassword.setText(pass);
         jbtnUpdate.setEnabled(true);
         jbtnDelete.setEnabled(true);
         jtxtName.setEditable(true);
         jtxtUserType.setEditable(true);
         jtxtPassword.setEditable(true);
       }else{
           JOptionPane.showMessageDialog(this, "Wrong Input ");
       }
       }catch(Exception e){
           JOptionPane.showMessageDialog(this, "Wrong Input sql exception");
       }
    }//GEN-LAST:event_jtableUserMouseClicked

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
       if(!jtxtName.getText().equals("")&&!jtxtPassword.getText().equals("")&&!jtxtUserType.getText().equals("")){
           String name = jtxtName.getText();
           String password = jtxtPassword.getText();
           String userType = jtxtUserType.getText();
           String sql = "Update Login set name = ?, password = ?, usertype= ? where userid= ?";
           try {
               pst = con.prepareStatement(sql);
               pst.setString(1, name);
               pst.setString(2, password);
               pst.setString(3, userType);
               pst.setString(4, tId);
               int count = pst.executeUpdate();
               if(0<count){
                   JOptionPane.showMessageDialog(this, "Updated successfully");
                   jtxtName.setText("");
                   jtxtPassword.setText("");
                   jtxtUserType.setText("");
                   userTable();
                   insertCountUser();
                   jbtnUpdate.setEnabled(false);
                   jbtnDelete.setEnabled(false);
                   jtxtName.setEditable(false);
                   jtxtUserType.setEditable(false);
                   jtxtPassword.setEditable(false);
               }else{
                   JOptionPane.showMessageDialog(this, "something went wrong");
               }
           } catch (SQLException ex) {
               Logger.getLogger(ViewUsers.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
           JOptionPane.showMessageDialog(this, "Please fill everything");
       }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
       jtxtName.setText("");
       jtxtPassword.setText("");
       jtxtUserType.setText("");
       jbtnUpdate.setEnabled(false);
       jbtnDelete.setEnabled(false);
       jtxtName.setEditable(false);
       jtxtUserType.setEditable(false);
       jtxtPassword.setEditable(false);
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        if(!jtxtName.getText().equals("")&&!jtxtPassword.getText().equals("")&&!jtxtUserType.getText().equals("")){
           String sql = "Delete from Login where userid = ?";
           try {
               pst = con.prepareStatement(sql);
               pst.setString(1, tId);
               int count = pst.executeUpdate();
               if(0<count){
                   JOptionPane.showMessageDialog(this, "Deleted successfully");
                   jtxtName.setText("");
                   jtxtPassword.setText("");
                   jtxtUserType.setText("");
                   userTable();
                   insertCountUser();
                   jbtnUpdate.setEnabled(false);
                   jbtnDelete.setEnabled(false);
                   jtxtName.setEditable(false);
                   jtxtUserType.setEditable(false);
                   jtxtPassword.setEditable(false);
               }else{
                   JOptionPane.showMessageDialog(this, "something went wrong");
               }
           } catch (SQLException ex) {
               Logger.getLogger(ViewUsers.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{
           JOptionPane.showMessageDialog(this, "Please fill everything");
       }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jtxtUserTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtUserTypeFocusLost
        String utype = jtxtUserType.getText();
        if(utype.equals("Admin")||
           utype.equals("Receving")||
           utype.equals("Quality")||
           utype.equals("Vendor")||
           utype.equals("Billing")){
            jtxtUserType.setText(utype);
        }else{
            jtxtUserType.setText("");
            JOptionPane.showMessageDialog(this, "please enter given details only"
                    + "\n Admin"
                    + "\n Receving"
                    + "\n Quality"
                    + "\n Vendor"
                    + "\n Billing");
            jtxtUserType.requestFocus();
        }
    }//GEN-LAST:event_jtxtUserTypeFocusLost

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
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAdCount;
    private javax.swing.JLabel jBill;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jQual;
    private javax.swing.JLabel jRec;
    private javax.swing.JLabel jRetailer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTotal;
    private javax.swing.JLabel jUserId;
    private javax.swing.JLabel jUserName;
    private javax.swing.JLabel jVendor;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JTable jtableUser;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUserType;
    // End of variables declaration//GEN-END:variables
}
