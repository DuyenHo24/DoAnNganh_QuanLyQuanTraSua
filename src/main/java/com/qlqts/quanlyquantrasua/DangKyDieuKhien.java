/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.DangKy_dichvu;
import com.qlqts.quanlyquantrasua.pojo.NhanVien;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author ASUS
 */
public class DangKyDieuKhien implements Initializable{
    
    @FXML
    private TextField hoTxtF;
    @FXML
    private TextField tenTxtF;
    @FXML
    private ComboBox gioiTinhCmb;
    @FXML
    private DatePicker ngaySinhDp;
    @FXML
    private TextField sdtTxtF;
    @FXML
    private TextField emailTxtF;
    @FXML
    private TextField chucVuTxtF;
    @FXML
    private TextField tenTkhoanTxtF;
    @FXML
    private PasswordField matKhauTxtF;
    @FXML
    private Label canhBaoDangKy;
    
    public void thoatOnMouseClick() throws IOException{
        App.setRoot("TrangChu");
    }
    
    public void XacNhanDangKy(ActionEvent e) throws Exception{
        if(!this.hoTxtF.getText().equals("") 
            && !this.tenTxtF.getText().equals("")
            && !this.gioiTinhCmb.getSelectionModel().getSelectedItem().toString().equals("Giới Tính")
            && !this.ngaySinhDp.getEditor().getText().equals("")
            && !this.sdtTxtF.getText().equals("")
            && !this.emailTxtF.getText().equals("")
            && !this.tenTkhoanTxtF.getText().equals("")
            && !this.matKhauTxtF.getText().equals("")
//            && rangBuocKyTuChu(hoTxtF) && rangBuocKyTuChu(tenTxtF)
            && rangBuocKyTuSo() && rangBuocEmail(emailTxtF)){
                DangKy();
        }
        else
            canhBaoDangKy.setText("Vui lòng điền đầy đủ thông tin");
    }
    
    public void DangKy() throws Exception{
        if(!DangKy_dichvu.ktraTenDN(this.tenTkhoanTxtF.getText())){
            NhanVien nv = new NhanVien(this.hoTxtF.getText(), this.tenTxtF.getText(), 
                    ngaySinhDp.getEditor().getText(), 
                    this.gioiTinhCmb.getSelectionModel().getSelectedItem().toString(),
                    this.sdtTxtF.getText(), this.emailTxtF.getText(),
                    this.tenTkhoanTxtF.getText(), this.matKhauTxtF.getText(),
                    this.chucVuTxtF.getText());
            try {
                    DangKy_dichvu.themTKNhanVien(nv);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Đăng ký thành công");
                    alert.showAndWait();
                    App.setRoot("DangNhap");
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Đăng ký không thành công. Vui lòng thử lại sau");
                    alert.showAndWait();
                }
        } else
            canhBaoDangKy.setText("Tên tài khoản đã tồn tại!");
    }
            
    public boolean rangBuocKyTuSo() {
        Pattern p = Pattern.compile("(0)?[0-9]{9}");
        Matcher m = p.matcher(this.sdtTxtF.getText());

        if (m.find() && m.group().equals(this.sdtTxtF.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng nhập số điện thoại");
            alert.showAndWait();
            this.sdtTxtF.clear();
            return false;
        }
    }

//    public boolean rangBuocKyTuChu(TextField txt) {
//        Pattern p = Pattern.compile("[a-zA-Z\\s]+");
//        Matcher m = p.matcher(txt.getText());
//
//        if (m.find() && m.group().equals(txt.getText())) {
//            return true;
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Vui lòng điền họ và tên của bạn");
//            alert.showAndWait();
//            txt.clear();
//            return false;
//        }
//    }

    public boolean rangBuocEmail(TextField txt) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+@gmail.com");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())
                && txt.getText().endsWith("@gmail.com")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vui lòng điền gmail của bạn");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DangKy_dichvu.chinhNgaySinh(ngaySinhDp);
        
        ObservableList<String> gioiTinh = 
                FXCollections.observableArrayList("Nam","Nữ");
        gioiTinhCmb.setItems(gioiTinh);
    }
    
    
    
}
