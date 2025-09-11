/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.controller;


import duan1.DAO.QuanLyLuongDao;

import duan1.DAO.ipml.QuanLyLuongIPLM1;
import duan1.entity.QuanLyLuong;
import java.util.List;

/**
 *
 * @author Hung Cuong
 */
public class QuanLyLuongControlner {

    private QuanLyLuongDao dao = new QuanLyLuongIPLM1();

    public void themluong(QuanLyLuong l) {
        dao.themluong(l);
    }

    public void capnhatluong(QuanLyLuong l) {
        dao.capnhatluong(l);
    }
    public List<QuanLyLuong> laytatcabangluong() {
        return dao.laytatcabangluong();
    }

    public List<QuanLyLuong> searchLuong(String manv, String maluong) {
        return dao.searchluong(manv, maluong); // gọi DAO đúng chưa?
    }
    
    public List<QuanLyLuong> searchLuongByHoTen(String hoTen, int thang, int nam) {
        return dao.searchLuongByHoTen(hoTen, thang, nam);
    }
    
    public List<QuanLyLuong> searchLuongByHoTenOnly(String hoTen) {
        return dao.searchLuongByHoTenOnly(hoTen);
    }

    public void themLuong(String manv, int thang, int nam) {
        dao.tinhLuongThang(manv, thang, nam);
    }
    
    public List<QuanLyLuong> getLuong3ThangQua() {
        return dao.getLuong3ThangQua();
    }
    
    public List<QuanLyLuong> getLuong6ThangQua() {
        return dao.getLuong6ThangQua();
    }
    
    public List<QuanLyLuong> getLuongNamNay() {
        return dao.getLuongNamNay();
    }
    
    public List<QuanLyLuong> getLuongNamNgoai() {
        return dao.getLuongNamNgoai();
    }
    
    public List<QuanLyLuong> getLuongTheoThangNam(int thang, int nam) {
        return dao.getLuongTheoThangNam(thang, nam);
    }
}
