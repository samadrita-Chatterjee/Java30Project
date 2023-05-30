/*
 * 14. Create a Java servlet that reads the name of the user from a form and displays a
welcome message on the web page. The servlet should use the GET method to read
the input data from the user.
 */

package com.test;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet  extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		String name =req.getParameter("Name");
		
		PrintWriter out = res.getWriter();
		out.println("Wecome " + name);
		
		
		
		
	}
}