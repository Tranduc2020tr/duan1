/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;

import duan1.entity.TangCa;
import duan1.entity.dangkitangca;
import java.util.List;

/**
 *
 * @author hang
 */
public interface dangkitangcaDAO extends AllDAO<dangkitangca, String>{
    List<dangkitangca> fillall1(String manv);
    dangkitangca findCurrentOvertimeRecord(String maNV, String ngay);
    dangkitangca findAnyOvertimeRecord(String maNV, String ngay);
}
