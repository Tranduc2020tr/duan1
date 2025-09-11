/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.sql.Time;
import java.util.Date;


/**
 *
 * @author hang
 */

public class chamcong {
    private String MaChamCong;
    private String MaNV;
    private String Hoten;
    private Date Ngay;
    private Time CheckIn;
    private Time CheckOut;
    private boolean DiLam;
    private boolean DiMuon;
    private boolean VeSom;
    private Double TongGio; // 👈 RẤT QUAN TRỌNG
    private String GhiChu;
    //
    public int nghiLe;
    public int nghiPhep;
    public int nghiKhongPhep;

    public chamcong(){}

    public chamcong(String MaChamCong, String MaNV, String Hoten, Date Ngay, Time CheckIn, Time CheckOut, boolean DiLam, boolean DiMuon, boolean VeSom, Double TongGio, String GhiChu, int nghiLe, int nghiPhep, int nghiKhongPhep) {
        this.MaChamCong = MaChamCong;
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.Ngay = Ngay;
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.DiLam = DiLam;
        this.DiMuon = DiMuon;
        this.VeSom = VeSom;
        this.TongGio = TongGio;
        this.GhiChu = GhiChu;
        this.nghiLe = nghiLe;
        this.nghiPhep = nghiPhep;
        this.nghiKhongPhep = nghiKhongPhep;
    }

    public String getMaChamCong() {
        return MaChamCong;
    }

    public void setMaChamCong(String MaChamCong) {
        this.MaChamCong = MaChamCong;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public Time getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Time CheckIn) {
        this.CheckIn = CheckIn;
    }

    public Time getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(Time CheckOut) {
        this.CheckOut = CheckOut;
    }

    public boolean isDiLam() {
        return DiLam;
    }

    public void setDiLam(boolean DiLam) {
        this.DiLam = DiLam;
    }

    public boolean isDiMuon() {
        return DiMuon;
    }

    public void setDiMuon(boolean DiMuon) {
        this.DiMuon = DiMuon;
    }

    public boolean isVeSom() {
        return VeSom;
    }

    public void setVeSom(boolean VeSom) {
        this.VeSom = VeSom;
    }

    public Double getTongGio() {
        return TongGio;
    }

    public void setTongGio(Double TongGio) {
        this.TongGio = TongGio;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getNghiLe() {
        return nghiLe;
    }

    public void setNghiLe(int nghiLe) {
        this.nghiLe = nghiLe;
    }

    public int getNghiPhep() {
        return nghiPhep;
    }

    public void setNghiPhep(int nghiPhep) {
        this.nghiPhep = nghiPhep;
    }

    public int getNghiKhongPhep() {
        return nghiKhongPhep;
    }

    public void setNghiKhongPhep(int nghiKhongPhep) {
        this.nghiKhongPhep = nghiKhongPhep;
    }
    
    

    
    
}
