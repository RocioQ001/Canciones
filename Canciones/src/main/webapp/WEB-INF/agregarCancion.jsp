<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Formulario agregar canción </title>
	</head>
	<body>
		<h2> -Formulario agregar canción- </h2>
		<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
			<div>
				<form:label path="titulo">
					Título:
				</form:label>
				<form:input path="titulo"/>
				<form:errors path="titulo"/>
			</div>
			<div>
				<form:label path="artista">
					Artísta:
				</form:label>
				<form:input path="artista"/>
				<form:errors path="artista"/>
			</div>
			<div>
				<form:label path="album">
					Albúm:
				</form:label>
				<form:input path="album"/>
				<form:errors path="album"/>
			</div>
			<div>
				<form:label path="genero">
					Género:
				</form:label>
				<form:input path="genero"/>
				<form:errors path="genero"/>
			</div>
			<div>
				<form:label path="idioma">
					Idioma:
				</form:label>
				<form:input path="idioma"/>
				<form:errors path="idioma"/>
			</div>
			<button> Agregar </button>
		</form:form>
		<a href="/canciones"> Volver a la lista de canciones </a>
	</body>
</html>