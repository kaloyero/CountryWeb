<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="inner content-inner clearfix">
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;">
<c:forEach items="${actividades}" var="actividad">

<div class="tileContent item instagram item-hot masonry-brick" style="width: 228px; position: absolute; top: 0px; left: 0px;">
									<div class="inner item-inner clearfix">


										<!-- Item Img -->
										<div class="item-image">
											<div class="img-intro-left">
												<a
													href="/ja_wall/default/instagram/17975-instagram-id-339270252753126384-1323391.html"
													title="Our CEO, Pete Cashmore got to hold Tardar Sauce AKA #GrumpyCat d"
													class="item-link">
													<div class="img_caption none" style="float: none; width: 209px;">
														<img class="caption"
															title="Our CEO, Pete Cashmore got to hold Tardar Sauce AKA #GrumpyCat d"
															src="../resources/img/propietarios/images.jpeg"
															alt="Our CEO, Pete Cashmore got to hold Tardar Sauce AKA #GrumpyCat d">
														<p class="img_caption">${actividad.nombre}</p>
													</div>
													 <span>&nbsp;</span> <span class="item-pin">&nbsp;</span>
												</a>
											</div>
										</div>
										<!-- //Item Img -->

										<div class="item-main clearfix">
											<!-- Item header -->
											<div class="header item-header clearfix">
												<h2>
												
												${actividad.nombre}

												</h2>
												<dl class="article-info">
													<dt class="article-info-term">Detalles</dt>
													<dd class="category-name">
														<strong>Categoria:</strong> <a href="/ja_wall/default/instagram.html">Actividades</a>
													</dd>
													<dd class="create">
														<strong>Costo:</strong>00
													</dd>
											
												</dl>

											</div>
											<!-- //Item header -->

											<!-- Item content -->
											<div class="content item-content">
											 ${actividad.descripcion}
												<ul>
													<strong><p>Dias y Horarios:</p></strong>
													<c:forEach items="${actividad.cronograma}" var="cronograma">
														<li><a href="#">${cronograma.dia} a las ${cronograma.horario}</a></li>

													</c:forEach>
											</ul>
				
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
					<div class="corner-stamp" style="width: 227px;">
									
								</div>
								
								
							</div>
								</div>
								