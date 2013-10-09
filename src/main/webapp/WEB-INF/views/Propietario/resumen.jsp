<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<%-- <form:form commandName="EVENTO" class="block-content form">

<fieldset>
		<legend>Evento</legend>

		
</fieldset>

<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Reset</a></li>
		</ul>
		<ul class="actions-right">
			<c:if test="${EVENTO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('evento');"></li>									
								</c:if>
			<c:if test="${EVENTO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateEvento(${EVENTO.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form> --%>
<div id="evento_nuevo" class="formulario">
					<div id="ja-message">
						<div id="system-message-container"></div>
					</div>
					<!-- MAIN CONTENT -->
			<div id="content">
					<div class="inner content-inner clearfix">
						<div class="item-page item-page uncategorised">

	<h2>
			<a href="/ja_wall/default/pages.html">
		Tu Resumen Johnny Cash!</a>
		</h2>





	<dl class="article-info">
	<dt class="article-info-term">Details</dt>
	<dd class="category-name">
				<strong>Category:</strong> <a href="/ja_wall/default/pages/9-uncategorised.html">Uncategorised</a>		</dd>
	<dd class="create">
	Created on 27 April 2012	</dd>
	<dd class="hits">
	<strong>Hits:</strong> 606	</dd>
	</dl>




<div class="content item-content">
	<b><p>Datos de tu ultimo Mes:</p></b>
	
	<i><font size="4"color="blue"><p>General:</p></font></i>
	<p>Tu unidad esta compuesta por:	</p><c:forEach items="${resumen.integrantesByUnidad}" var="integrante" varStatus="status">
	${integrante.persona.nombre}
	
	
	</c:forEach>
	<p>Las caracteristica de tu/tus Autos:	</p><c:forEach items="${resumen.vehiculosByUnidad}" var="vehiculo" varStatus="status">
	${vehiculo.codigo} ${vehiculo.tipoVehiculo.nombre}
	
	
	</c:forEach>
	<p>Las mascotas de la unidad:	</p><c:forEach items="${resumen.mascotasByUnidad}" var="mascota" varStatus="status">
	${mascota.nombre}
	
	
	</c:forEach>
	<p>Los accesos habilitados son:	</p>
	<p>El total de Expensas del mes fueron de :	</p>
	<i><font size="4"color="blue"><p>Eventos:</p></font></i>
	<p>Has creado <a style="font-weight:bold;" href="#">${resumen.eventosActivosTotal}</a> ,te has anotado a <a style="font-weight:bold;" href="#">${resumen.eventosInscriptosTotal}</a>.</p>
	<p>La popularidad de los eventos que has creado es (alta-baja-media)</p>
	
	<i><font size="4" color="blue"><p>Actividades:</p></font></i>
	<p>Estas inscripto en <a style="font-weight:bold;" href="#">${resumen.actividaddesTotal}</a> actividades.Contabilizando tu unidad ,estan inscriptos en <a style="font-weight:bold;" href="#">${resumen.actividaddesTotalUnidad}</a> actividades</p>
	<p>El pago total de estas es de *</p>
	<i><font size="4" color="blue"><p>Reclamos:</p></font></i>
	<p>Tenes <a style="font-weight:bold;" href="#">${resumen.reclamosAbiertosTotal}</a> reclamos abiertos.Se han cerrado con solucion <a style="font-weight:bold;" href="#">${resumen.reclamosCerradosTotal} </a>reclamos.La popularidad de los mismos es (baja-media-alta)</p>
	<b><font size="4" color="red"><p>Infracciones:</p></font></b>
	<c:if test="${resumen.infraccionesUnidadTotal == 0}">
		No tenes asociadas infracciones(contabilizando la unidad)</p>
	</c:if>
	<c:if test="${resumen.infraccionesUnidadTotal > 0}">
		Tenes asociadass <a style="font-weight:bold;" href="#">${resumen.infraccionesUnidadTotal} </a> infracciones(contabilizando la unidad)</p>
	</c:if>
	<i><font size="4" color="blue"><p>Clasificados:</p></font></i>
	<p>Tenes en venta <a style="font-weight:bold;" href="#">${resumen.avisosTotal}</a> articulos.</p>
	<p>Haz vendido * articulos(?Sirve?)</p>
	<i><font size="4" color="blue"><p>Recursos:</p></font></i>
	<p>Actualmente tenes <a style="font-weight:bold;" href="#">${resumen.reservasAbiertasTotal} </a> recursos con reserva abierta</p>
	<p>El pago total de los recursos del periodo (contabilizando la unidad)es de *</p>
	<p>Basandonos en tu participacion y en las de los demas relacionado a lo que publicas,tu reputacion dentro del lugar es : (Alta-Media-Baja)</p>
	
	
	
		
	

	<p>Lorem ipsum dolor sit amet consectetuer vitae metus augue Phasellus fringilla. Curabitur sapien tempor felis pellentesque Aenean Phasellus dui tincidunt tortor Vestibulum. Eu pellentesque est leo ac semper vel pretium tortor nunc et. Volutpat Aenean semper lacinia faucibus est dis hendrerit mauris magnis Curabitur. Vel Aenean pede in sodales ut porta Nulla pellentesque Integer turpis. In tempor quis dis fringilla semper.</p>

<p>Nibh ut tellus Quisque eget Integer lacinia mi suscipit Ut gravida. In sagittis et pretium natoque et quam et tortor libero diam. Vitae est nonummy dignissim sagittis natoque cursus congue consectetuer habitasse tristique. Pretium eget arcu eu urna pretium ullamcorper vitae Phasellus mauris laoreet. Enim Vivamus nunc Aenean adipiscing id congue lorem Cras orci feugiat. Laoreet magna auctor elit elit lacus.</p>

<p>Mauris tellus pede wisi dolor ipsum faucibus vitae semper accumsan nunc. Ante vitae vitae eleifend mauris tempus tincidunt hendrerit id Curabitur elit. Sem mus Nunc nec et est turpis dapibus lorem facilisi vitae. Leo leo Nunc ligula a dolor vitae convallis at dolor nunc. Lacinia morbi in lacinia Aenean eu libero faucibus Suspendisse at Sed. Eu fames consequat urna Nulla mi sed vitae senectus nibh auctor. Ut semper ipsum.</p>

<p>Dictum nascetur leo Curabitur nibh dignissim quis auctor a ipsum netus. Phasellus hendrerit leo adipiscing sed et nunc convallis non adipiscing ipsum. Cras Phasellus Sed ipsum augue mauris odio sagittis tortor enim Fusce. Nulla Phasellus morbi ante lobortis sem parturient auctor lacus convallis at. Libero porttitor libero Vestibulum nibh et malesuada leo habitasse commodo Donec. Congue orci Sed consequat Lorem justo nunc dolor iaculis quis Nunc. Ac.</p> </div>

	

	
</div>

<script type="text/javascript">
	(function(d){
		var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
		if (d.getElementById(id)) {return;}
		js = d.createElement('script'); js.id = id; js.async = true;
		js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
		ref.parentNode.insertBefore(js, ref);
	}(document));
</script>

<div class="fb-comments fb_iframe_widget" data-href="http://joomla25-templates.joomlart.com/ja_wall/default/pages.html" data-num-posts="2" data-width="576" fb-xfbml-state="rendered"><span style="height: 178px; width: 576px;"><iframe id="f1c78e865c" name="f3fbdcdf94" scrolling="no" title="Facebook Social Plugin" class="fb_ltr" src="https://www.facebook.com/plugins/comments.php?api_key=&amp;locale=en_US&amp;sdk=joey&amp;channel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D25%23cb%3Dfa0d6be64%26origin%3Dhttp%253A%252F%252Fjoomla25-templates.joomlart.com%252Ff1c007f5c%26domain%3Djoomla25-templates.joomlart.com%26relation%3Dparent.parent&amp;numposts=2&amp;width=576&amp;href=http%3A%2F%2Fjoomla25-templates.joomlart.com%2Fja_wall%2Fdefault%2Fpages.html" style="border: none; overflow: hidden; height: 178px; width: 576px;"></iframe></span></div>

					</div>
				</div>
					<!-- // MAIN CONTENT -->
					<!-- ASIDE -->
					<div id="aside">
						<div class="inner aside-inner cols-3 clearfix masonry" style="position: relative; height: 304px;">
							<div class="col aside-col aside-col-1 masonry-brick" style="position: absolute; top: 20px; left: 10px; width: 216px;">
								<div class="moduletable moduletable" id="Mod48">
									<div class="inner moduletable-inner clearfix">
										<h3>
											<span>Atencion!</span>
										</h3>
										<div class="box-ct clearfix">
											<div class="custom">
												<p>Desde aqui podras observar tu resumen y si es necesario
												   editar o consultar ciertas cosas que no esten bien.</p>
											</div>
										</div>
									</div>
									&nbsp; &nbsp;
								</div>
							</div>
					
							<div class="col aside-col aside-col-3 masonry-brick" style="position: absolute; top: 175px; left: 10px; width: 216px;">
								<div class="moduletable moduletable bg_yellow" id="Mod39">
									<div class="inner moduletable-inner clearfix">
										<h3>
											<span>Recomendacion(En base a tu historia)</span>
										</h3>
										<div class="box-ct clearfix">
											<p>Se ha creado un Evento relacionado a la categoria Deporte</p>
											<p>Hay noticias sobre las instalaciones</p>
											<p>Esta en venta un celular S3</p>
											<p>La cancha de futbol cuenta con espacio de reserva</p>
										</div>
									</div>
									&nbsp; &nbsp;
								</div>
							</div>
							<div id="base-blank-item" class="col masonry-brick" style="height: 0px; visibility: hidden; position: absolute; top: 294px; left: 10px;"></div>
						</div>
					</div>
					<!-- // ASIDE -->
				</div>