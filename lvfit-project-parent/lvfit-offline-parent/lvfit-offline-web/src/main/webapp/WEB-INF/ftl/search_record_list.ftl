<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${request.contextPath}/css/fitOpLog_list.css" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jqGrid/css/ui.jqgrid.css"/>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/area_tankuang.css">
</head>
<body>
    <div class="content content1">
    <div class="breadnav"><span>首页</span> > 搜索记录列表</div>
    <form id="myForm" autocomplete="off">
        <div class="infor1">
            <div class="visitor message">
                <div class="main">
                    <div class="part">
                        <label>出发城市：</label>
                        <input type="text" id="departureCityCode" name="departureCityCode" mod="address|notice" mod_address_source="hotel" mod_address_reference="getcityid" placeholder="中文/拼音" />
                        <label>到达城市：</label>
                        <input type="text" id="arrivalCityCode" name="arrivalCityCode" mod="address|notice" mod_address_source="hotel" mod_address_reference="getcityid" placeholder="中文/拼音" />
                        <label>去程时间：</label>
                        <input type="text" id="departureDate" name="departureDate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                        <label>返程时间：</label>
                        <input type="text" id="returnDate" name="returnDate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                    </div>
                    <div class="part">
                        <label>入住城市：</label>
                        <input type="text" id="stayCityCode" name="stayCityCode" mod="address|notice" mod_address_source="hotel" mod_address_reference="getcityid" placeholder="中文/拼音" />
                        <label>入住时间：</label>
                        <input type="text" id="checkInDate" name="checkInDate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                        <label>离店时间：</label>
                        <input type="text" id="checkOutDate" name="checkOutDate" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                        <label>IP：</label>
                        <input type="text" id="ip" name="ip" />
                    </div>
                    <div class="part">
                        <label>查询时间段：</label>
                        <input type="text" id="selectTimeStart" name="selectTimeStart" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                         -
                        <input type="text" id="selectTimeEnd" name="selectTimeEnd" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                        <label>查询结果：</label>
                        <select name="resultStatus" id="resultStatus">
                            <option value="">全部</option>
                            <#list resultStatusEnum as val>
                            <option value="${val}">${val}</option>
                        </#list>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="click">
            <button id="queryBtn" type="button">查询</button>
            <button id="resetBtn" type="button">清空</button>
            <button id="exportCsvBtn" type="button">导出CSV</button>
        </div>
    </form>
    
    <div class="content1" style="margin-top:50px;">
        <table id="opLogList"></table>
            <div id="pager"></div>
        </div>
    </div>

    <div id="jsContainer" class="jsContainer" style="height:0">
        <div id="tuna_alert" style="display:none;position:absolute;z-index:999;overflow:hidden;"></div>
        <div id="tuna_jmpinfo" style="visibility:hidden;position:absolute;z-index:120;"></div>
    </div>

    <script src="${request.contextPath}/js/fixdiv.js"></script>
    <script src="${request.contextPath}/js/address.js"></script>

    <script src="${request.contextPath}/js/resources/jqGrid/js/jquery-1.7.2.min.js"> </script>
    <script src="${request.contextPath}/js/resources/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="${request.contextPath}/js/resources/jqGrid/src/i18n/grid.locale-cn.js"></script>
    <script src="${request.contextPath}/js/resources/jqGrid/js/jquery.jqGrid.src.js"></script>
    <script src="${request.contextPath}/js/moment.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/My97DatePicker/WdatePicker.js"></script> 
    <script type="text/javascript">
        $(function (){
            // 查询时间段默认值初始化
            initDate();
            // 表格初始化
            $("#opLogList").jqGrid({
                url : "${request.contextPath}/fitSearchRecord/query",
                datatype : "json",
                mtype : "POST",
                postData : queryParam(),
                colNames : ['indexId','traceId','出发城市','到达城市','去程时间','返程时间','入住城市','入住时间','离店时间','成人数','儿童数','查询结果','错误信息','耗费时间','查询时间','IP地址'],
                colModel : [{
                    name : 'indexId',
                    index : 'indexId',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'traceId',
                    index : 'traceId',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'departureCityCode',
                    index : 'departureCityCode',
                    align : 'center',
                    width : 80,
                    sortable:false
                }, {
                    name : 'arrivalCityCode',
                    index : 'arrivalCityCode',
                    align : 'center',
                    width : 80,
                    sortable:false
                }, {
                    name : 'departureDate',
                    index : 'departureDate',
                    align : 'center',
                    width : 100,
                    sortable:false
                }, {
                    name : 'returnDate',
                    index : 'returnDate',
                    align : 'center',
                    width : 100,
                    sortable:false
                }, {
                    name : 'stayCityCode',
                    index : 'stayCityCode',
                    align : 'center',
                    width : 80,
                    sortable:false
                }, {
                    name : 'checkInDate',
                    index : 'checkInDate',
                    align : 'center',
                    width : 100,
                    sortable:false
                }, {
                    name : 'checkOutDate',
                    index : 'checkOutDate',
                    align : 'center',
                    width : 100,
                    sortable:false
                }, {
                    name : 'adultCount',
                    index : 'adultCount',
                    align : 'center',
                    width : 50,
                    sortable:false
                }, {
                    name : 'childrenCount',
                    index : 'childrenCount',
                    align : 'center',
                    width : 50,
                    sortable:false
                }, {
                    name : 'resultStatus',
                    index : 'resultStatus',
                    align : 'center',
                    width : 80,
                    sortable:false
                }, {
                    name : 'errMsg',
                    index : 'errMsg',
                    align : 'center',
                    formatter: remarkFmatter,
                    sortable:false
                }, {
                    name : 'usedTime',
                    index : 'usedTime',
                    align : 'center',
                    width : 90,
                    sortable:false
                }, {
                    name : 'queryTime',
                    index : 'queryTime',
                    align : 'center',
                    width : 200,
                    sortable:false
                }, {
                    name : 'ip',
                    index : 'ip',
                    align : 'center',
                    width : 200,
                    sortable:false
                }],
                rowNum:10,            //每页显示记录数
                autowidth: true,      //自动匹配宽度
                shrinkToFit:false,
                height: 'auto',
                sortable: true,
                sortname: 'queryTime',
                sortorder: 'desc',
                pager: '#pager',      //表格数据关联的分页条，html元素
                rowList:[10,20,50,500],   //分页选项，可以下拉选择每页显示记录数
                viewrecords: true,    //显示总记录数
                multiselect : false,
                caption : "搜索记录列表",
                jsonReader : {
                    root : "results",               // json中代表实际模型数据的入口  
                    page : "pagination.page",       // json中代表当前页码的数据   
                    records : "pagination.records", // json中代表数据行总数的数据   
                    total:'pagination.total',       // json中代表页码总数的数据 
                    repeatitems : false             // 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。   
                },
                onPaging : function(pgButton) {
                    $("#opLogList").jqGrid('setGridParam', {
                        postData : queryParam()
                    });
                }
            });
        });

        var initDate = function() {
            var defStartDateTime = moment().format("YYYY-MM-DD 00:00:00");
            var defEndDateTime = moment().format("YYYY-MM-DD 23:59:59")
            $("#selectTimeStart").val(defStartDateTime);
            $("#selectTimeEnd").val(defEndDateTime);
        }
        
        var remarkFmatter = function(cellvalue, options, rowdata) {
            if (cellvalue === "" || cellvalue === null) {
                return "";
            }
            return cellvalue.replace(/[\r\n]/g, "")
        }

        var queryParam = function() {
            return {
                'departureCityCode': getCityCode($("#departureCityCode").val()),
                'arrivalCityCode': getCityCode($("#arrivalCityCode").val()),
                'departureDate': $("#departureDate").val(),
                'returnDate': $("#returnDate").val(),
                'stayCityCode': getCityCode($("#stayCityCode").val()),
                'checkInDate': $("#checkInDate").val(),
                'checkOutDate': $("#checkOutDate").val(),
                'selectTimeStart': $("#selectTimeStart").val(),
                'selectTimeEnd': $("#selectTimeEnd").val(),
                'resultStatus': $("#resultStatus").val(),
                'ip': $("#ip").val()
            }
        }

        var getCityCode = function(value) {
            if($.trim(value).length > 0) {
                var startIndex = value.indexOf('(') + 1;
                var endIndex = value.indexOf(')');
                value = value.substring(startIndex, endIndex);
            }
            return value;
        }

        //查询列表信息   
        $("#queryBtn").click(function(event) {
            $("#opLogList").jqGrid('setGridParam', {
                url : "${request.contextPath}/fitSearchRecord/query",
                datatype : "json",
                mtype : "POST",
                postData : queryParam()
            }).trigger("reloadGrid");
        });
        
        //清空查询信息   
        $("#resetBtn").click(function(event) {
            $("#myForm")[0].reset();
            $("#opLogList").jqGrid('setGridParam', {
                url : "${request.contextPath}/fitSearchRecord/query",
                datatype : "json",
                mtype : "POST",
                postData : queryParam()
            }).trigger("reloadGrid");
        });

        $("#exportCsvBtn").click(function() {
            $("#myForm").attr("action", "${request.contextPath}/fitSearchRecord/exportCsv").submit();
        });

    </script>
</body>
</html>