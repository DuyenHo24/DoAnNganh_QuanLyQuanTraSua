/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.QuanLyBan_DichVu;
import com.qlqts.quanlyquantrasua.pojo.QuanLyBan;
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
public class QuanLyBanDieuKhien implements Initializable{
    @FXML
    private TextField txtMaBan;
    @FXML
    private TextField txtViTri;
    @FXML
    private TextField txtMoTa;
    @FXML
    private TextField txtTimKiem;
    @FXML
    private TableView<QuanLyBan> tbvQLBan;
    @FXML
    private TableColumn<QuanLyBan, Integer> cotMaBan;
    @FXML
    private TableColumn<QuanLyBan, String> cotViTri;
    @FXML
    private TableColumn<QuanLyBan, String> cotMoTa;
    
    private ObservableList<QuanLyBan> dulieu;
    
    int i = -1;
    
    public void HienThiDSBan() throws SQLException{
        
        cotMaBan.setCellValueFactory(new PropertyValueFactory<>("maBan"));
        cotViTri.setCellValueFactory(new PropertyValueFactory<>("viTri"));
        cotMoTa.setCellValueFactory(new PropertyValueFactory<>("moTa"));
        dulieu = FXCollections.observableArrayList(QuanLyBan_DichVu.layDuLieuBan());
        tbvQLBan.setItems(dulieu);
    }
    
    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("ChonChucNangQuanLy");
    }

    public void ThemBan(ActionEvent a) throws Exception{
        if(!this.txtMoTa.getText().equals("") && !this.txtViTri.getText().equals("")){
            QuanLyBan qlb = new QuanLyBan();
            qlb.setViTri(txtViTri.getText());
            qlb.setMoTa(txtMoTa.getText());
            try {
                QuanLyBan_DichVu.themBan(qlb);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Thêm bàn thành công");
                alert.showAndWait();
                HienThiDSBan();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Thêm bàn không thành công. Vui lòng thử lại sau");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();
        }
    }
    
    @FXML
    void LayDLTuBangVoTxt(MouseEvent m){
        i = tbvQLBan.getSelectionModel().getSelectedIndex();
        if(i <= -1){
            return;
        }
        txtMaBan.setText(cotMaBan.getCellData(i).toString());
        txtViTri.setText(cotViTri.getCellData(i));
        txtMoTa.setText(cotMoTa.getCellData(i));
        
    }
    
    public void SuaBan(ActionEvent a) throws Exception{
        if(!this.txtMoTa.getText().equals("") && !this.txtViTri.getText().equals("")){
            QuanLyBan qlb = new QuanLyBan();
            qlb.setViTri(txtViTri.getText());
            qlb.setMoTa(txtMoTa.getText());
            try {
                QuanLyBan_DichVu.suaBan(txtMaBan.getText(),txtViTri.getText(), txtMoTa.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Sửa bàn thành công");
                alert.showAndWait();
                HienThiDSBan();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sửa bàn không thành công. Vui lòng thử lại sau");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vui lòng điền đầy đủ thông tin");
            alert.showAndWait();
        }
    }
    
    public void XoaBan(ActionEvent a) throws Exception{
        try {
            QuanLyBan_DichVu.XoaBan(txtMaBan.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Xóa bàn thành công");
            alert.showAndWait();
            HienThiDSBan();
            txtMaBan.clear();
            txtViTri.clear();
            txtMoTa.clear();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Xóa bàn không thành công. Vui lòng thử lại sau");
            alert.showAndWait();
        }
    }
    
    @FXML
    void TimKiemBan() throws SQLException {
        dulieu = QuanLyBan_DichVu.layDuLieuBan();
        tbvQLBan.setItems(dulieu);
        FilteredList<QuanLyBan> duLieuLoc = new FilteredList<>(dulieu, a -> true);
        txtTimKiem.textProperty().addListener((o, gtriCu, gtriMoi) -> {
            duLieuLoc.setPredicate(ban -> {
                if (gtriMoi == null || gtriMoi.isEmpty()){ //Neu ko tim kiem se hien thi tat ca ban
                    return true;
                }
                String chuThuong = gtriMoi.toLowerCase();
                
                if(ban.getViTri().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo vi tri
                } else if(ban.getMoTa().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo mo ta
                } else 
                    if(String.valueOf(ban.getMaBan()).indexOf(chuThuong) != -1) {
                        return true; //Tim theo ma ban
                    } else
                        return false; //Ko tim thay 
            });
        });
        SortedList<QuanLyBan> duLieuSX = new SortedList<>(duLieuLoc);
        duLieuSX.comparatorProperty().bind(tbvQLBan.comparatorProperty());
        tbvQLBan.setItems(duLieuSX);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            HienThiDSBan();
            TimKiemBan();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyBanDieuKhien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
