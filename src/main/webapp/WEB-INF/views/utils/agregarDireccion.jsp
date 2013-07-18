<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<p>
	<label for="datepicker">Agregar Direccion</label>
	<div>
		<ul class="block-list">	
			<li>
				<div class="_25">
					<select id="telContact"> 
						<c:forEach var="loc" items="${localidades}">
							<option value="${loc.id}">${loc.name}</option>
						</c:forEach>
					</select> 				
				</div>
				<div class="_50">
					<input type="text" class=""  id="dirStreetName" placeholder="Nombre de la calle" size="35%" maxlength="80" />
				</div>
				<div class="_15">
					<input type="text" class="" id="dirStreetNum" placeholder="Numero" size="10%" maxlength="6"/>
				</div>
				<div class="_10">
				</div>
			</li>
			<li>
				<div class="_25">
					<label> </label> 
				</div>
				<div class="_15">
					<input type="text" class="" id="dirFloor" placeholder="Piso" size="10%" maxlength="16"/>
				</div>
				<div class="_15">
					<input type="text" class=""  id="dirFlat" placeholder="Dpto" size="10%" maxlength="6" />
				</div>
				<div class="_15">
					<input type="text" class=""  id="dirTower" placeholder="Torre" size="10%" maxlength="6" />
				</div>
				<div class="_15">
					<input type="text" class=""  id="dirBlock" placeholder="Bloque" size="10%" maxlength="6" />
				</div>
				<div class="_5">
					<label> </label> 
				</div>
				<div class="_10">
					<input type="button" id="addPhone" value="+" />
				</div>
				
			</li>
		</ul>
	</div>
</p>

