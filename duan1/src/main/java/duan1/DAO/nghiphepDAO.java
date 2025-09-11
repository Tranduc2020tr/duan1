/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;

import duan1.entity.NghiPhep;
import java.util.List;

/**
 *
 * @author hang
 */
public interface nghiphepDAO extends AllDAO<NghiPhep, Integer>{
    List<NghiPhep> findall(String manv);
    
    
}
