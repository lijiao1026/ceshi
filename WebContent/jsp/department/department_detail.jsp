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
				<th>科室类别</th>
				<td>
				<s:if test="department.departmentType==0">内科</s:if>
				<s:if test="department.departmentType==1">外科</s:if>
				<s:if test="department.departmentType==2">妇产科</s:if>
				<s:if test="department.departmentType==3">生殖中心</s:if>
				<s:if test="department.departmentType==4">儿科</s:if>
				<s:if test="department.departmentType==5">骨外科</s:if>
				<s:if test="department.departmentType==6">眼科</s:if>
				<s:if test="department.departmentType==7">口腔科</s:if>
				<s:if test="department.departmentType==8">耳鼻咽喉头颈科</s:if>
				<s:if test="department.departmentType==9">肿瘤科</s:if></td>			
			</tr>
			<tr>
				<th>科室名称</th>
				<td><s:property value="department.departmentName" />  </td>			
			</tr>
			<tr>
				<th>科室地址</th>
				<td><s:property value="department.departmentAddress" />  </td>			
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