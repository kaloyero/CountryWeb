var ComponentTranslator = new Class({
	
	initialize : function() {
		
	},
	
	onSubmit : function(objectType) {
		var self=this;
		var formToSend;
		switch (objectType) {
			case "actividad":
				formToSend =actividadRender.onSubmit();
				break;
			case "instructor":
				formToSend =instructorRender.onSubmit();
				break;
			case "unidad":
				formToSend =unidadRender.onSubmit();
				break;
			case "integrante":
				formToSend =integranteRender.onSubmit();
				break;
			case "concepto":
				formToSend =conceptoRender.onSubmit();
				break;
			case "recurso":
				formToSend =recursoRender.onSubmit();
				break;
			case "vehiculo":
				formToSend =vehiculoRender.onSubmit();
				break;
			case "mascota":
				formToSend =mascotaRender.onSubmit();
				break;
			case "tipoAutorizacion":
				formToSend = tipoAutorizacionRender.onSubmit();
				break;
			case "tipoDocumento":
				formToSend = tipoDocumentoRender.onSubmit();
				break;
			case "tipoEspecie":
				formToSend = tipoEspecieRender.onSubmit();
				break;
			case "tipoInfraccion":
				formToSend =tipoInfraccionRender.onSubmit();
				break;
			case "tipoPago":
				formToSend =tipoPagoRender.onSubmit();
				break;
			case "tipoRaza":
				formToSend =tipoRazaRender.onSubmit();
				break;
			case "tipoRecurso":
				formToSend = tipoRecursoRender.onSubmit();
				break;
			case "tipoVacuna":
				formToSend = tipoVacunaRender.onSubmit();
				break;
			case "tipoVehiculo":
				formToSend = tipoVehiculoRender.onSubmit();
				break;
			default:
				$.jGrowl("Se ha producido un error. No se ha creado satisfactoriamente.", { theme: 'error' });
		}
		serverManager.save({object:objectType,form:formToSend,onSuccess : function(data) {
				self.onSaved();
		}});
	},
	
	
	onSaved : function() {
		$.jGrowl("Creado con exito.", { theme: 'success' });
	},
	
	
	onUpdate : function(objectType,objectId) {
		var self=this;
		var formToSend;
		switch (objectType) {
			case "actividad":
				formToSend =actividadRender.onSubmit();
				break;
			case "instructor":
				formToSend =instructorRender.onSubmit();
				break;
			case "unidad":
				formToSend =unidadRender.onSubmit();
				break;
			case "integrante":
				formToSend =integranteRender.onSubmit();
				break;
			case "concepto":
				formToSend =conceptoRender.onSubmit();
				break;
			case "recurso":
				formToSend =recursoRender.onSubmit();
				break;
			case "vehiculo":
				formToSend =vehiculoRender.onSubmit();
				break;
			case "mascota":
				formToSend =mascotaRender.onSubmit();
				break;				
			case "tipoAutorizacion":
				formToSend = tipoAutorizacionRender.onSubmit();
				break;
			case "tipoDocumento":
				formToSend = tipoDocumentoRender.onSubmit();
				break;
			case "tipoEspecie":
				formToSend = tipoEspecieRender.onSubmit();
				break;
			case "tipoInfraccion":
				formToSend =tipoInfraccionRender.onSubmit();
				break;
			case "tipoPago":
				formToSend =tipoPagoRender.onSubmit();
				break;
			case "tipoRaza":
				formToSend =tipoRazaRender.onSubmit();
				break;
			case "tipoRecurso":
				formToSend = tipoRecursoRender.onSubmit();
				break;
			case "tipoVacuna":
				formToSend = tipoVacunaRender.onSubmit();
				break;
			case "tipoVehiculo":
				formToSend = tipoVehiculoRender.onSubmit();

			default:
				$.jGrowl("Se ha producido un error. Los cambios no han sido guardados.", { theme: 'error' });
			}
		serverManager.update({object:objectType,objectId:objectId,form:formToSend,onSuccess : function(data) {
				self.onUpdated();
		}});
	},
	
	onUpdated : function() {
		$.jGrowl("Guardado con exito.", { theme: 'success' });
		canvasController.getClose();
	},
	
	onLoad : function(objectType,objectId,rowSelectedName) {
		alert("aca ale");
		var self=this;
			serverManager.get({object:objectType,objectId:objectId,onSuccess : function(data) {
				alert("rowSelectedName " + rowSelectedName);
				alert("objectId " + objectId);
				alert("objectType " + objectType);
				alert("data " + data);
				self.onLoaded(rowSelectedName,objectId,objectType,data);
			}});
	},
	
	onLoaded : function(rowSelectedName,objectId,objectType,data) {
		
		canvasController.onLoaded(rowSelectedName,objectId,objectType,data);
	},
	
	onShow : function(objectType) {
		
		var self=this;
		serverManager.show({object:objectType,onSuccess : function(data) {
			self.onShowed(objectType,data);
	}});
		
	},
	
	onShowed : function(objectType,data) {
		
		canvasController.onShowOption(objectType,data);
	},
	
	onPopulateGrid : function(objectType) {
		
		//TODO esta bien esto o dejo lo que esta comentado
		render.populateGrid(objectType);
		
//    	switch (objectType) {
//		 case "actividad":
//			actividadRender.populateGrid();
//			break;
//		 case "integrante":
//			instructorRender.populateGrid();
//			break;
//		 default:
//			alert("ERROR")
//	}
},
	
	
	

});

var translator= new ComponentTranslator();
