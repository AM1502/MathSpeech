/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   package my_servlets;
   
    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.RequestDispatcher;  
    import javax.servlet.ServletException;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    import javax.servlet.http.HttpSession;  
      
    import connect_with_my_sql_database.LoginDao;  
      
    public class Login extends HttpServlet{  
      
        private static final long serialVersionUID = 1L;  
      
        protected void doGet(HttpServletRequest request, HttpServletResponse response)    
                throws ServletException, IOException {
          
            PrintWriter pw = response.getWriter();
            pw.println(getServletConfig().getInitParameter("adminEmail"));
        }
   
      @Override protected void doPost(HttpServletRequest request, HttpServletResponse response)    
                throws ServletException, IOException {    
      
            response.setContentType("text/html");    
           PrintWriter out = response.getWriter();   
              
            String n=request.getParameter("j_Username");    
            String p=request.getParameter("j_Password");   
              
            HttpSession session = request.getSession(false);  
            if(session!=null)  {
                 session.setAttribute("Username", n);  
                 session.setAttribute("Password", p);  
            }
      
            if(LoginDao.validate(n, p)){    
              
                RequestDispatcher rd=request.getRequestDispatcher("style/success.jsp"); 
                rd.forward(request,response);    
            }    
            else{  
               //out.print("<p  style=\"color:red\">Sorry "+n+" or "+p+" error</p>");
                RequestDispatcher rd=request.getRequestDispatcher("style/loginError.jsp");    
                rd.forward(request,response);    
            }    
            
           
            out.close();    
        }    
    }   