<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<!DOCTYPE html>
<head>

	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/xcConfirm.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
</head>

<div class="modal-header">
	<button type="button" class="close" data-toggle="modal" data-dismiss="modal" id="modalColse">
		x
		<!-- 防止页面被覆盖为黑色 -->
	</button>
	<h3 class="modal-title">注册</h3>
	<form id="registerForm" action="user!registerSave.action" method="post">
		<div class="modal-body">
			<!-- 	<div class="col-md-6" id="firstIn"> -->
			<div class="col-md-6"  id="firstIn">
				<div class="form-group" >
					<label for="enterusername">用户名</label>
					<input type="text"  maxlength="20" class="form-control" name="user.userName" id="enterusername" placeholder="请输入用户名">
				</div>
			</div>
			<div class="col-md-6" id="firstIn">
				<div class="form-group">
					<label for="enterpassword">密码</label>
					<input type="password" maxlength="20"  class="form-control" name="user.password" id="enterpassword" placeholder="请输入密码">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label for="enterpasswordTwo">确认密码</label>
					<input type="password"  maxlength="20" class="form-control" id="enterpasswordTwo" placeholder="请再次输入密码">
				</div>
			</div>
			<div class="col-md-6" >
				<div class="form-group" >
					<label for="entername">姓名</label>
					<input type="text" maxlength="10"class="form-control" name="user.name" id="entername" placeholder="请输入姓名">
				</div>
			</div>
			<div class="col-md-6" >
				<div class="form-group" >
					<label for="enterbirthDady">出生日期</label>
					<input type="text" class="form-control"   name="user.birthDay" id="enterbirthDay" placeholder="请输入生日">
				</div>
			</div>
			<div class="col-md-6" >
				<div class="form-group" >
					<label for="entersex">性别</label>
					<select id="entersex" name="user.sex" class="selectpicker show-tick form-control" data-live-searck="false">
						<option value="">请选择</option>
						<option value="0">男</option>
						<option value="1">女</option>
						
					</select>
				</div>
			</div>
		<div class="col-md-6" >
			<div class="form-group" >
				<label for="enterphone">手机号码</label>
				<input type="text" maxlength="20" class="form-control" name="user.telPhone" id="enterphone" placeholder="请输入手机号码">
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group" >
				<label for="enteraddress">家庭住址</label>
				<input type="text" maxlength="20" class="form-control" name="user.address" id="enteraddress" placeholder="请输入地址">
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript">
$("#enterbirthDay").datetimepicker({
	 language: 'zh-CN',//显示中文
	 minView: "month", //选择日期后，不会再跳转去选择时分秒 
	 format: "yyyy-mm-dd",//显示格式
	 initialDate: new Date(),
	  autoclose: true,//选中自动关闭
	  todayBtn: true//显示今日按钮
	}); 

	function addSave() {
		if (checkParm()&&checkExist()) {	
		
			window.wxc.xcConfirm( "是否保存？",window.wxc.xcConfirm.typeEnum.warning,{
				
			onOk:function (e) {
				$('#registerForm').submit(); 	
			}
			});
		}
	}
function checkExist() {
	var userName = $('#enterusername').val();
	var returnValue=true;
	$.ajax(
				{
					type : 'get',
					dataType : 'json',
					url : 'user!checkUserName.action',
					async : false,
					data :
					{
						userName : userName,					
					},
					success : function(message)
					
					{
			/* console.log(message.message); */
					if(message.message==1)
						{
						window.wxc.xcConfirm("已存在用户名", window.wxc.xcConfirm.typeEnum.info);
						returnValue = false;
						}
					}
				});
	return returnValue;
}
	function checkParm() {
		var userName = $('#enterusername').val();
		if (userName==null||userName=="") {
			window.wxc.xcConfirm("请输入用户名", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var password = $('#enterpassword').val();
		var passwordTwo=$('#enterpasswordTwo').val();
		if (password==null||password=="") {
			window.wxc.xcConfirm("请输入密码", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
			if (password!=passwordTwo) {
				window.wxc.xcConfirm("2次密码输入不一致", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
		var name = $('#entername').val();
		if (name==null||name=="") {
			window.wxc.xcConfirm("请输入姓名", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var birthDay=$("#enterbirthDay").val();
		if (birthDay==null||birthDay=="") {
			window.wxc.xcConfirm("请输入出生日期", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		BirthDay=birthDay.replace(/[\-]/g,"");
		if(checkTime(BirthDay))
		{
			window.wxc.xcConfirm("出生日期不能选择将来日期!", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var telPhone = $('#enterphone').val();
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if (telPhone==null||telPhone=="") {
			window.wxc.xcConfirm("请输入手机号码", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
			if (!myreg.test(telPhone)) {
				window.wxc.xcConfirm("您输入的手机号码格式有误", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
		var sex=$("#entersex").val();
		if (sex==null||sex=="") {
			window.wxc.xcConfirm("请输入性别", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		return true; 
	}
	function checkTime(data)
	{
		var myDate = new Date();
		var mytimeYear=myDate.getFullYear();
		var mytimeMonth=myDate.getMonth();
		var mytimeDay=myDate.getDate();
		if((parseInt(mytimeYear)*10000+(parseInt(mytimeMonth)+1)*100+parseInt(mytimeDay))>=parseInt(data)){
			return false;
		}else{
			return true;
		}
	}
</script>