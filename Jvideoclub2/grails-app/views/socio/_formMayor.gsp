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

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'direccion', 'error')} ">
	<label for="direccion">
		<g:message code="socio.direccion.label" default="Direccion" />
		
	</label>
	<g:textField name="direccion" value="${socioInstance?.direccion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'poblacion', 'error')} ">
	<label for="poblacion">
		<g:message code="socio.poblacion.label" default="Poblacion" />
		
	</label>
	<g:textField name="poblacion" value="${socioInstance?.poblacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'provincia', 'error')} ">
	<label for="provincia">
		<g:message code="socio.provincia.label" default="Provincia" />
		
	</label>
	<g:textField name="provincia" value="${socioInstance?.provincia}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'codigoPostal', 'error')} ">
	<label for="codigoPostal">
		<g:message code="socio.codigoPostal.label" default="Codigo Postal" />
		
	</label>
	<g:textField name="codigoPostal" maxlength="5" pattern="${socioInstance.constraints.codigoPostal.matches}" value="${socioInstance?.codigoPostal}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="socio.telefono.label" default="Teléfono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" maxlength="9" pattern="${socioInstance.constraints.telefono.matches}" required="" value="${socioInstance?.telefono}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'profesion', 'error')} ">
	<label for="profesion">
		<g:message code="socio.profesion.label" default="Profesion" />
		
	</label>
	<g:textField name="profesion" value="${socioInstance?.profesion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'codigoCuentaCorriente', 'error')} ">
	<label for="codigoCuentaCorriente">
		<g:message code="socio.codigoCuentaCorriente.label" default="Codigo Cuenta Corriente" />
		
	</label>
	<g:textField name="codigoCuentaCorriente" maxlength="20" pattern="${socioInstance.constraints.codigoCuentaCorriente.matches}" value="${socioInstance?.codigoCuentaCorriente}"/>
</div>

