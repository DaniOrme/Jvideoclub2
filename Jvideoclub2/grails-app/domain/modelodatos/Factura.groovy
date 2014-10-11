/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 11/04/2012
NOMBRE MODULO: Factura.groovy
DESCRIPCIÓN: Dominio Base Datos Factura */

package modelodatos

class Factura {
	static reportable = [:]
    static constraints = {
    }
	
	static belongsTo = [socio:Socio]
	float importe
	boolean estaPendiente = false
    Date fechaFactura		
}
