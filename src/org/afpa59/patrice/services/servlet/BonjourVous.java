package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BonjourVous
 */
public class BonjourVous extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BonjourVous() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		page.println("<html>");
		page.println("<head>");
		page.println("<title> Servlet Bonjour comptant ses appels</title>");
		page.println("</head>");
		page.println("</html>");		

		String nom = request.getParameter("nom");
		if (nom == null){
			page.println("<body>");
			page.println("BONJOUR");	
		}else{
			page.println("<body>");
			page.println("<font size=+2>");
			page.println("BONJOUR " + nom);
			page.println("</font>");
		}
		page.println("<br><br><a href='FormulaireGET.html'> Retour FormulaireGET</a>");
		page.println("</body>");	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		page.println("<html>");
		page.println("<head>");
		page.println("<title> Servlet Bonjour </title>");
		page.println("</head>");
		page.println("</html>");		

		String nom = request.getParameter("nom");
		if (nom == null){
			page.println("<body>");
			page.println("BONJOUR");
		}else{
			page.println("<body>");
			page.println("<font size=+2>");
			page.println("BONJOUR " + nom);
			page.println("</font>");
		}
		page.println("<br><br><a href='FormulairePOST.html'> Retour FormulairePOST</a>");
		page.println("</body>");	
	}

}
