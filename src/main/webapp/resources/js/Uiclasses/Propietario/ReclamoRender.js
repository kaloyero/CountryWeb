var ReclamoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    populateData: function(dataToAppend){
		this.onFinishLoading(dataToAppend);
    },
   
    load: function(dataToAppend){
    	this.cleanCanvas();
    	$("body").removeClass();
    	$("body").addClass("has-sidebar has-aside");
    	//$(".corner-stamp").remove()
    	$("#mainbody").prepend(dataToAppend);
    	//$("#mainbody").html(dataToAppend);

    },
    

    onFinishLoading : function(dataToAppend){
    	this.cleanCanvas();
    	$("#content").append(dataToAppend);
    	jQuery(".corner-stamp").load('../resources/static/corner.html');
    	$("body").removeClass();
    	$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview");
	
    	createEffect();
	
    }
});

reclamoRender=new ReclamoRender();

