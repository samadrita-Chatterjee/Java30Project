/*
 * 16. Create a Java servlet that uses session management to maintain the state of the
user across multiple requests. The servlet should store the user's name in a session
object and display it on multiple pages of the web application.
 * 
 */


package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user's name from the request parameter
        String name = request.getParameter("name");

        // Create a new session or get the existing session
        HttpSession session = request.getSession();

        // Set the user's name in the session
        session.setAttribute("name", name);

        // Redirect to the welcome page
        response.sendRedirect("welcome");
    }
}

