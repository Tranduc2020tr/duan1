/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO.ipml;

import duan1.DAO.chitietphieuluongDAO;
import duan1.entity.chitietphieuluong;
import duan1.util.XJdbc;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author hang
 */

    
public class chitietphieuluongimpl implements chitietphieuluongDAO {

    String sql = "EXEC sp_XemPhieuLuongChiTiet @MaNV = ?, @Thang = ?, @Nam = ?";

    @Override
    public List<chitietphieuluong> getByThangNam(String manv, int Thang, int nam) {
       
         List<chitietphieuluong> list = new ArrayList<>();

        try (Connection con = XJdbc.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, manv);
            ps.setInt(2, Thang);
            ps.setInt(3, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    chitietphieuluong ct = new chitietphieuluong();
                    ct.setManv(rs.getString("Mã Nhân Viên"));
                    ct.setHoten(rs.getString("Họ và tên"));
                    ct.setDilam(rs.getInt("Số Ngày Đi Làm"));
                    ct.setSogio(rs.getString("Số Giờ đi làm (Ước tính)"));
                    ct.setPhucap(rs.getString("Phụ cấp"));
                    ct.setBhxh(rs.getString("Bảo hiểm Xã hội (BHXH)"));
                    ct.setBhyt(rs.getString("Bảo hiểm Y tế (BHYT)"));
                    ct.setBhtn(rs.getString("Bảo hiểm Thất nghiệp (BHTN)"));
                    ct.setTtncn(rs.getString("Thuế thu nhập cá nhân"));
                    ct.setTongkhautru(rs.getString("Tổng khấu trừ"));
                    ct.setTongluong(rs.getString("Tổng Lương thực nhận"));
                    list.add(ct);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    
    }

   
}

