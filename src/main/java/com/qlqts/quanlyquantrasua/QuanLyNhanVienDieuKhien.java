/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.QuanLyNhanVien_dichvu;
import com.qlqts.quanlyquantrasua.pojo.QuanLyNhanVien;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author ASUS
 */
public class QuanLyNhanVienDieuKhien implements Initializable{
    @FXML
    private TextField txtMaNV;
    @FXML
    private TextField txtHo;
    @FXML
    private TextField txtTen;
    @FXML
    private TextField txtNgaySinh;
    @FXML
    private TextField txtGioiTinh;
    @FXML
    private TextField txtSDT;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtChucVu;
    @FXML
    private TextField txtTimKiem;
    @FXML
    private TableView<QuanLyNhanVien> tbvQLNV;
    @FXML
    private TableColumn<QuanLyNhanVien, Integer> cotMaNV;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotHo;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotTen;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotNgaySinh;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotGioiTinh;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotSDT;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotEmail;
    @FXML
    private TableColumn<QuanLyNhanVien, String> cotChucVu;
    
    private ObservableList<QuanLyNhanVien> dulieu;
    int i = -1;

    public void HienThiDSNhanVien() throws SQLException{
        dulieu = FXCollections.observableArrayList(QuanLyNhanVien_dichvu
                .layDuLieuNV());

        cotMaNV.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        cotHo.setCellValueFactory(new PropertyValueFactory<>("hoNV"));
        cotTen.setCellValueFactory(new PropertyValueFactory<>("tenNV"));
        cotNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
        cotGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        cotSDT.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        cotEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cotChucVu.setCellValueFactory(new PropertyValueFactory<>("chucVu"));
        tbvQLNV.setItems(dulieu);
    }
    
    @FXML
    void LayDLTuBangVoTxt(MouseEvent m){
        i = tbvQLNV.getSelectionModel().getSelectedIndex();
        if(i <= -1){
            return;
        }
        txtMaNV.setText(cotMaNV.getCellData(i).toString());
        txtHo.setText(cotHo.getCellData(i));
        txtTen.setText(cotTen.getCellData(i));
        txtNgaySinh.setText(cotNgaySinh.getCellData(i));
        txtGioiTinh.setText(cotGioiTinh.getCellData(i));
        txtSDT.setText(cotSDT.getCellData(i));
        txtEmail.setText(cotEmail.getCellData(i));
        txtChucVu.setText(cotChucVu.getCellData(i));
    }
    
    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("ChonChucNangQuanLy");
    }
    
    public void SuaNhanVien(ActionEvent a) throws Exception{
        if(!this.txtHo.getText().equals("") && !this.txtTen.getText().equals("")
           && !this.txtNgaySinh.getText().equals("") && !this.txtGioiTinh.getText().equals("")
           && !this.txtSDT.getText().equals("") && !this.txtEmail.getText().equals("")
           && !this.txtChucVu.getText().equals("")){
            QuanLyNhanVien qlnv = new QuanLyNhanVien();
            qlnv.setHoNV(txtHo.getText());
            qlnv.setTenNV(txtTen.getText());
            qlnv.setNgaySinh(txtNgaySinh.getText());
            qlnv.setGioiTinh(txtGioiTinh.getText());
            qlnv.setSdt(txtSDT.getText());
            qlnv.setEmail(txtEmail.getText());
            qlnv.setChucVu(txtChucVu.getText());
            try {
                QuanLyNhanVien_dichvu.SuaNhanVien(txtHo.getText(), txtTen.getText(), txtNgaySinh.getText(), 
                        txtGioiTinh.getText(), txtSDT.getText(), txtEmail.getText(), txtChucVu.getText(), 
                        txtMaNV.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Sửa thông tin nhân viên thành công");
                alert.showAndWait();
                HienThiDSNhanVien();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sửa thông tin nhân viên không thành công. Vui lòng thử lại sau");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();
        }
    }
    
    public void XoaNhanVien(ActionEvent a) throws Exception{
        try {
            QuanLyNhanVien_dichvu.XoaNhanVien(txtMaNV.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Xóa nhân viên thành công");
            alert.showAndWait();
            HienThiDSNhanVien();
            txtMaNV.clear();
            txtHo.clear();
            txtTen.clear();
            txtNgaySinh.clear();
            txtGioiTinh.clear();
            txtSDT.clear();
            txtEmail.clear();
            txtChucVu.clear();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Xóa nhân viên không thành công. Vui lòng thử lại sau");
            alert.showAndWait();
        }
    }

    @FXML
    void TimKiemNV() throws SQLException {
        dulieu = QuanLyNhanVien_dichvu.layDuLieuNV();
        tbvQLNV.setItems(dulieu);
        FilteredList<QuanLyNhanVien> duLieuLoc = new FilteredList<>(dulieu, a -> true);
        txtTimKiem.textProperty().addListener((o, gtriCu, gtriMoi) -> {
            duLieuLoc.setPredicate(nv -> {
                if (gtriMoi == null || gtriMoi.isEmpty()){ //Neu ko tim kiem se hien thi tat ca nhan vien
                    return true;
                }
                String chuThuong = gtriMoi.toLowerCase();
                
                if(nv.getHoNV().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo ho NV
                } else if(nv.getTenNV().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo ten NV
                } else if(nv.getSdt().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo SDT
                } else 
                    if(nv.getChucVu().toLowerCase().indexOf(chuThuong) != -1) {
                        return true; //Tim theo chuc vu
                    } else
                        return false; //Ko tim thay 
            });
        });
        SortedList<QuanLyNhanVien> duLieuSX = new SortedList<>(duLieuLoc);
        duLieuSX.comparatorProperty().bind(tbvQLNV.comparatorProperty());
        tbvQLNV.setItems(duLieuSX);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            HienThiDSNhanVien();
            TimKiemNV();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVienDieuKhien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
