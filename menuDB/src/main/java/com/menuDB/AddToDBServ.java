package com.menuDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddToDBServ
 */
@WebServlet("/AddToDBServ")
public class AddToDBServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MenuItem itemToAdd = new MenuItem();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToDBServ() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		itemToAdd.setFoodName(request.getParameter("foodname"));
		itemToAdd.setCost(request.getParameter("cost"));
		itemToAdd.setTimeServed(request.getParameter("timeserved"));
		itemToAdd.setHealthyMenu(request.getParameter("healthyoption"));
		
		DAO2.addToDB(itemToAdd);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
