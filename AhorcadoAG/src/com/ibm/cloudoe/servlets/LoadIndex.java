package com.ibm.cloudoe.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloudoe.connectionDB.CloudantConnection;
import com.ibm.cloudoe.model.Category;

/**
 * Servlet implementation class LoadIndex
 */
@WebServlet("/LoadIndex")
public class LoadIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoadIndex() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CloudantConnection cloudantConnection = new CloudantConnection();
		List<Category> categories = cloudantConnection.getCategories();
		request.setAttribute("categories", categories);   
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
