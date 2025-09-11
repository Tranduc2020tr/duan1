/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.phongbanDAO;
import duan1.entity.nhanvien;
import duan1.entity.phongban;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hang
 */
public class phongbanipml implements phongbanDAO {

    String create = "INSERT INTO PhongBan (tenpb, mota) VALUES(?,?)";
    String update = "UPDATE PhongBan SET tenpb = ?, mota = ? WHERE mapb = ?";
    String deleteid = "DELETE FROM PhongBan WHERE mapb = ?";
    String findAll = "SELECT * FROM PhongBan ";
    String findById = "SELECT * FROM PhongBan WHERE mapb = ?";

    @Override
    public phongban create(phongban entity) {
        try {
            Object[] values = {
                entity.getTenpb(),
                entity.getMota(),};
            XJdbc.executeUpdate(create, values);

        } catch (Exception e) {
        }
        return entity;
    }

    @Override
    public void update(phongban entity) {
        XJdbc.executeUpdate(update, entity.getTenpb(), entity.getMota(), entity.getMapb());
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.update(deleteid, id);
    }

    @Override
    public List<phongban> findAll() {
        return XQuery.getBeanList(phongban.class, findAll);
    }

    @Override
    public phongban findById(Integer id) {
        return XQuery.getSingleBean(phongban.class, findById, id);
    }

    @Override
public List<phongban> findall1() {
    List<phongban> list = new ArrayList<>();
    String sql = "SELECT mapb, tenpb FROM PhongBan"; // ← lấy cả mã và tên

    try (Connection con = XJdbc.openConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            phongban a = new phongban();
            a.setMapb(rs.getString("mapb"));    // ← thêm dòng này
            a.setTenpb(rs.getString("tenpb"));
            list.add(a);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}


}
