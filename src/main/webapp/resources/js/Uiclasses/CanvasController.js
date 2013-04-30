var CanvasController = new Class({
    initialize: function(){
    	this.bindTableEvents();
    	this.bindTabEvents(); 

    },
    createTabs: function(){
        this.getTabContainer().find('.tab-content').hide();
        this.getTabContainer().find("ul.tabs li:first").addClass("active").show();
    	this.getTabContainer().find(".tab-content:first").show();
    },
   
    addTab: function(nameRow, id, content){
    	alert("canva ");
    	this.getTabContainer().find("ul.tabs li").removeClass("active");
    	this.getTabContainer().find('.tab-content').hide();
        
    	$(".tabs").append('<li><a href=#' + id + '>' + nameRow + '</a> <span class="ui-icon ui-icon-close" role="presentation">Remove Tab</span> </li>');
    	$(".tab-container").append('<div id=' + id + ' class="tab-content">' + content + '</div>');

    	this.getTabContainer().find("ul.tabs li:last").addClass("active").show();
    },

	

    
    bindTabEvents: function(){
    	var self=this;
    	this.getTabContainer().find("ul.tabs li").live("click", function() {
    		self.getTabContainer().find("ul.tabs li").removeClass("active");
    		$(this).addClass("active");
    		self.getTabContainer().find(".tab-content").hide();

    		var activeTab = $(this).find("a").attr("href");
    		$(activeTab).fadeIn();
    	});
    },
    
   
   
    bindTableEvents: function(){
    	
    	var self=this;
    	this.getTableRows().live("click", function(event) {
    		var objectType=self.getTableId(this);
    		var id=$(this).attr("id");
    		var rowSelectedName=$(event.target.parentNode).children(0).eq(0).text();
    		translator.onLoad(objectType,id,rowSelectedName);
    	});
    },
    
    onLoaded: function(rowSelectedName,id,objectType,data){
    	
    	this.addTab(rowSelectedName,id+objectType,data);
    	
       	switch (objectType) {
		 case "recurso":
			recursoRender.onNewTab();
			break;
       	}
    },
    
    onShowOption: function(objectType,data){
    	$("#main-content").empty();
		$("#main-content").append(data);

		
		
	   	switch (objectType) {
		 case "recurso":
			recursoRender.draw();
			break;

	}
	    this.createTabs();

	 	this.populateGrid(objectType);
    },
    
    populateGrid: function(objectType){
    	console.log("broke");
    	translator.onPopulateGrid(objectType);
    },
    
    getTabContainer: function(){
    	alert("ale aca se toca cnd aparece el tab");
    	return $("#tab-panel-1");
    },
    getClose: function(){
    	alert("se cierra pos");
    	$("#tab-panel-1").remove();
    	//tabs.tabs( "refresh" );
    	alert("termino se ");
    },
    
    getTableRows: function(){
    	return $('.active-table tbody tr');
    },
    
    getTableId: function(table){
    	return $(table).parent().parent().attr("id");
    },
    
});
var canvasController=new CanvasController();

//tabs.delegate( "span.ui-icon-close", "click", function() {
//	alert("aca alegrieas");
//	var panelId = $( this ).closest( "li" ).remove().attr( "aria-controls" );
//    $( "#" + panelId ).remove();
//    tabs.tabs( "refresh" );
//  });



















