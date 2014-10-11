package modelodatos

class BuscaSocioService {

   static transactional = true

    def buscaIdPorDni(String dni) {
			Socio socioResult= Socio.findByDni(dni)
			return socioResult?.id;
    }
	
	def sociosConAlquileresPendientes (){
		
		def listaAlquileres = Alquiler.findAllByFechaEntregaIsNull()
		def results=[]
		listaAlquileres.each {alquiler ->
			results.add(alquiler.socio);
		}
		
		
		return results.unique();
	}
	
	
	def sociosConFacturasPendientes (){
		
		def listaFacturas = Factura.findAllByEstaPendiente(true)
		def results=[]
		listaFacturas.each {factura ->
			results.add(factura.socio);
		}
		
		
		return results.unique();
	}
}
