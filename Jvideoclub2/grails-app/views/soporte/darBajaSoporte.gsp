<%@ page import="modelodatos.Soporte" %>
<html>
   <head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'soporte.label', default: 'Soporte')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-soporte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
			</ul>
		</div>
		<div id="list-soporte" class="content scaffold-list" role="main">
            <h1><p align="center"><g:message  code="Elija el soporte que desea dar de baja:"   args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            
          
               <g:render template="lista" model="[accion:'baja']" />
           
           
            <div class="pagination">
				<g:paginate total="${soporteInstanceTotal}" />
			</div>
        </div>
    </body>
</html>
