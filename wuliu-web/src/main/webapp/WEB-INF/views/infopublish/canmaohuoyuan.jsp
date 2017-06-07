<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>发布货源</title>
<script type="text/javascript">
$(function() {

    $('#packageType1').combobox({
        url: 'common/getGoodsDicInfoList?pid=20',
        mode: 'remote',
        valueField:'id',
        textField:'name',
        panelHeight:true,
        editable:false,
        onHidePanel:function(){

        },
        onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            for (var item in val[0]) {
                if (item == "id") {
                    $(this).combobox("select", val[0][item]);
                }
            }
        }
    });

    $('#btn_1').click(function(){
        alert("信息已发送物流平台！");
    });

	$('#btn_2').click(function(){
        var str = "packageType="+$('#packageType1').combobox('getValue')+"&goodsName="+encodeURI(encodeURI($('#goodsName').val()))+
        "&weight="+$('#weight').val()+"&volume="+$('#volume').val()+"&tel="+$('#tel').val();
        $.modalDialog({
            title : '添加',
            width : 1400,
            height : 700,
            href : 'infopublish/loadHuoyuan?'+str
        });
	});
});

</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false" >
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
			<form id="huoyuanForm" method="post" >
				<table class="grid">
					<tr>
						<td>包装类型</td>
						<td>
							<select class="easyui-combobox" id="packageType1" name="packageType" style="width:100px">
                            </select>
						</td>
						<td>货物名称</td>
						<td>
							<input class="form-control" id="goodsName" name="goodsName" type="text" placeholder="" value="橘子"/>
						</td>
					</tr>
					<tr>
						<td>重量</td>
						<td>
							<input class="form-control" id="weight" name="weight" type="text" value="30"/>
						</td>
						<td>体积</td>
						<td>
							<input class="form-control" id="volume" name="volume" type="text" value="30"/>
						</td>
					</tr>
					<tr>
						<td>联系电话</td>
						<td>
							<input class="form-control" id="tel" type="text" name="tel" value="18600967102"/>
						</td>
						<td>物流方式</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
                            <input type="button" id="btn_1" value="物流平台" style="width: 20%"/>
                            <input type="button" id="btn_2" value="市场选择物流" style="width: 20%"/>
                        </td>
					</tr>
				</table>
			</form>
		</div>
	</div>
    <div id="div_1" style="display: none;">

    </div>
</body>
</html>