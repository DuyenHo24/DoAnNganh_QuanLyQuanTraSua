/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author ASUS
 */
public class GioiThieuDieuKhien {
    @FXML
    private Button btTrangChu;
    @FXML
    public void ChuyenTrangChu() throws IOException {
        App.setRoot("TrangChu");
    }
}
