/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.QuanLyMonAn;
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
public class QuanLyMonAn_DichVu {
    public static ObservableList<QuanLyMonAn> layDuLieuMonAn(){
        Connection knoi = KetNoiCSDL.layKnoi();
        ObservableList<QuanLyMonAn> ds = FXCollections.observableArrayList();
        try {
            PreparedStatement truyvan = knoi.prepareStatement("select * from mon");
            ResultSet kq = truyvan.executeQuery();
            while (kq.next()){
                 ds.add(new QuanLyMonAn(Integer.parseInt(kq.getString("ma_mon")),
                    kq.getString("ten_mon"), kq.getString("don_vi_tinh"), 
                    Float.parseFloat(kq.getString("gia_tien")), kq.getString("loai_mon")));  
            }
        } catch (SQLException e) {
        }
        return ds;
    }
    
    public static boolean themMonAn(QuanLyMonAn qlma) throws SQLException {
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "insert into mon(ten_mon, don_vi_tinh, gia_tien, loai_mon) values (?, ?, ?, ?)";

        //knoi.setAutoCommit(false);

        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, qlma.getTenMon());
        p.setString(2, qlma.getDvt());
        p.setFloat(3, qlma.getGiaTien());
        p.setString(4, qlma.getLoaiMon());
        
        p.executeUpdate();
        //knoi.commit();
        return true;
    }
    
    public static boolean suaMonAn(String s1, String s2, String s3, String s4, String s5) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "UPDATE mon set ten_mon= '"+s2+"', don_vi_tinh= '"+s3+"', gia_tien= '"+s4+"',"
                + "loai_mon= '"+s5+"' where ma_mon = '"+s1+"'";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.execute();
        return true;
    }
    
    public static boolean XoaMonAn(String s) throws SQLException{
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "DELETE FROM mon where ma_mon = ?";
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, s);
        p.execute();
        return true;
    }
}
