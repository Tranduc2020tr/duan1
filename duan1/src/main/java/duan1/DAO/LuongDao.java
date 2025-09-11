/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.DAO;

import duan1.entity.Luong;
import java.util.List;




public interface LuongDao{
    List<Luong> layTatCaBangLuong(String manv);
    List<Luong> timKiemLuong(String manv, int thang, int nam);
    List<Luong> layBangLuongTheoMaNV(String manv);

}

