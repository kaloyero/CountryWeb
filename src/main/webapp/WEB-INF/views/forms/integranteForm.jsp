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
			<%@include file="../utils/agregarTelefono.jsp" %>
			<BR>
			<div class="block-border">
				<div class="block-header">
					<h1>Telefonos</h1><span></span>
				</div>
				<div class="block-content">
					<ul class="block-list" id ="listaTelefonos">
						<c:forEach var="tel" items="${INTEGRANTE.persona.listaTelefonos}">
							<li>
								<div class='alert success telefono'>
					    			<span class='idTel' hidden='true'>${tel.id}</span>
					    			<span class='idTipoTe' hidden='true'>${tel.tipoTelefonoNombre}</span>
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