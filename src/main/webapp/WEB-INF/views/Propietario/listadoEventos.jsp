<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>


<div class="inner content-inner clearfix">
							<div id="masonry-container" class="clearfix masonry"
								style="position: relative; height: 1592px;">
								
<c:forEach items="${eventos}" var="evento">

<div class="tileContent item hi-tech  no-image masonry-brick" style="position: absolute; top: 0px; left: 0px; width: 228px;">
<div class="inner item-inner clearfix">
	
	


	<div class="item-main clearfix">
		<!-- Item header -->
		<div class="header item-header clearfix">
					<h2>
					<img src="../resources/img/propietarios/events-icon-small.png" alt="Evento" height="42" width="42">				<a href="#" class="item-link"><font color="#09c">${evento.nombre}</font>
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
							<strong>Unidos:</strong> ${evento.cantidadUnidos} 
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

