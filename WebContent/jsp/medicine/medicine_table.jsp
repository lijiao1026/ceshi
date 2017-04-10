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
				<a class="navbar-brand" href="#">药品数据分析</a>
			</div>
		</nav>
	</div>
	<div class="col-lg-10 col-md-10 col-lg-push-1">
		<div class="col-lg-12 col-md-12" id="container"  style="height: 400px">
		</div>	
	</div>







<!-- JavaScript -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/echarts.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/shine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/xcConfirm.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.form.js"></script>
<script type="text/javascript">
var colors=['#fb3e3e ','#593efb ','#3e97fb ','#3ed5fb ','#3efbBa ','#3fe712 ','#f1f825 ',
            '#fbc83e ','#fc9612 ','#fb3ec8','#919fdc ','#da3efb'];
	$(document).ready(function (){
          	var url = "medicine!createTable.action?time="+new Date();
	 		/*var serial= $("#serial").attr("value").trim();*/
  	 		 $.ajax({
            type: "get",//使用get方法访问后台
            dataType: "json",//返回json格式的数据
            cache:false,
            url:url,//要访问的后台地址
           // data: { serial: serial},//要发送的数据  
            success: function(msg){//msg为返回的数据，在这里做数据绑定    
            data=msg.medicineData;
            medData=data.rows;
            var medicineName=medData[0].medicineName;
            var medicineStore=medData[0].medicineStore;
            var medicineSupply=medData[0].medicineSupply;
            var medicineSale=medData[0].medicineSale;        	 
        
           option = {

             tooltip: {
                 trigger: 'axis',
                 triggerOn: 'mousemove',
             },
             grid: {
                 top: '100px',
            
          	  left:'200px',
              right: '100px', 
          
             },
             toolbox: {   //工具类显示
                 	show : true,
                 	color : ['#1e90ff','#22bb22','#4b0082','#d2691e'],
                 	feature : {
                     mark : {show: true},
                     magicType:{type:['line','bar','stack']},
                     dataZoom : {show: true,yAxisIndex: false},
                     dataView : {show: true, readOnly: false},
                restore : {show: true},
                /*    brush: {
                             type: ['lineX', 'clear']
                         }, */
                     saveAsImage : {show: true}
                 }
             },
              /*    brush: {
                     xAxisIndex: 'all',
                     brushLink: 'all',
                     outOfBrush: {
                         colorAlpha: 0.1,
                     },
                     brushStyle:{
                     color:'#F2F2F2', 
                     borderColor: '#FA8072',
                     }
                 },  */
            dataZoom : [
                /*  {
                 type: 'slider',
                 show : true,
                 realtime: true,
                 start : 0,
                 end : 50,
                 }, */
                 {
                 type: 'inside',
                 start: 0,
                 end: 100,
                 },     
            ],
          legend: {
             	show:true,
           		top : '10%',
             
             
                 data:['库存量','供应量','销售量']
             }, 
              color:colors,
             xAxis: [
                 {
                     type : 'category',
                     boundaryGap : true,//控制是否显示所有x轴数据，false使得起点在Y轴上
                     axisTick: {onGap:false},
                     splitLine: {show:false},
                   /*   axisLabel : {
                         formatter: '{value} ms'
                     },  */
                     data :medicineName
                 }
             ],
             
             yAxis:[
                    {
                        type : 'value',
                        name : '库存量',
                        nameRotate : 15,
                        scale:true,
                        position: 'left',
                        offset:0,
                       axisLine:{
                            lineStyle:{
                                color:colors[0],
                            }
                        }, 
                    }, 
                    {
                        type : 'value',
                        name : '供应量',
                        nameRotate : 15,
                        scale:true,
                        position: 'left',
                        offset:60,
                        axisLine:{
                            lineStyle:{
                                color:colors[1],
                            }
                        },
                    }, 
                    {
                        type : 'value',
                        name : '销售量',
                        nameRotate : 15,
                        scale:true,
                        position: 'left',
                        offset:120,
                        axisLine:{
                            lineStyle:{
                                color:colors[2],
                            }
                        },
                    }, 
                    ], 
             
             series:[
                     {
                         name:'库存量',
                         type:'line',
                         smooth:true,       
                         data:medicineStore,
                      /*   markPoint : {
                             symbol: 'emptyPin',
                             itemStyle : {
                                 normal : {
                                     color:'#1e90ff',
                                     label : {
                                         show:true,
                                         position:'top',
                                       
                                     }
                                 }
                             },
                             data : [
                                 {type : 'max', name: '最大值', symbolSize:5},
                                 {type : 'min', name: '最小值', symbolSize:5}
                             ]
                         },
                         markLine : {
                             symbol : 'none',
                             itemStyle : {
                                 normal : {
                                     color:'#1e90ff',
                                     label : {
                                         show:true,
                                        
                                     }
                                 }
                             },
                             data : [
                                 {type : 'average', name: '平均值'}
                             ]
                         } */
                     },
                     {
                         name:'供应量',
                         type:'line',
                         yAxisIndex: 1,
                         smooth:true,
                         data:medicineSupply,
                     },
                     {
                         name:'销售量',
                         type:'line',
                         yAxisIndex: 2,
                         smooth:true,
                         data:medicineSale,
                     }
                     ],
         }; 
           myChart.setOption(option);
 		},  
  	}); 
 	
  }); 
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom,'shine');
	

</script>
</body>
</html>