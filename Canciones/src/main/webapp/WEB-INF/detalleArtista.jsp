<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Detalle de Artístas </title>
	</head>
	<body>
			<h2> - Información del Artísta - </h2>
			<p><strong>Nombre:</strong> ${artista.nombre} ${artista.apellido} </p>
			<p><strong>Biografía:</strong> ${artista.biografia} </p>
			<h3> Canciones del Artísta: </h3>
		<ul>
			<c:forEach var="cancion" items="${listaCanciones}">
				<li> ${cancion.titulo} </li>
			</c:forEach>
		</ul>
		<a href="/artistas"> Volver a lista de artistas </a>
	</body>
</html>
