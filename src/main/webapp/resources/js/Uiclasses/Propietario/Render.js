var Render = new Class({
    initialize: function(){
       
    },
    
    /*
     * Si los hijos,no sobrescriben este metodo,significa que al formulario antes de enviarlo,no hay que hacerle nada como por ejemplo en InstrRender
     */
    onSubmit: function(id){
    
    },
    cleanCanvas: function(){
        canvasController.clean();
    },
    
    onFinishLoading : function(coleccion){
    	var me=this;
    	me.cleanCanvas();
    	for (tipo in coleccion){
    		templateManager.add(tipo,coleccion[tipo])
    		//console.log("Tipo",tipo)
    		//console.log("OBJECT",coleccion[tipo])
    	}
    	//$(template).tmpl(data).appendTo('#masonry-container');
    	createEffect();
    }

});

render=new Render();