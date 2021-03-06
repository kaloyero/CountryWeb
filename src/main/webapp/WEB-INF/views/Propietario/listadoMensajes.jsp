<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="inner content-inner clearfix"><strong>Filtrar por : </strong><a href="#" title="">Todos | </a><a href="#" title="">Mis Reclamos Creados  | </a>
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;"><div class="corner-stamp" style="width: 227px;">
									
								</div>
								
<c:forEach items="${mensajes}" var="mensaje">
<div class="tileContent item hi-tech  no-image " style="position: absolute; top: 0px; left: 0px; width: 221px;">
	<div class="inner item-inner clearfix">


		<!-- Item Img -->
		<div class="item-image"></div>
		<!-- //Item Img -->

		<div class="item-main clearfix">
			<!-- Item header -->
			<div class="header item-header clearfix">
				<h2>
					<a href="#" title="Exploration wheels soap sufficiently steele"
						class="item-link">${mensaje.asunto}</a>

				</h2>

				<dl class="article-info">
					<dt class="article-info-term">Details</dt>


					<dd class="category-name">
						<strong>Categoria:</strong>${mensaje.categoriaDescripcion}
					</dd>

					<dd class="create">
						<strong>Creado:</strong> ${mensaje.fecha}
					</dd>

					<dd class="create">
						<strong>Por :</strong> ${mensaje.integranteNombre} ${mensaje.integranteApellido}  
						<strong>Unidad :</strong> ${mensaje.integranteUnidad} 
						
					</dd>


				</dl>

			</div>
			<!-- //Item header -->

			<!-- Item content -->
			<div class="content item-content">${mensaje.descripcion}</div>
			<!-- //Item content -->

			<!-- Item footer -->
			<div class="footer item-footer clearfix">




				<dl class="article-hit">
					<dd class="hits">
						<strong>Hits:</strong> 500
					</dd>
				</dl>

				<p class="readmore">
					<a href="#" title="Exploration wheels soap sufficiently steele"
						class="item-link"> More </a>
				</p>


			</div>
			<!-- //Item footer -->
		</div>

		<div class="item-separator">&nbsp;</div>
	</div>
</div>
</c:forEach>

								
								
							</div>
								</div>

