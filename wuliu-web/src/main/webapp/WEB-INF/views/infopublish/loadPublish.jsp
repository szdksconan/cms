<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
$(function() {
    $('#PlatformLogistics').click(function(){
        $.post('infopublish/updatePlatformLogistics',{"id":parent.$.modalDialog.id},function(data){
            if (data.success){
                parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                parent.$.modalDialog.handler.dialog('close');
            }else {
                alert(data.msg);
            }
        });
    });
    $('#chpp').click(function() {
        $.post('infopublish/rePublish', {
            "json": parent.$.modalDialog.json,
            "type": parent.$.modalDialog.type
        }, function (result) {
            if (result.success) {
                parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                if (result.data.rows.length == 0) {
                    alert(result.msg);
                } else {
                    openList(parent.$.modalDialog.type == 'huoyuan' ? 'cheyuan' : 'huoyuan', result.data, parent.$.modalDialog.info);
                }
                parent.$.modalDialog.handler.dialog('close');
            } else {
                alert(result.msg);
            }
        });
    });
});

</script>
<div>
    <table style="height: 100%;width: 100%">
        <tr>
            <td style="text-align: center" colspan="2">
                <span style="font-weight: bold;font-size: 18pt;">产贸送物流平台报价:<span style="color: #ff0000">100元/吨</span></span>
            </td>
        </tr>
        <tr>
            <td style="text-align: center">
                <input style="font-size: 20pt;" class="btn btn-success" type="button" value="物流平台托运" id="PlatformLogistics"/>
            </td>
            <td style="text-align: center">
                <input style="font-size: 20pt;" class="btn btn-info" type="button" value="自选物流发布货源" id="chpp" />
            </td>
        </tr>
    </table>
</div>