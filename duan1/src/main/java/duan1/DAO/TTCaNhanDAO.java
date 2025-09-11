package duan1.DAO;

import java.util.List;
import duan1.entity.ThongTin;

public interface TTCaNhanDAO {
    void insert(ThongTin tt);    
    List<ThongTin> findByMaNV(String MaNV);   
    List<ThongTin> findByMonthAndYear(int month, int year);   
    ThongTin findById(String MaNV);  
    List<ThongTin> findAll();
    List<ThongTin> findByTrangThai(String trangThai);
      
}
