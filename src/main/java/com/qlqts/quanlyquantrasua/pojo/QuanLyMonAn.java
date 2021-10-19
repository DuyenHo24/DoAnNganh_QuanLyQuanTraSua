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
public class QuanLyMonAn {
    private int maMon;
    private String tenMon;
    private String dvt;
    private float giaTien;
    private String loaiMon;
    
    public QuanLyMonAn() {
    }

    public QuanLyMonAn(int maMon, String tenMon, String dvt, float giaTien, String loaiMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.dvt = dvt;
        this.giaTien = giaTien;
        this.loaiMon = loaiMon;
    }
    
    

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public String getDvt() {
        return dvt;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    
}
