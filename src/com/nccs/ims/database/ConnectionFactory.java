package com.nccs.ims.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

    Connection con;
    Statement stmt;
    ResultSet rs;
    boolean flag = false;

    public ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String Username, String Password) {
        try {
            String query = "select * from user where username='" + Username + "' and Password='" + Password + " ' ";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ims", "root", "");
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
