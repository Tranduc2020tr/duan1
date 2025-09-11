/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author hang
 */
public class quanlytaikhoan {
    String tendangnhap;
    String matkhau;
    String manv;
    boolean vaitro;
    boolean trangthai;
    String hoten;
    int roleid;
    String rolename;
    
    public quanlytaikhoan(){}

    public quanlytaikhoan(String tendangnhap, String matkhau, String manv, boolean vaitro, boolean trangthai, String hoten, int roleid, String rolename) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.manv = manv;
        this.vaitro = vaitro;
        this.trangthai = trangthai;
        this.hoten = hoten;
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    
    
}
