/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: Pelicula.groovy
DESCRIPCIÓN: Dominio Base Datos Película */

package modelodatos

class Pelicula {
	static reportable = [
		:
		]
	static hasMany = [soportes: Soporte]
	static belongsTo = [distribuidor:Distribuidor]
	
	String titulo
	Categoria tipoCategoria
	String calificacionMoral ="+"
	Genero tipoGenero
	boolean color
	boolean blancoNegro
	int duracion
	String director
	Idioma idioma
	int precioBase = 2
	String actores
	String argumento
	

	static constraints = {
		titulo unique:true,blank:false
		tipoCategoria blank:false
		calificacionMoral size:3..3, nullable: true
		tipoGenero blank:false
		duracion size:2..3, nullable: true
		director nullable: true
		idioma blank:false
		precioBase size:1,blank:false
		actores nullable: true
		argumento nullable: true
		
	}
	
		
	String toString(){
		return "${titulo}" 
	}
}
