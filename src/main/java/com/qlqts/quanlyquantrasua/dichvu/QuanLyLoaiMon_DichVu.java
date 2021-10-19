/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.QuanLyLoaiMon;
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
public class QuanLyLoaiMon_DichVu {
    public static ObservableList<QuanLyLoaiMon> layDLLoaiMon(){
        Connection knoi = KetNoiCSDL.layKnoi();
        ObservableList<QuanLyLoaiMon> ds = FXCollections.observableArrayList();
        try {
            PreparedStatement truyvan = knoi.prepareStatement("Select * from loai_mon");
            ResultSet kq = truyvan.executeQuery();
            while (kq.next()) {
                ds.add(new QuanLyLoaiMon(Integer.parseInt(kq.getString("ma_loai")), 
                        kq.getString("ten_loai")));
                
            }
        } catch (SQLException e) {
        }

        return ds;
    }
    
    public static boolean themLoaiMon(QuanLyLoaiMon qllm) throws SQLException {
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "insert into loai_mon(ten_loai) values (?)";
        
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, qllm.getTenLoai());
        p.executeUpdate();
        
        return true;
    }
    
    public static boolean suaLoaiMon(String s1, String s2) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "Update loai_mon set ten_loai = '"+s2+"' where ma_loai ='"+s1+"'";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.execute();
        return true;
    }
    
    public static boolean xoaLoaiMon(String s) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "Delete from loai_mon where ma_loai = ?";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, s);
        p.execute();
        return true;
    }
}
