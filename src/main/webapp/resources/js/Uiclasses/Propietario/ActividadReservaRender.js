var ActividadReservaRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },

    
    populateData: function(dataToAppend){
    		this.onFinishLoading(dataToAppend);
    },
   
    onFinishLoading : function(dataToAppend){
    	var self=this;
    	this.cleanCanvas();
    	$("#content").append(dataToAppend);
    	$("body").removeClass();

    	$("body").addClass("bd-home gridview hoverable has-sidebar basegrid-m display-fullview display-imageview");
    	jQuery(".corner-stamp").load('../resources/static/corner.html',function(){
    				createEffect();
    				self.bindEvents();

    			});
    	

    },
	bindEvents : function() {
		$(".anotarseAcvitidad").click(
				function() {

					var actividadParticipar = {
								"actividadId" : $(this).parents(".item").find("input").val(),
								"cronogramaId": 1,
								"integranteId":2,
								"fechaIni":"2013/08/08"
							};
					
						dialogRender.create({onAccept:function(){translator.onSubmitJson('actividadParticipar',actividadParticipar)}});
				});

	},
});

actividadReservaRender=new ActividadReservaRender();