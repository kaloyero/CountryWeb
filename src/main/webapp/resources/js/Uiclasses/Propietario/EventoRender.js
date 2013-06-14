var EventoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    getHtml: function(data){
    },
    
    populateData: function(dataToAppend){
    	var me=this;
    	var reclamo = [{firstName: "John",lastName: "Doe"},{firstName: "topu",lastName: "Doe"},{firstName: "jaja",lastName: "Doe"
    	              		},{firstName: "jaja",lastName: "Doe"},{firstName: "jaja",lastName: "Doe"}];

    	$.get("../resources/static/templateDashboard.html", function (data) {
    		$('body').append(data);
    		me.onFinishLoading(reclamo,data,"#templMisEventos");
    	      
    	});
 
    }
});

eventoRender=new EventoRender();