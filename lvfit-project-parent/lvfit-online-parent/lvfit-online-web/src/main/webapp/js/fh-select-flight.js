$(function() {
	$(document).bind("click", function() {
		$(".select-class-list").hide();
	});
	var $fhSearch = $(".fh-search");
	var $fhCondition = $(".fh-condition");
	$(".fh-edit-btn").on("click", function() {
		$fhCondition.hide();
		$fhSearch.show();
	});
	$(".fh-cancel-btn").on("click", function() {
		$fhSearch.hide();
		$fhCondition.show();
	});	$('.search_kind').click(function(e){

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
	});
	$(".select-class").on("click", function(e) {
		var event = e || window.event;
		event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
		$(".select-class-list").hide();
		var $this = $(this);
		var thisL = $this.offset().left,
			thisT = $this.offset().top,
			thisH = $this.outerHeight(true);
		$this.siblings(".select-class-list").show().css({
			'left': thisL,
			'top': thisT + thisH + 2
		});
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
});