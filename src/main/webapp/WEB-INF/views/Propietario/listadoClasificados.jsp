<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>


<div class="inner content-inner clearfix"><strong>Filtrar por : </strong><a href="#" title="">Todos | </a><a href="#" title="">Electronica  | </a><a href="#" title="">Hogar  | </a>
<a href="#" title="">Ropa  | </a><a href="#" title="">Consolas  | </a><a href="#" title="">Muebles  | </a>
						<div id="masonry-container" class="clearfix masonry" style="position: relative; height: 1578px;"><div class="corner-stamp" style="width: 227px;">
									
								</div>
						
<c:forEach items="${avisos}" var="aviso">
						
<div class="item flickr item-hot masonry-brick" style="position: absolute; top: 0px; left: 0px; width: 228px;">
<div class="inner item-inner clearfix">
	
	
	<!-- Item Img -->
	<div class="item-image">
					<div class="img-intro-left">
						<a href="#" title="" class="item-link">
							<div class="img_caption none" style="float: none; width: 187px;"><img class="caption" src="http://joomla25-templates.joomlart.com/ja_wall/images/jasocial_feed/0086c22e027f2877ea5680d289cff62b.jpg" display: inline;"><p class="img_caption">${aviso.categoriaDescription}</p></div>
							<span>&nbsp;</span>
				<span class="item-pin">&nbsp;</span>
			</a>
					</div>
		</div>
	<!-- //Item Img -->

	<div class="item-main clearfix">
		<!-- Item header -->
		<div class="header item-header clearfix">
					<h2><a class='openDescription'>${aviso.titulo}</a>
					<input type="hidden"class='description' name="Language" value='${aviso.cuerpo}' >
								
						</h2>
		
					<dl class="article-info">
				<dt class="article-info-term">Details</dt>
		
		
						<dd class="category-name">
																<strong>Categoria:</strong> <label class='categoria'>${aviso.categoriaDescription}</label> </dd>
		
						<dd class="create">
				<strong>Creado:</strong> <label class='creacion'>${aviso.fecha}	</label></dd>
		
		
		
		
					</dl>
			
		</div>
		<!-- //Item header -->

		<!-- Item content -->
		<div class="content item-content">
		<a href="http://www.flickr.com/people/joomla/">${aviso.importe} $</a> es el Precio	.</div>
		<!-- //Item content -->

		<!-- Item footer -->
		<div class="footer item-footer clearfix">

		
		
		
					<dl class="article-hit">
				<dd class="hits">
				<strong>Hits:</strong> 109				</dd>
				<strong>Publicado por:</strong> ${aviso.integranteNombre} ${aviso.integranteApellido} de la unidad ${aviso.unidad}
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

