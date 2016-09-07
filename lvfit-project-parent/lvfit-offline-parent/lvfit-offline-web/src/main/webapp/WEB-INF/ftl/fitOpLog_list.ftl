<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${request.contextPath}/css/fitOpLog_list.css" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>
    <link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jqGrid/css/ui.jqgrid.css"/>
</head>
<body>
    <div class="content content1">
    <div class="breadnav"><span>首页</span> > 操作日志列表</div>
    <form id="myForm" autocomplete="off">
        <div class="infor1">
            <div class="visitor message">
                <div class="main">
                    <div class="part">
                        <label>TraceId：</label>
                        <input type="text" id="traceId" name="traceId" />
                        
                        <label>业务类型：</label>
                        <select name="fitBusinessType" id="fitBusinessExceptionType">
                            <option value="">全部</option>
                            <#list fitBusinessTypeEnum as val>
                                <option value="${val}">${val.cnName}</option>
                            </#list> 
                        </select>
                        
                        <label>查询时间段：</label>
                        <input type="text" id="selectTimeStart" name="selectTimeStart" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                         -
                        <input type="text" id="selectTimeEnd" name="selectTimeEnd" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                    </div>
                </div>
            </div>
        </div>
        <div class="click">
            <button id="queryBtn">查询</button>
            <button id="resetBtn">清空</button>
        </div>
    </form>
    
    <div class="content1" style="margin-top:50px;">
        <table id="opLogList"></table>
            <div id="pager"></div>
        </div>
    </div>

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
            $("#opLogList").jqGrid({
                url : "${request.contextPath}/fitOpLog/query",
                datatype : "json",
                mtype : "POST",
                postData : queryParam(),
                colNames : ['操作时间','TraceId','业务类型','详细信息','备注','请求参数'],
                colModel : [{
                    name : 'createTime',
                    index : 'createTime',
                    formatter: dateFmatter,
                    align : 'center',
                    sortable:false
                }, {
                    name : 'traceId',
                    index : 'traceId',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'fitBusinessExceptionType',
                    index : 'fitBusinessExceptionType',
                    align : 'center',
                    sortable:false
                }, {
                    name : 'detail',
                    index : 'detail',
                    formatter: remarkFmatter,
                    align : 'center',
                    sortable:false
                }, {
                    name : 'remark',
                    index : 'remark',
                    formatter: remarkFmatter,
                    align : 'center',
                    sortable:false
                }, {
                    name : 'requestStr',
                    index : 'requestStr',
                    formatter: reqFmatter,
                    height: 200,
                    align : 'center',
                    sortable:false
                }],
                rowNum:10,            //每页显示记录数
                autowidth: true,      //自动匹配宽度
                height: 'auto',
                pager: '#pager',      //表格数据关联的分页条，html元素
                rowList:[10,20,50,500],   //分页选项，可以下拉选择每页显示记录数
                viewrecords: true,    //显示总记录数
                multiselect : false,
                caption : "操作日志列表",
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

         var reqFmatter = function(cellvalue, options, rowdata) {
            if (cellvalue === "" || cellvalue === null) {
                return "";
            }
            return new Option(cellvalue).innerHTML;
        }

        var dateFmatter = function(cellvalue, options, rowdata) {
            if (cellvalue === "" || cellvalue === null) {
                return "";
            }
            var date = new Date(cellvalue);
            return moment(date).format("YYYY-MM-DD HH:mm:ss");
        }

        var queryParam = function() {
            return {
                'traceId': $("#traceId").val(),
                'fitBusinessExceptionType': $("#fitBusinessExceptionType").val(),
                'selectTimeStart': $("#selectTimeStart").val(),
                'selectTimeEnd': $("#selectTimeEnd").val()
            }
        }

        //查询列表信息   
        $("#queryBtn").click(function(event) {
            event.preventDefault();
            $("#opLogList").jqGrid('setGridParam', {
                url : "${request.contextPath}/fitOpLog/query",
                datatype : "json",
                mtype : "POST",
                postData : queryParam()
            }).trigger("reloadGrid");
        });
        
        //清空查询信息   
        $("#resetBtn").click(function(event) {
            $("#myForm").reset();
        });

    </script>
</body>
</html>