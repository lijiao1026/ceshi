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
	<h3 class="modal-title">修改</h3>
	<form id="addForm" action="sysNotice!editSave.action" method="post">

		<s:hidden name="sysNotice.serial" id="serial"></s:hidden>
		<div class="modal-body">
			<!-- 	<div class="col-md-6" id="firstIn"> -->
			<div class="col-md-12"  id="firstIn">
				<div class="form-group" >
					<label for="enternoticetitle">公告标题</label>
					<input type="text" class="form-control" maxlength="50" value="${sysNotice.noticeTitle}" name="sysNotice.noticeTitle" id="enternoticetitle" placeholder="请输入公告标题">
				</div>
			</div>
		
			<div class="col-md-12">
				<div class="form-group">
					<label for="entersysnoticecontent">公告内容</label>
					<textarea class="form-control"  maxlength="200" name="sysNotice.noticeContent"  id="entersysnoticecontent" placeholder="请输入公告内容" rows="3">${sysNotice.noticeContent}</textarea>
			
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
								window.wxc.xcConfirm("修改成功", window.wxc.xcConfirm.typeEnum.info);
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
		var noticeTitle = $('#enternoticetitle').val();
		if (noticeTitle==null||noticeTitle=="") {
			window.wxc.xcConfirm("请输入公告标题", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		
		var noticeContent=$('#entersysnoticecontent').val();
		if (noticeContent==null||noticeContent=="") {
			window.wxc.xcConfirm("请输入公告内容", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	
		return true; 
	}
</script>