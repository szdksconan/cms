<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<script type="text/javascript">
var datagridParam = {
		url : '',
		striped : true,
		rownumbers : true,
		pagination : true,
		idField : 'carNo',
		sortName : 'carNo',
		sortOrder : 'asc',
		pageSize : 50,
		pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
		columns : [ [  {
			width : '120',
			title : '车牌号码',
			field : 'carNo',
			sortable : true
		},
		{
			width : '120',
			title : '车主姓名',
			field : 'carOwner',
			sortable : true
		},
		{
			width : '120',
			title : '随车电话',
			field : 'carTel'
		},{
			width : '120',
			title : '运输类型',
			field : 'carTrafficType',
			sortable : true
		},{
			width : '120',
			title : '家庭地址',
			field : 'carAddress2'
		},{
			width : '120',
			title : '定位服务',
			field : 'carLocationTag',
			formatter : function(value, row, index) {
				var str = '';
				if (value==0){
					str = "<span style='color:red'>未开通</span>";
				}
				if (value==1){
					str = "<span style='color:blue'>已开通</span>";
				}
				return str;
			}
		},{
			field : 'action',
			title : '操作',
			width : 220,
			align : 'center',
			formatter : function(value, row, index) {
				var str = '';
				if (row.carLocationTag==0){
					str += $.formatString('<a href="javascript:void(0)" onclick="openLocation(\'{0}\');" ><span style="color:red">开通定位</span></a>', row.carNo);
				}
				return str;
			}
		},] ],toolbar : '#toolbar'
};
var dataGrid;
$(function() {
	$('#tt1').tabs({
	 	border:false,
	    onSelect:function(title){
	    	id = getTabId(title);
	    	if (id==1){
	    		
	    	}else if (id==2){
	    		datagridParam.url='${ctx}/commonSenseCar/dataGrid';
	    		dataGrid = $('#dataGrid').datagrid(datagridParam);
	    	}else if (id==3){
	    		
	    	}
	    }
	});
	
	$('#locationFlag').combobox({
		panelHeight:true,
		editable:false,
		onSelect : function(){
			var carLocationTag = $(this).combobox('getValue');
			datagridParam.url='${ctx}/commonSenseCar/dataGrid?carLocationTag='+carLocationTag;
    		dataGrid = $('#dataGrid').datagrid(datagridParam);
		}
		});
});

function getTabId(title){
	var id;
	$("#queryType option").each(function(){
		if($(this).text() == title){
			id = $(this).val();
		}
	});
	return id;
}

function openLocation(no){
	alert(no);
}

</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<select id="queryType" name="queryType" style="display: none;">
			<option value="1">老司机</option>
			<option value="2">我的车</option>
			<option value="3">定位充值</option>
	</select>
	
	<div data-options="region:'north',border:false" style="height: 64px; overflow: hidden;background-color: #f4f4f4">
		<div id="tt1" class="easyui-tabs task-header-one" >
	    	<div title="老司机" style="overflow:auto;display:none;">
      		 </div>
      		 <div title="我的车" style="overflow:auto;display:none;">
      		 </div>
      		 <div title="定位充值" style="overflow:auto;display:none;">
      		 </div>
		</div>
	</div>
	
	<div data-options="region:'center',border:false" style="margin-top: 30px;">
		<table id="dataGrid" data-options="fit:true,border:false">
		</table>
	</div>
	<div id="toolbar" style="display: none;">
		<table>
			<tr>
				<td>是否开通定位：</td>
				<td>
					<select id="locationFlag" class="easyui-validatebox" data-options="panelHeight:true,editable:false">
						<option value="">全部</option>
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>