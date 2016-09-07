// JavaScript Document

$(function(){ 
	
	
	/*$('.js_youwanTime').focus(function(){ 
		pandora.calendar();
	});*/
	
	//下单日期调用，此代码已经迁移到后台
/**/
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
	
	var name_list_new_box = $('.name_list_new_box');
	if(name_list_new_box.length>0){
		$(window).scroll(function(){ 
			var win_t = $(window).height() - name_list_new_box.height();
			var obj_t = name_list_new_box.offset().top;
			var scroll_t = $(document).scrollTop();
			var order_box_h = name_list_new_box.parents('.order_box').height();
			if(scroll_t > obj_t && scroll_t && scroll_t < order_box_h+obj_t-100){
				
				name_list_new_box.find('.name_list_new').css({'position':'fixed','top':0,'z-index':199})
			}else{
				name_list_new_box.find('.name_list_new').css({'position':'relative','top':'inherit','z-index':0})
			}
		});
	}
	
	
	/*pandora.calendar({
        trigger: ".js_qzTime",
		template: "small",    //小日历
		isTodayClick:true,  //当天是否可点击
		offsetAmount:{left:-339,top:0}
    });
	
	pandora.calendar({
        trigger: ".js_bxTime",
		template: "small",    //小日历
		isTodayClick:true  //当天是否可点击
    });*/


	$(".js_birthday").each(function(){
		$(this).ui("calendar",{
		   input : this,
		   parm:{dateFmt:'yyyy-MM-dd'}
		})
	})
	
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
	
	//目的地保险展开收起
	$('.js_bx_name,.bx_info_sq').live("click", function(){ 
		var bx_list_box = $(this).parents('.bx_list_box');
		if(bx_list_box.hasClass('jt_up')){
			bx_list_box.removeClass('jt_up').find('.pro_info').hide();
		}else{
			bx_list_box.addClass('jt_up').find('.pro_info').show();
		}
	});
	
	$('.bx_other').live('click',function(){
		if(!$(this).hasClass('bx_show')){
			$(this).addClass('bx_show').html('收起').siblings('.bx_list_box').show();
		}else{
			$(this).removeClass('bx_show').html('显示全部保险项目').siblings('.bx_list_box:gt(0)').hide();
		}
		
	});
	
	
	$('.js_bx_check').click(function(){ 
		if($(this).find('input').attr('checked')){
			$(this).parents('.user_dl').prev('.hide').show();
		}else{
			$(this).parents('.user_dl').prev('.hide').hide();
		}
	});
	
	$('.btn_qita').click(function(){ 
		var pro_info = $(this).siblings('#otherTicketDiv');
		if(pro_info.find('.table_t').eq(0).is(':hidden')){
			$(this).hide().addClass('jt_up');
			pro_info.find('.table_t').show();
		}else{
			$(this).removeClass('jt_up');
			pro_info.find('.table_t').hide();
		}
		
	});
	
	
	$(".tagsback,.tags101,.bx_ts,.js_tips").poptip({
		place : 6
	});
	
	$(".bx_ts").poptip({
		place : 6,
		skin:'#ff6600'
	});
	
	//选择联系人提示人数已满,此代码已经迁移到后台
	/*$('.name_list_new .check').click(function(){ 
		var obj = $(this);
		nameFull(obj);
	});
	*/
	
	//提示人数上限,此代码已经迁移到后台
	/*$('.num_add').click(function(){ 
		var obj = $(this).parent(); //提示出现的模块位置
		var text = '最多2人'      //提示的文字
		var left = 5;            //提示的left微调
		var top = 6;             //提示的top微调
		var type = 'warning';    //warning(感叹号)；
		var fn = false;
		nameFull(obj,text,left,top,type,fn) //提示调用的方法
	});*/
	
	
	$('.js_kuaidi').click(function(){ 
		$(this).parents('.table_t').addClass('kd_yixuan').siblings('.table_t').removeClass('kd_yixuan');
	});
	
	//选择优惠券
	$('.yh_list').change(function(){ 
		$(this).parent().next('.pro_info').show();
		$(this).parents('dd').siblings().find('.pro_info').hide();
	});
	
	//付款按钮
	/*$('.btn_fk').click(function(){ 
		if(yanzhengOk()){
			
		}
	});*/
	
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
	
	
	
/*	//选择省市数据
	var city = [
				{ name: "选择省", cities: ["选择市"] },
				{ name: "北京", cities: ["西城", "东城", "崇文", "宣武", "朝阳", "海淀", "丰台", "石景山", "门头沟", "房山", "通州", "顺义", "大兴", "昌平", "平谷", "怀柔", "密云", "延庆"] },
				{ name: "天津", cities: ["青羊", "河东", "河西", "南开", "河北", "红桥", "塘沽", "汉沽", "大港", "东丽", "西青", "北辰", "津南", "武清", "宝坻", "静海", "宁河", "蓟县", "开发区"] },
				{ name: "河北", cities: ["石家庄", "秦皇岛", "廊坊", "保定", "邯郸", "唐山", "邢台", "衡水", "张家口", "承德", "沧州", "衡水"] },
				{ name: "山西", cities: ["太原", "大同", "长治", "晋中", "阳泉", "朔州", "运城", "临汾"] },
				{ name: "内蒙古", cities: ["呼和浩特", "赤峰", "通辽", "锡林郭勒", "兴安"] },
				{ name: "辽宁", cities: ["大连", "沈阳", "鞍山", "抚顺", "营口", "锦州", "丹东", "朝阳", "辽阳", "阜新", "铁岭", "盘锦", "本溪", "葫芦岛"] },
				{ name: "吉林", cities: ["长春", "吉林", "四平", "辽源", "通化", "延吉", "白城", "辽源", "松原", "临江", "珲春"] },
				{ name: "黑龙江", cities: ["哈尔滨", "齐齐哈尔", "大庆", "牡丹江", "鹤岗", "佳木斯", "绥化"] },
				{ name: "上海", cities: ["浦东", "杨浦", "徐汇", "静安", "卢湾", "黄浦", "普陀", "闸北", "虹口", "长宁", "宝山", "闵行", "嘉定", "金山", "松江", "青浦", "崇明", "奉贤", "南汇"] },
				{ name: "江苏", cities: ["南京", "苏州", "无锡", "常州", "扬州", "徐州", "南通", "镇江", "泰州", "淮安", "连云港", "宿迁", "盐城", "淮阴", "沐阳", "张家港"] },
				{ name: "浙江", cities: ["杭州", "金华", "宁波", "温州", "嘉兴", "绍兴", "丽水", "湖州", "台州", "舟山", "衢州"] },
				{ name: "安徽", cities: ["合肥", "马鞍山", "蚌埠", "黄山", "芜湖", "淮南", "铜陵", "阜阳", "宣城", "安庆"] },
				{ name: "福建", cities: ["福州", "厦门", "泉州", "漳州", "南平", "龙岩", "莆田", "三明", "宁德"] },
				{ name: "江西", cities: ["南昌", "景德镇", "上饶", "萍乡", "九江", "吉安", "宜春", "鹰潭", "新余", "赣州"] },
				{ name: "山东", cities: ["青岛", "济南", "淄博", "烟台", "泰安", "临沂", "日照", "德州", "威海", "东营", "荷泽", "济宁", "潍坊", "枣庄", "聊城"] },
				{ name: "河南", cities: ["郑州", "洛阳", "开封", "平顶山", "濮阳", "安阳", "许昌", "南阳", "信阳", "周口", "新乡", "焦作", "三门峡", "商丘"] },
				{ name: "湖北", cities: ["武汉", "襄阳", "孝感", "十堰", "荆州", "黄石", "宜昌", "黄冈", "恩施", "鄂州", "江汉", "随枣", "荆沙", "咸宁"] },
				{ name: "湖南", cities: ["长沙", "湘潭", "岳阳", "株洲", "怀化", "永州", "益阳", "张家界", "常德", "衡阳", "湘西", "邵阳", "娄底", "郴州"] },
				{ name: "广东", cities: ["广州", "深圳", "东莞", "佛山", "珠海", "汕头", "韶关", "江门", "梅州", "揭阳", "中山", "河源", "惠州", "茂名", "湛江", "阳江", "潮州", "云浮", "汕尾", "潮阳", "肇庆", "顺德", "清远"] },
				{ name: "广西", cities: ["南宁", "桂林", "柳州", "梧州", "来宾", "贵港", "玉林", "贺州"] },
				{ name: "海南", cities: ["海口", "三亚"] },
				{ name: "重庆", cities: ["渝中", "大渡口", "江北", "沙坪坝", "九龙坡", "南岸", "北碚", "万盛", "双桥", "渝北", "巴南", "万州", "涪陵", "黔江", "长寿"] },
				{ name: "四川", cities: ["成都", "达州", "南充", "乐山", "绵阳", "德阳", "内江", "遂宁", "宜宾", "巴中", "自贡", "康定", "攀枝花"] },
				{ name: "贵州", cities: ["贵阳", "遵义", "安顺", "黔西南", "都匀"] },
				{ name: "云南", cities: ["昆明", "丽江", "昭通", "玉溪", "临沧", "文山", "红河", "楚雄", "大理"] },
				{ name: "西藏", cities: ["拉萨", "林芝", "日喀则", "昌都"] },
				{ name: "陕西", cities: ["西安", "咸阳", "延安", "汉中", "榆林", "商南", "略阳", "宜君", "麟游", "白河"] },
				{ name: "甘肃", cities: ["兰州", "金昌", "天水", "武威", "张掖", "平凉", "酒泉"] },
				{ name: "青海", cities: ["黄南", "海南", "西宁", "海东", "海西", "海北", "果洛", "玉树"] },
				{ name: "宁夏", cities: ["银川", "吴忠"] },
				{ name: "新疆", cities: ["乌鲁木齐", "哈密", "喀什", "巴音郭楞", "昌吉", "伊犁", "阿勒泰", "克拉玛依", "博尔塔拉"] },
				{ name: "香港", cities: ["中西区", "湾仔区", "东区", "南区", "九龙-油尖旺区", "九龙-深水埗区", "九龙-九龙城区", "九龙-黄大仙区", "九龙-观塘区", "新界-北区", "新界-大埔区", "新界-沙田区", "新界-西贡区", "新界-荃湾区", "新界-屯门区", "新界-元朗区", "新界-葵青区", "新界-离岛区"] },
				{ name: "澳门", cities: ["花地玛堂区", "圣安多尼堂区", "大堂区", "望德堂区", "风顺堂区", "嘉模堂区", "圣方济各堂区", "路氹城"]},
				{ name: "台湾", cities: ["台北", "台中", "台南", "高雄", "基隆"]},
				{ name: "钓鱼岛", cities: ["钓鱼岛"]}			
				];
	
	var $city1 = $('#js_city1');
	var $city2 = $('#js_city2');
	if($city1.length>0){
		for(var i=0;i<city.length;i++){
			js_city1[i] = new Option(city[i].name);
		};
		
		$city1.change(function(){ 
			var num = this.selectedIndex;
			js_city2.length=1;
			if(num!=0){
				for(var i=0;i<city[num].cities.length;i++){
					js_city2[i+1] = new Option(city[num].cities[i]);
				};
			}
		});
	};
*/
	/*
	//添加礼品卡
	$('.js_addcard').live('click',function(){ 
		$(this).hide().next('.dikou_box').show();
	});
	
	//取消礼品卡
	$('.js_lpk_cancel').live('click',function(){ 
		$(this).parents('.lipinka_box').find('li').find('.input').removeClass('input_red').val('');
		$(this).parents('.youhui_info').hide().siblings('.youhui_tit').removeClass('info_show');
		$('.js_nameFull').remove();
	});
	
	
	//取消储值卡
	$('.js_czk_cancel').live('click',function(){ 
		$(this).hide().find('.input').val('');
		$(this).parents('.lipinka_box').siblings('.btn_addcard').show();
	});
	*/
	//可享促销展开
	$('.youhui_tit').live('click',function(){ 
		$('.js_nameFull').remove();
		if(!$(this).hasClass('info_show')){
			$(this).addClass('info_show').siblings('.youhui_info').show();
		}else{
			$(this).removeClass('info_show').siblings('.youhui_info').hide();
		}
	});
	
	
	
	/*添加礼品卡*/
	/*$('.js_dikou_queren').live('click',function(){ 
		if(!$(this).hasClass('btn_stop')){
			var price = $(this).siblings('.yong_input').find('input').val().replace(/\b(0+)/gi,""); 
			$(this).siblings('.yong_input').find('input').val(price);
			if(!price){
				price = '0';
			}
			$(this).hide().next('.dikou_box').show();
			$(this).siblings('.yong_input').hide();
			$(this).siblings('.yong_text').show().html(price+' 元');
		}
		
	});
	
	$('.js_dikou_quxiao').live('click',function(){ 
		$(this).siblings('.btn').show();
		$(this).siblings('.yong_input').show();
		$(this).siblings('.yong_text').hide().html('¥ 0');
	});
	
	
	
	$('.js_dikou_input').keyup(function(event){ 
		var text = $(this).val();
		var key = parseInt($(this).val()),
			zhanghu = parseInt($(this).parents('.dikou_box').siblings('.dikou_b').find('samp').text());
		if (event.keyCode == "110" || event.keyCode == "190") {}
		if(key>zhanghu || !/^[0-9]+$/.test(text)){
			$(this).parent().siblings('.btn-orange').addClass('btn_stop');
		}else{
			$(this).parent().siblings('.btn-orange').removeClass('btn_stop');
		}
	})
	*/
	
	//鼠标离开日期框，验证日期是否填写
	/*$('.js_youwanTime').blur(function(){ 
		if($(this).val()=='请选择游玩日期'){
			nameFull($(this),'请选择游玩日期',190,-25,'warning');   //错误提示函数，参数1：提示的对象，参数2：文字，3：是left值，4：top值，5、提示类型：warning或error
			//removeTips();  //删除提示框,需要删除提示框的时候调用这个函数
		}else{
			$(this).removeClass('input_red');
		}
	});*/
	
	
	
	/*//优惠券提示
	$('.js_yhq_yz').live('click',function(){ 
		var  obj = $(this).siblings('input');
		var text = '优惠券兑换码输入错误，请重新输入';
		nameFull(obj,text,10,8,'warning');
	});
	
	//优惠券提示
	$('.js_card_yz').live('click',function(){ 
		var  obj = $(this).parents('ul').find('input');
		var text = '卡号输入有误';
		nameFull(obj,text,10,8,'warning');
	});
	
	$('.js_lpk_true').live('click',function(){ 
		for(var i=1;i<4;i++){
			var obj = $('.lipinka_box input').eq(i);
			var text = '卡号输入有误';
			nameFull(obj,text,10,8,'warning');
			
		}
	});
	
	
	$('.js_check_tips').live('click',function(){ 
			var text = '卡号输入有误';
			nameFull($(this),text,10,8,'warning');
	});
	
	//使用储值卡
	$('.js_card_yz').live('click',function(){ 
		addCard('储值卡','4465444444444','4444444.00');
	});
	
	//使用礼品卡
	$('.js_lpk_true').live('click',function(){ 
		addCard('礼品卡','4465444444444','4444444.00');
	});
	
	//使用金额确认
	$('.js_card_ok').live('click',function(){ 
		var yong_box = $(this).parents('tr').find('.yong_price');
		var yong_price = yong_box.find('input').val();
		if(yong_price==''){
			yong_price=0;
		}
		yong_box.html(yong_price+'元').attr('yong_price',yong_price);
		$(this).parent().html('<a class="card_gai" href="javascript:;" hidefocus="false">修改</a> <a class="card_del" href="javascript:;" hidefocus="false">删除</a>');
	})
	
	//修改使用金额
	$('.card_gai').live('click',function(){ 
		var yong_box = $(this).parents('tr').find('.yong_price');
		var yong_price = yong_box.attr('yong_price');
		yong_box.html('<input class="input" value="'+yong_price+'" type="text">元');
		$(this).parent().html('<span class="btn btn-mini btn-orange js_card_ok">确认</span> <span class="btn btn-mini btn-default js_card_cancel">取消</span>')
	})
	
	//取消使用金额
	$('.js_card_cancel').live('click',function(){ 
		var yong_box = $(this).parents('tr').find('.yong_price');
		var yong_price = yong_box.attr('yong_price');
		yong_box.html(yong_price+'元');
		$(this).parent().html('<a class="card_gai" href="javascript:;" hidefocus="false">修改</a> <a class="card_del" href="javascript:;" hidefocus="false">删除</a>')
	})
	
	//删除卡
	$('.card_del').live('click',function(){ 
		if($(this).parents('.youhui_table').find('tr').length<3){
			$(this).parents('.youhui_table').html('');
		}
		$(this).parents('tr').remove();
	});
	*/

	
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
	
	
	
	///选择出生日期
	$("body").ui("calendar",{
        input : ".js_birthday",
        parm:{dateFmt:'yyyy-MM-dd'}
    })
	
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
		
		/*var copyName = $('.js_copy_info').eq(0).find('.input').eq(0).val();
		var copyMobile = $('.js_copy_info').eq(0).find('.input').eq(1).val();
		if(copyName!='' && copyMobile!=''){
			$(this).siblings('.input').val(copyName);
			$(this).parents('.user_dl').next('.user_dl').find('.input').val(copyMobile);
			$(this).parents('.user_info').find('dd').removeClass('error_show');
		}else{
			alert('请先填写购买人信息!')
		}*/
	});
	
	//发送验证码,一放在后台
	/*var times = 60,
		timer4 = null,
		downTime = true;
	$('.js_order_yzm').live('click',function(){ 
		if(times==60 && downTime){
			downTime = false;
			var This = $(this);
			This.html('<span class="c_f60">60</span>秒后重发').addClass('disabled');
			
			timer4 = setInterval(function(){
				times--;
				This.find('span').html(times);
				if(times==0){
					clearTimeout(timer4);
					This.html('重发验证码').removeClass('disabled');
					times=60;
					downTime = true;
				}
			},1000);
			
			//发送验证码的请求，在这里写.	
		}
		
	});*/
	
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

	
	//酒店下单
	/*pandora.calendar({
        trigger: ".js_hotel_time",
        isRange: true,
        cascade: {
            days: 1,
            trigger: ".js_hotel_time"
        },
        isTodayClick: true,
        template: "small",
        selectDateCallback: null
    });*/
	
	
	
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
			yanzhengThis(This)
		}
		
		for(var i=0;i<$('.error_show').length;i++){
			if($('.error_show').eq(i).is(':visible')){
				$('.error_show').eq(i).find('.js_yz:first').focus();
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
		var _english = /[\u4e00-\u9fa5]+/;
		var _english2 = /^[a-zA-Z\s]+$/;
		var _username = /[a-zA-Z\u4e00-\u9fa5]+$/;
		var value = $.trim(This.val());
		if(This.is(':visible')){
			//验证是否输入文字
			if(This.attr('type_name')=='text'){
				if( value==''){
					This.parent().addClass('error_show');
					//return false;
				}else{
					This.parent().removeClass('error_show');
				}
			};
			
			//验证中英文姓名
			if(This.attr('type_name')=='username'){
				if( value=='' || !_username.test(value)){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			
			//验证非汉字
			if(This.attr('type_name')=='english'){
				if( value=='' || _english.test(value)){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			
			//验证英文字母
			if(This.attr('type_name')=='english2'){
				if( value=='' || !_english2.test(value)){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			
			//验证抵现数字
			if(This.attr('type_name')=='number'){
				if( value=='' && This.prev().find('input').attr('checked') || isNaN(value) && This.prev().find('input').attr('checked') ||  isNaN(value) && This.prev().find('input').length==0 ||  value=='' && This.prev().find('input').length==0){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证优惠券是否选择和输入
			if(This.attr('type_name')=='youhuiquan'){
				if( value=='' && This.prev().find('input').attr('checked') || isNaN(value) && This.prev().find('input').attr('checked')){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证手机
			if(This.attr('type_name')=='mobile'){
				if(value=='' || !_mobile.test(value)){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证邮箱
			if(This.attr('type_name')=='email'){
				if(value=='' || !_email.test(value)){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证身份证
			if(This.attr('type_name')=='shenfenzheng'){
			    if (value == '' || !isIdCardNo(value) && This.siblings('.select').val() == 'ID_CARD') {
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证地址
			if(This.attr('type_name')=='address'){
				if(value=='' || value.length<5 ||  $('#js_city1').val()=='选择省' || $('#js_city2').val()=='选择市'){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
			//验证邮编
			if(This.attr('type_name')=='youbian'){
				if(value.length!=6 && value!=''){
					This.parent().addClass('error_show');
				}else{
					This.parent().removeClass('error_show');
				}
			};
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
		$('.js_nameFull').remove();
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

//门票-长隆库存校验-订单填写-场次
(function(){
	
	tipFix();

	// 最多可选提示 动态定位方法
	function tipFix(){
		var $floatTip = $('.d_floatTipFix');
		var $num_box = $floatTip.prev('.num_box');
		var $doc = $(document);
		var $win = $(window);

		if($floatTip.length != 1) return false;

		changePos();

		$win.scroll(function(event) {
			changePos();
		});

		$win.resize(function(event) {
			changePos();
		});

		function changePos(){
			$floatTip.css({
				'top' : $num_box.offset().top - $doc.scrollTop(),
				'left': $num_box.offset().left
			});
		}
	}

})();	

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