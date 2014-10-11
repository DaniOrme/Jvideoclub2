/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: DistribuidorController.groovy
DESCRIPCIÓN: Controlador Datos Distribuidora */

package modelodatos

import org.springframework.dao.DataIntegrityViolationException

class DistribuidorController {

    static allowedMethods = [save: "POST", update: "POST"]

	/* NOMBRE FUNCIÓN: index
	DESCRIPCIÓN: Función implementa la acción mostrada en el índice. */
    def index() {
        redirect(action: "list", params: params)
    }

	/* NOMBRE FUNCIÓN: list
	DESCRIPCIÓN: Función lista distribuidoras (básica). */
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [distribuidorInstanceList: Distribuidor.list(params), distribuidorInstanceTotal: Distribuidor.count()]
    }

	/* NOMBRE FUNCIÓN: create
	DESCRIPCIÓN: Función crear distribuidoras (básica). */
    def create() {
        [distribuidorInstance: new Distribuidor(params)]
    }

	/* NOMBRE FUNCIÓN: save
	DESCRIPCIÓN: Función guarda datos distribuidoras (básica). */
    def save() {
        def distribuidorInstance = new Distribuidor(params)
        if (!distribuidorInstance.save(flush: true)) {
            render(view: "crearAltaDistribuidor", model: [distribuidorInstance: distribuidorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), distribuidorInstance.id])
        redirect(action: "show", id: distribuidorInstance.id)
    }

	/* NOMBRE FUNCIÓN: show
	DESCRIPCIÓN: Función mostrar (básica). */
    def show() {
        def distribuidorInstance = Distribuidor.get(params.id)
        if (!distribuidorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "list")
            return
        }

        [distribuidorInstance: distribuidorInstance]
    }

	/* NOMBRE FUNCIÓN: edit
	DESCRIPCIÓN: Función editar distribuidoras (básica). */
    def edit() {
        def distribuidorInstance = Distribuidor.get(params.id)
        if (!distribuidorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "list")
            return
        }

        [distribuidorInstance: distribuidorInstance]
    }

	/* NOMBRE FUNCIÓN: update
	DESCRIPCIÓN: Función actualizar datos distribuidoras (básica). */
    def update() {
        def distribuidorInstance = Distribuidor.get(params.id)
        if (!distribuidorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "modificarDistribuidor")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (distribuidorInstance.version > version) {
                distribuidorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'distribuidor.label', default: 'Distribuidor')] as Object[],
                          "Another user has updated this Distribuidor while you were editing")
                render(view: "edit", model: [distribuidorInstance: distribuidorInstance])
                return
            }
        }

        distribuidorInstance.properties = params

        if (!distribuidorInstance.save(flush: true)) {
            render(view: "edit", model: [distribuidorInstance: distribuidorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), distribuidorInstance.id])
        redirect(action: "show", id: distribuidorInstance.id)
    }

	/* NOMBRE FUNCIÓN: delete
	DESCRIPCIÓN: Función eliminar distribuidoras (básica). */
    def delete() {
        def distribuidorInstance = Distribuidor.get(params.id)
        if (!distribuidorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "darBajaDistribuidor")
            return
        }

        try {
            distribuidorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "darBajaDistribuidor")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }

	/* NOMBRE FUNCIÓN: crearAltaDistribuidor
	DESCRIPCIÓN: Función dar Alta distribuidoras, recibe datos y crea. */
	def crearAltaDistribuidor () {
	 [distribuidorInstance: new Distribuidor(params)]
	}
	
	/* NOMBRE FUNCIÓN: saveDistribuidora
	DESCRIPCIÓN: Función salvar datos distribuidoras. */
	def saveDistribuidora () {
		def distribuidorInstance = new Distribuidor(params)
		if (!distribuidorInstance.save(flush: true)) {
			render(view: "crearAltaDistribuidor", model: [distribuidorInstance: distribuidorInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'distribuidor.label', default: 'Distribuidor'), distribuidorInstance.id])
		redirect(action: "show", id: distribuidorInstance.id)
	}
	
	/* NOMBRE FUNCIÓN: darBajaDistribuidor
	DESCRIPCIÓN: Función que muestra el listado de distribuidoras para poder eliminarlos. */
	def darBajaDistribuidor () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[distribuidorInstanceList: Distribuidor.list(params), distribuidorInstanceTotal: Distribuidor.count()]
	}
	
	/* NOMBRE FUNCIÓN: listarDistribuidor
	DESCRIPCIÓN: Función que muestra el listado completo de distribuidoras. */
	def listarDistribuidor () {
		redirect (action: "list")
	}
	
	/* NOMBRE FUNCIÓN: mostrarDistribuidor
	DESCRIPCIÓN: Función que muestra el listado de distribuidoras para poder mostrar los datos de uno concreto. */
	def mostrarDistribuidor () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[distribuidorInstanceList: Distribuidor.list(params), distribuidorInstanceTotal: Distribuidor.count()]
	}
	
	/* NOMBRE FUNCIÓN: modificarDistribuidor
	DESCRIPCIÓN: Función que muestra el listado de distribuidoras para poder modificarlos. */
	def modificarDistribuidor () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[distribuidorInstanceList: Distribuidor.list(params), distribuidorInstanceTotal: Distribuidor.count()]
	}
}
