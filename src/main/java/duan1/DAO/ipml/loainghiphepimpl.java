package duan1.DAO.ipml;

import duan1.DAO.loainghiphepDAO;
import duan1.entity.loainghiphep;
import duan1.util.XJdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class loainghiphepimpl implements loainghiphepDAO {

    private final String SQL_FIND_ALL = "SELECT * FROM LoaiNghiPhep";
    private final String SQL_CREATE = "INSERT INTO LoaiNghiPhep (MaLoai, TenLoai, HuongLuong) VALUES (?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE LoaiNghiPhep SET TenLoai = ?, HuongLuong = ? WHERE MaLoai = ?";
    private final String SQL_DELETE = "DELETE FROM LoaiNghiPhep WHERE MaLoai = ?";
    private final String SQL_FIND_BY_ID = "SELECT * FROM LoaiNghiPhep WHERE MaLoai = ?";

    @Override
    public loainghiphep create(loainghiphep entity) {
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_CREATE)) {
            ps.setString(1, entity.getMaloai());
            ps.setString(2, entity.getTenloai());
            ps.setBoolean(3, entity.getHuongLuong());
            ps.executeUpdate();
            return entity;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(loainghiphep entity) {
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, entity.getTenloai());
            ps.setBoolean(2, entity.getHuongLuong());
            ps.setString(3, entity.getMaloai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<loainghiphep> findAll() {
        List<loainghiphep> list = new ArrayList<>();
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                loainghiphep lnp = new loainghiphep();
                lnp.setMaloai(rs.getString("MaLoai"));
                lnp.setTenloai(rs.getString("TenLoai"));
                lnp.setHuongLuong(rs.getBoolean("HuongLuong"));
                list.add(lnp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public loainghiphep findById(Integer id) {
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    loainghiphep lnp = new loainghiphep();
                    lnp.setMaloai(rs.getString("MaLoai"));
                    lnp.setTenloai(rs.getString("TenLoai"));
                    lnp.setHuongLuong(rs.getBoolean("HuongLuong"));
                    return lnp;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
