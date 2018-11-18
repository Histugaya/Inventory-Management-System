package com.nccs.ims.gui;

import com.nccs.ims.dao.Invoicedao;
import com.nccs.ims.dao.Itemdao;
import com.nccs.ims.dao.Salesdao;
import com.nccs.ims.dto.Customerdto;
import com.nccs.ims.dto.Itemdto;
import com.nccs.ims.dto.Salesdto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Invoice extends javax.swing.JPanel {

    Statement stmt;
    Connection con;
    ResultSet rs;
    
    int i=1;

    public Invoice() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Bill = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        customerid = new javax.swing.JTextField();
        customername = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        productcombobox = new javax.swing.JComboBox();
        companycombobox = new javax.swing.JComboBox();
        rpu = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        statuscombo = new javax.swing.JComboBox();
        date = new com.toedter.calendar.JDateChooser();
        submit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(240, 240, 240));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Table);

        Bill.setBackground(new java.awt.Color(255, 255, 0));

        jLabel2.setText("Customer Id");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Address");

        jLabel10.setText("Contact");

        jLabel5.setText("Product");

        jLabel12.setText("Company");

        jLabel8.setText("Rater per unit");

        jLabel7.setText("Quantity");

        jLabel6.setText("Total");

        jLabel9.setText("Status");

        jLabel11.setText("Date");

        customerid.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                customeridComponentAdded(evt);
            }
        });
        customerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customeridActionPerformed(evt);
            }
        });
        customerid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customeridKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customeridKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customeridKeyTyped(evt);
            }
        });

        productcombobox.setModel(new javax.swing.DefaultComboBoxModel(new Invoicedao().returnQueryToGetProductName()));
        productcombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productcomboboxActionPerformed(evt);
            }
        });

        companycombobox.setModel(new javax.swing.DefaultComboBoxModel(new Invoicedao().returnQueryToGetCompanyName()));
        companycombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companycomboboxActionPerformed(evt);
            }
        });

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        statuscombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Paid", "Unpaid" }));

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Invoice");

        javax.swing.GroupLayout BillLayout = new javax.swing.GroupLayout(Bill);
        Bill.setLayout(BillLayout);
        BillLayout.setHorizontalGroup(
            BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillLayout.createSequentialGroup()
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customerid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(productcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rpu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BillLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillLayout.createSequentialGroup()
                                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(submit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1)
                                    .addComponent(statuscombo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(BillLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        BillLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address, customerid, customername, qty, rpu, total});

        BillLayout.setVerticalGroup(
            BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(BillLayout.createSequentialGroup()
                        .addComponent(productcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(companycombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statuscombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(BillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(jButton1))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2533, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(Bill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 private void loadData() {

        try {
            Salesdao saledao = new Salesdao();
              Table.setModel(saledao.builtTableMode(saledao.getQueryResult()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        Salesdto sale = new Salesdto();
        sale.setCustomerId(Integer.parseInt(customerid.getText()));
        sale.setCustomerName(customername.getText());
        sale.setAddress(address.getText());
        sale.setContact(contact.getText());
        sale.setProduct(String.valueOf(productcombobox.getSelectedItem()));
        sale.setCompany(String.valueOf(companycombobox.getSelectedItem()));
        sale.setQty(Integer.parseInt(qty.getText()));
        sale.setRpu(Integer.parseInt(rpu.getText()));
        sale.setTotal(Integer.parseInt(total.getText()));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        sale.setDate(df.format(date.getDate()));
        sale.setStatus(String.valueOf(statuscombo.getSelectedItem()));
        new Salesdao().set(sale);
        new Itemdao().updateitem(sale);
        
        
        try{
            
            MessageFormat header=new MessageFormat("Big Mart");
            MessageFormat footer=new MessageFormat("*** Please visit again ***");
            Table.print(JTable.PrintMode.NORMAL, header, footer);       
                    JOptionPane.showMessageDialog(null,"Transaction Completed");  
            
        }catch(Exception e){
            e.printStackTrace();
        }
   
        
        
        
        
        clearFields();
        loadData();
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void customeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customeridActionPerformed

    }//GEN-LAST:event_customeridActionPerformed

    private void customeridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customeridKeyPressed

    }//GEN-LAST:event_customeridKeyPressed

    private void customeridKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customeridKeyReleased
        Customerdto cus = new Customerdto();
        cus.setId(Integer.parseInt(customerid.getText()));
        cus = new Invoicedao().getdetail(cus);
        customername.setText(String.valueOf(cus.getName()));
        customername.setEditable(false);
        address.setText(String.valueOf(cus.getAddress()));
        address.setEditable(false);
        contact.setText(String.valueOf(cus.getContact()));
        contact.setEditable(false);
    }//GEN-LAST:event_customeridKeyReleased

    private void customeridComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_customeridComponentAdded

    }//GEN-LAST:event_customeridComponentAdded

    private void customeridKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customeridKeyTyped
        //TODO add your handling code here:
    }//GEN-LAST:event_customeridKeyTyped

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        Salesdto count=new Salesdto();
        count.setRpu( Integer.parseInt(rpu.getText()));
        count.setQty(Integer.parseInt(qty.getText()));
        count.setCompany( String.valueOf(companycombobox.getSelectedItem()));
        count.setProduct( String.valueOf(productcombobox.getSelectedItem()));
        int i=new Itemdao().checkquantity(count);
        if(i==1){
        int whole = count.getRpu() * count.getQty();
        total.setText(String.valueOf(whole));
        total.setEditable(false);
        }
        else{
            JOptionPane.showMessageDialog(null,"Not enough stock");
            total.setText(" ");
        }
    }//GEN-LAST:event_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void companycomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companycomboboxActionPerformed
        Itemdto sale = new Itemdto();
        sale.setSupplier(String.valueOf(companycombobox.getSelectedItem()));
        sale.setName(String.valueOf(productcombobox.getSelectedItem()));
        sale = new Invoicedao().getrpu(sale);
        rpu.setText(String.valueOf(sale.getRate()));
        rpu.setEditable(false);

    }//GEN-LAST:event_companycomboboxActionPerformed

    private void productcomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productcomboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productcomboboxActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    public void clearFields() {
        customerid.setText("");
        customername.setText("");
        address.setText("");
        contact.setText("");
        productcombobox.setSelectedIndex(0);
        companycombobox.setSelectedIndex(0);
        qty.setText("");
        rpu.setText("");
        total.setText("");
        date.setDate(null);
        statuscombo.setSelectedIndex(0);
    }
//    update.setVisible(false);

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bill;
    private javax.swing.JTable Table;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox companycombobox;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField customerid;
    private javax.swing.JTextField customername;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox productcombobox;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField rpu;
    private javax.swing.JComboBox statuscombo;
    private javax.swing.JButton submit;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
