/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class dashboard {
    private int tongNhanVien;
    private int tongChamCongHomNay;
    private int tongNghiPhepHomNay;
    private String manv;
    private double tongluong;
    private int soNgayDiLam;
    private int soNgayNghiPhep;
    
    public dashboard(){}

    public dashboard(int tongNhanVien, int tongChamCongHomNay, int tongNghiPhepHomNay, String manv, double tongluong, int soNgayDiLam, int soNgayNghiPhep) {
        this.tongNhanVien = tongNhanVien;
        this.tongChamCongHomNay = tongChamCongHomNay;
        this.tongNghiPhepHomNay = tongNghiPhepHomNay;
        this.manv = manv;
        this.tongluong = tongluong;
        this.soNgayDiLam = soNgayDiLam;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public int getTongNhanVien() {
        return tongNhanVien;
    }

    public void setTongNhanVien(int tongNhanVien) {
        this.tongNhanVien = tongNhanVien;
    }

    public int getTongChamCongHomNay() {
        return tongChamCongHomNay;
    }

    public void setTongChamCongHomNay(int tongChamCongHomNay) {
        this.tongChamCongHomNay = tongChamCongHomNay;
    }

    public int getTongNghiPhepHomNay() {
        return tongNghiPhepHomNay;
    }

    public void setTongNghiPhepHomNay(int tongNghiPhepHomNay) {
        this.tongNghiPhepHomNay = tongNghiPhepHomNay;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public double getTongluong() {
        return tongluong;
    }

    public void setTongluong(double tongluong) {
        this.tongluong = tongluong;
    }

    public int getSoNgayDiLam() {
        return soNgayDiLam;
    }

    public void setSoNgayDiLam(int soNgayDiLam) {
        this.soNgayDiLam = soNgayDiLam;
    }

    public int getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }

    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

   


    
    
}
