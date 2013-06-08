<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>





<div style="position: absolute; top: 0px; left: 0px; width: 910px;"
	class="tileContent item hi-tech grid-triple  masonry-brick">
	<div class="inner item-inner clearfix">


		<!-- //Item Img -->

		<div class="item-main clearfix">
			<!-- Item header -->
			<div class="header item-header clearfix">
				<h2>Anotate a una actividad! </h2>

			</div>
			<!-- //Item header -->

			<!-- Item content -->
			<div class="content item-content">
				<ol>
					<c:forEach items="${actividades}" var="actividad">
						<li>${actividad.nombre}
							<ul>
								<p>Dias y Horarios:</p>
								<c:forEach items="${actividad.cronograma}" var="cronograma">
									<li><a href="#">${cronograma.dia}
											a las ${cronograma.horario}</a></li>
									<p></p>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ol>
			</div>
			<!-- //Item content -->

			<!-- Item footer -->
			<div class="footer item-footer clearfix"></div>
			<!-- //Item footer -->
		</div>

	</div>
</div>