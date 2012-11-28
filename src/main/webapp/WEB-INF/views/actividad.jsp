<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<li><a href="#tab-2">+</a></li>
					<li><a href="#tab-3">Consectetur</a></li>
				</ul>
			</div>
			<div class="block-content tab-container">
				<div id="tab-1" class="tab-content">

					<table id="table-example" class="table">
					<thead>
						<tr>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Actividad</th>
							<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Descripcion</th>
							
						</tr>
				</thead>
<!-- 							<tr> -->
<!-- 								<th>Actividad</th> -->
<!-- 								<th>Integrantes</th> -->
<!-- 								<th>Descripcion</th> -->

<!-- 							</tr> -->
<!-- 						</thead> -->
<!-- 						<tbody> -->

<%-- 							<c:forEach var="elemento" items="${lista}"> --%>
<!-- 								<tr> -->
<%-- 									<td>${elemento}</td> --%>
<%-- 									<td>${elemento}</td> --%>
<%-- 									<td>${elemento}</td> --%>

<!-- 								</tr> -->
<%-- 							</c:forEach> --%>
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="tab-2" class="tab-content">
					<p></p>
					<form id="validate-form" class="block-content form" action=""
						method="post">
						<fieldset>
							<legend>General</legend>
							<div class="_100">
								<p>
									<label for="textfield">Nombre</label><input id="textfield"
										name="textfield" class="required" type="text" value="" />
								</p>
							</div>

							<div class="_100">
								<p>
									<label for="textarea">Descripcion</label>
									<textarea id="textarea" name="textarea" class="required"
										rows="5" cols="40"></textarea>
								</p>
							</div>
							<div class="_25">
								<p>
									<label for="textfield">Costo</label><input id="textfield"
										name="textfield" class="required" type="text" value="" />
								</p>
							</div>

							<div class="_25">
								<p>
									<label for="datepicker">Comienzo</label><input id="datepicker"
										name="datepicker" class="required" type="text" value="" />
								</p>
							</div>
							<div class="_50">
								<p>
									<span class="label">Apto</span> <label><input
										type="checkbox" name="checkbox" />Menores</label> <label><input
										type="checkbox" />Adultos</label> <label><input
										type="checkbox" />Hombres</label> <label><input
										type="checkbox" />Mujeres</label>
								</p>
							</div>
							<div class="_100">
								<p>
									<label for="select">Profesor</label> <select>
										<option>Alexis</option>
										<option>Oski</option>
										<option>Jackie</option>
									</select>
								</p>
							</div>
						</fieldset>
						<fieldset>
							<legend>Cronograma</legend>
							<div class="_100">
								<p></p>
								<p></p>
								<table id="cronograma" class="table">
									<thead>
										<tr>
											<th></th>
											<th>Domingo</th>
											<th>Lunes</th>
											<th>Martes</th>
											<th>Miercoles</th>
											<th>Jueves</th>
											<th>Viernes</th>
											<th>Sabado</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>11:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
											<td>12:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
											<td>14:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
											<td>15:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
											<td>16:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
											<td>16:00</td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
											<td id="h" class="selectable" style="padding-left: 43px;"></td>
										</tr>
										<tr>
									</tbody>
								</table>
							</div>

						</fieldset>

						<div class="clear"></div>
						<div class="block-actions">
							<ul class="actions-left">
								<li><a class="button red" id="reset-validate-form"
									href="javascript:void(0);">Reset</a></li>
							</ul>
							<ul class="actions-right">
								<li><input type="submit" class="button" value="Crear!"></li>
							</ul>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>