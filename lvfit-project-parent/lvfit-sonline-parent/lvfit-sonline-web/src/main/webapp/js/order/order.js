// JavaScript Document

var totalSalesAmount;
//获得商品总价格
function initPrice(_shopingUUID){
   $.ajax({
       type: "post",
       async: false,
       dataType: "json",
       url: basePath+"/calucateAmount",
       data: {
           shoppingUUID:_shopingUUID
       },
       success: function(obj) {
           $("#salesPrice").html(obj.result.totalAmount);
           totalSalesAmount = obj.result.totalAmount;
       },
       error:function(data)
       {
         $('.returnAlert').stop(true,true).fadeIn();
         $('.resortOver').stop(true,true).fadeIn();
         $("#errorMsg").html("你选择的航班已售完");
       }
   });
};

//点击提交订单按钮，进行验证
function infoSubmit(shopingUUID,_adultCount,_childCount,quantity){
	var check = checkBooking(_adultCount,_childCount,quantity);
	if(check){
	    //登录验证
	    fit.login.booking.check(function(){
	    	submit(shopingUUID,_adultCount,_childCount,true,quantity);
	    },function(){
	    	callBackSubmit(shopingUUID,_adultCount,_childCount,quantity);
	    });
	}
}

function callBackSubmit(shopingUUID,_adultCount,_childCount,quantity){
	loginCallback();//先登录,再刷新登录用户信息
	submit(shopingUUID,_adultCount,_childCount,true,quantity);
	if(!checkBooking(_adultCount,_childCount,quantity)){
	    location.reload();
	}
}

//提交订单
function submit(shopingUUID,_adultCount,_childCount,isWriteInfoRecord,quantity){
	if(!checkBooking(_adultCount,_childCount,quantity)||!yanzhengOk()){
		return;
	}
	//alert("成功提交了");return;
	//提交之前记录一下信息，方便失败的时候信息回填
	if(isWriteInfoRecord){
		//writeInfoRecord();
	}
	
	 var data = {};
	 //游玩人组装
	 var _passengers = getPassengers();
	 data.playerList = JSON.stringify(_passengers);
	
	 //购买人信息
	 data.name = $(".js_copy_info").find("input[type_name='text']").val();
	 data.mobile = $(".js_copy_info").find("input[type_name='mobile']").val();
	 data.email = $(".js_copy_info").find("input[type_name='email']").val();
	 data.receiverId = $(".js_copy_info").find(":hidden[name='receiverId']").val();
	 data.certType = $(".js_copy_info").find(":hidden[name='certType']").val();
	 data.certNo = $(".js_copy_info").find(":hidden[name='certNo']").val();
	 data.peopleType = $(".js_copy_info").find(":hidden[name='peopleType']").val();
	 data.birthday = $(".js_copy_info").find(":hidden[name='birthday']").val();
	
	 data.visitTime = $("#departureTime").html();
	 data.shoppingUUID = shopingUUID;
	 data.totalPrice = totalSalesAmount;
	 data.productName = $("#fit_productName span").html().trim();
	 //alert("成功提交了");return;
	 $(".dialog-close").click();
	 $(".fh-overlay, .fh-dialog-loading").show();
	 // 隐藏正在加载dialog
	  $.ajax({
	   type: "post",
	   async: true,
	   dataType: "json",
	   url: basePath+"/order/Booking",
	   data:data,
	   success: function(result) {
	     $(".fh-overlay, .fh-dialog-loading").hide();
	     window.location.href=result.successUrl;
	   },
	   error:function(obj)
	   { 
	     $(".fh-overlay, .fh-dialog-loading").hide();
	     $('.returnAlert').stop(true,true).fadeIn();
	     $('.resortOver').stop(true,true).fadeIn();
	     
	     $("#errorMsg").html("抱歉，订单提交失败，请稍候重试");
	   }
	});
}

//验证下单之前的数据
function checkBooking(adults,childs,quantity){
 //这里只做，成人儿童数的验证
 var adultNum = 0;
 var childNum = 0;
 var goodsQuantity = 1;
 if(quantity!==undefined && $.trim(quantity)!=="" && (!isNaN(quantity))){
	 goodsQuantity = quantity;
 }
 $(".border_t1_dotted").find(".peopleType").each(function(i){
     if($(this).val()=='ADULT'){
         adultNum ++;
     }else{
         childNum ++;
     }
 });
 if(!(adultNum === (adults*goodsQuantity) && childNum === (childs*goodsQuantity))){
     alert("下单成人和儿童数不匹配");
     return false;
 }
 return true;
}

//根据生日获得改变人员类型
function blurIdAndBirthday(that,flag){
   var value = $(that).val();
   var departureDateVal = $("#departureTime").html();
   var birthday = "";
   var $parent = $(that).parent().parent().parent();
   var $people = $parent.find("select[name='peopleType']");
   var peopleType = $people.val();
   var oldFlag = flag+"";
   flag = $parent.find("select[name='cardType']").val();
   if(value == undefined || $.trim(value)==""){
	   var tip ="<i class=\"tip-icon tip-icon-error\"></i>请输入证件号码";
		if(oldFlag=="birthday"){
		  tip="<i class=\"tip-icon tip-icon-error\"></i>请输入出生日期";
		}
		$(that).siblings(".error_text").html(tip);
		$(that).parent().addClass('error_show');return false;
   }
   if(flag =='ID'||flag=='ID_CARD'){
       if(isIdCardNo(value)){
           birthday = getBirthdayByIdCard(value) ;
           $parent.find("input[type_name='birthday']").val(birthday);
          var age = getAgeByBrithday(birthday);
           var _newPeopleType =getDateDiffCardType(departureDateVal,birthday);
           if(_newPeopleType=="CHILDREN" && peopleType == 'ADULT'){
        	   $(that).parent().removeClass('error_show');
               $people.parent().addClass('error_show');return false;
           }else if(_newPeopleType=="ADULT" && peopleType == 'CHILDREN'){
        	   $(that).parent().removeClass('error_show');
               $people.parent().addClass('error_show');return false;
           }else if(_newPeopleType=="BABY"){
               $people.parent().removeClass('error_show');
               $(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>抱歉，暂不支持2周岁以下的婴儿购买机票");
               $(that).parent().addClass('error_show');
               return false;
           }else if(_newPeopleType=="OLD"){
        	   $people.parent().removeClass('error_show');
               $(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>抱歉，暂不支持超过70周岁的乘客购买机票");
               $(that).parent().addClass('error_show');
               return false;
           }else{
               $people.parent().removeClass('error_show');
               $(that).parent().removeClass('error_show');
           }
       }else{
    	  $(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>证件信息错误或重复，请进行修改");
          $parent.find("select[name='cardType']").parent().addClass('error_show');return false;
       }
   }else{
       if(oldFlag=="birthday"){
    	   birthday = $parent.find("input[type_name='birthday']").val();
    	   $(that).parent().removeClass('error_show');
    	   if(typeof birthday == "undefined" || birthday==""){
    		   $(that).parent().addClass('error_show');
	    	   return false;
    	   }
	       var _newPeopleType =getDateDiffCardType(departureDateVal,birthday);
	       if(_newPeopleType=="CHILDREN" && peopleType == 'ADULT'){
	    	   $(that).parent().removeClass('error_show');
	           $people.parent().addClass('error_show');return false;
	       }else if(_newPeopleType=="ADULT" && peopleType == 'CHILDREN'){
	    	   $(that).parent().removeClass('error_show');
	           $people.parent().addClass('error_show');return false;
	       }else if(_newPeopleType=="BABY"){
	           $people.parent().removeClass('error_show');
	           $(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>抱歉，暂不支持2周岁以下的婴儿购买机票");
	           $(that).parent().addClass('error_show');return false;
	       }else if(_newPeopleType=="OLD"){
	    	   $people.parent().removeClass('error_show');
	           $(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>抱歉，暂不支持超过70周岁的乘客购买机票");
	           $(that).parent().addClass('error_show');return false;
	       }else{
	           $people.parent().removeClass('error_show');
	           $(that).parent().removeClass('error_show');
	       }
       }else{
    	   if(value==""){
    		   $(that).parent().addClass('error_show');return false;
    	   }else{
    		   $(that).parent().removeClass('error_show');
    	   }
       }
   }
   
   //验证证件号码是否重复
   return verifyIDCardRepeat($parent.find("input[type_name='shenfenzheng']").eq(0));
}

//验证证件号码是否重复($This:当前证件号jquery对象)
function verifyIDCardRepeat($This){
	var $parent = $This.parent().parent().parent();
	var IDCardType = $parent.find("select[name='cardType']").val();
	var IDCardNo = $This.val();
	var receiverId = $parent.find("input[name='receiverId']").val();
	var $people = $parent.find("select[name='peopleType']");
	var _userInfos = getPassengers();
	if(_userInfos.length<=1){
		return true;
	}
	if(IDCardNo!=""){
		var count = 0;
		for(var i=0; i<_userInfos.length; i++){
			if(IDCardNo==_userInfos[i].passengerIDCardNo && IDCardType==_userInfos[i].passengerIDCardType){
				if(_userInfos[i].passengerId==receiverId){count++;}else{count+=2;}
				if(count>1){
					if(IDCardType=='ID' || IDCardType=='ID_CARD'){
						$parent.find("select[name='cardType']").parent().addClass('error_show');
					}else{
						//$people.parent().addClass('error_show');
						$parent.find("select[name='cardType']").parent().addClass('error_show');
					}
					$This.parent().find(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>证件信息错误或重复，请进行修改");
					//$This.val("");
					return false;
				}
			}
		}
		$parent.find("select[name='cardType']").parent().removeClass('error_show');
	}
	return true;
}


//人群类型发生改变，验证是否正确
function changePeopleTypeCheck(that){
   var value = $(that).val();
   var departureDateVal = $("#departureTime").html();
   var $parent = $(that).parent().parent().parent();
   var id_card = $parent.find("input[type_name='shenfenzheng']").val();
   var $cardType = $parent.find("select[name='cardType']");
   var cardTypeValue = $cardType.find(":selected").val();
   //flag 没有参数，是人员类型变化触发
   if($.trim(id_card) != "" && isIdCardNo(id_card)){
       var birthday = getBirthdayByIdCard(id_card) ;
       var _newPeopleType =getDateDiffCardType(departureDateVal,birthday);

       if(_newPeopleType=="CHILDREN" && value == 'ADULT'){
           $(that).parent().addClass('error_show');
           return false;
       }else if(_newPeopleType=="ADULT" && value == 'CHILDREN'){
           $(that).parent().addClass('error_show');
           return false;
       }else if(_newPeopleType=="BABY"||_newPeopleType=="OLD"){
           $(that).parent().removeClass('error_show');
           return false;
       }else{
           $(that).parent().removeClass('error_show');
       }

   }else if(cardTypeValue=="PASSPORT"){
       var birthdayP = $parent.find("input[type_name='birthday']").val();
      var _newPeopleType =getDateDiffCardType(departureDateVal,birthdayP);

       if(_newPeopleType=="CHILDREN" && value == 'ADULT'){
           $(that).parent().addClass('error_show');
           return false;
       }else if(_newPeopleType=="ADULT" && value == 'CHILDREN'){
           $(that).parent().addClass('error_show');
           return false;
       }else if(_newPeopleType=="BABY"||_newPeopleType=="OLD"){
           $(that).parent().removeClass('error_show');
           return false;
       }else{
           $(that).parent().removeClass('error_show');
       }
   }else{
       $(that).parent().removeClass('error_show');
   }
   return true;
}


//根据日期获取两个两者之间的年数,判断乘客类型
function getDateDiffCardType(departureDateVal,birthDateVal) {
	 var birthDateArr=birthDateVal.split("-");
	 var flightDepartureDateArr = "";
	 if(departureDateVal != null && departureDateVal != ""){
	     flightDepartureDateArr=departureDateVal.split("-");
	 }
	 var intDays = flightDepartureDateArr[0] -birthDateArr[0] - 1;
	 if( birthDateArr[1] < flightDepartureDateArr[1] || (birthDateArr[1] == flightDepartureDateArr[1] && birthDateArr[2] <= flightDepartureDateArr[2])){
	     intDays++;
	 }
	 var cardTypeVal;
	 if(intDays>=70){
		 cardTypeVal="OLD";
	 }else if(intDays>=12){
	    cardTypeVal="ADULT";
	 }else if(intDays<12 && intDays>=2){
	    cardTypeVal="CHILDREN";
	 }else{
	     cardTypeVal="BABY";
	 }
	 return cardTypeVal;
}

//点击常用联系人， 信息复制到 购买人或者游玩人
var _sameNameCheck ;//已填充的游玩人
function checkUser(that){
	var isFillIn = true;//是否需要被填充
	var isSelected = $(that).prop("checked");
	var contactName = $(".js_copy_info").find("input[type_name='text']").val();
	if(contactName){
		  $(".border_t1_dotted").each(function(){
			  if(!$(this).find("input[type_name='text']").val()){
				  isFillIn = false;
				  return false;
			  }
		  });
	}
	if(isFillIn && contactName && isSelected){
		showInfo(that,'人数已满');
		$(that).removeAttr("checked");
		return;
	}
	
	if(!_sameNameCheck){
		_sameNameCheck = {};
	}
  
   var receiverId = $(that).nextAll(":hidden[name='receiverId']").val();
   var name = $(that).nextAll(":hidden[name='receiverName']").val();
   var certNo = $(that).nextAll(":hidden[name='certNo']").val();
   //转换手机号
   if(certNo=='null'){
   	certNo="";
   }
   var mobileNumber = $(that).nextAll(":hidden[name='mobileNumber']").val();
   if(isSelected && _sameNameCheck.receiverId  && _sameNameCheck.receiverId == receiverId){
	   alert("选择的游玩人名称已经存在！不能选择！");
	   $(that).prop(false);
	   return;
   }else  if(isSelected && !_sameNameCheck.receiverId == receiverId){   
	   _sameNameCheck.receiverId = receiverId;
   }
   if(!isSelected){
	   _sameNameCheck.receiverId  == "";
	  return  cleanSameUser(receiverId,certNo,name,mobileNumber);
	 
   }
   
   
   var userId = $(that).nextAll(":hidden[name='receiverId']").val();
   var certType = $(that).nextAll(":hidden[name='certType']").val();
   var peopleType = $(that).nextAll(":hidden[name='peopleType']").val();
   var email = $(that).nextAll(":hidden[name='email']").val();
   //验证邮箱
   var _email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
   if(!_email.test(email) && email!=''){
   		email="";
   }
   var birthday = $(that).nextAll(":hidden[name='birthday']").val();
   if(certType == 'ID'){
	   certType = 'ID_CARD';
	   birthday = getBirthdayByIdCard(certNo);
   }
   var $buyer = $(".js_copy_info").find("input[type_name='text']");
   if(!$buyer.val()){//购买人为空
	   $buyer.val(name);
       $(".js_copy_info").find("input[type_name='mobile']").val(mobileNumber);
       $(".js_copy_info").find("input[type_name='email']").val(email);
       $(".js_copy_info").find(":hidden[name='receiverId']").val(userId);
       $(".js_copy_info").find(":hidden[name='certType']").val(certType);
       $(".js_copy_info").find(":hidden[name='certNo']").val(certNo);
       $(".js_copy_info").find(":hidden[name='peopleType']").val(peopleType);
       $(".js_copy_info").find(":hidden[name='birthday']").val(birthday);
       //合同：
       $(".buyer_name").html(name);
       $(".buyer_phone").html(mobileNumber);
       checkContactName($buyer);
       $('.js_yz').live('blur',function(){ 
   		var This = $(".js_copy_info").find('input');
   		setTimeout(function(){
   			yanzhengThis(This)
   		},150)
	   		
	   	});
       yanzhengThis($(".js_copy_info").find("input[type_name='mobile']"));
       yanzhengThis($(".js_copy_info").find("input[type_name='email']"));
       //勾选了第一个联系人之后，现在只有购买人会填充，第一个游玩人现在不填充
       /*$(".border_t1_dotted").each(function(i){
    	   if(i==0 && !$(this).find("input[type_name='text']").val()){
		   		$(this).find("input[type_name='text']").val(name);
		   		$(this).find("input[name='receiverId']").val(userId);
		   		$(this).find("select[name='peopleType']").val(peopleType);
		   		$(this).find("select[name='cardType']").val(certType);
		   		$(this).find("input[type_name='shenfenzheng']").val(certNo);
		   		$(this).find("input[type_name='mobile']").val(mobileNumber);
		   		$(this).find("input[type_name='birthday']").val(birthday);
		   		return false;
		    }else{
		    	return false;
		    }
	   	});*/
   }else{//遍历游玩人
	   $(".border_t1_dotted").each(function(){
		    if(!$(this).find("input[type_name='text']").val()){
			   		$(this).find("input[type_name='text']").val(name);
			   		$(this).find("input[name='receiverId']").val(userId);
			   	   
			   		var departureDateVal = $("#departureTime").html();
				    var _newPeopleType =getDateDiffCardType(departureDateVal,birthday);
			   		
				    $(this).find("select[name='peopleType']").val(_newPeopleType);
			   		$(this).find("select[name='cardType']").val(certType);
			   		$(this).find("input[type_name='shenfenzheng']").val(certNo);
			   		$(this).find("input[type_name='mobile']").val(mobileNumber);
			   		if(certType=="ID"||certType=="ID_CARD"){
			   			$(this).find("input[type_name='birthday']").parent().parent().hide();
			   		}
			   		$(this).find("input[type_name='birthday']").val(birthday);
			   		$(this).find("input[name='email']").val(email);
			   		
			   		//如果是证件类型是护照，则生日控件显示
					if(certType == 'PASSPORT'){
						initPassport();
					}
					//填充
					checkUserName($(this).find("input[type_name='text']"));
					changePeopleTypeCheck($(this).find(".peopleType"));
					blurIdAndBirthday($(this).find("input[type_name='shenfenzheng']"),$(this).find("select[name='cardType']").val());
					return false;
			    }
		});
   }
}

//将选中的联系人，置为未选
function cleanSameUser(receiverId,certNo,name,mobile){
	if($.trim(receiverId) || $.trim(certNo)){
	     $(".border_t1_dotted").each(function(){
	         if($.trim(receiverId) == $.trim($(this).find("input[name='receiverId']").val())){
	             $(this).find("input").val("");
	             $(this).find("select").val("");
	             
	             //清空时将出错的提示信息删除
	             $(this).find("select[name='cardType']").parent().removeClass('error_show');
	             $(this).find("select[name='peopleType']").parent().removeClass('error_show');
	             $(this).find("input[type_name='text']").parent().removeClass('error_show');
	             
	             //清空时将生日控件隐藏
	             $(this).find("select[name='cardType']").parent().parent().next(".js_zhengjian_hide").hide();
	             
	             return false;
	         }
	    });
	     //购买人信息相应的删除
	     $(".js_copy_info").each(function(){
				if($.trim(receiverId) == $.trim($(this).find("input[name='receiverId']").val())){
			   		$(this).find("input").val("");
			   		$(this).find("select").val("");
			   		changePeopleTypeCheck($(this).find(".peopleType"));
			   		return false;
			    }else if($.trim(name) == $.trim($(this).find("input[type_name='text']").val()) && $.trim(mobile) == $.trim($(this).find("input[type_name='mobile']").val())){
			    	$(this).find("input").val("");
			   		$(this).find("select").val("");
			   		changePeopleTypeCheck($(this).find(".peopleType"));
			   		return false;
			    }
		   });
	}
}

//组装游玩人信息---下单
function getPassengers(){
  var passengers = new Array();
  var $userinfos = $(".border_t1_dotted");
  var j = 0;
  _mobile = $(".js_copy_info").find("input[type_name='mobile']").val();
 for(var i=0; i<$userinfos.length; i++){
     var obj = new Object();
     obj.passengerName = $userinfos.eq(i).find("input[type_name='text']").val();
     obj.passengerType = $userinfos.eq(i).find(".peopleType").val();
     obj.passengerId = $userinfos.eq(i).find(":hidden[name='receiverId']").val();
     obj.email = $userinfos.eq(i).find(":hidden[name='email']").val();
     obj.passengerIDCardNo = $userinfos.eq(i).find("input[type_name='shenfenzheng']").val();
     obj.mobile = _mobile;
     var value = $userinfos.eq(i).find("select[name='cardType']").find(":selected").val();
     if(value && value=='ID_CARD'){
         obj.passengerIDCardType = "ID_CARD" ;
         obj.passengerBirthday = getBirthdayByIdCard($userinfos.eq(i).find("input[type_name='shenfenzheng']").val()) ;
     }else{
         obj.passengerIDCardType = $userinfos.eq(i).find("select[name='cardType']").find(":selected").val(); ;
         obj.passengerBirthday = $userinfos.eq(i).find("input[type_name='birthday']").val();
     }
     passengers[j++] = obj;
 }
 return passengers;
}

//获取合同信息
function getContracts(_shoppingUUID){
 $.ajax({
       type: "post",
       async: true,
       dataType: "json",
       url: basePath+"/getContractsHtml",
       data: {
           shoppingUUID:_shoppingUUID
       },
       success: function(data) {
           $("#hetong").html(data.contracts.result);
       },
       error:function(data)
       {
       }
   });
}

//获取预订须知
function getBookingNotice(){
 $.ajax({
     type:"post",
     ContentType: "application/json; charset=utf-8",
     dataType:"json",
     url:basePath+"/getBookingNotice",
     data:{
         productId:productId,
         bizCategoryId:bizCategoryId
     },
     success:function(obj){
         $("#bookingNotice").html(obj.bookingNotice);
         //完成之后将预定须知里的除“出行警示和退改说明之外的去掉”
         $(".detail-instance-body").find("#line_route_visa").html("");
     },
     error:function(obj){
     }
 });
}

//下单失败、等出错信息弹窗----点击重启查询按钮
$('.fh-return-btn ,.ph_icon_closeAlert').click(function(){
	$('.returnAlert').stop(true,true).fadeOut();
	$('.resortOverlay').stop(true,true).fadeOut();
	$('body').removeAttr('style');
	var pageType ="freetour"; 
	if(bizCategoryId!=18){
	    pageType="group";
	}
	var _ulr = basePath+"/"+pageType+"-"+productId;
	 window.location.href=_ulr;
});

	//检测是否全部填写OK
	function yanzhengOk(){
		var obj = $('.js_youwanTime'); 
		for(var i=0;i<obj.length;i++){
			objThis = obj.eq(i);
			if(objThis.is(':visible')){
				if(objThis.val()==''){
					$('body,html').scrollTop(0);
					objThis.addClass('input_red');
					nameFull(objThis,'请选择游玩日期',215,-25,'warning'); 
					return false;
				}else{
					objThis.removeClass('input_red');
				}
			}
		}

		//长隆马戏场地选择验证
		var $circus = $('#circus');
		var $d_ccSelect = $('.d_ccSelect');
		if($circus.length != 0) {
			if ($d_ccSelect.is(':hidden')) {
				$('body,html').scrollTop(0);
				alert('暂无场次信息，请选择其他日期。');
				return false;
			}
			if ($d_ccSelect.val() == "-请选择场次-") {
				$('body,html').scrollTop(0);
				$d_ccSelect.addClass('input_red');
				$circus.find('.d_floatTip').show();
				return false;
			}else{
				$d_ccSelect.removeClass('input_red');
				$circus.find('.d_floatTip').hide();
			}
		}
		
		var $yanzheng = $('.js_yz');
		yanzhengPassengersInfo($yanzheng);
		
		var _english2 = /^[a-zA-Z\s]+$/;
		for(var i=0;i<$('.error_show').length;i++){
			var $error_show = $('.error_show').eq(i),
				yzInput = $error_show.find('.js_yz');
			if($error_show.is(':visible')){
				yzInput.eq(0).focus();
				if(yzInput.eq(0).attr('type_name')=='english2'){
					if(_english2.test(yzInput.eq(0).val())){
						yzInput.eq(1).focus();
					}
				}
				
				return false;
			}
		};
		
		for(var i=0;i<$('.error_show2').length;i++){
			if($('.error_show2').eq(i).is(':visible')){
				$('.error_show2').eq(i).find('.js_yz:first').focus();
				return false;
			}
		};
		
		if(!$('.xieyi_ok').find('input').attr('checked') && $('.xieyi_ok').is(':visible')){
			alert('请同意以下条款')
			return false;
		}

		return true;
	}
	
	//提交前校验所有人员输入框信息(Param：class='js_yz'的人员信息input框列表)
	function yanzhengPassengersInfo($yanzheng){
		for(var i=0;i<$yanzheng.length;i++){
			var This = $yanzheng.eq(i);
			var flag1=true,flag2=true;
			//检查所有人员姓名是否规范填写
			if(This.attr("type_name")==="text"){
				if(This.hasClass("js_goumai_name")){
					flag1 = checkContactName(This);
				}else{
					flag1 = checkUserName(This);
				}
			}
			//检查证件信息是否重复
			if(This.attr("type_name")==="shenfenzheng"){
				if(This.siblings('.select').val() == 'ID_CARD' || This.siblings('.select').val() == 'ID'){
					flag2 = blurIdAndBirthday(This,"ID");
				}else{
					flag2 = verifyIDCardRepeat(This);
				}
			}
			if(flag1 && flag2){
				yanzhengThis(This);
			}
		}
	}
	//验证当前输入框
	function yanzhengThis(This){
	    var _mobile = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17\d{1})|(18([0-4]|[5-9])))\d{8}$/;// /^(13[0-9]|15[0-9]|18[0-9]|170|17[6-8]|147|145)\d{8}$/; 
		var _email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		var isIDCard2= /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;/*/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/*/
		var _english = /^[\u4e00-\u9fa5]+$/;
		var _english2 = /^[a-zA-Z\s]+$/;
		var _username = /^[a-zA-Z\u4e00-\u9fa5\s]+$/;
		var value = $.trim(This.val()),
			thisSvalue = $.trim(This.siblings('input').val());
		
		var thisP = This.parent();
		
		if(This.is(':visible')){
			var optional = This.attr('optional');
			//验证手机
			if(This.attr('type_name')=='mobile'){
				if(value=='' && optional!="true"){
					This.siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>请输入手机号码");
					thisP.addClass('error_show');
				}else if(!_mobile.test(value) && value!=''){
					This.siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>您填写的手机号码有误，请重新填写");
					thisP.addClass('error_show');
				}else{
					thisP.removeClass('error_show');
				}
			}
			//验证邮箱
			if(This.attr('type_name')=='email'){
				if(value=='' && optional!="true"){
					This.siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>请输入邮箱地址");
					thisP.addClass('error_show');
				}else if(!_email.test(value) && value!=''){
					This.siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>您填写的邮箱地址有误，请重新填写");
					thisP.addClass('error_show');
				}else{
					thisP.removeClass('error_show');
				}
			}
			
			//验证身份证
			if(This.attr('type_name')=='shenfenzheng'){
				if(value=='' && optional!="true"){
					thisP.addClass('error_show');
				}else if(!isIdCardNo(value) && (This.siblings('.select').val() == 'ID'||This.siblings('.select').val() == 'ID_CARD') && value!=''){
					thisP.addClass('error_show');
				}/*else{
					thisP.removeClass('error_show');
				}*/
			}
			//验证生日
			if(This.attr('type_name')=='birthday'){
				blurIdAndBirthday(This,"birthday");
			}
			
		}//检测是否可见，只验证可见元素
	}

	function isIdCardNo(num) {
	    num = num.toUpperCase();
	    if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {
	        return false;
	    }
	    //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
	    var len, re;
	    len = num.length;
	    if (len == 15) {
	        re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
	        var arrSplit = num.match(re);
	        //检查生日日期是否正确 
	        var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);
	        var bGoodDay;
	        bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
	        if (!bGoodDay) {
	            return false;
	        } else {
	            //将15位身份证转成18位 
	            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
	            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	            var nTemp = 0, i;
	            num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
	            for (i = 0; i < 17; i++) {
	                nTemp += num.substr(i, 1) * arrInt[i];
	            }
	            num += arrCh[nTemp % 11];
	            return num;
	        }
	    }
	    if (len == 18) {
	        re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
	        var arrSplit = num.match(re);
	        //检查生日日期是否正确 
	        var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);
	        var bGoodDay;
	        bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));
	        if (!bGoodDay) {
	            return false;
	        }
	        else {
	            //检验18位身份证的校验码是否正确。 
	            //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。 
	            var valnum;
	            var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	            var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	            var nTemp = 0, i;
	            for (i = 0; i < 17; i++) {
	                nTemp += num.substr(i, 1) * arrInt[i];
	            }
	            valnum = arrCh[nTemp % 11];
	            if (valnum != num.substr(17, 1)) {
	                return false;
	            }
	            return num;
	        }
	    }
	    return false;
	}

	//显示联系人已满
	function nameFull(obj,text,left,top,type,fn){
		var L = obj.offset().left-10;
		var T = obj.offset().top+25;
		var Text = '人数已满';
		var html = '';
		var jtL = '';
		var fx = 12;
		$('.js_nameFull').remove();
		if(left){
			L = obj.offset().left-10+left;
		}
		if(top){
			T = obj.offset().top+25+top;
		}
		//提示文字
		if(text){
			Text = text;
		}
		//选择游玩日期提示
		if(obj.val()=='' && obj.hasClass('js_youwanTime')){
			fx = 9;
			$('html,body').animate({'scrollTop':0},300);
			obj.addClass('input_red');
		}
		
		//优惠券模块填写错误提示
		if(obj.attr('yz_input')=='true'){
			obj.addClass('input_red');
			jtL = ' style="left:30px;"'
		}
		
		//优惠券chek提示
		if(obj.attr('tips_L')=='true'){
			jtL = ' style="left:20px;"'
		}
		
		//提示类型
		if(type!=true){
			html = '<span class="tiptext tip-error tip-line js_nameFull"><span class="tip-icon tip-icon-error"></span>'+Text+'<div class="tip-arrow tip-arrow-'+fx+'"'+ jtL +'><em>◆</em><i>◆</i></div></span>';
		}
		if(type=='warning'){
			html = '<span class="tiptext tip-warning tip-line js_nameFull"><span class="tip-icon tip-icon-warning"></span>'+Text+'<div class="tip-arrow tip-arrow-'+fx+'"'+ jtL +'><em>◆</em><i>◆</i></div></span>';
		}
		if($('.js_nameFull').length==0){
			$('body').append(html);
		}
		if(obj.hasClass('num_box')){
			obj.addClass('num_false');
		}
		
		//提示定位
		$('.js_nameFull').css({'position':'absolute','left':L,'top':T});
		if(fn==true){
			$('.js_nameFull').remove();
			obj.removeClass('num_false');
			$('.warning_box').hide();
		}else if(fn==undefined){
			obj.mouseout(function(){
				$('.js_nameFull').remove();
				obj.removeClass('num_false');
			});
		}else{
			//库存不足提示
			var warHtml = '<div class="warning_box"><div class="tiptext tip-warning"><span class="tip-icon tip-icon-big-warning"></span>很抱歉，您预订的产品因其他买家抢购以致库存不足，请修改数量。</div></div>'
			$('body').append(warHtml);
			if(T<$(document).scrollTop()){
				$('html,body').scrollTop(T-100);
			}
			
		}
		/**/
	}
	
	//删除提示
	function removeTips(){
		$('.js_nameFull,.js_popTips').remove();
	}
	
	//页面loading状态
	function winLoading(data,txt){
		if(data==true && $('.windowBg').length==0){
			$('body').append('<div class="windowBg" style=" position:absolute; top:0; left:0; width:100%; background:#999; filter:alpha(opacity=50); -moz-opacity:0.5; -khtml-opacity:0.5; opacity:0.5; z-index:998;"></div><div class="winloading" style=" width:300px; height:50px; padding:26px 0; text-align:center; line-height:52px; font-size:14px; color:#666; background:#fff; border:#999 solid 1px; z-index:999; position:fixed; top:50%; margin-top:-50px; left:50%; margin-left:-150px;"><img style=" vertical-align:middle;" src="http://pic.lvmama.com/img/new_v/ui_scrollLoading/loadingGIF46px.gif" width="46" height="46" />　'+txt+'</div>');
			var height_w =$(document).height();
			$('.windowBg').css({'height':height_w});
		}else{
			$('.windowBg,.winloading').remove();
		}
		 
	}