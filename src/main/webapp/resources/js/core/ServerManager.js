var ServerManager = new Class({
    initialize: function(name){
        this.name = name;
        this.services={};
        this.services['actividad']={};
        this.services['instructor']={};
        this.services['unidad']={};
        this.services['integrante']={};
        this.services['concepto']={};
        this.services['recurso']={};
        this.services['vehiculo']={};
        this.services['mascota']={};
        this.services['actividad']["load"]="/CountryWeb/actividad/load/";
        this.services['actividad']["save"]="/CountryWeb/actividad/create/";
        this.services['instructor']["load"]="/CountryWeb/instructor/load/";
        this.services['instructor']["save"]="/CountryWeb/instructor/create/";
        this.services['unidad']["load"]="/CountryWeb/unidad/load/";
        this.services['unidad']["save"]="/CountryWeb/unidad/create/";
        this.services['integrante']["load"]="/CountryWeb/integrante/load/";
        this.services['integrante']["save"]="/CountryWeb/integrante/create/"
        this.services['concepto']["load"]="/CountryWeb/concepto/load/";
        this.services['concepto']["save"]="/CountryWeb/concepto/create/"
        this.services['recurso']["load"]="/CountryWeb/recurso/load/";
        this.services['recurso']["save"]="/CountryWeb/recurso/create/"
        this.services['vehiculo']["load"]="/CountryWeb/vehiculo/load/";
        this.services['vehiculo']["save"]="/CountryWeb/vehiculo/create/"
        this.services['mascota']["load"]="/CountryWeb/mascota/load/";
        this.services['mascota']["save"]="/CountryWeb/mascota/create/"

    },
 

    get: function(config){

    	var self=this;
    	$.ajax({
			type: 'GET',
			url: self.services[config.object]["load"]+config.objectId,
			success: function(data) {
				
				config.onSuccess(data);
			}
		});
    },
   
    save: function(config){
    	var self=this;

    	$.ajax( {
		      type: "POST",
		      url: self.services[config.object]["save"],
		      data: config.form.serialize(),
		      success: function(data) {
		    	  config.onSuccess(data);
				}
		    } );
    },
    
    update: function(config){
    	var self=this;

    	$.ajax( {
		      type: "POST",
		      url: self.services[config.object]["load"]+config.objectId,
		      data: config.form.serialize(),
		      success: function(data) {
		    	  config.onSuccess(data);
				}
		    } );
    },   
    show: function(config){
    	var self=this;
    	$.ajax({
    		type: 'GET',
    		url: self.services[config.object]["save"],
    		success: function(data) {
    			config.onSuccess(data);	
    		}
    	});
    }
   
});

serverManager=new ServerManager();