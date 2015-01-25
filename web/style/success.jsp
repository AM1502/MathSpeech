<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%-- 
    Document   : success
    Created on : 6 ??? 2014, 7:09:57 ??
    Author     : Evi
--%>
<html>
    <head>
        <title>This is MathSpeech</title>
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
        <form method="POST" action="/logout">
        <div id="wrapper">
            <div id="footer"></div>
	</div>
        <center>
            <%
                    if ((session.getAttribute("Username") == null) || (session.getAttribute("Username") == "")) {
                %>
                        You are not a member,please create an account<br/>
                        <a href="style/reg.jsp">Please sign up</a>

                <%} else {
                %>
                        <h2>Welcome <%=session.getAttribute("Username")%></h2>
                       <%-- <a href="style/logout.jsp">Log out</a>--%>
                        <a href="<c:url value="/logout?action=users_info&image=${users_info.Username}" />"> </a>
                <%
                }
                %>
            <h2>You are in the main menu of the MathSpeech!</h2>
        </center>


        </br></br></br></br>


        <center>
            <c:import url="footer.jsp"></c:import>
        </center>
        </form>
    </body>
</html>