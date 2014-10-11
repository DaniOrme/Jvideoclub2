
<%@ page import="modelodatos.Factura" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'factura.label', default: 'Factura')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-factura" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-factura" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="estaPendiente" title="${message(code: 'factura.estaPendiente.label', default: 'Esta Pendiente')}" />
					
						<g:sortableColumn property="fechaFactura" title="${message(code: 'factura.fechaFactura.label', default: 'Fecha Factura')}" />
					
						<g:sortableColumn property="importe" title="${message(code: 'factura.importe.label', default: 'Importe')}" />
					
						<th><g:message code="factura.socio.label" default="Socio" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${facturaInstanceList}" status="i" var="facturaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${facturaInstance.id}">${fieldValue(bean: facturaInstance, field: "estaPendiente")}</g:link></td>
					
						<td><g:formatDate date="${facturaInstance.fechaFactura}" /></td>
					
						<td>${fieldValue(bean: facturaInstance, field: "importe")}</td>
					
						<td>${fieldValue(bean: facturaInstance, field: "socio")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${facturaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
