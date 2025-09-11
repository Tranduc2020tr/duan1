/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class phongban {
    String mapb;
    String tenpb;
    String mota;
    
    public phongban(){}

    public phongban(String mapb, String tenpb, String mota) {
        this.mapb = mapb;
        this.tenpb = tenpb;
        this.mota = mota;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
    
    @Override
    public String toString() {
        return tenpb;
    }
}
