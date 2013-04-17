<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INSTRUCTOR" class="block-content form">

<%@include file="personaForm.jsp" %>

<fieldset>
		<legend>Instructor</legend>
		<div class="_50">
			<p>
				<label for="textfield">Fecha desde</label>
				<form:input path="fechaComienzo" class="required datepicker" />
			</p>
		</div>
			<div class="_50">
			<p>
				<label for="textfield">Fecha hasta</label>
				<form:input path="fechaFin" class="required datepicker" />
			</p>
		</div>
		
</fieldset>
	<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Limpiar</a></li>
		</ul>
		<ul class="actions-right">
			<c:if test="${INSTRUCTOR.id == 0}">
				<li><input type="button" class="button" value="Crear!"
				onClick="translator.onSubmit('instructor');"></li>
								</c:if>
			<c:if test="${INSTRUCTOR.id != 0}">
				<li><input type="button" class="button" value="Guardar!"
				onClick="updateInstructor(${INSTRUCTOR.id})"></li>									
			</c:if>
		</ul>
		
	</div>
</form:form>