<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="ACTIVIDAD" class="block-content form">
	<input type=hidden name="name" value="al" />
	<%-- 					<form:input path="dias[0]" />  --%>
	<%-- 										<form:input path="contactMap['name']" /> --%>

	<fieldset>
		<legend>General</legend>
		<div class="_100">
			<p>
				<label for="textfield">Nombre</label>
				<form:input path="nombre" class="required" />
			</p>
		</div>

		<div class="_100">
			<p>
				<label for="textarea">Descripcion</label>
				<form:textarea path="descripcion" class="required" rows="5"
					cols="40" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Costo</label>

				<form:input path="importe" class="required" />
			</p>
		</div>

		<div class="_25">
			<p>
				<label for="datepicker">Comienzo</label>
				<form:input path="fechaInicio" class="required" />
			</p>
		</div>

		<div class="_100">
			<p>
				<label for="select">Profesor</label>
				<form:select path="instructores" multiple="false">
					<form:options items="${instructores}" itemValue="id"
						itemLabel="persona.nombre" />
				</form:select>
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
				<tbody id="tableBody">
					<c:set var="show" value="false" />
					<c:forEach items="${ACTIVIDAD.horas}" var="hora" varStatus="status">
						<tr id="${hora}">
							<td>${hora}</td>
							<c:forEach items="${ACTIVIDAD.dias}" var="dia" varStatus="status">
								<c:forEach var="valor" items="${dia.value}">

									<c:if test="${valor == hora}">
										<c:set var="show" value="true" />
									</c:if>
								</c:forEach>
								<c:if test="${show == 'true'}">
									<td id="${dia.key}" class="selectable selected"
										style="padding-left: 43px;"><img src="resources/img/check.png" alt="Smiley face" height="10" width="12"></td>
								</c:if>
								<c:if test="${show == 'false'}">
									<td id="${dia.key}" class="selectable"
										style="padding-left: 43px;"></td>
								</c:if>
								<c:set var="show" value="false" />
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
			<li><input type="button" class="button" value="Crear!"
				onClick="submitActividad()"></li>
		</ul>
	</div>
</form:form>