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
		<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<!-- 	模态窗内容加载位置 -->
								</div>
							</div>
						</div>			
	
	
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
					<li id="menu_1"><a  id="firstPage" onclick="loadIframe(1)">系统首页 <span class="sr-only">(current)</span></a></li>
					<li id="menu_2"><a onclick="loadIframe(2)">挂号预约</a></li>
					<s:if test="user.userType==1||user.userType==0">
					
					<li id="menu_3"> <a onclick="loadIframe(3)">门诊收费</a></li>
				</s:if>
				<s:if  test="user.userType==0">
				
				
				<li class="dropdown" id="menu_4">
					<a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">药库管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a onclick="loadIframe(4)">药品入库</a></li>
						<li role="separator" class="divider"></li>
						<li><a onclick="loadIframe(5)">药品管理</a></li>      
					</ul>
				</li>
				<li class="dropdown" id="menu_5">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a onclick="loadIframe(6)">患者管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a onclick="loadIframe(7)">医生管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a onclick="loadIframe(8)">管理员用户管理</a></li>    
					</ul>
				</li>
				<li id="menu_6"><a href="#">统计分析</a></li>
				<li class="dropdown" id="menu_7">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a onclick="loadIframe(9)">公告管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a onclick="loadIframe(10)">科室管理</a></li>
						
					</ul>
				</li>
			</s:if>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>${session_user.name} <span class="caret"></span></a>
				<ul class="dropdown-menu">
					
					<li><a href="<%=request.getContextPath()%>/user!changePassWord.action?uid=<s:property value="user.uid" />" data-toggle="modal" data-target="#modal">修改密码</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="<%=request.getContextPath()%>/login.jsp">退出系统</a></li>
				</ul>
			</li>
		</ul> 
		
	</div><!-- /.navbar-collapse -->

</nav>
</div>
<iframe src="" width="100%" height="530px" frameborder="0" id="myIframe"></iframe>


<!-- JavaScript -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#firstPage").click();
})

	function loadIframe(menuId) {
		if(menuId==1){
		$("#myIframe").attr("src","<%=request.getContextPath()%>/user!toIndex.action");
		$(".active").attr("class","");
		$("#menu_"+menuId).attr("class","active"); 
		}
		
		if(menuId==2){
			$("#myIframe").attr("src","<%=request.getContextPath()%>/user!toIndex.action");
			$(".active").attr("class","");
			$("#menu_"+menuId).attr("class","active"); 
			}
		if(menuId==6){
			$("#myIframe").attr("src","<%=request.getContextPath()%>/userType1!queryList.action");
			$(".active").attr("class","");
			$("#menu_5").attr("class","active"); 
			}
		if(menuId==8){
			$("#myIframe").attr("src","<%=request.getContextPath()%>/userType0!queryList.action");
			$(".active").attr("class","");
			$("#menu_5").attr("class","active"); 
			}
		if(menuId==7){
			$("#myIframe").attr("src","<%=request.getContextPath()%>/userType2!queryList.action");
			$(".active").attr("class","");
			$("#menu_5").attr("class","active"); 
			}
	}



</script>
</body>
</html>