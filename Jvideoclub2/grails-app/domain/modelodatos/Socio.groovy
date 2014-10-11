/* AUTOR: Líder equipo, Resp. Desarrollo
FECHA: 10/02/2012
NOMBRE MODULO: Socio.groovy
DESCRIPCIÓN: Dominio Base Datos Socio */

package modelodatos

import java.util.Date;

class Socio {

	String dni
	String nombre
	String apellidos
	Date fechaRegistro
	String direccion
	String poblacion
	String provincia
	String codigoPostal
	String telefono
	Date fechaNacimiento
	String profesion
	String codigoCuentaCorriente
    Socio tutor	
	
	static hasMany = [alquileres:Alquiler]
	static reportable = [:]
    static constraints = {
		dni size:9..9,unique:true,blank:false,matches: "[0-9|X-Z]{1}[0-9]{7}[A-Z]"
		nombre  size:3..15,blank:false
		apellidos blank:false
		fechaRegistro blank:false
		direccion nullable: true
		poblacion nullable: true
		provincia nullable: true
		codigoPostal size:5..5,nullable: true,matches: "[0-9]{5}"
		telefono size:9..9,blank:false,matches: "[0-9]{9}"
		fechaNacimiento blank:false
		profesion nullable: true
		codigoCuentaCorriente size:20..20,nullable: true,matches: "[0-9]{20}"
		tutor nullable: true
    }
	
	String toString(){
		return "${nombre} ${apellidos}"
	}
	
		
}
