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
				<th>用户名</th>
				<td><s:property value="user.userName" />  </td>			
			</tr>
			<tr>
				<th>密码</th>
				<td><s:property value="user.password" />  </td>			
			</tr><tr>
				<th>姓名</th>
				<td><s:property value="user.name" />  </td>			
			</tr><tr>
				<th>年龄</th>
				<td><s:property value="user.age" />  </td>			
			</tr>
			<tr>
				<th>性别</th>
				<td>
				<s:if test="user.sex==0">男</s:if>
				<s:if test="user.sex==1">女</s:if>
				 </td>			
			</tr>
				<tr>
				<th>出生日期</th>
				<td><datefmt:writeString formatStr="yyyy-MM-dd" property="${user.birthDay}">
                       </datefmt:writeString>  </td>			
			</tr>
			<tr>
				<th>手机号码</th>
				<td><s:property value="user.telPhone" />  </td>			
			</tr>
			<tr>
				<th>家庭地址</th>
				<td><s:property value="user.address" />  </td>			
			</tr>
			<tr>
				<th>科室名称</th>
				<td><s:property value="user.department.departmentName" />  </td>			
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


</script>