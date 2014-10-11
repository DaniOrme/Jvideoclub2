<%@ page import="modelodatos.Factura"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'factura.label', default: 'Facturas pendientes')}" />
<title><g:message code="Facturas pendientes" args="[entityName]" /></title>
</head>
<body>

	<div class="nav"></div>
	<div class="body">
		<h1>
			<g:message code="Facturas pendientes" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${facturaInstance}">
			<div class="errors">
				<g:renderErrors bean="${facturaInstance}" as="devolver" />
			</div>
		</g:hasErrors>



		<g:form action="misfacturas" >
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: facturaInstance, field: 'socio', 'error')} required">
					<label for="socio"> <g:message code="factura.socio.label"
							default="Socio" /> <span class="required-indicator">*</span>
					</label>
					<g:select id="socio" name="id"
						from="${listaSociosFacturasPendientes}" optionKey="id" required=""
						value="" class="many-to-one" />
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="pagarFacturas"  value="Consultar facturas" />
				</fieldset>
			</g:form>

		
	</div>
</body>
</html>