var InstructorRender = new Class({
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
    		alert("hola");
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
	    	
    	this.getAddForm().find("#addAddress").click(function() {
    		var newEntry="";
    		if (self.getAddForm().find("#dirStreetName").val().trim() != "" ){
    			
    			newEntry=" <span class='idDire' hidden='true'>0</span>"	;
    			newEntry+="<span class='idTownDire' hidden='true'>"+ self.getAddForm().find("#dirTown").val() +" </span>";
    			newEntry+="<span class='townDire' >"+ self.getAddForm().find("#dirTown").val() +" </span>";
    			newEntry+="<span class='streetNameDire' >"+ self.getAddForm().find("#dirStreetName").val() +" </span>";
    			newEntry+="<span class='streetNumDire' >"+ self.getAddForm().find("#dirStreetNum").val() +" </span>";
    			newEntry+="<span class='floorDire' >"+ self.getAddForm().find("#dirFloor").val() +" </span>";
    			newEntry+="<span class='flatDire' >"+ self.getAddForm().find("#dirFlat").val() +" </span>";
    			newEntry+="<span class='towerDire' >"+ self.getAddForm().find("#dirTower").val() +" </span>";
    			newEntry+="<span class='blockDire' >"+ self.getAddForm().find("#dirBlock").val() +" </span>";
    			
    			self.getAddForm().find("#listaDirecciones").append("<li><div class='alert success direccion'><span class='hide'>x</span> "+newEntry+"</div></li>");
	    		self.addCloseListener();
	    		self.getAddForm().find("#dirTown").val("1");
	    		self.getAddForm().find("#dirStreetName").val("");
	    		self.getAddForm().find("#dirStreetNum").val("");
	    		self.getAddForm().find("#dirFloor").val("");
	    		self.getAddForm().find("#dirFlat").val("");
	    		self.getAddForm().find("#dirTower").val("");
	    		self.getAddForm().find("#dirBlock").val("");
	    		
    		}
		});
    	
    },
    addCloseListener: function(){
    	$('#listaTelefonos li:last-child').click(function() {
    		$(this).slideUp();					   
    	});
    	$('#listaDirecciones li:last-child').click(function() {
    		$(this).slideUp();					   
    	});
    	
    },
    onSubmit: function(id){
    	
    	var activeTab= $(".active").children().attr("href");
    	var form=$(activeTab).find("form");
    	
    	
    	var html = [];
    	var telefonos = [];
       	$('.telefono').each(function(index) {
       		telefonos.push({"Telefono": parseInt($(this).find(".tel").text()),
       						"Country":  parseInt($(this).find(".pais").text()),
       						"State": 	parseInt($(this).find(".state").text()),
       						"Prefix": 	parseInt($(this).find(".prefix").text()),
       						"IdTel": 	parseInt($(this).find(".idTel").text()),
       						"IdTipoTel":  parseInt($(this).find(".idTipoTe").text())});
    	});

       	var direcciones = [];
       	$('.direccion').each(function(index) {
       		direcciones.push({	"StreetName": parseInt($(this).find(".streetNameDire").text()),
       							"StreetNum":  parseInt($(this).find(".streetNumDire").text()),
       							"Floor": 	parseInt($(this).find(".floorDire").text()),
       							"Flat": 	parseInt($(this).find(".flatDire").text()),
       							"Tower": 	parseInt($(this).find(".towerDire").text()),
       							"Block": 	parseInt($(this).find(".blockDire").text()),
       							"IdDir": 	parseInt($(this).find(".idDire").text()),
       							"IdTownDir":  parseInt($(this).find(".idTownDire").text())});
       		
    	});

       	
       	var telefonosText = JSON.stringify(telefonos);
       	var direccionesText = JSON.stringify(direcciones);
       	html.push("<input type=hidden id=testa  name='persona.telefonos' value="+telefonosText+">");
       	html.push("<input type=hidden id=testa  name='persona.direcciones' value="+direccionesText+">");
       	form.append(html.join(''));
    	return form;
    }    		
    
});

instructorRender=new InstructorRender();