<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb">
<head>

<title>Home</title>





<!-- META FOR IOS & HANDHELD -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="HandheldFriendly" content="true">
<meta name="apple-touch-fullscreen" content="YES">
<!-- //META FOR IOS & HANDHELD -->
<!-- TEMPLATE STYLESHEETS -->

<link rel="stylesheet" href="../resources/css/propietario/modal.css" type="text/css">
<link rel="stylesheet" href="../resources/css/propietario/k2.css" type="text/css">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/core.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/navigation.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/joomla.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/modules.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/template.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/k2.css" media="all">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/print.css" media="print">
  <link rel="stylesheet" href="../resources/css/notifications.css"> <!-- Notifications, optional -->

<!-- //TEMPLATE STYLESHEETS -->
<!-- MEDIA QUERIES -->
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-mobile.css" media="only screen and (max-width:719px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-mobile-portrait.css" media="only screen and (max-width:479px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-tablet.css" media="only screen and (min-width:720px) and (max-width: 985px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-normal.css" media="only screen and (min-width:986px) and (max-width: 1235px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-wide.css" media="only screen and (min-width:1236px) and (max-width: 1585px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-wide-extra.css" media="only screen and (min-width:1586px) and (max-width: 1890px)">
<link rel="stylesheet" type="text/css" href="../resources/css/propietario/layout-hd.css" media="only screen and (min-width:1891px)">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../resources/js/mylibs/jquery.masonry.min.js"></script>
<script type="text/javascript" src="../resources/js/Uiclasses/Propietario/wall.js"></script>

<!-- //MEDIA QUERIES -->
<!-- CUSTOM THEMES -->
<!-- //CUSTOM THEMES -->
<!-- //NUESTROS JS -->
  <script src="../resources/js/libs/mootools-core-1.4.5-full-compat.js"></script>
  <script src="../resources/js/mylibs/jquery.notifications.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/Render.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/RenderTranslator.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/TemplateManager.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/ActividadReservaRender.js"></script>
  
  <script src="../resources/js/Uiclasses/Propietario/DashBoardRender.js"></script>
   <script src="../resources/js/Uiclasses/Propietario/RecursoReservaRender.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/ReclamoRender.js"></script>
  <script src="../resources/js/Uiclasses/Propietario/EventoRender.js"></script>
   
  
  
<script src="../resources/js/Uiclasses/Propietario/ComponentTranslator.js"></script>
<script src="../resources/js/Uiclasses/Propietario/CanvasController.js"></script>
 <script src="../resources/js/Uiclasses/CalendarController.js"></script>

<script src="../resources/js/Uiclasses/Propietario/SideBarController.js"></script>
<script src="../resources/js/core/TestServerManager.js"></script>
<script src="../resources/js/libs/jquery.tmpl.js"></script>

<link rel='stylesheet' type='text/css' href='../resources/js/libs/fullcalendar/fullcalendar.css' />
<script type='text/javascript' src='../resources/js/libs/fullcalendar/fullcalendar.js'></script>
<link rel="stylesheet" href="../resources/css/propietario/ui.css" >

  





<style type="text/css">

</style>

<script type="text/javascript">

	jQuery(document).ready(function($) {
		jQuery("#sidebar").load('../dashboard/sideBar',function(){
			sideBarController.bindMenuEvents();
			canvasController.show("dashboard");
		});	
		
	});
</script>



</head>


<!-- //TOOLBAR -->
<body id="bd"
	class="bd-home gridview hoverable has-sidebar basegrid-m display-fullview"
	style="min-height: 656px;">
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- HEADER -->
		<div id="header" class="wrap">
			


				</div>
			</div>
		</div>
		<!-- // HEADER -->

		<!-- CONTAINER -->
		<div id="container" class="wrap">
			<div class="main container-main clearfix">

				<div id="mainbody" class="clearfix">

					<div id="ja-message">

						<div id="system-message-container"></div>
					</div>

					<!-- MAIN CONTENT -->
					<div id="content">
						<div class="inner content-inner clearfix">
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;">
								<div class="corner-stamp" style="width: 227px;">
									
								</div>
								
								
							</div>
						</div>
						<!-- // MAIN CONTENT -->

					</div>

					<!-- SIDE BAR -->
					
					<!-- // SIDE BAR -->

				</div>
				<div id="sidebar" class="has-toggle" style="height: 468px;">
					
					</div>
			</div>
			<!-- // CONTAINER -->

		</div>
		<!-- // WRAPPER -->
		<!-- POPUP View -->
		<div id="popup-view">
			<div id="popup-content">
				<div class="popup-head">
					<a id="popup-close" href="javascript:;" class="btn-close">Close</a>
				</div>
			</div>
		</div>




		<div id="sbox-overlay" aria-hidden="true"
			style="z-index: 65555; opacity: 0;" tabindex="-1"></div>
		<div id="sbox-window" role="dialog" aria-hidden="true"
			style="z-index: 65557;" class="shadow">
			<div id="sbox-content" style="opacity: 0;"></div>
			<a id="sbox-btn-close" href="#" role="button"
				aria-controls="sbox-window"></a>
		</div>
		<div id="sbox-overlay" aria-hidden="true"
			style="z-index: 65555; opacity: 0;" tabindex="-1"></div>
		<div id="sbox-window" role="dialog" aria-hidden="true"
			style="z-index: 65557;" class="shadow">
			<div id="sbox-content" style="opacity: 0;"></div>
			<a id="sbox-btn-close" href="#" role="button"
				aria-controls="sbox-window"></a>
		</div>
		<div id="sbox-overlay" aria-hidden="true"
			style="z-index: 65555; opacity: 0;" tabindex="-1"></div>
		<div id="sbox-window" role="dialog" aria-hidden="true"
			style="z-index: 65557;" class="shadow">
			<div id="sbox-content" style="opacity: 0;"></div>
			<a id="sbox-btn-close" href="#" role="button"
				aria-controls="sbox-window"></a>
		</div>
	</div>
</body>
</html>