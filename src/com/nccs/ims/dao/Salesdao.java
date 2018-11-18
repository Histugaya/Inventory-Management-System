package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import com.nccs.ims.dto.Customerdto;
import com.nccs.ims.dto.Itemdto;
import com.nccs.ims.dto.Salesdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Salesdao {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;

    public Salesdao() {
        con = new ConnectionFactory().getConnection();
    }

    String[] searchColumnNames = {"SaleId","CustomerId", "CustomerName", "Address", "Contact", "Company", "Product", "Qty", "Rpu", "Total","Date", "Status"};

    public String returnQueryToGetColumnName() {
        String query = "SELECT * From sale";
        return query;
    }
    
     public ResultSet getquery(){
         String sql = "SELECT * FROM salesreturn";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    
    
    
    
    public ResultSet getQueryResult(){
         String sql = "SELECT * FROM sale";
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
        columnNames.add("Customer Id");
        columnNames.add("Customer Name");
        columnNames.add("Address");
        columnNames.add("Contact");
        columnNames.add("Product");
        columnNames.add("Company");
        columnNames.add("Quantity");
        columnNames.add("Rate per unit");
        columnNames.add("Total");
        columnNames.add("Date");
        columnNames.add("Status");
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

    public void set(Salesdto sale) {
        String query = "INSERT INTO sale(CustomerID,CustomerName,Address,Contact,Product,Company,Qty,Rpu,Total,Date,Status)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, sale.getCustomerId());
            pstmt.setString(2, sale.getCustomerName());
            pstmt.setString(3, sale.getAddress());
            pstmt.setString(4, sale.getContact());
            pstmt.setString(5, sale.getProduct());
            pstmt.setString(6, sale.getCompany());
            pstmt.setInt(7, sale.getQty());
            pstmt.setInt(8, sale.getRpu());
            pstmt.setInt(9, sale.getTotal());
            pstmt.setString(10, sale.getDate());
            pstmt.setString(11, sale.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  /*  public void update(Salesdto sale){
        String query="Update sale set Qty=Qty- Where SaleId=?";
        try {
            
        } catch (Exception e) {
        }
    }*/

    public DefaultTableModel sale(String name, String value) throws SQLException {
        String sql = "";
        if ("CustomerId".equalsIgnoreCase(name)) {
            sql = "SELECT * FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Qty".equalsIgnoreCase(name)) {
            sql = "SELECT * FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Rpu".equalsIgnoreCase(name)) {
            sql = "SELECT * FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Total".equalsIgnoreCase(name)) {
            sql = "SELECT * FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else {
            sql = "SELECT * FROM sale WHERE " + name + "  = '" + value + "' ";
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

    
     public DefaultTableModel viewsale() throws SQLException {
        String sql = "SELECT * FROM sale ";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData metaData = rs.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(searchColumnNames[column - 1]);
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
     
     public int  Total(){
         int i=0,Total_Sale=0, a[];
          a=new int[100];
         ResultSet total;
         try{
         String query = "SELECT Total FROM sale";
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
            sql = "SELECT Total FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Qty".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Rpu".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else if ("Total".equalsIgnoreCase(name)) {
            sql = "SELECT Total FROM sale WHERE " + name + "=" + Integer.parseInt(value);
        } else {
            sql = "SELECT Total FROM sale WHERE " + name + "  = '" + value + "' ";
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
     
     public void additem(Salesdto sale,int i) {
         if(i==1){
         String query = "INSERT INTO salesreturn VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, sale.getCustomerId());
            pstmt.setString(2, sale.getCustomerName());
            pstmt.setString(3, sale.getAddress());
            pstmt.setString(4, sale.getContact());
            pstmt.setString(5, sale.getProduct());
            pstmt.setString(6, sale.getCompany());
            pstmt.setInt(7, sale.getQty());
            pstmt.setInt(8, sale.getRpu());
            pstmt.setInt(9, sale.getTotal());
            pstmt.setString(10, sale.getStatus());
            pstmt.setString(11, sale.getTodaydate());
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sale Return Performed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         else{
             JOptionPane.showMessageDialog(null,"Sorry invalid data");
         }

}
     
     
     
      public int checkif(Salesdto i){
         String query = "SELECT Qty FROM sale WHERE SaleId=?";
         int value = i.getQty(), j = 0;
            try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,i.getSaleId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(value);
                System.out.println(rs.getInt("Qty"));
                if (value <= rs.getInt("Qty")) {
                    j++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    
        return j;

      }
 public Salesdto getdetail(Salesdto cus) {
        int Id = cus.getSaleId();
        String query = "SELECT * FROM sale WHERE SaleId=' " + Id + " ' ";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cus.setCustomerId(rs.getInt("CustomerID"));
                cus.setCustomerName(rs.getString("CustomerName"));
                cus.setAddress(rs.getString("Address"));
                cus.setContact(rs.getString("Contact"));
                cus.setProduct(rs.getString("Product"));
                cus.setCompany(rs.getString("Company"));
                cus.setQty(rs.getInt("Qty"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

//update after the salesreturn
 public void updatesale(Salesdto sale){
     String query="Update sale set Qty=Qty-? Where SaleId=?";
     try {
         System.out.println("Updating sale executed");
         pstmt=con.prepareStatement(query);
         // pstmt.setInt(1, sale.getCustomerId());
         pstmt.setInt(1,sale.getQty());
         pstmt.setInt(2,sale.getSaleId());
         pstmt.executeUpdate();         
     } catch (Exception e) {
         e.printStackTrace();
     }
     
 }




}
