package team.arcticfox.frms.database.service;

import team.arcticfox.frms.database.DAO.MedicineDAO;
import team.arcticfox.frms.database.Domain.Medicine;

import java.util.ArrayList;

public class MedicineService {

   private MedicineDAO medicineDAO= new MedicineDAO();
   //查询药品
   public Medicine getMedicine(int id){
       String sql="select * from where id =?";
       Medicine medicine= medicineDAO.querySingle(sql,Medicine.class,id);
       return  medicine;
   }
   //插入新的药品
    public void insertMedicine(int id,String CAS,String formula,String type,int quantity){
       String sql="insert into medicine values(?,?,?,?,?)";
        int affectedRow = medicineDAO.update(sql, null, CAS, formula, type, quantity);
    }
    //删除一种药品
    public void deleteMedicine(String CAS){
       String sql="delete from medicine where CAS=?";
       medicineDAO.update(sql,CAS);
    }
}
