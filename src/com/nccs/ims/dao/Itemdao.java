package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Itemdao {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;

    public Itemdao() {
        con = new ConnectionFactory().getConnection();
    }

    public void additem(Itemdto item) {

        int i = 0, k = 0;
        String Itemname = item.getName();
        String Suppliername = item.getSupplier();
        String a[] = new String[10];
        String b[] = new String[10];

        String query1 = "SELECT Distinct Name,Suppliername FROM item";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query1);
            while (rs.next()) {
                a[i] = rs.getString("Name");
                b[i] = rs.getString("Suppliername");
                i++;
            }

            for (int j = 0; j <= i; j++) {
                if (Itemname.equals(a[j])) {
                    if (Suppliername.equals(b[j])) {
                        k++;
                    }
                }
            }

            if (k == 0) {
                String query2 = "INSERT INTO  item(Name,Qty,Rpu,Suppliername,Date) VALUES(?,?,?,?,?)";
                try {
                    pstmt = con.prepareStatement(query2);
                    pstmt.setString(1, item.getName());
                    pstmt.setInt(2, item.getQuantity());
                    pstmt.setInt(3, item.getRate());
                   // pstmt.setInt(4, item.getTotal());
                    pstmt.setString(4, item.getSupplier());
                    pstmt.setString(5, String.valueOf(item.getDate()));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Recorded Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                String query = "UPDATE item SET Qty=Qty+? WHERE Suppliername=? AND Name=?";
                try {
                    pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, item.getQuantity());
                    pstmt.setString(2, item.getSupplier());
                    pstmt.setString(3, item.getName());
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Recorded Successfully");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String value) {
        String query = "DELETE FROM purchase WHERE Id=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(value));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }

    public Itemdto edit(JTable Table) {
        Itemdto itemEdit = new Itemdto();
        itemEdit.setId((Integer) Table.getValueAt(Table.getSelectedRow(), 0));
        itemEdit.setName((String) Table.getValueAt(Table.getSelectedRow(), 1));
        itemEdit.setQuantity((Integer) Table.getValueAt(Table.getSelectedRow(), 2));
        itemEdit.setRate((Integer) Table.getValueAt(Table.getSelectedRow(), 3));
        itemEdit.setSupplier((String) Table.getValueAt(Table.getSelectedRow(), 4));
        itemEdit.setDate((String) (Table.getValueAt(Table.getSelectedRow(), 5)));
        return itemEdit;
    }

   
    public int update(Itemdto update) {
        
        String query1 = "SELECT * FROM Purchase WHERE Id=? ";
        int i = 0;
        String supplier=update.getSupplier();
        String product=update.getName();
          try {
            pstmt = con.prepareStatement(query1);
            pstmt.setInt(1, update.getId());
            rs=pstmt.executeQuery();
            while (rs.next()) {
                String Supplier=rs.getString("Suppliername");
                String Product=rs.getString("Product");
                 if(supplier.equals(Supplier) && product.equals(Product))
                i++;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 1) {
            String query = "UPDATE item SET Qty=Qty-? WHERE Suppliername=? AND Name=?";

            try {
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, update.getQuantity());
                pstmt.setString(2, update.getSupplier());
                pstmt.setString(3, update.getName());
                int result = pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

//this is for purchase transaction
    public ResultSet getQueryResult() {
        String sql = "SELECT * FROM purchase";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

//this for stock
    public ResultSet getQueryResults() {
        String sql = "SELECT Id,Name,Qty,Rpu,Suppliername FROM item";
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

//this is for after sale 
    public void updateitem(Salesdto sale) {
        String Name = sale.getProduct();
        String Suppliername = sale.getCompany();
        int quantity = sale.getQty();
        String query = "Update item set Qty=Qty-? WHERE Name=? AND Suppliername=? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, quantity);
            pstmt.setString(2, Name);
            pstmt.setString(3, Suppliername);
            pstmt.executeUpdate();
         //   JOptionPane.showMessageDialog(null,"SALED");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//this is for after salereturn
    public int salereturnupdate(Salesdto sale) {
        int i = 0;

        String query1 = "SELECT SaleId,CustomerId,Qty FROM sale WHERE SaleId=?";
        try {
            pstmt = con.prepareStatement(query1);
            pstmt.setInt(1, sale.getSaleId());
            
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
               int id=rs.getInt("CustomerId");
              // int qtysale=rs.getInt("Qty");
                if(id==sale.getCustomerId())
                    i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       // int count=sale.getQty();
        if (i == 1 ){
            
            String query = "Update item set Qty=Qty+? WHERE Name=? AND Suppliername=?";
            try {
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, sale.getQty());
                pstmt.setString(2, sale.getProduct());
                pstmt.setString(3, sale.getCompany());
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        return i;
    }

    public String[] checkitem() {
        int minimum = 5, i = 0;
        String a[] = new String[50];
        String query = "SELECT Name,Suppliername FROM item WHERE Qty<5";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String product = rs.getString("Name");
                String company=" Of "+rs.getString("Suppliername");
                a[i]=product.concat(company);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    //this is for checking whether there is enough quantity or not in stock
    public int checkquantity(Salesdto count) {
        String query = "SELECT Qty FROM item WHERE Name=? AND Suppliername=?";
        int value = count.getQty(), i = 0;
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, count.getProduct());
            pstmt.setString(2, count.getCompany());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (value <= rs.getInt("Qty")) {
                    i++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
