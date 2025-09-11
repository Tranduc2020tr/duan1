/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.util.Date;

/**
 *
 * @author hang
 */
public class quanlythuong {
    String mathuong;
    String manv;
    String ngay;
    Double sotien;
    String noidung;
    
    public quanlythuong(){}

    public quanlythuong(String mathuong, String manv, String ngay, Double sotien, String noidung) {
        this.mathuong = mathuong;
        this.manv = manv;
        this.ngay = ngay;
        this.sotien = sotien;
        this.noidung = noidung;
    }

    public String getMathuong() {
        return mathuong;
    }

    public void setMathuong(String mathuong) {
        this.mathuong = mathuong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Double getSotien() {
        return sotien;
    }

    public void setSotien(Double sotien) {
        this.sotien = sotien;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

   
    
}
