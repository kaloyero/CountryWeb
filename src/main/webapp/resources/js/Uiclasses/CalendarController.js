var Calendarcontroller = new Class({
    initialize: function(name){
       
    },
    
    createCalendar: function(form,callbackEventSource){
        
    	var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		
		var calendarConfig ={
		
			selectable: true,
			select: function(start, end, allDay) {
			    	/*
			    	$('#calendar').fullCalendar("columnFormat",{
		                month: 'dddd',    // Monday, Wednesday, etc
		                week: 'dddd, MMM dS', // Monday 9/7
		                day: 'dddd, MMM dS'  // Monday 9/7
		            })*/

			    	 end.setHours(end.getHours()+1);
			    	 end.setMinutes(0);
						this.calendar.renderEvent(
							{
								title: "",
								start: start,
								end: end,
								allDay: allDay
							},
							true // make the event "stick"
						);

				},
		   defaultView: 'agendaWeek',
				 columnFormat: {
					 month: 'dddd',    // Monday, Wednesday, etc
		             week: 'dddd', // Monday 9/7
		               // day: 'dddd, MMM dS'  // Monday 9/7
					},
					firstHour: 6,
			        color: 'yellow',  
			        textColor: 'black' 
			    
	    };
		this.setCalendar(form,calendarConfig);
		this.bindCalendarEvents(form,callbackEventSource)
	   
    	},
    
    bindCalendarEvents: function(form,callbackEventSource){
    	
    	this.getCalendarPlaceHolder(form).fullCalendar( 'addEventSource',   
 			   function(start, end, callback) {
 	    			callbackEventSource(start, end, callback);
 	    });
    },
    
    getCalendar: function(form){
    	return $(form).find("#calendar");
    },
    
    getCalendarPlaceHolder: function(form){
    	return $(form).find("#calendar");
    },
    
    setCalendar: function(form,config){
    	$(form).find("#calendar").fullCalendar(config);
    }   
  
});

calendarController=new Calendarcontroller();