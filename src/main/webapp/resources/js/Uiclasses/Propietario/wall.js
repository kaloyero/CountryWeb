/**
 * ------------------------------------------------------------------------
 * JA Wall Template for Joomla25
 * ------------------------------------------------------------------------
 * Copyright (C) 2004-2011 J.O.O.M Solutions Co., Ltd. All Rights Reserved.
 * @license - Copyrighted Commercial Software
 * Author: J.O.O.M Solutions Co., Ltd
 * Websites:  http://www.joomlart.com -  http://www.joomlancers.com
 * This file may not be redistributed in whole or significant part.
 * ------------------------------------------------------------------------
 */

function createEffect(){ 
(window.$wall || window.jQuery)(function($){
	// Masonry corner stamp modifications
	$.Mason.prototype.resize = function() {
		//this._getColumns();
		//this._reLayout();
	};

	$.Mason.prototype._reLayout = function( callback ) {
		var freeCols = this.cols,
			cornerStampHeight = 0,
			cornerStampCols = 0;

		if ( this.options.cornerStampSelector ) {
			var $cornerStamp = this.element.find( this.options.cornerStampSelector );
			if($cornerStamp.length){
				freeCols = Math.floor((
					$cornerStamp.offset().left -
						(this.element.offset().left +
						this.offset.x +
						parseInt($cornerStamp.css('marginLeft')))) / this.columnWidth );

				cornerStampHeight = $cornerStamp.outerHeight(true);
				cornerStampCols = Math.ceil($cornerStamp.outerWidth(true) / this.columnWidth);
			}
		}

		// reset columns
		var i = this.cols,
			il = Math.min(freeCols + cornerStampCols, this.cols);

		this.colYs = [];
		while (i--) {
			this.colYs.push( this.offset.y );
		}

		for ( i = freeCols; i < il; i++ ) {
			this.colYs[i] = this.offset.y + cornerStampHeight;
		}

		// apply layout logic to all bricks
		this.layout( this.$bricks, callback );
	};
	//End Masonry modification

	var $container = $('#masonry-container'),
		itemSelector = '.item';



	// force show scrollbar
	$('#bd').css ('min-height', $(window).height() + 10);

	// add a blank, invisible masonry block to get the base width
	if (!$('#base-blank-item').length) {
		$('<div id="base-blank-item" class="' + itemSelector.substr(1) + '" style="height:0;visibility:hidden" />').appendTo ($container);
	}

	var uwsid = 0,
		lastWndWidth = 0,
		reloadMasonry = function () {
			//$(document.body).addClass ('masonry-relayout');
			$container.masonry('reload', function(){
				$(document.body).removeClass ('masonry-relayout');
			});
		},

		updateContainerWidth = function () {
			lastWndWidth = $(window).width();

			var cw = $('#base-blank-item').css('width', '').width(), // wrapper width
				mw = $container.width(), // wrap width
				cols = Math.round(mw / cw), //  detect number of columns by it's container
				cw_ = Math.floor(mw / cols), // update new width
				mw_ = cols * cw_;

			$('#base-blank-item').width(cw_);
			console.log("AUU",cw_)
			if ($container.data('basewidth') != cw_) {
				$container.data('basewidth', cw_);
				updateBrickWidth();
			}

			// reload layout
			reloadMasonry();
		},

		updateBrickWidth = function ($bricks) {

		};

	// init masonry
	$container.masonry({
		itemSelector: itemSelector,
		isResizable: false,
		cornerStampSelector: '.corner-stamp',
		columnWidth: function() {
			var size= $container.data ('basewidth')? $container.data ('basewidth') : $('#base-blank-item').width()
					console.log("size",size)
				return size
				
		}
	});

	// reload masonry when image loaded
	$container.imagesLoaded(function(){
		//lastWndWidth = -1; //force to reload
		updateContainerWidth();
	});




});
}