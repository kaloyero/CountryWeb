var RenderTranslator = new Class({
    initialize: function(){
       
    },

    getRender: function(type){
    	switch (type) {
		case "dashboard":
			return dashboardRender;
			break;
		case "meReclamos":
			return reclamoRender;
			break;
		case "meEventos":
			return eventoRender;
			break;
		case "mensajeReclamo":
			return reclamoRender;
			break;
		case "actividad":
			return actividadReservaRender;
			break;
			
		case "recurso":	
			return recursoReservaRender;
			break;

    	case "evento":
			return eventoRender;
			break;
    	case "resumen":
    		return resumenRender;
    		break;
	}
    	
    }
    
});

renderTranslator=new RenderTranslator();