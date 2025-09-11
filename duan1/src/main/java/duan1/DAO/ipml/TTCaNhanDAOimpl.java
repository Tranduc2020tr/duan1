/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;


import duan1.DAO.TTCaNhanDAO;
import duan1.entity.ThongTin;
import duan1.util.XAuth;
import static duan1.util.XJdbc.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author xloc2
 */
public class TTCaNhanDAOimpl implements TTCaNhanDAO {

    String findByIdSql = "SELECT * FROM NhanVien WHERE MaNV = ?";

    private Connection getConnection() throws SQLException {
        return openConnection();
    }

    @Override
    public void insert(ThongTin tt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThongTin> findByMaNV(String MaNV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThongTin> findByMonthAndYear(int month, int year) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ThongTin findById(String MaNV) {
        String findByIdSql = "SELECT * FROM NhanVien WHERE MaNV = ?";
    
    try (Connection conn = getConnection(); 
         PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
        
        stmt.setString(1, MaNV);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                ThongTin tt = new ThongTin();
                tt.setMaNV(rs.getString("MaNV"));
                tt.setHoTen(rs.getString("HoTen"));
                tt.setEmail(rs.getString("Email"));
                tt.setSDT(rs.getString("SDT"));
                tt.setGioiTinh(rs.getString("GioiTinh"));
                tt.setNgaySinh(rs.getDate("NgaySinh"));
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setMaPhong(rs.getString("MaPhong"));
                tt.setMaChucVu(rs.getString("MaChucVu"));
                tt.setCCCD(rs.getString("CCCD"));
                tt.setTrinhDo(rs.getString("TrinhDo"));
                tt.setChuyenNganh(rs.getString("ChuyenNganh"));
                tt.setPhoto(rs.getString("photo"));
                tt.setNguoiTao(rs.getString("NguoiTao"));
                tt.setNgayTao(rs.getDate("NgayTao"));
                // tt.setNgayVao(rs.getDate("NgayVao")); // Không có cột này
                tt.setTrangThai(rs.getString("TrangThai"));
                return tt;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
    }
    

    @Override
    public List<ThongTin> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThongTin> findByTrangThai(String trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
