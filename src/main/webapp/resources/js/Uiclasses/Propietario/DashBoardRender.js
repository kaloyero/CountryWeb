var DashBoardender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    getHtml: function(data){
        return "../resources/static/dashboard.html"
    },
    
    populateData: function(dataToAppend){
    	var me=this;
    
    	$.get("../resources/static/templateDashboard.html", function (data) {
    		$('body').append(data);
    		me.onFinishLoading(dataToAppend)
    	      
    	});

    },
   
    onFinishLoading : function(coleccion){
    	for (tipo in coleccion){
    		templateManager.add(tipo,coleccion[tipo])
    		//console.log("Tipo",tipo)
    		//console.log("OBJECT",coleccion[tipo])
    	}
    	jQuery(".corner-stamp").load('../resources/static/corner.html');
    	//$('#dashboardNoImage').tmpl(data2).appendTo('#masonry-container');
    	//$('#dashboardNews').tmpl(data3).appendTo('#masonry-container');
    	//$('#dashboardImage').tmpl(data).appendTo('#masonry-container');
    	//$("#masonry-container").append(data);
    	createEffect();

    }
});

dashboardRender=new DashBoardender();