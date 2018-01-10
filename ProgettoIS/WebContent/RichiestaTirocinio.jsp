
<!-- 
Jsp che permette di compilare una form per richiedere una convenzione

autori: Mario Procida

 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,dao.*,bean.*,java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Richiesta tirocinio</title>
</head>
<body class="bg-primary">

<%@ include file="/header.jsp"%>


	<div id="wrapper">
		
		<!--  Form per la richiesta di convenzione -->
		<header class="masthead bg-primary text-white text-center">
			<div class="container">
			
			<!--  Se l'utente � loggato mostra la form -->
			<% if(email != null && password != null){ %>
				<form action="rTiro" method="post">
					<input type="hidden" name="tipo" value="confermaForm">
					<label name="tutor">TutorAccademico</label> <input type="text" name="tutorAccademico" pattern="^[0-9a-zA-Z,\.\s']+$" required /> <br>
					<input type="submit" class="btn btn-info" value="Conferma form" />
				</form>
			<%}else{ %>
				<h3>Non sei loggato. Devi effettuare il login</h3>
			<%} %>
			</div>
		</header>
	</div>
	
	
	<div class="bg-primary" id="push"></div>
	<%@include file="/footer.jsp"%>
