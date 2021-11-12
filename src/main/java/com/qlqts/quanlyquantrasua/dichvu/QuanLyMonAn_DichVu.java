/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.QuanLyMonAn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

/**
 *
 * @author ASUS
 */
public class QuanLyMonAn_DichVu implements Initializable{
    private FileInputStream fi;
    private File f;
    
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
       
//        try {
            Connection knoi = KetNoiCSDL.layKnoi();
            String sql = "insert into mon(ten_mon, don_vi_tinh, gia_tien, loai_mon, hinh_anh_mon) values (?, ?, ?, ?, ?)";
            
            //knoi.setAutoCommit(false);
            
            PreparedStatement p = knoi.prepareStatement(sql);
            p.setString(1, qlma.getTenMon());
            p.setString(2, qlma.getDvt());
            p.setFloat(3, qlma.getGiaTien());
            p.setString(4, qlma.getLoaiMon());
            
//            fi = new FileInputStream(f);
//            p.setBinaryStream(5, fi, f.length());
            p.executeUpdate();
            //knoi.commit();
            
            
            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(QuanLyMonAn_DichVu.class.getName()).log(Level.SEVERE, null, ex);
//        }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
