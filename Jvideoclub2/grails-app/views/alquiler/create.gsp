<%@ page import="modelodatos.Alquiler" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'alquiler.label', default: 'Alquiler')}" />
		<title><g:message code="Alquilar películas" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-alquiler" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">

		</div>
		<div id="create-alquiler" class="content scaffold-create" role="main">
			<h1><g:message code="Alquilar películas" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${alquilerInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${alquilerInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create"  value="${message(code: 'Alquilar', default: 'Alquilar')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
