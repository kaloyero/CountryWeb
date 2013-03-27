<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
	
	<fieldset>
		<legend>Datos Personales</legend>
		<div class="_50">
			<p>
				<label for="textfield">Nombre</label>
				<form:input path="persona.nombre" class="required" />
				<form:hidden path="persona.id" />
			</p>
		</div>

		<div class="_50">
			<p>
				<label for="textarea">Apellido</label>
				<form:input path="persona.apellido" class="required" rows="5"
					cols="40" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Sexo</label>

				<form:input path="persona.sexo" class="required" />
			</p>
		</div>

		<div class="_25">
			<p>
				<label for="datepicker">Nacimiento</label>
				<form:input path="persona.nacimiento" class="required" />
			</p>
		</div>

		<div class="_25">
			<p>
				<label for="select">Tipo Documento</label>
				<form:select path="persona.tipoDocumento" multiple="false"> 
					<form:options items="${tipoDocumento}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 				
			</p>
		</div>
		
		<div class="_25">
			<p>
				<label for="datepicker">Nro Documento</label>
				<form:input path="persona.nroDoc" class="required" />
			</p>
		</div>
	
	<div class="_25">
			<p>
				<label for="datepicker">Email</label>
				<form:input path="persona.email" class="required" />
			</p>
		</div>
</fieldset>