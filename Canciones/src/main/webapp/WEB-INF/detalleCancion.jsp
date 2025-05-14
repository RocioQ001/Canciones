<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Detalle canción </title>
	</head>
	<body>
		<ul>
			<h2> - Información de la Canción - </h2>
			<p><strong>Título:</strong> ${cancion.titulo} </p>
			<p><strong>Artísta:</strong> ${cancion.artista} </p>
			<p><strong>Albúm:</strong> ${cancion.album} </p>
			<p><strong>Género musical:</strong> ${cancion.genero} </p>
			<p><strong>Idioma de la canción:</strong> ${cancion.idioma} </p>
			<a href="/canciones"> Volver a la lista de canciones </a>
		</ul>
	</body>
</html>
