<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="TIPO" class="block-content form">
	
	<fieldset>
			<legend>Configuracion</legend>
	
		<div class="_50">
			<p>
				<label for="textfield">Infraccion</label>
				<form:input path="nombre" class="required" />
				<form:hidden disabled="true" path="id" />
				<form:hidden disabled="true" path="concepto.id" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Importe</label>
				<form:input path="concepto.importe" class="required"  maxlength="8" />
			</p>
		</div>
		<div class="100">
			<p>
				<label for="textfield">Descipcion</label>
				<form:textarea path="concepto.descripcion" class="required" rows="4"/>
	
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
			<c:if test="${TIPO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('${accion}');"></li>									
								</c:if>
			<c:if test="${TIPO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateTipo(${TIPO.id})"></li>									
			</c:if>
		</ul>
	</div>

</form:form>