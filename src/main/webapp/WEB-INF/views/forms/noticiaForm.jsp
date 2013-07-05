<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="NOTICIA" class="block-content form">

<fieldset>
		<legend>Noticia</legend>
		<div class="_50">
			<p>
				<label for="textfield">titulo</label>
				<form:input path="titulo" class="required" />
			</p>
		</div>
		<div class="_50">
			<p>
				<label for="select">Categoria</label>
				<form:select path="categoria" multiple="false"> 
					<form:options items="${categorias}" itemValue="id"
						itemLabel="nombre" /> 
				</form:select> 				
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textarea">Noticia</label>
				<form:textarea path="texto" class="required" rows="5"
					cols="40" />
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
				<label for="datepicker">Fecha</label>
				<form:input path="fecha" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="datepicker">Fecha de edicion</label>
				<form:input path="fechaDesde" class="required datepicker" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="datepicker">Fecha de cierre</label>
				<form:input path="fechaHasta" class="required datepicker" />
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
			<c:if test="${NOTICIA.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('noticia');"></li>									
								</c:if>
			<c:if test="${NOTICIA.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateNoticia(${NOTICIA.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>