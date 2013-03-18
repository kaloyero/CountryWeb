<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

 <script type="text/javascript">
		
		function updateActividad(id){
			
			translator.onUpdate('actividad',id);
		}

</script> 


<div class="container_12">

	<div class="grid_12">
		<h1>Actividades</h1>
		<p>Desde aqui controle las actividades que se dictan dentro de su
			establecimiento</p>
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

					<table id="actividad" class="table active-table">
					<thead>
						<tr>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">id</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Actividad</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Descripcion</th>
							
						</tr>
				</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="new" class="tab-content">
					
					 <%@include file="forms/actividadForm.jsp" %>

				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>


