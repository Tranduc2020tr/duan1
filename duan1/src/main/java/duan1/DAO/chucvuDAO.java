/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.DAO;

import duan1.entity.chucvu;
import java.util.List;


/**
 *
 * @author hang
 */
public interface chucvuDAO extends AllDAO<chucvu, String>{
       List<chucvu> findall1();
}
