
<%@ page import="modelodatos.Pelicula" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pelicula.label', default: 'Pelicula')}" />
		<title><g:message code="Mostrar Película" args="[entityName]" /></title>
		<script src="http://code.jquery.com/jquery-1.7.1.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			
				 $.ajax({
				      url: "http://www.imdbapi.com/?t=${peliculaInstance?.titulo}",
				      dataType: 'jsonp',
				      success: function(data) {
				    
				        $("#caratula").attr("src","${createLink(controller:'infoPeli',action:'index')}/?title="+data.Poster);
				        
				      },
				      
				    });
			   
		</script>
	</head>
	<body>
		<a href="#show-pelicula" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
			</ul>
		</div>
		<div id="show-pelicula" class="content scaffold-show" role="main">
			<h1><g:message code="Mostrar Película" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div style="float:right; width=320px;height=465px;">
						<img id="caratula" src="" width="70%" height="70%"/>
			</div>
			<div>
			<ol class="property-list pelicula">
			
				<g:if test="${peliculaInstance?.titulo}">
				<li class="fieldcontain">
					<span id="titulo-label" class="property-label"><g:message code="pelicula.titulo.label" default="Titulo" /></span>
					
						<span class="property-value" aria-labelledby="titulo-label"><g:fieldValue bean="${peliculaInstance}" field="titulo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.tipoCategoria}">
				<li class="fieldcontain">
					<span id="tipoCategoria-label" class="property-label"><g:message code="pelicula.tipoCategoria.label" default="Tipo Categoria" /></span>
					
						<span class="property-value" aria-labelledby="tipoCategoria-label"><g:fieldValue bean="${peliculaInstance}" field="tipoCategoria"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.calificacionMoral}">
				<li class="fieldcontain">
					<span id="calificacionMoral-label" class="property-label"><g:message code="pelicula.calificacionMoral.label" default="Calificacion Moral" /></span>
					
						<span class="property-value" aria-labelledby="calificacionMoral-label"><g:fieldValue bean="${peliculaInstance}" field="calificacionMoral"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.tipoGenero}">
				<li class="fieldcontain">
					<span id="tipoGenero-label" class="property-label"><g:message code="pelicula.tipoGenero.label" default="Tipo Genero" /></span>
					
						<span class="property-value" aria-labelledby="tipoGenero-label"><g:fieldValue bean="${peliculaInstance}" field="tipoGenero"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.duracion}">
				<li class="fieldcontain">
					<span id="duracion-label" class="property-label"><g:message code="pelicula.duracion.label" default="Duracion" /></span>
					
						<span class="property-value" aria-labelledby="duracion-label"><g:fieldValue bean="${peliculaInstance}" field="duracion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.director}">
				<li class="fieldcontain">
					<span id="director-label" class="property-label"><g:message code="pelicula.director.label" default="Director" /></span>
					
						<span class="property-value" aria-labelledby="director-label"><g:fieldValue bean="${peliculaInstance}" field="director"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.idioma}">
				<li class="fieldcontain">
					<span id="idioma-label" class="property-label"><g:message code="pelicula.idioma.label" default="Idioma" /></span>
					
						<span class="property-value" aria-labelledby="idioma-label"><g:fieldValue bean="${peliculaInstance}" field="idioma"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.precioBase}">
				<li class="fieldcontain">
					<span id="precioBase-label" class="property-label"><g:message code="pelicula.precioBase.label" default="Precio Base" /></span>
					
						<span class="property-value" aria-labelledby="precioBase-label"><g:formatNumber number="${peliculaInstance.precioBase}" type="currency" currencyCode="EUR" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.actores}">
				<li class="fieldcontain">
					<span id="actores-label" class="property-label"><g:message code="pelicula.actores.label" default="Actores" /></span>
					
						<span class="property-value" aria-labelledby="actores-label"><g:fieldValue bean="${peliculaInstance}" field="actores"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.argumento}">
				<li class="fieldcontain">
					<span id="argumento-label" class="property-label"><g:message code="pelicula.argumento.label" default="Argumento" /></span>
					
						<span class="property-value" aria-labelledby="argumento-label"><g:fieldValue bean="${peliculaInstance}" field="argumento"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.blancoNegro}">
				<li class="fieldcontain">
					<span id="blancoNegro-label" class="property-label"><g:message code="pelicula.blancoNegro.label" default="Blanco Negro" /></span>
					
						<span class="property-value" aria-labelledby="blancoNegro-label"><g:formatBoolean boolean="${peliculaInstance?.blancoNegro}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.color}">
				<li class="fieldcontain">
					<span id="color-label" class="property-label"><g:message code="pelicula.color.label" default="Color" /></span>
					
						<span class="property-value" aria-labelledby="color-label"><g:formatBoolean boolean="${peliculaInstance?.color}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${peliculaInstance?.distribuidor}">
				<li class="fieldcontain">
					<span id="distribuidor-label" class="property-label"><g:message code="pelicula.distribuidor.label" default="Distribuidor" /></span>
					
						<span class="property-value" aria-labelledby="argumento-label"><g:fieldValue bean="${peliculaInstance}" field="distribuidor"/></span>
					
				</li>
				</g:if>

			
			</ol>
			</div>
		</div>
		
	</body>
</html>
