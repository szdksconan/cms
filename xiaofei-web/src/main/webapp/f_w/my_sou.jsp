<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/my_sou.js"></script>
</head>
<body style="z-index: 0">
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">个人中心</span>
        
    </div>
    
</div>
<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="height: 146px;border: 0;padding-top: 6px;z-index: 2;">
<p>
<img src="${pageContext.request.contextPath}/images/geren/ge_1.jpg">
</p>
</div>

<!--  zhuyao主要-->
<div class="xf_thd" >
    <div class="xf_tongjiz">
      <p  class="ge_rentou"><img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/>
      天涯客户111
      </p>
        <ul style="margin-top: 80px;">
            <Li ><a href="${pageContext.request.contextPath}/f_w/note.jsp" target="_self">订单管理></a>
            </Li>
            <Li  >
                <a href="${pageContext.request.contextPath}/gouc.jsp" target="_self"> 我的购物车></a>
            </Li>
            <Li  > <a href="${pageContext.request.contextPath}/f_w/kaidian.jsp" target="_self">创业申请></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/dingzhi.jsp" target="_self">我的定制></a>
            </Li>
            <Li class="active">
                <a href="${pageContext.request.contextPath}/f_w/my_sou.jsp" target="_self">我的收藏></a>
            </Li>
            <Li > <a href="${pageContext.request.contextPath}/f_w/dizi.jsp" target="_self">地址管理></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/my_message.jsp" target="_self">我的消息></a>
            </Li>
            <Li ><%-- <a href="${pageContext.request.contextPath}/f_w/money.jsp" target="_self">资金管理></a> --%>
            </Li>
            <Li >
                <%-- <a href="${pageContext.request.contextPath}/f_w/zhanghu.jsp" target="_self">账户信息></a> --%>
            </Li>
            <Li > <%-- <a href="${pageContext.request.contextPath}/f_w/tui.jsp" target="_self">退换货管理></a> --%>
            </Li>

        </ul>


    </div>
    <div class="xf_tongjiy ge_ren"  >
        <!--  2排序-->
        <div class="cfw_x" style="padding: 20px  0  20px  20px">
            <!--  右边搜索框-->
            <span> <a   class="btn btn-hu btn-w80" type="button" style="width: 55px;height: 32px;padding-top: 6px;margin: 0 0 20px 5px ;float: right;font-size: 13px;" >搜索</a></span>
            <div class="xf_sou1 fl" style="border: 1px solid #dddddd;width: 150px;margin:0 0 0 0;height: 32px;padding-top: 4px;float: right;"> <input type="text" class="xf_input" value=""  style="width: 120px;border: 0;" />
                <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
            </div>
            <!-- 左边切换-->
            <ul class="nav nav-tabs" role="tablist" id="tab-list">
                <li class="active"><a href="#cfw_c1" onclick="loading_OK(1,4);" role="tab" data-toggle="tab">商品收藏</a></li>
                <li ><a class="xin_2_2" href="#cfw_can1" onclick="store_OK(1,2);" role="tab" data-toggle="tab">贸易商收藏</a></li>
            </ul>

            <div class="tab-content" style="border: 0">
                <!--基本信息-->
                <div class="tab-pane active" id="cfw_c1">
                    
                     <div class="xin_2">
                         <table class="table1 mt10" style="font-size: 15px;border: 0;" id="tablight" onclick="setColor();">
                             <thead>
                             <tr>

                                 <th ></th>
                                 <th >商品</th>
                                 <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                 <th >操作</th>

                             </tr>
                             </thead>
                             <tbody class="sc_user_all_info">
                             
                             </tbody>
                         </table>
                         <!-- 结算-->
                         
                     </div>
                </div>
                <!--企业信息-->
                <div class="tab-pane" id="cfw_can1">

                        <table class="table1 mt10" style="font-size: 15px;border: 0;" >
                            <thead>
                            <tr>

                                <th >店铺 </th>
                                <th >&nbsp;</th>
                                <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                 <th >&nbsp;</th>
                                <th width="80">操作</th>

                            </tr>
                            </thead>
                            <tbody class="sc_user_all_store_info">
                            
                            <%-- <tr>
                                <td colspan="7" > <input type=checkbox name=All onclick="checkAll('mm')" class="fl"/>
                                    &nbsp;商家： 塗月CCPAO</td>
                            </tr>
                            <tr>
                                <td width="150"><input type=checkbox name=mm onclick="checkItem('All')" class="g_inp"/>   <img width="106" height="106" src="${pageContext.request.contextPath}/images/lll.jpg"></td>
                                <td width="790">
                                    <div>
                                        <p>坚果旗舰店&nbsp; </p>
                                        <p><img src="${pageContext.request.contextPath}/images/xinxin.jpg">4.1 </p>
                                        <p>联系方式：028-56566565</p>
                                        <p>所  在  地：四川成都高新区-城市里路-135号</p>
                                    </div>
                                </td>

                                <td width="50"> <a href="javascript:;" class="red" onclick='{if(confirm("确定要删除?")) {deleteCurrentRow(this); }else {}}'>删除</a>

                                </td>

                            </tr> --%>
                            </tbody>
                        </table>

                    <div class="xf_thd">
                        <!-- <div class="xf_cxlabel" style="width: 990px">
                            <span style="width:280px;float: left;margin: 5px 0 0 -15px;" ><input style="margin-left:-10px"  onclick="selectAll()" type="checkbox"   name="All" style="controlAll" id="controlAll" onclick="checkAll(mm)" />&nbsp;全部&nbsp;<a class="orange" >删除选中的商品&nbsp;移至购物车</a></span>
                        </div> -->
                    </div>
                </div>

            </div>
        </div>

    </div>
    </div>

<!-- fenye分页-->
<div class="xf_chatu" align="center">
    <div class="pagination" id="page_home"></div>
</div>
<!---->
<div class="xf_chatu">
   &nbsp;
</div>
    </div>
<!-- 底部-->
<div align="center" >
    <script src="../index_foot.js">

    </script>
</div>


<script>
    function selectAll(){
        var checklist = document.getElementsByName ("All");
        if(document.getElementById("controlAll").checked)
        {
            for(var i=0;i<checklist.length;i++)
            {
                checklist[i].checked = 1;
                checkAll('mm');
                checkAll('mm2');
            }
        }else{
            for(var j=0;j<checklist.length;j++)
            {
                checklist[j].checked = 0;
                checkAll('mm');
                checkAll('mm2');
            }
        }
    }

    {
        var a = document.getElementsByName(str);
        var n = a.length;
        alert(a);
        alert(a);
        for (var i=0; i<n; i++)
            a[i].checked = window.event.srcElement.checked;
    }
</script>

<SCRIPT LANGUAGE="JavaScript">

    function checkAll(str)
    {
        var a = document.getElementsByName(str);
        var n = a.length;
        for (var i=0; i<n; i++)
            a[i].checked = window.event.srcElement.checked;
    }
    function checkItem(str)
    {
        var e = window.event.srcElement;
        var all = eval("document.all."+ str);
        if (e.checked)
        {
            var a = document.getElementsByName(e.name);
            all.checked = true;
            for (var i=0; i<a.length; i++)
            {
                if (!a[i].checked)
                {
                    all.checked = false; break;
                }
            }
        }
        else
            all.checked = false;
    }
</SCRIPT>
<script type="text/javascript">
    function Goto(){}
    function deleteCurrentRow(obj){
        var tr=obj.parentNode.parentNode;
        var tbody=tr.parentNode;
        tbody.removeChild(tr);
    }
</script>
<script>
    /* $(".xin_2").hide();
    $(".xin_1_1").click(function(){
        $(".xin_1").hide();
        $(".xin_2").show();
    });
    $(".xin_2_2").click(function(){
        $(".xin_2").show();
        $(".xin_1").hide();
    }); */

    function deltr() {
        $(this).hide();
    }


    $('.xf_cl').hide();
    $("input").each(function(){
        $(this).focus(function(){
            if( $(this).val() == $(this).get(0).defaultValue ){
                $(this).val("");
                $('.xf_cl').show();
            }
        });
        $(this).blur(function(){
            if( $(this).val() == "" ){
                $(this).val( $(this).get(0).defaultValue );
                $('.xf_cl').hide();
            }
        })
    });

    $(".xf_tsouy div img").click(function(){
        $(this).hide();
        $(".xf_input").val( $(this).get(0).defaultValue );
    });

</script>

</body>
</html>