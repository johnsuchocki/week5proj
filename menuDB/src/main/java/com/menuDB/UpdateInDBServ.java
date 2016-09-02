package com.menuDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateInDBServ
 */
@WebServlet("/UpdateInDBServ")
public class UpdateInDBServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MenuItem updateItem = new MenuItem();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInDBServ() {
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

		updateItem.setMenuID(request.getParameter("menuID"));
		updateItem.setFoodName(request.getParameter("foodname"));
		updateItem.setCost(request.getParameter("cost"));
		updateItem.setTimeServed(request.getParameter("timeserved"));
		updateItem.setHealthyMenu(request.getParameter("healthymenu"));
		
		DAO2.updateDB(updateItem);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
