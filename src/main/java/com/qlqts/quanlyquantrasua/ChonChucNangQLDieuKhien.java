/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ASUS
 */

public class ChonChucNangQLDieuKhien {
    @FXML
    public void DangXuat() throws IOException{
        App.setRoot("TrangChu");
    }
    
    @FXML
    public void ChuyenTrangBanHang() throws IOException{
        App.setRoot("ChucNangBanHang");
    }
    
    @FXML
    public void ChuyenTrangQLNV() throws IOException{
        App.setRoot("QuanLyNhanVien");
    }
    
    @FXML
    public void ChuyenTrangQLBan() throws IOException{
        App.setRoot("QuanLyBan");
    }
    
    @FXML
    public void ChuyenTrangQLMonAn() throws IOException{
        App.setRoot("QuanLyMonAn");
    }
}
