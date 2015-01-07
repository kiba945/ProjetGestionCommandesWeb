package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.afpa59.patrice.service.fichier.ServiceArticle;
import com.afpa59.patrice.utils.ConnectionFichiersArticles;

/**
 * Servlet implementation class ServletArticle
 */
public class ServletArticle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static ServiceArticle serviceArt;

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
		
		System.out.println("Je suis là dans le doGET<br><br>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer compteur = null;
		compteur = new Integer(0);
		

		/* Récupération des élements saisis et création d'un article */
		RequestDispatcher rd = request.getRequestDispatcher("LaServlet");			

		ConnectionFichiersArticles fichArt;
		String nomPhysiqueArticle = "C:/Users/afpa1653/Documents/GitHub/ProjetGestionCommandes/TableArticles";
		fichArt = new ConnectionFichiersArticles(nomPhysiqueArticle);
		serviceArt = fichArt.getTab();
		
		String mes;

		mes = "*** CHARGEMENT du FICHIER des ARTICLES ***\n";
		if(serviceArt == null){

			serviceArt = new ServiceArticle(); 
			mes = mes + "*** TABLE ARTICLES VIDE !! ==>" +
					"CREATION par DEFAUT de la TABLE des ARTICLES ***\n";
		}
		
		String code = request.getParameter("code");
		String designation = request.getParameter("designation");
		String prix = request.getParameter("prix");	
		
		if (code != "" && prix != ""){
			serviceArt.creer(Integer.parseInt(code), designation, Float.parseFloat(prix));
			fichArt.ecrire(nomPhysiqueArticle);
		}

		System.out.println("Taille du tableau:" + serviceArt.getTabArticle().size());
		
		/* Création et récupération de la session*/
		HttpSession session = request.getSession();

		if (session.getAttribute("monCompteur") != null){
			compteur = (Integer) session.getAttribute("monCompteur");	
		}
		compteur = new Integer(compteur.intValue()+1);

		session.setAttribute("monCompteur", compteur);

		request.setAttribute("ServiceArticle", serviceArt);


		rd.forward(request, response);
	}

}
