package com.airline.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPassenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errors", false);
		String firstName = request.getParameter("first-name");
		if (firstName.length() == 0) {
			System.out.println("first name is not present");
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
		}
		else {
		System.out.println(firstName);
		}
		String lastName = request.getParameter("last-name");
		if (lastName.length() == 0) {
			System.out.println("last name is not present");
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
		}
		else{
			System.out.println(lastName);
		}
		String dob_str = request.getParameter("dob");
		String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(dob_str);
		if (m.find()) {
			String dob[] = dob_str.split("\\/");
			String day = dob[0];
			String month = dob[1];
			String year = dob[2];
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			Date date = calendar.getTime();
			System.out.println(date);
		} else {
			System.out.println("date is not present");
			request.setAttribute("errors", true);
			request.setAttribute("date_error", true);
		}
		String gender = request.getParameter("gender");
		System.out.println(gender);
		if((Boolean)request.getAttribute("errors")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp");
			rd.forward(request, response);
		}
	}

}
