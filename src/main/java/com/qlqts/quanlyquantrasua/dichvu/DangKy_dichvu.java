/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.dichvu;

import com.qlqts.quanlyquantrasua.pojo.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author ASUS
 */
public class DangKy_dichvu {
    
    public static boolean themTKNhanVien(NhanVien nv) throws SQLException {
        Connection knoi = KetNoiCSDL.layKnoi();
        String sql = "insert into nhan_vien(ho, ten, ngay_sinh, gioi_tinh, dien_thoai, email,"
                + "ten_tkhoan, mat_khau, chuc_vu) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //knoi.setAutoCommit(false);

        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, nv.getHoNV());
        p.setString(2, nv.getTenNV());
        p.setString(3, nv.getNgaySinh());
        p.setString(4, nv.getGioiTinh());
        p.setString(5, nv.getSdt());
        p.setString(6, nv.getEmail());
        p.setString(7, nv.getTenTK());
        p.setString(8, nv.getMatKhau());
        p.setString(9, nv.getChucVu());

        p.executeUpdate();

        //knoi.commit();

        return true;
    }
    
    public static void chinhNgaySinh(DatePicker ngay) {
        String s = "yyyy-MM-dd";
        ngay.setPromptText(s);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(s);
        StringConverter c = new LocalDateStringConverter(dtf, null);
        ngay.setConverter(c);
    }
    
    public static boolean ktraTenDN(String ten) throws Exception {
        String sql = "Select ten_tkhoan From nhan_vien where ten_tkhoan = ?";

        Connection knoi = KetNoiCSDL.layKnoi();
        PreparedStatement p = knoi.prepareStatement(sql);
        p.setString(1, ten);
        ResultSet r = p.executeQuery();

        if(r.next()) 
            return true;
        else 
            return false;
    }
}
