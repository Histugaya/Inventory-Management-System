package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import com.nccs.ims.dto.Customerdto;
import com.nccs.ims.dto.Itemdto;
import com.nccs.ims.dto.Salesdto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Invoicedao {

    Statement stmt;
    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;

    public Invoicedao() {
        con = new ConnectionFactory().getConnection();
    }

    public String[] returnQueryToGetProductName() {
        String query = "SELECT Distinct Product From supplier";
        String a[] = new String[15];
        int i = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                a[i] = rs.getString("Product");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public String[] returnQueryToGetCompanyName() {
        String query = "SELECT Distinct Suppliername From supplier";
        String a[] = new String[15];
        int i = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                a[i] = rs.getString("Suppliername");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public Customerdto getdetail(Customerdto cus) {
        int Id = cus.getId();
        String query = "SELECT * FROM customer WHERE Id=' " + Id + " ' ";
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cus.setName(rs.getString("CustomerName"));
                cus.setAddress(rs.getString("Address"));
                cus.setContact(rs.getString("Contact"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }
    
    

    public Itemdto getrpu(Itemdto sale) {
        String Product = sale.getName();
        String Suppliername = sale.getSupplier();
        String query = "SELECT Rpu FROM Supplier WHERE Product=? AND Suppliername= ? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, Product);
            pstmt.setString(2, Suppliername);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                sale.setRate(rs.getInt("Rpu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sale;
    }

    
    
    public Salesdto edit(JTable Table) {
        Salesdto itemEdit = new Salesdto();
        itemEdit.setSaleId((Integer) Table.getValueAt(Table.getSelectedRow(), 0));
        itemEdit.setCustomerId((Integer) Table.getValueAt(Table.getSelectedRow(), 1));
        itemEdit.setCustomerName((String) Table.getValueAt(Table.getSelectedRow(), 2));
        itemEdit.setAddress((String) Table.getValueAt(Table.getSelectedRow(), 3));
        itemEdit.setContact((String) Table.getValueAt(Table.getSelectedRow(), 4));
        itemEdit.setProduct((String) Table.getValueAt(Table.getSelectedRow(), 5));
        itemEdit.setCompany((String) Table.getValueAt(Table.getSelectedRow(),6));
        itemEdit.setQty((Integer) (Table.getValueAt(Table.getSelectedRow(), 7)));
        itemEdit.setRpu((Integer) (Table.getValueAt(Table.getSelectedRow(), 8)));
        itemEdit.setTotal((Integer) (Table.getValueAt(Table.getSelectedRow(), 9)));
        itemEdit.setDate((String) (Table.getValueAt(Table.getSelectedRow(), 10)));
        itemEdit.setStatus((String) (Table.getValueAt(Table.getSelectedRow(), 11)));
        return itemEdit;
    }
    
    
    public void update(Salesdto update) {
        String query = "UPDATE sale SET Company=?,Product=?,Qty=?,Rpu=?,Total=?,Date=?,Status=? WHERE CustomerID=? ";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,update.getCompany());
            pstmt.setString(2, update.getProduct());
            pstmt.setInt(3, update.getQty());
            pstmt.setInt(4, update.getRpu());
            pstmt.setInt(5, update.getTotal());
            pstmt.setString(6, String.valueOf(update.getDate()));
            pstmt.setString(7,update.getStatus());
            pstmt.setInt(8,update.getCustomerId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public void delete(String value) {
        String query = "DELETE FROM sale WHERE SaleId=?";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(value));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }
}
