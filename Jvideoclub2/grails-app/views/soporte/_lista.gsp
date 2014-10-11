<%@ page import="modelodatos.Pelicula" %>
		<table>
				<thead>
					<tr>
						<g:sortableColumn property="id" title="Código soporte" />
						
						<th><g:message code="soporte.pelicula.label" default="Título Película" /></th>
					
						<g:sortableColumn property="tipoSoporte" title="${message(code: 'soporte.tipoSoporte.label', default: 'Tipo Soporte')}" />
						
						<th><g:message code="soporte.precioAlquiler.label" default="Precio Alquiler" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${soporteInstanceList}" status="i" var="soporteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					
					  <g:if test="${accion == 'baja'}">
					  	<td><g:link action="delete" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"  id="${soporteInstance.id}">${fieldValue(bean: soporteInstance, field: "id")}</g:link></td>
					  </g:if>
					  
					  <g:if test="${accion == 'lista'}">
					  	<td>${fieldValue(bean: soporteInstance, field: "id")}</td>
					  </g:if>
					  
					  <g:if test="${accion == 'mostrar'}">
					  	 <td><g:link action="mostrar" id="${soporteInstance.id}">${fieldValue(bean: soporteInstance, field: "id")}</g:link></td>
					  </g:if>
					  
					 
						<td>${fieldValue(bean: soporteInstance, field: "pelicula")}</td>	
					
						<td>${fieldValue(bean: soporteInstance, field: "tipoSoporte")}</td>
						
						<td><g:formatNumber number="${soporteInstance.precioAlquiler}" type="currency" currencyCode="EUR" /></td>
					
					</tr>
				</g:each>
				</tbody>
		</table>