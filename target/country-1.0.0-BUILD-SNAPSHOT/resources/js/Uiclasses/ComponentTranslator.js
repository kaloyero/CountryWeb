var ComponentTranslator = new Class({
	
	initialize : function() {
		this.actividadRender=new ActividadRender()
	},
	
	onSubmit : function(id) {
		switch (id) {
		case "actividad":
			this.actividadRender.onSubmit();
			break;
		default:
			alert("ERROR Actividad.jsp")
		}
	}
});
