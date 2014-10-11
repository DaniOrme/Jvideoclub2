
<%@ page import="modelodatos.Factura" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'factura.label', default: 'Factura')}" />
		<title><g:message code="Facturas pendientes" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-factura" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">

		</div>
		<div id="list-factura" class="content scaffold-list" role="main">
			<h1><g:message code="Facturas pendientes" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="id" title="${message(code: 'factura.id.label', default: 'Número factura')}" />
						
						<th><g:message code="factura.socio.label" default="Socio" /></th>
					
						<g:sortableColumn property="fechaFactura" title="${message(code: 'factura.fechaFactura.label', default: 'Fecha Factura')}" />
					
						<g:sortableColumn property="importe" title="${message(code: 'factura.importe.label', default: 'Importe')}" />
					
	
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${facturaInstanceList}" status="i" var="facturaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					<g:if test="${importeTotal >= 18}">
					     <td>${fieldValue(bean: facturaInstance, field: "id")}</td>
					</g:if>
					<g:else>
						<td><g:link  action="show" id="${facturaInstance.id}">${fieldValue(bean: facturaInstance, field: "id")}</g:link></td>
					</g:else>
						
					
					<td>${fieldValue(bean: facturaInstance, field: "socio")}</td>
				
					<td><g:formatDate date="${facturaInstance.fechaFactura}" format="dd-MM-yyyy" /></td>
					
					<td><g:formatNumber number="${facturaInstance.importe}" type="currency" currencyCode="EUR" /></td>
				

					
					
					</tr>
				</g:each>
				<hr/>
				<tr>
					<td></td><td></td><td><b>Importe total:</b></td><td><b><g:formatNumber number="${importeTotal}" type="currency" currencyCode="EUR" /></b></td>
				</tr>
				</tbody>
			</table>

			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${socioInstance?.id}" />
					<g:if test="${importeTotal >= 18}">
					     <g:link action="cargoCuenta" id="${socioInstance?.id}">Cargo a cuenta</g:link>
					</g:if>
					<g:else>
						<g:link action="pagarTodas" id="${socioInstance?.id}">Pagar todas</g:link>
					</g:else>
					
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
