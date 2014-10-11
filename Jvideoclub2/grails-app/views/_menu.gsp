
<link rel="stylesheet" href="${resource(dir: 'css', file: 'menu_style.css')}" type="text/css">
<sec:ifLoggedIn>	
<div class="menu">
		<ul>
			<li><a href="${createLink(controller:".", view:"index")}" id="current">Home</a></li>
			<li><a href="${createLink() }" >Socio</a>
				<ul>
					<li><a href="${createLink(controller:"socio", action:"crearAltaSocio") }">Alta</a></li>
					<li><a href="${createLink(controller:"socio", action:"darBajaSocio") }">Baja</a></li>
					<li><a href="${createLink(controller:"socio", action:"modificarSocio") }">Modificar</a></li>
					<li><a href="${createLink(controller:"socio", action:"listarSocios") }">Listar</a></li>
					<li><a href="${createLink(controller:"socio", action:"mostrarSocio") }">Ficha</a></li>
					<li><a href="${createLink(controller:"socio", action:"imprimirCarnet") }">Carnet</a></li>
			   </ul>
		  </li>
		  <li><a href="#" >Distribuidora</a>
				<ul>
					<li><a href="${createLink(controller:"distribuidor", action:"crearAltaDistribuidor") }">Alta</a></li>
					<li><a href="${createLink(controller:"distribuidor", action:"darBajaDistribuidor") }">Baja</a></li>
					<li><a href="${createLink(controller:"distribuidor", action:"modificarDistribuidor") }">Modificar</a></li>
					<li><a href="${createLink(controller:"distribuidor", action:"listarDistribuidor") }">Listar</a></li>
					<li><a href="${createLink(controller:"distribuidor", action:"mostrarDistribuidor") }">Ficha</a></li>
					<li><a href="${createLink(controller:"pelicula", action:"crearListaPeliDis") }">Películas</a></li>
			   </ul>
		  </li>
			<li><a href="#" >Película</a>
				<ul>
					<li><a href="${createLink(controller:"pelicula", action:"altaPelicula") }">Alta</a></li>
					<li><a href="${createLink(controller:"pelicula", action:"darBajaPelicula") }">Baja</a></li>
					<li><a href="${createLink(controller:"pelicula", action:"modificarPelicula") }">Modificar</a></li>
					<li><a href="${createLink(controller:"pelicula", action:"listarPelicula") }">Listar</a></li>
					<li><a href="${createLink(controller:"pelicula", action:"mostrarPelicula") }">Ficha</a></li>					
			   </ul>
		  </li>
		  <li><a href="#" >Soporte</a>
				<ul>
					<li><a href="${createLink(controller:"soporte", action:"darAltaSoporte") }">Alta</a></li>
					<li><a href="${createLink(controller:"soporte", action:"darBajaSoporte") }">Baja</a></li>					
					<li><a href="${createLink(controller:"soporte", action:"listarSoporte") }">Listar</a></li>
					<li><a href="${createLink(controller:"soporte", action:"mostrarSoporte") }">Ficha</a></li>					
			   </ul>
		  </li>
		  <li><a href="#" >Alquiler</a>
				<ul>
					<li><a href="${createLink(controller:"alquiler", action:"create") }">Aquilar película</a></li>
			        <li><a href="${createLink(controller:"alquiler", action:"devolucion") }">Devolver película</a></li>	
					<li><a href="${createLink(controller:"factura", action:"facturaspendientes") }">Pagar facturas</a></li>					
			   </ul>
		  </li>
		  
		  <li><a href="#" >Informes</a>
				<ul>
				<li><a href="${createLink(controller:"informes", action:"listaDistribuidor") }">Peliculas de distribuidora</a></li>
				<li><a href="${createLink(controller:"djReport", params:[report:'contratosDeMantenimiento']) }">Contratos de mantenimiento</a></li>
				<li><a href="${createLink(controller:"djReport", params:[report:'alquileresPendientes']) }">Alquileres pendientes</a></li>	
				<li><a href="${createLink(controller:"djReport", params:[report:'todasLasPeliculas']) }">Películas disponibles</a></li>
				<li><a href="${createLink(controller:"djReport", params:[report:'todosLosSocios']) }">Socios afiliados</a></li>

													
			   </ul>
		  </li>
			<li><a href="${createLink(controller:"logout")}">Salir</a></li>
		</ul>
	</div>
</sec:ifLoggedIn>