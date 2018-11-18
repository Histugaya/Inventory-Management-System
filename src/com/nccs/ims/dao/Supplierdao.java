package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.nccs.ims.dto.Supplierdto;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supplierdao {
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;
    
     String[] searchColumnNames={"Id","Product","Qty","Rpu","Suppliername","Date"};
    
    public Supplierdao(){
        con=new ConnectionFactory().getConnection();
    }
    
    public void addsupplier(Supplierdto supplier){
        String query="INSERT INTO  supplier VALUES(?,?,?,?,?)";
        try {
         pstmt=con.prepareStatement(query);
         pstmt.setInt(1,supplier.getId());   
         pstmt.setString(2,supplier.getName());
         pstmt.setString(3,supplier.getItem());
         pstmt.setInt(4,supplier.getRpu());
         pstmt.setString(5,supplier.getContact());
         pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Recorded Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String value){
        String query="DELETE FROM supplier WHERE Id=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(value));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
        public Supplierdto editsupplier(JTable Table) {
        Supplierdto supplierEdit = new Supplierdto();
        
        supplierEdit.setId((Integer)Table.getValueAt(Table.getSelectedRow(), 0));
        supplierEdit.setName((String) Table.getValueAt(Table.getSelectedRow(), 1));
        supplierEdit.setItem((String) Table.getValueAt(Table.getSelectedRow(), 2));
        supplierEdit.setRpu((Integer) Table.getValueAt(Table.getSelectedRow(), 3));
        supplierEdit.setContact((String) Table.getValueAt(Table.getSelectedRow(), 4));
        return supplierEdit;
    }
    
    public void update(Supplierdto update){
        String query="UPDATE supplier SET Suppliername=?,Product=?,Rpu=?,Contact=? WHERE Id=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,update.getName());
            pstmt.setString(2,update.getItem());
            pstmt.setInt(3,update.getRpu());
            pstmt.setString(4,update.getContact());
            pstmt.setInt(5,update.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Successfully");
        
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    
     public ResultSet getQueryResult() {
        String sql = "SELECT * FROM supplier";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
     
      public String returnQueryToGetColumnName() {
        String query = "SELECT * From purchase";
        return query;
    }
      
      
       public DefaultTableModel purchase(String name, String value) throws SQLException {
       String sql = "";
       if ("Id".equalsIgnoreCase(name)) {
           sql = "SELECT Id,Product,Qty,Rpu,Suppliername,Date FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else {
            sql = "SELECT Id,Product,Qty,Rpu,Suppliername,Date FROM purchase WHERE "+name+"  = '"+value+ "' " ;
        }
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(searchColumnNames[column - 1]);
        // vector.add(rs.getObject(columnIndex));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "No search Found");
        } else {
            rs.beforeFirst();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
        }
        return new DefaultTableModel(data, columnNames);
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
        columnNames.add("Item");
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
}
