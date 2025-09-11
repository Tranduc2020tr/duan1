/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.chucvuDAO;
import duan1.entity.chucvu;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hang
 */
public class chucvuimpl implements chucvuDAO{
    
     String create = "INSERT INTO chucvu (tencv, mota,luongcoban) VALUES(?,?,?)";
    String update = "UPDATE chucvu SET tencv = ?, mota = ?,luongcoban = ? WHERE macv = ?";
    String deleteid = "DELETE FROM chucvu WHERE macv = ?";
    String findAll = "SELECT * FROM chucvu ";
    String findById = "SELECT * FROM chucvu WHERE macv = ?";

    @Override
    public chucvu create(chucvu entity) {
        try {
            Object[] values = {
                entity.getTencv(),
                entity.getMota(),
                entity.getLuongcoban(),
            };
                
            XJdbc.executeUpdate(create, values);

        } catch (Exception e) {
        }
        return entity;
    }

    @Override
    public void update(chucvu entity) {
        XJdbc.executeUpdate(update, entity.getTencv(), entity.getMota(), entity.getLuongcoban(), entity.getMacv());
    }

    @Override
    public void deleteById(String id) {
        XJdbc.update(deleteid, id);
    }

    @Override
    public List<chucvu> findAll() {
        return XQuery.getBeanList(chucvu.class, findAll);
    }

    @Override
    public chucvu findById(String id) {
        return XQuery.getSingleBean(chucvu.class, findById, id);
    }

    @Override
    public List<chucvu> findall1() {
        List<chucvu> list = new ArrayList<>();
    String sql = "SELECT macv, TenCV FROM chucvu";

    try (Connection con = XJdbc.openConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            chucvu a = new chucvu();
            a.setMacv(rs.getString("macv"));
            a.setTencv(rs.getString("tencv"));
            list.add(a);
            System.out.println(a.getTencv());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
    }
    }

    

