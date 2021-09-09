package com.qlqts.quanlyquantrasua;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TrangChuController implements Initializable {
    
    @FXML
    public void ChuyenTrangDangNhap() throws IOException {
        App.setRoot("DangNhap");
    }
    
    @FXML
    public void ChuyenTrangDangKy() throws IOException {
        App.setRoot("DangKy");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
