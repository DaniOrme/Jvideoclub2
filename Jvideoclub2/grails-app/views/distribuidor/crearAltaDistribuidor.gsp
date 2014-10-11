<%@ page import="modelodatos.Distribuidor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'distribuidor.label', default: 'Distribuidor')}" />
		<title><g:message code="Alta Distribuidora" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-distribuidor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="create-distribuidor" class="content scaffold-create" role="main">
			<h1><g:message code="Alta Distribuidora" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${distribuidorInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${distribuidorInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="saveDistribuidora" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="saveDistribuidora" value="${message(code: 'Crear Distribuidora', default: 'Crear Distribuidora')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
