<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="INTEGRANTE" class="block-content form">

<%@include file="personaForm.jsp" %>


<fieldset>
		<legend>Integrante</legend>
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
			<c:if test="${ empty INTEGRANTE.id }">
				<li><input type="button" class="button" value="Crear!"
				onClick="submitIntegrante()"></li>									
								</c:if>
			<c:if test="${ not empty INTEGRANTE.id }">
				<li><input type="button" class="button" value="Crear!"
				onClick="updateIntegrante(${INTEGRANTE.id})"></li>									
								</c:if>
		</ul>
		
	</div>
</form:form>