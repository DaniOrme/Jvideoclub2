/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 11/04/2012
NOMBRE MODULO: FacturasPendientesService.groovy
DESCRIPCIÓN: Servicio que calcula si el importe de las facturas de un socio es mayor que 18 euros*/

package modelodatos

class FacturasPendientesService {

    def hayFacturasPendientes(Socio socio) {
		def listaFacturas = Factura.findAllBySocioAndEstaPendiente(socio,true)
		def importependientedepago =0;
		listaFacturas.each{factura ->
			importependientedepago += factura.importe;
		}
		
		return importependientedepago>=18; 
    }
}
