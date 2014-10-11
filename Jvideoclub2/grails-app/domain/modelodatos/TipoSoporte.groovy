/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: TipoSoporte.groovy
DESCRIPCIÓN: Dominio Enumerado atributo TipoSoporte */

package modelodatos

public enum TipoSoporte {

	DVD ("DVD"),
	CINTA ("CINTA")
	
	
	String tipo
	TipoSoporte(String tipo) {
	   this.tipo = tipo
	   
	  }
}
