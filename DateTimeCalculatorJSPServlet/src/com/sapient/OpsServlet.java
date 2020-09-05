package com.sapient;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpsServlet
 */
@WebServlet("/OpsServlet")
public class OpsServlet extends HttpServlet {
	
	DateTimeCalculator calculator;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpsServlet() {
        super();
        calculator = new DateTimeCalculator();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int choice = Integer.parseInt(request.getParameter("op"));
		String result = "";
//		System.out.println(choice);
		
		switch (choice) {
		case 1: {
			//Get Period
			result = DateUtil.PeriodToString(calculator.getDifferenceBetweenTwoDates(request.getParameter("date1"), 
					request.getParameter("date2")));
//			System.out.println(result);
			break;
		}
		case 2:
			result = calculator.addNDays(request.getParameter("date1"), Integer.parseInt(request.getParameter("days")));
			break;
		case 3:
			result = calculator.subtractNDays(request.getParameter("date1"), Integer.parseInt(request.getParameter("days")));
			break;
		case 4:
			result = calculator.addNWeeks(request.getParameter("date1"), Integer.parseInt(request.getParameter("weeks")));
			break;
		case 5:
			result = calculator.subtractNWeeks(request.getParameter("date1"), Integer.parseInt(request.getParameter("weeks")));
			break;
		case 6:
			result = calculator.addNMonths(request.getParameter("date1"), Integer.parseInt(request.getParameter("months")));
			break;
		case 7:
			result = calculator.subtractNMonths(request.getParameter("date1"), Integer.parseInt(request.getParameter("months")));
			break;
		case 8:
			result = calculator.getDayOfWeek(request.getParameter("date1"));
			break;
		case 9:
			result = Integer.toString(calculator.getWeekNumber(request.getParameter("date1")));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
