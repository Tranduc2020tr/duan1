/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.quanlythuongDAO;
import duan1.entity.quanlythuong;
import duan1.util.XJdbc;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hang
 */
public class quanlythuongimpl implements quanlythuongDAO{
     String sql1 = "INSERT INTO thuong (manv, ngaythuong, sotien, noidung) VALUES (?, ?, ?, ?)";
      String sql2 = "UPDATE thuong SET manv=?, ngaythuong=?, sotien=?, noidung=? WHERE mathuong=?";
       String sql3 = "DELETE FROM thuong WHERE mathuong=?";
       String sql4 = "SELECT * FROM thuong";
        String sql5 = "SELECT * FROM thuong WHERE mathuong=?";
     @Override
    public quanlythuong create(quanlythuong entity) {
       
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, entity.getManv());
            ps.setString(2, entity.getNgay());
            ps.setDouble(3, entity.getSotien());
            ps.setString(4, entity.getNoidung());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    entity.setMathuong(rs.getString(1));
                }
            }
            return entity;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(quanlythuong entity) {
       
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql2)) {

            ps.setString(1, entity.getManv());
            ps.setString(2, entity.getNgay());
            ps.setDouble(3, entity.getSotien());
            ps.setString(4, entity.getNoidung());
            ps.setString(5, entity.getMathuong());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
       
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql3)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<quanlythuong> findAll() {
        List<quanlythuong> list = new ArrayList<>();
        
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql4);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                quanlythuong t = new quanlythuong();
                t.setMathuong(rs.getString("mathuong"));
                t.setManv(rs.getString("manv"));
                t.setNgay(rs.getString("ngaythuong"));
                t.setSotien(rs.getDouble("sotien"));
                t.setNoidung(rs.getString("noidung"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public quanlythuong findById(Integer id) {
       
        try (Connection conn = XJdbc.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql5)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    quanlythuong t = new quanlythuong();
                    t.setMathuong(rs.getString("mathuong"));
                    t.setManv(rs.getString("manv"));
                    t.setNgay(rs.getString("ngaythuong"));
                    t.setSotien(rs.getDouble("sotien"));
                    t.setNoidung(rs.getString("noidung"));
                    return t;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
