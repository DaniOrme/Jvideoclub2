import modelodatos.*;
import security.*;
class BootStrap {

    def init = { servletContext ->
		def distribuidor1
		def distribuidor2
		def distribuidor3
		def distribuidor4
		def distribuidor5
		def pelicula1
		def pelicula2
		def pelicula3
		def pelicula4
		def pelicula5
		def pelicula6
		def pelicula7
		def pelicula8
		def pelicula9
		def pelicula10
		def pelicula11
		def pelicula12
		def pelicula13
		def pelicula14
		def pelicula15
		
		if(!Socio.count()){
			new Socio (dni: "53974233Z", nombre: "Angel", apellidos: "García Martínez",fechaRegistro:new Date(), direccion: "C/Almagro 25 4º I", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28010", telefono: "913426015", fechaNacimiento: ('Mon Jan 14 07:12:32 EST 1985'), profesion: "Banquero",codigoCuentaCorriente: "20385892863244600095").save(failOnError: true)
			new Socio (dni: "02037505A", nombre: "Tomás", apellidos: "Aguado Molina",fechaRegistro:new Date(), direccion: "C/Velázquez 7 1º D", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28001", telefono: "912750899", fechaNacimiento: ('Sat May 29 07:12:32 EST 1976'), profesion: "Dependiente",codigoCuentaCorriente: "20425097263255690023").save(failOnError: true)
			new Socio (dni: "X5235834D", nombre: "Isabelle", apellidos: "Poulard Lemoine",fechaRegistro:new Date(), direccion: "C/Antonio López 101 5º D", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28026", telefono: "917852288", fechaNacimiento: ('Mon Jan 15 07:12:32 EST 1968'), profesion: "Profesora",codigoCuentaCorriente: "30751094081255693500").save(failOnError: true)
			new Socio (dni: "Y3570620H", nombre: "Gustav", apellidos: "Jürgen Maier",fechaRegistro:new Date(), direccion: "C/Bravo Murillo 100 3º", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28020", telefono: "917852288", fechaNacimiento: ('Fri Oct 4 07:12:32 EST 1975'), profesion: "Fontanero",codigoCuentaCorriente: "48002784552377000998").save(failOnError: true)
			new Socio (dni: "50348714B", nombre: "Teresa", apellidos: "Matas Sánchez",fechaRegistro:new Date(), direccion: "Paseo de Yeserías 15 3º B", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28005", telefono: "914730133", fechaNacimiento: ('Fri Mar 11 07:12:32 EST 1983'), profesion: "Farmaceútica",codigoCuentaCorriente: "84149320016222550298").save(failOnError: true)
			new Socio (dni: "04147083Y", nombre: "Natalia", apellidos: "Calderón Carrasco",fechaRegistro:new Date(), direccion: "Avenida de Valladolid 56-57 Portal A 6ºA", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28008", telefono: "915429303", fechaNacimiento: ('Tue Aug 28 07:12:32 EST 1962'), profesion: "Ingeniera Industrial",codigoCuentaCorriente: "36050512244351086270").save(failOnError: true)
			new Socio (dni: "50583209D", nombre: "Francisco", apellidos: "Olmos Sanz",fechaRegistro:new Date(), direccion: "C/Antonio Cumella 57 1º B", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28030", telefono: "913711855", fechaNacimiento: ('Fri Apr 6 07:12:32 EST 1979'), profesion: "Consultor",codigoCuentaCorriente: "92667126762877007151").save(failOnError: true)
			new Socio (dni: "34950839M", nombre: "Miguel", apellidos: "Sanz Visera",fechaRegistro:new Date(), direccion: "C/Aniceto Marinas 2 3º C", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28008", telefono: "915417413", fechaNacimiento: ('Sat Oct 20 07:12:32 EST 1990'), profesion: "Administrativo",codigoCuentaCorriente: "55001360052034822810").save(failOnError: true)
			new Socio (dni: "27520844P", nombre: "Carlota", apellidos: "González Retana",fechaRegistro:new Date(), direccion: "C/Charaima 3 4ºD", poblacion: "Majadahonda", provincia: "Madrid", codigoPostal: "28220", telefono: "914600858", fechaNacimiento: ('Thu Nov 26 07:12:32 EST 1987'), profesion: "Dependienta",codigoCuentaCorriente:  "97884206509373404808").save(failOnError: true)
			new Socio (dni: "38253905L", nombre: "Manuel", apellidos: "Carrasco Pérez",fechaRegistro:new Date(), direccion: "C/Benito Gutierrez 16 8º C", poblacion: "Madrid", provincia: "Madrid", codigoPostal: "28008", telefono: "915380046", fechaNacimiento: ('Thu Sept 11 07:12:32 EST 1980'), profesion: "Empresario",codigoCuentaCorriente: "65093798804373978206").save(failOnError: true)
			
		}
		
		if(!Distribuidor.count()){
			distribuidor1 = new Distribuidor (nombre: "FFactory", cif: "30586220D", direccion: "C/Sainz de Baranda 15", poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28009", telefono: "913432823", fechaInicioContrato: ('Mon Nov 14 00:00:00 EST 2011'), fechaFinContrato: ('Wed Nov 14 00:00:00 EST 2012'), e_mail: "ffactory@fantasticfactory.com").save(failOnError: true)
			distribuidor2 = new Distribuidor (nombre: "Filmax", cif: "43586255G", direccion: "C/Hilarión Eslava 62", poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28008", telefono: "917652863",  fechaInicioContrato: ('Fri May 20 00:00:00 EST 2011'), fechaFinContrato: ('Sun May 20 00:00:00 EST 2012'), e_mail: "filmax@gmail.com").save(failOnError: true)
			distribuidor3 = new Distribuidor (nombre: "Gemini Films", cif: "05446425Y", direccion: "C/Mozart 2", poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28008", telefono: "915731449",  fechaInicioContrato: ('Thu Dec 22 00:00:00 EST 2011'), fechaFinContrato: ('Fri Dec 22 00:00:00 EST 2012'), e_mail: "gfilms@gemini.com").save(failOnError: true)
			distribuidor4 = new Distribuidor (nombre: "Universal", cif: "42893209T", direccion: "C/Acacias 30", poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28005", telefono: "917615503",  fechaInicioContrato: ('Thu Feb 10 00:00:00 EST 2011'), fechaFinContrato: ('Fri Feb 10 00:00:00 EST 2012'), e_mail: "universal@universalstudios.com").save(failOnError: true)
			distribuidor5 = new Distribuidor (nombre: "Warner Bros", cif: "20153649B", direccion: "C/Narváez 14", poblacion: "Madrid", provincia: "Madrid", distritoPostal: "28009", telefono: "916530874",  fechaInicioContrato: ('Mon Oct 24 00:00:00 EST 2011'), fechaFinContrato: ('Wed Oct 24 00:00:00 EST 2012'), e_mail: "warner@warnerbrothers.com").save(failOnError: true)
		}
		
		if(!Pelicula.count()){
			pelicula1 = new Pelicula (titulo: "Matrix", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+15", tipoGenero: Genero.CienciaFiccion, duracion: 136, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor1).save(failOnError: true)
			pelicula2 = new Pelicula (titulo: "Los descendientes", tipoCategoria: Categoria.NOVEDAD, calificacionMoral:"+15", tipoGenero: Genero.Drama, duracion: 115, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor2).save(failOnError: true)
			pelicula3 = new Pelicula (titulo: "Avatar", tipoCategoria: Categoria.NORMAL, calificacionMoral:"+13", tipoGenero: Genero.CienciaFiccion, duracion: 162, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor2).save(failOnError: true)
			pelicula4 = new Pelicula (titulo: "Lo que el viento se llevo", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+10", tipoGenero: Genero.Drama, duracion: 238, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor3).save(failOnError: true)
			pelicula5 = new Pelicula (titulo: "La vida es bella", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+13", tipoGenero: Genero.Comedia, duracion: 116, idioma: Idioma.Italiano, precioBase: 2 , distribuidor: distribuidor3).save(failOnError: true)
			pelicula6 = new Pelicula (titulo: "Ben - Hur", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+10", tipoGenero: Genero.Aventura, duracion: 212, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor3).save(failOnError: true)
			pelicula7 = new Pelicula (titulo: "La piel que habito", tipoCategoria: Categoria.NOVEDAD, calificacionMoral:"+13", tipoGenero: Genero.Thriller, duracion: 117, idioma: Idioma.Espagnol, precioBase: 2 , distribuidor: distribuidor1).save(failOnError: true)
			pelicula8 = new Pelicula (titulo: "Con derecho a roce", tipoCategoria: Categoria.NOVEDAD, calificacionMoral:"+13", tipoGenero: Genero.Comedia, duracion: 112, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor5).save(failOnError: true)
			pelicula9 = new Pelicula (titulo: "Origen", tipoCategoria: Categoria.NORMAL, calificacionMoral:"+13", tipoGenero: Genero.CienciaFiccion, duracion: 118, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor5).save(failOnError: true)
			pelicula10 = new Pelicula (titulo: "Batman Begins", tipoCategoria: Categoria.NORMAL, calificacionMoral:"+13", tipoGenero: Genero.Accion, duracion: 140, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor4).save(failOnError: true)
			pelicula11 = new Pelicula (titulo: "Transporter", tipoCategoria: Categoria.NORMAL, calificacionMoral:"+13", tipoGenero: Genero.Accion, duracion: 92, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor4).save(failOnError: true)
			pelicula12 = new Pelicula (titulo: "La boda de mi mejor amigo", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+13", tipoGenero: Genero.Romantica, duracion: 105, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor3).save(failOnError: true)
			pelicula13 = new Pelicula (titulo: "Toy Story", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+13", tipoGenero: Genero.Animacion, duracion: 77, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor4).save(failOnError: true)
			pelicula14 = new Pelicula (titulo: "Ratatouille", tipoCategoria: Categoria.NORMAL, calificacionMoral:"+13", tipoGenero: Genero.Animacion, duracion: 111, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor2).save(failOnError: true)
			pelicula15 = new Pelicula (titulo: "Star Wars: Episodio IV", tipoCategoria: Categoria.OFERTA, calificacionMoral:"+13", tipoGenero: Genero.CienciaFiccion, duracion: 121, idioma: Idioma.Ingles, precioBase: 2 , distribuidor: distribuidor1).save(failOnError: true)
		}
		
		if(!Soporte.count()){
			new Soporte (pelicula: pelicula1, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula1, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula2, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula2, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula2, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula2, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula3, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula3, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula4, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula4, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula5, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula5, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula6, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula6, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula7, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula7, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula8, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula8, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula9, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula9, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula10, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula10, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula11, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula11, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula12, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula12, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula13, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula13, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula14, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula14, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			new Soporte (pelicula: pelicula15, tipoSoporte: TipoSoporte.DVD).save(failOnError: true)
			new Soporte (pelicula: pelicula15, tipoSoporte: TipoSoporte.CINTA).save(failOnError: true)
			
		}
		
		if (!Role.count()){
			def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true) 
			def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
			
			def testUser = new User(username: 'encargado', enabled: true, password: 'encargado') 
			testUser.save(flush: true)
			
			UserRole.create testUser, adminRole, true
			
			assert User.count() == 1 
			assert Role.count() == 2 
			assert UserRole.count() == 1
		}
    }
    def destroy = {
    }
}
