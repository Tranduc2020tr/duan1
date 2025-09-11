/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.UserDAO;
import duan1.entity.User;
import static duan1.util.XJdbc.openConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xloc2
 */
public class UserDAOimpl implements UserDAO {

    String insertSql = "INSERT INTO TaiKhoan (tendangnhap, matkhau, MaNV, RoleID, TrangThai) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE TaiKhoan SET matkhau = ?, MaNV = ?, RoleID = ?, TrangThai = ? WHERE tendangnhap = ?";
    String deleteSql = "DELETE FROM TaiKhoan WHERE tendangnhap = ?";
    
    String findAllSql = """
        SELECT a.tendangnhap, a.matkhau, a.MaNV, a.TrangThai, s.HoTen as HoTen, r.RoleID, r.RoleName
        FROM TaiKhoan a
        JOIN NhanVien s ON a.MaNV = s.MaNV
        LEFT JOIN Role r ON r.RoleID = a.RoleID
    """;

    String findByIdSql = """
        SELECT a.tendangnhap, a.matkhau, a.MaNV, a.TrangThai, s.HoTen, r.RoleID, r.RoleName
        FROM TaiKhoan a
        JOIN NhanVien s ON a.MaNV = s.MaNV
        LEFT JOIN Role r ON r.RoleID = a.RoleID
        WHERE a.tendangnhap = ?
    """;




    private Connection getConnection() throws SQLException {

        return openConnection();
    }

    @Override
    public User create(User entity) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            stmt.setString(1, entity.getTendangnhap());
            stmt.setString(2, entity.getMatkhau());
            stmt.setString(3, entity.getMaNV());
            stmt.setInt(4, entity.getRoleid());
            stmt.setBoolean(5, entity.isTrangThai());

            stmt.executeUpdate();
            return entity;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User entity) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setString(1, entity.getMatkhau());
            stmt.setString(2, entity.getMaNV());
            stmt.setInt(3, entity.getRoleid());
            stmt.setBoolean(4, entity.isTrangThai());
            stmt.setString(5, entity.getTendangnhap());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(deleteSql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(findAllSql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"),
                        false,
                        rs.getString("MaNV"),
                        rs.getBoolean("TrangThai"),
                        rs.getString("HoTen")
                );
                try { user.setRoleid(rs.getInt("RoleID")); } catch (SQLException ignore) {}
                try { user.setRolename(rs.getString("RoleName")); } catch (SQLException ignore) {}
                if (user.getRolename() != null) {
                    String rn = user.getRolename().trim().toLowerCase();
                    boolean isAdminOrHR = rn.equals("admin") || rn.equals("hr") || rn.equals("human resource") || rn.equals("human resources");
                    user.setVaiTro(isAdminOrHR);
                }
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findById(String id) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getString("tendangnhap"),
                            rs.getString("matkhau"),
                            false,
                            rs.getString("MaNV"),
                            rs.getBoolean("TrangThai"),
                            rs.getString("HoTen")
                    );
                    try { user.setRoleid(rs.getInt("RoleID")); } catch (SQLException ignore) {}
                    try { user.setRolename(rs.getString("RoleName")); } catch (SQLException ignore) {}
                    if (user.getRolename() != null) {
                        String rn = user.getRolename().trim().toLowerCase();
                        boolean isAdminOrHR = rn.equals("admin") || rn.equals("hr") || rn.equals("human resource") || rn.equals("human resources");
                        user.setVaiTro(isAdminOrHR);
                    }
                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
