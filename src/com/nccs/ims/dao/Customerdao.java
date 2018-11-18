package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import com.nccs.ims.dto.Customerdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Customerdao {
    Connection con;
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    public Customerdao() {
        con=new ConnectionFactory().getConnection();
    }
    
    public void addcustomer(Customerdto customer){
        String sql="INSERT INTO customer VALUES(?,?,?,?)";
        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,customer.getId());
            pstmt.setString(2,customer.getName());
            pstmt.setString(3,customer.getAddress());
            pstmt.setString(4,customer.getContact());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data inserted Successfully"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    public void delete(String value){
    String query="DELETE FROM customer WHERE Id=? ";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(value));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Customerdto editcustomer(JTable Table){
       Customerdto customerEdit = new Customerdto();
        customerEdit.setId((Integer)Table.getValueAt(Table.getSelectedRow(), 0));
        customerEdit.setName((String) Table.getValueAt(Table.getSelectedRow(), 1));
        customerEdit.setAddress((String) Table.getValueAt(Table.getSelectedRow(), 2));
        customerEdit.setContact((String) Table.getValueAt(Table.getSelectedRow(), 3));
        return customerEdit;  
    }
    
    public void update(Customerdto update){
        String query="UPDATE customer SET customername=?,Address=?,Contact=? WHERE Id=?";
         try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,update.getName());
            pstmt.setString(2,update.getAddress());
            pstmt.setString(3,update.getContact());
            pstmt.setInt(4,update.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");
        
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
     public ResultSet getQueryResult() {
        String sql = "SELECT * FROM customer";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
        
 public DefaultTableModel builtTableMode(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnName = new Vector<String>();
        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {
            columnName.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));

            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnName);
    }
       
        public Vector<String> getColumnName() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Name");
        columnNames.add("Address");
        columnNames.add("Contact");
        return columnNames;
    }
       public Vector<String> getColumnNames(String query) {
        Vector<String> columnNames = new Vector<String>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnNames;
    }

       public void updates(int a){
           String sql="Update item set Qty=Qty-'"+a+"' WHERE Name='Mobile'";
           try {
               stmt=con.createStatement();
               stmt.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"Updates");
           } catch (Exception e) {
               e.printStackTrace();
           }
               }
       
    
}
