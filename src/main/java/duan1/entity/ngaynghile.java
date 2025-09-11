package duan1.entity;

import java.time.LocalDate;

public class ngaynghile {
    private String maLe;
    private LocalDate ngay;
    private String tenLe;
    private boolean coTinhLuong;

    // Constructor mặc định
    public ngaynghile() {}

    // Constructor không có mã lễ

    public ngaynghile(String maLe, LocalDate ngay, String tenLe, boolean coTinhLuong) {
        this.maLe = maLe;
        this.ngay = ngay;
        this.tenLe = tenLe;
        this.coTinhLuong = coTinhLuong;
    }

    public String getMaLe() {
        return maLe;
    }

    public void setMaLe(String maLe) {
        this.maLe = maLe;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public String getTenLe() {
        return tenLe;
    }

    public void setTenLe(String tenLe) {
        this.tenLe = tenLe;
    }

    public boolean isCoTinhLuong() {
        return coTinhLuong;
    }

    public void setCoTinhLuong(boolean coTinhLuong) {
        this.coTinhLuong = coTinhLuong;
    }
   
}
