var RecursoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    draw: function(){
    	var form=this.getAddForm();
    	this.createCalendarComponent(form);
    },
    onNewTab: function(){
    	var form=this.getActiveForm();
    	this.createCalendarComponent(form);
    	var obj = JSON.parse($(form).find("#disponibilidades").attr("value"));
    	//var obj = JSON.parse('{"hello":"world"}');
    	//var obj = JSON.parse('[{"Dia": 0, "horaIni": 1,"horaFin": 1},{"Dia": 0, "horaIni": 1,"horaFin": 1}] ');
    	
    	//var str=$(form).find("#jsonTest").attr("value");
    	//var obj="{Dia: this.start.getDay(), horaIni: this.start.getHours(),horaFin: this.end.getHours()} "
    	console.log("OBBJ",obj);
    },

    createCalendarComponent: function(form){
    	
    	var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
    	var self=this;
		$(form).find("#calendar").fullCalendar({
			eventRender: function(event, element) {
				console.log("ENTRA")
			      element.bind('dblclick', function() {
			    	  event.backgroundColor = 'red';
			    	    //$('#calendar').fullCalendar( 'rerenderEvents' );
			    	    $('#calendar').fullCalendar( 'updateEvent',event );

			      });
			   },
//			 dayClick: function() {
//				 var myEvent = {
//						  title:"my new event",
//						  allDay: false,
//						  start: new Date(),
//						  end: new Date()
//						};
//				 console.log("arguments",arguments)
//				 $('#calendar').fullCalendar( 'renderEvent', myEvent );
//				 console.log($('#calendar').fullCalendar( 'clientEvents'));
//			    },
			selectable: true,
			select: function(start, end, allDay) {
			    	
			    	
			    	$('#calendar').fullCalendar("columnFormat",{
		                month: 'dddd',    // Monday, Wednesday, etc
		                week: 'dddd, MMM dS', // Monday 9/7
		                day: 'dddd, MMM dS'  // Monday 9/7
		            })
		            
		            //$('#calendar').fullCalendar( 'destroy' );
			    	//$('#calendar').fullCalendar('render');

			    	 end.setHours(end.getHours()+1);
			    	 end.setMinutes(0);
					//var title = prompt('Event Title:');
					//if (title) {
						$('#calendar').fullCalendar('renderEvent',
							{
								title: "",
								start: start,
								end: end,
								allDay: allDay
							},
							true // make the event "stick"
						);
					//}

				},
				 defaultView: 'agendaWeek',
				 columnFormat: {
					 month: 'dddd',    // Monday, Wednesday, etc
		                week: 'dddd', // Monday 9/7
		               // day: 'dddd, MMM dS'  // Monday 9/7
					},
					firstHour: 6,
					events: [
			            {
			                title: 'Event1',
			                start: new Date(y, m, d , 16, 0),
			                end: new Date(y, m, d , 17, 0),
			                allDay: false

			                	
			            },
			            {
			            	 title: 'Event1',
				             start: new Date(y, m, d+1 , 16, 0),
				             end: new Date(y, m, d+1 , 17, 0),
				             allDay: false
			            }
			            // etc...
			        ],
			        color: 'yellow',   // an option!
			        textColor: 'black' // an option!
			    
	    })
	    
	   
	    $('#calendar').fullCalendar( 'addEventSource',   
        function(start, end, callback) {
	    		//console.log("ADD", $('#calendar').fullCalendar())
	    	var events = [];
	    	var form=self.getAddForm();
	     	var eventList =self.getListEvents(form);
	     	console.log("Eventa ",eventList)
	    	//var fecha =new Date(start.getFullYear(), start.getMonth(), start.getDate()+1,8,4)
	     	var today=new Date();
	     
	     	
	     	//Si no esta dentro de la primera semana,que haga la copia de los eventos,sino,quedarian duplicados
	     	if (!(today > start && today < end)){
	     	
	     	$(eventList).each(function(index) {
	     		console.log("CORA",this)

	    		//var nextWeekStart = new Date(this.start.getTime() + 7 * 24 * 60 * 60 * 1000);
	     		var nextWeekStart=this.start;
	     		nextWeekStart.
	     		nextWeekStart.setHours(this.start.getHours())
	     		//var nextWeekEnd = new Date(this.end.getTime() + 7 * 24 * 60 * 60 * 1000);
	     		nextWeekEnd.setHours(this.end.getHours())
	    		var nuevoEvento=new Object();
	     		nuevoEvento.title="PPUT";
	     		nuevoEvento.allDay=false;
	     		
	     		nuevoEvento.start=nextWeekStart;
	     		nuevoEvento.end=nextWeekEnd;
	    		events.push(nuevoEvento);
	    	})
	     	}
	     	//events.push({
               //  title: 'It\'s the middle of the week!',
               //  start: fecha,
                // stick:true
                 //start :'2013-05-5'
            // });
	     	// $('#calendar').fullCalendar('renderEvent',{
                // title: 'It\'s the middle of the week!',
                // start: fecha
                 //start :'2013-05-5'
             //},true )
	    	callback( events,[true] );
	    	}
)
    },
    
    onSubmit: function(){
    	var disponibilidadesJson = [];
    	var html = [];
    	var form=this.getActiveForm();
    	var eventList =this.getListEvents(form);
    	console.log("EVENTOS ",eventList)
    	
    	$(eventList).each(function(index) {
    		disponibilidadesJson.push({"Dia": this.start.getDay(), "horaIni": this.start.getHours(),"horaFin": this.end.getHours()});
    	})
    	
    	var disponibilidadesText = JSON.stringify(disponibilidadesJson);
    	html.push("<input type=hidden id=testa  name='jsonTest' value="+disponibilidadesText+">")
    	form.append(html.join(''));
    	//return form;
    },
    
    getListEvents: function(form){
    	return $(form).find("#calendar").fullCalendar( 'clientEvents')
    }
    
});

recursoRender=new RecursoRender();