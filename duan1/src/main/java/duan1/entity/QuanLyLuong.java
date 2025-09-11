/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.math.BigDecimal;

/**
 *
 * @author Hung Cuong
 */
public class QuanLyLuong {
  private String maluong;
    private String manv;
    private String hoten;
    private int thang;
    private int nam;
    private BigDecimal luongcoban;
    private BigDecimal luongphucap;
    private BigDecimal thuong;
    private BigDecimal khautru;
    private BigDecimal tongluong;
    private String ngaytao;
    private String nguoitao;
    private String ghichu;

   
   public QuanLyLuong(){}

    public QuanLyLuong(String maluong, String manv, String hoten, int thang, int nam, BigDecimal luongcoban, BigDecimal luongphucap, BigDecimal thuong, BigDecimal khautru, BigDecimal tongluong, String ngaytao, String nguoitao, String ghichu) {
        this.maluong = maluong;
        this.manv = manv;
        this.hoten = hoten;
        this.thang = thang;
        this.nam = nam;
        this.luongcoban = luongcoban;
        this.luongphucap = luongphucap;
        this.thuong = thuong;
        this.khautru = khautru;
        this.tongluong = tongluong;
        this.ngaytao = ngaytao;
        this.nguoitao = nguoitao;
        this.ghichu = ghichu;
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

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
   
   
   

    
}
