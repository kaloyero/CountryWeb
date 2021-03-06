<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<script type="text/javascript">
		
		function updateInstructor(id){
			
			translator.onUpdate('instructor',id);
		}

</script> 


<div class="container_12">

	<div class="grid_12">
		<h1>Instructores</h1>
		<p>Desde aqui controle los instructores</p>
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

					<table id="instructor" class="table active-table">
					<thead>
						<tr>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">id</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Nombre</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Documento</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">E-mail</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Telefono</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Estado</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Acciones</th>
						</tr>
				</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="new" class="tab-content">
					
					 <%@include file="forms/instructorForm.jsp" %>

				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>


