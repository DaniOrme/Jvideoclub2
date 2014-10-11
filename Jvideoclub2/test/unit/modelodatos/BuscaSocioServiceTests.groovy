package modelodatos



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BuscaSocioService)
class BuscaSocioServiceTests {

	def buscaSocioService
	
    void testBuscaDNI() {
       

		def user = buscaSocioService.buscaIdPorDni("12345678");
		
		assert user==null;
		new Socio (dni: "03563238H", nombre: "Mickey", apellidos: "Mouse",fechaRegistro:new Date(), direccion: "DisneyLand", poblacion: "Paris", provincia: "Paris", codigoPostal: "28004", telefono: "915792202", fechaNacimiento: new Date(), profesion: "Dibujo Animado",codigoCuentaCorriente: "20383552863244600022").save(failOnError: true)
		user = buscaSocioService.buscaIdPorDni("03563238H");
		
		assert user!=null
    }
}
