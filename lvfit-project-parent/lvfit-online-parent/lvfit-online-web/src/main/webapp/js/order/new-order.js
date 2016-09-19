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
	
	//选择快递
	$('.js_kuaidi').change(function(){ 
		$(this).parents('.list_tit').next('.user_info').find('.user_dl:last').hide().siblings().show();
	});
	$('.js_ziqu').change(function(){ 
		$(this).parents('.list_tit').next('.user_info').find('.user_dl:last').show().siblings().hide();
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
		var $input1 = $('.js_copy_info').eq(0);
		var $input2 = $(this).parents('.user_info').eq(0);
		//赋值----将购买人所有的信息都赋值给游玩人1
		$input2.find("input[type_name='text']").val($input1.find("input[type_name='text']").val());
		$input2.find("input[name='receiverId']").val($input1.find("input[name='receiverId']").val());
		$input2.find("select[name='peopleType']").val($input1.find("input[name='peopleType']").val());
		$input2.find("select[name='cardType']").val($input1.find("input[name='certType']").val());
		$input2.find("input[type_name='shenfenzheng']").val($input1.find("input[name='certNo']").val());
		$input2.find("input[type_name='mobile']").val($input1.find("input[type_name='mobile']").val());
		$input2.find("input[type_name='birthday']").val($input1.find("input[name='birthday']").val());
		$input2.find("input[name='email']").val($input1.find("input[type_name='email']").val());
		//如果是证件类型是护照，则生日控件显示
		if($input1.find("input[name='certType']").val() == 'PASSPORT'){
			initPassport();
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
	//联想邮件地址选中其一
	$('#email_list li').live('click',function(e){ 
		var ThisLi = $(this),
			sText = ThisLi.text();
		nowInput.val(sText);
		if(ThisLi.click.caller==null){
			nowInput.blur();
		}
	});
	
	
	//保险切换
	$('.bx_tab li').live('click',function(){ 
		$(this).addClass('active').siblings().removeClass('active');
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
		for(var i=0;i<$yanzheng.length;i++){
			var This = $yanzheng.eq(i);
			var flag1=true,flag2=true;
			//检查所有人员姓名是否规范填写
			if(This.attr("type_name")==="text"){
				flag1 = checkUserName(This);
			}
			//检查证件信息是否重复
			if(This.attr("type_name")==="shenfenzheng"){
				if(This.siblings('.select').val() == 'ID_CARD'){
					flag2 = blurIdAndBirthday(This,"ID");
				}else{
					flag2 = verifyIDCardRepeat(This);
				}
			}
			if(flag1 && flag2){
				yanzhengThis(This);
			}
		}
		
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
					thisP.addClass('error_show');
				}else if(!_mobile.test(value) && value!=''){
					thisP.addClass('error_show');
				}else{
					thisP.removeClass('error_show');
				}
			}
			//验证邮箱
			if(This.attr('type_name')=='email'){
				if(value=='' && optional!="true"){
					thisP.addClass('error_show');
				}else if(!_email.test(value) && value!=''){
					thisP.addClass('error_show');
				}else{
					thisP.removeClass('error_show');
				}
			}
			//验证身份证
			if(This.attr('type_name')=='shenfenzheng'){
				if(value=='' && optional!="true"){
					thisP.addClass('error_show');
				}else if(!isIdCardNo(value) && This.siblings('.select').val() == 'ID_CARD' && value!=''){
					thisP.addClass('error_show');
				}/*else if(This.siblings('.select').val() == 'ID_CARD'){
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
	
	//优惠券模块提示文字
	var tipsid = 100;
	function popTips(obj,text,type,nodel){
		var L = obj.offset().left;
		var T = obj.offset().top + obj.outerHeight() + 4;
		var html = '';
		tipsid++;
		//计算弹窗提示箭头位置
		if(obj.outerWidth()<30){L=L-(30-obj.outerWidth())+3}
		
		if(!nodel){
			$('.js_popTips').remove();
		}
		
		//提示类型
		if(type=='warning'){
			html = '<div class="tiptext tip-warning tip-line js_popTips js_tips'+tipsid+'"><span class="tip-icon tip-icon-warning"></span>'+text+'<div class="tip-arrow tip-arrow-12" style="left:20px;"><em>◆</em><i>◆</i></div></div>';
		}else if(type=='error'){
			html = '<div class="tiptext tip-error tip-line js_popTips js_tips'+tipsid+'"><span class="tip-icon tip-icon-error"></span>'+text+'<div class="tip-arrow tip-arrow-12" style="left:20px;"><em>◆</em><i>◆</i></div></div>';
		}else{
			html = '<div class="tiptext tip-light js_popTips js_tips'+tipsid+'"><span class="tip-icon tip-icon-error"></span>'+text+'<div class="tip-arrow tip-arrow-12" style="left:20px;"><em>◆</em><i>◆</i></div></div>';
		};
		
		$('body').append(html);
		/*if($('.js_popTips').length==0){
			$('body').append(html);
		}*/
		
		//提示定位
		$('.js_tips'+tipsid).css({'position':'absolute','left':L,'top':T});
	}
	
	//删除提示
	function removeTips(){
		$('.js_nameFull,.js_popTips').remove();
	}
	
	
	//添加卡
	function addCard(cardName,cardNum,cardPrice){
		var cardTit = '<tr><th width="25%">'+cardName+'号</th><th width="25%">剩余金额</th><th width="25%">本次使用</th><th width="25%">　</th></tr>';
		var cardHtml ='<tr><td>'+cardNum+'</td><td>'+cardPrice+'元</td><td><div class="yong_price" yong_price="0"><input class="input" type="text">元</div></td><td><span class="btn btn-mini btn-orange js_card_ok">确认</span> <span class="btn btn-mini btn-default js_card_cancel">取消</span></td></tr>';
		if(cardName=='储值卡'){
			if($('.czk_table tr').length==0){
				$('.czk_table').append(cardTit+cardHtml);
			}else{
				$('.czk_table').append(cardHtml);
			}
		}else if(cardName=='礼品卡'){
			if($('.lpk_table tr').length==0){
				$('.lpk_table').append(cardTit+cardHtml);
			}else{
				$('.lpk_table').append(cardHtml);
			}
		}
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
	
	
	//添加被保险人名字
	function bxNameHtml(length){
		var html = '';
		for(i=0;i<length;i++){
			html += '<label class="check"></label>';
		}
		for(i=0;i<$('.js_bx_name').length;i++){
			$('.js_bx_name').eq(i).html(html);
		}
		
	}
	//被保险人显示隐藏
	function bxNameShow(length,bxName){
		var html = '<input class="checkbox" type="checkbox">'+bxName;
		if(bxName==false){
			for(i=0;i<$('.js_bx_name').length;i++){
				$('.js_bx_name').eq(i).find('.check').eq(length).html('');
			}
		}else{
			for(i=0;i<$('.js_bx_name').length;i++){
				$('.js_bx_name').eq(i).find('.check').eq(length).html(html);
			}
		}
		
	}


// 机+酒 下单
$(function(){
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