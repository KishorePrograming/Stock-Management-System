package Process;


import Log.Login;
import Users.Retailers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 91979
 */
public class RequestRequerments extends javax.swing.JFrame {
    private static Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private String name;
    private String userType;
    private static int id;
    private static String Order_Qty;
    private static String db_Qty;
    /**
     * Creates new form Admin
     */
    public RequestRequerments() {
        initComponents();
        this.con = Login.connection();
        }
    
    public RequestRequerments(String name, int id,String userType,Connection con) {
       initComponents();
       jcmbName.requestFocus();
       jUserId.setText(String.valueOf(id));
       jUserName.setText(name);
       this.con= con;
       this.name = name;
       this.userType = userType;
       this.id=id;
       autoId();
       jtxtProducId.setEditable(false);
       jtxtDBQty.setEditable(false);
       setDescriptionComboBox();
       autoCompleteDescriptionTyping();
       jbtnRequest.setEnabled(false);
       }
    
   private void autoCompleteDescriptionTyping(){
       AutoCompleteDecorator.decorate(jcmbName);
   } 
     
    
   private void setDescriptionComboBox(){
        String sql = "select Prod_Name from StoreTable where Qty!=Order_Qty;";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs != null){
                while(rs.next()){
                    String prod_name = rs.getString("Prod_Name");
                    jcmbName.addItem(prod_name);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Empty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestRequerments.class.getName()).log(Level.SEVERE, null, ex);
        }       
   } 
   
   private void autoId(){
        try {
             Statement st = con.createStatement();
             rs = st.executeQuery("select MAX(Order_num) from RequermentRequest");
             rs.next();            
             rs.getString("MAX(Order_num)");
             if(rs.getString("MAX(Order_num)")==null){
                 jOrderId.setText("OR001");
             }else{
                 long id = Long.parseLong(rs.getString("MAX(Order_num)").substring(2, rs.getString("MAX(Order_num)").length()));
                 id++;
                 jOrderId.setText("OR"+String.format("%03d", id));
             }
             
        } catch (SQLException e) {
            Logger.getLogger(RequestRequerments.class.getName()).log(Level.SEVERE, null, e);
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
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jOrderId = new javax.swing.JLabel();
        jtxtProducId = new javax.swing.JTextField();
        jcmbName = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jtxtQty = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jStatus = new javax.swing.JLabel();
        jlblPrice = new javax.swing.JLabel();
        jtxtDBQty = new javax.swing.JTextField();
        jchkProdName = new javax.swing.JCheckBox();
        jbtnRequest = new javax.swing.JButton();
        jlblDescription = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jbtnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 255));

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Retailers Requerment Request Page");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("User Id");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Name");

        jUserId.setBackground(new java.awt.Color(255, 204, 204));
        jUserId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserId.setForeground(new java.awt.Color(153, 153, 255));
        jUserId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserId.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jUserName.setBackground(new java.awt.Color(255, 204, 204));
        jUserName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jUserName.setForeground(new java.awt.Color(153, 153, 255));
        jUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jUserName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 255));
        jLabel10.setText("Product Id");

        jButton6.setBackground(new java.awt.Color(153, 204, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 255));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 255));
        jLabel14.setText("Product Name");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 255));
        jLabel15.setText("Price");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 255));
        jLabel16.setText("Order Id");

        jOrderId.setBackground(new java.awt.Color(102, 255, 204));
        jOrderId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jOrderId.setForeground(new java.awt.Color(0, 0, 255));
        jOrderId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jOrderId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtxtProducId.setBackground(new java.awt.Color(102, 255, 204));
        jtxtProducId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtProducId.setForeground(new java.awt.Color(0, 0, 255));

        jcmbName.setBackground(new java.awt.Color(102, 255, 204));
        jcmbName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcmbName.setForeground(new java.awt.Color(0, 0, 255));
        jcmbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbNameActionPerformed(evt);
            }
        });
        jcmbName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcmbNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcmbNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcmbNameKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 255));
        jLabel17.setText("Qty");

        jtxtQty.setBackground(new java.awt.Color(102, 255, 204));
        jtxtQty.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtQty.setForeground(new java.awt.Color(0, 0, 255));
        jtxtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtQtyFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 255));
        jLabel18.setText("Status");

        jStatus.setBackground(new java.awt.Color(102, 255, 204));
        jStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jStatus.setForeground(new java.awt.Color(0, 0, 255));
        jStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jStatus.setText("Not Started Yet");
        jStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblPrice.setBackground(new java.awt.Color(102, 255, 204));
        jlblPrice.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jlblPrice.setForeground(new java.awt.Color(0, 0, 255));
        jlblPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtxtDBQty.setBackground(new java.awt.Color(102, 255, 204));
        jtxtDBQty.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jtxtDBQty.setForeground(new java.awt.Color(0, 0, 255));
        jtxtDBQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtDBQtyFocusLost(evt);
            }
        });

        jchkProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkProdNameActionPerformed(evt);
            }
        });

        jbtnRequest.setBackground(new java.awt.Color(153, 204, 255));
        jbtnRequest.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnRequest.setForeground(new java.awt.Color(0, 0, 255));
        jbtnRequest.setText("Request");
        jbtnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRequestActionPerformed(evt);
            }
        });

        jlblDescription.setBackground(new java.awt.Color(102, 255, 204));
        jlblDescription.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jlblDescription.setForeground(new java.awt.Color(0, 0, 255));
        jlblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblDescription.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 255));
        jLabel19.setText("Description");

        jbtnClear.setBackground(new java.awt.Color(153, 204, 255));
        jbtnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnClear.setForeground(new java.awt.Color(0, 0, 255));
        jbtnClear.setText("Clear");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10)
                            .addComponent(jLabel19))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addGap(33, 33, 33)
                                .addComponent(jtxtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jtxtDBQty, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jtxtProducId, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jOrderId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                            .addGap(35, 35, 35)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel15))
                                            .addGap(39, 39, 39)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jchkProdName)
                                            .addGap(18, 18, 18)
                                            .addComponent(jcmbName, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(138, 138, 138)
                                        .addComponent(jbtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtProducId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18)
                            .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jcmbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jchkProdName))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jtxtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtDBQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnClear)
                    .addComponent(jbtnRequest))
                .addContainerGap(16, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.gc();
        this.setVisible(false);
        new Retailers(name,id,userType,con).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jtxtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtQtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtQtyFocusLost

    private void jtxtDBQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtDBQtyFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDBQtyFocusLost

    private void jbtnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRequestActionPerformed
        if(checkNumber()){
            methodForRequest();
            jcmbName.removeAllItems();
            setDescriptionComboBox();
        }else{
            JOptionPane.showMessageDialog(this, "Please Enter the Number in QTY");
            jtxtQty.setText("");
            jtxtQty.requestFocus();
        }
    }//GEN-LAST:event_jbtnRequestActionPerformed
    private void methodForRequest(){
        String Order_num = jOrderId.getText();
        String Prod_id = jtxtProducId.getText();
        String Prod_Name = jcmbName.getSelectedItem().toString();
        String Description = jlblDescription.getText();
        String Price = jlblPrice.getText();
        String Qty = jtxtQty.getText();
        String Status = jStatus.getText();
        String sql = "Insert into RequermentRequest(Order_num,Prod_id,Prod_Name,Description,Price,Qty,Status)values (?,?,?,?,?,?,?)";
        try {
            if(Integer.parseInt(jtxtQty.getText())<=Integer.parseInt(jtxtDBQty.getText())){
            pst = con.prepareStatement(sql);
            pst.setString(1, Order_num);
            pst.setString(2, Prod_id);
            pst.setString(3, Prod_Name);
            pst.setString(4, Description);
            pst.setString(5, Price);
            pst.setString(6, Qty);
            pst.setString(7, Status);
            int count = pst.executeUpdate();
            if(0<count){
                int qty = Integer.parseInt(Order_Qty)+Integer.parseInt(Qty);
                sql = "Update StoreTable set Order_Qty = ? where Prod_id= ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, String.valueOf(qty));
                pst.setString(2, Prod_id);
                count=0;
                count = pst.executeUpdate();
                if(0<count){
                    JOptionPane.showMessageDialog(this, "Order Placed Successfully");
                    autoId();
                    clear();
                }else{
                  JOptionPane.showMessageDialog(this, "Something Went wrong\n In StoreTable ");  
                }
            }else{
                 JOptionPane.showMessageDialog(this, "Something Went wrong\n In RequermentRequest");
                 }
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter less then or Equal Qty");
                jtxtQty.setText("");
                jtxtQty.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestRequerments.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    
    private void clear(){
            jtxtProducId.setText("");
            jlblPrice.setText("");
            jlblDescription.setText("");
            jtxtDBQty.setText("");
            jtxtQty.setText("");
            jcmbName.setSelectedIndex(0);
            jcmbName.requestFocus();
            jbtnRequest.setEnabled(false);
            jtxtQty.setEditable(false);
            jchkProdName.setSelected(false);
    }
    private void jchkProdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkProdNameActionPerformed
        if(jchkProdName.isSelected()){
            if(jcmbName.getSelectedItem().toString().equals("")){
                JOptionPane.showConfirmDialog(this, "Product is Not Available");
            }else{
            jtxtQty.setEditable(true);
            jbtnRequest.setEnabled(true);
            everyDataUpdatingInFileds();
            }
        }else{
            clear();
            
        }
    }//GEN-LAST:event_jchkProdNameActionPerformed

    private void jcmbNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbNameKeyPressed
       everyDataUpdatingInFileds();
    }//GEN-LAST:event_jcmbNameKeyPressed

    private void jcmbNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbNameKeyReleased
            jtxtProducId.setText("");
            jlblPrice.setText("");
            jlblDescription.setText("");
            jtxtDBQty.setText("");
            jtxtQty.setText("");
            jcmbName.requestFocus();
    }//GEN-LAST:event_jcmbNameKeyReleased

    private void jcmbNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcmbNameKeyTyped
       checkNumber();
    }//GEN-LAST:event_jcmbNameKeyTyped

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
       clear();
       autoId();
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jcmbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbNameActionPerformed
    
    private boolean checkNumber(){
        boolean flag = false;
        String qty = jtxtQty.getText();
        for(int i = 0;i<qty.length();i++){
            if('0'<=qty.charAt(i)&&qty.charAt(i)<='9'){
                flag = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    private void everyDataUpdatingInFileds(){
       
        String sql = " select Prod_id,Prod_Name,Description,RetailPrice,Qty,Order_Qty from StoreTable where Prod_Name = ?";
        try {
            String prodName = jcmbName.getSelectedItem().toString();
            pst = con.prepareStatement(sql);
            pst.setString(1,prodName);
            rs = pst.executeQuery();
            boolean check = rs.next();
            if(check){
                jtxtProducId.setText(rs.getString("Prod_id"));
                jlblPrice.setText(rs.getString("RetailPrice"));
                jlblDescription.setText(rs.getString("Description"));
                Order_Qty = rs.getString("Order_Qty");
                db_Qty = rs.getString("Qty");
                int Q = Integer.parseInt(db_Qty)-Integer.parseInt(Order_Qty);
                jtxtDBQty.setText(String.valueOf(Q));
                jtxtQty.requestFocus();
            }else{
                JOptionPane.showMessageDialog(this, "Empty");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestRequerments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
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
            java.util.logging.Logger.getLogger(RequestRequerments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestRequerments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestRequerments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestRequerments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RequestRequerments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jOrderId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jStatus;
    private javax.swing.JLabel jUserId;
    private javax.swing.JLabel jUserName;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnRequest;
    private javax.swing.JCheckBox jchkProdName;
    private javax.swing.JComboBox<String> jcmbName;
    private javax.swing.JLabel jlblDescription;
    private javax.swing.JLabel jlblPrice;
    private javax.swing.JTextField jtxtDBQty;
    private javax.swing.JTextField jtxtProducId;
    private javax.swing.JTextField jtxtQty;
    // End of variables declaration//GEN-END:variables
}
