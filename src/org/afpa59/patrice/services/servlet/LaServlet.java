package org.afpa59.patrice.services.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afpa59.patrice.donnees.Article;

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

		Integer compteur = null;

		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		page.println("<html>");
		page.println("<head>");
		page.println("<title> La Servlet </title>");
		page.println("</head>");
		page.println("</html>");		

		page.println("<body> Je suis là dans le doGET<br><br></body>");

		/* Création et récupération de la session*/

		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}

		System.out.println("compteur: " + compteur);

		Article article = (Article) request.getAttribute("Article");

		System.out.println("Code: " + article.getCode());
		System.out.println("Designation: " + article.getDesignation());
		System.out.println("Prix: " + article.getPrix());

		if (article.getCode() == 0 || article.getDesignation().equals(" ") ){
			page.println("<body>");
			page.println("Veuillez saisir tous les champs.");	
		}else{
			page.println("<body>");

			page.println("Hauteur du panier: "
					+ compteur
					+ "<br><br>");			

			page.println("<font size=+2>");
			page.println("Votre Article saisie est: <br><br>"
					+ "Code: "
					+ article.getCode()
					+ "<br> Designation: "
					+ article.getDesignation()
					+ "<br>Prix: "
					+ article.getPrix());
			page.println("</font>");
		}
		page.println("<br><br><a href='SaisieArticle.html'> Retour index</a>");
		page.println("</body>");	
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

		page.println("<body> Je suis là dans le doPOST<br><br></body>");


		/* Création et récupération de la session*/

		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}

		System.out.println("compteur: " + compteur);

		Article article = (Article) request.getAttribute("Article");

		System.out.println("Code: " + article.getCode());
		System.out.println("Designation: " + article.getDesignation());
		System.out.println("Prix: " + article.getPrix());

		if (article.getCode() == 0 || article.getDesignation().equals(" ") ){
			page.println("<body>");
			page.println("Veuillez saisir tous les champs.");	
		}else{
			page.println("<body>");

			page.println("Hauteur du panier: "
					+ compteur
					+ "<br><br>");			

			page.println("<font size=+2>");
			page.println("Votre Article saisie est: <br><br>"
					+ "Code: "
					+ article.getCode()
					+ "<br> Designation: "
					+ article.getDesignation()
					+ "<br>Prix: "
					+ article.getPrix());
			page.println("</font>");
		}
		page.println("<br><br><a href='SaisieArticle.html'> Retour index</a>");
		page.println("</body>");	
	}

}
