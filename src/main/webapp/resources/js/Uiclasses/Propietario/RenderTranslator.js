var RenderTranslator = new Class({
    initialize: function(){
       
    },

    getRender: function(type){
    	switch (type) {
		case "dashboard":
			return dashboardRender;
			break
		case "meReclamos":
			return reclamoRender;
		case "meEventos":
			return eventoRender;
		case "mensajesPropietario":
			return reclamoRender;
		case "actividadesReserva":
			return actividadReservaRender;
			
		case "recursosReserva":	
			return recursoReservaRender;
		}
    	
    	
    	
    	
    	recursosReserva
    }
    
});

renderTranslator=new RenderTranslator();