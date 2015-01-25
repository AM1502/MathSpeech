<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : logout
    Created on : 6 ??? 2014, 7:10:16 ??
    Author     : Evi
--%>
<html>
   <head>
    <title>Logout</title>
    <style type="text/css">
            body{
		
                background-color: #FFFFCC;
            }
            #footer {
                width:100%;
                height:80px;
                position:absolute;
                bottom:0;
                left:0;
                background:#ee5;
            }
     </style>
    </head>
    
    <body>
        <div id="wrapper">
            <div id="footer"></div>
        </div>
   

<%request.setCharacterEncoding("UTF-8");%>

<%
//session.setAttribute("Username", null);
//session.invalidate();  
response.sendRedirect("index.jsp");

%>

    
 <c:import url="footer.jsp"></c:import>
 
    </body>
    
    </html>
    
    
    
    