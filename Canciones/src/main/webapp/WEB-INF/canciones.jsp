<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
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
				<th> ${cancion.artista} </th>
				<th><a href="/canciones/detalle/${cancion.id}">Detalle</a></th>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
