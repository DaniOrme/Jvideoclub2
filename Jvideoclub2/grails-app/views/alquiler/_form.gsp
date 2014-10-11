<%@ page import="modelodatos.Alquiler" %>

<div class="fieldcontain ${hasErrors(bean: alquilerInstance, field: 'socio', 'error')} required">
	<label for="socio">
		<g:message code="alquiler.socio.label" default="Socio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="socio" name="socio.id" from="${modelodatos.Socio.list()}" optionKey="id" required="" value="${alquilerInstance?.socio?.id}" class="many-to-one"/>
</div>


<div class="fieldcontain ${hasErrors(bean: alquilerInstance, field: 'fechaAlquiler', 'error')} required">
	<label for="fechaAlquiler">
		<g:message code="alquiler.fechaAlquiler.label" default="Fecha Alquiler" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaAlquiler" precision="day"  value="${alquilerInstance?.fechaAlquiler}"  />
</div>





<div class="fieldcontain ${hasErrors(bean: alquilerInstance, field: 'soporte', 'error')} required">
	<label for="soporte">
		<g:message code="alquiler.soporte.label" default="Soporte" />
		<span class="required-indicator">*</span>
	</label>
		<g:select name="soportes" from="${modelodatos.Soporte.findAllByEstaDisponible(true)}" multiple="multiple" optionKey="id" size="5" value="" class="many-to-many"/>
</div>

