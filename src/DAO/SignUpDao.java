package DAO;

import DateBase.DBHelper;

import java.sql.*;

/**
 * Created by administer on 2017/5/19.
 */
public class SignUpDao {
    private static Connection Connection;
    private Connection connection ;
    private String name ="";
    private String password="";

    //向数据库插入数据;
    public boolean InsertInformation(String name,String password) throws SQLException {
        this.name =name;
        this.password = password;
        Statement statement = null;
        String sql = "INSERT userinformation VALUES ('"+name+"','"+password+"')";//sql语句
        System.out.println("INSERT userinformation VALUES ('"+name+"','"+password+"')");
        try {
            connection = DBHelper.getConnection();//新建连接
            statement = connection.createStatement();//创建statement
           int result = statement.executeUpdate(sql);//执行sql并且返回语句执行成功的数量
            System.out.println(result+"worinima    ");
            if (result>0){
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void main(String[] args) throws SQLException {
        String sql = "INSERT userinformation VALUES ('shit','1234567')";
        Connection = DBHelper.getConnection();//新建连接

       Statement statement =  Connection.createStatement();//创建statement
        int result = statement.executeUpdate(sql);//执行sql并且返回语句执行成功的数量
        if (result>0){
            System.out.println("成功");
        }
        else {
            System.out.println("失败");
        }
    }
}
