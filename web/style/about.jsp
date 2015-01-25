<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%-- 
    Document   : about
    Created on : 10 Δεκ 2014, 11:41:13 μμ
    Author     : Evi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Us</title>
        <style type="text/css">
            body {
		background-color: #FFFFCC;
            }
               
            #footer {
                width:100%;
                height:100px;
                position:absolute;
                bottom:0;
                left:0;
                background:#ee5;
            }
            p {
                font-family: "Times New Roman";
		font-size: 20px;
                text-align: justify;
                text-indent: 50px;
            }
            
        </style>
    </head>
    
    
    <body>
        <div id="wrapper">
            <div id="footer"></div>
        </div>
        
        <h2><u>Administrator's personal data</u></h2>
        
        </br></br>
        
        <ul>
          <li><h3><strong>Name :  </strong> Panayiotara Paraskeuh</h3> </li>
          <li><h3><strong>E-mail:  </strong> parpanag@inf.uth.gr/evi_panayiotara@hotmail.co.uk </h3></li>
          <li><h3><strong>Telephone :  </strong> +30 6974548836 </h3></li>
          <li><h3><strong>Address :  </strong>Volos, Greece, 38222</h3></li>
        </ul>
        
        </br></br>
        
       <p> I am a student at University of Thessaly at the Department of <i><b>Electrical & Computer Engineering </b></i>
        and i have developed this web application for Mr Vavalis subject, <i>Worldwide Wide Web Technologies</i>.I would 
        like to 
        make my diplomatic task on web technologies,as well as work as web developer and for this reason i decided 
        to create a web application,
        which will provide me with all necessary knowledge.I really love mathematics and so with the valuable 
        help of Mr. Vavalis decide to develop <i><b>MathSpeech</i></b>.
        I am a self-motivated person with excellent organisational skills, highly efficient
        and with a good eye for detail. Able to play a key role in analysing problems and come up 
	with creative solutions.A quick learner who can absorb new ideas
	and can communicate clearly and effectively.</p>
       
        <center>
             <c:import url="footer.jsp"></c:import>  
        </center>
      
    </body>
    
</html>
