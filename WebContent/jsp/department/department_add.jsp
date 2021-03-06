<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
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
	<h3 class="modal-title">新增</h3>
	<form id="addForm" action="department!addSave.action" method="post">
	
		<div class="modal-body">
			<!-- 	<div class="col-md-6" id="firstIn"> -->
				<div class="col-md-12" id="firstIn">
				<div class="form-group" >
					<label for="enterdepartmentType">科室类别</label>
					<select id="enterdepartmentType" name="department.departmentType" class="selectpicker show-tick form-control" data-live-searck="false">
						<option value="">请选择</option>
						<option value="0">内科</option>
						<option value="1">外科</option>
						<option value="2">妇产科</option>
						<option value="3">生殖中心</option>
						<option value="4">儿科</option>
						<option value="5">骨外科</option>
						<option value="6">眼科</option>
						<option value="7">口腔科</option>
						<option value="8">耳鼻咽喉头颈科</option>
						<option value="9">肿瘤科</option>
					</select>
				</div>
			</div>
			
			<div class="col-md-12"  >
			
				<div class="form-group" >
					<label for="enterdepartmentname">科室名称</label>
					<input type="text" class="form-control" maxlength="50" name="department.departmentName" id="enterdepartmentname" placeholder="请输入科室名称">
				</div>
			</div>
		
			<div class="col-md-12">
				<div class="form-group">
					<label for="enterdepartmentaddress">科室地址</label>
					<input type="text" class="form-control" maxlength="50" name="department.departmentAddress" id="enterdepartmentaddress" placeholder="请输入科室地址">
				</div>
			</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="addSave()">保存</button>
			<button type="button" class="btn btn" data-dismiss="modal">退出</button>
		
		</div>
	</div>
		
</form>
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
	function addSave() {
		if (checkParm()) {	
		
			window.wxc.xcConfirm( "是否保存？",window.wxc.xcConfirm.typeEnum.warning,{
				
			onOk:function (e) {
				var option={

						success:function(data){
							if (data.message==1) {
								window.wxc.xcConfirm("新增成功", window.wxc.xcConfirm.typeEnum.info);
								$('#modal').modal('hide');
								
							}
						
						}
					}
						$("#addForm").ajaxSubmit(option);
				
			}
			});
		}
	}

	function checkParm() {
		var departmenName = $('#enterdepartmentname').val();
		if (departmenName==null||departmenName=="") {
			window.wxc.xcConfirm("请输入科室名称", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		var departmentAddress=$('#enterdepartmentaddress').val();
		if (departmentAddress==null||departmentAddress=="") {
			window.wxc.xcConfirm("请输入科室地址", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	
		return true; 
	}
</script>