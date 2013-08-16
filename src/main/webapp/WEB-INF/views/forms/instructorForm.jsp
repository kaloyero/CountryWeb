<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INSTRUCTOR" class="block-content form">

<%@include file="personaForm.jsp" %>

<fieldset>
		<legend>Instructor</legend>
		<div class="_25">
			<p>
				<label for="textfield">Fecha desde</label>
				<form:input path="fechaComienzo" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Fecha hasta</label>
				<form:input path="fechaFin" class="required datepicker" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Estado</label>
				<form:checkbox path="estado" value="true" />
			</p>
		</div>
		
</fieldset>

<fieldset>
		<legend>Contacto</legend>
		<div class="_100">
			<p>
				<label for="datepicker">Email</label>
				<form:input path="persona.email" class="required" />
			</p>
		</div>
		<div class="_50">
			<%@include file="../utils/agregarTelefono.jsp" %>
			<BR>
			<div class="block-border">
				<div class="block-header">
					<h1>Telefonos</h1><span></span>
				</div>
				<div class="block-content">
					<ul class="block-list" id ="listaTelefonos">
						<c:forEach var="tel" items="${INSTRUCTOR.persona.listaTelefonos}">
							<li>
								<div class='alert success telefono'>
					    			<span class='idTel' hidden='true'>${tel.id}</span>
					    			<span class='idTipoTe' hidden='true'>${tel.tipoTelefono}</span>
					    			<span class='tipoTe' >${tel.tipoTelefonoNombre} </span>
						    		<strong>( </strong><span class='pais'> ${tel.codigoPais}</span>
						    		<span class='state'> ${tel.codigoArea}</span>
						    		<span class='prefix'> ${tel.prefijo}</span><strong> ) </strong>
						    		<span class='tel'>${tel.numero}</span>
						    		<span class='hide'>x</span>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>			
		</div>
		<div class="_50">
			<%@include file="../utils/agregarDireccion.jsp" %>
			<BR>
			<div class="block-border">
				<div class="block-header">
					<h1>Direcciones</h1><span></span>
				</div>
				<div class="block-content">
					<ul class="block-list" id ="listaDirecciones">
						<c:forEach var="tel" items="${INSTRUCTOR.persona.listaDirecciones}">
							<li>
								<div class='alert success direccion'>
					    			<span class='idDire' hidden='true'>${tel.id}</span>
					    			<span class='idTownDire' hidden='true'>${tel.id} </span>
					    			<span class='townDire' >${tel.townName} </span>
					    			<span class='streetNameDire' >${tel.streetName} </span>
					    			<span class='streetNumDire' >${tel.streetNumber} </span>
	    							<span class='floorDire'>${tel.floor} </span>
					    			<span class='flatDire' >${tel.flat} </span>
					    			<span class='towerDire'>${tel.tower} </span>
					    			<span class='blockDire'>${tel.block} </span>
						    		<span class='hide'>x</span>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>			

		</div>
</fieldset>

	<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Limpiar</a></li>
		</ul>
		<ul class="actions-right">
			<c:if test="${INSTRUCTOR.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('instructor');"></li>
								</c:if>
			<c:if test="${INSTRUCTOR.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateInstructor(${INSTRUCTOR.id})"></li>									
			</c:if>
		</ul>
		
	</div>
</form:form>