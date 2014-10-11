/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 19/04/2012
NOMBRE MODULO:InformesController.groovy
DESCRIPCIÓN: Controlador Datos Informes */

package modelodatos

class InformesController {

	/* NOMBRE FUNCIÓN: listaDistribuidor
	DESCRIPCIÓN: Devuelve la lista de distribuidoras disponibles. */
    def listaDistribuidor() { 
		
		[listaDistribuidor:Distribuidor.list()]
	}
	
	
}
