<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="inner content-inner clearfix">
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;">
								
<c:forEach items="${mensajes}" var="mensaje">
<div class="tileContent item hi-tech  no-image masonry-brick" style="position: absolute; top: 0px; left: 0px; width: 228px;">
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
						<strong>Category:</strong>${mensaje.categoria.nombre}
					</dd>

					<dd class="create">
						<strong>Created:</strong> 08 February 2012
					</dd>

					<dd class="create">
						<strong>por :</strong> ${mensaje.integrante.persona.apellido} 
						<strong>unidad :</strong> ${mensaje.integrante.unidad.code} 
						
					</dd>


				</dl>

			</div>
			<!-- //Item header -->

			<!-- Item content -->
			<div class="content item-content">${mensa.asunto}</div>
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
<div class="corner-stamp" style="width: 227px;">
									
								</div>
								
								
							</div>
								</div>

