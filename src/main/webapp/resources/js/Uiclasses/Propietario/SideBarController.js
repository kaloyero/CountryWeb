var SideBarController = new Class({
    initialize: function(){
       
    },
    onOptionSelected: function(objectType){
    	canvasController.show(objectType);
    },
    
    bindMenuEvents:function() {
    	this.bindMenuOptionsEvents()
    },
    
    bindMenuOptionsEvents:function() {
    	$('.option').bind("click", function(e) {
    		var objectId=$(this).attr("id");
    		sideBarController.onOptionSelected(objectId);
    			
    });
    }


	
});
var sideBarController=new SideBarController();