function getAllScenicFirstPage(){
	var selectDiv = $("div[data_scenic_dest_id]");
	var destStr = '';
	var destArray=[];
	var batchCount = 20 ; 
	var destIndex = 0 ; 
	$("div[data_show_scenic_tag]").each(function(){
		var destId = $(this).attr("data_scenic_dest_id");
		if(!isEmpty(destId)){
			destArray[destIndex] = destId;;
			destIndex++;
		}
		
	});
	var destAll = destArray.length;
	if(destAll > 0 ){
			var dealCount = parseInt(destAll/batchCount);
			var dealRemainCount = destAll%batchCount;
			var dealRemainStr ='';
			if(dealCount>0){
				for(var i=0;i<dealCount;i++){
					var  dealArray = destArray.slice(i*batchCount,(i+1)*batchCount);
					destStr = dealArray.join(",");
					getScenicPoiBatch(destStr);
				}
			}
			if(dealRemainCount>0){
				var remainArray = destArray.slice(dealCount*batchCount);
				dealRemainStr = remainArray.join(",");
				getScenicPoiBatch(dealRemainStr);
			}
			
			
			
		
		
	}
//	$("div[data_show_scenic_tag]").each(function(){
//			
//			var ele = $(this);
//			var destId = ele.attr("data_scenic_dest_id");
//			
//			$.ajax({
//	            url: "http://www.lvmama.com/lvyou/api/getPoiinfoByDestid?dest_id="+destId,
//	            
//	            dataType: 'JSONP',
//	            type: "GET",
//	            success: function(data) {
//	            	//待确定接口返回值
//            		if(data.code == 200){
//            			var  focus =  data.data[destId].focus;
//            			if(focus && !isEmpty(focus)){
//            				var url='';
//            				if(!isEmpty(focus[0])){
//            					url = focus[0].image; 
//            				};
//                			if(!isEmpty(url)){
//    		                	var photoLen = url.length-4;
//    		                	var photoType = url.substring(photoLen,photoLen+4);
//                				url = "http://pic.lvmama.com"+url.substring(0,photoLen)+"_180_120"+photoType;
//                				ele.find("img").eq(0).attr("src",url);
//                				ele.show();
//                			}
//            			}
//            		}
//		        },
//		        error:function(data){
//		        	console.log("error");
//		        	console.log(data);
//		        }
//        	});
//			
//			
//			
//	
//	});
	
	
	
	
}

function getScenicPoiBatch(destStr){
	
	var destArray =[]
	if(!isEmpty(destStr)){
		var url = "http://www.lvmama.com/lvyou/api/getPoiinfoByDestid?dest_id="+destStr;
		$.ajax({
            url: url,
            dataType: 'JSONP',
            type: "GET",
            success: function(data) {
	            var returnDataArray =[];
            	//待确定接口返回值
        		if(data.code == 200){
        			destArray = destStr.split(",");
        			returnDataArray = data.data;
        			var destOne;
        			if(!isEmpty(returnDataArray)){
        				for(destOne in returnDataArray){
        					var focus = returnDataArray[destOne].img_url;
        					var url = '';
        					if(!isEmpty(focus)){
        						url = focus;
        					}
        					if(!isEmpty(url)){
        						var photoLen = url.length-4;
    		                	var photoType = url.substring(photoLen,photoLen+4);
    		                	var urlSeparator = url[0]!='/'?'/':'';
                				url = "http://pic.lvmama.com"+urlSeparator+url.substring(0,photoLen)+"_300_200"+photoType;
                				var ele = $("div[data_show_scenic_tag][data_scenic_dest_id="+destOne+"]").eq(0);
                				ele.find("img").eq(0).attr("src",url);
                				ele.show();
        					}
        				}
        			}
        		}
	        },
	        error:function(data){
	        	console.log("error");
	        	console.log(data);
	        }
    	});
						
	}
	
}


 $(function(){
 	//调取所有景点模板第一张图片展示
 	getAllScenicFirstPage();
 	//绑定酒店点击弹框
 	$("[data_hotel_product_id]").live("click", function(){
 		showYinDialog(false, true, true);
 		var productId = $(this).attr("data_hotel_product_id");
        getHotelInfo(productId);    
 	});
 	//绑定景点点击弹框
 	$("[data_scenic_dest_id]").live("click",function(){
 		showYinDialog(true,true,true);
 		var destId = $(this).attr("data_scenic_dest_id");
 		//getScenicInfo(destId);
 		_getScenicOne(destId);
 		
 	})
 });
 
 
 function getHotelInfo(productId){
 	var hotelInfoUrl = "/vst_front/route/localAndOutBu/getHotelInfo";
 	 $.ajax({
	 		url: "${request.contextPath}/serverProxy",
	        type: "get",
	        dataType: 'html',
            data: {
            	requestStr:"http://dujia.lvmama.com/vst_front/route/localAndOutBu/getHotelInfo?productId="+productId
            },
            success: function(data) {
            	if(data && data!=''){
            		$(".yin-dialog").eq(0).find(".yin-dialog-basic").remove();
            		$(".yin-dialog").eq(0).find(".yin-dialog-comments").remove();
            	    var	t = $(".yin-dialog").eq(0).find(".ph_icon_close_dialog").eq(0);
            		t.after(data);
            		tt();
            		
            	}
            	removeYinDialogLoading();
            },
			error:function(data){
            	removeYinDialogLoading();
			}
        });
 }
 
 function getScenicInfo(destId){
 	
 	var scenicInfoUrl = "/vst_front/route/localAndOutBu/getScenicInfo";
 	 $.ajax({
            url: "${request.contextPath}/serverProxy",
            cache : false,
			async : false,
            type: "get",
            dataType: 'html',
			data:{
				requestStr:"http://dujia.lvmama.com/vst_front/route/localAndOutBu/getScenicInfo?destId="+destId
			},
            success: function(data) {
            	if(data && data!=''){
            		$(".yin-dialog").eq(0).find(".yin-dialog-basic").remove();
            		$(".yin-dialog").eq(0).find(".yin-dialog-comments").remove();
            	    var	t = $(".yin-dialog").eq(0).find(".ph_icon_close_dialog").eq(0);
            		t.after(data);
            		tt();
            	}
            	removeYinDialogLoading();
            	
            	
            }
        });
 }
 
 function isEmpty(value) {
     if (typeof(value) == 'undefined' || value == null || value == "") {
         return true;
     } else {
         return false;
     }
 }
 function  tt(){
	 $.yinSlider({
	     sliderDiv: $(".yin-dialog-slider"),
	     picBox: $(".slider-pic-box"),
	     leftBtn: $(".slider-btn-left"),
	     rightBtn: $(".slider-btn-right"),
	     btn: $(".slider-btn")
	 });
	 
 }
 
 /**
  * 获取poi信息
  * @param destId 景点poi id
  * */
 function _getScenicOne(destId){
	 var poiHtml = '';
	 $.ajax({
         url: "http://www.lvmama.com/lvyou/api/getPoiinfoByDestid?dest_id="+destId,
         
         dataType: 'JSONP',
         type: "GET",
         success: function(data) {
         	//待确定接口返回值
     		if(data.code == 200){
     			if(data && !isEmpty(data)){
     				poiHtml = _buildPoi(data,destId);
     			}
     			_getComment(destId,'DEST',poiHtml);
     			
	        }else{
	        	removeYinDialogLoading();  
	        }
	     },error:function(data){
	    	removeYinDialogLoading();
        	console.log("error");	        	
	     }
 	});
	 
 }
 
 /**
  * 构建poi信息
  * */
 function _buildPoi(data,destId){
	var totalHtml = ""; 
	 
	var  focus =  data.data[destId].focus;
	var urlHtml = '<div class="yin-dialog-slider">';
	var urlOneAndMoreHtml = '';
	var urlComtentHtml = '<ul class="slider-pic-box">';
	if(focus && !isEmpty(focus)){
		var length = focus.length;
		if(length >0){
			if(length>1){
				urlOneAndMoreHtml = '<a class="slider-btn slider-btn-left" href="javascript:;"></a><a class="slider-btn slider-btn-right" href="javascript:;"></a>';
			}
			
			var arrayW = length;
			if(length>5){
				arrayW = 5;
			}
			for(var i=0;i<arrayW;i++){
				if(!isEmpty(focus[i])){
					var url = focus[i].image;
					if(!isEmpty(url)){
			         	var photoLen = url.length-4;
			         	var photoType = url.substring(photoLen,photoLen+4);
						url = 'http://pic.lvmama.com'+url.substring(0,photoLen)+'_480_320'+photoType;
					}else{
						url = 'http://pic.lvmama.com/img/cmt/img_480_320.png';
					}
					urlComtentHtml += '<li><img src='+url+' width="460" height="308"></li>';
				}
			}
		}
	}else{
		urlComtentHtml = '<li><img src="http://pic.lvmama.com/img/cmt/img_480_320.png" width="460" height="308"></li>';
	}
	urlComtentHtml += '</ul>';
	urlHtml += urlOneAndMoreHtml;
	urlHtml += urlComtentHtml;
	urlHtml+='</div>'
	totalHtml += urlHtml;
	
	var poiInfoHtml = '<div class="yin-dialog-info">';
	var poiTitleHtml = '';
	var dest_name = data.data[destId].dest_name;
	var star = data.data[destId].star;
	var starHtml = "";
	if(star && !isEmpty(star)){
		starHtml = '<span>[<em>'+star+'A</em>景区]</span>';
	}
	if((dest_name && !isEmpty(dest_name)) || (star && !isEmpty(star))){
		poiTitleHtml += '<p class="yin-dialog-title">';
		if(dest_name && !isEmpty(dest_name)){
			poiTitleHtml += dest_name;
		}
		if(!isEmpty(starHtml)){
			poiTitleHtml += starHtml;
		}
		poiTitleHtml +='</p>';
	}
	poiInfoHtml += poiTitleHtml;
	
	
	var addr = data.data[destId].addr;
	var address ="";
	var addressHtml = "";
	if(addr && !isEmpty(addr)){
		address = addr[0]['address'];
		if(address && !isEmpty(address)){
			addressHtml = '<p class="yin-dialog-location"><i></i>'+address+'</p>';
		}
		
	}
	poiInfoHtml += addressHtml;
	console.log(data.data[destId]);
	var intro = data.data[destId].dest_summary;
	var introHtml = "";
	if(intro && !isEmpty(intro) && !isEmpty(focus)){
		intro = _removeHTMLTag(intro);
		intro = intro.replace('"','\'') ;
		if(intro.length > 400){
			var introTmp = intro.substring(0,400);
			if(introTmp._endWithPoi(" ") || introTmp._endWithPoi("\r") || introTmp._endWithPoi("\n")){
				intro = intro.substring(0,395)+"...";
			}
		}
		introHtml ='<p class="yin-dialog-detail">'+intro+'</p>';
	} 
	poiInfoHtml += introHtml;
	poiInfoHtml += '</div>';	
	totalHtml += poiInfoHtml;
	return totalHtml;
 }
 
 /**
  * @param id 产品目的地id
  * @param type PROUDCT,DEST
  * */
 function _getComment(id,type,poiHtml){
	 var commentHtml = "";
	 $.ajax({
		url: "${request.contextPath}/serverProxy",
		cache : false,
		async : false,
		type : 'get',
		data:
		{
			requestStr:"http://dujia.lvmama.com/vst_front/route/localAndOutBu/getCommentByProductId?type="+type+"&productId=" +id
		},
		success: function(data) {
        	if(data && data!=''){
        		var attributes = data.attributes;
        		if(data.code == 'success' && (attributes && !isEmpty(attributes))){
        			if(attributes.comment && !isEmpty(attributes.comment) ){
        				var commentVo = attributes.comment;
        				//存在点评
        				if(commentVo && !isEmpty(commentVo)){
        					commentHtml = _buildComment(commentVo);
        				}
        				_appendPoiHtml(poiHtml,commentHtml);
        				
        			}else{
        				_appendPoiHtml(poiHtml,commentHtml);
        			}
        		}else{//
        			_appendPoiHtml(poiHtml,commentHtml);
        		}
        	}else{
        		_appendPoiHtml(poiHtml,commentHtml);
        	}        	
        	
        },
        error:function(data){
        	_appendPoiHtml(poiHtml,commentHtml);
        }
		 
	 });
	 
 }
 /**
  * 构建点评html
  * */
 function _buildComment(commentVo){
	 var commentHtml = '<div class="yin-dialog-comments"><p class="yin-dialog-comments-title">驴友点评</p><ul class="yin-dialog-comments-content">';
	 var cmtCommentList = commentVo.cmtCommentList;
	 if(cmtCommentList && !isEmpty(cmtCommentList) && cmtCommentList.length >0){
		 for(var i=0;i<cmtCommentList.length;i++){
			 var commentHtmlOne = '<li class="ydcc-item">';
			 commentHtmlOne += '<p class="ydcc-content">'+cmtCommentList[i].content+'</p>';
			 var commentUser = cmtCommentList[i].replaceOrCutUserName ;
			 if(!(cmtCommentList[i].replaceOrCutUserName && !(isEmpty(cmtCommentList[i].replaceOrCutUserName)))){
				 commentUser = '匿名';
			 }
			 commentHtmlOne += '<p class="ydcc-user">'+commentUser+'</p>';
			 commentHtmlOne += '&emsp;发表';
			 if(cmtCommentList[i].createdTime && !isEmpty(cmtCommentList[i].createdTime)){
				 commentHtmlOne += '点评于&emsp;';
				 commentHtmlOne += formatDate(cmtCommentList[i].createdTime);
			 }
			 commentHtmlOne += '</p>';
			 commentHtmlOne += '</li>';
			 commentHtml += commentHtmlOne;
		 }
	 }else{
		 commentHtml += '<li>暂无点评</li>';
	 }
	 
	 commentHtml+='</ur></div>'
     return commentHtml;
 }
 
 function _appendPoiHtml(poiHtml,commentHtml){
	 if(!isEmpty(poiHtml)){
		 $(".yin-dialog").eq(0).find(".yin-dialog-basic").html(poiHtml);
	 }
	 if(!isEmpty(commentHtml)){
		$(".yin-dialog").eq(0).find(".yin-dialog-comments").html(commentHtml);
	 }
	tt();
	removeYinDialogLoading();
 }
 
 function formatDate(date) {
	 date = new Date(date);
     var y = date.getFullYear();  
     var m = date.getMonth() + 1;  
     m = m < 10 ? '0' + m : m;  
	 var d = date.getDate();  
	 d = d < 10 ? ('0' + d) : d;  
	 return y + '-' + m + '-' + d;  
 };  
 String.prototype._endWithPoi= function(str){
	if(str==null||str==""||this.length==0||str.length>this.length){
		return false; 
	}
	if(this.substring(this.length-str.length)==str){
		return true;
	}else{
		return false;
	}
	  
	return true;
 }
 /**
  * 去除字符串 中的html标签
  * */
 function _removeHTMLTag(str){
	  str = str.replace(/<\/?[^>]*>/g,''); //去除HTML tag
	  str = str.replace(/[ | ]*\n/g,'\n'); //去除行尾空白
	  str = str.replace(/\n[\s| | ]*\r/g,'\n'); //去除多余空行
	  str=str.replace(/&nbsp;/ig,'');//去掉&nbsp;
	  str = str.replace(/^\s+|\s+$/g,"");//去除首尾空白
	  return str;
}
