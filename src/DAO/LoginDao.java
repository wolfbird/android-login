package DAO;

import DateBase.DBHelper;
import com.po.Users;


import java.sql.*;

/**
 * Created by administer on 2017/5/18.
 */
public class LoginDao{
    private static String sql = "select * from userinformation order by username";
    private static Connection connection;
    //从数据库获得数据并且判断是否存在
    public static boolean Login(String name,String password) throws SQLException {
        String sql = "select * from userinformation order by username";
        if (name==null&&"".equals(name)||password==null&&"".equals(password)){
            return false;
        }
        try {
           connection = DBHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String username = set.getString("username");
                String userpassword = set.getString("password");

                if (name.equals(username)&&password.equals(userpassword)){
                    return true;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return false;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DBHelper.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet set = statement.executeQuery();
        while (set.next()){
            String username = set.getString("username");
            String userpassword = set.getString("password");
            System.out.println(username+"  "+userpassword);
            if ("nimahai".equals(username)&&"12323".equals(userpassword)){
                System.out.println("Success");
            }
            else {
               System.out.println("failure");
            }

        }

    }
}
