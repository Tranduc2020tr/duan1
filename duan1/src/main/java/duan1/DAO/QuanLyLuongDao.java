/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;


import duan1.entity.QuanLyLuong;
import java.util.List;

/**
 *
 * @author Hung Cuong
 */
public interface QuanLyLuongDao {
 void themluong(QuanLyLuong l);

    void capnhatluong(QuanLyLuong l);

    List<QuanLyLuong> laytatcabangluong();

    List<QuanLyLuong> timKiemLuong(String manv, int thang, int nam);

    List<QuanLyLuong> searchluong(String maNV,String maLuong);
    
    List<QuanLyLuong> searchLuongByHoTen(String hoTen, int thang, int nam);
    
    List<QuanLyLuong> searchLuongByHoTenOnly(String hoTen);

    void tinhLuongThang(String manv, int thang, int nam);

    boolean capNhatLuong(QuanLyLuong luong);

    boolean xoaLuong(String maluong);
    
    List<QuanLyLuong> getLuong3ThangQua();
    
    List<QuanLyLuong> getLuong6ThangQua();
    
    List<QuanLyLuong> getLuongNamNay();
    
    List<QuanLyLuong> getLuongNamNgoai();
    
    List<QuanLyLuong> getLuongTheoThangNam(int thang, int nam);
}
