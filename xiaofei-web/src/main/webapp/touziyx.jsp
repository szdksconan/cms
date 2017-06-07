<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
</head>
<body>
<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">投资意向选择</span>

    </div>


</div>




<!--  zhuyao主要-->
<div class="xf_thd">
    <div  style="height: 500px;width:598px;display: inline-block;float: left;padding: 120px  0 0 20px;">
        <table>

            <tr>
                <td rowspan="2" valign="middle"> <img src="${pageContext.request.contextPath}/images/geren/shan_y1.jpg" width="290" height="160"  > </td>
                <td><P style="font-size: 18px;margin: 0 0 0 20px;" >点击下方的申请成为贸易商按钮</P>
                    <p style="font-size: 14px;margin: 20px 0 0 20px; " >申请成为贸易商，您的申请信息会推送给相应的生产商，由生产商和您之间具体去洽谈合作计划。</p>
                </td>
            </tr>

            <tr >
                <td>
                    <p style="font-size: 14px;margin: 20px 0 0 20px; " >
                    <a href="f_w/kaidian_x3_1.jsp" target="_self" class="btn btn-he btn-w150" type="button">申请成为贸易商</a>
                    </p>
                </td>
            </tr>

        </table>
    </div>
    <div  style="height: 500px;width:598px;display: inline-block;float: left;padding: 120px  0 0 20px;">
        <table>

            <tr>
                <td rowspan="2" valign="middle"> <img src="${pageContext.request.contextPath}/images/geren/shan_y2.jpg" width="290" height="160"  > </td>
                <td><P style="font-size: 18px;margin: 0 0 0 20px;" >点击下方的申请成为物流商按钮</P>
                    <p style="font-size: 14px;margin: 20px 0 0 20px; " >申请成为贸易商，您的申请信息会推送给相应的平台物流组，由物流组和您之间具体去洽谈合作计划。</p>
                </td>
            </tr>

            <tr >
                <td>
                    <p style="font-size: 14px;margin: 20px 0 0 20px; " >
                        <a href="index_kd1.jsp" target="_self" class="btn btn-he btn-w150" type="button">申请成为物流商</a>
                    </p>
                </td>
            </tr>

        </table>
    </div>

  </div>



<!-- 底部-->
<div align="center" style="position: fixed;left: 0;right: 0;bottom: 0;">
    <script src="index_foot.js">

    </script>
</div>

</body>

</html>