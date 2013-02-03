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
			default:
				alert("ERROR")
		}
		serverManager.save({object:objectType,form:formToSend,onSuccess : function(data) {
				self.onSaved();
		}});
	},
	
	
	onSaved : function() {
		//TODO actualizar el id del form
		alert("YES")
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
			default:
				alert("ERROR")
		}
		serverManager.update({object:objectType,objectId:objectId,form:formToSend,onSuccess : function(data) {
				self.onUpated();
		}});
	},
	
	onUpdated : function() {
		alert("YES UP")
	},
	
	onLoad : function(objectType,objectId,rowSelectedName) {
		var self=this;
			serverManager.get({object:objectType,objectId:objectId,onSuccess : function(data) {
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
