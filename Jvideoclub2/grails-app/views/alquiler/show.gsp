
<%@ page import="modelodatos.Alquiler" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alquiler.label', default: 'Alquiler')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-alquiler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-alquiler" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list alquiler">
			
				<g:if test="${alquilerInstance?.fechaAlquiler}">
				<li class="fieldcontain">
					<span id="fechaAlquiler-label" class="property-label"><g:message code="alquiler.fechaAlquiler.label" default="Fecha Alquiler" /></span>
					
						<span class="property-value" aria-labelledby="fechaAlquiler-label"><g:formatDate date="${alquilerInstance?.fechaAlquiler}" format="dd-MM-yyyy"  /></span>
					
				</li>
				</g:if>
			
				<g:if test="${alquilerInstance?.fechaEntrega}">
				<li class="fieldcontain">
					<span id="fechaEntrega-label" class="property-label"><g:message code="alquiler.fechaEntrega.label" default="Fecha Entrega" /></span>
					
						<span class="property-value" aria-labelledby="fechaEntrega-label"><g:formatDate date="${alquilerInstance?.fechaEntrega}" format="dd-MM-yyyy"  /></span>
					
				</li>
				</g:if>
			
				<g:if test="${alquilerInstance?.socio}">
				<li class="fieldcontain">
					<span id="socio-label" class="property-label"><g:message code="alquiler.socio.label" default="Socio" /></span>
					
						<span class="property-value" aria-labelledby="socio-label"><g:link controller="socio" action="show" id="${alquilerInstance?.socio?.id}">${alquilerInstance?.socio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${alquilerInstance?.soporte}">
				<li class="fieldcontain">
					<span id="soporte-label" class="property-label"><g:message code="alquiler.soporte.label" default="Soporte" /></span>
					
						<span class="property-value" aria-labelledby="soporte-label"><g:link controller="soporte" action="show" id="${alquilerInstance?.soporte?.id}">${alquilerInstance?.soporte?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${alquilerInstance?.id}" />
					<g:link class="edit" action="edit" id="${alquilerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
