var EventoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },

    populateData: function(dataToAppend){
		this.onFinishLoading(dataToAppend);
},

onFinishLoading : function(dataToAppend){
	this.cleanCanvas();
	$("#masonry-container").append(dataToAppend);
	//$("body").addClass("display-imageview");
    createEffect();
	//templateManager.add("actividadesReserva",dataToAppend);
	
}
});

eventoRender=new EventoRender();