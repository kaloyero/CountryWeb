<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






	<div class="canvas">


<div >
			<p>
				<label for="select">Recursos</label>
				<form:select path="recursos" multiple="false" id="recursoCombo" class="recursoCombo">
				   <option value="-1">Seleccione un Recurso</option>
					<form:options items="${recursos}" itemValue="id"
						itemLabel="nombre" />
						
				</form:select>
				<div id="importeRecurso"></div>
			</p>
		</div>
		
		
<div id='calendar'></div>

</div>


