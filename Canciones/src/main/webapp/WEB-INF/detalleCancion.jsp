<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
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
			<p><strong>Artísta:</strong> ${cancion.artista.nombre} ${cancion.artista.apellido} </p>
			<p><strong>Albúm:</strong> ${cancion.album} </p>
			<p><strong>Género musical:</strong> ${cancion.genero} </p>
			<p><strong>Idioma de la canción:</strong> ${cancion.idioma} </p>
			<a href="/canciones"> Volver a la lista de canciones </a>
			<form action="/canciones/formulario/editar/${cancion.id}" method="GET">
				<button type="submit"> Actualizar canción </button>
			</form>
			<form action="/canciones/eliminar/${cancion.id}" method="POST">
				<input type="hidden" name="_method" value="DELETE">
				<button type="submit"> Eliminar cancion </button>
			</form>
		</ul>
	</body>
</html>
