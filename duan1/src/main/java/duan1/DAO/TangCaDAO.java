package duan1.DAO;


import duan1.entity.TangCa;
import java.util.List;

public interface TangCaDAO extends AllDAO<TangCa, String> {
    List<TangCa> fillall1();
}
