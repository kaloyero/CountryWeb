var InstructorRender = new Class({
    initialize: function(name){
        this.name = name;
    },
    onSubmit: function(id){
    	var activeTab= $(".active").children().attr("href");
    	var form=$(activeTab).find("form")
    	return form
    },
    
    populateGrid: function(){

    	var tableActividad =$('#table-example').dataTable( {
    		"bProcessing": true,
    		"sAjaxSource": "/CountryWeb/instructor/lista",
    		
    		"fnRowCallback": function( nRow, aData, iDisplayIndex ) {
    							//Cada vez que se dibuja una fila,se ejecuta este Callback,y se pone el ID de la fila al TR
    							var id = aData[0];
    							$(nRow).attr("id",id);
    							return nRow;
    						},
    	} );
    	tableActividad.fnSetColumnVis( 0, false );
    },

    show: function(){
     	var self=this;
    	$.ajax({
    		type: 'GET',
    		url: '/CountryWeb/instructor/create',
    		success: function(data) {
    			$("#main-content").empty();
    			$("#main-content").append(data);
    		 	canvasController.createTabs();
    			self.populateGrid();
    		}
    	});
    }
   
});

instructorRender=new InstructorRender();