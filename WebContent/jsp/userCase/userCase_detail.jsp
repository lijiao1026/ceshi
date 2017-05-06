<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%> 
<%@ taglib uri="/WEB-INF/dataformate.tld" prefix="datefmt"%>
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
	<h3 class="modal-title">查看</h3>
	

		<div class="modal-body">
		<div class="col-md-12"  id="firstIn">
		<table class="table table-bordered table-striped">
			<tr>
				<th width="20%">预约编号</th>
				<td width="30%"><s:property value="userCase.appointmentId.appointmentSerial" />  </td>	
				<th width="20%">患者姓名</th>
				<td width="30%"><s:property value="userCase.appointmentId.userId.name" />  </td>			
			</tr>
			<tr>
				<th width="20%">就诊医生姓名</th>
				<td width="30%"> <s:property value="userCase.userId.name" />  </td>	
				<th width="20%">就诊时间</th>
				<td width="30%"><datefmt:writeString formatStr="yyyy-MM-dd HH:mm:ss" property="${userCase.caseTime}">
                       </datefmt:writeString>   </td>			
			</tr>
			<tr>
				<th width="20%">所开药品1</th>
				<td width="30%"><s:property value="userCase.MedicineId.medicineName" />  </td>	
				<th width="20%">所开药品2</th>
				<td width="30%"><s:property value="userCase.MedicineId1.medicineName" /></td>			
			</tr>
			<tr>
				<th width="20%">所开药品3</th>
				<td width="30%"><s:property value="userCase.MedicineId2.medicineName" />  </td>	
				<th width="20%">所开药品4</th>
				<td width="30%"><s:property value="userCase.MedicineId3.medicineName" />  </td>			
			</tr>
			<tr>
				<th width="20%">就诊费用</th>
				<td width="30%"><s:property value="userCase.caseFree" />  </td>		
			</tr>
			<tr>
				<th width="20%">主诉</th>
				<td colspan="3">${userCase.zhuSu}  </td>		
			</tr>
			<tr>
				<th width="20%">现病史</th>
				<td colspan="3">${userCase.nowBingShi}  </td>				
			</tr>
			<tr>
			<th width="20%">个人史</th>
				<td colspan="3">${userCase.personBingShi}  </td>	
			</tr>
			<tr>
				<th width="20%">家族史</th>
				<td colspan="3">${userCase.famailyBingShi}  </td>	
				
			</tr>
		</table>
	</div>
		
		<div class="modal-footer">
			<button type="button" class="btn btn" data-dismiss="modal">退出</button>
		
		</div>
	</div>
		

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
</script>