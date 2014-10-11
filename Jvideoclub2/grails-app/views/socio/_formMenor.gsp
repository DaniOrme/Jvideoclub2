<%@ page import="modelodatos.Socio" %>





<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="socio.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="15" required="" value="${socioInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'apellidos', 'error')} required">
	<label for="apellidos">
		<g:message code="socio.apellidos.label" default="Apellidos" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidos" required="" value="${socioInstance?.apellidos}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'dni', 'error')} required">
	<label for="dni">
		<g:message code="socio.dni.label" default="Dni" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="dni" maxlength="9" pattern="${socioInstance.constraints.dni.matches}" required="" value="${socioInstance?.dni}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		<g:message code="socio.fechaNacimiento.label" default="Fecha Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaNacimiento" precision="day"  value="${socioInstance?.fechaNacimiento}"  />
</div>


<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'fechaRegistro', 'error')} required">
	<label for="fechaRegistro">
		<g:message code="socio.fechaRegistro.label" default="Fecha Registro" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaRegistro" precision="day"  value="${socioInstance?.fechaRegistro}"  />
</div>



<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="socio.telefono.label" default="Teléfono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" maxlength="9" pattern="${socioInstance.constraints.telefono.matches}" required="" value="${socioInstance?.telefono}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'tutor', 'error')} ">
	<label for="tutor">
		<g:message code="socio.tutor.label" default="Tutor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tutor" name="tutor.id" from="${modelodatos.Socio.list()}" optionKey="id" value="${socioInstance?.tutor?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

