<%@ page import="modelodatos.Pelicula" %>
		<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="id" title="Código de película" />
					
						<g:sortableColumn property="titulo" title="${message(code: 'pelicula.titulo.label', default: 'Titulo')}" />
					
						<g:sortableColumn property="tipoCategoria" title="Categoría" />							
					
						<g:sortableColumn property="tipoGenero" title="Género" />
					
						<g:sortableColumn property="idioma" title="Idioma" />
					
						<g:sortableColumn property="precioBase" title="Precio Base" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${peliculaInstanceList}" status="i" var="peliculaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					  <g:if test="${accion == 'baja'}">
					  	<td><g:link action="delete" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"  id="${peliculaInstance.id}">${fieldValue(bean: peliculaInstance, field: "id")}</g:link></td>
					  </g:if>
					  
					  <g:if test="${accion == 'lista'}">
					  		<td>${fieldValue(bean: peliculaInstance, field: "id")}</td>
					  </g:if>
					  
					  <g:if test="${accion == 'mostrar'}">
					  	 <td><g:link action="mostrar" id="${peliculaInstance.id}">${fieldValue(bean: peliculaInstance, field: "id")}</g:link></td>
					  </g:if>
					  
					  <g:if test="${accion == 'modificar'}">
					  	 <td><g:link action="edit" id="${peliculaInstance.id}">${fieldValue(bean: peliculaInstance, field: "id")}</g:link></td>
					  </g:if>
					  
						
						
						<td>${fieldValue(bean: peliculaInstance, field: "titulo")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "tipoCategoria")}</td>								
					
						<td>${fieldValue(bean: peliculaInstance, field: "tipoGenero")}</td>
					
						<td>${fieldValue(bean: peliculaInstance, field: "idioma")}</td>
					
						<td><g:formatNumber number="${peliculaInstance.precioBase}" type="currency" currencyCode="EUR" /></td>
					
					</tr>
				</g:each>
				</tbody>
		</table>