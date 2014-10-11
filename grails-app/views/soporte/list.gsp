
<%@ page import="modelodatos.Soporte" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'soporte.label', default: 'Soporte')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-soporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-soporte" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="soporte.pelicula.label" default="Pelicula" /></th>
					
						<g:sortableColumn property="tipoSoporte" title="${message(code: 'soporte.tipoSoporte.label', default: 'Tipo Soporte')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${soporteInstanceList}" status="i" var="soporteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${soporteInstance.id}">${fieldValue(bean: soporteInstance, field: "pelicula")}</g:link></td>
					
						<td>${fieldValue(bean: soporteInstance, field: "tipoSoporte")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${soporteInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
