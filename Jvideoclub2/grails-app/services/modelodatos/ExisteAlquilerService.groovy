/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 11/04/2012
NOMBRE MODULO: ExisteAlquilerService.groovy
DESCRIPCIÓN: Servicio devuelve la lista de alquileres pendientes de un socio */

package modelodatos

class ExisteAlquilerService {

    def hayAlquilerPendiente(Socio socio) {
		boolean resultado=Alquiler.findAllBySocioAndFechaEntrega(socio,null)
		return resultado;
    }
}
