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
	<div class="col-lg-6 col-md-6">
		<div class="jumbotron Myjumbotron">
			<h2>预约方法:</h2>
			<p>
				请按照要求仔细填写完整右边表单中的内容，并在预约时间提前半小时到科室准备就医。
			</p>


		</div>
		<div class="jumbotron Myjumbotron">
			<h2>注意事项:</h2>
			<p>
				如若有特殊情况请拨打医生电话取消预约，请在就医时带好身份证件，以便登记。
			</p>


		</div>
	</div>
	<form id="addForm" action="appointment!addSave.action" method="post">
		<div id="appointmentIn" class="col-lg-5 col-md-5 ">
			<div class="col-lg-12 col-md-12">
				<div class="form-group">
					<label for="enterusername" class="col-lg-3 col-md-3 col-lg-push-1 col-md-push-1">患者姓名</label>
					<select id="enterusername"  name="appointment.userId.uid" class="js-data-example-ajax form-group col-lg-7 col-md-7" tabindex="-1" aria-hidden="true">
						<option value="3620194" selected="selected">请选择患者姓名</option>
					</select>
				</div>
			</div>

			<div class="col-lg-12 col-md-12" >
				<div class="form-group">
					<label for="enterdepartment" class="col-lg-3 col-md-3 col-lg-push-1 col-md-push-1">科室名称</label>
					<select id="enterdepartment" name="appointment.departmentId.serial"  class="js-data-example-ajax form-group col-lg-7 col-md-7" tabindex="-1" aria-hidden="true">
						<option value="39020194" selected="selected">请选择科室</option>
					</select>

				</div>
			</div>

			<div class="col-lg-12 col-md-12" >
				<div class="form-group">
					<label for="enterappointmenttime" class="col-lg-3 col-md-3 col-lg-push-1 col-md-push-1">预约时间</label>
					<input size="16" type="text" name="appointment.appointmentTime" id="enterappointmenttime" value="" class="form-group col-lg-7 col-md-7" readonly>

				</div>
			</div>

			<div class="col-lg-12 col-md-12">
				<div class="form-group">
					<label for="enterappointmentremark" class="col-lg-3 col-md-3 col-lg-push-1 col-md-push-1">备注</label>
					<textarea class="col-lg-7 col-md-7"  maxlength="200" name="appointment.remark" id="enterappointmentremark" placeholder="备注" rows="4" ></textarea>

				</div>
			</div>

			<div class="col-lg-12 col-md-12" id="firstIn">
				<div class="col-lg-6 col-md-6 col-lg-push-2">
					<button type="button" class="btn btn-success btn-lg ">预约</button>
				</div>
				<div class="col-lg-6 col-md-6">
					<button type="button" class="btn btn-warning btn-lg">重填</button>
				</div>
			</div>		
		</div>
	</form>
	<!-- JavaScript -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/select2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/zh-CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>

	<script type="text/javascript">
		$("#enterappointmenttime").datetimepicker({
    	 language: 'zh-CN',//显示中文
    	format: "yyyy-mm-dd hh:ii:ss",//显示格式
    	initialDate: new Date(),
    	  autoclose: true,//选中自动关闭
    	  todayBtn: true//显示今日按钮
    	}); 
		
		$(".btn-warning").click(function () {
			$("#enterusername").val("");
			$("#select2-enterusername-container").attr("title","");
			$("#select2-enterusername-container").empty();
			var str=$("<span class='select2-selection__placeholder'>请选择患者姓名</span>");
			$("#select2-enterusername-container").prepend(str);
			$("#enterappointmenttime").val("");
			$("#enterdepartment").val("");
			$("#select2-enterdepartment-container").attr("title","");
			$("#select2-enterdepartment-container").empty();
			var str2=$("<span class='select2-selection__placeholder'>请选择科室</span>");
			$("#select2-enterdepartment-container").prepend(str2);
			$("#enterappointmentremark").val("");

		})


		function checkParm() {
			var enterusername = $('#enterusername').val();
			if (enterusername==null||enterusername=="") {
				window.wxc.xcConfirm("请选择患者姓名", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			
			var enterdepartment=$('#enterdepartment').val();
			if (enterdepartment==null||enterdepartment=="") {
				window.wxc.xcConfirm("请选择科室", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			var enterappointmenttime=$('#enterappointmenttime').val();
			if (enterappointmenttime==null||enterappointmenttime=="") {
				window.wxc.xcConfirm("请输入时间", window.wxc.xcConfirm.typeEnum.info);
				return false;
			}
			
			return true; 
		}

		$(".btn-success").click(function () {
			if (checkParm()) {	
				
				window.wxc.xcConfirm( "是否预约？",window.wxc.xcConfirm.typeEnum.warning,{
					
					onOk:function (e) {
						var option={

							success:function(data){
								if (data.message==1) {
									window.wxc.xcConfirm("预约成功", window.wxc.xcConfirm.typeEnum.info);
									$("#enterappointmenttime").val("");
									location.reload();
								}
								
							}
						}
						$("#addForm").ajaxSubmit(option);
						
					}
				});
			}
		})


		$("#enterusername").select2({

			language: "zh-CN",
			maximumInputLength: 10,
			ajax: {
				url: "<%=request.getContextPath()%>/appointment!queryUser.action",
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
			  templateResult:  formatRepo, 
			  templateSelection:formatRepoSelection,
			});

		function formatRepo (repo) {
			if (repo.loading) return repo.text;
			var markup="<option value="+repo.uid+">用户名:"+repo.userName+"&nbsp;&nbsp;&nbsp;姓名:"+
			repo.name+"</option>";
			return markup;
		}

		function formatRepoSelection(repo) {
			$("#enterusername").val(repo.uid); 
			return repo.name||repo.text;
		}



		$("#enterdepartment").select2({

			language: "zh-CN",
			maximumInputLength: 10,

			ajax: {
				url: "<%=request.getContextPath()%>/appointment!queryDepartment.action",
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
			    $.each(data.departmentList,function(i,v){
			    	var o ={};
			    	o.id=v.serial;
			    	o.serial=v.serial;
			    	o.departmentName=v.departmentName;
			    	o.departmentAddress=v.departmentAddress;					  
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
			var markup="<option value="+repo.serial+">科室名称:"+repo.departmentName+"&nbsp;&nbsp;&nbsp;科室地址:"+
			repo.departmentAddress+"</option>";
			return markup;
		}

		function formatRepoSelection2(repo) {
			$("#enterdepartment").val(repo.serial); 
			return repo.departmentName||repo.text;
		}
	</script>
</body>
</html>