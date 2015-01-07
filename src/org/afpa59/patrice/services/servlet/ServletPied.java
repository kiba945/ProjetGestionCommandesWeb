package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afpa59.patrice.utils.DateUser;
import com.afpa59.patrice.utils.ES;

/**
 * Servlet implementation class ServletPied
 */
public class ServletPied extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPied() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ES.affiche("Youpi!!!!!!!!!! J'ai ma ServletPied");
		
//		DateUser dateJour = new DateUser();
//
//		response.setContentType("text/html");
//		PrintWriter page = response.getWriter();	

//		System.out.println(request.getParameter("year"));

//		if(request.getParameter("year") == null){
//			page.println("<br><br><div align='right'><a> Copyright © "
//					+ dateJour.getAnnee()
//					+	"</a></div>");
//		} else {
//			page.println("<br><br><div align='right'><a> Copyright © "
//					+ request.getParameter("year")
//					+	"</a></div>");
//		}
		
//		page.println("<br><br><div align='right'><a> Copyright © "
//		+ dateJour.getAnnee()
//		+	"</a></div>");

	}

}
