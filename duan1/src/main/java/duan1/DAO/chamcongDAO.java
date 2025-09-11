/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;

import duan1.entity.Thongkechamcong;
import duan1.entity.chamcong;
import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hang
 */
public interface chamcongDAO extends AllDAO<chamcong, Integer>{
    void checkIn(chamcong entity);
    void checkOut(String maNV, Date ngay, Time gioRa); // thêm tham số ở đây
   Thongkechamcong thongkechamcong(String maNV, int thang, int nam);
List<chamcong> findall2(String manv);
List<chamcong> searchChamCong(String manv, int thang, int nam);
    public Time getGioCheckIn(String maNV, Date ngay);



}
