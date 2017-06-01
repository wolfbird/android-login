package Servlet;

import DAO.LoginDao;
import com.po.Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by administer on 2017/5/18.
 */
public class LoginServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");

        boolean flag = false;
        try {
            flag = LoginDao.Login(name,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter outputStream = response.getWriter();
        if (flag){
           outputStream.write(String.valueOf(true));

        }
        else {

           outputStream.write(String.valueOf(false));
        }


    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
