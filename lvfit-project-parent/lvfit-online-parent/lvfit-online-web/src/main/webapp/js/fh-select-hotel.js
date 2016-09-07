(function() {
	$(document).bind("click", function() {
		$(".select-div-list").hide();
	});
	$('.roomName').click(function() {
		openRoom($(this));
	});
	$('.JS_showInfo').click(function() {
		showInfo($(this));
	});

	function openRoom(elm, act) {
		var $roomLi = elm.parents('.roomLi');
		var $hideBox = $roomLi.next('.romLi-more');
		var $arrow = elm.children('i');
		var $showInfo = $hideBox.find('.JS_showInfo');
		if (act == "open") {
			$roomLi.addClass('open');
			$hideBox.show();
			$arrow.attr('class', 'arrow_up');
			showInfo($showInfo, "close");
			return;
		} else if (act == "close") {
			$roomLi.removeClass('open');
			$hideBox.hide();
			$arrow.attr('class', 'arrow');
			return;
		}
		if ($roomLi.hasClass('open')) {
			$roomLi.removeClass('open');
			$hideBox.hide();
			$arrow.attr('class', 'arrow');
		} else {
			$roomLi.addClass('open');
			$hideBox.show();
			$arrow.attr('class', 'arrow_up');
			showInfo($showInfo, "open");
		}
	}

	function showInfo(elm, act) {
		var $s_arrow = elm.children('i'),
			$info_box = elm.next('.info_box'),
			_act = act;
		if (!act) {
			_act = $info_box.is(':hidden') ? "open" : "close";
		}
		if (_act == "open") {
			$info_box.show();
			elm.html('收起房型设施<i class="arrow_up"></i>');
			return;
		} else if (_act == "close") {
			$info_box.hide();
			elm.html('查看房型设施<i class="arrow"></i>');
			return;
		}
	}
	$('.JS_showAllRoom').click(function(e) {
		var $me = $(this);
		var $html = $me.html();
		if ($me.children('.arrow').length > 0) {
			$me.html($html.replace('展开', '收起').replace('arrow', 'arrow_up'));
			 try{
            	var fj=e.target.parentNode.parentNode.children;
				// var fjc=e.target.parentNode.parentNode.children;
				window.fj=fj;
				// window.fjc=fjc;
        	}catch(e){
            	var fj=window.fj;
				// var fjc=window.fjc;
        	}
			
			for(var i=0;i<fj.length;i++){
				if(fj[i].className.indexOf("romLi-more_1")!=-1){
					fj[i].className=fj[i].className.replace('romLi-more_1', 'roomLi');
				}
			}
		} else {
			
			$me.html($html.replace('收起', '展开').replace('arrow_up', 'arrow'));
			 try{
            	var fj=e.target.parentNode.parentNode.children;
				// var fjc=e.target.parentNode.parentNode.children[0];
        		window.fj=fj;
				// window.fjc=fjc;
        	}catch(e){
            	var fj=window.fj;
				// var fjc=window.fjc;
        	}
			// var fj=e.target.parentNode.parentNode.children[0].children;
			// var fjc=e.target.parentNode.parentNode.children[0];
			for(var i=7;i<fj.length;i++){
				if(fj[i].className.indexOf("roomLi")!=-1){
					fj[i].className=fj[i].className.replace('roomLi', 'romLi-more_1');
				}
			}
		}
	});

	$('.js_moreSearch').click(function() {
		var $me = $(this),
			$prev = $me.prev();
		if ($prev.hasClass('search_more')) {
			$me.html('更多<i class="arrow"></i>');
			$prev.removeClass('search_more');
		} else {
			$me.html('收起<i class="arrow_up"></i>');
			$prev.addClass('search_more');
		}
	});

	$(".xuanze").click(function(e){
		$(".selectedBtn").html("选择");
		$(".selectedBtn").attr("class","btn btn-small btn-orange xuanze");
		e.target.className="selectedBtn";
		e.target.innerHTML="已选"+"<span class='ph_icon ph_icon_selected'></span>";

	});

	$('.search_kind').click(function(e){

		if(e.target.innerHTML=="全部"){
			if(e.target.parentNode.className=="active_1"){
				for(var i=1;i<e.target.parentNode.parentNode.childElementCount;i++){
					if(i==1){
						e.target.parentNode.parentNode.children[i].className="kind_buxian";
					}else{
						e.target.parentNode.parentNode.children[i].className="";
					}
				}
			}else{
				for(var i=1;i<e.target.parentNode.parentNode.childElementCount;i++){
					if(i==1){
						e.target.parentNode.parentNode.children[i].className="active_1";
					}else{
						e.target.parentNode.parentNode.children[i].className="active";
					}
				}
			}
			
		}else{
		if(e.target.tagName=="I"){
			if(e.target.parentNode.parentNode.className=="active"){
				e.target.parentNode.parentNode.className="";
			}else{
				e.target.parentNode.parentNode.className="active";
			}
		}else if(e.target.tagName=="A" && (e.target.className.indexOf("js_moreSearch")!=-1 || e.target.className.indexOf("JS_showAllRoom")!=-1)){
			return;
		}else if(e.target.tagName=="DIV" || e.target.tagName=="DL" || e.target.parentNode.tagName=="DL"){
			return;
		}else{
			if(e.target.parentNode.className=="active"){
				e.target.parentNode.className="";
			}else{
				e.target.parentNode.className="active";
			}
		}
		}
		var qq="<dt>您已选择：</dt>";
		var ee="<dd><a class='close_all' href='javascript:;'>清除所有条件</a></dd>";
		var aa="";
		var count=$('.filter .search_kind').children().children().length;
		for(var j=0;j<count;j++){
			if($('.filter .search_kind').children().children()[j].className=="active"){
				aa+="<dd><span>"+ $('.filter .search_kind').children().children()[j].innerText+"<a class='request_close' href='javascript:;' title='删除'>×</a></span></dd>";
			}
		}
		if(aa=="" || aa==null){
			$(".request_list").html(qq+aa);
		}else{
			$(".request_list").html(qq+aa+ee);
		}
	$('.request_close').click(function(e){
		var ee=e.target.parentNode.parentNode.innerHTML;
		e.target.parentNode.parentNode.innerHTML="";
		if($('.request_close').length == 0){
			$(".close_all").hide();
		}
		for(var j=0;j<count;j++){
			var ii=$('.filter .search_kind').children().children()[j].innerHTML;
			if(ee.substring(6,ee.indexOf("<a"))==ii.substring(ii.indexOf("</i>")+4,ii.length-4)){
				if(ii.indexOf("全部")!=-1){
					$('.filter .search_kind').children().children()[j].className="kind_buxian";
				}else{
					$('.filter .search_kind').children().children()[j].className="";
				}
			}
		}
		if($('.request_close').length == 0){
			for(var j=0;j<count;j++){
				if($('.filter .search_kind').children().children()[j].innerHTML.indexOf("全部")!=-1){
					$('.filter .search_kind').children().children()[j].className="kind_buxian";
				}else{
					$('.filter .search_kind').children().children()[j].className="";
				}
			}
		}
	});
	$('.close_all').click(function(e){
		var count1=e.target.parentNode.parentNode.childElementCount;
				for(var i=1;i<count1;i++){
					e.target.parentNode.parentNode.children[i].innerHTML="";
				}
			for(var j=0;j<count;j++){		
				if($('.filter .search_kind').children().children()[j].innerHTML.indexOf("全部")!=-1){
					$('.filter .search_kind').children().children()[j].className="kind_buxian";
				}else{
					$('.filter .search_kind').children().children()[j].className="";
				}
				
		}
	});

	$('.qx_close_all').click(function(e){
		var count1=$('.close_all')[0].parentNode.parentNode.childElementCount;
				for(var i=1;i<count1;i++){
					$('.close_all')[0].parentNode.parentNode.children[i].innerHTML="";
				}
			for(var j=0;j<count;j++){		
				if($('.filter .search_kind').children().children()[j].innerHTML.indexOf("全部")!=-1){
					$('.filter .search_kind').children().children()[j].className="kind_buxian";
				}else{
					$('.filter .search_kind').children().children()[j].className="";
				}
				
		}
	});


	});
	$(".select-div").on("click", function(e) {
		var event = e || window.event;
		event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
		$(".select-div-list").hide();
		var $this = $(this);
		var thisL = $this.offset().left,
			thisT = $this.offset().top,
			thisH = $this.outerHeight(true);
			if(e.target.className=="select-div1"){
				$this.siblings(".select-div-list").show().css({
				'left': thisL,
				'top': thisT + thisH - 10
				});
			}else{
				$this.siblings(".select-div-list").show().css({
				'left': thisL,
				'top': thisT + thisH - 1
				});
			}
		
	});

	$(".select-div-list li").on("click", function(e) {
		var event = e || window.event;
		event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
		var value = $(this).data("num");
		var $parent = $(this).parent();
		$parent.siblings(".select-div").find("span").html(value);
		$parent.siblings(".select-div1").find("span").html(value);
		$parent.hide();
	});
})();