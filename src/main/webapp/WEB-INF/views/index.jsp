<!doctype html>
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  
  <!-- DNS prefetch -->
  <link rel=dns-prefetch href="//fonts.googleapis.com">

  <!-- Use the .htaccess and remove these lines to avoid edge case issues.
       More info: h5bp.com/b/378 -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>Login :: Grape - Professional &amp; Flexible Admin Template</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Mobile viewport optimized: j.mp/bplateviewport -->
  <meta name="viewport" content="width=device-width,initial-scale=1">

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
  <!-- end CSS-->
  
  <!-- Fonts -->
  <link href="//fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet" type="text/css">
 
</head>

<body class="special-page">

  <!-- Begin of #container -->
  <div id="container">
  	
  	<!-- Begin of LoginBox-section -->
    <section id="login-box">
    	
    	<div class="block-border">
    		<div class="block-header">
    			<h1>Login</h1>
    		</div>
    		<form id="login-form" class="block-content form" name="LoginForm" method="post">
    			<p class="inline-small-label">
					<label for="username">Usuario</label>
					<input type="text" name="userName" value="" class="required">
				</p>
				<p class="inline-small-label">
					<label for="password">Password</label>
					<input type="password" name="password" value="" class="required">
				</p>
    			<p>
					<label><input type="checkbox" name="keep_logged" /> Manteneme logueado.</label>
				</p>
				
				<div class="clear"></div>
				
				<!-- Begin of #block-actions -->
    			<div class="block-actions">
					<ul class="actions-left">
						<li><a class="button" name="recover_password" href="javascript:void(0);">Recuperar Password</a></li>
						<li class="divider-vertical"></li>
						<li><a class="button red" id="reset-login" href="javascript:void(0);">Cancel</a></li>
					</ul>
					<ul class="actions-right">
						<li><input type="submit" class="button" value="Login"></li>
					</ul>
				</div> <!--! end of #block-actions -->
    		</form>
    		
    		
    	</div>
    </section> <!--! end of #login-box -->
  </div> <!--! end of #container -->

  
</body>
</html>
