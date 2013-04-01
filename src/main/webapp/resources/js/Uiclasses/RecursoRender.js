var RecursoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    draw: function(){
    	var form=this.getAddForm();
    	this.createCalendarComponent(form);
    	//this.bindEvents();
    	this.hideCalendarHeader();
    },
    onNewTab: function(){
    	var form=this.getActiveForm();
    	this.createCalendarComponent(form);
    	var obj = JSON.parse($(form).find("#disponibilidades").attr("value"));
    	console.log("OBBJ",obj);
    },
   
    bindEvents: function(){
    	var self=this
    	$("#dis").bind('click', function() {
    			self.toogleSelection("dis");
    			$("#calendar").fullCalendar( 'rerenderEvents' )
	      });
    	
    	$("#exc").bind('click', function() {
			self.toogleSelection("exc");
			$("#calendar").fullCalendar( 'rerenderEvents' )
      });
    },
    
    toogleSelection:function(selection){
    	if (selection =="dis"){
    		this.uncheckException();
    		this.hideCalendarHeader();

    	}else{
    		this.uncheckDisponibilidad();
    		this.showCalendarHeader();
    	}

    },
    
    uncheckException:function(){
    	$("#exc").attr('checked', false)
    },
    
    uncheckDisponibilidad:function(){
    	$("#dis").attr('checked', false)
    },
    
    
    hideCalendarHeader:function(){
    	$(".fc-header").hide()
    },
    
    showCalendarHeader:function(){
    	$(".fc-header").show()
    },
    
    createCalendarComponent: function(form){
    	var me=this;
    	calendarController.createCalendar(form,function(start, end, callback){me.populateExistingEvents(start, end, callback);});
    },
    
    /*Cargar eventos del recurso antes de mostrar*/
    populateExistingEvents: function(start, end, callback){
    	
    	var self=this;
    	var events = [];
    	var form=self.getAddForm();
     	var eventList =self.getListEvents(form);
     	
     	console.log("ADDEVENTSOURCE",eventList);
     
     	$(eventList).each(function(index) {

     		console.log("START ",start)
     		
     		var nextWeekStart= new Date(start.getTime());
     		var dia=this.start.getDay();
     		console.log("DIA ",dia)
     		console.log("DATE ",start)
     		console.log("GetDate",this.start.getDate())
     		console.log("TOTAL ",this.start.getDate() + dia)
     		console.log("ANTES",nextWeekStart)
     		nextWeekStart.setDate(start.getDate()+dia)
     		nextWeekStart.setHours(this.start.getHours())
     		var nextWeekEnd = new Date(start.getTime());
     		
     		nextWeekEnd.setDate(start.getDate()+dia)
     		nextWeekEnd.setHours(this.end.getHours())
    		var nuevoEvento=new Object();
     		nuevoEvento.title="PPUT";
     		nuevoEvento.allDay=false;
     		
     		nuevoEvento.start=nextWeekStart;
     		nuevoEvento.end=nextWeekEnd;
     		
     		console.log("DATENE",nextWeekStart)
     	    console.log("DATEEND",nextWeekEnd)
    		events.push(nuevoEvento);
    	})
 
    	callback( events,[true] );
    	
    },
    
    getListEvents: function(form){
    	return $(form).find("#calendar").fullCalendar( 'clientEvents')
    },
    
    onSubmit: function(){
    	var disponibilidades = [];
    	var html = [];
    	var form=this.getActiveForm();
    	var eventList =this.getListEvents(form);
    	
    	
    	$(eventList).each(function(index) {
    		disponibilidades.push({"Dia": this.start.getDay(), "horaIni": this.start.getHours(),"horaFin": this.end.getHours()});
    	})
    	
    	var disponibilidadesText = JSON.stringify(disponibilidades);
    	var disponibilidadesText="OLA"
    	html.push("<input type=hidden id=puto  name='disponibilidades' value='ola'>")
    	form.append(html.join(''));
    	console.log("EVENTOS ",disponibilidadesText)
    	return form;
    }
    
});

recursoRender=new RecursoRender();