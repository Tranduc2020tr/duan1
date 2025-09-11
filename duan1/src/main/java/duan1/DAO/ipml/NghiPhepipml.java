package duan1.DAO.ipml;

import duan1.DAO.nghiphepDAO;
import duan1.entity.NghiPhep;
import duan1.util.XJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NghiPhepipml implements nghiphepDAO {

    String insert_sql = "INSERT INTO YeuCauNghiPhep (MaNV,MaLoai, NgayBatDau, NgayKetThuc, LyDo) VALUES (?, ?, ?, ?,?)";
    String update_sql = "UPDATE YeuCauNghiPhep SET MaLoai = ?, NgayBatDau = ?, NgayKetThuc = ?, LyDo = ? WHERE MaYeuCau = ?";
    String delete_sql = "DELETE FROM YeuCauNghiPhep WHERE MaYeuCau = ?";
    String select_by_nv_sql = """
        SELECT 
            a.MaYeuCau, a.MaNV, c.TenLoai, b.HoTen, 
            a.NgayBatDau, a.NgayKetThuc, a.LyDo, 
            a.TrangThai, a.NgayXuLy, a.NguoiXuLy, 
            a.GhiChu, a.NgayGui
        FROM YeuCauNghiPhep a
        LEFT JOIN NhanVien b ON b.MaNV = a.MaNV
        LEFT JOIN LoaiNghiPhep c ON c.MaLoai = a.MaLoai
        WHERE a.MaNV = ?
        """;

    String select_all_sql = """
        SELECT 
            a.MaYeuCau, a.MaNV, c.TenLoai, b.HoTen, 
            a.NgayBatDau, a.NgayKetThuc, a.LyDo, 
            a.TrangThai, a.NgayXuLy, a.NguoiXuLy, 
            a.GhiChu, a.NgayGui
        FROM YeuCauNghiPhep a
        LEFT JOIN NhanVien b ON b.MaNV = a.MaNV
        LEFT JOIN LoaiNghiPhep c ON c.MaLoai = a.MaLoai
        """;

    String update_trangthai_sql = "UPDATE YeuCauNghiPhep SET TrangThai = ?, NgayXuLy = ?, NguoiXuLy = ?, GhiChu = ? WHERE MaYeuCau = ?";

    private Connection getConnection() throws SQLException {
        return XJdbc.openConnection();
    }

    @Override
    public NghiPhep create(NghiPhep entity) {
        XJdbc.update(insert_sql,
                entity.getManv(),
                entity.getMaloai(),
                entity.getNgaybatdau(),
                entity.getNgayketthuc(),
                entity.getLydo());
        return entity;
    }

    @Override
    public void update(NghiPhep entity) {
        XJdbc.update(update_trangthai_sql,
               entity.getTrangthai(),
               entity.getNgayxuly(),
               entity.getNguoixuly(),
               entity.getGhichuxuly(),
               entity.getMayeucau());
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.update(delete_sql, id);
    }

    @Override
    public NghiPhep findById(Integer id) {
        throw new UnsupportedOperationException("Chưa hỗ trợ findById.");
    }

    @Override
    public List<NghiPhep> findall(String manv) {
        List<NghiPhep> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(select_by_nv_sql)) {

            ps.setString(1, manv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NghiPhep np = new NghiPhep();
                np.setMayeucau(rs.getString("MaYeuCau"));
                np.setManv(rs.getString("MaNV"));
                np.setTenloai(rs.getString("TenLoai"));
                np.setHoten(rs.getString("HoTen"));
                np.setNgaybatdau(rs.getDate("NgayBatDau"));
                np.setNgayketthuc(rs.getDate("NgayKetThuc"));
                np.setLydo(rs.getString("LyDo"));
                np.setTrangthai(rs.getString("TrangThai"));
                np.setNguoixuly(rs.getString("NguoiXuLy"));
                np.setNgayxuly(rs.getString("NgayXuLy"));
                np.setGhichuxuly(rs.getString("GhiChu"));
                np.setNgaygui(rs.getString("NgayGui"));
                list.add(np);
            }

        } catch (SQLException e) {
            throw new RuntimeException("❌ Lỗi khi truy vấn danh sách nghỉ phép theo nhân viên", e);
        }
        return list;
    }

    @Override
    public List<NghiPhep> findAll() {
        List<NghiPhep> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(select_all_sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NghiPhep np = new NghiPhep();
                np.setMayeucau(rs.getString("MaYeuCau"));
                np.setManv(rs.getString("MaNV"));
                np.setTenloai(rs.getString("TenLoai"));
                np.setHoten(rs.getString("HoTen"));
                np.setNgaybatdau(rs.getDate("NgayBatDau"));
                np.setNgayketthuc(rs.getDate("NgayKetThuc"));
                np.setLydo(rs.getString("LyDo"));
                np.setTrangthai(rs.getString("TrangThai"));
                np.setNgaygui(rs.getString("NgayGui"));
                np.setNgayxuly(rs.getString("NgayXuLy"));
                np.setNguoixuly(rs.getString("NguoiXuLy"));
                np.setGhichuxuly(rs.getString("GhiChu"));
                list.add(np);
            }

        } catch (SQLException e) {
            throw new RuntimeException("❌ Lỗi khi truy vấn danh sách yêu cầu nghỉ phép", e);
        }
        return list;
    }

    public void xuLyDon(int maYeuCau, String trangThai, String nguoiXuLy, String ghiChu) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(update_trangthai_sql)) {

            ps.setString(1, trangThai);
            ps.setString(2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            ps.setString(3, nguoiXuLy);
            ps.setString(4, ghiChu);
            ps.setInt(5, maYeuCau);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("❌ Lỗi khi xử lý đơn nghỉ phép", e);
        }
    }
}
