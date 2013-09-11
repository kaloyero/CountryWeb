var myArray = [];
var InfraccionRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    onLoaded: function(){
    	var form=this.getAddForm();
    	myArray = new Array();
    	
    	console.log($("#categorias").lenth());
    	
    	
    	myArray[ 0 ] = "120.0";
    	myArray[ 4 ] = "150";
    	myArray[ 5 ] = "200";
    	
    	
    	for(var i in myArray){
    		alert(myArray[i]);
    	}
    	
    	console.log(myArray.length);
    	this.bindListeners(form);
    	
    	
    },
    onNewTab: function(){
    	var form=this.getActiveForm();
    	console.log("dos");
    	this.bindListeners(form);
    	
    },  
    bindListeners: function(form){
    	var self=this;

    	form.find("#infraccionSelect").change(function() {
    		console.log(myArray[form.find("#infraccionSelect").val()]);
    		form.find("#importeBox").val(myArray[form.find("#infraccionSelect").val()]);
		});
    },
});


infraccionRender=new InfraccionRender();