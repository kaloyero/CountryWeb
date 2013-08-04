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
        this.services['tipoAutorizacion']={};
        this.services['tipoDocumento']={};
        this.services['tipoEspecie']={};
        this.services['tipoInfraccion']={};
        this.services['tipoPago']={};
        this.services['tipoRaza']={};
        this.services['tipoRecurso']={};
        this.services['tipoVacuna']={};
        this.services['tipoVehiculo']={};
        this.services['mensajeCategoria']={};
        this.services['mensajesPropietario']={};
        this.services['mensaje']={};
        this.services['mensajeReclamo']={};
        this.services['noticiaCategoria']={};
        this.services['avisoCategoria']={};
        this.services['dashboard']={};
        this.services['meReclamos']={}
        this.services['actividadesReserva']={};
        this.services['recursosReserva']={};
        this.services['evento']={};
        this.services['noticia']={};
        this.services['eventos']={};
        this.services['aviso']={};
        this.services['actividad']["load"]="/CountryWeb/actividad/load/";
        this.services['actividad']["save"]="/CountryWeb/actividad/create/";
        this.services['instructor']["load"]="/CountryWeb/instructor/load/";
        this.services['instructor']["save"]="/CountryWeb/instructor/create/";
        this.services['unidad']["load"]="/CountryWeb/unidad/load/";
        this.services['unidad']["save"]="/CountryWeb/unidad/create/";
        this.services['integrante']["load"]="/CountryWeb/integrante/load/";
        this.services['integrante']["save"]="/CountryWeb/integrante/create/";
        this.services['concepto']["load"]="/CountryWeb/concepto/load/";
        this.services['concepto']["save"]="/CountryWeb/concepto/create/";
        this.services['recurso']["load"]="/CountryWeb/recurso/load/";
        this.services['recurso']["save"]="/CountryWeb/recurso/create/"
        this.services['vehiculo']["load"]="/CountryWeb/vehiculo/load/";
        this.services['vehiculo']["save"]="/CountryWeb/vehiculo/create/";
        this.services['mascota']["load"]="/CountryWeb/mascota/load/";
        this.services['mascota']["save"]="/CountryWeb/mascota/create/";
        this.services['tipoAutorizacion']["load"]="/CountryWeb/tipoAutorizacion/load/";
        this.services['tipoAutorizacion']["save"]="/CountryWeb/tipoAutorizacion/create/";
        this.services['tipoDocumento']["load"]="/CountryWeb/tipoDocumento/load/";
        this.services['tipoDocumento']["save"]="/CountryWeb/tipoDocumento/create/";
        this.services['tipoEspecie']["load"]="/CountryWeb/tipoEspecie/load/";
        this.services['tipoEspecie']["save"]="/CountryWeb/tipoEspecie/create/";
        this.services['tipoInfraccion']["load"]="/CountryWeb/tipoInfraccion/load/";
        this.services['tipoInfraccion']["save"]="/CountryWeb/tipoInfraccion/create/";
        this.services['tipoPago']["load"]="/CountryWeb/tipoPago/load/";
        this.services['tipoPago']["save"]="/CountryWeb/tipoPago/create/";
        this.services['tipoRaza']["load"]="/CountryWeb/tipoRaza/load/";
        this.services['tipoRaza']["save"]="/CountryWeb/tipoRaza/create/";
        this.services['tipoRecurso']["load"]="/CountryWeb/tipoRecurso/load/";
        this.services['tipoRecurso']["save"]="/CountryWeb/tipoRecurso/create/";
        this.services['tipoVacuna']["load"]="/CountryWeb/tipoVacuna/load/";
        this.services['tipoVacuna']["save"]="/CountryWeb/tipoVacuna/create/";
        this.services['tipoVehiculo']["load"]="/CountryWeb/tipoVehiculo/load/";
        this.services['tipoVehiculo']["save"]="/CountryWeb/tipoVehiculo/create/";
        this.services['mensajeCategoria']["load"]="/CountryWeb/mensajeCategoria/load/";
        this.services['mensajeCategoria']["save"]="/CountryWeb/mensajeCategoria/create/";
        this.services['noticiaCategoria']["load"]="/CountryWeb/noticiaCategoria/load/";
        this.services['noticiaCategoria']["save"]="/CountryWeb/noticiaCategoria/create/";
        this.services['avisoCategoria']["load"]="/CountryWeb/avisoCategoria/load/";
        this.services['avisoCategoria']["save"]="/CountryWeb/avisoCategoria/create/";
        this.services['dashboard']["lista"]="/CountryWeb/dashboard/lista/";
        this.services['mensajesPropietario']["lista"]="/CountryWeb/mensaje/listaPropietario";
        this.services['meReclamos']["lista"]="/CountryWeb/mensaje/listaMisMensajes";
        this.services['actividadesReserva']["lista"]="/CountryWeb/actividad/actividadesParaReservar";
        this.services['recursosReserva']["lista"]="/CountryWeb/recurso/recursosParaReservar";
        this.services['recursosReserva']["load"]="/CountryWeb/recurso/recursosParaReservar/load/";
        this.services['evento']["load"]="/CountryWeb/evento/load/";
        this.services['evento']["save"]="/CountryWeb/evento/create/";
        this.services['mensaje']["load"]="/CountryWeb/mensaje/load/";
        this.services['mensaje']["save"]="/CountryWeb/mensaje/create/";
        this.services['mensajeReclamo']["load"]="/CountryWeb/mensajeReclamo/load/";
        this.services['mensajeReclamo']["save"]="/CountryWeb/mensajeReclamo/create/";
        this.services['noticia']["load"]="/CountryWeb/noticia/load/";
        this.services['noticia']["save"]="/CountryWeb/noticia/create/";
        this.services['aviso']["load"]="/CountryWeb/aviso/load/";
        this.services['aviso']["save"]="/CountryWeb/aviso/create/";
        this.services['eventos']["lista"]="/CountryWeb/evento/listaPropietario";
        this.services['aviso']["lista"]="/CountryWeb/aviso/lista";


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
    getAll: function(config){

    	var self=this;
    	$.ajax({
			type: 'GET',
			url: self.services[config.object]["lista"],
			success: function(data) {
				
				config.onSuccess(data);
			}
		});
    },
   
    save: function(config){
    	var self=this;
    	console.log("SAVSERI",config.form.serialize())
    	    	console.log("SAVESINSER",config.form)

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