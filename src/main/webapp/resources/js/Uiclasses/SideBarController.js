var SideBarController = new Class({
    initialize: function(){
       
    },
    onOptionSelected: function(objectType){
    	switch (objectType) {
		 case "actividad":
			actividadRender.show();
			break;
		 case "integrante":
			instructorRender.show();
			break;
		 default:
			alert("ERROR")
	}
},
});
var sideBarController=new SideBarController();