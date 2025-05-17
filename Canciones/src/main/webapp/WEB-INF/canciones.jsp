<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Canciones </title>
	</head>
	<body>
		<table border=1>
			<tr>
				<th> Titulo </th>
				<th> Autor </th>
				<th> Detalle </th>
			</tr>
			<c:forEach var="cancion" items="${listaCanciones}">
			<tr>
				<th> ${cancion.titulo} </th>
				<th> ${cancion.artista.nombre} ${cancion.artista.apellido} </th>
				<th><a href="/canciones/detalle/${cancion.id}">Detalle</a></th>
			</tr>
			</c:forEach>
		</table>
		<form action="/canciones/formulario/agregar/0" method="GET">
			<button type="submit"> Agregar </button>
		</form>
		<a href="/artistas"> Ir a artistas </a>
	</body>
</html>
