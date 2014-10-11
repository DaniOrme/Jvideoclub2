<%@ page import="modelodatos.Factura" %>



<div class="fieldcontain ${hasErrors(bean: facturaInstance, field: 'estaPendiente', 'error')} ">
	<label for="estaPendiente">
		<g:message code="factura.estaPendiente.label" default="Esta Pendiente" />
		
	</label>
	<g:checkBox name="estaPendiente" value="${facturaInstance?.estaPendiente}" />
</div>

<div class="fieldcontain ${hasErrors(bean: facturaInstance, field: 'fechaFactura', 'error')} required">
	<label for="fechaFactura">
		<g:message code="factura.fechaFactura.label" default="Fecha Factura" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFactura" precision="day"  value="${facturaInstance?.fechaFactura}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: facturaInstance, field: 'importe', 'error')} required">
	<label for="importe">
		<g:message code="factura.importe.label" default="Importe" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="importe" required="" value="${fieldValue(bean: facturaInstance, field: 'importe')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: facturaInstance, field: 'socio', 'error')} required">
	<label for="socio">
		<g:message code="factura.socio.label" default="Socio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="socio" name="socio.id" from="${modelodatos.Socio.list()}" optionKey="id" required="" value="${facturaInstance?.socio?.id}" class="many-to-one"/>
</div>

