/**
 *  订单填写页JS
 *  @author:wanghuihui
 *  @date:2015-12-23
 */
function infoSubmitBack(shopingUUID,_adultCount,_childCount){
	submit(shopingUUID,_adultCount,_childCount,false);
};

function infoSubmit(shopingUUID,_adultCount,_childCount,quantity){
	/**
	 * 登录验证
	 */
	var check = checkBooking(_adultCount,_childCount,quantity);
	if(check){
		fit.login.booking.check(function(){
			submit(shopingUUID,_adultCount,_childCount,true,quantity);
		},function(){
			callBackSubmit(shopingUUID,_adultCount,_childCount,quantity);
		});
	}
};

function callBackSubmit(shopingUUID,_adultCount,_childCount,quantity){
	 loginCallback();//先登录,再刷新登录用户信息
	 submit(shopingUUID,_adultCount,_childCount,true);
	 if(!checkBooking(_adultCount,_childCount,quantity)){
		 location.reload();
	 }
}

function submit(shopingUUID,_adultCount,_childCount,isWriteInfoRecord,quantity){
	if(!checkBooking(_adultCount,_childCount,quantity)||!yanzhengOk()){
		return;
	}
	//alert("成功提交了");return;
	//提交之前记录一下信息，方便失败的时候信息回填
	if(isWriteInfoRecord){
		writeInfoRecord();
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
	 $.ajax({
         type: "post",
         async: true,
         dataType: "json",
         url: _data._contextPath+"/order/Booking",
         data:data,
         success: function(result) {
      	    $(".fh-overlay, .fh-dialog-loading").hide();
      	    var array = window.localStorage.getItem('fh_order_player_info');
      	    window.localStorage.setItem('fh_order_player_info',JSON.stringify(array));
      	    var buyer = window.localStorage.getItem('fh_order_buyer_info');
      	    window.localStorage.setItem('fh_order_buyer_info',JSON.stringify(buyer));
      	    window.localStorage.setItem('isSuccess',true);
      	    window.location.href=result.successUrl;
         },
		 error:function(obj)
		  {
			$(".fh-overlay, .fh-dialog-loading").hide();
			$('.returnAlert').stop(true,true).fadeIn();
			$('.resortOver').stop(true,true).fadeIn();
			$("#errorMsg").html("不好意思，系统繁忙，请稍后再试！");
			//下单失败调用还原shopping服务
			var faildata ={};
			faildata.shoppingUUID = shopingUUID;
			var result = $.getAjaxHtmlDataAsync(_data._contextPath+"/order/bookfailed",faildata);
		  }
     });
}

    
//常用联系人 信息复制到 购买人或者游玩人
var _sameNameCheck ;
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

var totalSalesAmount;

// 获得价格
function initPrice(context,_shopingUUID){
	  $.ajax({
          type: "post",
          async: false,
          dataType: "json",
          url: context+"/shopping/calucateAmount",
          data: {
        	  shoppingUUID:_shopingUUID
          },
          success: function(obj) {
        	  $("#totalPrice").html(obj.result.totalAmount);
              $("#promotion").html(obj.result.promotionAmount);
              $("#salesPrice").html(obj.result.totalSalesAmount);
              totalSalesAmount = obj.result.totalSalesAmount;       	
          },
		  error:function(data)
		  {
			$('.returnAlert').stop(true,true).fadeIn();
			$('.resortOver').stop(true,true).fadeIn();
			$("#errorMsg").html(eval('(' + data.responseText + ')').message);
		  }
      }); 
 };
 $('.fh-return-btn').click(function(){
     $('.returnAlert').stop(true,true).fadeOut();
     $('.resortOver').stop(true,true).fadeOut();
     $('body').removeAttr('style');
     //window.location.href=_data._contextPath+"/search/backToShopping?shoppingUUID="+shopingUUID+"&type=orderfilled";
     window.location.href= $("#reloadUrl").val();
 });
 
 
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
				  $people.parent().addClass('error_show'); return false;
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
  	  		 $parent.find("select[name='cardType']").parent().addClass('error_show'); return false;
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
		           $(that).parent().addClass('error_show'); return false;
		       }else{
				  $people.parent().removeClass('error_show');
				  $(that).parent().removeClass('error_show');
			  }
		  }else{
	    	   if(value==""){
	    		   $(that).parent().addClass('error_show');
	    		   return false;
	    	   }else{
	    		   $(that).parent().removeClass('error_show');
	    	   }
	       }
	  }
	  
	  //验证证件号码是否重复
	  return verifyIDCardRepeat($parent.find("input[type_name='shenfenzheng']").eq(0));
	  /*var _userInfos = getPassengers();
	  if(_userInfos.length<=1){
	  	return;
	  }
	  if(value!=""){
	  	for(var i=0; i<_userInfos.length; i++){
	  		if(value==_userInfos[i].passengerIDCardNo&&flag==_userInfos[i].passengerIDCardType&&_userInfos[i].passengerId!=$parent.find("input[name='receiverId']").val()){
	  			if(flag=='ID' || flag=='ID_CARD'){
	  				$parent.find("select[name='cardType']").parent().addClass('error_show');
	  			}else{
	  				$people.parent().addClass('error_show');
	  			}
	  			$(that).val("");
	  			return;
	  		}
	  	}
	  }*/
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


 
//记录搜索历史
function writeInfoRecord(){
    var array = new Array();
 	$(".border_t1_dotted").each(function(i){
 		var play = {};
 		play.passengerId = $(this).find("input[name='receiverId']").val();
 		play.passengerName = $(this).find("input[type_name='text']").val();
 		play.passengerType = $(this).find("select[name='peopleType']").find(":selected").val();
 		play.cardType = $(this).find("select[name='cardType']").find(":selected").val();
 		play.cardNo = $(this).find("input[type_name='shenfenzheng']").val();
 		play.birthday = $(this).find("input[type_name='birthday']").val();
 		array.push(play);
 	});
 	var buyer_info = {};
 	buyer_info.buyerName = $(".js_copy_info").find("input[type_name='text']").val();
 	buyer_info.buyerPhone = $(".js_copy_info").find("input[type_name='mobile']").val();
 	buyer_info.buyerEmail = $(".js_copy_info").find("input[type_name='email']").val();
 	if(window.localStorage){
       window.localStorage.setItem('fh_order_player_info',JSON.stringify(array));
     	window.localStorage.setItem('fh_order_buyer_info',JSON.stringify(buyer_info));
     }
 	
 }
 //填写内容恢复
 function recoveryInfoRecord(){
 	if(window.localStorage){
     	var array = window.localStorage.getItem('fh_order_player_info');
     	var playerInfo = JSON.parse(array);
     	if(playerInfo && "" != playerInfo){
 	    	$(".border_t1_dotted").each(function(i){
 	    		$(this).find("input[name='receiverId']").val(playerInfo[i].passengerId)
 	    		$(this).find("input[type_name='text']").val(playerInfo[i].passengerName);
 	    		$(this).find("select[name='peopleType']").val(playerInfo[i].passengerType);
 	    		$(this).find("input[type_name='shenfenzheng']").val(playerInfo[i].cardNo);
 	    		if (playerInfo[i].cardNo!=""){
 	    			$("#passenger_"+playerInfo[i].cardNo).attr("checked","checked");
 	    		}
 	    		$(this).find("input[type_name='birthday']").val(playerInfo[i].birthday);
 	    		var carType = playerInfo[i].cardType;
 	    		$(this).find("select[name='cardType']").val(carType);
 	    		if("PASSPORT" == carType){
 	    			$(".js_zhengjian_hide").show();
 	    		}
 	    	});
     	}
     	var buyer = window.localStorage.getItem('fh_order_buyer_info');
     	var buyer_info = JSON.parse(buyer);
     	if(buyer_info && "" != buyer_info){
     		$(".js_copy_info").find("input[type_name='text']").val(buyer_info.buyerName);
         	$(".js_copy_info").find("input[type_name='mobile']").val(buyer_info.buyerPhone);
         	$(".js_copy_info").find("input[type_name='email']").val(buyer_info.buyerEmail);
     	}
     }
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

//生日显示控件--身份证
var initId_Card = function(){
	$(".js_zhengjian").change(function(){
		var value = $(this).val();
		if(value=='ID'||value=='ID_CARD'){
			$(this).parent().parent().next(".js_zhengjian_hide").hide();
		}else{
			$(this).parent().parent().next(".js_zhengjian_hide").show();
		}
	});
}

//生日显示控件--护照
var initPassport = function(){
	$(".js_zhengjian").each(function(){
	   /*if($(this).val() === 'PASSPORT'){
		   $(this).parent().parent().next(".js_zhengjian_hide").show();
	   } */
		var value = $(this).val();
		if(value === 'ID'||value === 'ID_CARD'){
		   $(this).parent().parent().next(".js_zhengjian_hide").hide();
	   }else{
			$(this).parent().parent().next(".js_zhengjian_hide").show();
		}
	});
}

//点击护照时出现日历
var clickPassport = function(){
	$(".js_birthday").each(function(){
		$(this).ui("calendar",{
		   input : this,
		   parm:{dateFmt:'yyyy-MM-dd'}
		})
	});
}

var birthday_kongjian = function(){
	///选择出生日期
	$("body").ui("calendar",{
        input : ".js_birthday",
        parm:{dateFmt:'yyyy-MM-dd'}
    })
}

var clickIdCard = function(){
	$('.js_zhengjian').change(function(){ 
		setTimeout(function(){
			var T = $(document).scrollTop();
			$('body,html').scrollTop(T+1);
		},150);
		$(this).siblings('.input').val('');
	});
}

//实例合同信息：人员 和 电话
function initContractData(that){
	var value =$(that).val();
	var _mobile = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17\d{1})|(18([0-4]|[5-9])))\d{8}$/;
	if(value=='' || !_mobile.test(value)){
		$(that).parent().addClass('error_show');
	}else{
		$(that).parent().removeClass('error_show');
	}
}

function showInfo(o,msg){
	var obj = $(o).parent(); //提示出现的模块位置
	var text = msg; //提示的文字
	var left = 5; //提示的left微调
	var top = 6; //提示的top微调
	//nameFull(obj,text,left,top); //提示调用的方法
	var type = 'warning'; //warning(感叹号)；
	nameFull(obj,text,left,top,type);//提示调用的方法
}

//门票规则
$(".xit-list .xpro-name em").click(function() {
    $('.fh-ticket-detail').css({
        'position': 'relative',
        'z-index':'1'
    });
    var $this = $(this);
    var $detail = $this.parents(".xpro-detail");
    var id = $detail.data("id");
    var $dialog = $("#TDTL" + id.substring(1));
    $detail.after($dialog);
    $dialog.toggle();
});

$(".shouqi").click(function() {
    var $ticket_detail = $(this).parents(".fh-ticket-detail");
    $ticket_detail.hide();
})

//验证姓名，是否符合规范
function checkUserName(that){
	var userName = $(that).val();
	if(userName==undefined || $.trim(userName)==""){
		$(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>请输入姓名");
		$(that).parent().addClass('error_show');return false;
	}else if(!/^([\u4e00-\u9fa5]+|[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+[\u4e00-\u9fa5]+|[a-zA-Z]+[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+\/[a-zA-Z]+)+$/.test($.trim(userName))||$.trim(userName).length<2){
		$(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>请保持姓名与证件上的姓名一致");
		$(that).parent().addClass('error_show');return false;
	}else{
		$(that).parent().removeClass('error_show');
	}
	return true;
}

//购买人姓名
function checkContactName(that){
	var contactName = $(that).val();
	if(contactName==undefined||""==$.trim(contactName)){
		$(that).parent().addClass('error_show');return false;
	}else{
		$(that).parent().removeClass('error_show');return false;
	}
	return true;
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

//验证下单之前的数据
function checkBooking(adults,childs,quantity){
	//这里只做，成人儿童数的验证
	var adultNum = 0;
	var childNum = 0;
	 var goodsQuantity = 1;
	 if(quantity!==undefined && (!isNaN(quantity))){
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


