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
   
  <script src="resources/js/scriptsCoun.js"></script>
  <script src="resources/js/mylibs/jquery.dataTables.min.js"></script>
  <script src="resources/js/Uiclasses/ComponentTranslator.js"></script>
   <script src="resources/js/Uiclasses/Render.js"></script>
  <script src="resources/js/Uiclasses/ActividadRender.js"></script>
  <script src="resources/js/Uiclasses/InstructorRender.js"></script>
 <script src="resources/js/Uiclasses/IntegranteRender.js"></script>
   <script src="resources/js/Uiclasses/ConceptoRender.js"></script>
  <script src="resources/js/Uiclasses/UnidadRender.js"></script>
  <script src="resources/js/Uiclasses/SideBarController.js"></script>
  <script src="resources/js/Uiclasses/CanvasController.js"></script>
   <script src="resources/js/core/ServerManager.js"></script>
  

  <!-- end CSS-->
 <script type="text/javascript">
	$().ready(function() {

		$('.option').bind("click", function(e) {
			var objectId=$(this).attr("id");
			sideBarController.onOptionSelected(objectId);
			
		});
		
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
		</div> <!--! end of #main-content -->
  </div> <!--! end of #main -->


    <footer id="footer"><div class="container_12">
		<div class="grid_12">
    		<div class="footer-icon align-center"><a class="top" href="#top"></a></div>
		</div>
    </div></footer>
  </div> <!--! end of #container -->

</body>
</html>