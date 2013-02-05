<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="RECURSO" class="block-content form">

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
				<label for="datepicker">Max tiempo Reserva (minutos)</label>
				<form:input path="maxTiempoReserva" class="required" />
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
			<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('recurso');"></li>
		</ul>
	</div>
</form:form>