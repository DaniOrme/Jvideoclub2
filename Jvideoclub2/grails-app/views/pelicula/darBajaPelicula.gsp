<%@ page import="modelodatos.Pelicula" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="Baja Película" />
        <title><g:message code="Baja Película" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
        </div>
        <div class="body">
            <h1><p align="center"><g:message  code="Elija la película que desea dar de baja:"   args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            
          
               <g:render template="lista" model="[accion:'baja']" />
           
           
            <div class="pagination">
				<g:paginate total="${peliculaInstanceTotal}" />
			</div>
        </div>
    </body>
</html>
