/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;


import duan1.DAO.QuanLyLuongDao;
import duan1.entity.QuanLyLuong;
import duan1.util.XJdbc;
import java.sql.*;
import java.util.*;
import java.util.Calendar;

/**
 *
 * @author Hung Cuong
 */
public class QuanLyLuongIPLM1 implements QuanLyLuongDao {

    @Override
    public void themluong(QuanLyLuong l) {
        String sql = "INSERT INTO luong (manv, thang, nam, luongcoban, luongphucap, thuong, khautru, nguoitao, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, l.getManv(), l.getThang(), l.getNam(), l.getLuongcoban(),
                l.getLuongphucap(), l.getThuong(), l.getKhautru(), l.getNguoitao(), l.getGhichu());
    }

    @Override
    public void capnhatluong(QuanLyLuong l) {
        String sql = "UPDATE luong SET manv = ?, thang = ?, nam = ?, luongcoban = ?, luongphucap = ?, thuong = ?, khautru = ?, nguoitao = ?, ghichu = ? WHERE maluong = ?";
        XJdbc.update(sql, l.getManv(), l.getThang(), l.getNam(), l.getLuongcoban(),
                l.getLuongphucap(), l.getThuong(), l.getKhautru(), l.getNguoitao(), l.getGhichu());
    }

    @Override
    public List<QuanLyLuong> laytatcabangluong() {
        List<QuanLyLuong> list = new ArrayList<>();
        String sql = "SELECT a.maluong,a.manv,b.hoten,a.thang,a.nam,a.luongcoban, a.luongphucap,a.thuong,a.khautru,a.tongluong,a.NgayTao,a.NguoiTao,a.GhiChu FROM Luong a\n" +
"join NhanVien b on b.MaNV = a.manv";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                        rs.getString("maluong"),
                        rs.getString("manv"),
                        rs.getString("hoten"),
                        rs.getInt("thang"),
                        rs.getInt("nam"),
                        rs.getBigDecimal("luongcoban"),
                        rs.getBigDecimal("luongphucap"),
                        rs.getBigDecimal("thuong"),
                        rs.getBigDecimal("khautru"),
                        rs.getBigDecimal("tongluong"),
                        rs.getString("NgayTao"),
                        rs.getString("NguoiTao"),
                        rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<QuanLyLuong> searchluong(String manv, String maluong) {
        String sql = "SELECT * FROM luong WHERE manv = ? AND maluong = ?";
        List<Object> args = new ArrayList<>();
        args.add(manv);
        args.add(maluong);
        return docdulieu(sql, args.toArray());
    }
    
    @Override
    public List<QuanLyLuong> searchLuongByHoTen(String hoTen, int thang, int nam) {
        List<QuanLyLuong> list = new ArrayList<>();
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE nv.hoten LIKE ? AND l.thang = ? AND l.nam = ?";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + hoTen + "%");
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                        rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }

    private List<QuanLyLuong> docdulieu(String sql, Object... args) {
        List<QuanLyLuong> list = new ArrayList<>();
        try (ResultSet rs = XJdbc.executeQuery(sql, args)) {
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong();
                l.setMaluong(rs.getString("maluong"));
                l.setManv(rs.getString("manv"));
                l.setThang(rs.getInt("thang"));
                l.setNam(rs.getInt("nam"));
                l.setLuongcoban(rs.getBigDecimal("luongcoban"));
                l.setLuongphucap(rs.getBigDecimal("luongphucap"));
                l.setThuong(rs.getBigDecimal("thuong"));
                l.setKhautru(rs.getBigDecimal("khautru"));
                l.setTongluong(rs.getBigDecimal("tongluong"));
                l.setNgaytao(rs.getString("ngaytao"));
                l.setNguoitao(rs.getString("nguoitao"));
                l.setGhichu(rs.getString("ghichu"));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<QuanLyLuong> searchLuongByHoTenOnly(String hoTen) {
        List<QuanLyLuong> list = new ArrayList<>();
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE nv.hoten LIKE ?";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + hoTen + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }

    @Override
    public List<QuanLyLuong> timKiemLuong(String manv, int thang, int nam) {
        List<QuanLyLuong> list = new ArrayList<>();
        String sql = "SELECT l.*, nv.hoten FROM Luong l " +
                    "INNER JOIN NhanVien nv ON l.manv = nv.MaNV " +
                    "WHERE l.manv = ? AND l.thang = ? AND l.nam = ?";

        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, manv);
            ps.setInt(2, thang);
            ps.setInt(3, nam);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                        rs.getString("maluong"),
                        rs.getString("manv"),
                         rs.getString("hoten"),
                        rs.getInt("thang"),
                        rs.getInt("nam"),
                        rs.getBigDecimal("luongcoban"),
                        rs.getBigDecimal("luongphucap"),
                        rs.getBigDecimal("thuong"),
                        rs.getBigDecimal("khautru"),
                        rs.getBigDecimal("tongluong"),
                        rs.getString("NgayTao"),
                        rs.getString("NguoiTao"),
                        rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void tinhLuongThang(String manv, int thang, int nam) {
        String sql = "{call sp_TinhLuongThang(?, ?, ?)}";
        try (Connection conn = XJdbc.openConnection(); CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, manv);
            stmt.setInt(2, thang);
            stmt.setInt(3, nam);
            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi tính lương: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean capNhatLuong(QuanLyLuong luong) {
        String sql = "UPDATE Luong SET manv=?, thang=?, nam=?, luongcoban=?, luongphucap=?, thuong=?, khautru=?, nguoitao=?, ghichu=? WHERE maluong=?";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, luong.getManv());
            ps.setInt(2, luong.getThang());
            ps.setInt(3, luong.getNam());
            ps.setBigDecimal(4, luong.getLuongcoban());
            ps.setBigDecimal(5, luong.getLuongphucap());
            ps.setBigDecimal(6, luong.getThuong());
            ps.setBigDecimal(7, luong.getKhautru());
            ps.setString(8, luong.getNguoitao());
            ps.setString(9, luong.getGhichu());
            ps.setString(10, luong.getMaluong());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<QuanLyLuong> getLuong3ThangQua() {
        List<QuanLyLuong> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentYear = cal.get(Calendar.YEAR);
        
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE (l.nam = ? AND l.thang >= ?) OR (l.nam = ? AND l.thang <= ?) " +
                    "ORDER BY l.nam DESC, l.thang DESC";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            int startMonth = currentMonth - 2;
            int startYear = currentYear;
            if (startMonth <= 0) {
                startMonth += 12;
                startYear--;
            }
            
            ps.setInt(1, currentYear);
            ps.setInt(2, startMonth);
            ps.setInt(3, startYear);
            ps.setInt(4, currentMonth);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<QuanLyLuong> getLuong6ThangQua() {
        List<QuanLyLuong> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentYear = cal.get(Calendar.YEAR);
        
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE (l.nam = ? AND l.thang >= ?) OR (l.nam = ? AND l.thang <= ?) " +
                    "ORDER BY l.nam DESC, l.thang DESC";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            int startMonth = currentMonth - 5;
            int startYear = currentYear;
            if (startMonth <= 0) {
                startMonth += 12;
                startYear--;
            }
            
            ps.setInt(1, currentYear);
            ps.setInt(2, startMonth);
            ps.setInt(3, startYear);
            ps.setInt(4, currentMonth);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<QuanLyLuong> getLuongNamNay() {
        List<QuanLyLuong> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE l.nam = ? ORDER BY l.thang DESC";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, currentYear);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<QuanLyLuong> getLuongNamNgoai() {
        List<QuanLyLuong> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int lastYear = cal.get(Calendar.YEAR) - 1;
        
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE l.nam = ? ORDER BY l.thang DESC";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, lastYear);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public List<QuanLyLuong> getLuongTheoThangNam(int thang, int nam) {
        List<QuanLyLuong> list = new ArrayList<>();
        
        String sql = "SELECT l.*, nv.hoten FROM luong l " +
                    "INNER JOIN nhanvien nv ON l.manv = nv.manv " +
                    "WHERE l.thang = ? AND l.nam = ? ORDER BY l.manv";
        
        try (Connection conn = XJdbc.openConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QuanLyLuong l = new QuanLyLuong(
                    rs.getString("maluong"),
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getInt("thang"),
                    rs.getInt("nam"),
                    rs.getBigDecimal("luongcoban"),
                    rs.getBigDecimal("luongphucap"),
                    rs.getBigDecimal("thuong"),
                    rs.getBigDecimal("khautru"),
                    rs.getBigDecimal("tongluong"),
                    rs.getString("NgayTao"),
                    rs.getString("NguoiTao"),
                    rs.getString("GhiChu")
                );
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public boolean xoaLuong(String maluong) {
        String sql = "DELETE FROM Luong WHERE maluong=?";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maluong);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
