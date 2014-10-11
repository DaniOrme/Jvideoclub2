/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: SoporteController.groovy
DESCRIPCIÓN: Controlador Datos Soporte */

package modelodatos

import org.springframework.dao.DataIntegrityViolationException

class SoporteController {

	static allowedMethods = [save: "POST", update: "POST"]

	/* NOMBRE FUNCIÓN: index
	DESCRIPCIÓN: Función implementa la acción mostrada en el índice. */
	def index() {
		redirect(action: "list", params: params)
	}

	/* NOMBRE FUNCIÓN: list
	DESCRIPCIÓN: Función lista soportes (básica). */
	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[soporteInstanceList: Soporte.list(params), soporteInstanceTotal: Soporte.count()]
	}

	/* NOMBRE FUNCIÓN: create
	DESCRIPCIÓN: Función crear soportes (básica). */
	def create() {
		[soporteInstance: new Soporte(params)]
	}

	/* NOMBRE FUNCIÓN: save
	DESCRIPCIÓN: Función guarda datos soportes (básica). */
	def save() {
		def soporteInstance = new Soporte(params)
		if (!soporteInstance.save(flush: true)) {
			render(view: "darAltaSoporte", model: [soporteInstance: soporteInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'soporte.label', default: 'Soporte'), soporteInstance.id])
		redirect(action: "darAltaSoporte", id: soporteInstance.id)
	}

	/* NOMBRE FUNCIÓN: show
	DESCRIPCIÓN: Función mostrar (básica). */
	def show() {
		def soporteInstance = Soporte.get(params.id)
		if (!soporteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "list")
			return
		}

		[soporteInstance: soporteInstance]
	}

	/* NOMBRE FUNCIÓN: edit
	DESCRIPCIÓN: Función editar soportes (básica). */
	def edit() {
		def soporteInstance = Soporte.get(params.id)
		if (!soporteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "list")
			return
		}

		[soporteInstance: soporteInstance]
	}

	/* NOMBRE FUNCIÓN: update
	DESCRIPCIÓN: Función actualizar datos soportes (básica). */
	def update() {
		def soporteInstance = Soporte.get(params.id)
		if (!soporteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (soporteInstance.version > version) {
				soporteInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'soporte.label', default: 'Soporte')] as Object[],
						  "Another user has updated this Soporte while you were editing")
				render(view: "edit", model: [soporteInstance: soporteInstance])
				return
			}
		}

		soporteInstance.properties = params

		if (!soporteInstance.save(flush: true)) {
			render(view: "edit", model: [soporteInstance: soporteInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'soporte.label', default: 'Soporte'), soporteInstance.id])
		redirect(action: "mostrar", id: soporteInstance.id)
	}

	/* NOMBRE FUNCIÓN: delete
	DESCRIPCIÓN: Función eliminar soportes (básica). */
	def delete() {
		def soporteInstance = Soporte.get(params.id)
		if (!soporteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "darBajaSoporte")
			return
		}

		try {
			soporteInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "darBajaSoporte")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "darBajaSoporte", id: params.id)
		}
	}
	
	/* NOMBRE FUNCIÓN: darAltaSoporte
	DESCRIPCIÓN: Función dar Alta soportes, recibe datos y crea. */
	def darAltaSoporte() {
		[soporteInstance: new Soporte(params)]
	}
	
	/* NOMBRE FUNCIÓN: darBajaSoporte
	DESCRIPCIÓN: Función que muestra el listado de soportes para poder eliminarlos. */
	def darBajaSoporte() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[soporteInstanceList: Soporte.list(params), soporteInstanceTotal: Soporte.count()]
	}

	/* NOMBRE FUNCIÓN: listarSoporte
	DESCRIPCIÓN: Función que muestra el listado completo de soportes. */
	def listarSoporte() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[soporteInstanceList: Soporte.list(params), soporteInstanceTotal: Soporte.count()]
	}

	/* NOMBRE FUNCIÓN: mostrarSoporte
	DESCRIPCIÓN: Función que muestra el listado de soportes para poder mostrar los datos de uno concreto. */
	def mostrarSoporte() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[soporteInstanceList: Soporte.list(params), soporteInstanceTotal: Soporte.count()]
	}

	/* NOMBRE FUNCIÓN: mostrar
	DESCRIPCIÓN: Función que muestra los datos de un soporte concreto. */
	def mostrar() {
		def soporteInstance = Soporte.get(params.id)
		if (!soporteInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'soporte.label', default: 'Soporte'), params.id])
			redirect(action: "list")
			return
		}

		[soporteInstance: soporteInstance]
	}
}