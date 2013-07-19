<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="AVISO" class="block-content form">

<fieldset>
		<legend>Aviso</legend>
		<div class="_50">
			<p>
				<label for="textfield">titulo</label>
				<form:input path="titulo" class="required" />
			</p>
		</div>
		<div class="_50"></div>
		<div class="_25">
			<p>
				<label for="select">Categoria</label>
				<form:select path="categoria" multiple="false"> 
					<form:options items="${categorias}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 				
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Fecha Publicacion</label>
				<form:input path="fecha" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="textfield">Fecha Cierre</label>
				<form:input path="fechaCierre" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
		
		</div>
		
		
		<div class="_100">
			<p>
				<label for="textarea">Encabezado</label>
				<form:textarea path="encabezado" class="required" rows="1"
					cols="40" />
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textarea">Cuerpo</label>
				<form:textarea path="cuerpo" class="required" rows="5"
					cols="40" />
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textarea">Cierre</label>
				<form:textarea path="cierre" class="required" rows="1"
					cols="40" />
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
			<c:if test="${AVISO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('aviso');"></li>									
								</c:if>
			<c:if test="${AVISO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateAviso(${AVISO.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>