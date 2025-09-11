/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.sql.Date;



/**
 *
 * @author hang
 */
public class dangkitangca {
     private String maTangCa;      
    private String maNV;
    private String ngay;
    private int soGio;         
    private String checkin;
    private String checkout;
    private String loaiTangCa;
    private double heSo;
    private String trangThai;
    private String ghiChu;
    private String ngayTao;
    private String nguoiTao;
    private String hoten;
    
    public dangkitangca(){}

    public dangkitangca(String maTangCa, String maNV, String ngay, int soGio, String checkin, String checkout, String loaiTangCa, double heSo, String trangThai, String ghiChu, String ngayTao, String nguoiTao, String hoten) {
        this.maTangCa = maTangCa;
        this.maNV = maNV;
        this.ngay = ngay;
        this.soGio = soGio;
        this.checkin = checkin;
        this.checkout = checkout;
        this.loaiTangCa = loaiTangCa;
        this.heSo = heSo;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.hoten = hoten;
    }

    public String getMaTangCa() {
        return maTangCa;
    }

    public void setMaTangCa(String maTangCa) {
        this.maTangCa = maTangCa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getSoGio() {
        return soGio;
    }

    public void setSoGio(int soGio) {
        this.soGio = soGio;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getLoaiTangCa() {
        return loaiTangCa;
    }

    public void setLoaiTangCa(String loaiTangCa) {
        this.loaiTangCa = loaiTangCa;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    

   
}
