<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
	<title>医疗门诊服务平台</title>
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/xcConfirm.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="bigTitle">
		<div class="container"> 
			<h1>医疗门诊服务平台</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-8">
				<img src="<%=request.getContextPath()%>/image/loginLeft.jpg" class="img-responsive" alt="Responsive image">
			</div>

			<div class="row">
				<div class="col-lg-4 col-md-4" id="topLeave">
					<form id="loginForm" action="user!login.action" method="post">
						<h6 style="color: red"><s:actionerror/></h6>
						<div class="col-md-12" id="firstIn">
							<div class="form-group" >
								<label for="username">用户名</label>
								<input type="text" class="form-control" name="user.userName" id="username" placeholder="请输入用户名">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="password">密码</label>
								<input type="password" class="form-control" name="user.password" id="password" placeholder="请输入密码">
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<button type="button" class="btn btn-info btn-lg btn-block" onclick="login()">登录</button>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">				
								<a class="help-block" href="user!toRegister" data-toggle="modal" data-target="#modal">马上注册</a>
							</div>
						</div>
						<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<!-- 	模态窗内容加载位置 -->
								</div>
							</div>
						</div>						

					</form>
				</div>
			</div>
		</div>
	</div>

	
	<!-- JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript">
		function login() {
			if (checkParam()) {
	
				$("#loginForm").submit();
			}

		}
		function checkParam() {
			var userName=$("#username").val();

			if (userName==null||userName=="") {
				window.wxc.xcConfirm("请输入用户名", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
	
			var password=$("#password").val();
			if (password==null||password=="") {
				window.wxc.xcConfirm("请输入密码", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
