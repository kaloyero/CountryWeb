var CanvasController = new Class({
    initialize: function(){
    	

    },
    
    show : function(type){
    	translator.onShow(type);
    },
    
    onFinishShow : function(type,data){
    	console.log("TYPE ",type)
    	var me=this;
    	var renderInstace = renderTranslator.getRender(type);
    	/*switch (type) {
		case "dashboard":
			dataToAppend= renderInstace.getHtml(data);
			break;
			
		case "misReclamos":
			dataToAppend= renderInstace.getHtml(data);
			break;
		}*/
    	renderInstace.populateData(data);
    
    },
    clean : function(){
    	$(".tileContent").empty(); //TODO ver como recuperar el main y borrar todo excepto el corner
    	$(".canvas").remove();
    },
    
    onLoaded: function(type,data){
    	
    	var renderInstace = renderTranslator.getRender(type);
    	
    	renderInstace.load(data);
    },
    
});
var canvasController=new CanvasController();



