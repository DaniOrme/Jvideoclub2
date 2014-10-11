/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: Pelicula Controller.groovy
DESCRIPCIÓN: Controlador Datos Película */

package modelodatos

import org.springframework.dao.DataIntegrityViolationException

class PeliculaController {

	static allowedMethods = [save: "POST", update: "POST"]

	
	/* NOMBRE FUNCIÓN: index
	DESCRIPCIÓN: Función implementa la acción mostrada en el índice. */
	def index() {
		redirect(action: "list", params: params)
	}

	/* NOMBRE FUNCIÓN: list
	DESCRIPCIÓN: Función lista películas (básica). */
	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[peliculaInstanceList: Pelicula.list(params), peliculaInstanceTotal: Pelicula.count()]
	}

	/* NOMBRE FUNCIÓN: create
	DESCRIPCIÓN: Función crear películas (básica). */
	def create() {
		[peliculaInstance: new Pelicula(params)]
	}

	/* NOMBRE FUNCIÓN: save
	DESCRIPCIÓN: Función guarda datos películas (básica). */
	def save() {
		def peliculaInstance = new Pelicula(params)
		if (!peliculaInstance.save(flush: true)) {
			render(view: "altaPelicula", model: [peliculaInstance: peliculaInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), peliculaInstance.id])
		redirect(action: "mostrar", id: peliculaInstance.id)
	}

	/* NOMBRE FUNCIÓN: show
	DESCRIPCIÓN: Función mostrar (básica). */
	def show() {
		def peliculaInstance = Pelicula.get(params.id)
		if (!peliculaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "list")
			return
		}

		[peliculaInstance: peliculaInstance]
	}

	/* NOMBRE FUNCIÓN: edit
	DESCRIPCIÓN: Función editar películas (básica). */
	def edit() {
		def peliculaInstance = Pelicula.get(params.id)
		if (!peliculaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "modificarPelicula")
			return
		}

		[peliculaInstance: peliculaInstance]
	}

	/* NOMBRE FUNCIÓN: update
	DESCRIPCIÓN: Función actualizar datos películas (básica). */
	def update() {
		def peliculaInstance = Pelicula.get(params.id)
		if (!peliculaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "modificarPelicula")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (peliculaInstance.version > version) {
				peliculaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'pelicula.label', default: 'Pelicula')] as Object[],
						  "Another user has updated this Pelicula while you were editing")
				render(view: "edit", model: [peliculaInstance: peliculaInstance])
				return
			}
		}

		peliculaInstance.properties = params

		if (!peliculaInstance.save(flush: true)) {
			render(view: "edit", model: [peliculaInstance: peliculaInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), peliculaInstance.id])
		redirect(action: "mostrar", id: peliculaInstance.id)
	}

	/* NOMBRE FUNCIÓN: delete
	DESCRIPCIÓN: Función eliminar películas (básica). */
	def delete() {
		def peliculaInstance = Pelicula.get(params.id)
		if (!peliculaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "darBajaPelicula")
			return
		}

		try {
			peliculaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "darBajaPelicula")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "mostrar", id: params.id)
		}
	}
	
	def filtraPeliService

	/* NOMBRE FUNCIÓN: altaPelicula
	DESCRIPCIÓN: Función dar Alta películas, recibe datos y crea. */
	def altaPelicula() {
		[peliculaInstance: new Pelicula(params)]
	}
	
	/* NOMBRE FUNCIÓN: darBajaPelicula
	DESCRIPCIÓN: Función que muestra el listado de películas para poder eliminarlos. */
	def darBajaPelicula() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[peliculaInstanceList: Pelicula.list(params), peliculaInstanceTotal: Pelicula.count()]
	}
	
	/* NOMBRE FUNCIÓN: listarPelicula
	DESCRIPCIÓN: Función que muestra el listado completo de películas. */
	def listarPelicula() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[peliculaInstanceList: Pelicula.list(params), peliculaInstanceTotal: Pelicula.count()]
	}
	
	/* NOMBRE FUNCIÓN: mostrarPelicula
	DESCRIPCIÓN: Función que muestra el listado de películas para poder mostrar los datos de uno concreto. */
	def mostrarPelicula() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[peliculaInstanceList: Pelicula.list(params), peliculaInstanceTotal: Pelicula.count()]
	}
	
	/* NOMBRE FUNCIÓN: mostrar
	DESCRIPCIÓN: Función que muestra los datos de un película concreto. */
	def mostrar() {
		def peliculaInstance = Pelicula.get(params.id)
		if (!peliculaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pelicula.label', default: 'Pelicula'), params.id])
			redirect(action: "mostrarPelicula")
			return
		}

		[peliculaInstance: peliculaInstance]
	}
	
	/* NOMBRE FUNCIÓN: modificarPelicula
	DESCRIPCIÓN: Función que muestra el listado de películas para poder modificarlos. */
	def modificarPelicula () {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[peliculaInstanceList: Pelicula.list(params), peliculaInstanceTotal: Pelicula.count()]
	}
	
	/* NOMBRE FUNCIÓN: crearListaPeliDis
	DESCRIPCIÓN: Función que muestra el listado de películas suministradas por una distribuidora concreta. */
	def crearListaPeliDis () {
		println params
		if (params.distribuidor!=null){
		def distribuidorpelis = filtraPeliService.filtraPeliDis(params.distribuidor.id)
		render(view: "listarPelicula", model: [peliculaInstanceList: distribuidorpelis, peliculaInstanceTotal: distribuidorpelis.size()])
		
		}
	}
}
