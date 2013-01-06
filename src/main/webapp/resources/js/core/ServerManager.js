var ServerManager = new Class({
    initialize: function(name){
        this.name = name;
        this.services={};
        this.services['actividad']={};
        this.services['instructor']={};
        this.services['actividad']["load"]="/CountryWeb/actividad/load/";
        this.services['actividad']["save"]="/CountryWeb/actividad/create/";
        this.services['instructor']["load"]="/CountryWeb/instructor/load/";
        this.services['instructor']["save"]="/CountryWeb/instructor/create/";
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
    }
   
});

serverManager=new ServerManager();