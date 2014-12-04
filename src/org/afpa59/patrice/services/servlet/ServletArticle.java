package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afpa59.patrice.donnees.Article;

/**
 * Servlet implementation class ServletArticle
 */
public class ServletArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer compteur = null;
		compteur = new Integer(0);
		Article article = new Article();

		/* Récupération des élements saisis et création d'un article */
		RequestDispatcher rd = request.getRequestDispatcher("LaServlet");		


		String code = request.getParameter("code");
		if (code != ""){
			article.setCode(Integer.parseInt(code));
		}


		String designation = request.getParameter("designation");
		article.setDesignation(designation);


		String prix = request.getParameter("prix");
		if (prix != ""){
			article.setPrix(Float.parseFloat(prix));
		}

		/* Création et récupération de la session*/
		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}
		compteur = new Integer(compteur.intValue()+1);

		session.setAttribute("monCompteur", compteur);

		request.setAttribute("Article", article);


		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Integer compteur = null;
		compteur = new Integer(0);
		Article article = new Article();

		/* Récupération des élements saisis et création d'un article */
		RequestDispatcher rd = request.getRequestDispatcher("LaServlet");			

		String code = request.getParameter("code");
		if (code != ""){
			article.setCode(Integer.parseInt(code));
		}


		String designation = request.getParameter("designation");
		article.setDesignation(designation);


		String prix = request.getParameter("prix");
		if (prix != ""){
			article.setPrix(Float.parseFloat(prix));
		}

		/* Création et récupération de la session*/
		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}
		compteur = new Integer(compteur.intValue()+1);

		session.setAttribute("monCompteur", compteur);

		request.setAttribute("Article", article);


		rd.forward(request, response);
	}

}
