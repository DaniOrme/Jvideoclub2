<%@ page import="modelodatos.Alquiler"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'alquiler.label', default: 'Devolver películas')}" />
<title><g:message code="Devolver películas" args="[entityName]" /></title>
</head>
<body>

	<div class="nav"></div>
	<div class="body">
		<h1>
			<g:message code="Devolver películas" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${alquilerInstance}">
			<div class="errors">
				<g:renderErrors bean="${alquilerInstance}" as="devolver" />
			</div>
		</g:hasErrors>



		<g:form action="devolverPelicula" >
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: alquilerInstance, field: 'socio', 'error')} required">
					<label for="socio"> <g:message code="alquiler.socio.label"
							default="Socio" /> <span class="required-indicator">*</span>
					</label>
					<g:select id="socio" name="id"
						from="${listaSociosAlquileresPendientes}" optionKey="id" required=""
						value="${alquilerInstance?.socio?.id}" class="many-to-one" />
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="devolverPelicula"  value="Devolver Películas" />
				</fieldset>
			</g:form>

		
	</div>
</body>
</html>