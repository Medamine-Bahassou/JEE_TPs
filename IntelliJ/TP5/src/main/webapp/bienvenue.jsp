<%@ page errorPage = "erreur.jsp" import="personne.*" %>
<jsp:useBean id="utilisateur" class="personne.Personne" scope="session">
    <jsp:setProperty name="utilisateur" property="*" />
</jsp:useBean>

<%!
    String idPersonne = "";
    String identite = "A tout le monde"; // Updated variable name
%>

<%
    idPersonne = utilisateur.identificateur();
%>

<html>
<head>
    <title>Bienvenue</title>
</head>

<body>
<h1>Bonjour, <strong><%= utilisateur.getNom() %> <%= utilisateur.getPrenom() %></strong></h1>
<p>Votre identifiant est: <strong><%= idPersonne %></strong></p>
<p>Et votre mot de passe est: <strong><%= utilisateur.getMotDePasse() %></strong></p>

<%
    // Remove utilisateur from session at the end
    session.removeAttribute("utilisateur");
%>
</body>
</html>