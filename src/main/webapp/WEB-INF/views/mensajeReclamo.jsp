<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>
 <script type="text/javascript">
		
		function updateMensaje(id){
			
			translator.onUpdate('mensajeReclamo',id);
		}

</script> 

<div class="container_12">

	<div class="grid_12">
		<h1>Reclamos</h1>
		<p>Desde aqui controle los Reclamos</p>
	</div>
	<div class="grid_12">
		<div class="block-border" id="tab-panel-1">
			<div class="block-header">
				<h1></h1>

				<ul class="tabs">
					<li><a href="#tab-1">Listado </a></li>
					<li><a href="#new">+</a></li>
				</ul>
			</div>
			<div class="block-content tab-container">
				<div id="tab-1" class="tab-content">

					<table id="mensajeReclamo" class="table active-table">
					<thead>
						<tr>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">id</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Asunto</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Creado por</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Para</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Categoria</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Fecha creacion</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">estado</th>
						</tr>
					</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="new" class="tab-content">
					
					 <%@include file="forms/mensajeReclamoForm.jsp" %>

				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>