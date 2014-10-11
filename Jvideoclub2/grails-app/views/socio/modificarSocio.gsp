<%@ page import="modelodatos.Socio" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
        <title><g:message code="Modificar Datos Socio" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">

        </div>
        <div class="body">
            <h1><p align="center"><g:message  code="Elija el socio que desea modificar:"   args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="modificarSocio">
                <table>
                    <thead>
                        <tr>
                        
					    <g:sortableColumn property="id" title="${message(code: 'Número de Socio', default: 'Número de Socio')}" />
					
						<g:sortableColumn property="dni" title="${message(code: 'socio.dni.label', default: 'Dni')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'socio.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellidos" title="${message(code: 'socio.apellidos.label', default: 'Apellidos')}" />
					
						<g:sortableColumn property="fechaRegistro" title="${message(code: 'socio.fechaRegistro.label', default: 'Fecha Registro')}" />
					
						<g:sortableColumn property="telefono" title="${message(code: 'socio.telefono.label', default: 'Teléfono')}" />
						
						<g:sortableColumn property="tutor" title="${message(code: 'socio.tutor.label', default: 'Tutor')}" />
						
                        </tr>
                    </thead>
                    <tbody>
				<g:each in="${socioInstanceList}" status="i" var="socioInstance">

					    <td>${fieldValue(bean: socioInstance, field: "id")}</td>

                        <td><g:link action="modificar" id="${socioInstance.id}">${fieldValue(bean: socioInstance, field: "dni")}</g:link></td>
					
						<td>${fieldValue(bean: socioInstance, field: "nombre")}</td>
					
						<td>${fieldValue(bean: socioInstance, field: "apellidos")}</td>
					
						<td><g:formatDate date="${socioInstance.fechaRegistro}" format="dd-MM-yyyy" /></td>
					
						<td>${fieldValue(bean: socioInstance, field: "telefono")}</td>
						
						<td>${fieldValue(bean: socioInstance, field: "tutor")}</td>
					
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <g:paginate total="${socioInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
