/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.ngaynghileDAO;
import duan1.entity.ngaynghile;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class ngaynghileipml implements ngaynghileDAO {

    private Connection getConnection() throws SQLException {
         return duan1.util.XJdbc.openConnection();
    }

    @Override
    public ngaynghile create(ngaynghile entity) {
        String sql = "INSERT INTO NgayNghiLe (Ngay, TenLe, CoTinhLuong) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(entity.getNgay()));
            ps.setString(2, entity.getTenLe());
            ps.setBoolean(3, entity.isCoTinhLuong());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                entity.setMaLe(rs.getString(1));
            }
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(ngaynghile entity) {
        String sql = "UPDATE NgayNghiLe SET Ngay = ?, TenLe = ?, CoTinhLuong = ? WHERE MaLe = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(entity.getNgay()));
            ps.setString(2, entity.getTenLe());
            ps.setBoolean(3, entity.isCoTinhLuong());
            ps.setString(4, entity.getMaLe());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM NgayNghiLe WHERE MaLe = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ngaynghile> findAll() {
        List<ngaynghile> list = new ArrayList<>();
        String sql = "SELECT MaLe, Ngay, TenLe, CoTinhLuong FROM NgayNghiLe";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ngaynghile n = new ngaynghile();
                n.setMaLe(rs.getString("MaLe"));
                n.setNgay(rs.getDate("Ngay").toLocalDate());
                n.setTenLe(rs.getString("TenLe"));
                n.setCoTinhLuong(rs.getBoolean("CoTinhLuong"));
                list.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ngaynghile findById(Integer id) {
        String sql = "SELECT MaLe, Ngay, TenLe, CoTinhLuong FROM NgayNghiLe WHERE MaLe = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ngaynghile n = new ngaynghile();
                n.setMaLe(rs.getString("MaLe"));
                n.setNgay(rs.getDate("Ngay").toLocalDate());
                n.setTenLe(rs.getString("TenLe"));
                n.setCoTinhLuong(rs.getBoolean("CoTinhLuong"));
                return n;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

