package team.arcticfox.frms.database.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import team.arcticfox.frms.database.Domain.Medicine;
import team.arcticfox.frms.database.Utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;

public class MedicineDAO extends BasicDAO<Medicine> {
//    private QueryRunner qr=  new QueryRunner();
//    public void insert(String sql,Object...Parameters){
//        Connection connection=null;
//        try{
//            connection= JDBCUtilsByDruid.getConnection();
//            qr.insert(connection,sql, ResultSetHandler<Object>,Parameters);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            JDBCUtilsByDruid.close(null,null,connection);
//        }
//    }
}
