var ServerManager = new Class({
    initialize: function(name){
        this.name = name;
        this.services={};

        this.services['dashboard']={};
        //this.services['meReclamos']={}
        this.services['mensaje']={};
        this.services['actividad']={};
        this.services['recurso']={};
        this.services['mensajeReclamo']={};
        this.services['recursoReserva']={};
        this.services['evento']={};
        this.services['recurso']={};
        this.services['evento']["save"]="/CountryWeb/evento/create/";
        this.services['recursoReserva']["save"]="/CountryWeb/recursoReserva/create/";
        this.services['mensajeReclamo']["save"]="/CountryWeb/mensajeReclamo/create/";
        this.services['mensajeReclamo']["load"]="/CountryWeb/mensajeReclamo/load/";
        this.services['recurso']["load"]="/CountryWeb/recurso/recursosParaReservar/load/";
        
        //this.services['avisos']={};
   
        //this.services['dashboard']["lista"]="/CountryWeb/dashboard/lista/";
        //this.services['mensajesPropietario']["lista"]="/CountryWeb/mensaje/listaPropietario";
       // this.services['meReclamos']["lista"]="/CountryWeb/mensaje/listaMisMensajes";
        //this.services['actividadesReserva']["lista"]="/CountryWeb/actividad/actividadesParaReservar";
        //this.services['recursosReserva']["lista"]="/CountryWeb/recurso/recursosParaReservar";
        //this.services['recursosReserva']["load"]="/CountryWeb/recurso/recursosParaReservar/load/";
        //this.services['evento']["load"]="/CountryWeb/evento/load/";
        //this.services['evento']["save"]="/CountryWeb/evento/create/";
        //this.services['mensaje']["load"]="/CountryWeb/mensaje/load/";
        //this.services['mensaje']["save"]="/CountryWeb/mensaje/create/";
        //this.services['noticia']["load"]="/CountryWeb/noticia/load/";
        //this.services['noticia']["save"]="/CountryWeb/noticia/create/";
       // this.services['eventos']["lista"]="/CountryWeb/evento/listaPropietario";
        //this.services['avisos']["lista"]="/CountryWeb/avisos/lista";


    },
 

    getNewObject: function(config){

    	var type = config.object.split('_')[0];
    	var self=this;
    	$.ajax({
			type: 'GET',
			url: self.services[type]["save"],
			success: function(data) {
				
				config.onSuccess(data);
			}
		});
    },
    getObjectById: function(config){

    	var type = config.object.split('_')[0];
    	console.log("TYPE",type,this.services[type])
    	var self=this;
    	$.ajax({
			type: 'GET',
			url: self.services[type]["load"]+config.objectId,
			success: function(data) {
				
				config.onSuccess(data);
			}
		});
    },
    getAll: function(config){
    	var self=this;
    	var type = config.object.split('_');
    	var url="/CountryWeb/"+type[0]+ "/listaPropietario";
    	if (type[2]!=null ){
    		url+="FromUsuario"
    	}
    	console.log("URL",url)
    	$.ajax({
			type: 'GET',
			url: url,
			success: function(data) {
				config.onSuccess(data);
			}
		});
    },
    save: function(config){
    	//console.log("SER",config.form.serialize())
    	var transformedData="";
    	if (config.form)
    	transformedData =config.form.serialize()
    	var self=this;
    	$.ajax( {
		      type: "POST",
		      url: self.services[config.object]["save"],
		      data: transformedData,
		      success: function(data) {
		    	  console.log("@@")
		    	  config.onSuccess(data);
				}
		    } );
    },
    saveJson: function(config){
    	var self=this;
    	$.ajax( {
		      type: "POST",
		      dataType: 'json', 
		      url: self.services[config.object]["save"],
		      data: JSON.stringify(config.data),
		      contentType: 'application/json',
		      mimeType: 'application/json',
		      success: function(data) {
		    	  config.onSuccess(data);
				}
		    } );
    },
   
});

serverManager=new ServerManager();