<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>
 <script type="text/javascript">
		
		function updateInfraccion(id){
			translator.onUpdate('infraccion',id);
		}

</script> 

<div class="container_12">

	<div class="grid_12">
		<h1>Infracciones</h1>
		<p>Desde aqui controle las Infracciones</p>
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

					<table id="infraccion" class="table active-table">
					<thead>
						<tr>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">id</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Numero</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Fecha</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Importe</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Tipo</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Unidad</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Acciones</th>
						</tr>
					</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="new" class="tab-content">
					
					 <%@include file="forms/infraccionForm.jsp" %>

				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>