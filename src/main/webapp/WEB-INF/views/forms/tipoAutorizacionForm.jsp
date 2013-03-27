<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<form:form commandName="TIPO" class="block-content form">

<fieldset>
		<legend>Configuracion</legend>

		<%@ include file="tipoForm.jsp" %>		
</fieldset>




</form:form>