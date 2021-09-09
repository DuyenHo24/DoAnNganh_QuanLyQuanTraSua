/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.service.KetNoiCSDL;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DangNhapController implements Initializable{
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
    
    
    public void dangNhapButtonOnAction(ActionEvent e) {
        if(tenDNTextField.getText().isBlank() == false && dienPasswordField.getText().isBlank() == false) {
            xacNhanDangNhap();
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
                
            }
        } catch (Exception e) {
        }
    }
    
    public void thoatButtonOnAction() throws IOException{
        App.setRoot("TrangChu");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

}
