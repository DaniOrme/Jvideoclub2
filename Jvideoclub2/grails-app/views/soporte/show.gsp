
<%@ page import="modelodatos.Soporte" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'soporte.label', default: 'Soporte')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-soporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-soporte" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list soporte">
			
				<g:if test="${soporteInstance?.pelicula}">
				<li class="fieldcontain">
					<span id="pelicula-label" class="property-label"><g:message code="soporte.pelicula.label" default="Pelicula" /></span>
					
						<span class="property-value" aria-labelledby="pelicula-label"><g:link controller="pelicula" action="show" id="${soporteInstance?.pelicula?.id}">${soporteInstance?.pelicula?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${soporteInstance?.tipoSoporte}">
				<li class="fieldcontain">
					<span id="tipoSoporte-label" class="property-label"><g:message code="soporte.tipoSoporte.label" default="Tipo Soporte" /></span>
					
						<span class="property-value" aria-labelledby="tipoSoporte-label"><g:fieldValue bean="${soporteInstance}" field="tipoSoporte"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${soporteInstance?.id}" />
					<g:link class="edit" action="edit" id="${soporteInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
