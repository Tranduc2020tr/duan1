/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.hopdongDAO;
import duan1.entity.Hopdong;
import duan1.util.XJdbc;
import java.sql.Connection;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class Hopdongipml implements hopdongDAO {

    String create = "INSERT INTO HopDong (MaNV, MaLoaiHD, NgayBatDau, NgayKetThuc, LuongThoaThuan, TrangThai, GhiChu, NgayTao, NguoiTao) VALUES (?,?,?,?,?,?,?,?,?)";

    String update = "UPDATE HopDong SET MaLoaiHD = ?,NgayBatDau = ?,NgayKetThuc = ?, LuongThoaThuan = ?, TrangThai = ?, GhiChu = ?,NguoiTao = ? WHERE MaHD = ?";
    String deleteid = "DELETE FROM HopDong WHERE MaHD = ?";

    String findall = "SELECT \n"
            + "    a.MaHD, \n"
            + "    a.MaNV, \n"
            + "    b.HoTen,\n"
            + "    c.TenLoai,\n"
            + "    a.NgayBatDau,\n"
            + "    a.NgayKetThuc,\n"
            + "    a.LuongThoaThuan,\n"
            + "    a.TrangThai,\n"
            + "    a.GhiChu,\n"
            + "    a.NgayTao,\n"
            + "    a.NguoiTao \n"
            + "FROM \n"
            + "    HopDong a\n"
            + "JOIN \n"
            + "    NhanVien b ON a.MaNV = b.MaNV\n"
            + "JOIN \n"
            + "    LoaiHopDong c ON a.MaLoaiHD = c.MaLoaiHD";
    String findbyMaNV = "SELECT * FROM HopDong WHERE MaHD = ?";

    private java.sql.Date safeSqlDate(String yyyyMmDd) {
        try {
            if (yyyyMmDd == null) return null;
            String s = yyyyMmDd.trim();
            if (s.isEmpty()) return null;
            // Chỉ nhận yyyy-MM-dd
            return java.sql.Date.valueOf(s);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    @Override
    public Hopdong create(Hopdong entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {

            // Không set MaHD vì SQL sẽ tự động tạo (AUTO_INCREMENT)
            stmt.setString(1, entity.getManv());
            stmt.setString(2, entity.getMaloaihd());
            // Chuyển String yyyy-MM-dd sang java.sql.Date an toàn
            stmt.setDate(3, safeSqlDate(entity.getNgaybatdau()));
            stmt.setDate(4, safeSqlDate(entity.getNgayketthuc()));
            stmt.setString(5, entity.getLuongthoathuan());
            stmt.setString(6, entity.getTrangthai());
            stmt.setString(7, entity.getGhichu());
            // Ngày tạo lưu dạng yyyy-MM-dd
            stmt.setDate(8, safeSqlDate(entity.getNgaytao()));
            stmt.setString(9, entity.getNguoitao());

            stmt.executeUpdate();

            // Lấy MaHD được tự động tạo và set vào entity
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setMahd(generatedKeys.getString(1));
                }
            }

            return entity;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Hopdong entity) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(update)) {

            stmt.setString(1, entity.getMaloaihd());
            stmt.setDate(2, safeSqlDate(entity.getNgaybatdau()));
            stmt.setDate(3, safeSqlDate(entity.getNgayketthuc()));
            stmt.setString(4, entity.getLuongthoathuan());
            stmt.setString(5, entity.getTrangthai());
            stmt.setString(6, entity.getGhichu());
            stmt.setString(7, entity.getNguoitao());
            stmt.setString(8, entity.getMahd());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(deleteid)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hopdong> findAll() {
        List<Hopdong> list = new ArrayList<>();
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(findall); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hopdong hd = new Hopdong();
                hd.setMahd(rs.getString("MaHD"));
                hd.setManv(rs.getString("MaNV"));
                hd.setHoten(rs.getString("HoTen"));
                hd.setMaloaihd(rs.getString("TenLoai"));
                hd.setNgaybatdau(rs.getString("NgayBatDau"));
                hd.setNgayketthuc(rs.getString("NgayKetThuc"));
                hd.setLuongthoathuan(rs.getString("LuongThoaThuan"));
                hd.setTrangthai(rs.getString("TrangThai"));
                hd.setGhichu(rs.getString("GhiChu"));
                hd.setNgaytao(rs.getString("NgayTao"));
                hd.setNguoitao(rs.getString("NguoiTao"));

                list.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Hopdong findById(String id) {
        Hopdong hd = null;
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(findbyMaNV)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hd = new Hopdong();
                    hd.setMahd(rs.getString("MaHD"));
                    hd.setManv(rs.getString("MaNV"));
                    hd.setMaloaihd(rs.getString("MaLoaiHD"));
                    hd.setNgaybatdau(rs.getString("NgayBatDau"));
                    hd.setNgayketthuc(rs.getString("NgayKetThuc"));
                    hd.setLuongthoathuan(rs.getString("LuongThoaThuan"));
                    hd.setTrangthai(rs.getString("TrangThai"));
                    hd.setGhichu(rs.getString("GhiChu"));
                    hd.setNgaytao(rs.getString("NgayTao"));
                    hd.setNguoitao(rs.getString("NguoiTao"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

}
