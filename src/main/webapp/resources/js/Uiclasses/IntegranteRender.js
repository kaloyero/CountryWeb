var IntegranteRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    onLoaded: function(){
    	this.bindListeners();
    	
    },
    bindListeners: function(){
    	var self=this;

    	this.getAddForm().find("#addPhone").click(function() {
    		var newEntry="";
    		if (self.getAddForm().find("#telNumber").val().trim() != "" ){
    			//newEntry="<strong> "+ self.getAddForm().find("#telContact").selectedItem() + "</strong>";
	    		newEntry="<strong>( </strong>"+ self.getAddForm().find("#telCountry").val();
	    		newEntry+= " " +self.getAddForm().find("#telState").val() + "<strong> ) </strong>";
	    		newEntry+=" " +self.getAddForm().find("#telNumber").val()	;
	    		self.getAddForm().find("#listaTelefonos").append("<li><div class='alert success'><span class='hide'>x</span> "+newEntry+"</div></li>");
	    		self.addCloseListener();
	    		self.getAddForm().find("#telCountry").val("");
	    		self.getAddForm().find("#telState").val("");
	    		self.getAddForm().find("#telNumber").val("");

    		}
		});
	    	


    	
    },
    addCloseListener: function(){
    	$('#listaTelefonos li:last-child').click(function() {
    		$(this).slideUp();					   
    	});
    	
    }
});

integranteRender=new IntegranteRender();
