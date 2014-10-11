
<%@ page import="modelodatos.Soporte" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'soporte.label', default: 'Soporte')}" />
		<title><g:message code="Mostrar Soporte" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-soporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>		
			</ul>
		</div>
		<div id="show-soporte" class="content scaffold-show" role="main">
			<h1><g:message code="Mostrar Soporte" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list soporte">
			
				<g:if test="${soporteInstance?.id}">
				<li class="fieldcontain">
					<span id="codigo-soporte-label" class="property-label"><g:message code="Código soporte" default="Código soporte" /></span>
					
					<span class="property-value" aria-labelledby="codigo-soporte-label">${soporteInstance?.id}</span>
					
				</li>
				</g:if>
			
				<g:if test="${soporteInstance?.pelicula}">
				<li class="fieldcontain">
					<span id="pelicula-label" class="property-label"><g:message code="soporte.pelicula.label" default="Título Película" /></span>
					
						<span class="property-value" aria-labelledby="tipoSoporte-label"><g:fieldValue bean="${soporteInstance}" field="pelicula"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${soporteInstance?.tipoSoporte}">
				<li class="fieldcontain">
					<span id="tipoSoporte-label" class="property-label"><g:message code="soporte.tipoSoporte.label" default="Tipo Soporte" /></span>
					
						<span class="property-value" aria-labelledby="tipoSoporte-label"><g:fieldValue bean="${soporteInstance}" field="tipoSoporte"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${soporteInstance?.tipoSoporte}">
				<li class="fieldcontain">
					<span id="tipoSoporte-label" class="property-label"><g:message code="soporte.precioAlquiler.label" default="Precio Alquiler" /></span>
					
						<span class="property-value" aria-labelledby="tipoSoporte-label"><g:formatNumber number="${soporteInstance.precioAlquiler}" type="currency" currencyCode="EUR" /></span>
					
				</li>
				</g:if>
			
			</ol>
			
		</div>
	</body>
</html>
