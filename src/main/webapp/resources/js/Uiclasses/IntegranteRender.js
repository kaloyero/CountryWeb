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
	    		newEntry="<strong>( </strong><span class='pais'>"+ self.getAddForm().find("#telCountry").val()+"</span>";
	    		newEntry+= " <span class='state'>" +self.getAddForm().find("#telState").val() + "</span><strong> ) </strong>";
	    		newEntry+=" <span class='tel'>" +self.getAddForm().find("#telNumber").val()+"</span>"	;
	    		self.getAddForm().find("#listaTelefonos").append("<li><div class='alert success telefono'><span class='hide'>x</span> "+newEntry+"</div></li>");
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
    	
    },
    onSubmit: function(id){
    	
    	var activeTab= $(".active").children().attr("href");
    	var form=$(activeTab).find("form");
    	
    	var telefonos = [];
    	var html = [];
       	$('.telefono').each(function(index) {
       		telefonos.push({"Telefono": $(this).find("tel"), "State": $(this).find("state"),"country":  $(this).find("pais")});
    	});
       	var telefonosText = JSON.stringify(telefonos);
       	html.push("<input type=hidden id=testa  name='telefonos' value="+telefonosText+">")
       	form.append(html.join(''));
    	return form;
    }
});

integranteRender=new IntegranteRender();
