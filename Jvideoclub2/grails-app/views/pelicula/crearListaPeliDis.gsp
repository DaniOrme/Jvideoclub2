<%@ page import="modelodatos.Pelicula" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pelicula.label', default: 'Película')}" />
        <title><g:message code="Mostrar películas distribuidora" args="[entityName]" /></title>
        <calendar:resources lang="es" theme="tiger"/>
    </head>
    <body>
        <div class="nav">

        </div>
        <div class="body">
		<h1><p align="center"><g:message  code="Escoja la distribuidora de las películas:"   args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${peliculaInstance}">
            <div class="errors">
                <g:renderErrors bean="${peliculaInstance}" as="crearListaPeliDis" />
            </div>
            </g:hasErrors>
            <g:form action="crearListaPeliDis" >
                
                <div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'distribuidor', 'error')} required">
					<label for="distribuidor">
					<g:message code="pelicula.distribuidor.label" default="Distribuidor" />
					<span class="required-indicator">*</span>
					</label>
				<g:select id="distribuidor" name="distribuidor.id" from="${modelodatos.Distribuidor.list()}" optionKey="id" required="" value="${peliculaInstance?.distribuidor?.id}" class="many-to-one"/>
				</div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="search" class="search" value="Listar Películas" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>