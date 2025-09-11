package duan1.DAO.ipml;

import duan1.DAO.dashboarDAO;
import duan1.entity.dashboard;
import static duan1.util.XJdbc.openConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class dashboardipml implements dashboarDAO {

    String SQL_FINDALL = "select * from vw_TongHopNgayHomNay_ThongKeTongQuat";
    String sql1 = "SELECT * FROM vw_TongHopNgayHomNay WHERE MaNV = ?";

    @Override
    public dashboard create(dashboard entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(dashboard entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<dashboard> findAll() {
        List<dashboard> list = new ArrayList<>();
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(SQL_FINDALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dashboard dash = new dashboard();
                dash.setTongNhanVien(rs.getInt("TongNhanVien"));
                dash.setTongChamCongHomNay(rs.getInt("TongChamCongHomNay"));
                dash.setTongNghiPhepHomNay(rs.getInt("TongNghiPhepHomNay"));
                list.add(dash);
            }

        } catch (Exception e) {
            System.err.println("Lỗi khi tải dữ liệu dashboard (findAll): " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public dashboard findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<dashboard> findall1(String manv) {
        List<dashboard> list = new ArrayList<>();
        try (Connection con = openConnection();
             PreparedStatement ps = con.prepareStatement(sql1)) {

            // ✅ Truyền tham số vào câu truy vấn
            ps.setString(1, manv);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dashboard dash = new dashboard();
                    dash.setManv(rs.getString("MaNV"));
                    dash.setSoNgayDiLam(rs.getInt("SoNgayDiLam"));

                    // Xử lý NULL nếu có
                    int nghiPhep = rs.getObject("SoNgayNghiPhep") != null ? rs.getInt("SoNgayNghiPhep") : 0;
                    dash.setSoNgayNghiPhep(nghiPhep);

                    dash.setTongluong(rs.getDouble("TongLuong")); // ✅ lấy kiểu double
                    list.add(dash);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải dữ liệu dashboard (findall1): " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

  
}


