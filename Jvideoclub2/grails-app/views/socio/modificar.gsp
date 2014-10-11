<%@ page import="modelodatos.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
		<title><g:message code="Modificar Datos Socio" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-socio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>

			</ul>
		</div>
		<div id="modificar" class="content scaffold-edit" role="main">
			<h1><g:message code="Modificar Datos Socio" args="[entityName]" /></h1>
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
			<g:form method="post" >
				<g:hiddenField name="id" value="${socioInstance?.id}" />
				<g:hiddenField name="version" value="${socioInstance?.version}" />
				<fieldset class="form">
					<g:render template="formComun"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="actualizarSocio" action="actualizarSocio" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>