<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p></p>

<div id="reclamo_nuevo" class="formulario">
									<div id="ja-message">
						<div id="system-message-container"></div>
					</div>
					<!-- MAIN CONTENT -->
					<div id="content">
						<div class="inner content-inner clearfix">
							<!-- K2 user register form -->
							<form:form commandName="MENSAJE" class="formulario form-validate">
							
								<div class="componentheading">Nuevo Reclamo</div>
								<div id="k2Container" class="k2AccountPage">
									<div class="wheader k2ProfileHeading">Detalles</div>
									<div class="wcgroup">
										<label class="wlabel" id="namemsg" for="name">Titulo</label>
										<div class="wcontrols">
										<form:input path="asunto" size="40" class="inputbox required validate-email" maxlength="100" aria-required="true" required="required"/>
										</div>
									</div>
									
									<div class="wcgroup">
										<label class="wlabel" id="emailmsg" for="email">
											Categoria:</label>
										<div class="wcontrols">
										<form:select path="categoria" multiple="false"> 
											<form:options items="${categorias}" itemValue="id" itemLabel="nombre" /> 
									</form:select>
									</div>
									</div>

									<div class="wheader k2ProfileHeading">Descripcion</div>
									<!-- K2 attached fields -->
									<div class="wcgroup">
										<label class="wlabel" id="descriptionmsg" for="description">De que se trata tu Reclamo?</label>
										<div class="wcontrols">
										<form:textarea path="respuesta"  rows="3" cols="20" style="width: 100%; height: 250px;" class="mce_editable" aria-hidden="true" />
					
										</span>
										</div>
									</div>
									<!-- Joomla! 1.6+ JForm implementation -->
									<div class="k2AccountPageUpdate">
										<input type="button" class="button" value="Crear reclamo" onclick="translator.onSubmit('mensaje');">
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