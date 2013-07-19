<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <html class="no-js" lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">

  <!-- DNS prefetch -->

  <!-- Use the .htaccess and remove these lines to avoid edge case issues.
       More info: h5bp.com/b/378 -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>Country Template</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Place favicon.ico and apple-touch-icon.png in the root directory: mathiasbynens.be/notes/touch-icons -->

  <!-- CSS: implied media=all -->
  <!-- CSS concatenated and minified via ant build script-->
  <link rel="stylesheet" href="resources/css/style.css"> <!-- Generic style (Boilerplate) -->
  <link rel="stylesheet" href="resources/css/960.fluid.css"> <!-- 960.gs Grid System -->
  <link rel="stylesheet" href="resources/css/main.css"> <!-- Complete Layout and main styles -->
  <link rel="stylesheet" href="resources/css/buttons.css"> <!-- Buttons, optional -->
  <link rel="stylesheet" href="resources/css/lists.css"> <!-- Lists, optional -->
  <link rel="stylesheet" href="resources/css/icons.css"> <!-- Icons, optional -->
  <link rel="stylesheet" href="resources/css/notifications.css"> <!-- Notifications, optional -->
  <link rel="stylesheet" href="resources/css/typography.css"> <!-- Typography -->
  <link rel="stylesheet" href="resources/css/forms.css"> <!-- Forms, optional -->
  <link rel="stylesheet" href="resources/css/tables.css"> <!-- Tables, optional -->
  <link rel="stylesheet" href="resources/css/charts.css"> <!-- Charts, optional -->
  <link rel="stylesheet" href="resources/css/jquery-ui-1.8.15.custom.css"> <!-- jQuery UI, optional -->
  <script src="resources/js/libs/jquery-1.6.2.min.js"></script>
  <script src="resources/js/mylibs/jquery-ui-1.8.15.custom.min.js"></script>
  <script src="resources/js/libs/mootools-core-1.4.5-full-compat.js"></script>
  <script src="resources/js/libs/jquery.visualize.js"></script>

  <script src="resources/js/scriptsCoun.js"></script>
  <script src="resources/js/mylibs/jquery.dataTables.min.js"></script>
  <script src="resources/js/mylibs/jquery.notifications.js"></script>
  <script src="resources/js/Uiclasses/ComponentTranslator.js"></script>
  <script src="resources/js/Uiclasses/Render.js"></script>
  <script src="resources/js/Uiclasses/ActividadRender.js"></script>
  <script src="resources/js/Uiclasses/InstructorRender.js"></script>
  <script src="resources/js/Uiclasses/IntegranteRender.js"></script>
  <script src="resources/js/Uiclasses/AvisoRender.js"></script>  
  <script src="resources/js/Uiclasses/ConceptoRender.js"></script>
  <script src="resources/js/Uiclasses/UnidadRender.js"></script>
  <script src="resources/js/Uiclasses/RecursoRender.js"></script>
  <script src="resources/js/Uiclasses/VehiculoRender.js"></script>
  <script src="resources/js/Uiclasses/MascotaRender.js"></script>
  <script src="resources/js/Uiclasses/TipoAutorizacionRender.js"></script>
  <script src="resources/js/Uiclasses/TipoDocumentoRender.js"></script>
  <script src="resources/js/Uiclasses/TipoEspecieRender.js"></script>
  <script src="resources/js/Uiclasses/TipoInfraccionRender.js"></script>
  <script src="resources/js/Uiclasses/TipoPagoRender.js"></script>
  <script src="resources/js/Uiclasses/TipoRazaRender.js"></script>
  <script src="resources/js/Uiclasses/TipoRecursoRender.js"></script>
  <script src="resources/js/Uiclasses/TipoVacunaRender.js"></script>
  <script src="resources/js/Uiclasses/TipoVehiculoRender.js"></script>
  <script src="resources/js/Uiclasses/MensajeCategoriaRender.js"></script>
  <script src="resources/js/Uiclasses/NoticiaCategoriaRender.js"></script>
  <script src="resources/js/Uiclasses/AvisoCategoriaRender.js"></script>  
  <script src="resources/js/Uiclasses/MensajeRender.js"></script>
  <script src="resources/js/Uiclasses/MensajeReclamoRender.js"></script>  
  <script src="resources/js/Uiclasses/EventoRender.js"></script>
  <script src="resources/js/Uiclasses/NoticiaRender.js"></script>
  <script src="resources/js/Uiclasses/SideBarController.js"></script>
  <script src="resources/js/Uiclasses/CanvasController.js"></script>
  <script src="resources/js/Uiclasses/CalendarController.js"></script>
  <script src="resources/js/core/ServerManager.js"></script>
   
   <link rel='stylesheet' type='text/css' href='resources/js/libs/fullcalendar/fullcalendar.css' />
<script type='text/javascript' src='resources/js/libs/fullcalendar/fullcalendar.js'></script>



  

  <!-- end CSS-->
 <script type="text/javascript">
	$().ready(function() {

		sideBarController.bindMenuEvents(this);
		canvasController.createDashboard();
		
		$('.selectable').live("click", function(){ 
			if ($(this).hasClass('selected')){
				$(this).removeClass('selected');
				//$(this).css('background','none');
			$(this).children(':first-child').remove();

			}else{
				$(this).addClass('selected');
				$(this).append('<img src="resources/img/check.png" alt="Smiley face" height="10" width="12">')
				//$(this).css('background','url(img/check.png) no-repeat center');
			}
		});
		
		

	});
		

	  </script>

</head>

<body id="top">

  <!-- Begin of #container -->
  <div id="container">
  	<!-- Begin of #header -->
    <div id="header-surround"><header id="header">

    	<!-- Place your logo here -->
		<img src="resources/img/logo.png" alt="Grape" class="logo">

		<!-- Divider between info-button and the toolbar-icons -->
		<div class="divider-header divider-vertical"></div>

		<!-- Info-Button -->
		<a href="javascript:void(0);" onclick="$('#info-dialog').dialog({ modal: true });"><span class="btn-info"></span></a>


		<!-- Begin of #user-info -->
		<div id="user-info">
			<p>
				<span class="messages">Hello <a href="javascript:void(0);">Administrator</a> ( <a href="javascript:void(0);">
					<img src="resources/img/icons/packs/fugue/16x16/mail.png" alt="Messages"> 3 new messages</a> )</span>
				<a href="javascript:void(0)" class="toolbox-action button">Settings</a> <a href="javascript:void(0);" class="button red">Logout</a>
			</p>
		</div> <!--! end of #user-info -->

    </header></div> <!--! end of #header -->

    <div class="fix-shadow-bottom-height"></div>

	<!-- Begin of Sidebar -->
    <aside id="sidebar">

    	<!-- Search -->
    	<div id="search-bar">
			<form id="search-form" name="search-form" action="search.php" method="post">
				<input type="text" id="query" name="query" value="" autocomplete="off" placeholder="Search">
			</form>
		</div> <!--! end of #search-bar -->

    	<!-- Begin of Navigation -->
    	<nav id="nav">
	    	<ul class="menu collapsible shadow-bottom">
	    		<li>
	    			<a href="javascript:void(0);" class="option current" id="actividad"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Actividad<span class="badge red">42</span></a>
	    			<a href="javascript:void(0);" class="option current" id="instructor"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Instructor<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="unidad"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Unidades<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="integrante"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Integrante<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="concepto"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Concepto<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="recurso"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Recurso<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="vehiculo"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Vehiculo<span class="badge red"></span></a>					
					<a href="javascript:void(0);" class="option current" id="mascota"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Mascota<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="mensajeReclamo"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Reclamos<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="mensaje"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Mensaje (no anda)<span class="badge red"></span></a>
					<a href="javascript:void(0);" class="option current" id="noticia"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Noticia (no modifica)<span class="badge red"></span></a>					
					<a href="javascript:void(0);" class="option current" id="aviso"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Aviso (no anda)<span class="badge red"></span></a>					
					<a href="javascript:void(0);" class="option current" id="evento"><img src="resources/img/icons/packs/fugue/16x16/user-white.png">Evento (falta modif)<span class="badge red"></span></a>					
					<a href="javascript:void(0);"><img src="src/main/webapp/resources/img/icons/packs/fugue/16x16/clipboard-list.png">Configuracion<span class="badge grey">9</span></a>
	    			<ul class="sub">
	    				<li><a href="javascript:void(0);" class="option current" id="tipoAutorizacion">Tipo de Autorizaciones</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoDocumento">Tipo de Documentos</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoEspecie">Tipo de Especies</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoInfraccion">Tipo de Infracciones</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoPago">Tipo de Pago</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoRaza">Tipo de Razas</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoRecurso">Tipo de Recursos</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoVacuna">Tipo de Vacunas</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoVehiculo">Tipo de Vehiculos</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="tipoAviso">Tipo de Avisos</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="mensajeCategoria">Categorias de Mensajes</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="noticiaCategoria">Categorias de Noticias</a></li>
	    				<li><a href="javascript:void(0);" class="option current" id="avisoCategoria">Categorias de Avisos</a></li>	    				
	    			</ul>
	    		</li>
	    		
	    	</ul>
    	</nav> <!--! end of #nav -->

    </aside> <!--! end of #sidebar -->

    <!-- Begin of #main -->
    <div id="main" role="main">

    	<!-- Begin of titlebar/breadcrumbs -->
			<div id="title-bar">
				<ul id="breadcrumbs">
					<li><a href="dashboard.html" title="Home"><span id="bc-home"></span></a></li>
					<li class="no-hover">Actividades</li>
				</ul>
			</div> <!--! end of #title-bar -->

		<div class="shadow-bottom shadow-titlebar"></div>

		<!-- Begin of #main-content -->
		<div id="main-content">
			<div class="container_12">

			<div class="grid_12">
				<h1>Inicio</h1>

				<div class="alert info"><span class="hide">x</span><strong>Hola Admin! Bienvenido a tu pantalla de inicio de Country ASARA</strong></div>
			</div>

		<div class="grid_8">
				<div class="block-border" id="tab-graph">
					<div class="block-header">
						<h1>Estadisticas</h1>
						<ul class="tabs">
							<li class="active" style=""><a href="#tab-line">Deudores</a></li>
							<li><a href="#tab-area">Actividades</a></li>
							<li><a href="#tab-pie">Reclamos</a></li>
							<li><a href="#tab-bar">Multas</a></li>
						</ul>
					</div>
					<div class="block-content tab-container">
							<table id="graph-data" class="graph">
								<caption>2009 Employee Sales by Department</caption>
								<thead>
									<tr>
										<td></td>
										<th scope="col">Enero</th>
										<th scope="col">Febrero</th>
										<th scope="col">Marzo</th>
										<th scope="col">Abril</th>
										<th scope="col">Mayo</th>
										<th scope="col">Junio</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">Unidad 1</th>
										<td>190</td>
										<td>160</td>
										<td>40</td>
										<td>120</td>
										<td>30</td>
										<td>70</td>
									</tr>
									<tr>
										<th scope="row">Unidad 2</th>
										<td>3</td>
										<td>40</td>
										<td>30</td>
										<td>45</td>
										<td>35</td>
										<td>49</td>
									</tr>
									<tr>
										<th scope="row">Unidad 3</th>
										<td>10</td>
										<td>180</td>
										<td>10</td>
										<td>85</td>
										<td>25</td>
										<td>79</td>
									</tr>
									<tr>
										<th scope="row">Unidad 4</th>
										<td>40</td>
										<td>80</td>
										<td>90</td>
										<td>25</td>
										<td>15</td>
										<td>119</td>
									</tr>
								</tbody>
							</table>
						<div id="tab-line" class="tab-content"></div>
						<div id="tab-area" class="tab-content"></div>
						<div id="tab-pie" class="tab-content"></div>
						<div id="tab-bar" class="tab-content"></div>

					</div>
					
				</div>
				<div class="grid_1aa2">
				<div class="block-border">
					<div class="block-header">
						<h1>Resumen</h1><span></span>
					</div>
					<div class="block-content">
						<div class="alert info no-margin top">Tenes 12 novedades sin leer.</div>
						<ul class="overview-list">
							<li><a href="javascript:void(0);"><span>8262</span> Total de Servicios</a></li>
							<li><a href="javascript:void(0);"><span>521</span> Torneos en marcha</a></li>
							<li><a href="javascript:void(0);"><span>257</span> Anuncios de propietarios</a></li>
							<li><a href="javascript:void(0);"><span>42</span> Reclamos</a></li>
						</ul>
					</div>
				</div>
			</div>
			</div>

			<div class="grid_4">
				<div class="block-border">
					<div class="block-header">
						<h1>Reclamo alambrado por UsuarioX</h1><span></span>
					</div>
					<form id="validate-form" class="block-content form" action="dashboard.html" method="post">
						<p>
							<label for="title">Mantenimiento del alambrado</label>
						</p>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
						</p>

						<div class="clear"></div>

						<!-- Buttons with actionbar  -->
						<div class="block-actions">
							<ul class="actions-left">
								<li><a class="button red" id="reset-validate-form" href="javascript:void(0);">No gracias</a></li>
							</ul>
							<ul class="actions-right">
								<li><input type="submit" class="button" value="Atender Reclamo"></li>
							</ul>
						</div> <!--! end of #block-actions -->
					</form>
				</div>
			</div>

			<div class="grid_4">
				<div class="block-border">
					<div class="block-header">
						<h1>Accesos Directos</h1><span></span>
					</div>
					<div class="block-content">
						<ul class="block-list with-icon">
							<li class="i-16-calendar">Pileta</li>
							<li class="i-16-application">House</li>
							<li class="i-16-balloon">Pavimento</li>
							<li class="i-16-chart">Alambrado</li>
							<li class="i-16-drive">Camaras</li>
						</ul>
					</div>
					<div class="block-content dark-bg">
						<p>Click en cada uno para ver los detalles</p>
					</div>
				</div>
			</div>

			

			<div class="clear height-fix"></div>

		</div></div> <!--! end of #main-content -->
  </div> <!--! end of #main -->


    <footer id="footer"><div class="container_12">
		<div class="grid_12">
    		<div class="footer-icon align-center"><a class="top" href="#top"></a></div>
		</div>
    </div></footer>
  </div> <!--! end of #container -->

</body>
</html>