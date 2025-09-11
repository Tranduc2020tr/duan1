package duan1.DAO.ipml;

import duan1.DAO.quanlytaikhoanDAO;
import duan1.entity.quanlytaikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class quanlytaikhoanipml implements quanlytaikhoanDAO {

    String insertSql = "INSERT INTO TaiKhoan (tendangnhap, matkhau, VaiTro, MaNV, TrangThai) VALUES (?, ?, ?, ?, ?)";
    String updateSql = "UPDATE TaiKhoan SET matkhau = ?, VaiTro = ?, MaNV = ?, TrangThai = ? WHERE tendangnhap = ?";
    String deleteSql = "DELETE FROM TaiKhoan WHERE tendangnhap = ?";
    String findAllSql = "SELECT a.tendangnhap,b.HoTen,a.matkhau,a.vaitro,a.manv,a.trangthai FROM TaiKhoan a join nhanvien b on b.manv = a.manv";
    String findByIdSql = "SELECT * FROM TaiKhoan WHERE tendangnhap = ?";
    String sql1 = "SELECT \n" +
"    nv.MaNV,\n" +
"    nv.HoTen,\n" +
"    NULL AS TenDangNhap,\n" +
"    NULL AS MatKhau,\n" +
"    NULL AS VaiTro,\n" +
"    NULL AS TrangThai\n" +
"FROM NhanVien nv\n" +
"WHERE NOT EXISTS (\n" +
"    SELECT 1 FROM TaiKhoan tk WHERE tk.MaNV = nv.MaNV\n" +
")";

    private Connection getConnection() throws SQLException {
        return duan1.util.XJdbc.openConnection();
    }

    @Override
    public quanlytaikhoan create(quanlytaikhoan entity) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(insertSql)) {

            stmt.setString(1, entity.getTendangnhap());
            stmt.setString(2, entity.getMatkhau());
            stmt.setBoolean(3, entity.isVaitro());     
            stmt.setString(4, entity.getManv());
            stmt.setBoolean(5, entity.isTrangthai());   

            stmt.executeUpdate();
            return entity;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(quanlytaikhoan entity) {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setString(1, entity.getMatkhau());
            stmt.setBoolean(2, entity.isVaitro());
            stmt.setString(3, entity.getManv());
            stmt.setBoolean(4, entity.isTrangthai());
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
    public List<quanlytaikhoan> findAll() {
        List<quanlytaikhoan> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(findAllSql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setTendangnhap(rs.getString("tendangnhap"));
                tk.setHoten(rs.getString("hoten"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setVaitro(rs.getBoolean("VaiTro"));
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
                    tk.setVaitro(rs.getBoolean("VaiTro"));
                    tk.setManv(rs.getString("MaNV"));
                    tk.setTrangthai(rs.getBoolean("TrangThai"));
                    return tk;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
            System.out.println("Vai trò: " + (tk.isVaitro() ? "Admin" : "User"));
            System.out.println("Mã nhân viên: " + tk.getManv());
            System.out.println("Trạng thái: " + (tk.isTrangthai() ? "Hoạt động" : "Ngừng"));
            System.out.println("----------------------------------------");
        }
    }
}

    @Override
    public List<quanlytaikhoan> findall1() {
        List<quanlytaikhoan> list = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql1); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                quanlytaikhoan tk = new quanlytaikhoan();
                tk.setTendangnhap(rs.getString("tendangnhap"));
                tk.setHoten(rs.getString("hoten"));
                tk.setMatkhau(rs.getString("matkhau"));
                tk.setVaitro(rs.getBoolean("VaiTro"));
                tk.setManv(rs.getString("MaNV"));
                tk.setTrangthai(rs.getBoolean("TrangThai"));
                list.add(tk);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
