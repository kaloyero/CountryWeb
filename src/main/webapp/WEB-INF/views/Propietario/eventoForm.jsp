<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>
<%-- <form:form commandName="EVENTO" class="block-content form">

<fieldset>
		<legend>Evento</legend>

		
</fieldset>

<div class="clear"></div>
	<div class="block-actions">
		<ul class="actions-left">
			<li><a class="button red" id="reset-validate-form"
				href="javascript:void(0);">Reset</a></li>
		</ul>
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
</form:form> --%>
<div id="evento_nuevo" class="formulario">
					<div id="ja-message">
						<div id="system-message-container"></div>
					</div>
					<!-- MAIN CONTENT -->
					<div id="content">
						<div class="inner content-inner clearfix">
							<!-- K2 user register form -->
							<form:form commandName="EVENTO" class="formulario form-validate">
							
								<div class="componentheading">Nuevo Evento</div>
								<div id="k2Container" class="k2AccountPage">
									<div class="wheader k2ProfileHeading">Detalles</div>
									<div class="wcgroup">
										<label class="wlabel" id="namemsg" for="name">Titulo</label>
										<div class="wcontrols">
										<form:input path="nombre" size="40" class="inputbox required validate-email" maxlength="100" aria-required="true" required="required"/>
										</div>
									</div>
								
									<div class="wcgroup">
										<label class="wlabel" id="emailmsg" for="email">
											Fecha del Evento:</label>
										<form:input path="fecha" size="40" class="inputbox required validate-email"  maxlength="100" aria-required="true"/>
											
								
									</div>
									<div class="wcgroup">
										<label class="wlabel" id="emailmsg" for="email">
											Horario inicial:</label>
										<div class="wcontrols">
										<form:input path="hourIni" size="40" class="inputbox required validate-email"  maxlength="100" aria-required="true"/>
										
										</div>
										<label class="wlabel" id="emailmsg" for="email">
											Duracion:</label>
										<div class="wcontrols">
										<form:input path="duracion" size="40" class="inputbox required validate-email" maxlength="100" aria-required="true" required="required"/>
										
										</div>
										<div class="wcontrols">
										<label class="wlabel" id="emailmsg" for="email">
											Cupo minimo:</label>
										<form:input path="cupo" size="40" class="inputbox required validate-email" maxlength="100" aria-required="true" required="required"/>
											<div class="wcgroup"><b><font color="blue">
										<label for="select">Recurso necesario:</label> </font></b>
										<input id="recursoElegido" disabled='true' name="recursoElegido" class="inputbox required validate-email" aria-required="true" type="text" value="" size="40" maxlength="100">
										<b><font color="blue"><label class="wlabel" id="emailmsg" for="email">
											Horario:</label></font></b>
										<input id="horarioRecursoElegido" disabled='true' name="horarioRecursoElegido" class="inputbox required validate-email" aria-required="true" type="text" value="" size="40" maxlength="100">

									<form:input path="reserva.recursoId" class="idRecursoReserva" type ="hidden" />
											
										<form:input path="reserva.horaIni"  type ="hidden" />
										<form:input path="reserva.duracion" type ="hidden" />
										<form:input path="reserva.fecha" type ="hidden" />
										<form:input path="reserva.minutosIni"  type ="hidden" />
										
									
										
																										
									<input type="button" class="button" value="Reserve un recurso desde aqui de ser necesario" id="showDisponibilidades">
									
									</div>
										</div>
									</div>
									<div class="wheader k2ProfileHeading">Descripcion</div>
									<!-- K2 attached fields -->
									<div class="wcgroup">
										<label class="wlabel" id="descriptionmsg" for="description">Conta
											bien la idea para que los demas se unan!</label>
										<div class="wcontrols">
										<form:textarea path="descripcion"  rows="3" cols="20" style="width: 100%; height: 250px;" class="mce_editable" aria-hidden="true" />
					
										</span>
										</div>
									</div>
									<!-- Joomla! 1.6+ JForm implementation -->
									<div class="k2AccountPageUpdate">
									<input type="button" class="button" value="Crear evento" onclick="translator.onSubmit('evento');">
									</div>
								</div>
								
</form:form>						</div>
					</div>
					<!-- // MAIN CONTENT -->
					<!-- ASIDE -->
					<div id="aside">
						<div class="inner aside-inner cols-3 clearfix masonry" style="position: relative; height: 304px;">
							<div class="col aside-col aside-col-1 masonry-brick" style="position: absolute; top: 20px; left: 10px; width: 216px;">
								<div class="moduletable moduletable" id="Mod48">
									<div class="inner moduletable-inner clearfix">
										<h3>
											<span>Atencion!</span>
										</h3>
										<div class="box-ct clearfix">
											<div class="custom">
												<p>Desde aqui podras crear un evento,el cual estara
													visible para todo el barrio</p>
											</div>
										</div>
									</div>
									&nbsp; &nbsp;
								</div>
							</div>
							<div class="col aside-col aside-col-2 masonry-brick" style="position: absolute; top: 20px; left: 226px; width: 216px;">
								<div class="moduletable moduletable blue" id="Mod44">
									<div class="inner moduletable-inner clearfix">
										<h3>
											<span>Login</span>
										</h3>
										<div class="box-ct clearfix">
											<form action="/ja_wall/default/pages/registration-form.html" method="post" id="login-form">
												<fieldset class="userdata">
													<p id="form-login-username">
														<label for="modlgn-username">User Name</label> <input id="modlgn-username" type="text" name="username" class="inputbox" size="18">
													</p>
													<p id="form-login-password">
														<label for="modlgn-passwd">Password</label> <input id="modlgn-passwd" type="password" name="password" class="inputbox" size="18">
													</p>
													<p id="form-login-remember">
														<label for="modlgn-remember">Remember Me</label> <input id="modlgn-remember" type="checkbox" name="remember" class="inputbox" value="yes">
													</p>
													<input type="submit" name="Submit" class="button" value="Log in"> <input type="hidden" name="option" value="com_users"> <input type="hidden" name="task" value="user.login"> <input type="hidden" name="return" value="aW5kZXgucGhwP2Zvcm1hdD1odG1sJm9wdGlvbj1jb21fdXNlcnMmdmlldz1yZWdpc3RyYXRpb24mSXRlbWlkPTQwNQ==">
													<input type="hidden" name="ad65911ba01c4bde8bdf6f13143c91f0" value="1">
												</fieldset>
												<ul>
													<li><a href="/ja_wall/default/pages/password-reset1.html">
															Forgot your password?</a></li>
													<li><a href="/ja_wall/default/pages/username-reminder.html">
															Forgot your username?</a></li>
													<li><a href="/ja_wall/default/pages/registration-form.html">
															Create an account</a></li>
												</ul>
											</form>
										</div>
									</div>
									&nbsp; &nbsp;
								</div>
							</div>
							<div class="col aside-col aside-col-3 masonry-brick" style="position: absolute; top: 175px; left: 10px; width: 216px;">
								<div class="moduletable moduletable bg_yellow" id="Mod39">
									<div class="inner moduletable-inner clearfix">
										<h3>
											<span>Totales</span>
										</h3>
										<div class="box-ct clearfix">
											<p>Tenes 2 eventos creados en el mes</p>
										</div>
									</div>
									&nbsp; &nbsp;
								</div>
							</div>
							<div id="base-blank-item" class="col masonry-brick" style="height: 0px; visibility: hidden; position: absolute; top: 294px; left: 10px;"></div>
						</div>
					</div>
					<!-- // ASIDE -->
				</div>
				<div class="tileContent">
  <div id="disponibilidadesPanel"   style="width: 800px; height: 800px; padding: 0.4em; position: relative;display:none;" >

  </div>

  </div>
