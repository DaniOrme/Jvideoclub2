/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: Distribuidor.groovy
DESCRIPCIÓN: Dominio Base Datos Distribuidora */

package modelodatos

import java.util.Date;

class Distribuidor {
	
	static hasMany = [pelicula: Pelicula]
	String nombre
	String cif
	String direccion
	String poblacion
	String provincia
	String distritoPostal
	String telefono
	String fax
	Date fechaInicioContrato
	Date fechaFinContrato
	String e_mail
	
	static reportable = [:]
    static constraints = {
		nombre size:5..15,unique:true,blank:false
		cif  size:9..9,unique:true,blank:false,matches: "[0-9]{8}[A-Z]"
		direccion blank:false
		poblacion blank:false
		provincia blank:false
		distritoPostal size:5..5,blank:false,matches: "[0-9]{5}"
		telefono size:9..9,blank:false,matches: "[0-9]{9}"
		fax size:9..9,nullable: true,matches: "[0-9]{9}"
		fechaInicioContrato blank:false
		fechaFinContrato blank:false
		e_mail email:true, blank:false
    }

	String toString(){
		return "${nombre}"
	}
	
}