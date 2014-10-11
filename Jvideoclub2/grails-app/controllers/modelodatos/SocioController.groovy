/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 10/02/2012
NOMBRE MODULO: SocioController.groovy
DESCRIPCIÓN: Controlador Datos Socio */

package modelodatos

import org.springframework.dao.DataIntegrityViolationException

class SocioController {
	
    static allowedMethods = [save: "POST", update: "POST"]

	/* NOMBRE FUNCIÓN: index
	DESCRIPCIÓN: Función implementa la acción mostrada en el índice. */
    def index() {
        redirect(action: "list", params: params)
    }

	/* NOMBRE FUNCIÓN: list
	DESCRIPCIÓN: Función lista socios (básica). */
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
    }

	/* NOMBRE FUNCIÓN: create
	DESCRIPCIÓN: Función crear socios (básica). */
    def create() {
        [socioInstance: new Socio(params)]
    }

	/* NOMBRE FUNCIÓN: save
	DESCRIPCIÓN: Función guarda datos socios (básica). */
    def save() {
        def socioInstance = new Socio(params)
        if (!socioInstance.save(flush: true)) {
            render(view: "create", model: [socioInstance: socioInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
        redirect(action: "show", id: socioInstance.id)
    }

	/* NOMBRE FUNCIÓN: show
	DESCRIPCIÓN: Función mostrar (básica). */
    def show() {
        def socioInstance = Socio.get(params.id)
        if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "list")
            return
        }

        [socioInstance: socioInstance]
    }
	
	/* NOMBRE FUNCIÓN: edit
	DESCRIPCIÓN: Función editar socios (básica). */
    def edit() {
        def socioInstance = Socio.get(params.id)
        if (!socioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "list")
            return
        }

        [socioInstance: socioInstance]
    }

	/* NOMBRE FUNCIÓN: update
	DESCRIPCIÓN: Función actualizar datos socios (básica). */
    def update() {
        def socioInstance = Socio.get(params.id)
        if (!socioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (socioInstance.version > version) {
                socioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'socio.label', default: 'Socio')] as Object[],
                          "Another user has updated this Socio while you were editing")
                render(view: "edit", model: [socioInstance: socioInstance])
                return
            }
        }

        socioInstance.properties = params

        if (!socioInstance.save(flush: true)) {
            render(view: "edit", model: [socioInstance: socioInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
        redirect(action: "show", id: socioInstance.id)
    }

	/* NOMBRE FUNCIÓN: delete
	DESCRIPCIÓN: Función eliminar socios (básica). */
    def delete() {
        def socioInstance = Socio.get(params.id)
        if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "darBajaSocio")
            return
        }

        try {
            socioInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "darBajaSocio")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
            redirect(action: "mostrar", id: params.id)
        }
    }
	
	def calcularSocioMayorService

	/* NOMBRE FUNCIÓN: crearAltaSocio
	DESCRIPCIÓN: Función dar Alta socios, redirige según el socio sea menor o no. */
	def crearAltaSocio () {
		if (params.fechaNacimiento!=null){
			def edadResult=true
			edadResult=calcularSocioMayorService.getmayorEdad(params.fechaNacimiento)
			if (edadResult) {
				redirect (action:"altaSocioMayor")
			}
			else {
				redirect (action:"altaSocioMenor")
			}
		}
	}
	
	/* NOMBRE FUNCIÓN: altaSocioMayor
	DESCRIPCIÓN: Función dar Alta socios mayores de edad. */
	def altaSocioMayor () {
		[socioInstance: new Socio(params)]
	}
	
	/* NOMBRE FUNCIÓN: saveSocioMayor
	DESCRIPCIÓN: Función salvar datos socios mayores de edad. */
	def saveSocioMayor () {
		def socioInstance = new Socio(params)
		if (!socioInstance.save(flush: true)) {
			render(view: "altaSocioMayor", model: [socioInstance: socioInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
		redirect(action: "mostrar", id: socioInstance.id)
	}
	
	/* NOMBRE FUNCIÓN: saveSocioMenor
	DESCRIPCIÓN: Función salvar datos socios menores de edad. */
	def saveSocioMenor () {
		def socioInstance = new Socio(params)
		if (!socioInstance.save(flush: true)) {
			render(view: "altaSocioMenor", model: [socioInstance: socioInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
		redirect(action: "mostrar", id: socioInstance.id)
	}
	
	/* NOMBRE FUNCIÓN: altaSocioMenor
	DESCRIPCIÓN: Función dar Alta socios menores de edad. */
	def altaSocioMenor () {
		[socioInstance: new Socio(params)]
	}
	
	/* NOMBRE FUNCIÓN: listarSocios
	DESCRIPCIÓN: Función que muestra el listado completo de socios. */
	def listarSocios () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
	}
	
	/* NOMBRE FUNCIÓN: darBajaSocio
	DESCRIPCIÓN: Función que muestra el listado de socios para poder eliminarlos. */
	def darBajaSocio () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
	}
	
	/* NOMBRE FUNCIÓN: mostrar
	DESCRIPCIÓN: Función que muestra los datos de un socio concreto. */
	def mostrar () {
		def socioInstance = Socio.get(params.id)
		if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
			redirect(action: "mostrarSocio")
			return
		}
		[socioInstance: socioInstance]
	}
	
	/* NOMBRE FUNCIÓN: mostrarSocio
	DESCRIPCIÓN: Función que muestra el listado de socios para poder mostrar los datos de uno concreto. */
	def mostrarSocio () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
	}
	
	/* NOMBRE FUNCIÓN: actualizarSocio
	DESCRIPCIÓN: Función que actualiza los datos de un socio modificados previamente. */
	def actualizarSocio () {
		def socioInstance = Socio.get(params.id)
		if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
			redirect(action: "modificarSocio")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (socioInstance.version > version) {
				socioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'socio.label', default: 'Socio')] as Object[],
						  "Another user has updated this Socio while you were editing")
				render(view: "modificar", model: [socioInstance: socioInstance])
				return
			}
		}

		socioInstance.properties = params

		if (!socioInstance.save(flush: true)) {
			render(view: "modificar", model: [socioInstance: socioInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'socio.label', default: 'Socio'), socioInstance.id])
		redirect(action: "mostrar", id: socioInstance.id)
	}
	
	/* NOMBRE FUNCIÓN: modificar
	DESCRIPCIÓN: Función que modificados los datos de un socio concreto. */
	def modificar () {
		def socioInstance = Socio.get(params.id)
		if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
			redirect(action: "modificarSocio")
			return
		}

		[socioInstance: socioInstance]
	}
	
	/* NOMBRE FUNCIÓN: modificarSocio
	DESCRIPCIÓN: Función que muestra el listado de socios para poder modificarlos. */
	def modificarSocio () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
	}
	
	/* NOMBRE FUNCIÓN: imprimir
	DESCRIPCIÓN: Función que imprimir el carnet de un socio concreto. */
	def imprimir () {
		def socioInstance = Socio.get(params.id)
		if (!socioInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'socio.label', default: 'Socio'), params.id])
			redirect(action: "imprimirCarnet")
			return
		}
		[socioInstance: socioInstance]
	}
	
	/* NOMBRE FUNCIÓN: imprimirCarnet
	DESCRIPCIÓN: Función que muestra el listado de socios para poder imprimir su carnet. */
	def imprimirCarnet () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[socioInstanceList: Socio.list(params), socioInstanceTotal: Socio.count()]
	}
	
}