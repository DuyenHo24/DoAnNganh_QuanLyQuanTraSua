/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlqts.quanlyquantrasua.pojo;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class NhanVien {
    private String hoNV;
    private String tenNV;
    private String ngaySinh;
    private String gioiTinh;
    private String sdt;
    private String email;
    private String tenTK;
    private String matKhau;
    private String chucVu;

    public NhanVien(String ho, String ten, String ns, String gt, String sdt, String email, 
            String tentk, String mk, String chucVu) {
        this.hoNV = ho;
        this.tenNV = ten;
        this.ngaySinh = ns;
        this.gioiTinh = gt;
        this.sdt = sdt;
        this.email = email;
        this.tenTK = tentk;
        this.matKhau = mk;
        this.chucVu = chucVu;
    }

    /**
     * @return the hoNV
     */
    public String getHoNV() {
        return hoNV;
    }

    /**
     * @param hoNV the hoNV to set
     */
    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    /**
     * @return the tenNV
     */
    public String getTenNV() {
        return tenNV;
    }

    /**
     * @param tenNV the tenNV to set
     */
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }


    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tenTK
     */
    public String getTenTK() {
        return tenTK;
    }

    /**
     * @param tenTK the tenTK to set
     */
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the chucVu
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
