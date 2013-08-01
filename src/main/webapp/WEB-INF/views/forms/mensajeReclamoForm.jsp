<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="MENSAJE" class="block-content form">

<fieldset>
		<legend>Reclamo</legend>
		<div class="_100">
			<p>
				<label for="textfield">Creado por: </label>
				<c:if test="${MENSAJE.id == 0}">
					<form:select path="integrante" multiple="false"> 
						<form:options items="${integrantes}" itemValue="id"
							itemLabel="nombre" /> 
					</form:select> 		
				</c:if>
				<c:if test="${MENSAJE.id != 0}">
					<form:input path="integranteNombre"  readonly="true"/>
				</c:if>
				
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Asunto</label>
				<c:if test="${MENSAJE.id == 0}">
					<form:input path="asunto" class="required" />
				</c:if>
				<c:if test="${MENSAJE.id != 0}">
					<form:input path="asunto"  readonly="true"/>
				</c:if>
				<form:hidden path="id" />
				<form:hidden path="tipo" />
			</p>
		</div>
		<div class="_25">
			<p>
				<label for="select">Categoria</label>
				<c:if test="${MENSAJE.id == 0}">
					<form:select path="categoria" multiple="false"> 
						<form:options items="${categorias}" itemValue="id"
							itemLabel="nombre" /> 
					</form:select> 				
				</c:if>
				<c:if test="${MENSAJE.id != 0}">
					<form:input path="categoriaDescripcion"  readonly="true"/>
					<form:hidden path="categoria"  readonly="true"/>
				</c:if>
			</p>
		</div>	
		<div class="_25">
			<p>
				<c:if test="${MENSAJE.id == 0}">
					<label for="textfield"></label>
					<form:hidden path="estado" />
				</c:if>
				<c:if test="${MENSAJE.id != 0}">
					<label for="textfield">Estado</label>
					<form:input path="estado"  readonly="true"/>
				</c:if>

			</p>
		</div>
		<div class="_25">
			<p>
				<label for="datepicker">Fecha de envio</label>
				<c:if test="${MENSAJE.id == 0}">
					<form:input path="fecha" class="required datepicker" />
				</c:if>
				<c:if test="${MENSAJE.id != 0}">
					<form:input path="fecha"  readonly="true"/>
				</c:if>
			</p>
		</div>
		<div class="_25"></div>
		<div class="_100">
			<p>
				<label for="datepicker">Descripción</label>
				<form:textarea path="respuesta" class="required datepicker" />
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
				onClick="translator.onSubmit('mensajeReclamo');"></li>									
								</c:if>
			<c:if test="${MENSAJE.id != 0}">
				<li><input type="button" class="button" value="Enviar!"
				onClick="updateMensaje(${MENSAJE.id})"></li>									
			</c:if>
		</ul>
	</div>
</form:form>