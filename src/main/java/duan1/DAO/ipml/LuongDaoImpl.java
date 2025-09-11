/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;


import duan1.DAO.LuongDao;
import duan1.entity.Luong;
import duan1.util.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LuongDaoImpl implements LuongDao {

    @Override
    public List<Luong> layTatCaBangLuong(String manv) {
       List<Luong> list = new ArrayList<>();
    String sql = "SELECT * FROM Luong WHERE manv = ?";

    try (
        Connection conn = XJdbc.openConnection(); 
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setString(1, manv);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Luong l = new Luong(
                rs.getString("maluong"),
                rs.getString("manv"),
                rs.getInt("thang"),
                rs.getInt("nam"),
                rs.getBigDecimal("luongcoban"),
                rs.getBigDecimal("luongphucap"),
                rs.getBigDecimal("thuong"),
                rs.getBigDecimal("khautru"),
                rs.getBigDecimal("tongluong"),
                rs.getDate("NgayTao"),
                rs.getString("NguoiTao"),
                rs.getString("GhiChu")
            );
            list.add(l);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
    }

    @Override
    public List<Luong> timKiemLuong(String manv, int thang, int nam) {
        
         List<Luong> list = new ArrayList<>();
        String sql = "SELECT * FROM Luong WHERE manv = ? AND thang = ? AND nam = ?";

        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, manv);
            ps.setInt(2, thang);
            ps.setInt(3, nam);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Luong l = new Luong(
                        rs.getString("maluong"),
                        rs.getString("manv"),
                        rs.getInt("thang"),
                        rs.getInt("nam"),
                        rs.getBigDecimal("luongcoban"),
                        rs.getBigDecimal("luongphucap"),
                        rs.getBigDecimal("thuong"),
                        rs.getBigDecimal("khautru"),
                        rs.getBigDecimal("tongluong"),
                        rs.getDate("NgayTao"),
                        rs.getString("NguoiTao"),
                        rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Luong> layBangLuongTheoMaNV(String manv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
