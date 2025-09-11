/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.chitietphieuluongDAO;
import duan1.entity.chitietphieuluong;
import duan1.util.XJdbc;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hang
 */

    
public class chitietphieuluongimpl implements chitietphieuluongDAO {

    @Override
    public List<chitietphieuluong> getByThangNam(String manv, int Thang, int nam) {
        List<chitietphieuluong> list = new ArrayList<>();
        
        // Lấy dữ liệu từ bảng Luong và NhanVien
        String sql = "SELECT l.*, nv.hoten, nv.sdt, nv.diachi, nv.cccd, nv.email, nv.trinhdo, nv.chuyennganh " +
                    "FROM Luong l " +
                    "INNER JOIN NhanVien nv ON l.manv = nv.MaNV " +
                    "WHERE l.manv = ? AND l.thang = ? AND l.nam = ?";

        try (Connection con = XJdbc.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, manv);
            ps.setInt(2, Thang);
            ps.setInt(3, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    chitietphieuluong ct = new chitietphieuluong();
                    
                    // Thông tin cơ bản
                    ct.setManv(rs.getString("manv"));
                    ct.setHoten(rs.getString("hoten"));
                    
                    // Ước tính số ngày đi làm (giả sử 22 ngày/tháng)
                    ct.setDilam(22);
                    
                    // Ước tính số giờ (8 giờ/ngày * 22 ngày)
                    ct.setSogio("176");
                    
                    // Lấy từ bảng Luong
                    ct.setPhucap(rs.getBigDecimal("luongphucap").toString());
                    ct.setTongkhautru(rs.getBigDecimal("khautru").toString());
                    
                    // Tính các loại bảo hiểm và thuế (giả sử tỷ lệ cố định)
                    double luongCoban = rs.getBigDecimal("luongcoban").doubleValue();
                    double phuCap = rs.getBigDecimal("luongphucap").doubleValue();
                    double thuong = rs.getBigDecimal("thuong").doubleValue();
                    double tongThuNhap = luongCoban + phuCap + thuong;
                    
                    // BHXH: 8% của lương cơ bản
                    double bhxh = luongCoban * 0.08;
                    ct.setBhxh(String.valueOf((int)bhxh));
                    
                    // BHYT: 1.5% của lương cơ bản
                    double bhyt = luongCoban * 0.015;
                    ct.setBhyt(String.valueOf((int)bhyt));
                    
                    // BHTN: 1% của lương cơ bản
                    double bhtn = luongCoban * 0.01;
                    ct.setBhtn(String.valueOf((int)bhtn));
                    
                    // Thuế TNCN: 5% của tổng thu nhập (đơn giản hóa)
                    double thueTNCN = tongThuNhap * 0.05;
                    ct.setTtncn(String.valueOf((int)thueTNCN));
                    
                    // Tổng lương thực nhận = Tổng thu nhập - Tổng khấu trừ
                    double tongLuong = tongThuNhap - rs.getBigDecimal("khautru").doubleValue();
                    ct.setTongluong(String.valueOf((int)tongLuong));
                    
                    list.add(ct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    
    }

   
}

