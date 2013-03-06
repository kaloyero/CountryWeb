<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="VEHICULO" class="block-content form">


<fieldset>
		<legend>Vehiculo</legend>
		<div class="_50">
			<p>
				<label for="textfield">Codigo</label>
				<form:input path="codigo" class="required" />
				<form:hidden path="id" />
			</p>
		</div>

		<div class="_50">
			<p>
				<label for="textfield">Cilindrada</label>
				<form:input path="cilindrada" class="required" />
			</p>
		</div>
		<div class="_50">
				<p>
				<label for="select">Tipo de Vehiculo</label>
				<form:select path="tipoVeh" multiple="false"> 
					<form:options items="${tipoVehiculo}" itemValue="id" 
						itemLabel="nombre" />
				</form:select> 
			</p>
		</div>

		<div class="_25">
			<p>
				<label for="textarea">Descripcion</label>
				<form:input path="descripcion" class="required" rows="5"
					cols="40" />
			</p>
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
			<c:if test="${VEHICULO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('vehiculo');"></li>									
			</c:if>
			<c:if test="${VEHICULO.id != 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="updateVehiculo(${VEHICULO.id})"></li>									
			</c:if>
		</ul>
	</div>
</form:form>