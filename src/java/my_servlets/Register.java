/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author Chris
 */
public class Register extends HttpServlet {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/mathcollection";
    String dbUserName = "parpanag";
    String dbpassword = "%pa16016";
    Connection conn = null;
    Statement stmt = null;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

      
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uemail = request.getParameter("email");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        int id = 0;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUserName, dbpassword);

            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select Username from users_info where Username=?");
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                PreparedStatement ps3 = (PreparedStatement) conn.prepareStatement("select Email from users_info where Email=?");
                ps3.setString(1, uemail);
                ResultSet rs3 = ps3.executeQuery();

                if (!rs3.next()) {
                    PreparedStatement pst = (PreparedStatement) conn.prepareStatement("SELECT id FROM users_info");
                    ResultSet rs2 = pst.executeQuery();
                    stmt = conn.createStatement();

                    while (rs2.next()) {
                        id = rs2.getInt(1);
                    }

                    //String sql="insert into table values(?,?,?,?)";
                    java.sql.PreparedStatement ps2 = conn.prepareStatement("insert into users_info values(?,?,?,?,?,?)");

                    ps2.setInt(1, id + 1);
                    ps2.setString(2, fname);
                    ps2.setString(3, lname);
                    ps2.setString(4, uemail);
                    ps2.setString(5, uname);
                    ps2.setString(6, pass);
                    int i = ps2.executeUpdate();
                    if (i > 0) {
                        /*RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                         rd.include(request, response);
                         out.print(" You are successfully registered! Now you can login!");*/
                        request.setAttribute("message", "You are successfully registered! Now you can login!");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } else {
                    /*session.setAttribute("errormessage","Sorry, it looks like that email is already taken.Please choose an other one.");
                     RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
                     rd.include(request, response);*/
                    request.setAttribute("message2", "Sorry, it looks like that email is already taken.Please choose an other one.");
                    request.getRequestDispatcher("/reg.jsp").forward(request, response);
                }
            } else {
                /*RequestDispatcher rd = request.getRequestDispatcher("/signup.jsp");
                 rd.include(request, response);
                 out.println(" Sorry, it looks like that username is already taken.<br>Please choose an other one.");
                 */
                request.setAttribute("message2", "Sorry, it looks like that username is already taken.Please choose an other one.");
                request.getRequestDispatcher("/reg.jsp").forward(request, response);
            }
            out.println();

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
        }
        
    }
}
