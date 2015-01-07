package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuRevoir
 */
public class AuRevoir extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AuRevoir() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		page.println("<html>");
		page.println("<head>");
		page.println("<title>Ma première page =D</title>");
		page.println("</head>");
		page.println("<body>");
		page.println("<font size=+5>");
		page.println("Au revoir ...<br/> <strong>Adieu</strong>");
		page.println("</font>");
		page.println("<br><br><a href='index.html'> Retour index</a>");
		page.println("</body>");	
		page.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
