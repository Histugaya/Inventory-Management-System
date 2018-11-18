package com.nccs.ims.dao;

import com.nccs.ims.database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Userdao {
    PreparedStatement pstmt;
    Connection con;
    
    public Userdao(){
         con = new ConnectionFactory().getConnection();
    }
     public void changepasssword(String Username,String old,String nee){
             try{
                 if(new ConnectionFactory().checkLogin(Username,old)){
                     String sql="Update user SET Password=? WHERE Password=?";
                     pstmt=con.prepareStatement(sql);
                     pstmt.setString(1,nee);
                     pstmt.setString(2,old);
                     pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Password had been Changed");
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Wrong Username and Password");
                 }
         }catch(Exception e){
             e.printStackTrace();
         }
         
        }
}
