/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.math.BigDecimal;

/**
 *
 * @author hang
 */
public class chucvu {
    String macv;
    String tencv;
    String mota;
    BigDecimal luongcoban;
    
    public chucvu(){}

    public chucvu(String macv, String tencv, String mota, BigDecimal luongcoban) {
        this.macv = macv;
        this.tencv = tencv;
        this.mota = mota;
        this.luongcoban = luongcoban;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public BigDecimal getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(BigDecimal luongcoban) {
        this.luongcoban = luongcoban;
    }
    
    @Override
    public String toString() {
        return tencv;
    }
}
