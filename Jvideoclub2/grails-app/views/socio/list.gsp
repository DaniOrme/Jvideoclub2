
<%@ page import="modelodatos.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-socio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-socio" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dni" title="${message(code: 'socio.dni.label', default: 'Dni')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'socio.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellidos" title="${message(code: 'socio.apellidos.label', default: 'Apellidos')}" />
					
						<g:sortableColumn property="fechaRegistro" title="${message(code: 'socio.fechaRegistro.label', default: 'Fecha Registro')}" />
					
						<g:sortableColumn property="direccion" title="${message(code: 'socio.direccion.label', default: 'Direccion')}" />
					
						<g:sortableColumn property="poblacion" title="${message(code: 'socio.poblacion.label', default: 'Poblacion')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${socioInstanceList}" status="i" var="socioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${socioInstance.id}">${fieldValue(bean: socioInstance, field: "dni")}</g:link></td>
					
						<td>${fieldValue(bean: socioInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "apellidos")}</td>
					
						<td><g:formatDate date="${socioInstance.fechaRegistro}" /></td>
					
						<td>${fieldValue(bean: socioInstance, field: "direccion")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "poblacion")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${socioInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
