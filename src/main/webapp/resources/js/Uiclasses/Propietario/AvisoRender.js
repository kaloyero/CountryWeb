var AvisoRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },

    populateData: function(dataToAppend){
    	console.log("APPEND",dataToAppend)
		this.onFinishLoading(dataToAppend);
},

	onFinishLoading : function(dataToAppend){
		this.cleanCanvas();
		$("#content").append(dataToAppend);
		$("body").removeClass();
		$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview");
		jQuery(".corner-stamp").load('../resources/static/corner.html',function(){
			createEffect();
		});

}
});

avisoRender=new AvisoRender();