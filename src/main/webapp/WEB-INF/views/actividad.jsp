<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>
 <script type="text/javascript">
	
		function submitActividad(){
			var translator= new ComponentTranslator()
			translator.onSubmit('actividad');
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
						<tbody>
						</tbody>
					</table>
				</div>
				<div id="tab-2" class="tab-content">
					<p></p>
					 <form:form commandName="ACTIVIDAD" >
					<input type=hidden name="name" value="al"/>  
<%-- 					<form:input path="dias[0]" />  --%>
<%-- 										<form:input path="contactMap['name']" /> --%>
					
						<fieldset>
							<legend>General</legend>
							<div class="_100">
								<p>
									<label for="textfield">Nombre</label><form:input path="name" class="required"/>
								</p>
							</div>

							<div class="_100">
								<p>
									<label for="textarea">Descripcion</label>
									<form:textarea path="descripcion" class="required" rows="5" cols="40"/>
								</p>
							</div>
							<div class="_25">
								<p>
									<label for="textfield">Costo</label>
									
									<form:input path="importe"  class="required"/>
								</p>
							</div>

							<div class="_25">
								<p>
									<label for="datepicker">Comienzo</label><form:input path="fechaInicio"  class="required"/>
								</p>
							</div>
							
							<div class="_100">
								<p>
									<label for="select">Profesor</label>
									<form:select path="instructores" multiple="false">
										<form:options items="${instructores}" itemValue="id" itemLabel="persona.nombre"/>
									</form:select>
								</p>
							</div>
							 <c:forEach items="${roleList}" var="role" varStatus="status">
            					<tr>
                					<td><form:checkbox path="roles" value="${role}" label="${role.id}" /></td>
           				 	</tr>
        				</c:forEach>
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

								<c:forEach items="${ACTIVIDAD.lunes}" var="hora" varStatus="status">
											
									</c:forEach>							
		
									</thead>
									<tbody id="tableBody">
									<c:set var="show" value="false"/>
										<c:forEach items="${ACTIVIDAD.horas}" var="hora" varStatus="status">
										<tr id="${hora}"><td>${hora}</td>
										 <c:forEach items="${ACTIVIDAD.dias}" var="dia" varStatus="status">
												<c:forEach var="valor" items="${dia.value}">
												
												<c:if test="${valor == hora}">
								                      <c:set var="show" value="true"/>
							                        </c:if>
												</c:forEach>
												<c:if test="${show == 'true'}">
												<td id="${dia.key}" class="selectable selected" style="padding-left: 43px;"></td>
												</c:if>
												<c:if test="${show == 'false'}">
												<td id="${dia.key}" class="selectable" style="padding-left: 43px;"></td>
												</c:if>
								                      <c:set var="show" value="false"/>
									</c:forEach>							
									
							</tr>
									
									</c:forEach>
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
								<li><input type="button" class="button" value="Crear!" onClick="submitActividad()"></li>
							</ul>
						</div>
				  </form:form>

				</div>
			</div>
		</div>
	</div>

	<div class="clear height-fix"></div>

</div>