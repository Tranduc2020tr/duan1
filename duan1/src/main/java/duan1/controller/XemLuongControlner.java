/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.controller;



import duan1.DAO.LuongDao;
import duan1.DAO.ipml.LuongDaoImpl;
import duan1.entity.Luong;
import duan1.util.XJdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

public class XemLuongControlner {
    private LuongDao dao = new LuongDaoImpl();

    // ✅ Truyền tham số manv đã có, không khai báo lại kiểu
    public List<Luong> layTatCaBangLuong(String manv) {
        return dao.layTatCaBangLuong(manv);
    }

    public List<Luong> searchLuong(String manv, int thang, int nam) {
        return dao.timKiemLuong(manv, thang, nam);
    }

    public void tinhLuong(String manv, int thang, int nam) {
        try (Connection conn = XJdbc.openConnection();
             CallableStatement cs = conn.prepareCall("{call sp_TinhLuongThang(?, ?, ?)}")) {
            cs.setString(1, manv);
            cs.setInt(2, thang);
            cs.setInt(3, nam);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Luong> layBangLuongTheoMaNV(String manv) {
        return dao.layBangLuongTheoMaNV(manv);
    }
}



