/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: Soporte.groovy
DESCRIPCIÓN: Dominio Base Datos Soporte */


package modelodatos

class Soporte {
	static reportable = [:]
    static constraints = {
    }
	
	
	static belongsTo = [pelicula:Pelicula]
	Pelicula pelicula;
	boolean estaDisponible=true;
	
	TipoSoporte tipoSoporte  //CD o DVD
	
	static transients = ['precioAlquiler']  //Porque no queremos almacenar el precio en BD ya que es un valor calculado
	
	float getPrecioAlquiler (){
		float resultado = pelicula.precioBase;
		
		if (pelicula.tipoCategoria == Categoria.NOVEDAD){
			resultado += pelicula.precioBase*0.3;
		}
		if (pelicula.tipoCategoria == Categoria.NORMAL){
			resultado += pelicula.precioBase*0.2;
		}
		
		if (tipoSoporte == TipoSoporte.DVD){
			resultado += pelicula.precioBase*0.3;
		}
		if (tipoSoporte == TipoSoporte.CINTA){
			resultado += pelicula.precioBase*0.2;
		}
		
		return resultado;
	}
	
	String toString(){
		return "${pelicula}-${tipoSoporte}-${id}";
	}
	
}