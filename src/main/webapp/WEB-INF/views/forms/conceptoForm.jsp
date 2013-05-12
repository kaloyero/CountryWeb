<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
</script>

<p></p>
<form:form commandName="CONCEPTO" class="block-content form">

	<fieldset>
		<legend>General</legend>
		<div class="_100">
			<p>
				<label for="textfield">Nombre</label>
				<form:input path="nombre" class="required" /><span class="ui-icon ui-icon-close" role="presentation" onclick="alert('ale');" >Remove Tab</span>
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
				<form:input path="fechaComienzo"  class="required datepicker"/>
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
		</ul>
		<ul class="actions-right">
			<c:if test="${CONCEPTO.id == 0}">
			<li><input type="button" class="button" value="Crear Po"
				onClick="translator.onSubmit('concepto');"></li>
			</c:if>
			<c:if test="${CONCEPTO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateConcepto(${CONCEPTO.id})"></li>									
			</c:if>
		</ul>
		
	</div>
</form:form>