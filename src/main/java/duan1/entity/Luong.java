/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author Hung Cuong
 */
public class Luong {
    private String maluong;
    private String manv;
    private int thang;
    private int nam;
    private BigDecimal luongcoban;
    private BigDecimal luongphucap;
    private BigDecimal thuong;
    private BigDecimal khautru;
    private BigDecimal tongluong;
    private Date ngayTao;
    private String nguoiTao;
    private String ghiChu;

   public Luong(){}

    public Luong(String maluong, String manv, int thang, int nam, BigDecimal luongcoban, BigDecimal luongphucap, BigDecimal thuong, BigDecimal khautru, BigDecimal tongluong, Date ngayTao, String nguoiTao, String ghiChu) {
        this.maluong = maluong;
        this.manv = manv;
        this.thang = thang;
        this.nam = nam;
        this.luongcoban = luongcoban;
        this.luongphucap = luongphucap;
        this.thuong = thuong;
        this.khautru = khautru;
        this.tongluong = tongluong;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.ghiChu = ghiChu;
    }

    public String getMaluong() {
        return maluong;
    }

    public void setMaluong(String maluong) {
        this.maluong = maluong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public BigDecimal getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(BigDecimal luongcoban) {
        this.luongcoban = luongcoban;
    }

    public BigDecimal getLuongphucap() {
        return luongphucap;
    }

    public void setLuongphucap(BigDecimal luongphucap) {
        this.luongphucap = luongphucap;
    }

    public BigDecimal getThuong() {
        return thuong;
    }

    public void setThuong(BigDecimal thuong) {
        this.thuong = thuong;
    }

    public BigDecimal getKhautru() {
        return khautru;
    }

    public void setKhautru(BigDecimal khautru) {
        this.khautru = khautru;
    }

    public BigDecimal getTongluong() {
        return tongluong;
    }

    public void setTongluong(BigDecimal tongluong) {
        this.tongluong = tongluong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   
   
   
}
