//验证姓名，是否符合规范
function checkUserName(that){
	var userName = $(that).val();
	if(!/^([\u4e00-\u9fa5]+|[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+[\u4e00-\u9fa5]+|[a-zA-Z]+[\u4e00-\u9fa5]+[a-zA-Z]+|[a-zA-Z]+\/[a-zA-Z]+)+$/.test(userName)){
		$(that).parent().addClass('error_show');
	}else{
		$(that).parent().removeClass('error_show');
	}
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
		if(value=='ID_CARD'){
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
$('.js_yz').live('blur',function(){ 
	var This = $(this);
	setTimeout(function(){
		yanzhengThis(This)
	},150)
	
});

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