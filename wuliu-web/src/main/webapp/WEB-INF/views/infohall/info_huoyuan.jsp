<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		$('#info').val('${map.info}');
		var silver=5;
		var cuprum=10;
		var createTime=new Date('${map.createTime}'.replace("-","/"));
		createTime.setMinutes(createTime.getMinutes() + silver, createTime.getSeconds(), 0);
		clearTimeout(cdst);
		count_down(createTime.Format("yyyy-MM-dd hh:mm:ss"));
	});

    function call(tel){
        $('#div_time').show();
    }

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<table class="table">
		<tr>
			<td>
				发布时间<input class="form-control" value="${map.createTime}" readonly="readonly"/>
			</td>
			<td rowspan="5">
				<img id="carImg" width="200" height="200" alt="货物图片" src="${map.goodsImg}" onerror="javascript:this.src='http://pic17.nipic.com/20111109/8056482_004804322000_2.jpg';"/>
			</td>
		</tr>
		<tr>
			<td>
				货物名称<input class="form-control" value="${map.goodsName}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>
				包装类型<input class="form-control" value="${map.packageTypeName}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>
				公司名称<input class="form-control" value="${map.companyName}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>
				吨位<input class="form-control" value="${map.weight}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td>
				体积<input class="form-control" value="${map.volume}" readonly="readonly"/>
			</td>
			<td rowspan="2">
<%-- 				<a href="javascript:void(0)" onclick="CallTel('${map.tel}+${map.tel1}+${map.tel2}','${map.id}','huoyuan')" <c:if test="${map.viewflag}">style="display:none;"</c:if>>拨打电话</a> --%>
			</td>
		</tr>
		<tr>
			<td>
				线路<input class="form-control" value="${map.way}" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				详情<textarea id="info" style="width: 100%;height: 100%;"  readonly="readonly"></textarea>
			</td>
		</tr>
	</table>
    <div id="div_time" style="display: none;">
        <h1>${map.tel}+${map.tel1}+${map.tel2}</h1>
        <div id="countdown">

        </div>
    </div>
    <%--<input type="button" value="确认信息" id="infoconfirm" onclick="infoconfirm()" <c:if test="${map.state!='1'}">style="display: none;" </c:if>/>--%>
</div>
