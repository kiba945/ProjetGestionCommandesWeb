<%@page import="com.afpa59.patrice.utils.ConnectionFichiersArticles"%>
<%@page import="com.afpa59.patrice.service.fichier.ServiceArticle"%>

<%@ taglib uri="/WEB-INF/Tag01.tld" prefix="Tag01" %>

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

	

	<%
		String nom = request.getParameter("nom");

		if (nom == null) {
			out.println("C'est OKAY.....");
		} else {
			out.println("C'est OKAY....." + nom);
		}
	%>

	<br><br>

	<%
		int a = 100;
		out.println(" depuis les taps" + a);
	%>

	<br><br>
			
			le prix est de <%= a %> euros
			
			<br><br>
			
			<% for(int i = 1; i<11; i++){ %> 
			
				Je boucle pour la <%= i%>
			
				<% if(i == 1){ %>
			
					�re fois
				
				<% }else{ %>
			
					�me fois
				
				<% } %>
			
				<br>
			
				<% } %>
			
			<br><br>

			Hauteur du panier <%= session.getAttribute("monCompteur") %>

			<br><br>
			
			<Tag01:Tag01/>
			
			<br><br>
			
			<Tag01:Tag02/>
			
			<br/><br>
			
			<Tag01:Tag02 name="TAG 02"/>
						
			<br><br>
			
			
			<Tag01:Tag03 name="TAG 03"/>
						
			<br><br>
			
<%-- 			<Tag01:Tag02:upperCase>Ce texte sera mis en majuscule, ainsi que le r�sultat de ce <%="scriptlet"%>.</tag11:upperCase> --%>
			
			<jsp:useBean id="Service" class="com.afpa59.patrice.service.fichier.ServiceArticle" scope="session"/>
			
			<br><br>
			
			
<%-- 			<jsp:include page="/ServletPied" > --%>
<%-- 				<jsp:param name="year" value="2014"/> --%>
<%-- 			</jsp:include> --%>
			
<%-- 			Ann�e <%= request.getParameter("year") %> --%>
			
		</body>
</html>