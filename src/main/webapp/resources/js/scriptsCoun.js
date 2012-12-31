function  createTabs (container) {

		container.find('.tab-content').hide();
		container.find("ul.tabs li:first").addClass("active").show();
		container.find(".tab-content:first").show();

		container.find("ul.tabs li").click(function() {
			container.find("ul.tabs li").removeClass("active");
			$(this).addClass("active");
			container.find(".tab-content").hide();

			var activeTab = $(this).find("a").attr("href");
			$(activeTab).fadeIn();
			return false;
		});



    }

function  updateTabs (container) {
	container.find("ul.tabs li").removeClass("active");
	container.find('.tab-content').hide();
	container.find("ul.tabs li:last").addClass("active").show();
	//container.find(".tab-content:last").show();



}

function  addTab (container,nameRow,content) {
	container.find("ul.tabs li").removeClass("active");
	container.find('.tab-content').hide();
	$(".tabs").append( '<li><a href="#tab-1">'+nameRow+'</a></li>' );
	$(".tab-container").append( '<div id='+nameRow+' class="tab-content">'+content+'</div>' );

	container.find("ul.tabs li:last").addClass("active").show();
	//container.find(".tab-content:last").show();



}



function  populateGrid (type) {

	$('#table-example').dataTable( {
		"bProcessing": true,
		"sAjaxSource": "/CountryWeb/lista"
	} );



}

function submitaa(){
	alert("2")
}

