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
		case "mensajesPropietario":
			return reclamoRender;
			break;
		case "actividadesReserva":
			return actividadReservaRender;
			break;
			
		case "recursosReserva":	
			return recursoReservaRender;
			break;
			
    	case "eventos":
			return eventoRender;
			break;
		}
    	
    }
    
});

renderTranslator=new RenderTranslator();