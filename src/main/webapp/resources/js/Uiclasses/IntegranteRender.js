var IntegranteRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },
    onLoaded: function(){
    	this.bindListeners();
    	
    },
    onNewTab: function(){
    	this.bindListeners();
    	
    },
    bindListeners: function(){
    	var self=this;

    	this.getAddForm().find("#addPhone").click(function() {
    		var newEntry="";
    		if (self.getAddForm().find("#telNumber").val().trim() != "" ){
    			newEntry=" <span class='idTel' hidden='true'>0</span>"	;
    			newEntry+="<span class='idTipoTe' hidden='true'>"+ self.getAddForm().find("#telContact").val() +" </span>";
    			newEntry+="<span class='tipoTe' >"+ self.getAddForm().find("#telContact").val() +" </span>";
	    		newEntry+="<strong>( </strong><span class='pais'> "+ self.getAddForm().find("#telCountry").val()+"</span>";
	    		newEntry+= " <span class='state'>" +self.getAddForm().find("#telState").val() + "</span>";
	    		newEntry+= " <span class='prefix'>" +self.getAddForm().find("#telPrefijo").val() + "</span><strong> ) </strong>";
	    		newEntry+=" <span class='tel'>" +self.getAddForm().find("#telNumber").val()+"</span>"	;
	    		self.getAddForm().find("#listaTelefonos").append("<li><div class='alert success telefono'><span class='hide'>x</span> "+newEntry+"</div></li>");
	    		self.addCloseListener();
	    		self.getAddForm().find("#telCountry").val("");
	    		self.getAddForm().find("#telState").val("");
	    		self.getAddForm().find("#telPrefijo").val("");
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
       		telefonos.push({"Telefono": parseInt($(this).find(".tel").text()),
       						"Country":  parseInt($(this).find(".pais").text()),
       						"State": 	parseInt($(this).find(".state").text()),
       						"Prefix": 	parseInt($(this).find(".prefix").text()),
       						"IdTel": 	parseInt($(this).find(".idTel").text()),
       						"IdTipoTel":  parseInt($(this).find(".idTipoTe").text())});
    	});
       	
       	var telefonosText = JSON.stringify(telefonos);
       	html.push("<input type=hidden id=testa  name='persona.telefonos' value="+telefonosText+">");
       	form.append(html.join(''));
    	return form;
    }
});

integranteRender=new IntegranteRender();
