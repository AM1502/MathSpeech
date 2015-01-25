 <%-- 
    Document   : registration
    Created on : 6 ??? 2014, 7:07:13 ??
    Author     : Evi
--%>
<%@ page import ="java.sql.*" %>
<%
     String fname = request.getParameter("fname");
     String lname = request.getParameter("lname");
     String user = request.getParameter("uname");    
     String email = request.getParameter("email");
     String pwd = request.getParameter("pass");
   
  
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mathcollection",
            "parpanag", "%pa16016");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into users_info(FirstName, LastName, Username, Email, Password) values ('" + fname + "','" + lname + "','" + user + "','" + email + "','" + pwd + "')");
    if (i > 0) {
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>
