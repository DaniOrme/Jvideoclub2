<%@ page import="modelodatos.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'Alta Socio Mayor Edad', default: 'Socio')}" />
		<title><g:message code="Alta Socio Menor Edad" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-socio" class="skip" tabindex="-1"><g:message code="Alta Socio Menor Edad" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="create-socio" class="content scaffold-create" role="main">
			<h1><g:message code="Alta Socio Menor de Edad" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${socioInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${socioInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="saveSocioMenor" >
				<fieldset class="form">
					<g:render template="formMenor"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="saveSocioMenor" value="${message(code: 'Crear Socio', default: 'Crear Socio')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>