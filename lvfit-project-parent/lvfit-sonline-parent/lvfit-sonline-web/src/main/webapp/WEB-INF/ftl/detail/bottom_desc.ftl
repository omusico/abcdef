<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
     <script type="text/javascript" src="http://pic.lvmama.com/min/index.php?f=js/new_v/jquery-1.7.2.min.js"></script>
</head>

<body>

   	${bottomDescInfo}
   					
<script>
       $(function (){
       
       		//需要动态初始化的参数
			var productId = '${productId}';
			var packagedProductId = '${packagedProductId}';
			var routeDetailUseFlag = '${routeDetailUseFlag}';
			var feeExplainUseFlag = '${feeExplainUseFlag}';
			var routeDetailUseFlag = '${routeDetailUseFlag}';
			var feeExplainUseFlag = '${feeExplainUseFlag}';
       		$("#productId",parent.document).val(productId);
       		
       		parent.window.cmtRef = window.cmtRef;//重新初始化相关点评的相关对象
       		//parent.setDynamicParmFromFrame(productId);

          //1. 设置产品详情
          var product_detail = $("#product-detail").html();
          var product_summary = $("#product-detail .product-summary");
          var instance_body =$("#product-detail .detail-instance-body span").html();
          if($("#product-detail").find(".product-summary").length<=0){
        	  $("#product-detail").find(".instance-title").eq(0).after($(".product-summary")[0]);
          }
          if(product_summary.length<=0 && instance_body==null){
           	//$("a[data-flag='product-detail']",window.parent.document).parent("li").remove();
           	//$("#product-detail",window.parent.document).remove();
           }else{
          	parent.setProductDetail(product_detail);
          	}
          
           //2. 设置行程介绍
           var product_travel = $("#product-travel").html();
           if(product_travel==null){
        	   var xc_day = $(".xingcheng_day");
        	   parent.setProductTravelHotelCombo(xc_day);
           }else{
           	var tripType = $("#product-travel .instance_box>div.clearfix").html();
           	var instance_list = $("#product-travel .instance_list").html();
           	var J_scrollnav1 = $("#product-travel .instance_list2_box .travel-fixed #J_scrollnav1").html();
           	var xc_detail = $("#product-travel .instance_list2_box .instance-travel-xc-gb").html();
           	var travel_days = $("#product-travel div.travel-days");
           	var traffic_type = $("#product-travel .instance_list2_box div.travel-instance");
           	var havepackagedProductId = $("#product-travel").attr("packagedProductId") || packagedProductId ;           	
          	parent.setProductTravel(tripType,instance_list,J_scrollnav1,xc_detail,travel_days,traffic_type,havepackagedProductId);}
           
           //3. 设置交通地图
           var product_map = $("#product-map").html();
           if(product_map==null){
           	 //$("a[data-flag='product-map']",window.parent.document).parent("li").remove();
           	 //$("#product-map",window.parent.document).remove();
           }else if(typeof(jsonArray)!=="undefined"){
           		parent.setProductMap(product_map,jsonArray);//jsonArray为坐标数组
           }
           //4. 设置费用说明
           var product_cost = $("#product-cost").html();
           var instance_list2 = $("#product-cost div.instance_list2 .product-detail-instance").html();
           if(instance_list2==null){
        	   var feiyong_all = $(".feiyong_all");
        	   feiyong_all.find("strong").css("font-weight","bold");
        	   parent.setProductCost(null,feiyong_all);
           }else{
           		parent.setProductCost(product_cost);}
           
           //4. 设置分期说明
           //var product_fenqi = $("#product-fenqi").html();
           //if(product_fenqi==null){
           	 //$("a[data-flag='product-fenqi']",window.parent.document).parent("li").css("display","none");
           	// $("#product-fenqi",window.parent.document).css("display","none");
           //}else{
           		//parent.setProductFenqi(product_fenqi);}
           
           //5. 设置预订须知
           var preorder_note = $("#product-preorder-note").html();
           var desc_items = $("#product-preorder-note .detail-instance-body .detail-desc-item");
           var declarations = $("#product-preorder-note .detail-instance-body .declaration");
           var $packageProductPreorder = $("#packageproduct-preorder-note");
           if(routeDetailUseFlag==="Y" && $packageProductPreorder.length>0){//附加被打包产品  购物说明、推荐项目
        	   var packagedNotes = $packageProductPreorder.find(".instance_list2_box");
        	   $("#product-preorder-note .preorder-notice .instance_list2_box").remove();
        	   $("#product-preorder-note .preorder-notice").prepend(packagedNotes);
           }
           //if(desc_items.length<=0 && declarations.length<=0){
           	 //$("a[data-flag='product-preorder-note']",window.parent.document).parent("li").remove();
           	 //$("#product-preorder-note",window.parent.document).remove();
           //}else{
           		parent.setPreorderNote($("#product-preorder-note").html());//}
           
           //6. 设置线路推荐
           var product_recommend = $("#product-recommend").html();
           if(product_recommend==null){
           	 //$("a[data-flag='product-recommend']",window.parent.document).parent("li").remove();
           	 //$("#product-recommend",window.parent.document).remove();
           }else{
           		parent.setProductRoutRecommend();}
           //parent.setProductRecommend(product_recommend);
           
           //6. 设置驴友点评
           var totalCmt = $("#totalCmt").html();//旅游点评总数
           var allCmtComment = $("#product-customer-review .comwrap .JS_com-content #allCmtComment").html();//全部评论内容
           var new_cominfo = $("#product-customer-review .comwrap .new-cominfo").html();
           var allCmt = $("#allCmt").html();//全部评论Tab替换
           var bestCmt = $("#bestCmt").html();//精华评论Tab替换
           var picCmt = $("#picCmt").html();
           var refCmt = $("#refCmt").html();//相关评论Tab替换
           parent.setCustomerReview(totalCmt,new_cominfo,allCmtComment,allCmt,bestCmt,picCmt,refCmt);
           
           //6. 相关游记
           var customer_trip = $("#product-customer-trip").html();
           //if(customer_trip==null){
           	 //$("a[data-flag='product-customer-trip']",window.parent.document).parent("li").remove();
           	 //$("#product-customer-trip",window.parent.document).remove();
           //}else{
           	var tripListAll = $("#product-customer-trip .tripContent .tripListBox .tripListAll").html();
           	var destId = $("#destId").val();
            var travel_cCode = $("#_travel_cCode").val();
           	parent.setCustomerTrip(tripListAll,destId,travel_cCode);//}
          
          
       });
              
</script>		   
</body>
</html>
