var ActividadReservaRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },

    
    populateData: function(dataToAppend){
    		this.onFinishLoading(dataToAppend);
    },
   
    onFinishLoading : function(dataToAppend){
    	this.cleanCanvas();
    	$("#content").append(dataToAppend);
    	jQuery(".corner-stamp").load('../resources/static/corner.html');
    	$("body").removeClass();

    	$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview display-imageview");
        createEffect();
    	
    }
});

actividadReservaRender=new ActividadReservaRender();