<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>


<div class="inner content-inner clearfix">
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;">
								
<c:forEach items="${eventos}" var="evento">

	
<div class="tileContent item instagram item-hot masonry-brick" style="position: absolute; top: 0px; left: 0px; width: 200px;">
<div class="inner item-inner clearfix">
	
	
	<!-- Item Img -->
	<div class="item-image">
					<div class="img-intro-left">
						<a href="/ja_wall/default/instagram/17975-instagram-id-339270252753126384-1323391.html" title="Nombre Evento" class="item-link">
							<div class="img_caption none" style="float: none; width: 209px;"><img class="caption" title="Nombre Evento" src="../resources/img/propietarios/events-icon-small.png" alt="Nombre Evento"><p class="img_caption">${evento.nombre}</p></div>
							<span>&nbsp;</span>
				<span class="item-pin">&nbsp;</span>
			</a>
					</div>
		</div>
	<!-- //Item Img -->

	<div class="item-main clearfix">
		<!-- Item header -->
		<div class="header item-header clearfix">
					<h2>
									<a href="#" class="item-link"><font color="#09c">${evento.nombre}</font>
					</a>
						</h2>
		
					<dl class="article-info">
				<dt class="article-info-term">Details</dt>

		
						<dd class="category-name">
		
						<dd class="create">
						<c:if test="${evento.cupo > 1}">
							<strong>Se necesitan:</strong> ${evento.cupo} personas
						<strong>Dia se la semana:</strong>: ${evento.diaSemana} 
						</c:if>
						<c:if test="${evento.cupo <= 1}">
							<strong>Se realiza el:</strong> ${evento.fecha}						
						</c:if>
					<strong>Horario comienzo:</strong> ${evento.hourIni}
					<strong>Duracion:</strong> ${evento.duracion} horas
					</dd>
					</dl>
			
		</div>
		<!-- //Item header -->

		<!-- Item content -->
		<div class="content item-content">
		${evento.descripcion}		</div>
		<!-- //Item content -->

		<div class="footer item-footer clearfix">
					<dl class="article-hit">
						<dd class="hits">
							<strong>Unidos:</strong> 0 
						</dd>
						<dd class="hits">
							<c:if test="${evento.integrante == null}">
								<strong>Creado por:</strong> Admin
													</c:if>
							<c:if test="${evento.integrante != null}">
								<strong>Creado por:</strong> ${evento.integranteNombre} ${evento.integranteApellido}
													</c:if>

						</dd>
						<dd class="hits anotarseEvento">
							<input type="hidden" name="idEvento" value="${evento.id}">
						
							<a>Click aqui para anotarse al evento</a>
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

