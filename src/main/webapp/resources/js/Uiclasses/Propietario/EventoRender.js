var EventoRender = new Class(
		{
			Extends : Render,
			initialize : function(name) {
				this.name = name;
			},

			populateData : function(dataToAppend) {
				this.onFinishLoading(dataToAppend);
			},
			load : function(dataToAppend) {
				this.cleanCanvas();
				$("body").removeClass();
				$("body").addClass("has-sidebar has-aside");
				// $(".corner-stamp").remove()
				$("#mainbody").prepend(dataToAppend);
				this.bindEventsForNew();
			},

			onFinishLoading : function(dataToAppend) {
				var self=this;
				this.cleanCanvas();
				$("#content").append(dataToAppend);
				$("body").removeClass();

				$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview");
				jQuery(".corner-stamp").load('../resources/static/corner.html',function(){
    				createEffect();
    				self.bindEvents();

    			});

			},
			bindEvents : function() {
				$(".anotarseEvento").click(
						function() {
							var eventoParticipar = {
								"evento" : $(this).find("input").val()
							};
							//Remuevo por si ya agregue un htl con el div del dialogo
				        	dialogRender.create({onAccept:function(){translator.onSubmitJson('eventoParticipar',eventoParticipar)}});

				
						});

			},
			bindEventsForNew : function() {

				$('#fecha').datepicker({
					dateFormat : 'dd-mm-yy'
				});

			}
		});

eventoRender = new EventoRender();