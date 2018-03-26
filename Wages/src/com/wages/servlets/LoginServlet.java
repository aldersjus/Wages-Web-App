package com.wages.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseDAO;

/**
 * Servlet implementation class LoginServlet
 * @author Justin Alderson
 * Checks to see if the user is author is a registered user.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * Login will be checked to see if the user is valid.
     */
    public LoginServlet() {
        super();
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Set cookies and session timeout if registered user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		boolean validUser = false;
		
		try(DatabaseDAO db = new DatabaseDAO()){
		
			db.getConnection();
			validUser = db.checkUserPassword(user, password);
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			
		}
		
		if(validUser) {
			HttpSession session = request.getSession();
			
			session.setAttribute("user", user);
			
			///Set session to expire after.. 15 mins
			session.setMaxInactiveInterval(15*60);
			response.sendRedirect("userPage.jsp");
			
		}else {
			
			//Send to page incorrect details...
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is incorrect.</font>");
			rd.include(request, response);
			
		}
	}
	}
