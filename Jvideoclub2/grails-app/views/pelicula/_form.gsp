<%@ page import="modelodatos.Pelicula" %>



<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'titulo', 'error')} required">
	<label for="titulo">
		<g:message code="pelicula.titulo.label" default="Titulo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titulo" required="" value="${peliculaInstance?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'tipoCategoria', 'error')} required">
	<label for="tipoCategoria">
		<g:message code="pelicula.tipoCategoria.label" default="Tipo Categoria" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoCategoria" from="${modelodatos.Categoria?.values()}" keys="${modelodatos.Categoria.values()*.name()}" required="" value="${peliculaInstance?.tipoCategoria?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'calificacionMoral', 'error')} ">
	<label for="calificacionMoral">
		<g:message code="pelicula.calificacionMoral.label" default="Calificacion Moral" />
		
	</label>
	<g:textField name="calificacionMoral" maxlength="3" value="${peliculaInstance?.calificacionMoral}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'tipoGenero', 'error')} required">
	<label for="tipoGenero">
		<g:message code="pelicula.tipoGenero.label" default="Tipo Genero" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoGenero" from="${modelodatos.Genero?.values()}" keys="${modelodatos.Genero.values()*.name()}" required="" value="${peliculaInstance?.tipoGenero?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'duracion', 'error')} required">
	<label for="duracion">
		<g:message code="pelicula.duracion.label" default="Duracion" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="duracion" required="" value="${fieldValue(bean: peliculaInstance, field: 'duracion')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'director', 'error')} ">
	<label for="director">
		<g:message code="pelicula.director.label" default="Director" />
		
	</label>
	<g:textField name="director" value="${peliculaInstance?.director}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'idioma', 'error')} required">
	<label for="idioma">
		<g:message code="pelicula.idioma.label" default="Idioma" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="idioma" from="${modelodatos.Idioma?.values()}" keys="${modelodatos.Idioma.values()*.name()}" required="" value="${peliculaInstance?.idioma?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'precioBase', 'error')} required">
	<label for="precioBase">
		<g:message code="pelicula.precioBase.label" default="Precio Base" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="precioBase" required="" value="${fieldValue(bean: peliculaInstance, field: 'precioBase')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'actores', 'error')} ">
	<label for="actores">
		<g:message code="pelicula.actores.label" default="Actores" />
		
	</label>
	<g:textField name="actores" value="${peliculaInstance?.actores}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'argumento', 'error')} ">
	<label for="argumento">
		<g:message code="pelicula.argumento.label" default="Argumento" />
		
	</label>
	<g:textField name="argumento" value="${peliculaInstance?.argumento}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'blancoNegro', 'error')} ">
	<label for="blancoNegro">
		<g:message code="pelicula.blancoNegro.label" default="Blanco Negro" />
		
	</label>
	<g:checkBox name="blancoNegro" value="${peliculaInstance?.blancoNegro}" />
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'color', 'error')} ">
	<label for="color">
		<g:message code="pelicula.color.label" default="Color" />
		
	</label>
	<g:checkBox name="color" value="${peliculaInstance?.color}" />
</div>

<div class="fieldcontain ${hasErrors(bean: peliculaInstance, field: 'distribuidor', 'error')} required">
	<label for="distribuidor">
		<g:message code="pelicula.distribuidor.label" default="Distribuidor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="distribuidor" name="distribuidor.id" from="${modelodatos.Distribuidor.list()}" optionKey="id" required="" value="${peliculaInstance?.distribuidor?.id}" class="many-to-one"/>
</div>
</div>

