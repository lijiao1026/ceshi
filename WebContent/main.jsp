<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"  %>
<%@ taglib uri="/struts-tags"  prefix="s"%>    
<!DOCTYPE html>
<html>
<head>
	<title>服务平台主页</title>
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">

</head>
<body style="padding-top:70px">
	<div>
		<nav role="navigation" class="navbar navbar-myNavbar navbar-fixed-top">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">医疗门诊服务平台</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<!--   <li class="active"><a href="#">系统首页 <span class="sr-only">(current)</span></a></li> -->
					<li ><a href="#">系统首页 <span class="sr-only">(current)</span></a></li>
					<li ><a href="#">挂号预约</a></li>
					<s:if test="user.userType==1||user.userType==0">
					
					<li > <a href="#">门诊收费</a></li>
				</s:if>
				<s:if  test="user.userType==0">
				
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">药库管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">药品入库</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">药品管理</a></li>      
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">患者管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">医生管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">管理员用户管理</a></li>    
					</ul>
				</li>
				<li><a href="#">统计分析</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">公告管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">科室管理</a></li>
						
					</ul>
				</li>
			</s:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>${session_user.name} <span class="caret"></span></a>
				<ul class="dropdown-menu">
					
					<li><a href="#">修改密码</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">退出系统</a></li>
				</ul>
			</li>
		</ul> 
		
	</div><!-- /.navbar-collapse -->

	
</nav>
</div>
<iframe src="" width="100%" height="auto" frameborder="0"></iframe>


<!-- JavaScript -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
</body>
</html>