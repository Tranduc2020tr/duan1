/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.sql.Date;

/**
 *
 * @author xloc2
 */
public class ThongTin {

    private String HoTen;
    private String Email;
    private String SDT;
    private String GioiTinh;
    private Date NgaySinh;
    private String DiaChi;
    private String MaPhong;
    private String MaChucVu;
    private String CCCD;
    private String TrinhDo;
    private String ChuyenNganh;
    private String photo;
    private String NguoiTao;
    private String trangThai;
    private Date ngayTao;
    private Date ngayVao;
    private String maNV;
    private String stt;

// Getter/Setter tương ứng
    public ThongTin() {
    }

    public ThongTin(String HoTen, String Email, String SDT, String GioiTinh, Date NgaySinh, String DiaChi, String MaPhong, String MaChucVu, String CCCD, String TrinhDo, String ChuyenNganh, String photo, String NguoiTao, String trangThai, Date ngayTao, Date ngayVao, String maNV, String stt) {
        this.HoTen = HoTen;
        this.Email = Email;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.MaPhong = MaPhong;
        this.MaChucVu = MaChucVu;
        this.CCCD = CCCD;
        this.TrinhDo = TrinhDo;
        this.ChuyenNganh = ChuyenNganh;
        this.photo = photo;
        this.NguoiTao = NguoiTao;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayVao = ngayVao;
        this.maNV = maNV;
        this.stt = stt;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getTrinhDo() {
        return TrinhDo;
    }

    public void setTrinhDo(String TrinhDo) {
        this.TrinhDo = TrinhDo;
    }

    public String getChuyenNganh() {
        return ChuyenNganh;
    }

    public void setChuyenNganh(String ChuyenNganh) {
        this.ChuyenNganh = ChuyenNganh;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

   

  

}