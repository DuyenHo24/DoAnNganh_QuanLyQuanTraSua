/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import com.qlqts.quanlyquantrasua.dichvu.QuanLyLoaiMon_DichVu;
import com.qlqts.quanlyquantrasua.dichvu.QuanLyMonAn_DichVu;
import com.qlqts.quanlyquantrasua.pojo.QuanLyBan;
import com.qlqts.quanlyquantrasua.pojo.QuanLyLoaiMon;
import com.qlqts.quanlyquantrasua.pojo.QuanLyMonAn;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author ASUS
 */
public class QuanLyMonAnDieuKhien implements Initializable{
    @FXML
    private TextField txtMaMon;

    @FXML
    private TextField txtTenMon;

    @FXML
    private TextField txtDVT;

    @FXML
    private TextField txtGiaTien;
    
    @FXML
    private TextField txtLoaiMon;
    
    @FXML
    private TextField txtTimKiem;

    @FXML
    private TableView<QuanLyMonAn> tbvQLMA;

    @FXML
    private TableColumn<QuanLyMonAn, Integer> cotMaMon;

    @FXML
    private TableColumn<QuanLyMonAn, String> cotTenMon;

    @FXML
    private TableColumn<QuanLyMonAn, String> cotDVT;

    @FXML
    private TableColumn<QuanLyMonAn, Float> cotGiaTien;

    @FXML
    private TableColumn<QuanLyMonAn, String> cotLoaiMon;
    
    @FXML
    private ImageView khungHinh;
    @FXML
    private Image hinh;
    @FXML
    private FileInputStream fi;
    private File f;
    @FXML
    private FileChooser fc;
    @FXML
    private AnchorPane luoi;
    private Stage s;
    //private Desktop hdh = Desktop.getDesktop();
    
    @FXML
    private TextField txtMaLoai;
    @FXML
    private TextField txtLoaiMonAn;
    @FXML
    private TableView<QuanLyLoaiMon> tbvQLLM;
    @FXML
    private TableColumn<QuanLyLoaiMon, Integer> cotMaLoai;
    @FXML
    private TableColumn<QuanLyLoaiMon, String> cotTenLoai;
    
    private ObservableList<QuanLyLoaiMon> dulieu1;
    
    int i = -1;

    private ObservableList<QuanLyMonAn> dulieu;
    
    @FXML
    void QuayLai(ActionEvent event) throws IOException{
        App.setRoot("ChonChucNangQuanLy");
    }
    
    public void HienThiDSMonAn() throws SQLException{
        
        cotMaMon.setCellValueFactory(new PropertyValueFactory<>("maMon"));
        cotTenMon.setCellValueFactory(new PropertyValueFactory<>("tenMon"));
        cotDVT.setCellValueFactory(new PropertyValueFactory<>("dvt"));
        cotGiaTien.setCellValueFactory(new PropertyValueFactory<>("giaTien"));
        cotLoaiMon.setCellValueFactory(new PropertyValueFactory<>("loaiMon"));
        dulieu = FXCollections.observableArrayList(QuanLyMonAn_DichVu.layDuLieuMonAn());
        tbvQLMA.setItems(dulieu);
    }
    
    public void ThemMonAn(ActionEvent a) throws Exception{
        if(!this.txtTenMon.getText().equals("") && !this.txtDVT.getText().equals("") &&
           !this.txtGiaTien.getText().equals("") && !this.txtLoaiMon.getText().equals("")){
            QuanLyMonAn qlma = new QuanLyMonAn();
            qlma.setTenMon(txtTenMon.getText());
            qlma.setDvt(txtDVT.getText());
            qlma.setGiaTien(Float.parseFloat(txtGiaTien.getText()));
            qlma.setLoaiMon(txtLoaiMon.getText());
            //f = new FileInputStream(f1);
            
            try {
                QuanLyMonAn_DichVu.themMonAn(qlma);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Th??m m??n ??n th??nh c??ng");
                alert.showAndWait();
                HienThiDSMonAn();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Th??m m??n ??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vui l??ng ??i???n ?????y ????? th??ng tin");
            alert.showAndWait();
        }
    }
    
    @FXML
    void LayDLTuBangVoTxt(MouseEvent m){
        i = tbvQLMA.getSelectionModel().getSelectedIndex();
        if(i <= -1){
            return;
        }
        txtMaMon.setText(cotMaMon.getCellData(i).toString());
        txtTenMon.setText(cotTenMon.getCellData(i));
        txtDVT.setText(cotDVT.getCellData(i));
        txtGiaTien.setText(cotGiaTien.getCellData(i).toString());
        txtLoaiMon.setText(cotLoaiMon.getCellData(i));
        
    }
    
    public void SuaMonAn(ActionEvent a) throws Exception{
        if(!this.txtTenMon.getText().equals("") && !this.txtDVT.getText().equals("") &&
           !this.txtGiaTien.getText().equals("") && !this.txtLoaiMon.getText().equals("")){
            QuanLyMonAn qlma = new QuanLyMonAn();
            qlma.setTenMon(txtTenMon.getText());
            qlma.setDvt(txtDVT.getText());
            qlma.setGiaTien(Float.parseFloat(txtGiaTien.getText()));
            qlma.setLoaiMon(txtLoaiMon.getText());
            try {
                QuanLyMonAn_DichVu.suaMonAn(txtMaMon.getText(),txtTenMon.getText(), txtDVT.getText(),
                                            txtGiaTien.getText(), txtLoaiMon.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("S???a m??n ??n th??nh c??ng");
                alert.showAndWait();
                HienThiDSMonAn();
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("S???a m??n ??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vui l??ng ??i???n ?????y ????? th??ng tin");
            alert.showAndWait();
        }
    }
    
    public void XoaMonAn(ActionEvent a) throws Exception{
        try {
            QuanLyMonAn_DichVu.XoaMonAn(txtMaMon.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("X??a m??n ??n th??nh c??ng");
            alert.showAndWait();
            HienThiDSMonAn();
            txtMaMon.clear();
            txtTenMon.clear();
            txtDVT.clear();
            txtGiaTien.clear();
            txtLoaiMon.clear();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("X??a m??n ??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
            alert.showAndWait();
        }
    }
    
    @FXML
    void TimKiemMonAn() throws SQLException {
        dulieu = QuanLyMonAn_DichVu.layDuLieuMonAn();
        tbvQLMA.setItems(dulieu);
        FilteredList<QuanLyMonAn> duLieuLoc = new FilteredList<>(dulieu, a -> true);
        txtTimKiem.textProperty().addListener((o, gtriCu, gtriMoi) -> {
            duLieuLoc.setPredicate(ma -> {
                if (gtriMoi == null || gtriMoi.isEmpty()){ //Neu ko tim kiem se hien thi tat ca mon an
                    return true;
                }
                String chuThuong = gtriMoi.toLowerCase();
                
                if(ma.getTenMon().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo ten mon
                } else if(ma.getDvt().toLowerCase().indexOf(chuThuong) != -1) {
                    return true; //Tim theo don vi tinh
                } else 
                    if(ma.getLoaiMon().toLowerCase().indexOf(chuThuong) != -1) {
                        return true; //Tim theo loai mon
                    } else
                        return false; //Ko tim thay 
            });
        });
        SortedList<QuanLyMonAn> duLieuSX = new SortedList<>(duLieuLoc);
        duLieuSX.comparatorProperty().bind(tbvQLMA.comparatorProperty());
        tbvQLMA.setItems(duLieuSX);
    }
    
    @FXML
    private void ChonHinh(ActionEvent a){
        s = (Stage) luoi.getScene().getWindow();
        fc = new FileChooser();
        fc.setTitle("Ch???n H??nh");
        fc.getExtensionFilters()
                .addAll(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg"));
        f = fc.showOpenDialog(s);
        
        if (f != null){
            hinh = new Image(f.toURI().toString());
            khungHinh.setImage(hinh);
        }
    }
    
    public void HienThiDanhSachLoaiMon() throws SQLException{
        cotMaLoai.setCellValueFactory(new PropertyValueFactory<>("maLoai"));
        cotTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoai"));
        dulieu1 = FXCollections.observableArrayList(QuanLyLoaiMon_DichVu.layDLLoaiMon());
        tbvQLLM.setItems(dulieu1);
    }
    
    public void ThemLoaiMon(){
        if(!this.txtLoaiMonAn.getText().equals("")){
            QuanLyLoaiMon qllm = new QuanLyLoaiMon();
            qllm.setTenLoai(txtLoaiMonAn.getText());
            
            try {
                QuanLyLoaiMon_DichVu.themLoaiMon(qllm);
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Th??m lo???i m??n th??nh c??ng");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Th??m lo???i m??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Vui l??ng ??i???n ?????y ????? th??ng tin");
            a.showAndWait();
        }
        
    }
    
    @FXML
    void LayDLTuBangVoTxtLM(MouseEvent m){
        i = tbvQLLM.getSelectionModel().getSelectedIndex();
        if (i <= -1){
            return;
        }
        txtMaLoai.setText(cotMaLoai.getCellData(i).toString());
        txtLoaiMonAn.setText(cotTenLoai.getCellData(i));
    }
    
    public void SuaLoaiMon(){
        if(!this.txtLoaiMonAn.getText().equals("")){
            QuanLyLoaiMon qllm = new QuanLyLoaiMon();
            qllm.setTenLoai(txtLoaiMonAn.getText());
            
            try {
                QuanLyLoaiMon_DichVu.suaLoaiMon(txtMaLoai.getText(), txtLoaiMonAn.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("S???a lo???i m??n th??nh c??ng");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("S???a lo???i m??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Vui l??ng ??i???n ?????y ????? th??ng tin");
            a.showAndWait();
        }
    }
    
    public void XoaLoaiMon(){
        try {
                QuanLyLoaiMon_DichVu.xoaLoaiMon(txtMaLoai.getText());
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("X??a lo???i m??n th??nh c??ng");
                a.showAndWait();
                HienThiDanhSachLoaiMon();
                txtMaLoai.clear();
                txtLoaiMonAn.clear();
            } catch (SQLException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("X??a lo???i m??n kh??ng th??nh c??ng. Vui l??ng th??? l???i sau");
                a.showAndWait();
            }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            HienThiDSMonAn();
            HienThiDanhSachLoaiMon();
            TimKiemMonAn();
            
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyMonAnDieuKhien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
