/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.chamcongDAO;
import duan1.entity.Thongkechamcong;
import duan1.entity.chamcong;
import duan1.util.XJdbc;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class chamcongimpl implements chamcongDAO {

    String sqlCheckIn = "INSERT INTO ChamCong (MaNV, Ngay, CheckIn) VALUES (?, ?, ?)";
    String sqlCheckOut = "UPDATE ChamCong SET CheckOut = ? WHERE MaNV = ? AND Ngay = ?";
    String sqlCheckInExists = "SELECT COUNT(*) FROM ChamCong WHERE MaNV = ? AND Ngay = ?";
    String sqlCheckOutExists = "SELECT CheckOut FROM ChamCong WHERE MaNV = ? AND Ngay = ?";
 
    
    
    @Override
    public void checkIn(chamcong entity) {
        try {
            // Kiểm tra đã check-in chưa
            Integer count = XJdbc.getValue(sqlCheckInExists, entity.getMaNV(), entity.getNgay());
            if (count != null && count > 0) {
                throw new RuntimeException("Nhân viên đã check in hôm nay rồi!");
            }

            Object[] values = {
                entity.getMaNV(),
                entity.getNgay(),
                entity.getCheckIn()
            };
            int result = XJdbc.executeUpdate(sqlCheckIn, values);
            System.out.println("Check In thành công: " + result + " dòng được chèn");
        } catch (Exception e) {
            System.err.println("Lỗi khi check in: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void checkOut(String maNV, Date ngay, Time gioRa) {
        try {
            // Kiểm tra đã check-in
            Integer count = XJdbc.getValue(sqlCheckInExists, maNV, ngay);
            if (count == null || count == 0) {
                throw new RuntimeException("Nhân viên chưa check in hôm nay!");
            }

            // Kiểm tra đã check-out chưa
            Time gioDaRa = XJdbc.getValue(sqlCheckOutExists, maNV, ngay);
            if (gioDaRa != null) {
                throw new RuntimeException("Nhân viên đã check out hôm nay rồi!");
            }

            int result = XJdbc.executeUpdate(sqlCheckOut, gioRa, maNV, ngay);
            System.out.println("Check Out thành công: " + result + " dòng được cập nhật");

        } catch (Exception e) {
            System.err.println("Lỗi khi check out: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public chamcong create(chamcong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(chamcong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<chamcong> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public chamcong findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public Time getGioCheckIn(String maNV, Date ngay) {
    String sql = "SELECT CheckIn FROM ChamCong WHERE MaNV = ? AND Ngay = ?";
    try (Connection con = XJdbc.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps. setString(1, maNV);
        ps.setDate(2, new java.sql.Date(ngay.getTime()));

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getTime("CheckIn");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    @Override
    public Thongkechamcong thongkechamcong(String maNV, int thang, int nam) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<chamcong> findall2(String manv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<chamcong> searchChamCong(String manv, int thang, int nam) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}


   
   


