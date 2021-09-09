/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class KetNoiCSDL {
    private static Connection knoi;
        static {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                knoi = DriverManager.getConnection("jdbc:mysql://localhost/quanlyquantrasua","root","htmd_240700");
            } catch(SQLException | ClassNotFoundException ex) {
                Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    public static Connection layKnoi() {
        return knoi;
    }
}
