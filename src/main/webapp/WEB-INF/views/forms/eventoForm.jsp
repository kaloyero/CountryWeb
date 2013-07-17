<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="EVENTO" class="block-content form">

<fieldset>
		<legend>Evento</legend>
		<div class="_100">
			<p>
				<label for="textfield">Evento</label>
				<form:input path="concepto.nombre" class="required" />

				<form:hidden path="id" />
				<form:hidden path="concepto.id" />
			</p>
		</div>

		<div class="_100">
			<p>
				<label for="textfield">Organiza: </label>
				<form:select path="integrante" multiple="false"> 
					<form:options items="${integrantes}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 		
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Recurso: </label>
				<form:select path="recurso" multiple="false" id="recursoCombo">
					<option value="-1">Seleccione un Recurso</option>
						<form:options items="${recursos}" itemValue="id"
							itemLabel="nombre" />
				</form:select>
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Fecha: </label>
				El dìa <form:input path="fecha" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield"></label>
				desde las <form:input path="hourIni" class="required" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Costo</label>
				<form:input path="concepto.importe" class="required" />
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Invitación al evento: </label>
				<form:textarea path="descripcion"  rows="3" cols="20" style="width: 100%; height: 250px;" class="required" />
			</p>
		</div>

</fieldset>

<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-right">
			<c:if test="${EVENTO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('evento');"></li>									
								</c:if>
			<c:if test="${EVENTO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateEvento(${EVENTO.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>
