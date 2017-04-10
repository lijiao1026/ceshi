<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<%@ taglib uri="/WEB-INF/dataformate.tld" prefix="datefmt"%>
<!DOCTYPE html>
<head>

	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/xcConfirm.css" rel="stylesheet" type="text/css">
</head>

<div class="modal-header">
	<button type="button" class="close" data-toggle="modal" data-dismiss="modal" id="modalColse">
		x
		<!-- 防止页面被覆盖为黑色 -->
	</button>
	<h3 class="modal-title">查看</h3>
	

		<div class="modal-body">
		<div class="col-md-12"  id="firstIn">
		<table class="table table-bordered table-striped">
				<tr>
				<th width="30%">预约编号</th>
				<td width="70%">	
				<s:property value="appointment.appointmentSerial" />
					 </td>			
			</tr>
			<tr>
				<th width="30%">患者姓名</th>
				<td width="70%"><s:property value="appointment.userId.name" />  </td>			
			</tr>
			<tr>
				<th width="30%">患者年龄</th>
				<td width="70%"><s:property value="appointment.userId.age" />  </td>			
			</tr>
			<tr>
				<th width="30%">患者性别</th>
				<td width="70%">
				<s:if test="appointment.userId.sex==0">男</s:if>
				<s:if test="appointment.userId.sex==1">女</s:if> </td>			
			</tr>
			<tr>
				<th width="30%">患者手机号码</th>
				<td width="70%"><s:property value="appointment.userId.telPhone" />  </td>			
			</tr>
			<tr>
				<th width="30%">家庭地址</th>
				<td width="70%"><s:property value="appointment.userId.address" />  </td>			
			</tr>
			<tr>
				<th width="30%">科室名称</th>
				<td width="70%"><s:property value="appointment.departmentId.departmentName" />  </td>			
			</tr>
			<tr>
				<th width="30%">科室地址</th>
				<td width="70%"><s:property value="appointment.departmentId.departmentAddress" />  </td>			
			</tr>
			<tr>
				<th width="30%">创建时间</th>
				<td width="70%"><datefmt:writeString formatStr="yyyy-MM-dd HH:mm:ss" property="${appointment.appointmentTime}">
                       </datefmt:writeString>  </td>			
			</tr>
			<tr>
				<th width="30%">预约状态</th>
				<td width="70%">	
					<s:if test="appointment.appointmentStatus==0">已预约</s:if>
					<s:if test="appointment.appointmentStatus==1">已完成</s:if>
					<s:if test="appointment.appointmentStatus==2">已过期</s:if> </td>			
			</tr>
			
			<tr>
				<th width="30%">备注</th>
				<td width="70%"><s:property value="appointment.remark" />  </td>			
			</tr>
		</table>
	</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn" data-dismiss="modal">退出</button>
		
		</div>
	</div>
		

</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript">

$('#modal').modal('show');
$('#modal').on('hidden.bs.modal', function (e) {
			queryList();
	})
</script>