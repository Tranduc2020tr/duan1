/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class Thongkechamcong {
    public int diMuon;
    public int veSom;
    public int nghiLe;
    public int nghiPhep;
    public int nghiKhongPhep;
   private boolean diLam;
    
    public Thongkechamcong(){}

    public Thongkechamcong(int diMuon, int veSom, int nghiLe, int nghiPhep, int nghiKhongPhep, boolean diLam) {
        this.diMuon = diMuon;
        this.veSom = veSom;
        this.nghiLe = nghiLe;
        this.nghiPhep = nghiPhep;
        this.nghiKhongPhep = nghiKhongPhep;
        this.diLam = diLam;
    }

    public int getDiMuon() {
        return diMuon;
    }

    public void setDiMuon(int diMuon) {
        this.diMuon = diMuon;
    }

    public int getVeSom() {
        return veSom;
    }

    public void setVeSom(int veSom) {
        this.veSom = veSom;
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

    public boolean isDiLam() {
        return diLam;
    }

    public void setDiLam(boolean diLam) {
        this.diLam = diLam;
    }

   
    
}
