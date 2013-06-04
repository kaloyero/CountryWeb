<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="MENSAJE" class="block-content form">

<fieldset>
		<legend>Mensaje</legend>
		<div class="_100">
			<p>
				<label for="textfield">Para</label>
				<form:input path="integranteNombre" class="required" />
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Asunto</label>
				<form:input path="asunto" class="required" />
				<form:hidden path="id" />
			</p>
		</div>
		<div class="_25">
			<p></p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Tipo</label>
				<form:input path="tipo" class="required" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Estado</label>
				<form:input path="estado" class="required" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="select">Categoria</label>
				<form:select path="categoria" multiple="false"> 
					<form:options items="${categorias}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 				
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="datepicker">Fecha de envio</label>
				<form:input path="fecha" class="required datepicker" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="datepicker">Fecha de cierre</label>
				<form:input path="fechaCierre" class="required datepicker" />
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
			<c:if test="${MENSAJE.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('mensaje');"></li>									
								</c:if>
			<c:if test="${MENSAJE.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateMensaje(${MENSAJE.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>