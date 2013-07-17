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

				calendarController.createCalendar(null, null, this
						.getCalendarConfig());
				this.bindEvents();

			},

			bindEvents : function() {
				this.bindRecursoEvents();
			},
			bindRecursoEvents : function() {
				$("#recursoCombo").change(
						function() {
							var selectedRecurso = $(this).find(
									'option:selected').val();
							console.log("selectedRecurso", selectedRecurso)
							// Si selecciono algo
							if (selectedRecurso != -1)
								translator.onLoad("recurso", selectedRecurso)

						});
			},
			load : function(data) {
				// var disponibilidades=$(data).find("#recursoDis")[0].value;
				var disponibilidades = data

				var self = this;
				this.events = null;
				$("#calendar").fullCalendar(
						'addEventSource',
						function(start, end, callback) {
							var translatedEvents = [];
							var eventList = disponibilidades;
							self.removeEvents();
							if (self.events) {
								translatedEvents = self.getTranslatedEvents(
										start, end);

							} else {
								self.events = JSON.parse(eventList);
								translatedEvents = self.getTranslatedEvents(
										start, end);
							}

							callback(translatedEvents, [ true ]);
						});

			},

			removeEvents : function() {
				$("#calendar").fullCalendar('removeEvents', function(event) {

					return true;
				});
			},

			getTranslatedEvents : function(start, end) {
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
					events.push(nuevoEvento);

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
					defaultView : 'agendaWeek',
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
				var date = calEvent.start.getDate();
				var month = calEvent.start.getMonth() + 1; //Months are zero based
				var year = calEvent.start.getFullYear();
				var fecha=year + "-" + month + "-" + date
				var reserva = {
					"descripcion" : "mierda",
					"recursoId" : 1,
					"horaIni" : 1,
					"duracion" : 1,
					"fecha":fecha
				};
				translator.onSubmitJson('recursoReserva', reserva);
				
			}

		});

recursoReservaRender = new RecursoReservaRender();