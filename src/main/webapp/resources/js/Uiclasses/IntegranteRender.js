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
    		newEntry="<strong>Pais</strong>: "+ self.getAddForm().find("#telCountry").val()
    		newEntry+= " <strong>Provincia</strong>: " +self.getAddForm().find("#telState").val()
    		newEntry+=" <strong>Numero:</strong> " +self.getAddForm().find("#telNumber").val()	
    		self.getAddForm().find("#listaTelefonos").append("<li><div class='alert success'><span class='hide'>x</span> "+newEntry+"</div></li>");
    		self.addCloseListener();

    		});
    },
    addCloseListener: function(){
    	$('#listaTelefonos li:last-child').click(function() {
    		$(this).slideUp();					   
    	});
    	
    }
});

integranteRender=new IntegranteRender();
