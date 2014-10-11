<%@ page import="modelodatos.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
		<title><g:message code="Imprimir Carnet Socio" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-socio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="show-socio" class="content scaffold-show" role="main">
			<h1><g:message code="Imprimir Carnet Socio" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list socio">

				<g:if test="${socioInstance?.id}">
				<li class="fieldcontain">
					<span id="id-label" class="property-label"><g:message code="socio.id.label" default="Número de Socio" /></span>
					
						<span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${socioInstance}" field="id"/></span>
					
				</li>
				</g:if>

				<g:if test="${socioInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="socio.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${socioInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.apellidos}">
				<li class="fieldcontain">
					<span id="apellidos-label" class="property-label"><g:message code="socio.apellidos.label" default="Apellidos" /></span>
					
						<span class="property-value" aria-labelledby="apellidos-label"><g:fieldValue bean="${socioInstance}" field="apellidos"/></span>
					
				</li>
				</g:if>

			
				<g:if test="${socioInstance?.dni}">
				<li class="fieldcontain">
					<span id="dni-label" class="property-label"><g:message code="socio.dni.label" default="Dni" /></span>
					
						<span class="property-value" aria-labelledby="dni-label"><g:fieldValue bean="${socioInstance}" field="dni"/></span>
					
				</li>
				</g:if>

			
				<g:if test="${socioInstance?.fechaRegistro}">
				<li class="fieldcontain">
					<span id="fechaRegistro-label" class="property-label"><g:message code="socio.fechaRegistro.label" default="Fecha Registro" /></span>
					
						<span class="property-value" aria-labelledby="fechaRegistro-label"><g:formatDate date="${socioInstance?.fechaRegistro}" format="dd-MM-yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="socio.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${socioInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.tutor}">
				<li class="fieldcontain">
					<span id="tutor-label" class="property-label"><g:message code="socio.tutor.label" default="Tutor" /></span>
					
						<span class="property-value" aria-labelledby="tutor-label"><g:link controller="socio" action="show" id="${socioInstance?.tutor?.id}">${socioInstance?.tutor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			    
			    
			</ol>
			
		</div>
		<div class="buttons">
           <span class="button"><g:submitButton name="Imprimir" value="Imprimir" onclick="javascript:if (window.print){window.print();}"/></span>
        </div>
	</body>
</html>
