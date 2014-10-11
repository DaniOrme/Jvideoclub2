


import modelodatos.Distribuidor;
import modelodatos.Pelicula;
import modelodatos.Socio;

class EstadisticasTagLib {

	def countsocio = { attrs, body ->
		out << Socio.count();
	}

	def countpelicula = { attrs, body ->
		out << Pelicula.count();
	}

	def countdistribuidor = { attrs, body ->
		out << Distribuidor.count();
	}
}
