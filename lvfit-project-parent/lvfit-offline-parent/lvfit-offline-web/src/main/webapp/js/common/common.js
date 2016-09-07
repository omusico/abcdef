(function($) {
   $.common = {};
	 //-- 浏览器工具 --//
   $.common.browser = {
       // 检测是否是IE浏览器
       isIE: function() {
           var _uaMatch = $.uaMatch(navigator.userAgent);
           var _browser = _uaMatch.browser;
           if (_browser == 'msie') {
               return true;
           } else {
               return false;
           }
       },
       // 检测是否是chrome浏览器
       isChrome: function() {
           var _uaMatch = $.uaMatch(navigator.userAgent);
           var _browser = _uaMatch.browser;
           if (_browser == 'webkit') {
               return true;
           } else {
               return false;
           }
       },
       // 检测是否是Firefox浏览器
       isMozila: function() {
           var _uaMatch = $.uaMatch(navigator.userAgent);
           var _browser = _uaMatch.browser;
           if (_browser == 'mozilla') {
               return true;
           } else {
               return false;
           }
       },
       // 检测是否是Firefox浏览器
       isOpera: function() {
           var _uaMatch = $.uaMatch(navigator.userAgent);
           var _browser = _uaMatch.browser;
           if (_browser == 'opera') {
               return true;
           } else {
               return false;
           }
       }
   };
	
   
	//////////////////////////////jquery公用方法
	$.getAjaxHtmlData = function(url, data) {
		var htmlData =null;
		$.ajax({
			type : "post",
			url : url,
			async : false,
			data : arguments[1] || {},
			success : function(result) {
				htmlData = result;
			}
		});
		return htmlData;
	};
	
	
	//select初始化
	$.fn.selectInit = function(options) {
		var that = this;
		$(this).empty();
		if (options.defaults) {
			$(this).append(
					"<option value=" + options.defaults.key + ">" + options.defaults.value
							+ "</option>");
		}

		var key = "id", value = "text";
		if (options.mapping) {
			key = options.mapping.key;
			value = options.mapping.value;
		}
		
		$(options.data).each(function(num, item) {
			var $d1 = $("<option value='" + item[key] + "'>" + item[value] + "</option>");
		    $d1.data("optionData", item);
		    $(that).append($d1);
		});
		$(this).bind("change", options.onChange);
		return this;
	};
	
	//弹出框
	$.fn.showbox = function(options){
		// var $height = window.screen.availHeight ;
		// var $width = window.screen.availWidth;
		var $height = $(window).height();
		var $width = $(window).width();
		var $w = parseInt($width - $(this).width() ) / 2;
		var $h = parseInt($height - $(this).height() ) / 2;
		var data = {};
		data.zindex = 8000;
		data.top = $h;
		data.left = $w;
		data = $.extend(data,options);    
		var $htmls = "<div class='showbox' style='position:fixed;top:0;left:0;background:rgba(0,0,0,0.1)!important;z-index:"+data.zindex+";background-color:#000; filter:alpha(opacity=70);";
		$htmls += "width:" + $width + "px;height:" + $height + "px;'></div>";
		$('body').append($htmls);
		$(this).css({ "top":data.top + "px", "left":data.left + "px" });
		$(this).show();
	}
	
	//弹出新窗口
	$.newTabWindow = function(url){
	    var linking = $("<a href='" + url + "' target='_blank'>Hiaas</a>").get(0); 
	    if (/firefox/.test(navigator.userAgent.toLowerCase())) {
    		var ev = document.createEvent('MouseEvents'); 
      	    ev.initEvent('click', true, true);
      	    linking.dispatchEvent(ev);
    	} else if (/opera/.test(navigator.userAgent.toLowerCase())) {
	    	//FOR CHROM 默认
    	    var ev = document.createEvent('HTMLEvents'); 
      	    ev.initEvent('click', true, true);
      	    linking.dispatchEvent(ev);
    	}
	};
	
})(jQuery);


//////////////////////////////////////////js方法扩展区

String.prototype.trim = function() {
    return this.replace(/(^\s+)|\s+$/g, "");
};

/**
 * 转换字符串为json对象
 */
String.prototype.toJson = function() {
    return eval('(' + this + ')');
};

String.prototype.endsWithIgnoreCase = function(str) {
    return (this.toUpperCase().match(str.toUpperCase() + "$") == str.toUpperCase()) ||
    (this.toLowerCase().match(str.toLowerCase() + "$") == str.toLowerCase());
}

/**
 * 输出2010-02-05格式的日期字符串
 *
 * @return {}
 */
Date.prototype.toDateStr = function() {
    return ($.common.browser.isMozila() || $.common.browser.isChrome() ? (this.getYear() + 1900) : this.getYear()) + "-" +
    (this.getMonth() < 10 ? "0" + this.getMonth() : this.getMonth()) +
    "-" +
    (this.getDate() < 10 ? "0" + this.getDate() : this.getDate());
};

/**
 * 日期格式化
 * @param {Object} format
 */
Date.prototype.format = function(format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}


/**
 * 将字符串格式的日期转换为日期类型对象
 * @param {Object} strDate
 */
Date.toDate = function(strDate) {
    var strDs = strDate.split('-');
    var year = parseInt(strDs[0]);
    var month = parseInt(strDs[1]);
    var date = parseInt(strDs[2]);
    return new Date(year, month, date);
};

/**
 * 通过当前时间计算当前周数
 */
Date.prototype.getWeekNumber = function() {
    var d = new Date(this.getFullYear(), this.getMonth(), this.getDate(), 0, 0, 0);
    var DoW = d.getDay();
    d.setDate(d.getDate() - (DoW + 6) % 7 + 3); // Nearest Thu
    var ms = d.valueOf(); // GMT
    d.setMonth(0);
    d.setDate(4); // Thu in Week 1
    return Math.round((ms - d.valueOf()) / (7 * 864e5)) + 1;
}


//+---------------------------------------------------
//| 日期计算
//+---------------------------------------------------
Date.prototype.DateAdd = function(strInterval, Number) {
    var dtTmp = this;
    switch (strInterval) {
        case 's':
            return new Date(Date.parse(dtTmp) + (1000 * Number));
        case 'n':
            return new Date(Date.parse(dtTmp) + (60000 * Number));
        case 'h':
            return new Date(Date.parse(dtTmp) + (3600000 * Number));
        case 'd':
            return new Date(Date.parse(dtTmp) + (86400000 * Number));
        case 'w':
            return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
        case 'q':
            return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'm':
            return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        case 'y':
            return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
    }
};

//-- Javascript对象扩展--结束 -//

//-- 自定义类-开始 --/
function StringBuffer() {
    this._strings_ = new Array();
}

StringBuffer.prototype.append = function(str) {
    this._strings_.push(str);
    return this;
};

StringBuffer.prototype.toString = function() {
    return this._strings_.join("").trim();
};



Array.prototype.remove=function(dx)
{
  if(isNaN(dx)||dx>this.length){return false;}
  for(var i=0,n=0;i<this.length;i++)
  {
      if(this[i]!=this[dx])
      {
          this[n++]=this[i];
      }
  }
  this.length-=1;
};

function getAjaxData(fromId){
	var formArray = $("#"+fromId).serializeArray();
	var data = {};
	for(var i =0;i<formArray.length;i++){
		data[formArray[i].name] = formArray[i].value;
	}
	return data;
}

/**
 *  分布公共方法：适用于弹出层方法。
 *  实现算法效果： 第一个2 3 4 5 6 最后一个。 中间显示5个。
 * @param pagination
 * @param selectClass 当前页的样式 名称
 * @param fenyeFn  上一页|下一页方法 名称
 */
function getPageHtml(pagination,selectClass,fenyeFn){
	if(pagination.records <= 1) return "";
	var page = pagination.page;   //当前页数
	var records = pagination.records;   //总记录数
	var rows = pagination.rows;  	//每页数量
	var total = pagination.total;   //总页数
	
	var html = "<span>共<font>"+records+"</font>条</span>";
	if(page>1){
		html += '<a class="prevpage" href="javascript:'+fenyeFn+'('+(page-1)+ ')"><i class="larr"></i></a>';
	}
	if(total<=7){
		for(var i=1;i<=total;i++){
			if(i == page){
				html += '<a class="'+selectClass+'" href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
			}else{
				html += '<a href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
			}
		}
	}else{
		if(page<=4){
			for(var i=1;i<=7;i++){
				if(i == page){
					html += '<a class="'+selectClass+'" href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}else{
					html += '<a href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}
			}
			html += "...";
			html += '<a href="javascript:'+fenyeFn+'('+total+')">'+total+'</a>';
		}else if(page>4 && page+3<total){
			html += '<a href="javascript:'+fenyeFn+'(1)">1</a>';
			html += "...";
			for(var i=page-2;i<=page+2;i++){
				if(i == page){
					html += '<a class="'+selectClass+'" href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}else{
					html += '<a href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}
			}
			html += "...";
			html += '<a href="javascript:'+fenyeFn+'('+total+')">'+total+'</a>';
		}else if(page+3>= total){
			html += '<a href="javascript:'+fenyeFn+'(1)">1</a>';
			html += "...";
			for(var i=total-5;i<=total;i++){
				if(i == page){
					html += '<a class="'+selectClass+'" href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}else{
					html += '<a href="javascript:'+fenyeFn+'('+i+')">'+i+'</a>';
				}
			}
		}
	}
	if(page<total){
		html += '<a class="nextpage" href="javascript:'+fenyeFn+'('+(page+1)+ ')"><i class="rarr"></i></a>';
	}
	return html;
}

/**
 *  根据身份证号获得生日
 * @param idCard
 * @returns {String}
 */
function getBirthdayByIdCard(idCard) {
  	var birthday = "";
	if(idCard != null && idCard != ""){
		if(idCard.length == 15){
			birthday = "19"+idCard.substr(6,6);
		} else if(idCard.length == 18){
			birthday = idCard.substr(6,8);
		}else{
			return "";
		}
		birthday = birthday.replace(/(.{4})(.{2})/,"$1-$2-");
	}
	return birthday;
  }

/**
 * 根据生日字符串获得年龄 
 * @param birthday_str ：yyyy-MM-dd
 * @returns {Number}
 */
function getAgeByBrithday(birthday_str){
	if(birthday_str == null || birthday_str== "" || birthday_str.length != 10){
		return -1;
	}
	 var age=-1;
	 var today=new Date();
	 var todayYear=today.getFullYear();
	 var todayMonth=today.getMonth()+1;
	 var todayDay=today.getDate();
	 var birthday= new Date(birthday_str);
	 birthdayYear=birthday.getFullYear();
	 birthdayMonth=birthday.getMonth();
	 birthdayDay=birthday.getDate();
	 if(todayYear-birthdayYear<0) {
	       alert("出生日期不正确!");
	 } else {
        if(todayMonth*1 - birthdayMonth*1<0){
               age = (todayYear*1-birthdayYear*1)-1;
        } else {
               if(todayDay-birthdayDay>=0){
            	   //alert(thisDay+'-'+brithd+"_ddd");
                   age = (todayYear*1-birthdayYear*1);
               } else {
                    age = (todayYear*1-birthdayYear*1)-1;
               }
        }
	 }
	 return age*1;
}

function seoJustice(from,dest,hotel,key,baseUrl){
	//seo修改
    var that = this;
    $.ajax({//调接口并将请求的数据放到缓存中
        url: baseUrl+"/seo/queryTDK",
        data:{key:key},
        type:'GET',
        dataType:'json',
        success: function (res) {
            var data = res;
            if(key=="seotdk_fit_freetour"){
                data.title=data.title.replace(/\{dest}/g,dest);
                data.title=data.title.replace(/\{from}/g,from);
                data.title=data.title.replace(/\{hotel}/g,hotel);
                data.description=data.description.replace(/\{dest}/g,dest).replace(/\{from}/g,from);
            }
            if(data!=null&&data!=''){
            	document.getElementById("TITLE").innerHTML=data.title
                document.getElementById("DESC").content=data.description
                document.getElementById("KEYWORDS").content=data.keywords
            }
            
        },
        error: function (e) {

        }
    })

}    

/*function seoFriendLink(){
	$.ajax({
		url: baseUrl + "/seo/querySeoFriendLink",
		data: {},
		type: "GET",
		dataType: "json",
		success: function (result){
			var htmlLink = "";
			var link = JSON.parse(result);
			for(var i = 0; i < link.length; i++){
				
			}
		}
	})
	
}*/