
<%@ page import="modelodatos.Distribuidor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'Mostrar Distribuidora', default: 'Distribuidor')}" />
		<title><g:message code="Mostrar Distribuidora" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-distribuidor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>


			</ul>
		</div>
		<div id="show-distribuidor" class="content scaffold-show" role="main">
			<h1><g:message code="Mostrar Distribuidora" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list distribuidor">
			
			<g:if test="${distribuidorInstance?.id}">
				<li class="fieldcontain">
					<span id="id-label" class="property-label"><g:message code="Código" default="Código" /></span>
					
						<span class="property-value" aria-labelledby="id-label"><g:fieldValue bean="${distribuidorInstance}" field="id"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="distribuidor.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${distribuidorInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.cif}">
				<li class="fieldcontain">
					<span id="cif-label" class="property-label"><g:message code="distribuidor.cif.label" default="Cif" /></span>
					
						<span class="property-value" aria-labelledby="cif-label"><g:fieldValue bean="${distribuidorInstance}" field="cif"/></span>
					
				</li>
				
				<g:if test="${distribuidorInstance?.fechaInicioContrato}">
				<li class="fieldcontain">
					<span id="fechaInicioContrato-label" class="property-label"><g:message code="distribuidor.fechaInicioContrato.label" default="Fecha Inicio Contrato" /></span>
					
						<span class="property-value" aria-labelledby="fechaInicioContrato-label"><g:formatDate date="${distribuidorInstance?.fechaInicioContrato}" format="dd-MM-yyyy"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.fechaFinContrato}">
				<li class="fieldcontain">
					<span id="fechaFinContrato-label" class="property-label"><g:message code="distribuidor.fechaFinContrato.label" default="Fecha Fin Contrato" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinContrato-label"><g:formatDate date="${distribuidorInstance?.fechaFinContrato}" format="dd-MM-yyyy"/></span>
					
				</li>
				</g:if>
				
				</g:if>
			
				<g:if test="${distribuidorInstance?.direccion}">
				<li class="fieldcontain">
					<span id="direccion-label" class="property-label"><g:message code="distribuidor.direccion.label" default="Direccion" /></span>
					
						<span class="property-value" aria-labelledby="direccion-label"><g:fieldValue bean="${distribuidorInstance}" field="direccion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.poblacion}">
				<li class="fieldcontain">
					<span id="poblacion-label" class="property-label"><g:message code="distribuidor.poblacion.label" default="Poblacion" /></span>
					
						<span class="property-value" aria-labelledby="poblacion-label"><g:fieldValue bean="${distribuidorInstance}" field="poblacion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.provincia}">
				<li class="fieldcontain">
					<span id="provincia-label" class="property-label"><g:message code="distribuidor.provincia.label" default="Provincia" /></span>
					
						<span class="property-value" aria-labelledby="provincia-label"><g:fieldValue bean="${distribuidorInstance}" field="provincia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.distritoPostal}">
				<li class="fieldcontain">
					<span id="distritoPostal-label" class="property-label"><g:message code="distribuidor.distritoPostal.label" default="Distrito Postal" /></span>
					
						<span class="property-value" aria-labelledby="distritoPostal-label"><g:fieldValue bean="${distribuidorInstance}" field="distritoPostal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label"><g:message code="distribuidor.telefono.label" default="Telefono" /></span>
					
						<span class="property-value" aria-labelledby="telefono-label"><g:fieldValue bean="${distribuidorInstance}" field="telefono"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${distribuidorInstance?.fax}">
				<li class="fieldcontain">
					<span id="fax-label" class="property-label"><g:message code="distribuidor.fax.label" default="Fax" /></span>
					
						<span class="property-value" aria-labelledby="fax-label"><g:fieldValue bean="${distribuidorInstance}" field="fax"/></span>
					
				</li>
				</g:if>
			

			
				<g:if test="${distribuidorInstance?.e_mail}">
				<li class="fieldcontain">
					<span id="e_mail-label" class="property-label"><g:message code="distribuidor.e_mail.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="e_mail-label"><g:fieldValue bean="${distribuidorInstance}" field="e_mail"/></span>
					
				</li>
				</g:if>
		
			
			</ol>

		</div>
	</body>
</html>
