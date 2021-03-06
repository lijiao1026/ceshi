<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<%@ taglib uri="/WEB-INF/dataformate.tld" prefix="datefmt"%>   
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
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<!-- 	模态窗内容加载位置 -->
			</div>
		</div>
	</div>		
	
	<div class="col-lg-8 col-md-8">
		<div id="myCarousel" class="carousel slide" data-interval="2000" data-ride="carousel">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>   
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="<%=request.getContextPath()%>/image/login1.jpg"  class="img-responsive" alt="First slide">
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/image/login2.jpg"    class="img-responsive" alt="Second slide">
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/image/login3.jpg"  class="img-responsive" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" 
			data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left">
			</span></a>
			<a class="carousel-control right" href="#myCarousel" 
			data-slide="next">
			<span class="glyphicon glyphicon-chevron-right">
			</span></a>
		</div> 
	</div>
	<div class="col-lg-4 col-md-4">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">公告栏</a>
				</div>
			</div>
		</nav>
		<div class="list-group">
		<s:if test="sysNoticeList != null &&  sysNoticeList.size != 0">
			<s:iterator value="sysNoticeList" status="st">
			<button type="button" class="list-group-item" title="${noticeTitle}" data-toggle="modal" data-target="#modal"  href="<%=request.getContextPath()%>/sysNotice!toDetail.action?serial=<s:property value="serial" />">
			<datefmt:writeString property="${noticeTitle}"
                            length="10" formatStr="" ellipsis="true" ></datefmt:writeString>
                            <p class="pull-right">
                            <datefmt:writeString formatStr="yyyy-MM-dd HH:mm:ss" property="${createTime}">
                       </datefmt:writeString></p>
                            </button>
			</s:iterator>
			</s:if>
	
		</div>

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">预约栏</a>
				</div>
			</div>
		</nav>
		<div class="list-group">
		<s:if test="appointmentList != null &&  appointmentList.size != 0">
			<s:iterator value="appointmentList" status="st">
<%-- 			<button type="button" class="list-group-item" data-toggle="modal" data-target="#modal"  href="<%=request.getContextPath()%>/appointment!toDetail.action?serial=<s:property value="serial" />">
 --%>
	<button type="button" class="list-group-item"  >
 			${appointmentSerial}
			 <span class="badge pull-right">${appointmentTime}</span>
                         
			</button>
			</s:iterator>
			</s:if>
			
		<s:else>
		<button type="button" class="list-group-item" >
 			今日无预约
			 <p class="pull-right">
                       
                         
			</button>
		</s:else>
	
		</div>
	</div>
	<div class="col-lg-12 col-md-12">
	<div class="bottomCopyright">
		
	<footer>
			<p class="pull-right">
				Copyright&nbsp;&nbsp;&nbsp;&nbsp; ©2017&nbsp;&nbsp;&nbsp;&nbsp; 12013054027李骄
			</p>
			</footer>
	</div>
</div>
	<!-- JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript">
		function queryList() {
			// body...
			location.reload();
		}

	</script>
</body>
</html>