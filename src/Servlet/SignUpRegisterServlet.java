package Servlet;

import DAO.SignUpDao;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by administer on 2017/5/19.
 */
public class SignUpRegisterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"   "+password);
        SignUpDao signup = new SignUpDao();
        PrintWriter outputStream = response.getWriter();

        try {
            boolean IsWorked = signup.InsertInformation(username,password);
            if (IsWorked){
                outputStream.write(String.valueOf(true));
            }
            else {
                outputStream.write(String.valueOf(false));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
