package jvideoclub2
import modelodatos.*
import static org.junit.Assert.*
import org.junit.*

class IntegrationTest {
	
	@Before
	void setUp() {
		// Setup logic here
		
	}

	@After
	void tearDown() {
		// Tear down logic here
	}

	@Test
	void testPI_BBDD_SOCIO_CrearSocio() {
		Socio Nsocio = new Socio (dni: "17974233Z", nombre: "Hans", apellidos: "Topo",
			fechaRegistro:new Date(), direccion: "C/Gran Vía 25 2º D", poblacion: "Madrid",
			provincia: "Madrid", codigoPostal: "28004", telefono: "915557015", fechaNacimiento: new Date(),
			profesion: "Millonario",codigoCuentaCorriente: "20385892863244600095").save(failOnError: true)
		assert Nsocio.count() == 11
		assert Socio.get(Nsocio.id) != null
	}
	
	void testPI_BBDD_SOCIO_EliminarSocio() {
		Socio Nsocio = new Socio (dni: "17974233Z", nombre: "Hans", apellidos: "Topo",
			fechaRegistro:new Date(), direccion: "C/Gran Vía 25 2º D", poblacion: "Madrid",
			provincia: "Madrid", codigoPostal: "28004", telefono: "915557015", fechaNacimiento: new Date(),
			profesion: "Millonario",codigoCuentaCorriente: "20385892863244600095").save(failOnError: true)
		assert Nsocio.count() == 11
		Socio Nsocio2 = new Socio (dni: "13974233Z", nombre: "Bill", apellidos: "Gates",
			fechaRegistro:new Date(), direccion: "C/Gran Vía 25 2º D", poblacion: "Madrid",
			provincia: "Madrid", codigoPostal: "28004", telefono: "915557015", fechaNacimiento: new Date(),
			profesion: "Millonario",codigoCuentaCorriente: "20385892863244600012").save(failOnError: true)
		assert Nsocio2.count() == 12
		Nsocio.delete()
		assert Nsocio2.count() == 11
		assert Socio.get(Nsocio.id) == null
		assert Socio.get(Nsocio2.id) != null
	}

	void testPI_BBDD_DIST_CrearDistribuidor() {
		def distrib1, distrib2
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		assert Distribuidor.get(distrib1.id) != null
		assert Distribuidor.count() == 6
	}
	
	void testPI_BBDD_DIST_EliminarDistribuidor(){
		def distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		distrib1.delete()
		assert Distribuidor.get(distrib1.id) == null
		assert Distribuidor.count() == 5
	}
	
	void testPI_BBDD_PEL_CrearPelicula() {
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revolutions", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
	}
	
	void testPI_DIST_PEL_CrearPelicula() {
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			 poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			 fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			 e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revolutions", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
	}
	
	void testPI_PEL_SOP_CrearSoporte(){
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			 fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			 e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revol", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
	}
	
	void testPI_BBDD_DIST_EliminarDistribuidorConPeliculaAsociada(){
		def distrib1, pelic1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revolutions", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
		assert Pelicula.get(pelic1.id) != null
		assert Pelicula.count() == 16
		pelic1.delete()
		distrib1.delete()
		assert Distribuidor.get(distrib1.id) == null
		assert Distribuidor.count() == 5
	}
	
	void testPI_BBDD_DIST_EliminarPelicula() {
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			 poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			 fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			 e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revolutions", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
			pelic1.delete()
			assert Pelicula.get(pelic1.id) == null
	}
	
	/*void testPI_BBDD_SOP_EliminarSoporte(){
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			 fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			 e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revol", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
		pelic1.delete()
		assert Pelicula.get(pelic1.id) == null
	}*/
		
	void testPI_PEL_SOP_EliminarSoporte(){
		def pelic1, distrib1
		distrib1 = new Distribuidor (nombre: "WarnerB", cif: "14586220D", direccion: "C/Almagro 5",
			poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28002", telefono: "913432823",
			 fechaInicioContrato: new Date(), fechaFinContrato: new Date(),
			 e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		pelic1 = new Pelicula (titulo: "Matrix Revol", tipoCategoria: Categoria.OFERTA,
			tipoGenero: Genero.CienciaFiccion, calificacionMoral:"+18", idioma: Idioma.Ingles,
			precioBase: 2, distribuidor: distrib1).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
		new Soporte (pelicula: pelic1, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
		pelic1.delete()
		assert Pelicula.get(pelic1.id) == null
	}
}
