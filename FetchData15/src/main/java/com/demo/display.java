/*15. Write a Java servlet that reads the data from a MySQL database table and displays it
in an HTML table on the web page. The servlet should use JDBC to connect to the
database and retrieve the data.
 * 
 * 
 */

package com.demo;



import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class display extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
             Class.forName("com.mysql.cj.jdbc.Driver"); 
             String url="jdbc:mysql:///people";
             String user="root";
             String password="pune#123";
             Connection con = DriverManager.getConnection(url,user,password);  
               
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from student");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>ID</th><th>ADDRESS</th><th>AGE</th><th>NAME</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("sid");  
                 String nm = rs.getString("saddress");  
                 int s = rs.getInt("sage"); 
                 String k =rs.getString("sname");
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + k + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  
