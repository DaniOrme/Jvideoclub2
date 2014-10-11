<%@ page import="modelodatos.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
		<title><g:message code="Mostrar listado socios" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-socio" class="skip" tabindex="-1"><g:message code="Mostrar listado socios" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="list-socio" class="content scaffold-list" role="main">
			<h1><g:message code="Mostrar listado socios" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					    <g:sortableColumn property="id" title="${message(code: 'Número de Socio', default: 'Número de Socio')}" />
					
						<g:sortableColumn property="dni" title="${message(code: 'socio.dni.label', default: 'Dni')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'socio.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellidos" title="${message(code: 'socio.apellidos.label', default: 'Apellidos')}" />
					
						<g:sortableColumn property="fechaRegistro" title="${message(code: 'socio.fechaRegistro.label', default: 'Fecha Registro')}" />
					
						<g:sortableColumn property="telefono" title="${message(code: 'socio.telefono.label', default: 'Teléfono')}" />
						
						<g:sortableColumn property="tutor" title="${message(code: 'socio.tutor.label', default: 'Tutor')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${socioInstanceList}" status="i" var="socioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					    <td>${fieldValue(bean: socioInstance, field: "id")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "dni")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "apellidos")}</td>
					
						<td><g:formatDate date="${socioInstance.fechaRegistro}" format="dd-MM-yyyy"/></td>
					
						<td>${fieldValue(bean: socioInstance, field: "telefono")}</td>
						
						<td>${fieldValue(bean: socioInstance, field: "tutor")}</td>
					
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
