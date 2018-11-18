package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import com.nccs.ims.dto.Customerdto;
import com.nccs.ims.dto.Itemdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Purchasedao {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;

    String[] searchColumnNames = {"Id", "Product", "Qty", "Rpu","Total","Suppliername", "Date"};

    public Purchasedao() {
        con = new ConnectionFactory().getConnection();
    }

    public ResultSet getquery() {
        String sql = "SELECT * FROM purchasereturn";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Id");
        columnNames.add("Product");
        columnNames.add("Qty");
        columnNames.add("Rpu");
        columnNames.add("Total");
        columnNames.add("Suppliername");
        columnNames.add("Date");
        return columnNames;
    }

    public void purchase(Itemdto item) {
        String query = "INSERT INTO  purchase(Product,Qty,Rpu,Total,Suppliername,Date) VALUES(?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getQuantity());
            pstmt.setInt(3, item.getRate());
            pstmt.setInt(4,item.getTotal());
            pstmt.setString(5, item.getSupplier());
            pstmt.setString(6, String.valueOf(item.getDate()));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Itemdto update) {
        String query = "UPDATE purchase SET Product=?,Qty=Qty-?,Rpu=?,Suppliername=?,Date=? WHERE Id=? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, update.getName());
            pstmt.setInt(2, update.getQuantity());
            pstmt.setInt(3, update.getRate());
            pstmt.setString(4, update.getSupplier());
            pstmt.setString(5, String.valueOf(update.getDate()));
            pstmt.setInt(6, update.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //this for purchase return update
    public void purchasereturnupdate(Itemdto update) {
        String query = "UPDATE purchase SET Product=?,Qty=Qty-?,Rpu=?,Suppliername=? WHERE Date=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, update.getName());
            pstmt.setInt(2, update.getQuantity());
            pstmt.setInt(3, update.getRate());
            pstmt.setString(4, update.getSupplier());
            pstmt.setString(5, String.valueOf(update.getDate()));

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel purchase(String name, String value) throws SQLException {
        String sql = "";
        if ("Id".equalsIgnoreCase(name)) {
            sql = "SELECT Id,Product,Qty,Rpu,Total,Suppliername,Date FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Qty".equalsIgnoreCase(name)) {
            sql = "SELECT Id,Product,Qty,Rpu,Total,Suppliername,Date FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Rpu".equalsIgnoreCase(name)) {
            sql = "SELECT Id,Product,Qty,Rpu,Total,Suppliername,Date FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else {
            sql = "SELECT Id,Product,Qty,Rpu,Total,Suppliername,Date FROM purchase WHERE " + name + "  = '" + value + "' ";
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

    public DefaultTableModel viewpurchase() throws SQLException {
        String sql = "SELECT Id,Product,Qty,Rpu,Total,Suppliername,Date FROM purchase ";
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

    public void reduceitem(Itemdto item, int i) {
        if (i == 1) {
            String query = "INSERT INTO  purchasereturn(Product,Qty,Rpu,Suppliername,Date) VALUES(?,?,?,?,?)";
            try {
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, item.getName());
                pstmt.setInt(2, item.getQuantity());
                pstmt.setInt(3, item.getRate());
                pstmt.setString(4, item.getSupplier());
                pstmt.setString(5, item.getTodaydate());
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Purchase Return Performed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, " Sorry invalid data");
        }
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

    
    
    public int checkif(Itemdto i){
         String query = "SELECT Qty FROM item WHERE Name=? AND Suppliername=?";
         int value = i.getQuantity(), j = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, i.getName());
            pstmt.setString(2, i.getSupplier());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (value <= rs.getInt("Qty")) {
                    j++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }
    
    
     public Itemdto getdetail(Itemdto cus) {
        int Id = cus.getId();
        String query = "SELECT * FROM purchase WHERE Id=' " + Id + " ' ";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cus.setName(rs.getString("Product"));
                cus.setSupplier(rs.getString("Suppliername"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }
     
        public int  Total(){
         int i=0,Total_Sale=0, a[];
          a=new int[100];
         ResultSet total;
         try{
         String query = "SELECT Total FROM purchase";
          stmt = con.createStatement();
            total = stmt.executeQuery(query);
           
               while(total.next()){
                 a[i]=total.getInt("Total");
                 i++;
                }
         }
         catch(Exception e){
        e.printStackTrace();
        }  
        
         for (int j = 0; j < i; j++) {
             Total_Sale+=a[j];
         }
        return Total_Sale;        
        
     }
     
      public int  Viewtotal(String name,String value) throws SQLException{
         int i=0,Total_Sale=0, a[];
          a=new int[100];
         ResultSet total;
          String sql = "";
        if ("CustomerId".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Qty".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Rpu".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Total".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM purchase WHERE " + name + "=" + Integer.parseInt(value);
        } else {
            sql = "SELECT Total FROM purchase WHERE " + name + "  = '" + value + "' ";
        }
          stmt = con.createStatement();
            total = stmt.executeQuery(sql);
           
               while(total.next()){
                 a[i]=total.getInt("Total");
                 i++;
                }
         
         
        
         for (int j = 0; j < i; j++) {
             Total_Sale+=a[j];
         }
        return Total_Sale;        
        
     }
}
