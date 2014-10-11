<%@ page import="modelodatos.Distribuidor" %>



<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="distribuidor.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="15" required="" value="${distribuidorInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'cif', 'error')} required">
	<label for="cif">
		<g:message code="distribuidor.cif.label" default="Cif" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cif" maxlength="9" pattern="${distribuidorInstance.constraints.cif.matches}" required="" value="${distribuidorInstance?.cif}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'fechaInicioContrato', 'error')} required">
	<label for="fechaInicioContrato">
		<g:message code="distribuidor.fechaInicioContrato.label" default="Fecha Inicio Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaInicioContrato" precision="day"  value="${distribuidorInstance?.fechaInicioContrato}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'fechaFinContrato', 'error')} required">
	<label for="fechaFinContrato">
		<g:message code="distribuidor.fechaFinContrato.label" default="Fecha Fin Contrato" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinContrato" precision="day"  value="${distribuidorInstance?.fechaFinContrato}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'direccion', 'error')} required">
	<label for="direccion">
		<g:message code="distribuidor.direccion.label" default="Direccion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="direccion" required="" value="${distribuidorInstance?.direccion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'poblacion', 'error')} required">
	<label for="poblacion">
		<g:message code="distribuidor.poblacion.label" default="Poblacion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="poblacion" required="" value="${distribuidorInstance?.poblacion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'provincia', 'error')} required">
	<label for="provincia">
		<g:message code="distribuidor.provincia.label" default="Provincia" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="provincia" required="" value="${distribuidorInstance?.provincia}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'distritoPostal', 'error')} required">
	<label for="distritoPostal">
		<g:message code="distribuidor.distritoPostal.label" default="Distrito Postal" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="distritoPostal" maxlength="5" pattern="${distribuidorInstance.constraints.distritoPostal.matches}" required="" value="${distribuidorInstance?.distritoPostal}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'telefono', 'error')} required">
	<label for="telefono">
		<g:message code="distribuidor.telefono.label" default="Telefono" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telefono" maxlength="9" pattern="${distribuidorInstance.constraints.telefono.matches}" required="" value="${distribuidorInstance?.telefono}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'fax', 'error')} ">
	<label for="fax">
		<g:message code="distribuidor.fax.label" default="Fax" />
		
	</label>
	<g:textField name="fax" maxlength="9" pattern="${distribuidorInstance.constraints.fax.matches}" value="${distribuidorInstance?.fax}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'e_mail', 'error')} required">
	<label for="e_mail">
		<g:message code="distribuidor.e_mail.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="e_mail" required="" value="${distribuidorInstance?.e_mail}"/>
</div>



