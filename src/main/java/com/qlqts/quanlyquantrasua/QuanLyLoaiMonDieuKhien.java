/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.QuanLyLoaiMon_DichVu;
import com.qlqts.quanlyquantrasua.pojo.QuanLyLoaiMon;
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
public class QuanLyLoaiMonDieuKhien implements Initializable{
    @FXML
    private TextField txtMaLoai;
    @FXML
    private TextField txtLoaiMon;
    @FXML
    private TextField txtTimKiem;
    @FXML
    private TableView<QuanLyLoaiMon> tbvQLLM;
    @FXML
    private TableColumn<QuanLyLoaiMon, Integer> cotMaLoai;
    @FXML
    private TableColumn<QuanLyLoaiMon, String> cotTenLoai;
    
    private ObservableList<QuanLyLoaiMon> dulieu;
    
    int i = -1;
    
    public void HienThiDanhSachLoaiMon() throws SQLException{
        cotMaLoai.setCellValueFactory(new PropertyValueFactory<>("maLoai"));
        cotTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoai"));
        dulieu = FXCollections.observableArrayList(QuanLyLoaiMon_DichVu.layDLLoaiMon());
        tbvQLLM.setItems(dulieu);
    }
    
    public void ThemLoaiMon(){
        if(!this.txtLoaiMon.getText().equals("")){
            QuanLyLoaiMon qllm = new QuanLyLoaiMon();
            qllm.setTenLoai(txtLoaiMon.getText());
            
            try {
                QuanLyLoaiMon_DichVu.themLoaiMon(qllm);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Thêm loại món thành công");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Thêm loại món không thành công. Vui lòng thử lại sau");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Vui lòng điền đầy đủ thông tin");
            a.showAndWait();
        }
        
    }
    
    @FXML
    void LayDLTuBangVoTxt(MouseEvent m){
        i = tbvQLLM.getSelectionModel().getSelectedIndex();
        if (i <= -1){
            return;
        }
        txtMaLoai.setText(cotMaLoai.getCellData(i).toString());
        txtLoaiMon.setText(cotTenLoai.getCellData(i));
    }
    
    public void SuaLoaiMon(){
        if(!this.txtLoaiMon.getText().equals("")){
            QuanLyLoaiMon qllm = new QuanLyLoaiMon();
            qllm.setTenLoai(txtLoaiMon.getText());
            
            try {
                QuanLyLoaiMon_DichVu.suaLoaiMon(txtMaLoai.getText(), txtLoaiMon.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Sửa loại món thành công");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Sửa loại món không thành công. Vui lòng thử lại sau");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Vui lòng điền đầy đủ thông tin");
            a.showAndWait();
        }
    }
    
    public void XoaLoaiMon(){
        try {
                QuanLyLoaiMon_DichVu.xoaLoaiMon(txtMaLoai.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Xóa loại món thành công");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
                txtMaLoai.clear();
                txtLoaiMon.clear();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Xóa loại món không thành công. Vui lòng thử lại sau");
                a.showAndWait();
            }
    }
    
    @FXML
    void TimKiemLoaiMon() throws SQLException {
        dulieu = QuanLyLoaiMon_DichVu.layDLLoaiMon();
        tbvQLLM.setItems(dulieu);
        FilteredList<QuanLyLoaiMon> duLieuLoc = new FilteredList<>(dulieu, a -> true);
        txtTimKiem.textProperty().addListener((o, gtriCu, gtriMoi) -> {
            duLieuLoc.setPredicate(lm -> {
                if (gtriMoi == null || gtriMoi.isEmpty()){ //Neu ko tim kiem se hien thi tat ca loai mon
                    return true;
                }
                String chuThuong = gtriMoi.toLowerCase();
                
                if(lm.getTenLoai().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo ten loai
                } else 
                    if(String.valueOf(lm.getMaLoai()).indexOf(chuThuong) != -1) {
                        return true; //Tim theo ma loai
                    } else
                        return false; //Ko tim thay 
            });
        });
        SortedList<QuanLyLoaiMon> duLieuSX = new SortedList<>(duLieuLoc);
        duLieuSX.comparatorProperty().bind(tbvQLLM.comparatorProperty());
        tbvQLLM.setItems(duLieuSX);
    }
    
    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("ChonChucNangQuanLy");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            HienThiDanhSachLoaiMon();
            TimKiemLoaiMon();
        } catch (SQLException e) {
            Logger.getLogger(QuanLyLoaiMonDieuKhien.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
