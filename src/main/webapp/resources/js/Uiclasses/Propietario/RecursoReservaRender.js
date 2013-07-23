var RecursoReservaRender = new Class(
		{
			Extends : Render,
			initialize : function(name) {
				this.name = name;
				this.events = null;
			},

			populateData : function(dataToAppend) {
				this.onFinishLoading(dataToAppend);
			},

			onFinishLoading : function(dataToAppend) {
				this.cleanCanvas();
				$("#content").append(dataToAppend);
				$("body").removeClass();
				$("body")
						.addClass(
								"bd-home gridview hoverable has-sidebar basegrid-m display-fullview");

				calendarController.createCalendar(null, null, this.getCalendarConfig());
				this.bindEvents();
				this.createSources();


			},

			bindEvents : function() {
				this.bindRecursoEvents();
			},
			bindRecursoEvents : function() {
				var self=this;
				$("#recursoCombo").change(
						function() {
							var selectedRecurso = $(this).find(
									'option:selected').val();
							console.log("selectedRecurso", selectedRecurso)
							// Si selecciono algo
							if (selectedRecurso != -1){
								translator.onLoad("recurso", selectedRecurso);
								self.selectedRecurso=selectedRecurso;
							}
								

						});
			},
			load : function(data) {
				var self = this;
				self.disponibilidades = data;
				this.events = null;
				self.eventosDisponiblesAEliminar=new Array();
				$("#calendar").fullCalendar( 'refetchEvents' );
			},
			createSources : function() {
				var self =this;
				$("#calendar").fullCalendar(
						'addEventSource',
				{
							events: function(start, end, callback) {
								
								if (self.isRecursoSelected()){
									$.ajax({
										url: '../recursoReserva/diasOcupados/'+self.selectedRecurso,
										type: 'GET',
									
										success: function(doc) {
											//TODO no me conviene en realidad pintar y cambiar algun valor de los eventos disponibles ya pintados en lugar
											//de hacer todo el lio del EventAfterRender y etc?
											debugger
											callback(JSON.parse(doc), [ true ]);
										}
									});
								}
 				            },
				            color: 'yellow',   // an option!
				            textColor: 'black'		
                });

				$("#calendar").fullCalendar(
						'addEventSource',
						function(start, end, callback) {
							var translatedEvents = [];
							var eventList = self.disponibilidades;
							self.removeEvents();
							if (self.events) {
								translatedEvents = self.getTranslatedEvents(
										start, end);

							} else {
								if (eventList){ 
									self.events = JSON.parse(eventList);
									translatedEvents = self.getTranslatedEvents(start, end);
								}
							}
							console.log("EVENTOS",$('#calendar').fullCalendar('clientEvents'));
							callback(translatedEvents, [ true ]);
						});
							

			},

			removeEvents : function() {
				$("#calendar").fullCalendar('removeEvents', function(event) {

					return true;
				});
			},

			getTranslatedEvents : function(start, end) {
				var id = 2;

				var events = [];
				var self = this;
				$(self.getEvents()).each(function(index) {
					var event = self.getEvents()[index];
					var fechaDesde = new Date(start.getTime());
					var fechaHasta = new Date(start.getTime());
					fechaDesde.setDate(start.getDate() + event.dia)
					fechaDesde.setHours(event.horaIni);
					fechaHasta.setDate(start.getDate() + event.dia)
					fechaHasta.setHours(event.horaFin);

					var nuevoEvento = new Object();
					nuevoEvento.title = "Disponible";
					nuevoEvento.allDay = false;

					nuevoEvento.start = fechaDesde;
					nuevoEvento.end = fechaHasta;
					nuevoEvento.id=id;
					events.push(nuevoEvento);
					id++

				})
				return events;
			},

			getCalendarConfig : function() {
				var self=this;
				var calendarConfig = {

						         
					selectable : true,

					viewDisplay : function(view) {
						console.log("CAMBIA")
						return false;
					},
					eventRender: function(event, element) {
				        var dateFrom=event.start;
						var dateTo=event.end;
						
						//Si encuentro un evento ocupado,no deberia mostrar el evento Disponible en ese mismo lugar,guardo el id para removerlo luego
						if (event.title =="Disponible"){
							$('#calendar').fullCalendar('clientEvents', function(eventa) {
								if(eventa.start.getTime() == dateFrom.getTime() && eventa.end.getTime() == dateTo.getTime() && eventa.title!="Disponible") {
									self.eventosDisponiblesAEliminar.push(event.id);
								}
						});
						}


				    },
				    //Cuando se terminan de renderizados los eventos,recorro el Array de eventos a eliminar
				    eventAfterAllRender: function(view) {
				    	if (self.eventosDisponiblesAEliminar)
				    		for (i=0;i<self.eventosDisponiblesAEliminar.length;i++){
				    			$("#calendar").fullCalendar( 'removeEvents',self.eventosDisponiblesAEliminar[i] )
				    		}
				    	},
				
				    defaultView:"agendaWeek",
				    allDayDefault: false,
					columnFormat : {
						month : 'dddd',
						week : 'dddd',
					},
					minTime : 7,
					maxTime : 21,
					color : 'yellow',
					textColor : 'black',
					eventClick : function(calEvent, jsEvent, view) {
						
						self.onEventClick(calEvent, jsEvent, view);

					}


				};

				return calendarConfig;
			},
			getEvents : function() {
				return this.events;
			},
			onEventClick:function(calEvent, jsEvent, view){
				console.log("Evento ",calEvent, jsEvent, view);
				console.log("FEcha ", new Date (calEvent.start.getTime()))
				console.log("FEcha2 ", calEvent.start.getDate())
				console.log("Hora ", calEvent.start.getHours())
				var date = calEvent.start.getDate();
				var month = calEvent.start.getMonth() + 1; //Months are zero based
				var year = calEvent.start.getFullYear();
				var fecha=date + "-" + month + "-" + year
				
				var recursoId=$("#recursoCombo").val();
				var horaIni=calEvent.start.getHours();
				var reserva = {
					"descripcion" : "borrarCampo",
					"recursoId" : recursoId,
					"horaIni" : horaIni,
					"duracion" : 1,
					"fecha":fecha
				};
				translator.onSubmitJson('recursoReserva', reserva);
				
			},
			isRecursoSelected : function() {
				console.log("Seleccionadao",$("#recursoCombo").find('option:selected').val());
				if ($("#recursoCombo").find('option:selected').val()!=-1) return true;
					return false;
			},

		});

recursoReservaRender = new RecursoReservaRender();