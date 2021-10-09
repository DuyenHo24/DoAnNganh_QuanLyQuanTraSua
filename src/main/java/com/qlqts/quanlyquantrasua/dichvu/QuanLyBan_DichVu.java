/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.QuanLyBan;
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
public class QuanLyBan_DichVu {
    public static ObservableList<QuanLyBan> layDuLieuBan(){
        Connection knoi = KetNoiCSDL.layKnoi();
        ObservableList<QuanLyBan> ds = FXCollections.observableArrayList();
        try {
            PreparedStatement truyvan = knoi.prepareStatement("select * from ban");
            ResultSet kq = truyvan.executeQuery();
            while (kq.next()){
                 ds.add(new QuanLyBan(Integer.parseInt(kq.getString("ma_ban")),
                    kq.getString("vi_tri"), kq.getString("mieu_ta")));  
            }
        } catch (SQLException e) {
        }
        return ds;
    }
    
    public static boolean themBan(QuanLyBan qlb) throws SQLException {
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "insert into ban(vi_tri, mieu_ta) values (?, ?)";

        //knoi.setAutoCommit(false);

        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, qlb.getViTri());
        p.setString(2, qlb.getMoTa());
        
        p.executeUpdate();
        //knoi.commit();
        return true;
    }
    
    public static boolean suaBan(String s1, String s2, String s3) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "UPDATE ban set vi_tri= '"+s2+"', mieu_ta= '"+s3+"' where ma_ban = '"+s1+"'";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.execute();
        return true;
    }
    
    public static boolean XoaBan(String s) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "DELETE FROM ban where ma_ban = ?";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, s);
        p.execute();
        return true;
    }
}
