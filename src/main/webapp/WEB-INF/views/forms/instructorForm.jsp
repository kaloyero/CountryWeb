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
				<form:input path="fechaComienzo" class="required" />
			</p>
		</div>
			<div class="_50">
			<p>
				<label for="textfield">Fecha hasta</label>
				<form:input path="fechaFin" class="required" />
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
			<li><input type="button" class="button" value="Crear!"
				onClick="submitInstructor()"></li>
		</ul>
	</div>
</form:form>