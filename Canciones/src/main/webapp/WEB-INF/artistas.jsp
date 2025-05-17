<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Artistas </title>
	</head>
	<body>
		<ul>
			<c:forEach var="artista" items="${listaArtistas}">
				<li>
				<a href="/artistas/detalle/${artista.id}"> ${artista.nombre} ${artista.apellido} </a>
				</li>
			</c:forEach>
		</ul>
		<a href="/canciones"> Ir a canciones </a>
	</body>
</html>
