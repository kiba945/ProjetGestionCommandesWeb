package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afpa59.patrice.donnees.Article;
import com.afpa59.patrice.service.fichier.ServiceArticle;

/**
 * Servlet implementation class LaServlet
 */
public class LaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LaServlet() {
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
		page.println("<title> La Servlet </title>");
		page.println("</head>");
		page.println("</html>");		

		page.println("<body> Je suis là dans le doGET de LaServlet<br><br></body>");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer compteur = null;

		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		page.println("<html>");
		page.println("<head>");
		page.println("<title> La Servlet </title>");
		page.println("</head>");
		page.println("</html>");		

		page.println("<body> Je suis là dans le doPOST de LaServlet<br><br></body>");

		/* Création et récupération de la session*/

		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}

		System.out.println("Hauteur du panier: " + compteur);

		ServiceArticle serviceArt = (ServiceArticle) request.getAttribute("ServiceArticle");

		System.out.println(serviceArt.toString());
		
		System.out.println("Taille du tableau: " 
		+ serviceArt.getTabArticle().size());
		
//		System.out.println("Code: " + ServiceArt.getCode());
//		System.out.println("Designation: " + ServiceArt.getDesignation());
//		System.out.println("Prix: " + ServiceArt.getPrix());

		if (serviceArt == null ){
			page.println("<body>");
			page.println("Veuillez saisir tous les champs.");	
		}else{
			page.println("<body>");

			page.println("Hauteur du panier: "
					+ compteur
					+ "<br><br>");			

			page.println("<font size=+2>");
			page.println("Affichage des articles: <br><br>"
					+ serviceArt.toString().replace("\n", "<br>")
					+ "<br>");
			
			page.println("</font>");
		}
		page.println("<br><br><a href='SaisieArticle.html'> Retour index</a>");
		page.println("</body>");	
	}
}
