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
	<link href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal">
		<div class="modal-dialog" role="document">
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
				<a class="navbar-brand" href="#">药品入库</a>
			</div>

		</nav>
	</div>
	
	<div class="col-lg-12 col-md-12">
		
		<form class="form-inline" id="addForm" action="medicine!addSave.action" method="post">
			<div class="col-md-6 col-lg-6 col-lg-push-2 col-md-push-2 tabLength"  >
				<div class="form-group " >
					<label for="entermedicinetype">药品分类编号&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text"  size="30" class="form-control" maxlength="20" name="medicine.medicineType" id="entermedicinetype" placeholder="请输入药品分类编号">
				</div>
			</div>
			<div class="col-md-6 col-lg-6 tabLength"  >
				<div class="form-group" >
					<label for="entermedicinename" >药品名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text" size="30" class="form-control" maxlength="20" name="medicine.medicineName" id="entermedicinename" placeholder="请输入药品名称">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-lg-push-2 col-md-push-2 tabLength" >
				<div class="form-group">
					<label for="enterproductionDate" >药品生产日期&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input size="30" type="text" class="form-control" name="medicine.productionDate" id="enterproductionDate" value=""  placeholder="请选择生产日期" class="form-group">
				</div>
			</div>
			<div class="col-lg-6 col-md-6 tabLength" >
				<div class="form-group">
					<label for="enterexpireDate" >药品有效日期&nbsp;&nbsp;</label>
					<input size="30" type="text" class="form-control" name="medicine.expireDate" id="enterexpireDate" value=""  placeholder="请选择有效日期" class="form-group" >
				</div>
			</div>
			<div class="col-md-6 col-lg-6 col-lg-push-2 col-md-push-2 tabLength"  >
				<div class="form-group " >
					<label for="entermedicineSuppier">供应商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text"  size="30" class="form-control" maxlength="20" name="medicine.medicineSuppier" id="entermedicineSuppier" placeholder="请输入供应商">
				</div>
			</div>
			<div class="col-md-6 col-lg-6 tabLength"  >
				<div class="form-group" >
					<label for="enterSuppierPhone" >供应商电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text" size="30" class="form-control" maxlength="20" name="medicine.SuppierPhone" id="enterSuppierPhone" placeholder="请输入供应商电话">
				</div>
			</div>
			<div class="col-md-6 col-lg-6 col-lg-push-2 col-md-push-2 tabLength"  >
				<div class="form-group " >
					<label for="entermedicineSupply">供应量&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text"  size="30" class="form-control" maxlength="12" name="medicine.medicineSupply" id="entermedicineSupply" placeholder="请输入供应量">
				</div>
			</div>
			<div class="col-md-6 col-lg-6 tabLength"  >
				<div class="form-group" >
					<label for="enterunitPrice" >单价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<input type="text" size="30" class="form-control" maxlength="12" name="medicine.unitPrice" id="enterunitPrice" placeholder="请输入单价">
				</div>
			</div>
			<div class="col-md-10 col-lg-10 col-lg-push-2 col-md-push-2 tabLength"   >
				<div class="form-group" >
					<label for="enterremark" class="center-block">备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<textarea  maxlength="200" name="medicine.remark" style="margin-left: 13%;margin-top: -10px;" id="enterremark" placeholder="备注" rows="3"  cols="105"></textarea>
				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-lg-push-3 col-md-push-3" id="firstIn">
				<div class="col-lg-6 col-md-6 col-lg-push-2 col-md-push-2">
					<button type="button" class="btn btn-success btn-lg" onclick="addSave()">入库</button>
				</div>
				<div class="col-lg-6 col-md-6 col-lg-pull-2 col-md-pull-2">
					<button type="button" class="btn btn-warning btn-lg">重填</button>
				</div>
			</div>		
		</form>
	</div>



	




	<!-- JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript">
		$("#enterproductionDate").datetimepicker({
   	 	language: 'zh-CN',//显示中文
   		format: "yyyy-mm-dd",//显示格式
   		initialDate: new Date(),
   	  	autoclose: true,//选中自动关闭
   	  	todayBtn: true,//显示今日按钮
   	  	minView:"month",
   	  }); 
		
		$("#enterexpireDate").datetimepicker({
	   	 	language: 'zh-CN',//显示中文
	   		format: "yyyy-mm-dd",//显示格式
	   		initialDate: new Date(),
	   	  	autoclose: true,//选中自动关闭
	   	  	todayBtn: true,//显示今日按钮
	   	  	minView:"month",
	   	  }); 
		function addSave() {
			if (checkParm()) {	

				window.wxc.xcConfirm( "是否保存？",window.wxc.xcConfirm.typeEnum.warning,{

					onOk:function (e) {
						var option={

							success:function(data){
								if (data.message==1) {
									window.wxc.xcConfirm("入库成功", window.wxc.xcConfirm.typeEnum.info);
									location=location;

								}

							}
						}
						$("#addForm").ajaxSubmit(option);

					}
				});
			}
		}
		function checkParm() {
 			var entermedicinetype = $('#entermedicinetype').val();
		if (entermedicinetype==null||entermedicinetype=="") {
			window.wxc.xcConfirm("请输入药品分类编号", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enterexpireDate = $('#enterexpireDate').val();
		if (enterexpireDate==null||enterexpireDate=="") {
			window.wxc.xcConfirm("请选择药品有效日期", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var entermedicinename = $('#entermedicinename').val();
		if (entermedicinename==null||entermedicinename=="") {
			window.wxc.xcConfirm("请输入药品名称", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enterproductionDate = $('#enterproductionDate').val();
		if (enterproductionDate==null||enterproductionDate=="") {
			window.wxc.xcConfirm("请选择生产日期", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var entermedicineSuppier = $('#entermedicineSuppier').val();
		if (entermedicineSuppier==null||entermedicineSuppier=="") {
			window.wxc.xcConfirm("请输入供应商", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var entermedicineSupply = $('#entermedicineSupply').val();
		if (entermedicineSupply==null||entermedicineSupply=="") {
			window.wxc.xcConfirm("请输入供应量", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (!checkNumber(entermedicineSupply)) {
			window.wxc.xcConfirm("供应量请输入数字", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enterunitPrice = $('#enterunitPrice').val();
		if (enterunitPrice==null||enterunitPrice=="") {
			window.wxc.xcConfirm("请输入单价", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enterSuppierPhone = $('#enterSuppierPhone').val();
		if (enterSuppierPhone==null||enterSuppierPhone=="") {
			window.wxc.xcConfirm("请输入供应商电话", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
		if (!myreg.test(enterSuppierPhone)) {
			window.wxc.xcConfirm("您输入的手机号码格式有误", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (!checkNumber(enterunitPrice)) {
			window.wxc.xcConfirm("单价请输入数字", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		return true; 
 }
		$(".btn-warning").click(function () {
			$("#entermedicinetype").val("");
			$("#enterexpireDate").val("");
			$("#entermedicinename").val("");
			$("#enterproductionDate").val("");
			$("#entermedicineSuppier").val("");
			$("#enterunitPrice").val("");
			$("#entermedicineSupply").val("");
			$("#enterremark").val("");
			$("#enterSuppierPhone").val("");
		})
function checkNumber(theObj) {
  var reg = /^[0-9]+.?[0-9]*$/;
  if (reg.test(theObj)) {
    return true;
  }
  return false;
		}
</script>
</body>
</html>