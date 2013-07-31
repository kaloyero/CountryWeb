<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<p>
	<label for="datepicker">Agregar Telefono</label>
	<div>
		<ul class="block-list">	
			<li>
				<div class="_25">
					<select id="telContact"> 
						<c:forEach var="tel" items="${tipoTelefono}">
							<option value="${tel.id}">${tel.nombre}</option>
						</c:forEach>
					</select> 				
				</div>
				<div class="_10">
					<input type="text" class=""  id="telCountry" placeholder="Pais" size="50%" maxlength="6" />
				</div>
				<div class="_10">
					<input type="text" class="" id="telState" placeholder="Ciudad" size="25%" maxlength="5"/>
				</div>
				<div class="_15">
					<input type="text" class=""  id="telPrefijo" placeholder="Prefijo" size="50%" maxlength="6" />
				</div>
				<div class="_25">
					<input type="text" class="" id="telNumber" placeholder="numero" size="25%" maxlength="16"/>
				</div>
				<div class="_10">
					<input type="button" id="addPhone" value="+" />
				</div>
			</li>
		</ul>
	</div>	
</p>