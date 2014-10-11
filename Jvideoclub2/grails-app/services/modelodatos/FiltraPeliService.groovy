/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: FiltraPeliService.groovy
DESCRIPCIÓN: Servicio Película que devuelve la lista de películas de una distribuidora determinada */

package modelodatos

class FiltraPeliService {

	static transactional = true
	
    def filtraPeliDis(String id) {
		Distribuidor distribResult= Distribuidor.findById(id)
		return distribResult?.pelicula;

    }
}
