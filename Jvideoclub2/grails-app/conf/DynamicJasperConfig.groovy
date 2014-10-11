import ar.com.fdvs.dj.core.layout.HorizontalBandAlignment
import ar.com.fdvs.dj.domain.AutoText
import ar.com.fdvs.dj.domain.constants.Font
import ar.com.fdvs.dj.domain.constants.Border
import java.awt.Color
import ar.com.fdvs.dj.domain.constants.Transparency
import ar.com.fdvs.dj.domain.constants.HorizontalAlign
import ar.com.fdvs.dj.domain.constants.VerticalAlign
import ar.com.fdvs.dj.domain.constants.Rotation
import ar.com.fdvs.dj.domain.constants.Stretching
import ar.com.fdvs.dj.domain.constants.Page
import java.awt.Color

import modelodatos.*;

dynamicJasper {

	useFullPageWidth = true

	page = Page.Page_A4_Landscape()

	isUsingImagesToAlign = true

	intPattern = '#0'
	floatPattern = '#0.00'
	datePattern = 'dd/MM/yyyy'

	titleStyle {
		font = new Font(18, Font._FONT_GEORGIA, true)
		textColor = Color.black
		border = Border.NO_BORDER
		borderColor = Color.darkGray
		horizontalAlign = HorizontalAlign.CENTER
		verticalAlign = VerticalAlign.MIDDLE
		backgroundColor = Color.white
		transparency = Transparency.OPAQUE
		transparent = false
		blankWhenNull = true
		padding = 15
		pattern = ''
		radius = 1
		rotation = Rotation.NONE
		stretching = Stretching.NO_STRETCH
		stretchWithOverflow = false
	}

	subtitleStyle {
		font = new Font(14, Font._FONT_GEORGIA, false)
		textColor = Color.black
		border = Border.NO_BORDER
		borderColor = Color.darkGray
		horizontalAlign = HorizontalAlign.LEFT
		verticalAlign = VerticalAlign.MIDDLE
		backgroundColor = Color.white
		transparency = Transparency.OPAQUE
		transparent = false
		blankWhenNull = true
		padding = 2
		pattern = ''
		radius = 1
		rotation = Rotation.NONE
		stretching = Stretching.NO_STRETCH
		stretchWithOverflow = false
	}

	headerStyle {
		font = Font.GEORGIA_BIG_BOLD
		textColor = Color.BLACK
		border = Border.PEN_2_POINT
		borderColor = Color.darkGray
		horizontalAlign = HorizontalAlign.CENTER
		verticalAlign = VerticalAlign.MIDDLE
		backgroundColor = new Color(219,238,243)
		transparency = Transparency.OPAQUE
		transparent = false
		blankWhenNull = true
		padding = 2
		pattern = ''
		radius = 1
		rotation = Rotation.NONE
		stretching = Stretching.NO_STRETCH
		stretchWithOverflow = false
	}

	detailStyle {
		font = Font.GEORGIA_MEDIUM
		textColor = Color.black
		borderTop = Border.THIN
		borderBottom = Border.THIN
		borderLeft = Border.THIN
		borderRight = Border.THIN
		borderColor = Color.black
		horizontalAlign = HorizontalAlign.CENTER
		verticalAlign = VerticalAlign.MIDDLE
		backgroundColor = new Color(237,243,237)
		transparency = Transparency.OPAQUE
		//transparent = false
		blankWhenNull = true
		padding = 2
		//pattern = ''
		radius = 1
		rotation = Rotation.NONE
		stretching = Stretching.NO_STRETCH
		stretchWithOverflow = false
	}
	
	soporteByDistribuidor {
		entity = 'soporte'
		title = 'Películas suministradas por distribuidora'
		columns = ['id','pelicula', 'tipoSoporte','pelicula.distribuidor']
		columnTitles = ['id': 'Código soporte', 'pelicula': 'Nombre película', 'tipoSoporte': 'Tipo Soporte', 'pelicula.distribuidor': 'Nombre distribuidora']
		patterns = ['id': '#0']
		fileName = null
		
		dataSource = { session, params -> Soporte.findAll('from Soporte as s where s.pelicula.distribuidor.id = ? order by id', [new Long(params.id)]) }
		}
	
	todasLasPeliculas {
		entity = 'pelicula'
		title = 'Informe de películas disponibles'
		columns = ['id','titulo']
		columnTitles = ['id': 'Código película', 'titulo': 'Nombre película']
		patterns = ['id': '#0']
		fileName = null
		
		dataSource = { session, params -> Pelicula.findAll('from Pelicula as p order by id') }
		}

	todosLosSocios {
		entity = 'socio'
		title = 'Informe de los socios del videoclub'
		columns = ['id','nombre','apellidos','telefono','fechaRegistro']
		columnTitles = ['id': 'Número socio', 'nombre' : 'Nombre', 'apellidos': 'Apellidos', 'telefono': 'Teléfono', 'fechaRegistro': 'Fecha registro socio']
		patterns = ['id': '#0']
		fileName = null
		
		dataSource = { session, params -> Socio.findAll('from Socio as s order by id') }
		}
	
	contratosDeMantenimiento {
		entity = 'distribuidor'
		title = 'Informe de los contratos de mantenimiento'
		columns = ['id','nombre','fechaInicioContrato','fechaFinContrato']
		columnTitles = ['id': 'Código Distribuidora', 'nombre': 'Nombre distribuidora','fechaInicioContrato': 'Fecha inicio contrato','fechaFinContrato': 'Fecha finalización contrato' ]
		patterns = ['id': '#0']
		fileName = null
		
		dataSource = { session, params -> Distribuidor.findAll('from Distribuidor as d order by id') }
		}
	
	alquileresPendientes {
		entity = 'alquiler'
		title = 'Informe de alquileres pendientes'
		columns = ['socio', 'soporte','fechaAlquiler','fechaDevolucion']
		columnTitles = ['socio': 'Nombre socio', 'soporte' : 'Datos película', 'fechaAlquiler': 'Fecha alquiler','fechaDevolucion': 'Fecha prevista entrega' ]
		patterns = ['id': '#0']
		fileName = null
		
		dataSource = { session, params -> Alquiler.findAll('from Alquiler as a where a.fechaEntrega is null order by fechaAlquiler') }
		}
}