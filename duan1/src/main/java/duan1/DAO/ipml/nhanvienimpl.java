/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.nhanvienDAO;
import duan1.entity.nhanvien;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hang
 */
public class nhanvienimpl implements nhanvienDAO {

    String create = "insert into NhanVien (HoTen,Email,SDT,GioiTinh,NgaySinh,DiaChi,TrangThai,MaPhong,MaChucVu,CCCD,NguoiTao,TrinhDo,ChuyenNganh,photo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String update = "UPDATE NhanVien SET HoTen=?, Email=?, SDT=?, GioiTinh=?, NgaySinh=?, DiaChi=?, TrangThai=?, MaPhong=?, MaChucVu=?, CCCD=?, NguoiTao=?, TrinhDo=?, ChuyenNganh=?, photo=? WHERE MaNV=?";
    String deleteid = "EXEC sp_XoaNhanVien @MaNV = ?";
    String findAll = "SELECT * FROM NhanVien";
    String findById = "SELECT * FROM NhanVien WHERE MaNV = ?";

    @Override
    public nhanvien create(nhanvien entity) {

        try {
            Object[] values = {
                entity.getHoTen(),
                entity.getEmail(),
                entity.getSdt(),
                entity.getGioiTinh(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getTrangThai(),
                entity.getMaPhong(),
                entity.getMaChucVu(),
                entity.getCccd(),
                entity.getNguoiTao(),
                entity.getTrinhdo(),
                entity.getChuyennganh(),
                entity.getPhoto()
            };
            XJdbc.executeUpdate(create, values);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi thêm nhân viên: " + e.getMessage());
        }
    }

    @Override
    public void update(nhanvien entity) {

        Object[] values = {
            entity.getHoTen(),
            entity.getEmail(),
            entity.getSdt(),
            entity.getGioiTinh(),
            entity.getNgaySinh(),
            entity.getDiaChi(),
            entity.getTrangThai(),
            entity.getMaPhong(),
            entity.getMaChucVu(),
            entity.getCccd(),
            entity.getNguoiTao(),
            entity.getTrinhdo(),
            entity.getChuyennganh(),
            entity.getPhoto(),
            entity.getMaNV()
        };
        XJdbc.executeUpdate(update, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.update(deleteid, id);
    }

    @Override
public List<nhanvien> findAll() {
    List<nhanvien> list = new ArrayList<>();
    
    try (
        Connection conn = XJdbc.openConnection();
        PreparedStatement ps = conn.prepareStatement(findAll);
        ResultSet rs = ps.executeQuery()
    ) {
        while (rs.next()) {
            nhanvien nv = new nhanvien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setHoTen(rs.getString("HoTen"));
            nv.setEmail(rs.getString("Email"));
            nv.setSdt(rs.getString("SDT"));
            nv.setGioiTinh(rs.getString("GioiTinh"));
            nv.setNgaySinh(rs.getString("NgaySinh"));
            nv.setDiaChi(rs.getString("DiaChi"));
            nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
            nv.setTrangThai(rs.getString("TrangThai"));
            nv.setMaPhong(rs.getString("MaPhong"));
            nv.setMaChucVu(rs.getString("MaChucVu"));
            nv.setCccd(rs.getString("CCCD"));
            nv.setNgayTao(rs.getTimestamp("NgayTao"));
            nv.setNguoiTao(rs.getString("NguoiTao"));
            nv.setTrinhdo(rs.getString("TrinhDo"));
            nv.setChuyennganh(rs.getString("ChuyenNganh"));
            nv.setPhoto(rs.getString("photo"));
            list.add(nv);
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
    }
    return list;
}


    @Override
    public nhanvien findById(String id) {
        return XQuery.getSingleBean(nhanvien.class, findById, id);
    }

    public static boolean doiMatKhauTheoEmail(String email, String newPassword) {
    String sql = "UPDATE T SET matkhau = ? " +
                 "FROM taikhoan T JOIN NhanVien N ON T.MaNV = N.MaNV " +
                 "WHERE LOWER(LTRIM(RTRIM(N.Email))) = ?";
    try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, newPassword);
        ps.setString(2, email.trim().toLowerCase());
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    /**
     * Kiểm tra email có tồn tại trong bảng NhanVien hay không
     * @param email Email cần kiểm tra
     * @return true nếu tồn tại, false nếu không
     */
    public static boolean checkEmailExists(String email) {
        String sql = "update taikhoan set matkhau = ? from taikhoan T JOIN NhanVien N ON T.MaNV = N.MaNV WHERE N.Email = ?";
        try (Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email.trim().toLowerCase());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    


}
