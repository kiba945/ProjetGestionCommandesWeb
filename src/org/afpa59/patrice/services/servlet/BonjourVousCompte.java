package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BonjourVousCompte
 */
public class BonjourVousCompte extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int compte = 0;	//Compteur du nombre d'appels de la servlet
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BonjourVousCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		compte = 0;
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
		
		compte++;

		page.println("<br><br>Appel numero: " + compte);
		
		page.println("<br><br><a href='FormulaireGET.html'> Retour FormulaireGET</a>");
		page.println("</body>");
		
	}
		
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
