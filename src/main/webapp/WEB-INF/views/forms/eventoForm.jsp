<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="EVENTO" class="block-content form">

<fieldset>
		<legend>Evento</legend>
		<div class="_100">
			<p>
				<label for="textfield">Evento</label>
				<form:input path="nombre" class="required" />

				<form:hidden path="id" />
				<form:hidden path="concepto.id" />
				<form:hidden path="reservaId" />
			</p>
		</div>

		<div class="_50">
			<p>
				<c:if test="${EVENTO.id == 0}">
					<label for="textfield">Organiza: </label>
					<form:select path="personaId" multiple="false"> 
						<form:options items="${integrantes}" itemValue="id"
							itemLabel="nombre" /> 
					</form:select> 		
				</c:if>
				<c:if test="${EVENTO.id != 0}">
					<label for="textfield">Organiza: </label>
					<c:if test="${EVENTO.envioAdm==true}">
						Administrador (${EVENTO.persona.nombre} ${EVENTO.persona.apellido} - ${EVENTO.persona.nroDoc})
					</c:if>
					<c:if test="${EVENTO.envioAdm==false}">
						${EVENTO.persona.nombre} ${EVENTO.persona.apellido} - ${EVENTO.persona.nroDoc}
					</c:if>
				</c:if>				
			</p>
		</div>
		<div class="_50">
			<p>
				<c:if test="${EVENTO.id == 0}">
					<label for="textfield">Administrador: </label>
					<form:checkbox path="envioAdm" value="true"/>
				</c:if>
				<c:if test="${EVENTO.id != 0}">
					
				</c:if>				
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Recurso: </label>
				<form:select path="recurso" multiple="false" id="recursoCombo">
					<option value="-1">Seleccione un Recurso</option>
						<form:options items="${recursos}" itemValue="id"
							itemLabel="nombre" />
				</form:select>
			</p>
		</div>
		<div class="_20">
			<p>
				<label for="textfield">Cupo Mínimo: </label>
				<form:input path="cupo" class="required" />
			</p>
		</div>
		<div class="_20">
			<p>
				<label for="textfield">El dìa: </label>
				<form:input path="fecha" class="required datepicker" />
			</p>
		</div>
		<div class="_20">
			<p>
				<label for="textfield">Comienza a las</label>
				<form:select path="hourIni" multiple="false" >
					<option value="0">00</option>
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>
					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
				</form:select>
				<form:select path="minutesIni" multiple="false">
					<option value="0">00</option>
					<option value="15">15</option>
					<option value="30">30</option>
					<option value="45">45</option>

				</form:select>
			</p>
		</div>
		<div class="_20">
			<p>
				<label for="textfield">Duración</label>
				<form:input path="duracion" class="required" />
			</p>
		</div>
		<div class="_20">
			<p>
				<label for="textfield">Costo</label>
				<form:input path="concepto.importe" class="required" />
			</p>
		</div>
		<div class="_100">
			<p>
				<label for="textfield">Invitación al evento: </label>
				<form:textarea path="descripcion"  rows="3" cols="20" style="width: 100%; height: 250px;" class="required" />
			</p>
		</div>

</fieldset>

<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-right">
			<c:if test="${EVENTO.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('evento');"></li>									
								</c:if>
			<c:if test="${EVENTO.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateEvento(${EVENTO.id})"></li>									
								</c:if>
		</ul>
	</div>
</form:form>
