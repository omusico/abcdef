$(function(){ 
	//付款按钮浮动显示
	var fixed_box = $('.fk_box_fixed');
	if(fixed_box.length>0){
		function fk_scroll(){
			var win_t = $(window).height() - fixed_box.height();
			var obj_t = fixed_box.offset().top;
			var scroll_t = $(document).scrollTop();
			if(scroll_t > obj_t - win_t){
				fixed_box.find('.fk_box').css('position','absolute')
			}else{
				fixed_box.find('.fk_box').css('position','fixed')
			}
		}
		$(window).scroll(function(){ 
			fk_scroll();
		});
		fk_scroll();
	}
	//出生日期控件加载
	$(".js_birthday").each(function(){
		$(this).ui("calendar",{
		   input : this,
		   parm:{dateFmt:'yyyy-MM-dd'}
		})
	});
	//证件类型
	$('.js_zhengjian').change(function(){ 
		setTimeout(function(){
			var T = $(document).scrollTop();
			$('body,html').scrollTop(T+1);
		},150);
		$(this).siblings('.input').val('');
	});
	
	//手机号码放大
	var bigHtml = '<div id="text_big" style="height:36px; line-height:36px; padding:0 10px; background:#FFFDE6;  border:#FFAA00 solid 1px; position:absolute; color:#333; font-family:Arial; font-size:20px; display:none;"></div>';
	$('body').append(bigHtml)
	$('.js_textBig').live('keyup',function(){ 
		var This = $(this);
		textBig(This);

	})
	$('.js_textBig').live('focus',function(){ 
		var This = $(this);
		var text = This.val();
		if(text.length>0){
			textBig(This);
		}
	})
	$('.js_textBig').live('blur',function(){ 
		$('#text_big').hide().html('');
	});
	
	function textBig(This){
		var text = This.val();
		var L = This.offset().left;
		var T = This.offset().top-37;
		var arr = [];
		for(var i=0;i<text.length;i++){
			arr.push(text.substring(i,i+1));
			if(This.attr('type_name') == 'mobile'){
				if(i==2 || i==6){
					arr.push(" ");
				}
			}else if(This.attr('type_name') == 'shenfenzheng'){
				if(i==5 || i==13){
					arr.push(" ");
				}
			}
			
		}
		$('#text_big').show().css({'left':L,'top':T,'min-width':$(This).outerWidth()-22}).html(arr.join(''));
	}
	
	
	//点击产品名称，展开内容
	$('.pro_name,.pro_info_sq,.js_name').live("click", function(){ 
		var pro_info = $(this).parents('.table_t').find('.pro_info');
		if(pro_info.is(':hidden')){
			$(this).parents('.table_t').addClass('jt_up').find('.pro_info').show();
		}else{
			$(this).parents('.table_t').removeClass('jt_up').find('.pro_info').hide();
		}
	});
	
	$(".tagsback,.tags101,.bx_ts,.js_tips").poptip({
		place : 6
	});
	
	$(".bx_ts").poptip({
		place : 6,
		skin:'#ff6600'
	});
	
	
	//鼠标离开输入框，验证
	$('.js_yz').live('blur',function(){ 
		var This = $(this);
		setTimeout(function(){
			yanzhengThis(This)
		},150)
		
	});
	
	
	//选择发票
	$('.js_fapiaoYes').change(function(){ 
		$(this).parents('.list_tit').next('.user_info').show();
		$('.js_fapiaoTip').show();
	});
	$('.js_fapiaoNo').change(function(){ 
		$(this).parents('.list_tit').next('.user_info').hide();
		$('.js_fapiaoTip').hide();
	});
	
	//协议更多展开
	$('.xieyi_gd').click(function(){ 
		$(this).hide().siblings('.lv-agree').addClass('xieyi_show');
		$('html,body').animate({'scrollTop':$(document).scrollTop()+250},300)
	})
	
	//合同弹窗
	$('.xieyi_qw').click(function(){ 
		pandora.dialog({
			title: "合同模板",
			width: 780,
			content: $(".ht_box")
		});
	})
	
	
	$('.js_btn_qita').live('click',function(){ 
		var pro_info = $(this).siblings('.otherHideDiv');
		if(pro_info.find('.table_t').eq(0).is(':hidden')){
			$(this).hide().addClass('jt_up');
			pro_info.show().find('.table_t').show();
		}else{
			$(this).removeClass('jt_up');
			pro_info.hide().find('.table_t').hide();
		}
		
	});
	
	
	$('.js_name_shouqi').live('click',function(){ 
		if($(this).hasClass('btn_up')){
			$(this).removeClass('btn_up').html('更多<i class="icon_arrow"></i>').parent().height(26);
		}else{
			$(this).addClass('btn_up').html('收起<i class="icon_arrow"></i>').parent().height('auto');;
		}
		$(this).parents('.name_list_new_box').height($(this).parent().outerHeight(true));
		
	});
	
	//直接显示证件类型
	$('.js_zj_show').live('change',function(){ 
		$(this).parent().siblings('.zj_list').show();
	});
	//客服来电填写证件
	$('.js_zj_hide').live('change',function(){ 
		$(this).parent().siblings('.zj_list').hide();
	});
	//邮轮填写信息，清空
	/*$('.js_btn_qk').live('click',function(){ 
		$(this).parents('.user_info').find('input').val('');
		$(this).parents('.user_info').find('dd,li').removeClass('error_show');
	});*/
	
	$(".js_yk_name").die().live('keyup',function(){
	    if($(this).val().trim() == $('.js_jj_name').val()){
	        $('.js_jj_name').parent('dd').addClass('error_show2');
	    }else{
	        $('.js_jj_name').parent('dd').removeClass('error_show2');
	    }
	});

	$('.js_yk_mobile').die().live('keyup',function(){
	    if($(this).val().trim() == $('.js_jj_mobile').val()){
	        $('.js_jj_mobile').parent('dd').addClass('error_show2');
	    }else{
	        $('.js_jj_mobile').parent('dd').removeClass('error_show2');
	    }
	});
	//邮轮紧急联系人手机检测
	$('.js_jj_mobile').live('keyup',function(){ 
		var $This = $(this);
		for(var i=0;i<$('.js_yk_mobile').length;i++){
			if($('.js_yk_mobile').eq(i).val()==$This.val() && $This.val()!=''){
				setTimeout(function(){
					$This.parent('dd').addClass('error_show2');
				},200)
			}else{
				$This.parent('dd').removeClass('error_show2');
			}
			
		}
	});
	//邮轮紧急联系人姓名检测
	$('.js_jj_name').live('keyup',function(){ 
		var $This = $(this);
		for(var i=0;i<$('.js_yk_name').length;i++){
			if($('.js_yk_name').eq(i).val()==$This.val() && $This.val()!=''){
				setTimeout(function(){
					$This.parent('dd').addClass('error_show2');
				},200)
			}else{
				$This.parent('dd').removeClass('error_show2');
			}
			
		}
	});
	
	//复制购买人信息
	$('.js_btn_copy').live('click',function(){
		var $input1 = $('.js_copy_info').eq(0).find('.js_yz');
		var $input2 = $(this).parents('.user_info').find('.js_yz');
		for(var i=0;i<$input1.length;i++){
			var attr1 = $input1.eq(i).attr('placeholder');
			var value = $input1.eq(i).val();
			if(value!=''){
				for(var j=0;j<$input2.length;j++){
					var attr2 = $input2.eq(j).attr('placeholder');
					if(attr1==attr2){
						$input2.eq(j).val(value).trigger("change");
					}
				}
				$(this).parents('.user_info').find('dd').removeClass('error_show');
			}else{
				if(attr1=='姓名' || attr1=='手机' || attr1=='邮箱'){
					//alert('购买人信息不完整!')
				}
				
			}
			
		}
		
	});
	
	//邮箱自动补全
	var emailArr = ['qq.com','163.com','126.com','sina.com','sina.cn','yahoo.com','hotmail.com','gmail.com','sohu.com','yeah.net','139.com','foxmail.com','189.com'],
		emailIndex = -1,
		nowInput;
	
	if($('.js_email').length>0){};
	
	$('body').append('<ul class="email_list" id="email_list" style="z-index:1000;"></ul>');
	
	$('.js_email').live('keyup',function(e){ 
		var This = $(this),
			email_list = $('#email_list'),
			sText = This.val();
		
		if(/@/.test(sText)){
			var thisL = This.offset().left,
				thisT = This.offset().top+This.outerHeight()-1,
				html = '',
				emaillen = emailArr.length,
				activeText = '';
			
			if(sText.substring(sText.length-1,sText.length)=="@"){
				for(var i=0;i<emaillen;i++){
					html+='<li>'+sText+emailArr[i]+'</li>';
				}
				email_list.html(html).css({'display':'block','left':thisL,'top':thisT});
				emailIndex=-1;
			};
			if(e.keyCode == "38"){
				emailIndex--;
				if(emailIndex<=-1){emailIndex=emaillen-1};
				email_list.find('li').eq(emailIndex).addClass('active').click().siblings().removeClass('active');
			}else if(e.keyCode == "40"){
				
				emailIndex++;
				if(emailIndex>=emaillen){emailIndex=0};
				email_list.find('li').eq(emailIndex).addClass('active').click().siblings().removeClass('active');
			}else if(e.keyCode == "13"){
				This.blur();
			}
		}else{
			email_list.hide();
			emailIndex=-1;
		};
		
	}).live('focus',function(){ 
		nowInput = $(this);
	}).live('blur',function(){ 
		setTimeout(function(){
			$('#email_list').hide();
			emailIndex=-1;
		},150)
		
	});;
	
	$('#email_list li').live('click',function(e){ 
		var ThisLi = $(this),
			sText = ThisLi.text();
		nowInput.val(sText);
		if(ThisLi.click.caller==null){
			nowInput.blur();
		}
	});
	
	
	//var bx_tab_info = $('.bx_tab_info');
	var timer_bx = null;
	$('.bx_tab li').live('mouseenter',function(){ 
		var L = $(this).parent().offset().left,
			thisT = $(this).offset().top+35-$('.main_box').offset().top,
			arrowL = $(this).width()/2+8,
			infoL = $(this).offset().left,
			num = $(this).index();
		
		if(num>0){
			clearTimeout(timer_bx);
			$('.bx_tab_info').show().css({'left':infoL,'top':thisT}).find('li').eq(num-1).show().siblings().hide();
			$('.bx_tab_info').find('.info_arrow').css('left',arrowL);
		}
	});
	$('.bx_tab li').live('mouseleave',function(){
		var num = $(this).index();
		if(num>0){
			timer_bx = setTimeout(function(){
				$('.bx_tab_info').hide();
			},200);
		}
	});
	
	$('.bx_tab_info').live('mouseenter',function(){ 
		clearTimeout(timer_bx);
	});
	$('.bx_tab_info').live('mouseleave',function(){ 
		timer_bx = setTimeout(function(){
			$('.bx_tab_info').hide();
		},200)
	});
	
	
	
	
	$('.pro_name_bx').live('click',function(){ 
		if(!$(this).parents('dl').hasClass('jt_up')){
			$(this).parents('dl').addClass('jt_up');
			$(this).siblings('.pro_info_bx').show();
		}else{
			$(this).parents('dl').removeClass('jt_up');
			$(this).siblings('.pro_info_bx').hide();
		}
	});
	
	$('.pro_info_bx_sq').live('click',function(){ 
		$('.pro_name_bx').click();
	});
	
	// 更多联系人
	$(".fit-more-contact").die().live("click",function(e){
	    var $this = $(this);
	    var $nameList = $this.parents(".name_list");
	    var text = $this.html();
	    if($this.hasClass('fit-more-contact-up')) {
	        $this.html(text.replace('收起','更多')); 
	        $this.removeClass('fit-more-contact-up');
	        $nameList.removeClass('fit-name-more');
	    } else {
	        $this.html(text.replace('更多','收起')); 
	        $this.addClass('fit-more-contact-up');
	        $nameList.addClass('fit-name-more');
	    }
	});
	
	
	//航班详细信息弹出层
	$(".flight-add-one-day").poptip({
        offsetX : -29,
        place: 7
    });
    $(".plane-type").hover(function() {
        var $this = $(this);
        var $planeInfoDetail = $(".plane-info-detail");
        var thisL = $this.offset().left,
        thisT = $this.offset().top,
        thisH = $this.outerHeight(true);

        $planeInfoDetail.find(".pi-plan").text($this.data("plan"));
        $planeInfoDetail.find(".pi-name").text($this.data("name"));
        $planeInfoDetail.find(".pi-type").text($this.data("type"));
        $planeInfoDetail.find(".pi-min").text($this.data("min"));
        $planeInfoDetail.find(".pi-max").text($this.data("max"));

        $('.plane-info').show().css({
            'left': thisL,
            'top': thisT + thisH + 4
        });
    },function () {
        var timeId = setTimeout(function(){
            $('.plane-info').hide();
        },300);
        $('.plane-info').mouseenter(function(){
            clearTimeout(timeId);
        }).mouseleave(function(){
            $(this).hide();
        });
    });
    
});


//验证姓名，是否符合规范
function checkUserName(that){
	var userName = $(that).val();
	if($.trim(userName)==""){
		$(that).siblings(".error_text").html("<i class=\"tip-icon tip-icon-error\"></i>请输入姓名");
		$(that).parent().addClass('error_show');return false;
	}else if(!/^([\u4e00-\u9fa5]+|[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+[\u4e00-\u9fa5]+|[a-zA-Z]+[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+\/[a-zA-Z]+)+$/.test(userName)||userName.length<2){
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
	if(null==$.trim(contactName)||""==$.trim(contactName)){
		$(that).parent().addClass('error_show');return false;
	}else{
		$(that).parent().removeClass('error_show');return false;
	}
	return true;
}


//勾选常用联系人，控制人数
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

$(document).bind("click", function($element) {
         
        if($element.target.className=='fillInBtn'){
            $("#fillingExplanation_"+$element.target.id).html($("#fillingExplanationHtml").html());
            $("#fillingExplanation_"+$element.target.id).toggle();
        }else{
            $(".fillingExplanation").hide();
        }
  });

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
	   if($(this).val() === 'PASSPORT'){
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
//鼠标离开输入框，验证
/*$('.js_yz').live('blur',function(){ 
	var This = $(this);
	setTimeout(function(){
		yanzhengThis(This)
	},150)
	
});*/

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

//点击常用联系人