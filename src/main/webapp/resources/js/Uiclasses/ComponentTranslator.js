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
			default:
				alert("ERROR")
		}
		serverManager.save({object:objectType,form:formToSend,onSuccess : function(data) {
				self.onSaved();
		}});
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
	
	onSaved : function() {
		alert("YES")
	}
});

var translator= new ComponentTranslator();
