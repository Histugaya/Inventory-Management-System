package com.nccs.ims.main;

import com.nccs.ims.gui.logindialog;
import javax.swing.UIManager;



public class InventoryManagementSystem {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        logindialog d = new logindialog();
        d.setResizable(false);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }

}
