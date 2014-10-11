/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 11/04/2012
NOMBRE MODULO: AlquilerController.groovy
DESCRIPCIÓN: Controlador Datos Alquiler */

package modelodatos

import org.springframework.dao.DataIntegrityViolationException
import modelodatos.Factura

class AlquilerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	/* NOMBRE FUNCIÓN: index
	DESCRIPCIÓN: Función implementa la acción mostrada en el índice. */
    def index() {
        redirect(action: "list", params: params)
    }

	/* NOMBRE FUNCIÓN: list
	DESCRIPCIÓN: Función lista alquileres (básica). */
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [alquilerInstanceList: Alquiler.list(params), alquilerInstanceTotal: Alquiler.count()]
    }

	/* NOMBRE FUNCIÓN: create
	DESCRIPCIÓN: Función crear socios (básica). */
    def create() {
        [alquilerInstance: new Alquiler(params)]
    }

def facturasPendientesService
def existeAlquilerService
def buscaSocioService

	/* NOMBRE FUNCIÓN: save
	DESCRIPCIÓN: Función guarda datos alquileres. */
     def save() {
		
		float importeTotal=0;
		def facturaPendiente=false
		def alquilerPendiente=false
		def socio = Socio.get(params.socio.id)
		facturaPendiente=facturasPendientesService.hayFacturasPendientes(socio)
		alquilerPendiente=existeAlquilerService.hayAlquilerPendiente(socio)
		if (facturaPendiente){
			flash.message = "La operacion no se puede realizar porque hay facturas pendientes."
			redirect (controller:"factura",action:"misfacturas",id:socio.id)
		}else if (alquilerPendiente){
			flash.message = "La operacion no se puede realizar porque hay alquileres pendientes."
			redirect (action:"create")
		}else{
		
			params.soportes.each{ idSoporte ->
				def soporte = Soporte.get(idSoporte);
				soporte.estaDisponible=false;
				soporte.save(flush:true);
				importeTotal+= soporte.precioAlquiler;
				def alquilerInstance = new Alquiler(socio:Socio.get(params.socio.id),soporte:soporte,fechaAlquiler:params.fechaAlquiler)
				socio.addToAlquileres(alquilerInstance).save(flush:true);
				if (!alquilerInstance.save(flush: true)) {
					render(view: "create", model: [alquilerInstance: alquilerInstance])
					return
				}
				
			
			}
			def facturaInstance = new Factura (socio:Socio.get(params.socio.id),importe:importeTotal, estaPendiente: true, fechaFactura:params.fechaAlquiler).save(flush:true);
	        redirect(controller: "factura", action: "show", id: facturaInstance.id)
		}
    }

	 /* NOMBRE FUNCIÓN: show
	 DESCRIPCIÓN: Función mostrar alquileres (básica). */
    def show() {
        def alquilerInstance = Alquiler.get(params.id)
        if (!alquilerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "list")
            return
        }

        [alquilerInstance: alquilerInstance]
    }

	/* NOMBRE FUNCIÓN: edit
	DESCRIPCIÓN: Función editar alquileres (básica). */
    def edit() {
        def alquilerInstance = Alquiler.get(params.id)
        if (!alquilerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "list")
            return
        }

        [alquilerInstance: alquilerInstance]
    }

	/* NOMBRE FUNCIÓN: update
	DESCRIPCIÓN: Función actualizar datos alquileres (básica). */
    def update() {
        def alquilerInstance = Alquiler.get(params.id)
        if (!alquilerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (alquilerInstance.version > version) {
                alquilerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'alquiler.label', default: 'Alquiler')] as Object[],
                          "Another user has updated this Alquiler while you were editing")
                render(view: "edit", model: [alquilerInstance: alquilerInstance])
                return
            }
        }

        alquilerInstance.properties = params

        if (!alquilerInstance.save(flush: true)) {
            render(view: "edit", model: [alquilerInstance: alquilerInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), alquilerInstance.id])
        redirect(action: "show", id: alquilerInstance.id)
    }

	/* NOMBRE FUNCIÓN: delete
	DESCRIPCIÓN: Función eliminar alquileres (básica). */
    def delete() {
        def alquilerInstance = Alquiler.get(params.id)
        if (!alquilerInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "list")
            return
        }

        try {
            alquilerInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'alquiler.label', default: 'Alquiler'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	
	/* NOMBRE FUNCIÓN: devolucion
	DESCRIPCIÓN: Función listar socios con alquileres pendientes. */
	def devolucion(){
		
		[listaSociosAlquileresPendientes:buscaSocioService.sociosConAlquileresPendientes()]
	}
	
	
	/* NOMBRE FUNCIÓN: devolverPelicula
	DESCRIPCIÓN: Función listar alquileres pendientes de un socio. */
	def devolverPelicula(){
		def s = Socio.get(params.id)
		def listaAlquileres = Alquiler.findAllBySocioAndFechaEntrega(s,null);
		[alquilerInstanceList: listaAlquileres, alquilerInstanceTotal: listaAlquileres.size(),socioInstance:s]
	}
	
	/* NOMBRE FUNCIÓN: procesarDevolucion
	DESCRIPCIÓN: Función realiza la devolucion de alquiler de una película. */
	def procesarDevolucion(){
		def alquiler = Alquiler.get(params.id);
		alquiler.fechaEntrega = new Date();
		def soporte = alquiler.soporte;
		soporte.estaDisponible=true;
		
		soporte.save(flush:true);
		
		alquiler.save(flush:true);
		flash.message = "La película ha sido devuelta"
		redirect (action:"devolverPelicula",params:['id':alquiler.socio.id]);
	}
	
	
	/* NOMBRE FUNCIÓN: devolverTodas
	DESCRIPCIÓN: Función realiza la devolucion de todas las peliculas alquiladas por un socio. */
	def devolverTodas(){
		def socio = Socio.get(params.id)
		socio.alquileres.each{alquiler ->
			alquiler.fechaEntrega = new Date();
			def soporte = alquiler.soporte;
			soporte.estaDisponible=true;			
			soporte.save(flush:true);			
			alquiler.save(flush:true);
		}
		
		socio.save(flush:true);
		flash.message = "Todas las películas han sido devueltas"
		redirect (action:"devolucion");
	}
}
