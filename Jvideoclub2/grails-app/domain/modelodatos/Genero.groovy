/* AUTOR: Resp. Soporte, Resp. Desarrollo
FECHA: 17/02/2012
NOMBRE MODULO: Genero.groovy
DESCRIPCIÓN: Dominio Enumerado atributo Género */

package modelodatos

public enum Genero {

	Accion("Acción"),
	Aventura("Aventura"),
	Animacion("Animación"),
	Biografica("Biográfica"),
	Comedia("Comedia"),
	Crime("Crimen"),
	Documental("Documental"),
	Drama("Drama"),
	Familiar("Familiar"),
	Fantastica("Fantástica"),
	CineNegro("Cine Negro"),
	Historica("Histórica"),
	Terror("Terror"),
	Musica("M�sica"),
	Musical("Musical"),
	Misterio("Misterio"),
	Noticias("Noticias"),
	RealityTV("RealityTV"),
	Romantica("Romántica"),
	CienciaFiccion("Ciencia-Ficción"),
	Deportes("Deportes"),
	TalkShow("TalkShow"),
	Thriller("Thriller"),
	Belica("Bélica"),
	Western("Western")

	String tipo
	Genero(String tipo) {
		this.tipo = tipo
	}
}