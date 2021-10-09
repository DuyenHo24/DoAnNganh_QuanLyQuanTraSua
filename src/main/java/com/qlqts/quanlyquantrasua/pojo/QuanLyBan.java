/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.pojo;

/**
 *
 * @author ASUS
 */
public class QuanLyBan {
    private int maBan;
    private String viTri;
    private String moTa;

    public QuanLyBan(int maBan, String viTri, String moTa) {
        this.maBan = maBan;
        this.viTri = viTri;
        this.moTa = moTa;
    }

    public QuanLyBan() {
    }

    /**
     * @return the maBan
     */
    public int getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the viTri
     */
    public String getViTri() {
        return viTri;
    }

    /**
     * @param viTri the viTri to set
     */
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
