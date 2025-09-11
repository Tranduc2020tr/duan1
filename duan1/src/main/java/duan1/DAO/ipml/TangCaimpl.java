package duan1.DAO.ipml;

import duan1.DAO.TangCaDAO;
import duan1.entity.TangCa;
import duan1.util.XJdbc;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class TangCaimpl implements TangCaDAO {
    
    String insertSql = "INSERT INTO TangCa (MaNV, Ngay, CheckIn, CheckOut, LoaiTangCa, HeSo, TrangThai, GhiChu, NguoiTao VALUES (?,?,?,?,?,?,?,?,?)";
    String updateSql = "UPDATE TangCa SET MaNV = ?, Ngay = ?, LoaiTangCa = ?, TrangThai = ?, GhiChu = ?, NguoiTao = ? WHERE MaTangCa = ?";
    String deleteSql = "DELETE FROM TangCa WHERE MaTangCa = ?";
    String findAllSql = "SELECT  a.matangca,a.manv,b.hoten,a.ngay,a.checkin,a.checkout,a.sogio,a.loaitangca,a.heso,a.ghichu,a.trangthai,a.nguoitao FROM TangCa a join nhanvien b on b.manv = a.manv";
    String findByIdSql = "SELECT * FROM TangCa WHERE MaTangCa = ?";
    
    @Override
    public TangCa create(TangCa entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(insertSql)) {
            ps.setString(1, entity.getMaNV());
            ps.setString(2, entity.getNgay());
            ps.setString(3, entity.getCheckin());
            ps.setString(4, entity.getCheckout());
            ps.setString(5, entity.getLoaiTangCa());
            ps.setDouble(6, entity.getHeSo());
            ps.setString(7, entity.getTrangThai());
            ps.setString(8, entity.getGhiChu());
            ps.setString(9, entity.getNguoiTao());
            ps.executeUpdate();
            return entity;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void update(TangCa entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(updateSql)) {
            ps.setString(1, entity.getMaNV());
            ps.setString(2, entity.getNgay());
            ps.setString(3, entity.getLoaiTangCa());
           
            ps.setString(4, entity.getTrangThai());
            ps.setString(5, entity.getGhiChu());
            ps.setString(6, entity.getNguoiTao());
            ps.setString(7, entity.getMaTangCa());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void deleteById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(deleteSql)) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<TangCa> findAll() {
        List<TangCa> list = new ArrayList<>();
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(findAllSql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TangCa tc = new TangCa();
                tc.setMaTangCa(rs.getString("MaTangCa"));
                tc.setMaNV(rs.getString("MaNV"));
                tc.setHoten(rs.getString("hoten"));
                tc.setNgay(rs.getString("Ngay"));
                tc.setCheckin(rs.getString("checkin"));
                tc.setCheckout(rs.getString("checkout"));
                tc.setSoGio(rs.getInt("SoGio"));
                tc.setLoaiTangCa(rs.getString("LoaiTangCa"));
                tc.setHeSo(rs.getFloat("HeSo"));
                tc.setGhiChu(rs.getString("GhiChu"));
                tc.setTrangThai(rs.getString("TrangThai"));
                tc.setNguoiTao(rs.getString("NguoiTao"));
                list.add(tc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public TangCa findById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(findByIdSql)) {
            ps.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TangCa tc = new TangCa();
                    tc.setMaNV(rs.getString("MaNV"));
                    tc.setHoten(rs.getString("hoten"));
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
    public List<TangCa> fillall1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
