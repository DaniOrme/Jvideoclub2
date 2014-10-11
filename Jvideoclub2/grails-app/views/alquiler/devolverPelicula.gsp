<%@ page import="modelodatos.Alquiler" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alquiler.label', default: 'Alquiler')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-alquiler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">

		</div>
		<div id="list-alquiler" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="id" title="&nbsp;" />
											
						<g:sortableColumn property="fechaAlquiler" title="${message(code: 'alquiler.fechaAlquiler.label', default: 'Fecha Alquiler')}" />
					
						<g:sortableColumn property="fechaDevolucion" title="${message(code: 'alquiler.fechaDevolucion.label', default: 'Fecha Devolucion')}" />
					
						<th><g:message code="alquiler.socio.label" default="Socio" /></th>
					
						<th><g:message code="alquiler.soporte.label" default="Soporte" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${alquilerInstanceList}" status="i" var="alquilerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link onclick="return confirm('¿Desea devolver esta película?');" action="procesarDevolucion"  id="${alquilerInstance.id}">Devolver </g:link></td>
						
						<td><g:formatDate date="${alquilerInstance.fechaAlquiler}" format="dd-MM-yyyy" /></td>
					
						<td><g:formatDate date="${alquilerInstance.fechaDevolucion}" format="dd-MM-yyyy" /></td>
					
						<td>${fieldValue(bean: alquilerInstance, field: "socio")}</td>
					
						<td>${fieldValue(bean: alquilerInstance, field: "soporte")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${alquilerInstanceTotal}" />
			</div>
			
			<g:form>
				<fieldset class="buttons">					
				     <g:link action="devolverTodas" id="${socioInstance?.id}">Devolver todas</g:link>										
				</fieldset>
			</g:form>
		</div>
	</body>
</html>