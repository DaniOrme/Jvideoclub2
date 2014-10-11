
<%@ page import="modelodatos.Pelicula" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pelicula.label', default: 'Pelicula')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pelicula" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pelicula" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="titulo" title="${message(code: 'pelicula.titulo.label', default: 'Titulo')}" />
					
						<g:sortableColumn property="tipoCategoria" title="${message(code: 'pelicula.tipoCategoria.label', default: 'Tipo Categoria')}" />
					
						<g:sortableColumn property="calificacionMoral" title="${message(code: 'pelicula.calificacionMoral.label', default: 'Calificacion Moral')}" />
					
						<g:sortableColumn property="tipoGenero" title="${message(code: 'pelicula.tipoGenero.label', default: 'Tipo Genero')}" />
					
						<g:sortableColumn property="duracion" title="${message(code: 'pelicula.duracion.label', default: 'Duracion')}" />
					
						<g:sortableColumn property="director" title="${message(code: 'pelicula.director.label', default: 'Director')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${peliculaInstanceList}" status="i" var="peliculaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${peliculaInstance.id}">${fieldValue(bean: peliculaInstance, field: "titulo")}</g:link></td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "tipoCategoria")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "calificacionMoral")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "tipoGenero")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "duracion")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "director")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${peliculaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
