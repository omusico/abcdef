<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>

<body>
  
<!-- 公共头部开始    -->
<#if getSuperCommonHeader ??>
	<#if isNew>
    	${getSuperCommonHeader('company',true,'${provinceId}','${cityId}','${stationName}','index')}
    <#else>
    	${getSuperCommonHeader()}
    </#if>
</#if>

</body>



</html>
