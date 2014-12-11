<%@page import="com.afpa59.patrice.utils.ConnectionFichiersArticles"%>
<%@page import="com.afpa59.patrice.service.fichier.ServiceArticle"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JSP OK</title>
	</head>
		<body>

<%-- 	<jsp:include page="/ServletEntete" > </jsp:include> --%>

			<br><br>

			<% ServiceArticle serviceArt = new ServiceArticle(); %>
			
			<% ConnectionFichiersArticles fichArt; %>
			<% String nomPhysiqueArticle = "C:/Users/afpa1653/Documents/GitHub/ProjetGestionCommandes/TableArticles"; %>
			<% fichArt = new ConnectionFichiersArticles(nomPhysiqueArticle); %>
			<% serviceArt = fichArt.getTab(); %>
					
			
			Affichage des articles: 
			
			<br><br>
			
			<%=  serviceArt.toString().replace("\n", "<br>") %> 
		
			<br><br>

			
			Nbre d'articles <%= serviceArt.getTabArticle().size() %>
			
			<br><br>

			Hauteur du panier <%= session.getAttribute("monCompteur") %>
			
			<jsp:useBean id="Service" class="com.afpa59.patrice.service.fichier.ServiceArticle" scope="session"/>
			
			<br><br>
			
			
<%-- 			<jsp:include page="/ServletPied" > --%>
<%-- 				<jsp:param name="year" value="2014"/> --%>
<%-- 			</jsp:include> --%>
			
<%-- 			Année <%= request.getParameter("year") %> --%>
			
		</body>
</html>