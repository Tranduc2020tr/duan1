/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class chitietphieuluong {
   String manv;
   String hoten;
   int dilam;
   String sogio;
   String phucap;
   String tongkhautru;
   String bhxh;
   String bhyt;
   String bhtn;
   String ttncn;
   String tongluong;
   
   public chitietphieuluong(){}

    public chitietphieuluong(String manv, String hoten, int dilam, String sogio, String phucap, String tongkhautru, String bhxh, String bhyt, String bhtn, String ttncn, String tongluong) {
        this.manv = manv;
        this.hoten = hoten;
        this.dilam = dilam;
        this.sogio = sogio;
        this.phucap = phucap;
        this.tongkhautru = tongkhautru;
        this.bhxh = bhxh;
        this.bhyt = bhyt;
        this.bhtn = bhtn;
        this.ttncn = ttncn;
        this.tongluong = tongluong;
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

    public int getDilam() {
        return dilam;
    }

    public void setDilam(int dilam) {
        this.dilam = dilam;
    }

    public String getSogio() {
        return sogio;
    }

    public void setSogio(String sogio) {
        this.sogio = sogio;
    }

    public String getPhucap() {
        return phucap;
    }

    public void setPhucap(String phucap) {
        this.phucap = phucap;
    }

    public String getTongkhautru() {
        return tongkhautru;
    }

    public void setTongkhautru(String tongkhautru) {
        this.tongkhautru = tongkhautru;
    }

    public String getBhxh() {
        return bhxh;
    }

    public void setBhxh(String bhxh) {
        this.bhxh = bhxh;
    }

    public String getBhyt() {
        return bhyt;
    }

    public void setBhyt(String bhyt) {
        this.bhyt = bhyt;
    }

    public String getBhtn() {
        return bhtn;
    }

    public void setBhtn(String bhtn) {
        this.bhtn = bhtn;
    }

    public String getTtncn() {
        return ttncn;
    }

    public void setTtncn(String ttncn) {
        this.ttncn = ttncn;
    }

    public String getTongluong() {
        return tongluong;
    }

    public void setTongluong(String tongluong) {
        this.tongluong = tongluong;
    }
   
   
}
