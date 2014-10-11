
<%@ page import="modelodatos.Factura" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'factura.label', default: 'Factura')}" />
		<title><g:message code="Pagar Factura" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-factura" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">

		</div>
		<div id="show-factura" class="content scaffold-show" role="main">
			<h1><g:message code="Pagar Factura" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list factura">
			
				<g:if test="${facturaInstance?.id}">
				<li class="fieldcontain">
					<span id="estaPendiente-label" class="property-label"><g:message code="factura.id.label" default="Número factura" /></span>
					
						<span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${facturaInstance}" field="id"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${facturaInstance?.socio}">
				<li class="fieldcontain">
					<span id="socio-label" class="property-label"><g:message code="factura.socio.label" default="Socio" /></span>
					
						<span class="property-value" aria-labelledby="socio-label"><g:link controller="socio" action="show" id="${facturaInstance?.socio?.id}">${facturaInstance?.socio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${facturaInstance?.fechaFactura}">
				<li class="fieldcontain">
					<span id="fechaFactura-label" class="property-label"><g:message code="factura.fechaFactura.label" default="Fecha Factura" /></span>
					
						<span class="property-value" aria-labelledby="fechaFactura-label"><g:formatDate date="${facturaInstance?.fechaFactura}" format="dd-MM-yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${facturaInstance?.importe}">
				<li class="fieldcontain">
					<span id="importe-label" class="property-label"><g:message code="factura.importe.label" default="Importe" /></span>
					
						<span class="property-value" aria-labelledby="importe-label"><g:formatNumber number="${facturaInstance.importe}" type="currency" currencyCode="EUR" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link action="pagarFactura" id="${facturaInstance?.id}"><g:message code="pagarFactura" default="Pagar factura" /></g:link>
					<g:link action="show" id="${facturaInstance?.id}" onclick="javascript:if (window.print){window.print();}">Imprimir Resguardo</g:link></span>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
