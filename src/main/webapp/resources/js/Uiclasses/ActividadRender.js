var ActividadRender = new Class({
	Extends: Render,
   
	initialize: function(name){
    },
    onSubmit: function(id){
    	
    	var activeTab= $(".active").children().attr("href");
    	var form=$(activeTab).find("form");
		var html = [];
		var domingo=new Array();
		var lunes=new Array();
		var martes=new Array();
		var miercoles=new Array();
		var jueves=new Array();
		var viernes=new Array();
		var sabado=new Array();

		$('.selected').each(function(index) {
		
			var dia =$(this).attr("id");
			switch(parseInt(dia))
			{
			case 0:
				domingo.push($(this).parent().attr("id"));
				break;
			case 1:
				lunes.push($(this).parent().attr("id"));
				break;
			case 2:
				martes.push($(this).parent().attr("id"));
				break;
			case 3:
				miercoles.push($(this).parent().attr("id"));
			    break;
			case 4:
				jueves.push($(this).parent().attr("id"));
				break;
			case 5:
				viernes.push($(this).parent().attr("id"));
				break;
			 case 6:
				sabado.push($(this).parent().attr("id"));
				break;
			default:
					alert("ERROR Actividad.jsp");
				}
		});
		html.push("<input type=hidden id=testa  name='dias[0]' value="+domingo+">");
		html.push("<input type=hidden id=testa name='dias[1]'value="+lunes+">");
		html.push("<input type=hidden id=testa name='dias[2]'value="+martes+">");
		html.push("<input type=hidden id=testa name='dias[3]'value="+miercoles+">");
		html.push("<input type=hidden id=testa name='dias[4]'value="+jueves+">");
		
		html.push("<input type=hidden id=testa name='dias[5]'value="+viernes+">");
		html.push("<input type=hidden id=testa name='dias[6]'value="+sabado+">");

		form.append(html.join(''));
		return form;
    }
});

actividadRender=new ActividadRender();