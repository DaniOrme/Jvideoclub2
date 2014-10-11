<%@ page import="modelodatos.Soporte" %>



<div class="fieldcontain ${hasErrors(bean: soporteInstance, field: 'pelicula', 'error')} required">
	<label for="pelicula">
		<g:message code="soporte.pelicula.label" default="Pelicula" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pelicula" name="pelicula.id" from="${modelodatos.Pelicula.list()}" optionKey="id" required="" value="${soporteInstance?.pelicula?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: soporteInstance, field: 'tipoSoporte', 'error')} required">
	<label for="tipoSoporte">
		<g:message code="soporte.tipoSoporte.label" default="Tipo Soporte" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tipoSoporte" from="${modelodatos.TipoSoporte?.values()}" keys="${modelodatos.TipoSoporte.values()*.name()}" required="" value="${soporteInstance?.tipoSoporte?.name()}"/>
</div>

