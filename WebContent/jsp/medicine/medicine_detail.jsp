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
				<th width="20%">药品分类编号</th>
				<td width="30%"><s:property value="medicine.medicineType" />  </td>	
				<th width="20%">药品名称</th>
				<td width="30%"><s:property value="medicine.medicineName" />  </td>			
			</tr>
			<tr>
				<th width="20%">药品生产日期</th>
				<td width="30%"><datefmt:writeString formatStr="yyyy-MM-dd" property="${medicine.productionDate}">
                       </datefmt:writeString>  </td>	
				<th width="20%">药品有效日期</th>
				<td width="30%"><datefmt:writeString formatStr="yyyy-MM-dd" property="${medicine.expireDate}">
                       </datefmt:writeString>   </td>			
			</tr>
			<tr>
				<th width="20%">药品库存量</th>
				<td width="30%"><s:property value="medicine.medicineStore" />  </td>	
				<th width="20%">药品供应量</th>
				<td width="30%"><s:property value="medicine.medicineSupply" />  </td>			
			</tr>
			<tr>
				<th width="20%">药品单价</th>
				<td width="30%"><s:property value="medicine.unitPrice" />  </td>	
				<th width="20%">药品销售量</th>
				<td width="30%"><s:property value="medicine.medicineSale" />  </td>			
			</tr>
			<tr>
				<th width="20%">药品供应商</th>
				<td width="30%"><s:property value="medicine.medicineSuppier" />  </td>	
				<th width="20%">药品供应商电话</th>
				<td width="30%"><s:property value="medicine.SuppierPhone" />  </td>			
			</tr>
			<tr>
				<th width="20%">药品入库人姓名</th>
				<td width="30%">${medicine.userId.name}  </td>	
				<th width="20%">药品入库时间</th>
				<td width="30%"><datefmt:writeString formatStr="yyyy-MM-dd HH:mm:ss" property="${medicine.inTime}">
                       </datefmt:writeString>  </td>			
			</tr>
			<tr>
				<th width="20%">备注</th>
				<td colspan="3">${medicine.remark}  </td>	
				
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