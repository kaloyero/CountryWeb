jQuery(function($){
	var css = document.createElement('link');
	css.type = 'text/css';
	css.rel= 'stylesheet';
	css.href= '//fonts.googleapis.com/css?family=Oleo+Script|Lovers+Quarrel|Norican|Berkshire+Swash|Crete+Round|Yellowtail';
	
	document.getElementsByTagName('head')[0].appendChild(css);
	
	var text = $.trim(window.jtypo.css('visibility', 'visible').text()),
		words = text.split(' '),
		jmasonry = $('<div id="typo-masonry">').css({
			margin: '0 auto',
			overflow: 'hidden'
		}).appendTo(window.jtypo.empty()),
		
		janchor = $('<div id="typo-anchor"></div>').insertAfter(window.jtypo),
		ewords = [],
		page = 0,
		kpagesize = 7;
		
	for(var i = 0, il = words.length; i < il; i++){
		ewords.push($('<div class="item typo ' + (Math.random() < 0.6 ? '' : (Math.random() > 0.7 ? 'grid-double' : 'grid-tripple')) +'"><div class="inner item-inner clearfix typo' + (Math.floor(Math.random() * 22) + 1) + '">' + words[i].replace(/_/g, ' ') + '</div></div>')[0]);
	}

	$('#content').css('width', '100%');
	$('#toolbar').css('display', 'none');

	jmasonry.append(ewords.slice(0, 10));
	page += 10;

	jmasonry.masonry({
		itemSelector: '.item'
	});
	
	$(window).unbind('smartscroll.typo').bind('smartscroll.typo', function(){
		if(page < ewords.length && ( $(window).scrollTop() + $(window).height() + 50 >  janchor.offset().top) ){
			jmasonry.masonry('appended', $(ewords.slice(page, page + kpagesize)).appendTo(jmasonry), true);
			page += kpagesize;
		}
	}).trigger('smartscroll.typo');
	
	$(window).load(function(){
		jmasonry.masonry('reload');
		
		while($(document).height() < $(window).height() && page < ewords.length){
			$(window).trigger('smartscroll.typo');
		}
	});
});