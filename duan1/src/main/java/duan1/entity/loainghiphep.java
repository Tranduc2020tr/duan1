/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class loainghiphep {
    String maloai;
    String tenloai;
    Boolean HuongLuong;
    
    public loainghiphep(){}

    public loainghiphep(String maloai, String tenloai, Boolean HuongLuong) {
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.HuongLuong = HuongLuong;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public Boolean getHuongLuong() {
        return HuongLuong;
    }

    public void setHuongLuong(Boolean HuongLuong) {
        this.HuongLuong = HuongLuong;
    }
    
   
}
