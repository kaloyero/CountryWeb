var SideBarController = new Class({
    initialize: function(){
       
    },
    onOptionSelected: function(objectType){
    	canvasController.show(objectType);
    },
    onOptionFormSelected: function(objectType){
    	canvasController.showForm(objectType);
    },
    
    bindMenuEvents:function() {
    	this.bindMenuOptionsEvents()
    },
    
    bindMenuOptionsEvents:function() {
    
    $('.option').bind("click", function(e) {
    		var objectId=$(this).attr("id");
    		sideBarController.onOptionSelected(objectId);
    			
    });
    $('.optionNew').bind("click", function(e) {
    		var objectId=$(this).attr("id");
    		sideBarController.onOptionFormSelected(objectId);
    			
    });
    }


	
});
var sideBarController=new SideBarController();