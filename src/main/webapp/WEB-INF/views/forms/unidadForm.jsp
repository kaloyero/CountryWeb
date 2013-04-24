<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="UNIDAD" class="block-content form">
	
	 <p></p>
	
	<fieldset>
		<legend>Unidad General</legend>
		<div class="_25">
			<p>
				<label for="textfield">Codigo</label>
				<form:input path="code" class="required" />
			</p>
		</div>

		<div class="_100">
			<p>
				<label for="textarea">Descripcion</label>
				<form:textarea path="descripcion" class="required" rows="3"
					cols="40" />
			</p>
		</div>
		<div class="_100">
			<table id="integrantesUnidad" class="table active-table">
				<thead>
					<tr>
						<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Nombre</th>
						<th class="sorting" rowspan="1" colspan="1" style="width: 203px;">Documento</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="integrante" items="${integrantes}">
						<tr>
							<td>
									${integrante.persona.nombre} ${integrante.persona.apellido}
							</td>
							<td>
									${integrante.persona.tipoDoc.nombre} ${integrante.persona.nroDoc}
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
</fieldset>


	<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Reset</a></li>
		</ul>
		<ul class="actions-right">
		</ul>
		<ul class="actions-right">
			<c:if test="${UNIDAD.id == 0}">
			<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('unidad')"></li>
								</c:if>
			<c:if test="${UNIDAD.id != 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="updateUnidad(${UNIDAD.id})"></li>									
								</c:if>
		</ul>
		
		
	</div>
</form:form>