 <head>
  <meta charset="utf-8" />
 </head>

<!-- bottom 页面增加，动态传入 作为后续查询条件  ljl 5.18-->
<input type="hidden" name="productId" id="productId" value="${basicInfo.productId}">
  <!-- 是否是国内或者出境BU的产品 -->
  <div class="line-detail-main">

   <div class="product-main clearfix">

    <!-- 导航高度占位块开始 -->
    <div id="nav-height-holder" class="nav-height-holder">
     <!-- 产品头部导航开始-->
     <div class="product-detail-header clearfix" id="product-detail-header">
      <ul id="navigate-list">
       <li><a href="#" data-flag="product-detail">产品详情</a></li>
       <li><a href="#" data-flag="product-travel">行程介绍</a></li>
       <li><a href="#" data-flag="product-map">交通地图</a></li>
       <li><a href="#" data-flag="product-cost">费用说明</a></li>
       <!--小驴分期说明 -->
       <li><a href="#" data-flag="product-fenqi">分期说明<i class="floatTips">小驴分期<span class="triangle"></span></i></a></li>
       <li><a href="#" data-flag="product-preorder-note">预订须知</a></li>
       <li><a href="#" data-flag="product-recommend">线路推荐</a></li>
       <li date="comments"><a href="#" data-flag="product-customer-review">驴友点评<span id="totalCmt" class="customer-review-count"></span></a></li>
       <!-- <li><a href="#" data-flag="product-customer-trip">相关游记<span class="customer-review-count">()</span></a></li>-->
       <li><a href="#" data-flag="product-customer-trip">相关游记<span class="customer-review-count" id="travelCount"></span></a></li>
      </ul>
      <div class="product-detail-booking">
       开始预订
      </div>
     </div>
     <!-- 产品头部导航结束 -->
    </div>
    <!-- 导航高度占位块结束 -->
    <div class="product-modules clearfix common_box">
     <!-- 优惠活动开始 -->
     <!-- 优惠活动结束 -->
     <!-- 产品详情开始 -->
     <div class="product-detail-instance productDetailsbox" id="product-detail">
       <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-detail-icon"></i>
       </div>
       <h3>产品详情</h3>
      </div>
      <!--产品概要
      	线路详情页产品详情-产品概要
      <div class="product-summary">
       <h5>产品概要</h5>
       <div class="instance_list2_box">
        <div class="instance_list2" style="display:block;">
         <ul class="clearfix">
          住宿-
          <li class="product-summary-li-first"> <i class="icon-product-summary-hotel"></i> 含4晚住宿 </li>
          景点
          <li><i class="icon-product-summary-view-port"></i> 景点详见行程介绍 </li>
          交通
          <li><i class="icon-product-summary-traffic"></i> 含 飞机 </li>
          用餐
          <li class="product-summary-li-first"><i class="icon-product-summary-restaurant"></i> 含 4早餐

		        							11自理


		        					 </li>
          购物点
          <li><i class="icon-product-summary-shop"></i> 购物点详见行程介绍 </li>
          自由活动
          <li><i class="icon-product-summary-free-time"></i> 含自由活动4次 </li>
         </ul>
        </div>
       </div>
      </div>
      <div class="detail-instance-body">
       <span><span> <p align="center"> <b><span style="font-size:16px;"><img alt="" src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-04-22/35e01070-d752-4bee-b931-66f965a0bf7c.jpg" width="90%" /></span></b> </p> <h3> <span style="font-size:16.0pt;font-family:;"> <h3> <span style="font-size:16.0pt;font-family:;"> <h3> <span style="font-size:16.0pt;font-family:;"> <h3> <span style="font-size:16.0pt;font-family:;"> <h3> <span style="font-size:16.0pt;font-family:;"> <h3> </h3> </span> </h3> </span> </h3> </span> </h3> </span> </h3> </span> </h3>
         <div style="text-align:center;">
          <img alt="" src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-03-31/a517b5f9-d61a-4dbe-9a3f-5ddf051140aa.jpg" width="90%" />
         </div> </span> <p align="center"> <span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-03-31/4851b96a-5bf7-458c-a05c-59c386535867.jpg" width="90%" /> </span> </p> <p align="center"> <span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-03-31/6c389d90-eba9-411e-ba89-9728a2654fb5.jpg" width="90%" /> </span> </p> <p align="center"> <span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-03-31/69350bd9-2741-4be7-b876-2251b4220e1c.jpg" width="90%" /> </span> </p> <p align="center"> <span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-03-31/68083201-44dd-4599-9c24-d6b92c146e9d.jpg" width="90%" /> </span> </p> <p align="center"> <span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-03-31/3b61d9dd-12a0-488e-900c-713421103431.jpg" width="90%" /></span> </p> <p align="center"> <strong><span style="color:#FF6600;">赠饮金花茶（在红树林酒店内）</span></strong> </p> <p> <span style="font-family:SimSun;font-size:16px;color:#000000;"><strong><span style="color:#FF6600;"> </span></strong></span> </p> <p align="center"> <strong><span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-05-07/c0afad21-a283-4317-b6a5-a77da8e83b29.jpg" width="90%" /> </span></strong> </p> <p align="center"> <strong><span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-05-07/632c7280-e538-40f9-b3b1-b52c100d5051.jpg" width="90%" /> </span></strong> </p> <p align="center"> <strong><span style="font-family:SimSun;font-size:16px;color:#000000;"><img alt="" src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-05-07/ace290ea-4360-4aad-b03b-454c1c6dec63.jpg" width="90%" /></span> </strong> </p> <strong> <p> <br /> </p> <p> <br /> </p> <br /> </strong> <p> <br /> </p> <p> <br /> </p> <span></span></span>
      </div>  -->
     </div>
     <!-- 产品详情结束 -->
     <!-- 行程介绍开始 -->
     <div class="product-detail-instance" id="product-travel">
      <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-line-icon"></i>
       </div>
       <h3>行程介绍</h3>
      </div>
      <div class="instance_box">
       <div class="ncxc_popUp">
        <p class="ncxc_popTitle">发送行程至邮箱<a href="javascript:" class="ncxc_popClose"></a></p>
        <div class="ncxc_popContent">
         <span class="ncxc_emailText">邮箱：</span>
         <input type="text" class="ncxc_emailtext" id="ncemail" value="" />
         <a class="ncxc_emailBtn">发送</a>
         <p class="ncxc_errorTips"><span class="ncxc_tip-icon-error"></span>请输入正确的邮件地址</p>
        </div>
       <!--发送成功的提示-->
        <div class="ncxc_popSuccess" style="display: none;">
         <p class="ncxc_successTips"><span class="ncxc_tip-icon-big-success"></span>发送成功&nbsp;!</p>
         <p class="ncxc_popCheck">请登录您的邮箱查看行程</p>
        </div>
        <div class="ncxc_popError" style="display: none;">
         <p class="ncxc_popCheck" style="color:red; font-size:15px; margin-top:50px;"></p>
        </div>
       </div>
       <div class="ncxc_fade"></div>
       <!--循环执行行程Key（A行程、B行程、C行程...） TODO-->
       <div class="clearfix">
        <ul class="instance_tab fl">
         <li class="active" data-line="114693"> A行程 <i class="line_icon_gou"></i> </li>
        </ul>
        <a href="javascript:;" class="instance-xcBtn fr printRoute" target="blank" hidefocus="false" style="display:none;"> <span class="group_icon groupIcon_print"></span> 打印行程 </a>
       </div>
       <!--循环生成行程明细-->
       <!--线路详情页 行程介绍 之行程概要-->
       <ul class="instance_list">
       </ul>
       <!--交通和行程明细-->
       <div class="instance_list2_box">
        <div class="instance_list2" style="display: block;">
         <div class="detail-instance-body clearfix">
          <div class="travel-fixed">
           <ul id="J_scrollnav1">
           </ul>
          </div>
          <div class="travel-instance" id="travel-traffic-9537"></div>
          <!--行程明细-->
          <div class="instance-travel-xc-gb">
           <div class="instance-travel-xc-gb-border">
			
			</div>
           <!--行程提示-->
          </div>
         </div>
        </div>
       </div>
      </div>
     </div>
     <!-- 行程介绍结束 -->
     <!-- 产品地图开始 -->
     <div class="product-detail-instance" id="product-map">
      <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-map-icon"></i>
       </div>
       <h3>交通地图</h3>
      </div>
      <div class="detail-instance-body">
       <div class="line-baidu-map" id="line-baidu-map"></div>
      </div>
      <div class="detail-instance-body">
<!--        <div class="detail-desc-item">
        <div class="operate">
         公共交通
        </div>
        <div class="detail">
         <p> <span style="color:#FF6600;">亚龙湾（亚龙湾中心广场）</span><span style="color:#FF6600;">步行距离946米（约11分钟）</span> <span><br /> </span> </p>
         <p> <span style="color:#FF6600;">三亚凤凰国际机场</span><span style="color:#FF6600;"> 驾车距离34.5公里（约60分钟）</span> </p>
         <p> <span style="color:#FF6600;">三亚火车站</span><span style="color:#FF6600;"> 驾车距离22.6公里（约40分钟）</span> </p>
         <p> <span></span><span style="color:#FF6600;">市中心</span><span style="color:#FF6600;"> 驾车距离22.8公里（约40分钟）</span> </p>
         <span style="color:#FF6600;">亚龙湾希尔顿大酒店The Spa</span>
         <span style="color:#FF6600;">驾车距离2.0公里（约6分钟）</span>
         <br />
         <span style="color:#FF6600;">亚龙湾</span>
         <span style="color:#FF6600;">驾车距离1.4公里（约3分钟）</span>
         <br />
        </div>
       </div>  -->
      </div>
     </div>
     <!-- 产品地图结束 -->
     <!-- 费用说明开始 -->
     <div class="instance_list2_box" id="product-cost">
      <div class="instance_list2" style="display:block;">
       <div class="product-detail-instance">
        <div class="instance-title clearfix">
         <div class="title-icon-container">
          <i class="product-cost-icon"></i>
         </div>
         <h3>费用说明</h3>
        </div>
         <div class="detail-instance-body">
<!--         <div class="detail-desc-item">
          <div class="operate">
           费用包含
          </div>
          <div class="detail">
           【行】上海往返三亚机票经济舱（含税）
           <br />【住】亚龙湾红树林度假酒店4晚住宿
           <br />【食】每日赠送自助早餐及每房至多2位1.2米以下儿童早餐
           <br />【行】赠送三亚凤凰机场-酒店的拼车接机服务一次
           <br />【享】酒店私家沙滩、园林泳池、儿童乐园、免费wifi。
           <br />【赠】报“驴妈妈”＋预订人的名字可在红树林店内品尝金花茶（具体位置请咨询前台）
           <br />
           <br />特别提示：
           <br />师傅会在接机前的一天晚上9点-10点短信或者电话通知客人，请客人保持手机畅通，谢谢！
           <br />我司提供的拼车接机服务三亚湾、市区、大东海区域拼车接机服务时间为24小时，海棠湾、亚龙湾区域（万丽、梅诺卡等不提供拼车服务）拼车接机服务时间为08:00-24:00（航班抵达时间），不在服务时间内抵达航班需自行前往酒店，我司不提供接机。
          </div>
         </div>
         <div class="detail-desc-item">
          <div class="operate">
           费用不包含
          </div>
          <div class="detail">
           1、因交通延阻、罢工、天气、飞机机器故障、航班取消或更改时间等不可抗力原因所引致的额外费用。
           <br />2、酒店内洗衣、理发、电话、传真、收费电视、饮品、烟酒等个人消费。
           <br />3、当地参加的自费以及以上“费用包含”中不包含的其它项目。
           <br />4、保险：本产品不含旅游人身意外险,我们强烈建议游客购买。游客可在填写订单时勾选附加产品。
          </div>
         </div>-->
        </div>  
       </div>
      </div>
     </div>
     <!-- 费用说明结束 -->
     <!-- 小驴分期说明 -->
     <!-- 小驴分期开始 -->
     <div class="product-detail-instance" id="product-fenqi">
      <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-fq-icon"></i>
       </div>
       <h3>分期说明</h3>
      </div>
      <div class="detail-instance-body">
        <div class="detail-desc-item">
        <div class="detail">
          1.年龄20-60周岁（持有国内身份证的中国公民），无不良信用记录；
         <br /> 2.每笔订单出行人不超过6人（含6人），且贷款申请人必须在出行人之列;
         <br /> 3.贷款申请人需提供清晰的本人手持身份证的照片和身份证正面照片, 并提供可使用的银行卡借记卡（具体银行卡信息请见须知5）
         <br /> 4.申请额度最高支持5万;
         <br />5.支持借记卡：工商银行，农业银行，中国银行，建设银行，邮储银行，中信银行，光大银行，兴业银行，平安银行
         <br /> 6.支持申请区域：上海、浙江、北京、江苏、苏州、江西、重庆、四川、广东、贵州、云南、湖北、安徽、河北、河南、山东、内蒙古、深圳
         <br /> 7.2小时内审核订单，审核通过后，支付成功，如审核不通过，您需使用其他方式完成支付；审批时间为每日9:30-21:30。如果您在20:00后提交订单，可能延后到次日审批
         <br /> 8.申请成功并确认放款后，会自动绑定该借记卡作为今后的还款账户，每月对应日自动扣款。
         <br /> 9.贷款首次还款日为贷款支付后次月的对应日。例：客户2月14日贷款支付消费，首次扣款日为3月14日，之后为4月14日，5月14日……
         <br /> 10.先游玩，后付款活动只支持3期6期分期付款方式。9期12期分期付款方式不享受先游玩，后付款活动。9期12期分期付款方式的手续费按每月1%申请金额收取。
         <p class="mt40"><img src="http://s3.lvjs.com.cn/img/line/fenqi_process.png" width="863" height="158" /></p>
        </div>
       </div>
      </div>
     </div>
     <!-- 小驴分期结束 -->
     <!-- 预订须知开始 -->
     <div class="product-detail-instance" id="product-preorder-note">
      <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-notice-icon"></i>
       </div>
       <h3>预订须知</h3>
      </div>
      <div class="detail-instance-body preorder-notice">
       <!-- <div class="instance_list2_box" id="line_route_visa">
        <div class="instance_list2" style="display: block;">
        </div>
       </div>
       <div class="instance_list2_box" id="line_route_visa">
        <div class="instance_list2" style="display: block;">
        </div>
       </div>
       <div class="detail-desc-item">
        <div class="operate">
         出行警示及说明
        </div>
        <div class="detail">
         <p> 三亚亚龙湾红树林度假酒店 &nbsp;&nbsp;<br /> 地址：海南省三亚市亚龙湾国家旅游度假区<br /> 开业时间：2005年<br /> 电话：0898-88558888<br /> 宽带：免费宽带、免费wifi<br /> 入住时间：14:00以后 离店时间：12:00以前&nbsp;<br /> 提前增订成人早餐：196元/位/餐<br /> 增订儿童早餐（1.2-1.4米）：98元/位/餐<br /> 第三人入住（含单早）：450元/床/晚<br /> 房间面积：42平方米<br /> 床型尺寸：大床2&times;2m，双床1.35&times;2m </p>
         <p> </p>
         <p> <b><span style="font-family:宋体;">温馨提示：节假日期间早餐和加床价格会有变动，需以酒店公示为准。</span></b><b><span></span></b> </p>
         <br /> 特别提示：
         <br /> 我司提供的拼车接机服务三亚湾、市区、大东海区域拼车接机服务时间为24小时，海棠湾、亚龙湾区域拼车接机服务时间为08:00-24:00（航班抵达时间），不在服务时间内抵达航班需自行前往酒店，我司不提供接机。
         <br />
         <span style="font-size:12px;line-height:1.5;">自由行-行前须知</span>
         <p></p>
         <p> 1.为了不耽误您的行程，请您严格按照《出团通知书》要求，在航班起飞前规定时间到达机场集合并办理登机和出入境相关手续。出团通知书会在出发前1天给到客人。 </p>
         <p> 2.根据国家法律规定，为确保您的游程顺利，请随身携带并自行保管好您的有效身份证明（12岁以下儿童携带户口簿原件）。 </p>
         <p> 3.按国家规定，可以不占座位的儿童的标准为0.8米以下怀抱婴儿，0.8米以上儿童必须占座，否则，我社导游可依据《新交通法规》的有规定，为了保证车上其他游客的正常行程及生命安全，有权拒绝儿童参加本次旅游活动，由此产生的一切后果和损失由游客自负。 </p>
         <p> 自由行-预订须知 </p>
         <p> 1.单房差：报价是按照2人入住1间房计算的价格，如出现单男或单女情况，本公司将于出发前两天通知是否可以拼房或加床并支付附加费，如未能拼房，就需支付单人房附加费，享用单人房间。 </p>
         <p> 2.旅游者如是(60)岁以上（含(60)岁）人员出游的，本人需充分考虑自身健康状况能够完成本次旅游活动，谨慎出游，建议要有亲友陪同出游，如因旅游者自身身体原因引发疾病或其他损害由旅游者本人承担相关责任。未满18周岁的旅游者请由家属陪同旅游。因服务能力所限，不接受18周岁以下旅游者单独报名出游，敬请谅解。本产品网上报价适用持有大陆居民身份证的游客。如您持有其他国家或地区的护照，请电话现询价格，给您造成的不便，敬请谅解。 </p>
         <p> 3.游客必须保证自身身体健康良好的前提下，参加旅行社安排的旅游行程，不得欺骗隐瞒，若因游客身体不适而发生任何意外，旅行社不承担责任。 </p>
         <p> 自由行-游玩提示 </p>
         <p> 1.旅游者参加高原地区旅游或风险旅游项目（包括但不限于：游泳、浮潜、冲浪、漂流等水上活动以及骑马、攀岩、登山等高风险的活动）或患有不宜出行旅游的病情（包括但不限于：恶性肿瘤、心血管病、高血压、呼吸系统疾病、癫痫、怀孕、精神疾病、身体残疾、糖尿病、传染性疾病、慢性疾病健康受损），建议在报名前自行前往医疗机构体检或自行咨询医院专业医生意见，以确保自身身体条件能够完成本次旅游活动。 </p>
         <p> 2.如自身身体条件不适宜出游而参加旅游活动的，在行程中因自身身体条件引发的疾病或其他损害由旅游者本人承担相关责任；旅游者如系60岁以上（含60岁）人员出游的，本人需充分考虑自身健康状况能够完成本次旅游活动，谨慎出游，建议要有亲友陪同出游，如因旅游者自身身体原因引发疾病或其他损害由旅游者本人承担相关责任。 </p>
         <p> 3.上述内容作为乙方给予旅游者的重要出游安全提示，如旅游者仍坚持参加旅游活动，由此造成任何人身意外及不良后果将由旅游者本人承担全部责任。为了获得更为全面的保障，乙方强烈建议旅游者出游时根据个人意愿和需要自行投保人身意外伤害保险等个人险种。 </p>
         <p> 4.不可抗力是指不能预见、不能避免并不能克服的客观情况。不可抗力、意外事件等不可归责于旅行社的客观原因包括但不限于，恶劣天气、自然灾害、战争、罢工、骚乱、飞机故障、航班保护、恐怖事件、政府行为、公共卫生事件等客观原因，造成旅游行程安排的交通服务延误、景区临时关闭、宾馆饭店临时被征用、出境管制、边境关闭、目的地入境政策临时变更、我国政府机构发布橙色及以上旅游预警信息等，均会导致旅游目的无法实现，旅行社不承担违约责任。 </p>
         <p> 5.在自行安排活动期间，旅游者应在自己能够控制风险的范围内活动，旅游者应选择自己能够控制风险的活动项目，并对自己的安全负责。 </p>
         <p> 6.旅游期间或自行安排活动期间请注意人身和财产安全。旅游者因违约、自身过错、自行安排活动期间内的行为或自身疾病引起的人身、财产损失由其自行承担；由此给旅行社或其他服务提供方造成损失的，旅游者应当承担赔偿责任。为了获得更为全面的保障，乙方强烈建议旅游者出游时根据个人意愿和需要自行投保人身意外伤害保险等个人险种。 </p>
         <p> <br /> </p>
        </div>
       </div>
       <div class="detail-desc-item">
        <div class="operate">
         退改说明
        </div>
        <div class="detail">
         <p> </p>
         <p> <span style="font-family:宋体;">订单支付成功后，如需进行修改或取消订单提前致电</span><span>10106060</span><span style="font-family:宋体;">转</span><span>1</span><span style="font-family:宋体;">号键后转</span><span>5</span><span style="font-family:宋体;">号键。</span><span></span> </p>
         <p> <span>1.</span><span style="font-family:宋体;">旅游者不能出行，应至少提前</span><span>7</span><span style="font-family:宋体;">天通知取消，并承担旅行社预订实际损失费。</span><span></span> </p>
         <p> <span>2.</span><span style="font-family:宋体;">上述违约金不足以弥补我司或相关旅行社已办理的护照成本手续费、订房损失费、签证及服务费、国际国内交通费用等业务损失时，游客应当承担赔偿责任。</span><span></span> </p>
         <p> <span>3.</span><span style="font-family:宋体;">游客转让：出行前，在符合办理团队签证或签注期限或其他条件许可情况下，旅游者可以向组团社书面提出将其自身在本合同中的权利和义务转让给符合出游条件的第三人；并且由第三人与组团社重新签订合同；因此增加的费用由旅游者或第三人承担，减少的费用由组团社退还旅游者。</span><span></span> </p>
         <p></p>
         <p> <br /> </p>
         <p> <br /> </p>
        </div>
       </div> -->
      </div>
     </div>
     <!-- 预订须知结束 -->
     <!-- 国内,出境线路推荐开始 -->
     <div class="product-detail-instance" id="product-recommend" productid="${basicInfo.productId!''}" 
     <#if basicInfo.defDeparture>
     	districtid="${basicInfo.defDeparture.departureCityDistrictId!''}"
     </#if>
     <#if basicInfo.additionalInfoDto && basicInfo.additionalInfoDto.destinations>
     	destname="${basicInfo.additionalInfoDto.destinations[0].destName!''}"
     </#if>></div>   
     <!-- 国内,出境线路推荐结束 -->
     <!-- 签证开始 -->
     <div class="instance_list2_box" id="product-visa">
      <div class="instance_list2" style="display: block;">
      </div>
     </div>
     <!-- 签证结束 -->
     <!-- 用户点评开始 -->
     <div class="product-detail-instance xl_position_r" id="product-customer-review">
      <a href="http://www.lvmama.com/zt/promo/chunjie6/" class="xl_comments_enter3" target="_blank"><img src="http://s1.lvjs.com.cn/img/v5/comments_enter3.png" width="196" height="105" /></a>
      <div class="instance-title clearfix">
       <div class="title-icon-container">
        <i class="product-review-icon"></i>
       </div>
       <h3>驴友点评</h3>
      </div>
      <div class="comwrap">
       <!-- 点评信息概况 -->
       <div class="new-cominfo">
        <div class="comstati clearfix">
         <div class="com-count">
          <i class="percentum f60" data-mark="dynamicNum" data-level=""></i>
          <span class="f60">%</span>
          <em>好评率</em>
          <em>来自<a class="f60">40</a>位驴友的真实点评</em>
         </div>
         <ul class="clearfix">
          <li> <span class="comcount"><em>景点</em>（4.7）</span> <span class="comlevel"> <i data-level="4.7" data-mark="dynamicNum" style="width: 94.6%;"></i> </span> </li>
          <li> <span class="comcount"><em>酒店</em>（4.7）</span> <span class="comlevel"> <i data-level="4.7" data-mark="dynamicNum" style="width: 94%;"></i> </span> </li>
          <li> <span class="comcount"><em>服务</em>（4.8）</span> <span class="comlevel"> <i data-level="4.8" data-mark="dynamicNum" style="width: 95%;"></i> </span> </li>
          <li> <span class="comcount"><em>交通</em>（4.6）</span> <span class="comlevel"> <i data-level="4.6" data-mark="dynamicNum" style="width: 92%;"></i> </span> </li>
         </ul>
         <div class="com-btns">
          <a class="nlogin" href="javascript:;">有订单，写体验点评返奖金</a>
         </div>
        </div>
        <!-- //com-btns -->
       </div>
       <div class="comheatd">
        <ul class="comheatd-ul JS_com-tabnav">
         <li class="active"><a href="javascript:;" hidefocus="false" id="allCmt">全部点评<span>(40)</span></a></li>
         <li><a href="javascript:;" hidefocus="false" id="bestCmt">精华点评<span>(5)</span></a></li>
         <li><a href="javascript:;" hidefocus="false" id="picCmt">晒旅图点评<span>(21)</span></a></li>
         <li class=""><a href="javascript:;" hidefocus="false" id="refCmt">相关点评<span>(87)</span></a></li>
        </ul>
       </div>
       <!-- //comhead -->
       <div class="JS_com-content">
        <!-- 点评 -->
        <div class="comment-list com-all" style="display:none" id="allCmtComment">
         <div class="comment-li">
          <div class="ufeed-info">
           <span class="fr tagsback tagsback-orange" tip-title="写体验点评送积分" tip-content="预订此产品，游玩后发表体验点评，内容通过审核，即可获得积分。"><em>送</em><i>250分</i></span>
           <span class="fr tagsback tagsback-orange" tip-title="写体验点评返现金" tip-content="预订此产品，游玩后发表体验点评，内容通过审核，即可获得&lt;span&gt;104&lt;/span&gt;元点评奖金返现。"><em>点评</em><i>104元</i></span>
           <p class="ufeed-score"> <span class="tags tags-red">精华</span> <span class="ufeed-level"><i data-level="5" data-mark="" style="width: 100%;"></i></span> <span class="ufeed-item"> <em>景点&nbsp;</em> <i>5 (推荐) </i> </span> <span class="ufeed-item"> <em>酒店&nbsp;</em> <i>5 (推荐) </i> </span> <span class="ufeed-item"> <em>服务&nbsp;</em> <i>5 (推荐) </i> </span> <span class="ufeed-item"> <em>交通&nbsp;</em> <i>4 (满意) </i> </span> <span class="ufeed-tag">体验</span> </p>
          </div>
          <!-- //ufeed-info -->
          <div class="ufeed-content">
           <!-- 展开时加showmore --> 【点评有奖第9季】超级愉快的一次
           <a id="xmy" href="http://dujia.lvmama.com/tour/sanya272">三亚</a>行，一直都很信赖驴妈妈，虽然之前看酒店评论没有那么佳有点心慌慌，不过这几天的游玩下来完全没有不愉快，非常赞的一次体验。 独有的私家海滩，海浪一波波的真的很刺激，玩的停不下来，真想再多玩两天！ 若大的游泳池，每天都有好多小朋友来这里戏水，真的是很适合亲子的一家酒店，每天和老公两个人都会乘着太阳下山的时候来狗刨两下，Hohoho～ 酒店是在亚龙湾度假区，附近还有七八家度假酒店，周边有一个百花谷商业区，七八分钟的路程，吃的挺多的，价格也高低不一，我基本都是团购的套餐，时鲜都比较贵。提一下这里的超市价格和机场差不多，只差几毛钱，坑人。要买特产的朋友还是去外面买比较好。这里的水果价格也没有多便宜，可能也是度假区的原因，水果是挺甜的，可是很多熟过头了！ 顺便说一下这边的吃的，我们叫了好几顿外卖，首推的就是红帽子，豪华外卖有木有，赞赞赞，大爱芒果螺！ 最好提一下酒店的服务，基本都是有求必应，前台的态度蛮好的，但是各个游乐设施的服务员态度就有待加强了，可能人去的多了也就没办法热情了，一个城市一旦形成了旅游商业模式，当地人对于游客的热情也会大大减退，希望
           <a id="xmy" href="http://www.lvmama.com/lvyou/d-sanya272.html">三亚</a>能多一份单纯，多一份热情！ 五天四夜几乎都是在酒店里度过的，也不会觉得闷，纯度假模式，有机会还要来
           <a id="xmy" href="http://ticket.lvmama.com/a-sanya272">三亚</a>！
           <span class="JS_showmore ufeed-showmore">查看全部<i class="iconcom iconcom-more"></i></span>
          </div>
          <!-- 点评图片展示 -->
          <!-- 大图结构 -->
          <div class="compic-big">
           <a class="l" title="上一张" href="javascript:;"></a>
           <a class="r" title="下一张" href="javascript:;"></a>
           <p></p>
          </div>
          <div class="compic-scoll">
           <span class="compic-bigbtn fl"><i class="iconcom iconcom-scollleft"></i></span>
           <div class="compic-small fl">
            <!-- //compic-scollbox -->
            <ul>
             <li data-src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-05-12/4dac6735-61d1-4bda-9fc6-867f49ab3389_480_320.jpg"><img src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-05-12/4dac6735-61d1-4bda-9fc6-867f49ab3389_180_120.jpg" alt="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】" /></li>
             <li data-src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-05-12/673dad30-9f8d-46d9-a5b4-8b2f185ac090_480_320.jpg"><img src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-05-12/673dad30-9f8d-46d9-a5b4-8b2f185ac090_180_120.jpg" alt="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】" /></li>
             <li data-src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-05-12/eba9b573-201e-4bd3-8698-da49e257cabc_480_320.jpg"><img src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-05-12/eba9b573-201e-4bd3-8698-da49e257cabc_180_120.jpg" alt="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】" /></li>
             <li data-src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-05-12/0f093cbd-ddc5-4e66-a993-34f9e570c22c_480_320.jpg"><img src="http://s3.lvjs.com.cn/uploads/pc/place2/2016-05-12/0f093cbd-ddc5-4e66-a993-34f9e570c22c_180_120.jpg" alt="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】" /></li>
             <li data-src="http://s1.lvjs.com.cn/uploads/pc/place2/2016-05-12/a84648bc-713c-4c22-903d-5ca800eb73a6_480_320.jpg"><img src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-05-12/a84648bc-713c-4c22-903d-5ca800eb73a6_180_120.jpg" alt="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】" /></li>
            </ul>
           </div>
           <a href="javascript:;" class="JS_close copic-bigup">收起<i class="iconcom iconcom-bigup"></i></a>
           <span class="compic-bigbtn fr"><i class="iconcom iconcom-scollright"></i></span>
          </div>
          <!-- 用户信息 -->
          <div class="com-userinfo">
           <a href="javascript:;" class="JS_reply fr com-dcom"><i class="iconcom iconcom-dcom"></i>回复<em>0</em></a>
           <a href="javascript:Comment.addUsefulCount('1','2566110','');" class="fr com-enjoy" id="userfulCount__2566110"><i class="iconcom iconcom-enjoy"></i>有用<em>1</em></a>
           <p> <a href="javascript:;" title="lv135****9951">lv135****9951</a> 对 “ <a class="com-proTit" href="javascript:;" title="三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】 9C8779-9C8780   上海虹桥往返三亚（T）+(豪华海景房)豪华海景房+全面型+拼车接机一人次 成人票">三亚亚龙湾红树林度假酒店双飞5天4晚自由行【亚龙湾知名亲子酒店 一线海景 巴厘岛热带风情 含早餐 享别致园林 泳池及私家沙滩 赠接机＋品尝金花茶】 9C8779-9C8780 上海虹桥往返三亚（T）+(豪华海景房)豪华海景房+全面型+拼车接机一人次 成人票</a> ” 发表点评 <em>2016-05-12</em> <a class="com-user-app" href="javascript:;"> <i class="iconcom iconcom-mobile"></i> <span class="com-msg">该点评来源驴妈妈APP端</span> </a> </p>
          </div>
          <!-- 点评回复 -->
          <div class="com-answer combd clearfix ">
           <!-- //如果下面有回复则加 open否则不加 -->
           <i class="iconcom iconcom-boxdir"></i>
           <div class="com-answer-form">
            <form action="">
             <a data-cid="2566110" data-ctype="" data-reply="0" class="com-answer-submit radio5 fr" href="javascript:;">回复</a>
             <input class="com-answerinput" type="text" />
            </form>
           </div>
           <ul class="com-answer-li">
           </ul>
          </div>
          <!-- //com-answer -->
         </div>
         <div class="paging orangestyle">
          <div class="pagebox">
           <span class="prevpage"><i class="larr"></i></span>
           <span class="pagesel" onclick="javascript:Comment.newLoadPaginationOfComment({type:'all',currentPage:1,totalCount:'40',placeId:'',productId:'578809',placeIdType:'',isPicture:'',isBest:'',isPOI:'Y',isELong:'N'});">1</span>
           <a href="javascript:Comment.newLoadPaginationOfComment({type:'all',currentPage:2,totalCount:'40',placeId:'',productId:'578809',placeIdType:'',isPicture:'',isBest:'',isPOI:'Y',isELong:'N'});" hidefocus="false">2</a>
           <a href="javascript:Comment.newLoadPaginationOfComment({type:'all',currentPage:3,totalCount:'40',placeId:'',productId:'578809',placeIdType:'',isPicture:'',isBest:'',isPOI:'Y',isELong:'N'});" hidefocus="false">3</a>
           <a href="javascript:Comment.newLoadPaginationOfComment({type:'all',currentPage:4,totalCount:'40',placeId:'',productId:'578809',placeIdType:'',isPicture:'',isBest:'',isPOI:'Y',isELong:'N'});" hidefocus="false">4</a>
           <a href="javascript:Comment.newLoadPaginationOfComment({type:'all',currentPage:2,totalCount:'40',placeId:'',productId:'578809',placeIdType:'',isPicture:'',isBest:'',isPOI:'Y',isELong:'N'});" class="nextpage" hidefocus="false"> <i class="rarr"></i></a>
          </div>
         </div>
        </div>
        <!-- //comment-list -->
        <!-- 精华 -->
        <div class="comment-list" id="bestCmtComment">
        </div>
        <!-- //comment-list -->
        <!-- 晒旅图点评 -->
        <div class="comment-list" id="picCmtComment">
        </div>
        <!--相关点评-->
        <!--相关点评子tab-->
        <div class="comment-list" id="refCmtComment">
         <div class="relevant_com-tips">
          <img src="http://s1.lvjs.com.cn/img/v6/comment/relevant_com.png" width="496" height="64" alt="小驴为您准备与该产品相关的真实点评，希望能够帮助到您哟！" />
          <ul class="relevant_com-xg">
           <li class="" id="cmt_ref_lines" onclick="refCmtLine(0)">相关线路</li>
           <li id="cmt_ref_views" onclick="refCmtLine(1)" class="">相关景点</li>
           <li id="cmt_ref_hotels" onclick="refCmtLine(2)" class="">相关酒店</li>
          </ul>
         </div>
         <!-- //relevant_com-tips -->
        </div>
       </div>
      </div>
     </div>
     <script>
    window.cmtRef =  {};
    window.cmtRef.allCount = 87;
    window.cmtRef.lineCount = 0;
    window.cmtRef.lineProductIds = '';
    window.cmtRef.viewProductIds = '229142';
    window.cmtRef.viewCount = 0;
    window.cmtRef.hotelCount = 87;
    window.cmtRef.hotelProductIds = '412969';
    window.cmtRef.hotelComments = "";
    window.cmtRef.viewComments = "";
    window.cmtRef.lineComments = "";

    <!--同步加载相关点评 -->
    function asynLoadRef(isClick) {

        var allCommentCount = 40;
        var refAllCount = 87 ;
        if (refAllCount > 0) {
            var totalCount = 0;
            var productRef = "";
            var refType = 0;
            if (window.cmtRef.hotelCount > 0) {
                totalCount = window.cmtRef.hotelCount;
                productRef = window.cmtRef.hotelProductIds;
                refType = 2;
            }
            if (window.cmtRef.viewCount > 0) {
                totalCount = window.cmtRef.viewCount;
                productRef = window.cmtRef.viewProductIds;
                refType = 1;
            }
            if (window.cmtRef.lineCount > 0) {
                totalCount = window.cmtRef.lineCount;
                productRef = window.cmtRef.lineProductIds;
                refType = 0;
            }
            //productRef不为空时调用--------
            if (totalCount > 0 && productRef != '') {
                $.ajax({
                    url: "${request.contextPath}/serverProxy",
                    type: "post",
                    cache : false,
					async : false,
                    data: {

                    requestStr:"http://dujia.lvmama.com/vst_front/comment/newPaginationOfComments?currentPage=1&type=ref&totalCount="+totalCount+
                	"&productRef="+productRef+"&isPOI=N&isRef="+refType

                    },
                    dataType: 'html',
                    success: function (data) {

                        $("#refCmtComment").html(data);
                        if (allCommentCount <= 0) {//无点评则暂时相关点评tab数据
                            $("#refCmtComment").show();
                        }

                        setPageCacheComments(refType, data);

                    }
                });

            }

        }
    }

    function refInit() {
        var allCommentCount = 40;
        if (allCommentCount <= 0) {//当全部点评为空的时候 才初始化相关点评第一页数据
            asynLoadRef();
        }
    }

    refInit();

    $("#refCmt").bind("click",function(){
        var count = $("#refCmtComment").find(".comment-li").length;
        if(count <= 0){
            asynLoadRef();
        }
    });

    /**
     * 点击相关相关点评子tab 切换数据  ljl
     */
    function refCmtLine(refType) {
        var totalCount = window.cmtRef.lineCount;
        var productRef = window.cmtRef.lineProductIds;
        var vstType = '';
        var returnComments = "";
        if (refType == 2) {
            totalCount = window.cmtRef.hotelCount;
            productRef = window.cmtRef.hotelProductIds;
            returnComments = window.cmtRef.hotelComments;

        } else if (refType == 1) {
            totalCount = window.cmtRef.viewCount;
            productRef = window.cmtRef.viewProductIds;
            returnComments = window.cmtRef.viewComments;

        } else if (refType == 0) {
            totalCount = window.cmtRef.lineCount;
            productRef = window.cmtRef.lineProductIds;
            returnComments = window.cmtRef.lineComments;

        }
        //productRef不为空时调用--------
        if (returnComments == "") {

            $.ajax({
                url: "${request.contextPath}/serverProxy",
                cache : false,
				async : false,
                type: "POST",
                data: {
                requestStr:"http://dujia.lvmama.com/vst_front/comment/newPaginationOfComments?currentPage=1&type=ref&totalCount="+totalCount+
                "&isPOI=N&productRef="+productRef+"&vstType="+vstType+"&isRef="+refType
                },
                dataType: 'html',
                success: function (data) {
                    $("#refCmtComment").html(data);
                    setPageCacheComments(refType, data);
                    //clickReply();
                }
            });
        } else {
            $("#refCmtComment").html(returnComments);
        }

    }

    /**
     * 页面缓存第一页相关点评
     */
    function setPageCacheComments(refType,returnComments){
        if(refType == 2){
            window.cmtRef.hotelComments = returnComments;
        }else if(refType == 1){
            window.cmtRef.viewComments = returnComments;
        }else if(refType == 0){
            window.cmtRef.lineComments = returnComments;

        }

    }
	<!--统计点击驴友点评访问量-->
	$("[data-flag='product-customer-review']").bind("click",function(){
		cmCreateElementTag("自由行_驴友点评","驴友点评点击");
	});
	<!--统计点击相关游记访问量-->
	$("[data-flag='product-customer-trip']").bind("click",function(){
		cmCreateElementTag("自由行_相关游记","相关游记点击");
	});
    <!--点评部分-->
    $("#allCmt").bind("click",function(){
        var count = $("#allCmtComment").find(".comment-li").length;
        if(count <= 0){
        	var totalCount = $("#allCmt span").text().replace("(","").replace(")","");
            Comment.newLoadPaginationOfComment({type:"all",currentPage:1,totalCount:totalCount,productId:$("#productId").val(),isPOI:"Y",isELong:"N"});
        }
    });

    $("#bestCmt").bind("click",function(){
        var count = $("#bestCmtComment").find(".comment-li").length;
        if(count <= 0){
        	var totalCount = $("#bestCmt span").text().replace("(","").replace(")","");
            Comment.newLoadPaginationOfComment({type:"best",currentPage:1,totalCount:totalCount,productId:$("#productId").val(),isBest:"Y",isPOI:"Y",isELong:"N"});
        }
    });

    $("#picCmt").bind("click",function(){
        var count = $("#picCmtComment").find(".comment-li").length;
        if(count <= 0){
        	var totalCount = $("#picCmt span").text().replace("(","").replace(")","");
            Comment.newLoadPaginationOfComment({type:"pic",currentPage:1,totalCount:totalCount,productId:$("#productId").val(),isPicture:"Y",isPOI:"Y",isELong:"N"});
        }
    });

    /**
     *相关点评翻页
     * @param type          点评类别
     * @param currentPage   当前页
     * @param totalCount    总数
     * @param placeId       POI
     * @param productId     产品ID
     * @param placeIdType   POI类型
     * @param isPicture     晒图
     * @param isBest        精华
     * @param isPOI         是不是POI
     * @param isELong       是不是艺龙点评
     * @param productRef    相关点评产品id串,逗号分隔
     * @param vstType       产品品类
     * @param isRef         相关点评类型
     */
    function newLoadPaginationOfCommentRef(type,currentPage,totalCount,placeId,productId,placeIdType,isPicture,isBest,isPOI,isELong,productRef,vstType,isRef){
        $.ajax({
            url: "/comment/newPaginationOfComments",
            type: "post",
            data: {
                currentPage:currentPage,
                totalCount:totalCount,
                type:type,
                placeId: placeId,
                productId: productId,
                placeIdType:placeIdType,
                isPicture:isPicture,
                isBest:isBest,
                isPOI:isPOI,
                isELong:isELong,
                productRef:productRef,
                vstType:vstType,
                isRef:isRef

            },
            dataType: 'html',
            success: function(data) {
                $("#"+type+"CmtComment").html(data);
                $(window).scrollTop($('#product-customer-review').offset().top);
            }
        });
    }
</script>
     <!-- 用户点评结束 -->
     <!-- 游记开始 -->
     <input type="hidden" id="elite" />
     <input type="hidden" id="destId" value="10032030,100172,272,267" />
     <input type="hidden" id="_travel_cCode" value="category_route_freedom" />
     <div id="product-customer-trip" class="product-detail-instance dbox tripBox">
      <!-- 相关游记开始 -->
      <div class="dtitle">
       <p class="dtit"><i class="dp_icon dicon-trip"></i>相关游记</p>
       <a class="trip-propaganda" href="http://www.lvmama.com/trip/zt/i/hui100" target="_blank">一写就惠——写订单游记，超值返现100元！</a>
       <a target="_blank" href="http://www.lvmama.com/public/help_center_555" class="trip-ask fr"> <span class="dp_icon dicon-tripAsk"></span>活动说明 </a>
       <a target="_blank" href="http://www.lvmama.com/trip/start" class="trip-link fr">发游记赚钱啦!</a>
      </div>
      <!-- 游记内容开始 -->
      <div class="tripContent">
       <div class="tripTab">
        <span class="active" id="allTabTrip">全部</span>|
        <span id="bestTabTrip">精华</span>
       </div>
       <ul class="trip-list">
        <div class="tripListBox">
         <!-- 如果没有点评则显示commentNull -->
         <div class="commentNull">
          <span class="icon dicon-comLv"></span> 本产品暂无相关游记，如果您去过，那就写篇关于这里的游记吧，更重要的是它还能帮你赚钱哦！
         </div>
         <!-- //commentNull -->
        </div>
       </ul>
      </div>
     </div>
     <script src="http://s3.lvjs.com.cn/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/new_v/top/header-air_new.js"></script>
     <script type="text/javascript">
	var dataArray = [];//本地存储数据
	/* $(document).ready(function(){
		getTravelCount();
	}); */

	//初始化数据
	function init(){
		//直接加载层对应数据(加载缓存数据)
		ajaxData(1);//全部
		var index = getIndex();
		dataArray[index] = $(".tripListBox").html();
		ajaxData(1, 1);//精华
	}

	function getTravelCount(){
	var categoryCode  = $("#_travel_cCode").val()!='' ? $("#_travel_cCode").val() : "";
	var dest_id= $("#destId").val()
	var destArray =[]
		var url = "http://www.lvmama.com/trip/ajax/multi_trance?dest_id="+dest_id+"&page=1&size=1&category_code="+categoryCode;
		$.ajax({
            url: url,
            dataType: 'JSONP',
            type: "GET",
            success: function(data) {
           if(data.code == 200){
            	var  total=data.data.total;
            	if(total>0){
	            	$('#navigate-list').find('li:last').show();
	            	$("#travelCount").html("("+total+")");
            		init();
					addLoscHref();
            	}else{
            	    //alert("没有相关游戏的内容!");
            		$('#navigate-list').find('li:last').hide();
            	}
	         }
	        },
	        error:function(data){
	        	console.log("error:"+data);
	        }
    	});
	}

	//全部事件
	$("#allTabTrip").bind("click",function(){
		$("#elite").val("");//全部
		refresh();
	});

	//精华事件
	$("#bestTabTrip").bind("click",function(){
		$("#elite").val(1);//精华
		refresh();
	});

	/**
	*游记部分(分页)
	*@param currentPage 页数
	*/
	function loadPaginationOfTrips(currentPage){
		ajaxData(currentPage, null, function(data){
			$(".tripListBox").html(data);
		});
	}
	/**
	*Ajax请求数据
	*@param elite 全部/精华
	*@param callFn 回调函数
	*/
	function ajaxData(currentPage, elite, callFn){
		var categoryCode  = $("#_travel_cCode").val()!='' ? $("#_travel_cCode").val() : "";
		$.ajax({
	         url: "${request.contextPath}/serverProxy",
	         type : "get",
	         cache : false,
			 async : false,
	         data: {
	        	 requestStr:"http://dujia.lvmama.com/vst_front/trip/destPaginationOfTrip?"+
	        	 "currentPage="+currentPage+"&destId="+$("#destId").val()+"&elite="+getElite(elite)+
	        	 "&categoryCode="+categoryCode
	         },
	         dataType: 'html',
	         success: function(data) {
	        	 var index = getIndex(elite);
	        	 dataArray[index] = data;
	        	 if(data){
	        		 refresh();
	        	 	//$(".tripListBox").html("");
					//$(".tripListBox").html(dataArray[index]);
	        	 }

	        	 if(callFn) callFn(data);
	         },
	         error:function(res){
	        	 console.info("ajaxData failure【"+ res.status +"】");
	         }
	    });

	}

	//刷新div内容
	function refresh(){
		var index = getIndex();
		$(".tripListBox").html("");
		$(".tripListBox").html(dataArray[index]);
	}

	/**
	*根据elite获取div选项索引
	*/
	function getIndex(elite){//直接加载层对应数据
		var elite = getElite(elite);
		if(!elite) return 0;//默认显示全部层
		return elite;
	}
	function getElite(elite){
		if(!elite) return $("#elite").val();
		return elite;
	}

	function addLoscHref(){

		var jz_tic_losc = '';
		var categoryId = '18';
		//var packType = 'LVMAMA';
		if(categoryId == 18){
			jz_tic_losc = '?losc=056659&ict=i';
		}else if(categoryId == 17){// && packType=='LVMAMA'
			jz_tic_losc = '?losc=056661&ict=i';
		}else if(categoryId == 15){//packType=='SUPPLIER'
			 jz_tic_losc = '?losc=056662&ict=i';
		}else if(categoryId == 16){
			 jz_tic_losc = '?losc=162285&ict=i';
		}/* else if(categoryId == 11){
			 jz_tic_losc = '?losc=058172&ict=i';
		} */
		if(jz_tic_losc!=''){
			$('.trip-listPic').each(function(){
				var herf = $(this).attr('href');
				var anchor = $(this).attr('data');
			    $(this).attr('href',herf+jz_tic_losc+ "#p" +anchor);
			});
			$('.trip-list_info_content').each(function(){
				var herf = $(this).attr('href');
				var anchor = $(this).attr('data');
			    $(this).attr('href',herf+ jz_tic_losc+ "#p" +anchor);
			});
		}

	}
</script>
     <!-- 游记结束 -->
    </div>
    <div class="booking-way">
     <div class="booking-way-title">
      <div class="booking-way-title-bg"></div>
      <h3>预订方式</h3>
     </div>
     <ul>
      <li class="booking-way-choice"> <i></i> <em>选择产品</em> <p>挑选您喜爱的产品并选择出行日期、人数等预订信息</p> </li>
      <li class="booking-way-arrow"></li>
      <li class="booking-way-write"> <i></i> <em>填写订单</em> <p>核对选购的产品，选择可选优惠，并填写游玩人信息</p> </li>
      <li class="booking-way-arrow"></li>
      <li class="booking-way-confirm"> <i></i> <em>订单确认</em> <p>确认订单内容，客服将与您保持联系，确保游客利益</p> </li>
      <li class="booking-way-arrow"></li>
      <li class="booking-way-pay"> <i></i> <em>支付订单</em> <p>选择适合您的付款方式，轻松进入下一步付款</p> </li>
      <li class="booking-way-arrow"></li>
      <li class="booking-way-happy"> <i></i> <em>快乐旅程</em> <p>24小时全年客服，解决您旅途问题，一同开启快乐旅程</p> </li>
      <li class="booking-way-arrow"></li>
      <li class="booking-way-travel"> <i></i> <em>写点评、游记赚零花</em> <p>撰写游记或点评产品，赚取您下一次旅程的旅游基金</p> </li>
     </ul>
    </div>
    <!--推荐模块2---开始-->
    <div class="common_box pro_box1" id="scenic_recommendation">
     <h3 class="common_tit1">景点推荐</h3>
     <ul class="pro_list2">
      <li> <a href="http://ticket.lvmama.com/scenic-158950" target="_blank"> <img src="http://s3.lvjs.com.cn/uploads/pc/place2/2015-06-18/24b031bb-2989-454a-a378-33f8587a8690.jpg" width="211" height="141" /> <h5>三亚千古情景区</h5> </a> <p><span class="pro_comment"><samp> 97.5 </samp>% 好评率</span> <span class="pro_price1"><dfn>￥</dfn>120</span>起</p> </li>
      <li> <a href="http://ticket.lvmama.com/scenic-101548" target="_blank"> <img src="http://s1.lvjs.com.cn/uploads/pc/place2/2015-06-15/9fdd8d10-c220-48e8-ba5e-6c51ad1a8eaa.jpg" width="211" height="141" /> <h5>蜈支洲岛</h5> </a> <p><span class="pro_comment"><samp> 95.5 </samp>% 好评率</span> <span class="pro_price1"><dfn>￥</dfn>110</span>起</p> </li>
      <li> <a href="http://ticket.lvmama.com/scenic-153217" target="_blank"> <img src="http://s2.lvjs.com.cn/uploads/pc/place2/2016-01-14/49a52119-fee4-4a22-a54d-a1d3f2453a4a.jpg" width="211" height="141" /> <h5>亚龙湾热带天堂森林公园</h5> </a> <p><span class="pro_comment"><samp> 94.7 </samp>% 好评率</span> <span class="pro_price1"><dfn>￥</dfn>135</span>起</p> </li>
      <li> <a href="http://ticket.lvmama.com/scenic-100530" target="_blank"> <img src="http://s3.lvjs.com.cn/uploads/pc/place2/2015-12-24/c69e7465-934d-4e13-a17c-0b558512fa75.jpg" width="211" height="141" /> <h5>南山寺</h5> </a> <p><span class="pro_comment"><samp> 95 </samp>% 好评率</span> <span class="pro_price1"><dfn>￥</dfn>110</span>起</p> </li>
     </ul>
    </div>
    <!--推荐模块2---结束-->
   </div>
   <!-- 1354 行 -->
  </div>
  <!--弹出航班信息-->
  <table class="plane_type_box">
   <tbody>
    <tr>
     <th>计划机型</th>
     <th>机型名称</th>
     <th>类型</th>
     <th>最少座位数</th>
     <th>最多座位数</th>
    </tr>
    <tr></tr>
   </tbody>
  </table>
  <script src="http://s1.lvjs.com.cn/js/v6/public/footer.js"></script>
  <script src="http://s2.lvjs.com.cn/min/index.php?f=/js/common/poplogin.js&amp;version=051209"></script>
   <!-- <div class="app-ar-thumb">
    <i></i> 手
    <br /> 机
    <br /> 扫
    <br /> 码
    <br /> 更
    <br /> 优
    <br /> 惠
   </div>
   <div class="app-qr-code">
    <img src="http://dujia.lvmama.com/group/showLineQr/578809" alt="" />
   </div>
   <em>◆</em>
   <b>◆</b>
  </div>  -->
  <!-- Footer文件开始 -->
  <script>

    window.lineDetail = {};
        </script>
  <script src="http://s1.lvjs.com.cn/min/index.php?f=/js/bower_components/jquery/jquery.min.js,/js/bower_components/jquery.actual/jquery.actual.min.js,/js/bower_components/underscore/underscore.js,/js/bower_components/backbone/backbone.js,/js/bower_components/marionette/lib/backbone.marionette.min.js,/js/bower_components/moment/min/moment.min.js,/js/bower_components/PikaChoose/lib/jquery.jcarousel.min.js,/js/bower_components/PikaChoose/lib/jquery.pikachoose.js,/js/bower_components/PikaChoose/lib/jquery.touchwipe.min.js&amp;version=122906"></script>
  <script src="http://s2.lvjs.com.cn/min/index.php?f=/js/ui/lvmamaUI/lvmamaUI.js,/js/v6/public/searchComplete.js,/js/v6/header_new.js,/js/v5/modules/pandora-poptip.js,/js/v6/modules/imgScroll1.js,/js/v5/modules/pandora-select.js,/js/v5/modules/pandora-dialog.js,/js/common/losc.js,/js/v6/comment/new_comment.js,/js/v6/public/common_box.js&amp;version=122906"></script>
  <script src="http://s3.lvjs.com.cn/min/index.php?f=/js/line/config.js,/js/line/util.js,/js/line/calendar.js"></script>
  <script src="${request.contextPath}/js/comm/comment.js?verson=201508111234"></script>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
  <script src="http://s1.lvjs.com.cn/min/index.php?f=/js/v5/ibm/eluminate.js,/js/v5/ibm/coremetrics-initalize.js&amp;version=122906"></script>
  <script src="http://s2.lvjs.com.cn/min/index.php?f=/js/v6/modules/calendar-detail.js"></script>
  <script src="http://dujia.lvmama.com/vst_front/js/localAndOutBU/linedetail.js?verson=201601281640"></script>
  <script type="text/javascript" src="http://s3.lvjs.com.cn/js/v6/public/promotion-module.js"></script>
  <script>

    var publicCallBack = {};
    window.onload = function() {
        //初始化打印行程链接
    	//var routeId = $(".instance_tab").find(".active").attr("data-line");
        //printRouteParam(routeId);
    }
    //设置打印行程链接   ljl 5.19
    function printRouteParam(routeId,packagedProductId){
    	var url = "http://dujia.lvmama.com/local/localAndOutBu/routePrint.do?startDistrictId=&routeId="+routeId+"&productId=";
    	if(packagedProductId!==undefined && packagedProductId!==null && $.trim(packagedProductId)!=="" && $.trim(packagedProductId)!=="0"){
    		url += packagedProductId;
    	}else{
    		url += $("#productId").val();
    	}
    	if(routeId!='' && routeId!='undefined'){
	    	$(".printRoute").attr("href",url);
    	}else{
    		$(".printRoute").attr("href","javascript:;");
    	}
    }
    //行程日期,显示更多
    function Showmore(e) {
        var $_this = $(this),
        p = $_this.parent('dd').find('p:nth-child(n+' + e.data.i + ')');
        if ($_this.hasClass('open')) {
            p.hide();
            $_this.removeClass('open').html('展开<span></span>');
        } else {
            p.show();
            $_this.addClass('open').html('收起<span></span>');
        }
    }

	//根据产品id去后台得到进入详情页时显示产品推荐调用得到目的地信息与推荐的产品  ljl 5.17
    function loadProdAssociationRecommend(productId,districtId,mainProductdistrictName){
    	var inData = {"productId":productId};
    	if(districtId && typeof(districtId) != "undefined" &&  districtId!='' ){
    		inData.districtId = districtId;
    	}
    	if(mainProductdistrictName && typeof(mainProductdistrictName) != "undefined" &&  mainProductdistrictName!='' ){
    		inData.mainProductdistrictName = mainProductdistrictName;
    	}
		$.ajax({
			url : "${request.contextPath}/serverProxy",//local为nginx的跳转路径，会自动跳到/vst_front/route/下
			type : "get",
			cache : false,
			async : false,
			dataType: 'html',
			data : {
				requestStr:"http://dujia.lvmama.com/local/localAndOutBu/getProdAssociationRecommend.do?"+
				"productId="+productId+(inData.districtId!=undefined?"&districtId="+inData.districtId:"")+
				(inData.mainProductdistrictName!=undefined?"&mainProductdistrictName="+inData.mainProductdistrictName:"")
			},
			success : function(result) {
					$("#product-recommend").html(result);
					$("#product-recommend").attr("productid",productId).attr("districtid",districtId);
					//addLosc($("#product-recommend"),$(".product-content").attr("data_id"));
					$("#product-recommend .product-line-tab p em").html("出发地："+mainProductdistrictName);
					productRecommendEvent();
			}
		});
	}

	</script>

  <!-- Footer文件结束 -->
  <script src="http://s3.lvjs.com.cn/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js,/js/v5/ibm/eluminate.js&amp;version=051209"></script>
  <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
  <script src="http://s1.lvjs.com.cn/js/v6/modules/pandora-calendar.js"></script>
  <script src="http://s2.lvjs.com.cn/js/v5/modules/pandora-poptip.js"></script>
  <script src="${request.contextPath}/js/liner/secenicDialog.js?verson=201601111234"></script>
  <!--酒店和景点弹窗代码-->
  <!-- 景点酒店弹窗 -->
  <div class="yin-dialog-overlay"></div>
  <div class="yin-dialog">
   <a href="javascript:;" class="ph_icon ph_icon ph_icon_close_dialog pa"></a>
   <div class="yin-dialog-basic">
    <div class="yin-dialog-slider">
     <ul class="slider-pic-box">
      <li> <img src="http://s3.lvjs.com.cn/img/cmt/img_480_320.png" alt="" width="460" height="308" /> </li>
     </ul>
    </div>
   </div>
   <div class="yin-dialog-comments">
    <p class="yin-dialog-comments-title">驴友点评</p>
    <ul class="yin-dialog-comments-content">
     <li>暂无点评</li>
    </ul>
   </div>
   <p class="yin-dialog-loading-content">驴妈妈拼命加载中，请稍候...</p>
  </div>
  <iframe name="getHtmlFrame" id="getHtmlFrame" src="${request.contextPath}/searchProductBottomDescInfo.do?productId=${productId}&bizCategoryId=${basicInfo.bizCategoryId}" style="display:none;"></iframe>

  <!--打包组js代码  ljl 05.19-->
  <script type="text/javascript">
	function setDynamicParmFromFrame(productId){
		$("#productId").val(productId);
	}

   function setProductDetail(value){
      $("#product-detail").html(value);
   }
   function setProductTravelHotelCombo(xc_day){
		$("#product-travel .instance_box>div.clearfix").css("display","none");
		$(".instance_list").css("display","none");
		$("#product-travel .instance_list2").html(xc_day);
	   
		//重新给行程每一天的 li添加锚点点击事件
	   	$("#J_scrollnav1>li").click(function(e) {
	   		var data = {
	   	            obj: this,
	   	            thisName: 'active',
	   	            runName: $(this).parent(),
	   	            difference: $(this).parent().outerHeight(),
	   	            triggerNum: 0,
	   	            runTime: 0,
	   	            maxTrigger: true,
	   	            trigger: function() {}
	   	        };
	    	  var navThis = this,
	    	    index = $(this).index();
	    	    arrT = [];
	    	    var Li = $("#J_scrollnav1").find("li");
	    	    for (var i = 0; i < Li.length; i++) {
	    	        var thisId = Li.eq(i).attr('date_id');
	    	        if ($('#' + thisId).length == 1) {
	    	            var T = $('#' + thisId).offset().top - data.difference;
	    	        } else {
	    	            var T = 9999999;
	    	        }
	    	        arrT.push(T);
	    	    }
	    	    $('body,html').animate({
	    	        'scrollTop': arrT[index] + 1
	    	    },
	    	    data.runTime,
	    	    function() {
	    	        setTimeout(function() {
	    	            $(navThis).addClass(data.thisName).siblings().removeClass(data.thisName);
	    	        },
	    	        50)
	    	    });
	      });
   }
   function setProductTravel(tripType,instance_list,J_scrollnav1,xc_detail,travel_days,traffic_type,packagedProductId){
   	if(tripType!=null){
      	$("#product-travel .instance_box>div.clearfix").html(tripType);
      	$("#product-travel .instance_box>div.clearfix a").css("display","none");
      	//初始化打印行程链接
    	var routeId = $(".instance_tab").find(".active").attr("data-line");
        printRouteParam(routeId,packagedProductId);
        
        //行程tab
        $(".instance_tab li").bind("click",function(){
            var lineRouteId = $(this).attr("data-line");
            printRouteParam(lineRouteId,packagedProductId);
            yudingStop();
            $(".noresult").hide();
        });
        
      }else{$("#product-travel .instance_box>div.clearfix").css("display","none");}
      if(instance_list!=null){
      $("#product-travel .instance_list").html(instance_list);
      }else{$("#product-travel .instance_list").css("display","none");}
      $("#product-travel .instance_list2_box .travel-fixed #J_scrollnav1").html(J_scrollnav1);
      if(traffic_type!=null){
    	  $("#product-travel .instance_list2_box div.travel-instance").replaceWith(traffic_type);
      }
      $("#product-travel .instance_list2_box .instance-travel-xc-gb").html(xc_detail);
      if(xc_detail==null && travel_days!=null){
	  	$("#product-travel .instance_list2_box .detail-instance-body").append(travel_days);
	  	$("#product-travel .instance_list2_box .detail-instance-body .travel-days .travel-instance").css("width","840px");
	  }
		//重新给行程每一天的 li添加锚点点击事件
      $(".travel-fixed-item").click(function(e) {
          var $current = $(e.currentTarget);
          var navBarHeight=$("#product-detail-header").height();
          var flag = $current.data("flag");
          var destination = $("#" + flag)[0].offsetTop;
          $(window).scrollTop(destination - navBarHeight);
          $(".travel-fixed-item").each(function() {
              $(this).removeClass("active");
          });
          $current.addClass("active");
      });

       //调取所有景点模板第一张图片展示
 		getAllScenicFirstPage();

 		$('.JS_travelTime').on('click', {i: 3},Showmore);

   }
   	function setProductMap(value,coordinateJson){
   		$("#product-map").html(value);
   		var jsonArray = [{"address":"三亚市凤凰路155号（与三亚河东路交叉口）","coordId":50408,"coordType":"BAIDU","destType":"HOTEL","latitude":18.293144,"longitude":109.49656,"objectId":10001420,"objectType":"BIZ_DEST","searchKey":"三亚湾红树林度假世界（木棉酒店）"},{"address":"海南省三亚市亚龙湾国家旅游度假区(百花谷购物中心对面)","coordId":81001,"coordType":"BAIDU","destType":"HOTEL","latitude":18.235123,"longitude":109.645276,"objectId":10032030,"objectType":"BIZ_DEST","searchKey":"三亚亚龙湾红树林度假酒店"},{"address":"三亚市","coordId":40561,"coordType":"BAIDU","destType":"CITY","latitude":18.257776,"longitude":109.522771,"objectId":272,"objectType":"BIZ_DEST","searchKey":"三亚 三亚"},{"address":"海南省","coordId":736207,"coordType":"BAIDU","destType":"PROVINCE","latitude":20.025669,"longitude":110.355167,"objectId":267,"objectType":"BIZ_DEST","searchKey":"海南"}];
		if(coordinateJson!== undefined && coordinateJson!=null){
			jsonArray = coordinateJson;
		}
   		if(jsonArray == null || jsonArray == undefined || jsonArray.length < 1){
	   		$("#line-baidu-map").css("display","none");
		}else{
			lvmap({
            	type: jsonArray[0].coordType.toLowerCase(),//地图类型,支持google, baidu. 默认google
            	marker: true,//是否显示地图标记. 默认不显示
            	coordinate: { lng: jsonArray[0].longitude, lat: jsonArray[0].latitude },//地图中心点的经度(lng)和纬度(lat)
            	zoom: 15,//缩放等级. 默认15,即街道级别. 数值越大,可视区域越小,地标显示越清晰
           		containerID: "line-baidu-map",//地图容器的ID
            	markerTips: { title: jsonArray[0].searchKey, content: jsonArray[0].address, maxWidth: 150, maxHeight: 100 }
            	//地图标记信息: marker为true且content有值时显示. 默认不显示. 支持自定义提示框宽高.
        	});
		}
   	}
	function setProductCost(product_cost,feiyong_all){
		if(feiyong_all!=undefined && feiyong_all!=null){
			$("#product-cost .detail-instance-body").html(feiyong_all);
		}else{
			$("#product-cost").html(product_cost);
		}
   	}
   	function setProductFenqi(value){
      $("#product-fenqi").html(value);
   	}
	function setPreorderNote(value){
      $("#product-preorder-note").html(value);
   	}
   	function setProductRecommend(value){
      $("#product-recommend").replaceWith(value);
      productRecommendEvent();
   	}
   	function setProductRoutRecommend(){
   	 	var productId = $("#product-recommend").attr("productid");
   	 	var districtId = $("#product-recommend").attr("districtid");
   	 	var mainProductdistrictName = "${basicInfo.defDeparture.departureCityName!''}";
      loadProdAssociationRecommend(productId,districtId,mainProductdistrictName);
   	}
   	function setCustomerReview(totalCmt,new_cominfo,allCmtComment,allCmt,bestCmt,picCmt,refCmt){
	  $("#totalCmt").html(totalCmt);
      $("#product-customer-review .comwrap .new-cominfo").html(new_cominfo);//点评好评率部分
      if(allCmtComment!=null){
      	$("#product-customer-review .comwrap .JS_com-content #allCmtComment").html(allCmtComment).css("display","block");
      }else{
      	$("#product-customer-review .comwrap .JS_com-content #allCmtComment").css("display","none");
      }
      if(allCmt!=null){
      $("#product-customer-review .comwrap .comheatd .comheatd-ul li #allCmt").html(allCmt);
      }else{
      	$("#product-customer-review .comwrap .comheatd .comheatd-ul li #allCmt").parent("li").css("display","none");}
      if(bestCmt!=null){
      	$("#product-customer-review .comwrap .comheatd .comheatd-ul li #bestCmt").html(bestCmt);
      }else{$("#product-customer-review .comwrap .comheatd .comheatd-ul li #bestCmt").parent("li").css("display","none");}
      if(picCmt!=null){
      	$("#product-customer-review .comwrap .comheatd .comheatd-ul li #picCmt").html(picCmt);
      }else{$("#product-customer-review .comwrap .comheatd .comheatd-ul li #picCmt").parent("li").css("display","none");}
      if(refCmt!=null){
      	$("#product-customer-review .comwrap .comheatd .comheatd-ul li #refCmt").html(refCmt);
      }else{$("#product-customer-review .comwrap .comheatd .comheatd-ul li #refCmt").parent("li").css("display","none");}
  	  if(allCmt==null && bestCmt==null && picCmt==null && refCmt==null){
  		  $("#product-customer-review .comwrap .comheatd").css("display","none");
  	  }
   	}
   	function setCustomerTrip(tripListAll,destId,travel_cCode){
      //$("#product-customer-trip").html(value);
      $("#product-customer-trip .tripContent .tripListBox .tripListAll").html(tripListAll);
      $("#destId").val(destId);
      $("#_travel_cCode").val(travel_cCode);
      getTravelCount();
   	}

</script>
  <script type="text/javascript">
  </script>

<!-- 国内,出境线路推荐JS ljl 5.20 -->
<script type="text/javascript">
function productRecommendEvent() {
    var $productTab = $('.product-line-tab li');//各目的地
	var $titleTab = $('.title-tab li');//线路推荐与已浏览信息
	var productId = $('#product-recommend').attr("productId");//产品id

	/*
	*点击相应目的地拉出相应推荐产品
	*/
	$productTab.click(function(){
		$productnum = $(this).index();
		$(this).addClass('active').siblings().removeClass('active');
		$(this).parent().siblings('.product-line-list').eq($productnum).show().siblings('.product-line-list').hide();
	});

	/*
	*点击线路推荐与已浏览信息拉出相应推荐产品
	*/
	$titleTab.click(function(){
		$titlenum = $(this).index();
		$(this).addClass('active').siblings().removeClass('active');
		$(this).parent().parent().siblings('.product-content').eq($titlenum).show().siblings('.product-content').hide();
	});

	/*
	*鼠标移到产品与移出产品的效果
	*/
	$('.product-line-list li').hover(function(){
			$(this).find('.product-line-bg').show();
		},function(){
			$(this).find('.product-line-bg').hide();
	});
	/*
	*浏览记录
	*/
	$('#historyContentTab').click(function(){
		var productId = $('#product-recommend').attr("productId");//产品id
		var districtId = $('#product-recommend').attr("districtId");//出发地id
		var destName = $('#product-recommend').attr("destName");//目的地名称
		var historyContentDiv = document.getElementById("historyContent");

		if(historyContentDiv){
		}else{
			$.ajax({
				url : "${request.contextPath}/serverProxy",//local为nginx的跳转路径，会自动跳到/vst_front/route/下
				type : "get",
				cache : false,
				async : false,
		        dataType: 'html',
		        data : {
		        	requestStr:"http://dujia.lvmama.com/local/localAndOutBu/getCookieProduct.do?"+
		        	"productId1="+productId+"&districtId="+districtId+"&destName="+destName},
		        success: function (result){
		       		$("#product-recommend").append(result);
		        	$("#historyContent").siblings('.product-content').hide();
		        	$("#historyContent").show();
		        }
		    });
		}
	});
}
</script>
