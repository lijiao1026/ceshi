<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<%@ taglib uri="/WEB-INF/dataformate.tld" prefix="datefmt"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/css/xcConfirm.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="modal fade bs-example-modal-lg" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<!-- 	模态窗内容加载位置 -->
			</div>
		</div>
	</div>		
	<div class="col-lg-12 col-md-12">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">查询</a>
			</div>
			<form class="navbar-form navbar-right" action="" id="searchForm">
				<div class="form-group">
					<input type="text" name="searchMedicineName" id="searchMedicineName" class="form-control" placeholder="请输入药品名称">
				</div>
				<button type="button" class="btn btn-default" id="searchStart">查询</button>
			</form>

		</nav>
	</div>
	<s:hidden name="currPage" id="currPage"></s:hidden>

	<div class="col-lg-12 col-md-12">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">药品列表</a>
			</div>
			
		</nav>
		<table class=" table table-hover table-bordered" style="text-align: center;">
			<tr class="info" >
				<td width="5%">序号</td>
				<td width="10%">药品名称</td>
				<td width="15%">药品分类编号</td>
				<td width="10%">库存量</td>
				<td width="15%">供应商</td>
				<td width="15%">入库人姓名</td>
				<td width="20%">入库时间</td>
				<td width="10%">操作</td>
			</tr>
			<s:if test="medicineList != null &&  medicineList.size != 0">
			<s:iterator value="medicineList" status="st">
			<tr>
				<td>

					<s:property value="#st.count + ((currPage-1)*10)" />
				</td>
				<td title="${medicineName}">
				<datefmt:writeString property="${medicineName}"
                            length="10" formatStr="" ellipsis="true" ></datefmt:writeString>
				</td>
				<td title="${medicineType}">
				<datefmt:writeString property="${medicineType}"
                            length="10" formatStr="" ellipsis="true" ></datefmt:writeString>
				</td>
				
				<td >
				<s:property value="medicineStore" />
			
				</td>
					<td title="${medicineSuppier}">
				<datefmt:writeString property="${medicineSuppier}"
                            length="10" formatStr="" ellipsis="true" ></datefmt:writeString>
				</td>
				<td title="${userId.name}">
				<datefmt:writeString property="${userId.name}"
                            length="10" formatStr="" ellipsis="true" ></datefmt:writeString>
				</td>
				
				<td >
				<datefmt:writeString formatStr="yyyy-MM-dd HH:mm:ss" property="${inTime}">
                       </datefmt:writeString>
			
				</td>
				<td>
					<s:if test="medicineName!=null">
					<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal"  href="<%=request.getContextPath()%>/medicine!toDetail.action?serial=<s:property value="serial" />">查看</button>
					<%-- <button type="button" class="btn btn-warning btn-xs"  data-toggle="modal" data-target="#modal" href="<%=request.getContextPath()%>/medicine!toEdit.action?serial=<s:property value="serial" />" >修改</button>
					<button type="button" class="btn btn-danger btn-xs" onclick="deleteUser(${serial})">删除</button> --%>
				</s:if>
				
			</td>
		</tr>
		
	</s:iterator>
</s:if>
<s:else>
<tr>
	<td colspan="8">
		未找到相关数据!
	</td>
</tr>
</s:else>
</table>
</div>
<div class="col-lg-4 col-md-4 col-lg-push-5 col-md-push-5">
	<nav aria-label="Page navigation">
		<ul class="pagination  pagination-lg pagination-right">
			<li id="Previous">
				<s:if test="currPage!=1">
				<a href="${pageContext.request.contextPath}/medicine!queryList.action?currPage=<s:property value="currPage-1" />" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</s:if>

	</li>

	<li>
		<s:if test="currPage!=totalPage&&totalPage!=0">
		<a href="${pageContext.request.contextPath}/medicine!queryList.action?currPage=<s:property value="currPage+1" />" aria-label="Next">
		<span aria-hidden="true">&raquo;</span>
	</a>
</s:if>

</li>
</ul>
</nav>

</div>







<!-- JavaScript -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var pageTotal="${totalPage}";
		var pageNo="";
		for(var i=1;i<=pageTotal;i++){
			pageNo+="<li><a href={pageContext.request.contextPath}/medicine!queryList.action?currPage="+i+">"+i+"</a></li>"
		}
		$("#Previous").after(pageNo);
	})
	$("#searchStart").click(function () {
		// body...
		var currPage=$("#currPage").val();
		var searchmedicineName=$("#searchmedicineName").val();
		$("#searchForm").action="{pageContext.request.contextPath}/medicine!queryList.action?currPage="+currPage+"&searchmedicineName="+searchmedicineName;
		$("#searchForm").submit();
	})
	function queryList(){
		$("#searchStart").click();
	}
	function deleteUser(serial) {

		window.wxc.xcConfirm( "是否删除？",window.wxc.xcConfirm.typeEnum.warning,{

			onOk:function (e) {
				$.ajax(
				{
					type : 'get',
					dataType : 'json',
					url : 'medicine!delete.action',
					async : false,
					data :
					{
						serial : serial,					
					},
					success : function(message)
					{
						
						if(message.message==1)
						{
							window.wxc.xcConfirm("删除成功", window.wxc.xcConfirm.typeEnum.info);
							queryList();
						}
					}
				});


			}
		});
	}
</script>
</body>
</html>