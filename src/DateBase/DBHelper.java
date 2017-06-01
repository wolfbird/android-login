package DateBase;

import java.sql.*;

/**
 * Created by administer on 2017/5/19.
 */
public class DBHelper {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/userdatabase";
    private static final String adminname = "root";
    private static final String password = "nimahai3155828";
    private static Connection connection = null;
    private static final String driver = "com.mysql.jdbc.Driver";


    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {//获得数据库的连接
        if (connection == null){
            connection =  DriverManager.getConnection(url,adminname,password);
            return connection;
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DBHelper.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM userinformation");
        ResultSet set = statement.executeQuery();
        if (connection!=null){
            while (set.next()){
                String a = set.getString("username");
                String b = set.getString("password");
                System.out.println(a+"   "+b);
            }
        }
        else {
            System.out.println("连接异常");
        }
    }
}
