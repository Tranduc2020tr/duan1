/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.dangkitangcaDAO;
import duan1.entity.dangkitangca;
import duan1.util.XJdbc;
import static duan1.util.XJdbc.openConnection;
import java.util.List;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class dangkitangcaimpl implements dangkitangcaDAO {

    String insertSql = "INSERT INTO TangCa (MaNV, Ngay, CheckIn, LoaiTangCa, HeSo, GhiChu, NguoiTao) VALUES (?,?,?,?,?,?,?)";

    String updateSql = "UPDATE TangCa SET MaNV = ?, Ngay = ?, SoGio = ?, LoaiTangCa = ?, HeSo = ?, GhiChu = ?, NgayTao = ?, NguoiTao = ? WHERE MaTangCa = ?";
    String deleteSql = "DELETE FROM TangCa WHERE MaTangCa = ?";
    String findByIdSql = "SELECT * FROM TangCa WHERE MaTangCa = ?";
    String checkouut = "UPDATE TangCa SET CheckOut = ? WHERE MaTangCa = ?";

    @Override
    public dangkitangca create(dangkitangca entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(insertSql)) {
            ps.setString(1, entity.getMaNV());
            ps.setString(2, entity.getNgay());
            ps.setString(3, entity.getCheckin());
            ps.setString(4, entity.getLoaiTangCa());
            ps.setDouble(5, entity.getHeSo());
            ps.setString(6, entity.getGhiChu());
            ps.setString(7, entity.getNguoiTao());

            ps.executeUpdate();
            return entity;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(dangkitangca entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(updateSql)) {
            ps.setString(1, entity.getMaNV());
            ps.setString(2, entity.getNgay());
            ps.setString(3, entity.getCheckin());
            ps.setString(4, entity.getCheckout());
            ps.setDouble(5, entity.getHeSo());
            ps.setString(6, entity.getTrangThai());
            ps.setString(7, entity.getGhiChu());
            ps.setString(8, entity.getNguoiTao());
            ps.setString(9, entity.getMaTangCa());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(deleteSql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public dangkitangca findById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(findByIdSql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dangkitangca tc = new dangkitangca();
                    tc.setMaNV(rs.getString("MaNV"));
                    tc.setNgay(rs.getString("Ngay"));
                    tc.setCheckin(rs.getString("checkin"));
                    tc.setCheckout(rs.getString("checkout"));
                    tc.setSoGio(rs.getInt("SoGio"));
                    tc.setLoaiTangCa(rs.getString("LoaiTangCa"));
                    tc.setHeSo(rs.getFloat("HeSo"));
                    tc.setGhiChu(rs.getString("GhiChu"));
                    tc.setTrangThai(rs.getString("TrangThai"));
                    tc.setNguoiTao(rs.getString("NguoiTao"));
                    tc.setMaTangCa(rs.getString("MaTangCa"));
                    return tc;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<dangkitangca> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<dangkitangca> fillall1(String manv) {
        List<dangkitangca> list = new ArrayList<>();
        String sql = "SELECT matangca, manv, ngay, checkin, checkout, sogio, loaitangca, heso, ghichu, trangthai, nguoitao FROM TangCa WHERE manv = ?";

        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, manv);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dangkitangca tc = new dangkitangca();
                tc.setMaTangCa(rs.getString("matangca"));
                tc.setMaNV(rs.getString("manv"));
                tc.setNgay(rs.getString("ngay"));
                tc.setCheckin(rs.getString("checkin"));
                tc.setCheckout(rs.getString("checkout"));
                tc.setSoGio(rs.getInt("sogio"));
                tc.setLoaiTangCa(rs.getString("loaitangca"));
                tc.setHeSo(rs.getDouble("heso"));
                tc.setGhiChu(rs.getString("ghichu"));
                tc.setTrangThai(rs.getString("trangthai"));
                tc.setNguoiTao(rs.getString("nguoitao"));

                list.add(tc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi truy vấn theo mã nhân viên", e);
        }

        return list;
    }

    public void updateCheckout(String maTangCa, String checkout2q3) {
        String sql = "UPDATE TangCa SET CheckOut = ? WHERE matangca = ? AND CheckOut IS NULL";
        try (Connection con = openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Extract numeric ID from values like "#TC0005"
           

            ps.setString(1, checkout2q3);
              ps.setString(2, maTangCa); 
            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("Không có ca nào để check out.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public dangkitangca findCurrentOvertimeRecord(String maNV, String ngay) {
        String sql = "SELECT * FROM TangCa WHERE MaNV = ? AND Ngay = ? AND CheckOut IS NULL ORDER BY CheckIn DESC";
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maNV);
            ps.setString(2, ngay);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dangkitangca tc = new dangkitangca();
                    tc.setMaTangCa(rs.getString("MaTangCa"));
                    tc.setMaNV(rs.getString("MaNV"));
                    tc.setNgay(rs.getString("Ngay"));
                    tc.setCheckin(rs.getString("CheckIn"));
                    tc.setCheckout(rs.getString("CheckOut"));
                    tc.setSoGio(rs.getInt("SoGio"));
                    tc.setLoaiTangCa(rs.getString("LoaiTangCa"));
                    tc.setHeSo(rs.getDouble("HeSo"));
                    tc.setGhiChu(rs.getString("GhiChu"));
                    tc.setTrangThai(rs.getString("TrangThai"));
                    tc.setNguoiTao(rs.getString("NguoiTao"));
                    return tc;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public dangkitangca findAnyOvertimeRecord(String maNV, String ngay) {
        String sql = "SELECT * FROM TangCa WHERE MaNV = ? AND Ngay = ? ORDER BY CheckIn DESC";
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, maNV);
            ps.setString(2, ngay);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dangkitangca tc = new dangkitangca();
                    tc.setMaTangCa(rs.getString("MaTangCa"));
                    tc.setMaNV(rs.getString("MaNV"));
                    tc.setNgay(rs.getString("Ngay"));
                    tc.setCheckin(rs.getString("CheckIn"));
                    tc.setCheckout(rs.getString("CheckOut"));
                    tc.setSoGio(rs.getInt("SoGio"));
                    tc.setLoaiTangCa(rs.getString("LoaiTangCa"));
                    tc.setHeSo(rs.getDouble("HeSo"));
                    tc.setGhiChu(rs.getString("GhiChu"));
                    tc.setTrangThai(rs.getString("TrangThai"));
                    tc.setNguoiTao(rs.getString("NguoiTao"));
                    return tc;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
