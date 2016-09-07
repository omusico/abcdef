 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
     ${tdkStr}
    <link rel="stylesheet" href="http://s1.lvjs.com.cn/min/index.php?f=/styles/v6/header_new.css,/styles/v5/modules/tip.css,/styles/v4/modules/selectbox.css,/styles/v5/modules/tags.css,/styles/v5/modules/form.css,/styles/v5/modules/arrow.css,/styles/v5/modules/button.css,/styles/v5/modules/paging.css,/styles/v6/public/dianping.css,/styles/v6/flighthotel/fh-icon-ac.css&version=041506" />
    <link rel="stylesheet" href="http://s1.lvjs.com.cn/min/index.php?f=/styles/v6/header_new.css,/styles/v5/modules/tip.css,/styles/v4/modules/selectbox.css,/styles/v5/modules/tags.css,/styles/v5/modules/form.css,/styles/v5/modules/arrow.css,/styles/v5/modules/button.css,/styles/v5/modules/paging.css,/styles/v6/public/dianping.css,/styles/v6/flighthotel/fh-icon-ac.css&version=041506" />
    <link rel="stylesheet" href="http://s1.lvjs.com.cn/min/index.php?f=/styles/v6/header_new.css,/styles/v5/modules/tip.css,/styles/v4/modules/selectbox.css,/styles/v5/modules/tags.css,/styles/v5/modules/form.css,/styles/v5/modules/arrow.css,/styles/v5/modules/button.css,/styles/v5/modules/paging.css,/styles/v6/public/dianping.css,/styles/v6/flighthotel/fh-icon-ac.css&version=041506" />
    <link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon" >
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/modules/calendar.css,/styles/line/detail/product-detail-freetour.css,/styles/common/poplogin.css,/styles/v5/modules/dialog.css&version=${version!}" />
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v5/modules/tip.css,/styles/v4/modules/selectbox.css,/styles/v5/modules/tags.css,/styles/v5/modules/form.css,/styles/v5/modules/arrow.css,/styles/v5/modules/button.css,/styles/v5/modules/paging.css,/styles/v6/public/dianping.css&version=${version!}" type="text/css" />
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/line/detail/product-detail-freetour.css,/styles/line/detail/calendar.css,/js/bower_components/PikaChoose/styles/base.css,/styles/v6/public/common_box.css&version=${version!}" type="text/css" />
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v5/comments_enterorder.css">
    <!--点评添加-->
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/comment/comment_index.css">
    <!--<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/dest.css"/>-->
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/comment/relatedpages.css">
    <link rel="stylesheet" href="http://s2.lvjs.com.cn/min/index.php?f=/styles/line/detail/calendar.css,/styles/v6/public/base.css,/styles/v6/public/common_box.css&version=122206" type="text/css" />

    <script type="text/javascript" src="http://pic.lvmama.com/min/index.php?f=js/new_v/jquery-1.7.2.min.js"></script>
    <script src="http://pic.lvmama.com/js/v6/modules/mapControl.js"></script>
    <link rel="stylesheet" href="${request.contextPath}/css/line/line_detail.css" />
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/public/promotion-module.css" />
    <script type="text/javascript">
        var _data = {};
        _data._contextPath = "${request.contextPath}";
    </script>
    <script src="http://s3.lvjs.com.cn/js/v5/ibm/eluminate.js"></script>
    <script src="http://s3.lvjs.com.cn/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>cmSetClientID("90409730",true,"data.cn.coremetrics.com","lvmama.com");</script>
    <script>
        cmCreatePageviewTag("产品详情页-自由行-国内-${productTypeName}", "自由行产品详情页");
        cmCreateProductviewTag('${basicInfo.productId}', '${basicInfo.productName}', '自由行', '-_--_--_-'+'国内游事业部'); 
    </script>
</head>
<body class="details_page">

    <#include "detail/head.ftl">
    <div class="line-detail-main">
        <div class="product-main clearfix"> 
        </div>
    </div>
    <script>
        $(function () {
            $('.preorder-total-price').width(216);
        });
       
    </script>
	
	<style>
    .btn-stop {
        height: 40px;
        padding: 0 26px;
        background: #f80;
        border-color: #f80;
        color: #fff;
        font: normal 18px/40px "Microsoft Yahei";
    }
    .btn-stop:hover {
        background: #f80;
        color: #fff;
        cursor: default;
    }
</style>
	
  
	  <!-- 顶部产品概览结束 -->
    <div id="preorder-height-holder" class="preorder-height-holder">
	
	<!-- 预订详细配置开始 -->
	<div id="preorder-adjust" class="preorder-adjust">
	

	<!-- 交通 -->
	<div class="adjust-traffic preorder-adjust-first" id="adjust-traffic">
		<#include "/detail/item/traffic.ftl"/>
	</div> 
	
	
	
	</div>
    <!-- 预订详细配置结束 -->
    </div>
	</body>
</html> 
<script src="http://s3.lvjs.com.cn/min/index.php?f=/js/common/poplogin.js"></script>
<script src="http://s3.lvjs.com.cn/min/index.php?f=/js/ui/lvmamaUI/lvmamaUI.js,/js/v6/public/searchComplete.js,/js/v6/header_new.js,/js/v5/modules/pandora-poptip.js,/js/v6/public/dianping.js,/js/v5/modules/pandora-select.js,/js/v5/modules/pandora-dialog.js"></script>
 <script src="http://s1.lvjs.com.cn/min/index.php?f=/js/line/product-detail-group.js"></script> <!---->
<script type="text/javascript" src="http://s1.lvjs.com.cn/js/v6/public/promotion-module.js"></script> 
<script src="http://s1.lvjs.com.cn/js/v5/modules/pandora-poptip.js"></script>
<script src="${request.contextPath}/js/product/product_goods.js"></script>    
<script src="${request.contextPath}/js/line/product-detail-freetour.js"></script>