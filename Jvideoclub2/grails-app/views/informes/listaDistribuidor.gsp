<%@ page import="modelodatos.Distribuidor"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'distribuidor.label', default: 'Informe de películas por distribuidora')}" />
<title><g:message code="Devolver películas" args="[entityName]" /></title>
</head>
<body>

	<div class="nav"></div>
	<div class="body">
		<h1>
			<g:message code="Informe de películas por distribuidora" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:form controller="djReport" action="index" >
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'distribuidor', 'error')} required">
					<label for="distribuidor"> <g:message code="distribuidor.label"
							default="Distribuidora" /> <span class="required-indicator">*</span>
					</label>
					<g:select id="distribuidor" name="id"
						from="${listaDistribuidor}" optionKey="id" required=""
						value="" class="many-to-one" />
					</div>
				</fieldset>	
					<g:hiddenField name="report" value="soporteByDistribuidor" />
				<fieldset class="buttons">
	
					<g:submitButton name="generarInforme"  value="Generar Informe" />
				</fieldset>
			</g:form>
	</div>
</body>
</html>