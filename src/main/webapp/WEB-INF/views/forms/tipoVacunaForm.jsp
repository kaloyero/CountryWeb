<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="TIPO" class="block-content form">
	
	<fieldset>
			<legend>Configuracion</legend>
	
		<div class="_25">
			<p>
				<label for="textfield">Vacuna</label>
				<form:input path="nombre" class="required" />
				<form:hidden path="id" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Especie</label>
				<form:select path="especie" multiple="false">
					<form:options items="${especies}" itemValue="id" itemLabel="nombre" />
				</form:select>
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Vigencia (en meses)</label>
				<form:input path="vigencia" class="required"  maxlength="4" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Obligatorios</label>
				<form:checkbox path="obligatoria" value="true" />
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