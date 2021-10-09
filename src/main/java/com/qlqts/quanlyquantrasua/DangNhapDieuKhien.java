/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.KetNoiCSDL;

import com.qlqts.quanlyquantrasua.pojo.NhanVien;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DangNhapDieuKhien implements Initializable{
    @FXML
    private Label canhBaoDangNhap;
//    @FXML
//    private Button dangNhapButton;
//    @FXML
//    private Button thoatButton;
    @FXML
    private TextField tenDNTextField;
    @FXML
    private PasswordField dienPasswordField;
    
    Connection knoi = null;
    ResultSet kqua = null;
    PreparedStatement truyVan = null;
    
    
    public void dangNhapButtonOnAction(ActionEvent e) throws SQLException, IOException{
        if(tenDNTextField.getText().isBlank() == false && dienPasswordField.getText().isBlank() == false) {
            xacNhanDangNhap(); 
            if (kiemTraChucVu(this.tenDNTextField.getText()).equals("Quản Lý")) {
                    App.setRoot("ChonChucNangQuanLy");
                } else {
                    App.setRoot("ChucNangBanHang");
                }
        } else {
            canhBaoDangNhap.setText("Vui lòng điền tên đăng nhập và mật khẩu");
        }
            
    }
    
    public void xacNhanDangNhap(){
        try {
            knoi = KetNoiCSDL.layKnoi();
            String sql = "Select ten_tkhoan, mat_khau from nhan_vien where ten_tkhoan = ? and mat_khau = ? ";
            truyVan = knoi.prepareStatement(sql);
            truyVan.setString(1, tenDNTextField.getText());
            truyVan.setString(2, dienPasswordField.getText());
            kqua = truyVan.executeQuery();
            if (kqua.next()){

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Đăng nhập thành công");
                a.showAndWait();
                
            } else {
                canhBaoDangNhap.setText("Sai tên đăng nhập hoặc mật khẩu!");
                this.tenDNTextField.clear();
                this.dienPasswordField.clear();
            }
            
        } catch (Exception e) {
        }


    }
    
    public static String kiemTraChucVu(String tenTK) throws SQLException{
        String sql = "Select chuc_vu from nhan_vien where ten_tkhoan = ?";
        Connection knoi = KetNoiCSDL.layKnoi();
        PreparedStatement truyVan = knoi.prepareStatement(sql);
        truyVan.setString(1, tenTK);
        
        ResultSet kq = truyVan.executeQuery();
        String chucVu = "";
        while (kq.next()) {
            chucVu = kq.getString("chuc_vu");
        }
        return chucVu;
    }
    
    public void thoatButtonOnAction() throws IOException{
        App.setRoot("TrangChu");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

}
