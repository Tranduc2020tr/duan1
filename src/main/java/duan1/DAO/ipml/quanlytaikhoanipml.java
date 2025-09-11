package duan1.DAO.ipml;

import duan1.DAO.quanlytaikhoanDAO;
import duan1.entity.quanlytaikhoan;

import duan1.entity.role;
import duan1.util.XAuth;
import duan1.util.XDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class quanlytaikhoanipml implements quanlytaikhoanDAO {

    String insertSql = "INSERT INTO TaiKhoan (tendangnhap, matkhau, MaNV, RoleID, TrangThai) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE TaiKhoan SET matkhau = ?, MaNV = ?, RoleID = ?, TrangThai = ? WHERE tendangnhap = ?";
    String deleteSql = "DELETE FROM TaiKhoan WHERE tendangnhap = ?";
    String findAllSql = """
        SELECT a.tendangnhap, b.HoTen, a.matkhau, r.RoleName, a.RoleID, a.MaNV, a.TrangThai
        FROM TaiKhoan a
        JOIN NhanVien b ON b.MaNV = a.MaNV
        JOIN Role r ON r.RoleID = a.RoleID
    """;
    String findByIdSql = "SELECT * FROM TaiKhoan WHERE tendangnhap = ?";
    String sql1 = """
        SELECT 
            nv.MaNV,
            nv.HoTen,
            NULL AS tendangnhap,
            NULL AS matkhau,
            NULL AS RoleID,
            NULL AS TrangThai
        FROM NhanVien nv
        WHERE NOT EXISTS (
            SELECT 1 FROM TaiKhoan tk WHERE tk.MaNV = nv.MaNV
        )
    """;

    private Connection getConnection() throws SQLException {
        return duan1.util.XJdbc.openConnection();
    }

    @Override
    public quanlytaikhoan create(quanlytaikhoan entity) {
        try (Connection conn = getConnection()) {
            // Nếu muốn tạo admin mới → kiểm tra trong DB
            if (entity.getRoleid() == 1) {
                String checkAdminSql = "SELECT COUNT(*) FROM TaiKhoan WHERE RoleID = 1";
                try (PreparedStatement checkStmt = conn.prepareStatement(checkAdminSql); ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null,
                                "Đã tồn tại một tài khoản Admin. Không thể tạo thêm!",
                                "Cảnh báo",
                                JOptionPane.WARNING_MESSAGE);
                        return null;
                    }
                }
            }

            // Thêm tài khoản bình thường
            try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
                stmt.setString(1, entity.getTendangnhap());
                stmt.setString(2, entity.getMatkhau());
                stmt.setString(3, entity.getManv());
                stmt.setInt(4, entity.getRoleid());
                stmt.setBoolean(5, entity.isTrangthai());
                stmt.executeUpdate();
                return entity;
            }
        } catch (SQLException e) {
            XDialog.alert("trùng username");
            return null;
        }
    }

    @Override
    public void update(quanlytaikhoan entity) {
        try (Connection conn = getConnection()) {
            String currentLoggedInUser = XAuth.user.getTendangnhap();

            // Lấy role hiện tại của tài khoản cần update
            String checkRoleSql = "SELECT RoleID FROM TaiKhoan WHERE tendangnhap = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkRoleSql)) {
                checkStmt.setString(1, entity.getTendangnhap());
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        int currentRole = rs.getInt("RoleID");

                        // Nếu là admin và sửa chính mình → chặn
                        if (currentRole == 1 && entity.getTendangnhap().equalsIgnoreCase(currentLoggedInUser)) {
                            JOptionPane.showMessageDialog(null,
                                    "Admin không thể sửa thông tin tài khoản của chính mình!",
                                    "Thông báo",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Nếu đang là admin → không cho đổi role
                        if (currentRole == 1 && entity.getRoleid() != currentRole) {
                            JOptionPane.showMessageDialog(null,
                                    "Không thể thay đổi phân quyền của Admin!",
                                    "Thông báo",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        // Nếu tài khoản hiện tại KHÔNG phải admin, nhưng muốn đổi thành admin
                        if (currentRole != 1 && entity.getRoleid() == 1) {
                            String checkAdminSql = "SELECT COUNT(*) FROM TaiKhoan WHERE RoleID = 1";
                            try (PreparedStatement adminCheck = conn.prepareStatement(checkAdminSql); ResultSet rs2 = adminCheck.executeQuery()) {
                                if (rs2.next() && rs2.getInt(1) > 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "Đã tồn tại một tài khoản Admin. Không thể đổi thêm!",
                                            "Cảnh báo",
                                            JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            // Cập nhật bình thường
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                stmt.setString(1, entity.getMatkhau());
                stmt.setString(2, entity.getManv());
                stmt.setInt(3, entity.getRoleid());
                stmt.setBoolean(4, entity.isTrangthai());
                stmt.setString(5, entity.getTendangnhap());
                stmt.executeUpdate();
            }
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
    public List<quanlytaikhoan> findAll() {
        List<quanlytaikhoan> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(findAllSql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setTendangnhap(rs.getString("tendangnhap"));
                tk.setHoten(rs.getString("HoTen"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setRolename(rs.getString("RoleName"));
                tk.setRoleid(rs.getInt("RoleID"));
                tk.setManv(rs.getString("MaNV"));
                tk.setTrangthai(rs.getBoolean("TrangThai"));
                list.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public quanlytaikhoan findById(String id) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    quanlytaikhoan tk = new quanlytaikhoan();
                    tk.setTendangnhap(rs.getString("tendangnhap"));
                    tk.setMatkhau(rs.getString("matkhau"));
                    tk.setManv(rs.getString("MaNV"));
                    tk.setRoleid(rs.getInt("RoleID"));
                    tk.setTrangthai(rs.getBoolean("TrangThai"));
                    return tk;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<quanlytaikhoan> findall1() {
        List<quanlytaikhoan> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql1); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setManv(rs.getString("MaNV"));
                tk.setHoten(rs.getString("HoTen"));
                list.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<role> getAllRoles() {
        List<role> roles = new ArrayList<>();
        String sql = "SELECT RoleID, RoleName FROM Role";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                role role = new role();
                role.setRoleid(rs.getInt("RoleID"));
                role.setRolename(rs.getString("RoleName"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public static void main(String[] args) {
        quanlytaikhoanipml dao = new quanlytaikhoanipml();
        List<quanlytaikhoan> list = dao.findAll();

        if (list.isEmpty()) {
            System.out.println("Không có tài khoản nào trong cơ sở dữ liệu.");
        } else {
            for (quanlytaikhoan tk : list) {
                System.out.println("Tên đăng nhập: " + tk.getTendangnhap());
                System.out.println("Mật khẩu: " + tk.getMatkhau());
                System.out.println("Vai trò: " + tk.getRolename());
                System.out.println("Mã nhân viên: " + tk.getManv());
                System.out.println("Trạng thái: " + (tk.isTrangthai() ? "Hoạt động" : "Ngừng"));
                System.out.println("----------------------------------------");
            }
        }
    }
}
