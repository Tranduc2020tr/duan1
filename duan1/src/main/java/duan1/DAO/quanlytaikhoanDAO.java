/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;

import duan1.entity.quanlytaikhoan;
import java.util.List;

/**
 *
 * @author hang
 */
public interface quanlytaikhoanDAO extends AllDAO<quanlytaikhoan, String>{
        List<quanlytaikhoan> findall1();
}
