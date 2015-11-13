package com.ibm.cloudoe.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.cloudoe.connectionDB.CloudantConnection;
import com.ibm.cloudoe.model.Word;

/**
 * Servlet implementation class LoadGame
 */
@WebServlet("/LoadGame")
public class LoadGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		String value = request.getParameter("value");

		if ((action != null)&&(value != null)) {
		 CloudantConnection cloudantConnection = new CloudantConnection();
		 Word word = cloudantConnection.getRandomWordByCategory(value);
		 if(word!=null){
		    response.setContentType("text/html");
		    response.getWriter().write(word.getName());
		 }
		}
	}

}
