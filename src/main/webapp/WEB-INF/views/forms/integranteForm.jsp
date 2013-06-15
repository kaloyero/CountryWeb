<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INTEGRANTE" class="block-content form">

<%@include file="personaForm.jsp" %>
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
								<div class="_25">
									<select id="telContact"> 
										<c:forEach var="tel" items="${tipoTelefono}">
											<option value="${tel.id}">${tel.nombre}</option>
										</c:forEach>
									</select> 				
								</div>
								<div class="_15">
									<input type="text" class=""  id="telCountry" placeholder="pais" size="50%" maxlength="6" />
								</div>
								<div class="_15">
									<input type="text" class="" id="telState" placeholder="ciudad" size="25%" maxlength="6"/>
								</div>
								<div class="_30">
									<input type="text" class="" id="telNumber" placeholder="numero" size="25%" maxlength="16"/>
								</div>
								<div class="_10">
									<input type="button" id="addPhone" value="+" />
								</div>
							</li>
						</ul>
					</div>
				</p>
				<BR>
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
				<label for="select">Unidad</label>
				<form:select path="unidad" multiple="false"> 
					<form:options items="${unidades}" itemValue="id" 
						itemLabel="code" />
				</form:select> 
			</p>
		</div>

</fieldset>

 	<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Reset</a></li>
		</ul>
		<ul class="actions-right">
			<c:if test="${INTEGRANTE.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('integrante');"></li>									
								</c:if>
			<c:if test="${INTEGRANTE.id != 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="updateIntegrante(${INTEGRANTE.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>