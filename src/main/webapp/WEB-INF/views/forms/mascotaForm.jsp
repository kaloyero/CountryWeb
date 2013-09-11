<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="MASCOTA" class="block-content form">

<fieldset>
		<legend>Mascota</legend>
		<div class="_50">
			<p>
				<label for="textfield">Codigo</label>
				<form:input path="codigo" class="required" />
				<form:hidden path="id" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Nombre</label>
				<form:input path="nombre" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Sexo</label>
				<form:input path="sexo" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Fecha Nacimiento</label>
				<form:input path="fNac" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Tamaño</label>
				<form:input path="tamanio" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Color</label>
				<form:input path="color" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textarea">Marcas Distintivas</label>
				<form:textarea path="marcasDist" class="required" rows="5"
					cols="40" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="textfield">Raza</label>
				<form:select path="raza" multiple="false"> 
					<form:options items="${razas}" itemValue="id" 
						itemLabel="nombre" />
				</form:select> 
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
			<c:if test="${MASCOTA.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('mascota');"></li>									
			</c:if>
			<c:if test="${MASCOTA.id != 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="updateMascota(${MASCOTA.id})"></li>									
			</c:if>
		</ul>
	</div>
</form:form>