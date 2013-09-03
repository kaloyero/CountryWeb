<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INFRACCION" class="block-content form">

<fieldset>
		<legend>Infraccion</legend>
		<div class="_50">
			<p>
				<label for="textfield">Codigo</label>
				<form:input path="numero" class="required" />
				<form:hidden path="id" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">El día: </label>
				<form:input path="fecha" class="required datepicker" />
			</p>
		</div>

		<div class="_50">
			<p>
				<label for="textfield">Infraccion: </label>
				<form:select path="tipoInfraccion.id" multiple="false" id="infraccionSelect" > 
					<form:options items="${categorias}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 		
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Importe: </label>
				<form:input path="importe" class="required" id="importeBox"/>
			</p>
		</div>

		<div class="_100">
			<p>
				<label for="textfield">Motivo: </label>
				<form:textarea path="motivo"  rows="3" cols="20" style="width: 90%; height: 250px;" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Unidad: </label>
				<form:select path="unidadId" multiple="false" > 
					<form:options items="${unidades}" itemValue="id"
						itemLabel="code" /> 
				</form:select> 		
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Vehiculo: </label>
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Mascota: </label>

			</p>
		</div>


</fieldset>

<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-right">
			<c:if test="${INFRACCION.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('infraccion');"></li>									
								</c:if>
			<c:if test="${INFRACCION.id != 0}">
		<!-- 		<li><input type="button" class="button" value="Guardar!"
				onClick="updateInfraccion(${INFRACCION.id})"></li>									 -->
								</c:if>
		</ul>
	</div>
</form:form>
