<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/xcConfirm.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="modal-header">
		<button type="button" class="close" data-toggle="modal" data-dismiss="modal" id="modalColse">
			x
			<!-- 防止页面被覆盖为黑色 -->
		</button>
		<h3 class="modal-title">修改密码</h3>
		<form id="registerForm" action="user!saveNewPassword.action" method="post">
			<s:hidden name="user.uid" id="uid"></s:hidden>
			<div class="modal-body">
				<!-- 	<div class="col-md-6" id="firstIn"> -->
				<div class="col-md-12"  id="firstIn">
					<div class="form-group" >
						<label for="oldPassword">原密码</label>
						<input type="password"  maxlength="20" class="form-control" name="oldPassword" id="oldPassword" placeholder="请输入用户名">
					</div>
				</div>


				<div class="col-md-12" >
					<div class="form-group" >
						<label for="newPassword">新密码</label>
						<input type="password"  maxlength="20" class="form-control" name="newPassword" id="newPassword" placeholder="请输入用户名">
					</div>
				</div>
				<div class="col-md-12" >
					<div class="form-group" >
						<label for="newPasswordTwo">确认新密码</label>
						<input type="password"  maxlength="20" class="form-control" name="newPasswordTwo" id="newPasswordTwo" placeholder="请输入用户名">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="addSave()">保存</button>
					<button type="button" class="btn btn" data-dismiss="modal">退出</button>

				</div>
			</div>

		</form>
	</div>
	<!-- JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script type="text/javascript">
	$('#modal').modal('show');
	$('#modal').on('hidden.bs.modal', function (e) {
				location=location;
		})
		function addSave() {
			
			if (checkParm()) {
					window.wxc.xcConfirm( "是否保存？",window.wxc.xcConfirm.typeEnum.warning,{
			onOk:function (e) {
				var option={

					success:function(data){
						if (data.message==1) {
							window.wxc.xcConfirm("修改密码成功", window.wxc.xcConfirm.typeEnum.info);
							$('#modal').modal('hide');
						}
						else if(data.message==0){
							window.wxc.xcConfirm("修改密码失败", window.wxc.xcConfirm.typeEnum.info);
						}else if(data.message==2){
							window.wxc.xcConfirm("原密码错误", window.wxc.xcConfirm.typeEnum.info);
						}
					}
				}
					$("#registerForm").ajaxSubmit(option);
			}
			});
			}
			
			}
			function checkParm() {
				var oldPassword=$("#oldPassword").val();
				if (oldPassword==""||oldPassword==null) {
					window.wxc.xcConfirm("请输入原密码", window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				
				var newPassword=$("#newPassword").val();
				if (newPassword==""||newPassword==null) {
					window.wxc.xcConfirm("请输入新密码", window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				var newPasswordTwo=$("#newPasswordTwo").val();
				if (newPasswordTwo==""||newPasswordTwo==null) {
					window.wxc.xcConfirm("请确认新密码", window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				if (newPassword!=newPasswordTwo) {
					window.wxc.xcConfirm("2次密码输入不一致", window.wxc.xcConfirm.typeEnum.info);
					return false;
				}
				return true;
			}
			
		</script>
	</body>
	</html>