<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INSTRUCTOR" class="block-content form">

<%@include file="personaForm.jsp" %>

<fieldset>
		<legend>Instructor</legend>
		<div class="_50">
			<p>
				<label for="textfield">Fecha desde</label>
				<form:input path="fechaComienzo" class="required datepicker" />
			</p>
		</div>
			<div class="_50">
			<p>
				<label for="textfield">Fecha hasta</label>
				<form:input path="fechaFin" class="required datepicker" />
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
				<p>
					<label for="datepicker">Agregar Telefono</label>
					<div>
						<ul class="block-list">	
							<li>
								<select> 
									<c:forEach var="tel" items="${tipoTelefono}">
										<option value="${tel.id}">${tel.nombre}</option>
									</c:forEach>
								</select> 				
								<input type="text" class=""  id="telCountry" placeholder="pais" size="50%" />
								<input type="text" class="" id="telState" placeholder="ciudad" size="25%"/>
								<input type="text" class="" id="telNumber" placeholder="numero" size="25%"/>
							</li>
						</ul>
					</div>
					<input type="button" id="addPhone" value="+" />
				</p>
				<div class="block-border">
					<div class="block-header">
						<h1>Telefonos</h1><span></span>
					</div>
					<div class="block-content">
						<ul class="block-list" id ="listaTelefonos">
							<c:forEach var="tel" items="${INTEGRANTE.persona.telefonos}">
								<li id="${dir.key}">
									${tel.value}
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
		</div>
		<div class="_50">
				<p>
					<label for="datepicker">Agregar Direccion</label>
					<div>
						<ul class="block-list">	
							<li>
								<input type="text" class=""  id="dirStreet" placeholder="Nombre de la calle" size="50%" />
								<input type="text" class="" id="dirNum" placeholder="Numero" size="25%"/>
								<input type="text" class="" id="dirFloor" placeholder="piso" size="25%"/>
							</li>
						</ul>
					</div>
				</p>
				<div class="block-border">
					<div class="block-header">
						<h1>Direcciones</h1><span></span>
					</div>
					<div class="block-content">
						<ul class="block-list">
							<c:forEach var="dir" items="${INTEGRANTE.persona.direcciones}">
								<li id="${dir.key}">
									 ${dir.value}
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