var RecursoReservaRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
        this.events=null;
    },

    
    populateData: function(dataToAppend){
    		this.onFinishLoading(dataToAppend);
    },
   
    onFinishLoading : function(dataToAppend){
    	this.cleanCanvas();
    	$("#content").append(dataToAppend);
    	$("body").removeClass();
    	$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview");
	
    	calendarController.createCalendar(null,null,this.getCalendarConfig());
    	this.bindEvents();
	
    },

    bindEvents : function(){
    	this.bindRecursoEvents();
    },
    bindRecursoEvents : function(){
    	$("#recursoCombo").change(function() {
    		  var selectedRecurso=$(this).find('option:selected').val();
    		  //Si selecciono algo
    		  if (selectedRecurso!=-1)
    			  translator.onLoad("recurso",selectedRecurso)
    	
    });
    },
    load : function(data){
    	
        var disponibilidades=$(data).find("#recursoDis")[0].value;
       //TODO tal vez lo mejor seria tener una llamada que nos devuelva JSON para no hacer lo de arriba
        
    	var self=this;
    	this.events=null;
    	$("#calendar").fullCalendar( 'addEventSource',   
  			   function(start, end, callback) {
  	    	    	var translatedEvents=[];
  	    	     	var eventList =disponibilidades;
  	    	     	
  	    	     	//console.log("ADDEVENTSOURCE",eventList);
  	    	     	self.removeEvents();
  	    	     	if (self.events) {
  	    	     		translatedEvents=self.getTranslatedEvents(start,end);  	    	     	
  	    	    		
  	    	     	}else{
  	    	     		self.events=JSON.parse(eventList);
  	    	     		//console.log("EVENTOS",self.events)
  	    	     		translatedEvents=self.getTranslatedEvents(start,end);
  	    	     	}
  	    
  	    	    	callback( translatedEvents,[true] );
  	    });
    	
    	
    	
    	
    	//console.log("LOADDDD",data)
    },
    
    removeEvents:function(){
    	$("#calendar").fullCalendar( 'removeEvents', function(event) {
	     	    
   	        return true;
   	}); 
    },
    
    getTranslatedEvents:function(start,end){
    	var events = [];
    	var self=this;
    	$(self.getEvents()).each(function(index) {
    		console.log("EVENTOrrr",index)
    		
    		var event=self.getEvents()[index];
    		var fechaDesde= new Date(start.getTime());
       		var fechaHasta= new Date(start.getTime());

           	fechaDesde.setDate(start.getDate() +event.dia)
           	fechaDesde.setHours(event.horaIni);
           	fechaHasta.setDate(start.getDate() +event.dia)
           	fechaHasta.setHours(event.horaFin);


           	
      		var nuevoEvento=new Object();
       		nuevoEvento.title="Disponible";
       		nuevoEvento.allDay=false;
       		
       		nuevoEvento.start=fechaDesde;
       		nuevoEvento.end=fechaHasta;
       		events.push(nuevoEvento);

    	}
    	)

    
   	
   		return events
    },
    
    getCalendarConfig:function(){
    	
    	var calendarConfig ={
    			selectable: true,

    			viewDisplay: function(view) {
    					console.log("CAMBIA")
    					return false;
    			},
    		   defaultView: 'agendaWeek',
    		   columnFormat: {
    					  	month: 'dddd',   
    					  	week: 'dddd', 
    						},
    		   minTime: 7,
    		   maxTime: 21,
    		   color: 'yellow',  
    		   textColor: 'black' 
    			    
    	    };
    	
    	return calendarConfig;
    },
    getEvents:function(){
    	return this.events;
    }
    
});

recursoReservaRender=new RecursoReservaRender();