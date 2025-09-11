package duan1.DAO.ipml;

import duan1.DAO.chamcongDAO;
import duan1.entity.Thongkechamcong;
import duan1.entity.chamcong;
import duan1.util.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class quanlychamcongimpl implements chamcongDAO {

    private final String SQL_ALL = """
        SELECT cc.MaChamCong, cc.MaNV, nv.HoTen, cc.Ngay, cc.CheckIn, cc.CheckOut, cc.DiLam, cc.TongGio, cc.GhiChu 
        FROM ChamCong cc
        JOIN NhanVien nv ON cc.MaNV = nv.MaNV
    """;

    private final String create = """
        INSERT INTO ChamCong (MaNV, Ngay, CheckIn, CheckOut)
        VALUES (?,?,?,?)
    """;

    private final String SQL_UPDATE = """
   UPDATE ChamCong SET Ngay = ?, CheckIn = ?, CheckOut = ?, GhiChu = ? WHERE MaChamCong = ?;
""";

    private final String SQL_DELETE = "DELETE FROM ChamCong WHERE MaChamCong = ?";

private final String SQL_THONG_KE = """
    SELECT SoLanDiMuon, SoLanVeSom, SoNgayNghiLe, SoDonNghiPhepDaDuyet, SoDonNghiPhepTuChoi
            FROM vw_ThongKeChamCong
        WHERE MaNV = ? AND Thang = ? AND Nam = ?;
""";



    private String findall = "select * from chamcong where manv = ?";

    @Override
    public List<chamcong> findAll() {
        List<chamcong> list = new ArrayList<>();
        try (
                Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(SQL_ALL); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                chamcong cc = new chamcong();
                cc.setMaChamCong(rs.getString("MaChamCong"));
                cc.setMaNV(rs.getString("MaNV"));
                cc.setHoten(rs.getString("HoTen"));
                cc.setNgay(rs.getDate("Ngay"));
                cc.setCheckIn(rs.getTime("CheckIn"));
                cc.setCheckOut(rs.getTime("CheckOut"));
                cc.setDiLam(rs.getBoolean("DiLam"));
                cc.setTongGio(rs.getDouble("TongGio"));
                cc.setGhiChu(rs.getString("GhiChu"));
                list.add(cc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(chamcong entity) {
        XJdbc.executeUpdate(
                SQL_UPDATE,
                entity.getNgay(),
                entity.getCheckIn(),
                entity.getCheckOut(), // <-- Thêm dòng này
                entity.getGhiChu(),
                entity.getMaChamCong()
        );
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(SQL_DELETE, id);
    }

    @Override
    public chamcong create(chamcong entity) {
        try {
            Object[] values = {
                entity.getMaNV(),
                entity.getNgay(),
                entity.getCheckIn(),
                entity.getCheckOut(),};

            XJdbc.executeUpdate(create, values);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public void checkIn(chamcong entity) {
        throw new UnsupportedOperationException("Chức năng checkIn chưa được triển khai.");
    }

    @Override
    public void checkOut(String maNV, Date ngay, Time gioRa) {
        throw new UnsupportedOperationException("Chức năng checkOut chưa được triển khai.");
    }

    // ✅ Trả về đối tượng Thongkechamcong
@Override
public Thongkechamcong thongkechamcong(String maNV, int thang, int nam) {
    try (
        Connection con = XJdbc.openConnection();
        PreparedStatement ps = con.prepareStatement(SQL_THONG_KE)
    ) {
        ps.setString(1, maNV);
        ps.setInt(2, thang);
        ps.setInt(3, nam);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Thongkechamcong dto = new Thongkechamcong();
            dto.diMuon = rs.getInt("SoLanDiMuon");
            dto.veSom = rs.getInt("SoLanVeSom");
            dto.nghiLe = rs.getInt("SoNgayNghiLe");

            // ✅ Sửa tên cột ở đây cho đúng với view
            dto.nghiPhep = rs.getInt("SoDonNghiPhepDaDuyet");
            dto.nghiKhongPhep = rs.getInt("SoDonNghiPhepTuChoi");

            return dto;
        } else {
            System.out.println("Không có dữ liệu thống kê cho nhân viên này.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}


    @Override
    public chamcong findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<chamcong> findall2(String manv) {
         List<chamcong> list = new ArrayList<>();

        try (
                Connection con = XJdbc.openConnection(); PreparedStatement ps = con.prepareStatement(findall)) {
            ps.setString(1, manv);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                chamcong cc = new chamcong();
                cc.setMaChamCong(rs.getString("MaChamCong"));
                cc.setMaNV(rs.getString("MaNV"));
                cc.setNgay(rs.getDate("Ngay"));
                cc.setCheckIn(rs.getTime("CheckIn"));
                cc.setCheckOut(rs.getTime("CheckOut"));
                cc.setDiLam(rs.getBoolean("DiLam"));
                cc.setTongGio(rs.getDouble("TongGio"));
                cc.setGhiChu(rs.getString("GhiChu"));

                list.add(cc);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi truy vấn chấm công theo MaNV", e);
        }
return list;
    
    }

    @Override
    public List<chamcong> searchChamCong(String manv, int thang, int nam) {
       List<chamcong> list = new ArrayList<>();
    String sql = "SELECT * FROM ChamCong WHERE MaNV = ? AND MONTH(Ngay) = ? AND YEAR(Ngay) = ?";

    try (
        Connection con = XJdbc.openConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, manv);
        ps.setInt(2, thang);
        ps.setInt(3, nam);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            chamcong cc = new chamcong();
            cc.setMaChamCong(rs.getString("MaChamCong"));
            cc.setMaNV(rs.getString("MaNV"));
            cc.setNgay(rs.getDate("Ngay"));
            cc.setCheckIn(rs.getTime("CheckIn"));
            cc.setCheckOut(rs.getTime("CheckOut"));
            cc.setDiLam(rs.getBoolean("DiLam"));
            cc.setDiMuon(rs.getBoolean("DiMuon"));
            cc.setVeSom(rs.getBoolean("VeSom"));
            cc.setTongGio(rs.getDouble("TongGio"));
            cc.setGhiChu(rs.getString("GhiChu"));
            list.add(cc);
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Lỗi tìm kiếm chấm công theo tháng/năm", e);
    }

    return list;
    }

    @Override
    public Time getGioCheckIn(String maNV, Date ngay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
