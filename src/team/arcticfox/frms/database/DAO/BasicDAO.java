package team.arcticfox.frms.database.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import team.arcticfox.frms.database.Utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//开发BasicDAO,是其他DAO的父类
public class BasicDAO<T> {//泛型指定具体类型

    private QueryRunner qr=  new QueryRunner();

    //开发通用的dml方法，针对任意的表
    public int update(String sql,Object...Parameters){
        Connection connection =null;
        try{
            connection= JDBCUtilsByDruid.getConnection();
            int updateRow= qr.update(connection,sql,Parameters);
            return  updateRow;
        }catch(SQLException e){
            throw new RuntimeException(e);//将编译异常转换为运行异常
        }
        finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //返回多个对象（即查询的结果是多行），针对任意表
    /**
     *
     * @param sql sql语句可以有?
     * @param clazz 传入一个Class对象，利用反射,比如Actor.class
     * @param parameters 传入?具体值，可以有多个
     * @return 返回对应的ArrayList集合
     */
    public List<T>queryMulti(String sql,Class<T> clazz,Object...parameters){
        Connection connection=null;
        try{
            connection=JDBCUtilsByDruid.getConnection();
            ArrayList<T> arr= (ArrayList<T>) qr.query(connection,sql,new BeanListHandler<>(clazz),parameters);
            return arr;
        }catch(SQLException e){
            throw new RuntimeException(e);//将编译异常转换为运行异常
        }
        finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行结果的通用方法
    public T querySingle(String sql,Class<T>clazz,Object...parameters){
        Connection connection=null;
        try{
            connection=JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<>(clazz),parameters);//返回一个表对象
        }catch(SQLException e){
            throw new RuntimeException(e);//将编译异常转换为运行异常
        }
        finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行单列的方法，即返回单值的方法
    public Object queryScalar(String sql,Object...parameters){
        Connection connection=null;
        try{
            connection=JDBCUtilsByDruid.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parameters);//返回一个表对象
        }catch(SQLException e){
            throw new RuntimeException(e);//将编译异常转换为运行异常
        }
        finally {
            JDBCUtilsByDruid.close(null,null,connection);
        }
    }
}
