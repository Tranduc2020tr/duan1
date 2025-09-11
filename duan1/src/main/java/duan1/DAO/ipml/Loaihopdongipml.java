/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.loaihopdongDAO;
import duan1.entity.Hopdong;
import duan1.entity.Loaihopdong;
import duan1.util.XJdbc;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class Loaihopdongipml implements loaihopdongDAO {

    String create = "INSERT INTO LoaiHopDong (TenLoai, ThoiHanThang, GhiChu) VALUES (?,?,?)";
    String update = "UPDATE LoaiHopDong SET TenLoai = ?, ThoiHanThang = ?, GhiChu = ? WHERE MaLoaiHD = ?";
    String deleteid = "DELETE FROM LoaiHopDong WHERE MaLoaiHD = ?";
    String findall = "select * from LoaiHopDong";
    String findbyid = "select * from LoaiHopDong where MaLoaiHD = ?   ";
    String sql1 = "SELECT\n" +
"    nv.MaNV,\n" +
"    nv.HoTen,\n" +
"    pb.tenpb AS TenPhongBan,\n" +
"    cv.tencv AS TenChucVu,\n" +
"    N'Chưa có hợp đồng' AS TrangThaiHopDong\n" +
"FROM\n" +
"    NhanVien nv\n" +
"LEFT JOIN\n" +
"    HopDong hd ON nv.MaNV = hd.MaNV\n" +
"LEFT JOIN \n" +
"    phongban pb ON nv.MaPhong = pb.mapb\n" +
"LEFT JOIN \n" +
"    chucvu cv ON nv.MaChucVu = cv.macv\n" +
"WHERE\n" +
"    hd.MaHD IS NULL;";
    
    

    @Override
    public Loaihopdong create(Loaihopdong entity) {

        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(create, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, entity.getTenloai());
            stmt.setInt(2, entity.getThoihan());
            stmt.setString(3, entity.getGhichu());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                return entity;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Loaihopdong entity) {

        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(update)) {

            stmt.setString(1, entity.getTenloai());
            stmt.setInt(2, entity.getThoihan());
            stmt.setString(3, entity.getGhichu());
            stmt.setString(4, entity.getMaloai());

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
    public List<Loaihopdong> findAll() {
        List<Loaihopdong> list = new ArrayList<>();
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(findall); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Loaihopdong lhd = new Loaihopdong();
                lhd.setMaloai(rs.getString("MaLoaiHD"));
                lhd.setTenloai(rs.getString("TenLoai"));
                lhd.setThoihan(rs.getInt("ThoiHanThang"));
                lhd.setGhichu(rs.getString("GhiChu"));
                list.add(lhd);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Loaihopdong findById(String id) {
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(findbyid)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Loaihopdong lhd = new Loaihopdong();
                    lhd.setMaloai(rs.getString("MaLoaiHD"));
                    lhd.setTenloai(rs.getString("TenLoai"));
                    lhd.setThoihan(rs.getInt("ThoiHanThang"));
                    lhd.setGhichu(rs.getString("GhiChu"));
                    return lhd;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  @Override
public List<Hopdong> sql1() {
    List<Hopdong> list = new ArrayList<>();
    try (Connection conn = XJdbc.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql1);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Hopdong hd = new Hopdong();
            hd.setManv(rs.getString("MaNV"));
            hd.setHoten(rs.getString("HoTen"));
            hd.setTenPhongBan(rs.getString("TenPhongBan"));
            hd.setTenChucVu(rs.getString("TenChucVu"));
            hd.setTrangThaiHopDong(rs.getString("TrangThaiHopDong"));
            list.add(hd);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}


}
