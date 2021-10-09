/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.QuanLyNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class QuanLyNhanVien_dichvu {
    
    public static ObservableList<QuanLyNhanVien> layDuLieuNV(){
        Connection knoi = KetNoiCSDL.layKnoi();
        ObservableList<QuanLyNhanVien> ds = FXCollections.observableArrayList();
        try {
            PreparedStatement truyvan = knoi.prepareStatement("select ma_nv, ho, ten, ngay_sinh, "
                    + "gioi_tinh, dien_thoai, email, chuc_vu from nhan_vien");
            ResultSet kq = truyvan.executeQuery();
            while (kq.next()){
                 ds.add(new QuanLyNhanVien(Integer.parseInt(kq.getString("ma_nv")),
                    kq.getString("ho"), kq.getString("ten"), kq.getString("ngay_sinh"), 
                    kq.getString("gioi_tinh"), kq.getString("dien_thoai"), kq.getString("email"), 
                    kq.getString("chuc_vu")));  

            }
        } catch (SQLException e) {
        }
        return ds;
    }
    
    public static boolean SuaNhanVien(String s1, String s2, String s3, String s4, String s5, String s6, 
                                     String s7, String s8) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "UPDATE nhan_vien set ho= '"+s1+"', ten= '"+s2+"',  "
                + "ngay_sinh= '"+s3+"', gioi_tinh= '"+s4+"',"
                + "dien_thoai= '"+s5+"', email= '"+s6+"', "
                + "chuc_vu= '"+s7+"' where ma_nv = '"+s8+"'";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.execute();
        return true;
    }
    
    public static boolean XoaNhanVien(String s) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "DELETE FROM nhan_vien where ma_nv = ?";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, s);
        p.execute();
        return true;
    }
}
