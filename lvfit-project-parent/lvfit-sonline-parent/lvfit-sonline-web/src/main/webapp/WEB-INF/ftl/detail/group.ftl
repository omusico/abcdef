 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
      ${tdkStr}
    <!--<link rel="stylesheet" href="http://s2.lvjs.com.cn/min/index.php?f=/styles/line/detail/calendar.css,/styles/v6/public/base.css,/styles/v6/public/common_box.css&version=122206" type="text/css" />-->
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v5/modules/tip.css,/styles/v4/modules/dialog.css,/styles/v4/modules/selectbox.css,/styles/v5/modules/tags.css,/styles/v5/modules/form.css,/styles/v5/modules/arrow.css,/styles/v5/modules/button.css,/styles/v5/modules/paging.css,/styles/v6/public/dianping.css&version=${version!}" type="text/css" />
    <!--<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/line/detail/product-detail-group.css,/styles/line/detail/calendar.css,/js/bower_components/PikaChoose/styles/base.css,/styles/v6/public/common_box.css&version=${version!}" type="text/css" />-->
    <!--<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v4/modules/calendar.css,/styles/v5/modules/dialog.css,styles/new_v/ob_login/l_fast_login.css&version=${version!}" />-->
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v5/comments_enterorder.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/lv/calendar.css">
    <link rel="stylesheet" href="http://s2.lvjs.com.cn/min/index.php?f=/styles/line/detail/calendar.css,/styles/v6/public/base.css,/styles/v6/public/common_box.css&version=122206">
    <!--点评添加-->
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/comment/comment_index.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/dest.css"/>
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/comment/relatedpages.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/line/detail/product-detail-group.css">
    <!--[if lt IE 8]>
    <script src="http://pic.lvmama.com/js/common/json_change.js"></script>
    <![endif]-->
    <script type="text/javascript" src="http://pic.lvmama.com/min/index.php?f=js/new_v/jquery-1.7.2.min.js"></script>
    <script src="http://pic.lvmama.com/js/v6/modules/mapControl.js"></script>
   	<script src="http://pic.lvmama.com/min/index.php?f=/js/lv/calendar.js"></script>
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/public/promotion-module.css">

    <script type="text/javascript">
        var _data = {};
        _data._contextPath = "${request.contextPath}";
    </script>
    <script src="http://s3.lvjs.com.cn/js/v5/ibm/eluminate.js"></script>
    <script src="http://s3.lvjs.com.cn/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>cmSetClientID("90409730",true,"data.cn.coremetrics.com","lvmama.com");</script>
    <script>
        cmCreatePageviewTag("产品详情页-跟团游-国内-${productTypeName}", "跟团游产品详情页");
        cmCreateProductviewTag('${basicInfo.productId}', '${basicInfo.productName}','跟团游', '-_--_--_-'+'国内游事业部');
    </script>
</head>
<body class="details_page">

    <#include "detail/head.ftl">
    <div class="line-detail-main">
        <div class="product-main clearfix">
        <#include "detail/group_base.ftl">
        <#include "detail/product_order_bar.ftl">

        <#include "detail/bottom.ftl">
        <#include "detail/last_bottom.ftl">
        </div>
    </div>

    <script src="${request.contextPath}/js/product/product_goods.js"></script>
    <script src="http://s3.lvjs.com.cn/min/index.php?f=/js/ui/lvmamaUI/lvmamaUI.js,/js/v5/modules/pandora-poptip.js,/js/v5/modules/pandora-dialog.js"></script>
	<script src="${request.contextPath}/js/line/product-detail-group.js"></script>
</body>
</html>