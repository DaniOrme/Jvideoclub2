
<%@ page import="modelodatos.Distribuidor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'distribuidor.label', default: 'Distribuidor')}" />
		<title><g:message code="Listar Distribuidoras" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-distribuidor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="list-distribuidor" class="content scaffold-list" role="main">
			<h1><g:message code="Mostrar listado distribuidoras" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
				       <g:sortableColumn property="id" title="${message(code: 'Código', default: 'Código')}" />
						
						<g:sortableColumn property="nombre" title="${message(code: 'distribuidor.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="cif" title="${message(code: 'distribuidor.cif.label', default: 'Cif')}" />
					
						<g:sortableColumn property="fechaInicioContrato" title="${message(code: 'distribuidor.fechaInicioContrato.label', default: 'Fecha Inicio Contrato')}" />
					
						<g:sortableColumn property="fechaFinContrato" title="${message(code: 'distribuidor.fechaFinContrato.label', default: 'Fecha Fin Contrato')}" />
					
					
						<g:sortableColumn property="e_mail" title="${message(code: 'distribuidor.e_mail.label', default: 'e_mail')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${distribuidorInstanceList}" status="i" var="distribuidorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					    <td>${fieldValue(bean: distribuidorInstance, field: "id")}</td>					
					
						<td>${fieldValue(bean: distribuidorInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: distribuidorInstance, field: "cif")}</td>
					
						<td><g:formatDate date="${distribuidorInstance.fechaInicioContrato}" format="dd-MM-yyyy" /></td>
					
						<td><g:formatDate date="${distribuidorInstance.fechaFinContrato}" format="dd-MM-yyyy" /></td>
					
						<td>${fieldValue(bean: distribuidorInstance, field: "e_mail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${distribuidorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
