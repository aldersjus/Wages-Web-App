package com.wages.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wages.beans.WageSlip;

import database.DatabaseDAO;

/**
 * Servlet implementation class DisplayPayServlet
 * Connect to the database through the doGet() method to create a pay slip object.
 * Add the objects fields to request to be used by paySlip.jsp.
 *  @author Justin Alderson
 */
@WebServlet("/DisplayPayServlet")
public class DisplayPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Connect to database, create object, add to request.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WageSlip wages = null;
		HttpSession session = request.getSession();
		String month = request.getParameter("month");
		String name = (String) session.getAttribute("user");
		
		//Connect to database create a bean of pay slip.
		try(DatabaseDAO db = new DatabaseDAO()){
			
			db.getConnection();
			wages = db.findWages(name, month);
		
		} catch (Exception e1) {
			
			e1.printStackTrace();
			
		}
		
		if(wages != null) {
			
			request.setAttribute("month", month);
			request.setAttribute("overtime", wages.getOvertime());
			request.setAttribute("overtimeWorked", wages.getOvertimeWorked());
			request.setAttribute("health", wages.getHealth());
			request.setAttribute("tax", wages.getTax());
			request.setAttribute("total", wages.getTotalPay());
			request.setAttribute("base", wages.getBasePay());
			request.setAttribute("regularity", wages.getRegularity());
			request.setAttribute("shift", wages.getShift());
			request.setAttribute("actual", wages.getActualPay());
			request.setAttribute("overtime", wages.getOvertime());
			request.setAttribute("hoursWorked", wages.getHoursWorked());
			
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/paySlip.jsp");
		rd.forward(request, response);
	}

	
}
