<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<%@ taglib uri="/WEB-INF/dataformate.tld" prefix="datefmt"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="<%=request.getContextPath()%>/css/select2.css" rel="stylesheet" type="text/css">	
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
				<a class="navbar-brand" href="#">门诊收费</a>
			</div>

		</nav>
	</div>
	
	<div class="col-lg-12 col-md-12">
		
		<form class="form-inline" id="addForm" action="userCase!addSave.action" method="post">
			<div class="col-md-6 col-lg-6 col-lg-push-2 col-md-push-2 tabLength"  >
				<div class="form-group " >
					<label for="enterappointmentSerial">预约编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<select   id="enterappointmentSerial"  name="userCase.appointmentId.serial" class="js-data-example-ajax form-control " tabindex="-1" aria-hidden="true">
						<option   value="3620194" selected="selected">请选择预约编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
<!-- 					<input type="text"  size="30" class="form-control" maxlength="20" name="userCase.appointmentId.serial" id="enterappointmentSerial" placeholder="请选择预约编号">
 -->				</div>
			</div>
			<div class="col-md-6 col-lg-6 tabLength"  >
				<div class="form-group" >
					<label for="enteruserId" >就诊医生&nbsp;&nbsp;&nbsp;</label>
					<select id="enteruserId"  name="userCase.userId.uid" class="js-data-example-ajax form-control " tabindex="-1" aria-hidden="true">
						<option  value="3620194" selected="selected">请选择就诊医生姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
<!-- 					<input type="text" size="30" class="form-control" maxlength="20" name="userCase.userId.uid" id="enteruserId" placeholder="请选择就诊医生姓名">
 -->				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-lg-push-2 col-md-push-2 tabLength" >
				<div class="form-group">
					<label for="entermedicinename" >所开药品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<select   id="entermedicinename"  name="userCase.medicineId.serial" class="js-data-example-ajax form-control " tabindex="-1" aria-hidden="true">
						<option value="30194" selected="selected">请选择药品名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
<!-- 					<input size="30" type="text" class="form-control" name="userCase.medicineId.serial" id="entermedicinename"  placeholder="请选择药品名称" class="form-group">
 -->				</div>
			</div>
			<div class="col-lg-6 col-md-6 tabLength" >
				<div class="form-group">
					<label for="entercaseFree" >就诊费用&nbsp;&nbsp;&nbsp;</label>
					<input size="30" type="text" class="form-control" name="userCase.caseFree" id="entercaseFree"   placeholder="请输入就诊费用" class="form-group" >
				</div>
			</div>
			
			<div class="col-md-10 col-lg-10 col-lg-push-2 col-md-push-2 tabLength"   >
				<div class="form-group" >
					<label for="enterzhuSu" class="center-block">主诉&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<textarea  maxlength="200" name="userCase.zhuSu" style="margin-left: 13%;margin-top: -10px;" id="enterzhuSu" placeholder="主诉" rows="3"  cols="105"></textarea>
				</div>
			</div>
			<div class="col-md-10 col-lg-10 col-lg-push-2 col-md-push-2 tabLength"   >
				<div class="form-group" >
					<label for="enternowBingShi" class="center-block">现病史&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<textarea  maxlength="200" name="userCase.nowBingShi" style="margin-left: 13%;margin-top: -10px;" id="enternowBingShi" placeholder="现病史" rows="3"  cols="105"></textarea>
				</div>
			</div>
			<div class="col-md-10 col-lg-10 col-lg-push-2 col-md-push-2 tabLength"   >
				<div class="form-group" >
					<label for="enterpersonBingShi" class="center-block">个人史&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<textarea  maxlength="200" name="userCase.personBingShi" style="margin-left: 13%;margin-top: -10px;" id="enterpersonBingShi" placeholder="个人史" rows="3"  cols="105"></textarea>
				</div>
			</div>
				<div class="col-md-10 col-lg-10 col-lg-push-2 col-md-push-2 tabLength"   >
				<div class="form-group" >
					<label for="enterfamailyBingShi" class="center-block">个人史&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
					<textarea  maxlength="200" name="userCase.famailyBingShi" style="margin-left: 13%;margin-top: -10px;" id="enterfamailyBingShi" placeholder="家族史" rows="3"  cols="105"></textarea>
				</div>
			</div>
			<div class="col-lg-9 col-md-9 col-lg-push-3 col-md-push-3" id="firstIn">
				<div class="col-lg-6 col-md-6 col-lg-push-2 col-md-push-2">
					<button type="button" class="btn btn-success btn-lg" onclick="addSave()">记录</button>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/select2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/zh-CN.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript">

	$("#enterappointmentSerial").select2({

		language: "zh-CN",
		maximumInputLength: 10,
		ajax: {
			url: "<%=request.getContextPath()%>/userCase!queryAppointment.action",
			dataType: 'json',
			delay: 500,
			data: function (params) {
				return {
		        q: params.term, // search term
		        currPage: params.page
		    };
		},
		processResults: function (data, params) {
		    //解析结果为预期的格式，因为我们使用自定义格式化功能，我们不需要更改远程JSON数据，表示滚动可以使用
		    params.page = params.page || 1;
		    /*使用select2必须传输的数据中有id值，不然无法使得组件识别，在这里也别注释，以防止以后忘记。*/
		    var results = [];

		    $.each(data.appointmentList,function(i,v){
		    	var o ={};
		    	o.id=v.serial;
		    	o.serial=v.serial;
		    	o.appointmentSerial=v.appointmentSerial;
		    	o.name=v.userId.name;
		    	results.push(o);
		    });
		    return {
		    	results: results,
		    	pagination: {
		    		more: (params.page * 30) < data.total_count
		    	}
		    };
		},
		cache: true
	},
		  escapeMarkup: function (markup) { return markup; }, //自定义格式化工作
		  minimumInputLength: 1,
		  templateResult:  formatRepo, 
		  templateSelection:formatRepoSelection,
		});

	function formatRepo (repo) {
		if (repo.loading) return repo.text;
		var markup="<option value="+repo.serial+">预约编号:"+repo.appointmentSerial+"&nbsp;&nbsp;&nbsp;</br>患者姓名:"+
		repo.name+"</option>";
		return markup;
	}

	function formatRepoSelection(repo) {
		$("#enterappointmentSerial").val(repo.serial); 
		return repo.appointmentSerial||repo.text;
	}
	
	
	$("#enteruserId").select2({

		language: "zh-CN",
		maximumInputLength: 10,
		ajax: {
			url: "<%=request.getContextPath()%>/userCase!queryUser.action",
			dataType: 'json',
			delay: 500,
			data: function (params) {
				return {
		        q2: params.term, // search term
		        currPage: params.page
		    };
		},
		processResults: function (data, params) {
		    //解析结果为预期的格式，因为我们使用自定义格式化功能，我们不需要更改远程JSON数据，表示滚动可以使用
		    params.page = params.page || 1;
		    /*使用select2必须传输的数据中有id值，不然无法使得组件识别，在这里也别注释，以防止以后忘记。*/
		    var results = [];

		    $.each(data.userList,function(i,v){
		    	var o ={};
		    	o.id=v.uid;
		    	o.uid=v.uid;
		    	o.userName=v.userName;
		    	o.name=v.name;					  
		    	results.push(o);
		    });
		    return {
		    	results: results,
		    	pagination: {
		    		more: (params.page * 30) < data.total_count
		    	}
		    };
		},
		cache: true
	},
		  escapeMarkup: function (markup) { return markup; }, //自定义格式化工作
		  minimumInputLength: 1,
		  templateResult:  formatRepo2, 
		  templateSelection:formatRepoSelection2,
		});

	function formatRepo2 (repo) {
		if (repo.loading) return repo.text;
		var markup="<option value="+repo.uid+">用户名:"+repo.userName+"&nbsp;&nbsp;&nbsp;姓名:"+
		repo.name+"</option>";
		return markup;
	}

	function formatRepoSelection2(repo) {
		$("#enteruserId").val(repo.uid); 
		return repo.name||repo.text;
	}
	
	
	$("#entermedicinename").select2({

		language: "zh-CN",
		maximumInputLength: 10,
		ajax: {
			url: "<%=request.getContextPath()%>/userCase!queryMedicine.action",
			dataType: 'json',
			delay: 500,
			data: function (params) {
				return {
		        medicineName: params.term, // search term
		        currPage: params.page
		    };
		},
		processResults: function (data, params) {
		    //解析结果为预期的格式，因为我们使用自定义格式化功能，我们不需要更改远程JSON数据，表示滚动可以使用
		    params.page = params.page || 1;
		    /*使用select2必须传输的数据中有id值，不然无法使得组件识别，在这里也别注释，以防止以后忘记。*/
		    var results = [];

		    $.each(data.medicineList,function(i,v){
		    	var o ={};
		    	o.id=v.serial;
		    	o.serial=v.serial;
		    	o.medicineName=v.medicineName;
		    	o.medicineStore=v.medicineStore;
		    	o.unitPrice=v.unitPrice;
		    	o.information="药品名称:"+v.medicineName+"   药品单价："+v.unitPrice;
		    	results.push(o);
		    });
		    return {
		    	results: results,
		    	pagination: {
		    		more: (params.page * 30) < data.total_count
		    	}
		    };
		},
		cache: true
	},
		  escapeMarkup: function (markup) { return markup; }, //自定义格式化工作
		  minimumInputLength: 1,
		  templateResult:  formatRepo3, 
		  templateSelection:formatRepoSelection3,
		});

	function formatRepo3 (repo) {
		if (repo.loading) return repo.text;
		var markup="<option value="+repo.serial+">药品名称:"+repo.medicineName+"&nbsp;&nbsp;&nbsp;药品库存量:"+
		repo.medicineStore+"&nbsp;&nbsp;&nbsp;</br>药品单价:"+
		repo.unitPrice+"</option>";
		return markup;
	}

	function formatRepoSelection3(repo) {
		$("#entermedicinename").val(repo.serial); 
		return repo.information||repo.text;
	}
	
		function addSave() {
			if (checkParm()) {	

				window.wxc.xcConfirm( "是否保存？",window.wxc.xcConfirm.typeEnum.warning,{

					onOk:function (e) {
						var option={

							success:function(data){
								if (data.message==1) {
									window.wxc.xcConfirm("记录成功", window.wxc.xcConfirm.typeEnum.info);
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
 			var enterappointmentSerial = $('#enterappointmentSerial').val();
		if (enterappointmentSerial==null||enterappointmentSerial=="") {
			window.wxc.xcConfirm("请选择预约编号", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enteruserId = $('#enteruserId').val();
		if (enteruserId==null||enteruserId=="") {
			window.wxc.xcConfirm("请选择就诊时间", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var entermedicinename = $('#entermedicinename').val();
		if (entermedicinename==null||entermedicinename=="") {
			window.wxc.xcConfirm("请选择药品名称", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var entercaseFree = $('#entercaseFree').val();
		if (entercaseFree==null||entercaseFree=="") {
			window.wxc.xcConfirm("请输入就诊费用", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		if (!checkNumber(entercaseFree)) {
			window.wxc.xcConfirm("就诊费用请输入数字", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
		var enterzhuSu = $('#enterzhuSu').val();
		if (enterzhuSu==null||enterzhuSu=="") {
			window.wxc.xcConfirm("请输入主诉", window.wxc.xcConfirm.typeEnum.info);
			return false;
		}
	
	
		return true; 
 }
		$(".btn-warning").click(function () {
			location=location;
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