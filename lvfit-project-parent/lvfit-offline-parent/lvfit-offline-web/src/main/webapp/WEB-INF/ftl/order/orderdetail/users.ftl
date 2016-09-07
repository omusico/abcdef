<div class="module3">
	<div class="bdinfor"> <!-- 乘客信息开始 -->
	<div class="">
		<b>游客信息</b>
	</div>
	<table width="100%">
		<tr class="title">
			<th width="6%">乘客类型</th>
			<th width="8%">中文姓名</th>
			<!-- <th width="8%">英文姓</th>
			<th width="8%">英文姓</th>
			 -->
			<th width="6%">证件类型</th>
			<th width="8%">证件号码</th>
			<!-- <th width="8%">签发地</th>
			<th width="8%">有效期</th>
			 -->
			<th width="10%">出生日期</th>
			<th width="6%">人群</th>
			<!-- <th width="6%">性别</th> -->
			<th width="6%">联系电话</th>
			<!-- <th width="6%">邮箱地址</th>
			<th width="6%">关联的商品</th> -->
		</tr>
		<#if base.fitOrderPassengers ??>
		<#list base.fitOrderPassengers as passer>
		<tr>
			<td >游客</td>
			<td>${passer.passengerName !''}</td>
			<!-- <td>&nbsp;</td>
			<td>&nbsp;</td>
			 -->
			<td>
				<#list IDCardTypeEnum as val> 
			    <#if val !="NULL" && val == passer.passengerIDCardType>
			       ${val.cnName}
			    </#if>
				</#list>
			</td>
			<td>${passer.passengerIDCardNo !'' }<!-- 证件号码 --></td>
			<!-- <td>&nbsp;</td>
			<td>&nbsp;</td>
			 -->
			<td>${passer.passengerBirthday !'' }<!-- 出生日期 --></td>
			<td><!-- 人群 -->
				<#list passengerTypeEnum as val> 
			    <#if val !="NULL" && val == passer.passengerType>
			       ${val.cnName}
			    </#if>
				</#list>
			</td>
			<!--<td>&nbsp; 性别</td>-->
			<td>${passer.mobile !'' }<!-- 联系电话 --></td>
			<!-- <td>&nbsp; 邮箱地址</td>
			<td>&nbsp;关联的商品 </td>-->
		</tr>
		</#list>
		</#if>
	</table>
	</div> <!-- end 乘客信息 -->
	
	<div class="bdinfor"> <!-- start 购买人信息 -->
	<div class="">
		<b>购买人信息</b>
	</div>
	<table width="100%">
		<tr class="title">
			<th>联系人</th>
			<th>联系电话</th>
			<th>邮箱地址</th>
		</tr>
		<tr>
			<td >${base.fitOrderContacter.name }</td>
			<td >${base.fitOrderContacter.mobile }</td>
			<td >${base.fitOrderContacter.email }</td>
		</tr>
	</table>
	</div> <!-- end 购买人信息 -->
</div>