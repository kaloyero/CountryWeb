var InstructorRender = new Class({
	Extends: Render,
    initialize: function(name){
        this.name = name;
    },

    onLoaded: function(){
    	var form=this.getAddForm();
    	this.bindListeners(form);
    	
    },
    onNewTab: function(){
    	var form=this.getActiveForm();
    	this.bindListeners(form);
    	
    },
    bindListeners: function(form){
    	var self=this;

    	form.find("#addPhone").click(function() {
    		var newEntry="";
    		if (form.find("#telNumber").val().trim() != "" ){
    			newEntry=" <span class='idTel' hidden='true'>0</span>"	;
    			newEntry+="<span class='idTipoTe' hidden='true'>"+ form.find("#telContact").val() +" </span>";
    			newEntry+="<span class='tipoTe' >"+ form.find("#telContact").val() +" </span>";
	    		newEntry+="<strong>( </strong><span class='pais'> "+ form.find("#telCountry").val()+"</span>";
	    		newEntry+= " <span class='state'>" +form.find("#telState").val() + "</span>";
	    		newEntry+= " <span class='prefix'>" +form.find("#telPrefijo").val() + "</span><strong> ) </strong>";
	    		newEntry+=" <span class='tel'>" +form.find("#telNumber").val()+"</span>"	;
	    		form.find("#listaTelefonos").append("<li><div class='alert success telefono'><span class='hide'>x</span> "+newEntry+"</div></li>");
	    		self.addCloseListener();
	    		form.find("#telCountry").val("");
	    		form.find("#telState").val("");
	    		form.find("#telPrefijo").val("");
	    		form.find("#telNumber").val("");

    		}
		});
	    	
    	form.find("#addAddress").click(function() {
    		var newEntry="";
    		if (form.find("#dirStreetName").val().trim() != "" ){
    			
    			newEntry=" <span class='idDire' hidden='true'>0</span>"	;
    			newEntry+="<span class='idTownDire' hidden='true'>"+ form.find("#dirTown").val() +" </span>";
    			newEntry+="<span class='townDire' >"+ form.find("#dirTown").val() +" </span>";
    			newEntry+="<span class='streetNameDire' >"+ form.find("#dirStreetName").val() +" </span>";
    			newEntry+="<span class='streetNumDire' >"+ form.find("#dirStreetNum").val() +" </span>";
    			newEntry+="<span class='floorDire' >"+ form.find("#dirFloor").val() +" </span>";
    			newEntry+="<span class='flatDire' >"+ form.find("#dirFlat").val() +" </span>";
    			newEntry+="<span class='towerDire' >"+ form.find("#dirTower").val() +" </span>";
    			newEntry+="<span class='blockDire' >"+ form.find("#dirBlock").val() +" </span>";
    			
    			form.find("#listaDirecciones").append("<li><div class='alert success direccion'><span class='hide'>x</span> "+newEntry+"</div></li>");
	    		self.addCloseListener();
	    		form.find("#dirTown").val("1");
	    		form.find("#dirStreetName").val("");
	    		form.find("#dirStreetNum").val("");
	    		form.find("#dirFloor").val("");
	    		form.find("#dirFlat").val("");
	    		form.find("#dirTower").val("");
	    		form.find("#dirBlock").val("");
	    		
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