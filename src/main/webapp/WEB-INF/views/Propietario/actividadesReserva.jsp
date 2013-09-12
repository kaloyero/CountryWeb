<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="inner content-inner clearfix"><strong>Filtrar por : </strong><a href="#" title="">Todas | </a><a href="#" title="">Actividades a las que me anote </a>
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1784px;"><div class="corner-stamp" style="width: 227px;">
									
								</div>
<c:forEach items="${actividades}" var="actividad">

<div class="tileContent item instagram item-hot masonry-brick" style=" position: absolute; top: 0px; left: 0px;">
		
									<div class="inner item-inner clearfix">


										<!-- Item Img -->
										<div class="item-image">
											<div class="img-intro-left">
												<a
													href="/ja_wall/default/instagram/17975-instagram-id-339270252753126384-1323391.html"
													title="Our CEO, Pete Cashmore got to hold Tardar Sauce AKA #GrumpyCat d"
													class="item-link">
												<div class="header item-header clearfix">
												<h2>
												<input type="hidden" name="idActividad" value="${actividad.id}">
												
												${actividad.nombre}
												</h2>
												<dl class="article-info">
													<dt class="article-info-term">Detalles</dt>
													<dd class="category-name">
														<strong>Categoria:</strong> <a href="/ja_wall/default/instagram.html">Actividades</a>
													</dd>
													<dd class="create">
														<strong style="font-family:arial;color:#9E7474;font-size:15px;">Costo:100$</strong>
													</dd>
											
												</dl>

											</div>
												</a>
											</div>
										</div>
										<!-- //Item Img -->

										<div class="item-main clearfix" style="padding-top:1px;">
											<!-- Item header -->
										
											<!-- //Item header -->
											<strong>Descripcion:</strong>
											<!-- Item content -->
											<div class="content item-content">
											 ${actividad.descripcion}
											 											<strong><p>Dias y Horarios:</p></strong>
											 
											 <div style="height:120px;width:170px;border:1px solid #ccc;overflow:auto;">
											 
												<ul>
													<c:forEach items="${actividad.cronograma}" var="cronograma">
														<li><a class ="anotarseAcvitidad" id='${cronograma.id}'>${cronograma.dia} a las ${cronograma.horario}</a></li>

													</c:forEach>
											</ul>
											</div>
				
											</div>
											<!-- //Item content -->

											<!-- Item footer -->
											<div class="footer item-footer clearfix">




												<dl class="article-hit">
													<dd class="hits">
														<strong>Hits:</strong> 153
													</dd>
												</dl>



											</div>
											<!-- //Item footer -->
										</div>

										<div class="item-separator">&nbsp;</div>
									</div>
								</div>
					</c:forEach>
			
								
								
							</div>
								</div>
								