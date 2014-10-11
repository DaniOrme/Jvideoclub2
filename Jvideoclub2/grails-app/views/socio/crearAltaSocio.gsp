<%@ page import="modelodatos.Socio" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
        <title><g:message code="Crear Alta Socio" args="[entityName]" /></title>
    </head>
    <body>
    
        <div class="nav">
        </div>
        <div class="body">
            <h1><g:message  code="Crear alta socio"/></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${socioInstance}">
            <div class="errors">
                <g:renderErrors bean="${socioInstance}" as="crearAltaSocio" />
            </div>
            </g:hasErrors>
            <g:form action="crearAltaSocio" >
                <div class="dialog">
                    <table>
                        <tbody>
                              <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fechaNacimiento"><g:message code="socio.fechaNacimiento.label" default="Fecha Nacimiento" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: socioInstance, field: 'fechaNacimiento', 'errors')}">
                                    <g:datePicker name="fechaNacimiento" precision="day" value="${socioInstance?.fechaNacimiento}"  />
                                </td>
                            </tr>                
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="search" class="search" value="Crear Socio" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>