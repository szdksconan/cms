<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <script >
	    var context = "${pageContext.request.contextPath}";
	    var orderId="";
	    var shopNum=0;
    </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/note_pin.js"></script>

</head>
<body >
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!-- <div align="center" > <script src="index_head.js">

    </script>
</div> -->

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="../index.html" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">商品评价</span>

        <!--<div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg">
        <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span>-->
    </div>


</div>
<div class="xf_thd">
<c:forEach items="${lista}" var="list">
<input  id=orderId style="display:none;" value="${list.orderId}"></input>

	<c:forEach items="${list.cmsOrderItem}" var="lists" varStatus="status">
	<script >
		shopNum=${status.index};
    </script>
    <div style="width: 100%;border: 1px solid #dddddd;padding: 20px 0 0 20px;display: inline-block;min-height: 480px;height: auto;">
      <table >
              <tr>
              <td align="left" valign="top"> <img style="float: left;" width="160" height="160" src="../images/w1.jpg"></td>
              <td align="left" valign="top" style="padding-left: 20px">
                  <P style="font-size: 16px;width: 280px;">${lists.productTitle}</P>
                  <P style="font-weight: bold;font-size: 16px;">￥${lists.realTotal}</P>
                  <P >${lists.realTotal}</P>
                  <P >${list.orderId}地址：${list.entArea}${list.entAdress}</P>
              </td>
              <td style="padding-left:50px">

                      <div class="gradecon" >
                          <span style="float: left">宝贝与描述相符&nbsp;&nbsp;</span>
                          <ul class="rev_pro clearfix">
                              <li>

                                  <div class="revinp">
				                      <span class="level">
					                 <i name="levelSolid${status.index}" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="levelSolid${status.index}" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="levelSolid${status.index}" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="levelSolid${status.index}" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="levelSolid${status.index}" txt="" class="level_hollow" cjmark=""></i>
				                         </span>
                                      <span class="revgrade"></span>
                                  </div>
                              </li>

                          </ul>
                      </div>
                <P style="font-weight: bold">商品评价</P>
                  <P ><textarea name="Evaluatio" id="Evaluatio${status.index}" style="max-width: 580px;max-height: 200px;min-width: 580px;min-height: 200px;" placeholder="请输入您的描述和评价"></textarea></P>
                  <P ><img width="30" height="30" src="../images/geren/ge_3.png">&nbsp;晒图片&nbsp;<img width="50" height="50" src="../images/geren/ge_3.png">
                      &nbsp;<img width="50" height="50" src="../images/geren/ge_3.png">&nbsp;2/5
            <span style="float: right;margin:20px   30px 0 0;">
                <input type="radio" name="radio" id="radio" value=""> 公开

                &nbsp;
                <input  type="radio" name="radio" id="radio2" value="radio"> 匿名
            </span>
                  </P>
                  <P >数量限5张</P>
              </td>
          </tr>
      </table>
      </div>
      </c:forEach>
</c:forEach>
        <p class="h_xuline" style="display: inline-block;width: 95%; "></p>
        <div style="float: left;display: inline-block;width:350px;min-height: 150px;line-height: 28px;margin-top: 30px;">
            <P align="right" style="font-weight: bold;margin: 0 30px 0 0;">店铺动态评分</P>

        </div>

        <div style="float: left;display: inline-block;width:260px;line-height:36px;margin-top: 30px;font-size: 15px;">


                <div class="gradecon" style="width: 700px">
                    <span style="float: left">卖家的服务态度&nbsp;&nbsp;</span>
                    <ul class="rev_pro clearfix" >
                        <li style="margin-top: 10px">

                            <div class="revinp">
				                      <span class="level">
					                 <i name="orderPin1" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin1" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin1" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin1" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin1" txt="" class="level_hollow" cjmark=""></i>
				                         </span>
                                <span class="revgrade"></span>
                            </div>
                        </li>

                    </ul>
                </div>
            <div class="gradecon" style="width: 700px" >
                <span style="float: left">卖家发货的速度&nbsp;&nbsp;</span>
                <ul class="rev_pro clearfix">
                    <li style="margin-top: 10px">

                        <div class="revinp">
				                      <span class="level">
					                 <i name="orderPin2" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin2" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin2" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin2" txt="" class="level_hollow" cjmark=""></i>
					                 <i name="orderPin2" txt="" class="level_hollow" cjmark=""></i>
				                         </span>
                            <span class="revgrade"></span>
                        </div>
                    </li>

                </ul>
            </div>

        </div>
        <p class="h_xuline" style="display: inline-block;width: 95%; "></p>
        <p style="margin: 50px 0 50px 0" align="center"><a  onclick="fabuev()"  target="_self" class="btn btn-he btn-w100" type="button" >发布评论</a></p><!-- note_pin1.html -->
    </div>

</div>
<!--虚线-->




<p>&nbsp;</p>

<div align="center" >
    <script src="../index_foot.js">

    </script>
</div>

<style type="text/css">
    /* star */
    .clearfix:after{content:".";display:block;height:0;clear:both;visibility:hidden}
    .clearfix{display:inline-table}
    *html .clearfix{height:1%}
    .clearfix{display:block}
    *+html .clearfix{min-height:1%}
    .fl{float:left;}

    .gradecon{background:#ffffff;padding:0;width:320px;}
    .rev_pro li{line-height:20px;height:20px;}
    .rev_pro li .revtit{text-align:right;display:block;float:left;margin-right:10px;width:70px;}
    .revinp{float:left;display:inline;}
    .level .level_solid,.level .level_hollow{float:left;background-image:url("../images/icon2.png");background-repeat:no-repeat;display:inline-block;width:21px;height:21px;}
    .level .level_solid{background-position:0px 0px;}
    .level .level_hollow{background-position:-29px 0px;}
    .revgrade{margin-left:20px;}

</style>
<script type="text/javascript">
    var degree = ['','1级很不满意','2级不满意','3级一般','4级满意','5级非常满意','未评分'];
    //重新点评
    function addComment2(e,inid,opt,id){
        $.ajax({
            url:'/siteMessage/content',
            type:'post',
            data:'id='+id,
            dataType:'json',
            success:function(data){
                if(data.status==1){
                    var list = $('#Addnewskill_119');
                    list.eq(0).html(data.talent+'(人才ID：'+data.talentId+')');
                    list.eq(1).html(data.job);
                    list.eq(2).html(data.ms);

                    var arr = [data.total,data.expAuth,data.killAuth,data.followTime,data.formality,data.appReact];
                    var list2 = $('span.level','#Addnewskill_119');
                    $('input[name="InterviewCommentInfoSub[opt]"]').val(opt+1);
                    list2.each(function(i,v){
                        var a = '';

                        if(i>0){
                            a = 'cjmark';
                            $(v).parents('li').find('input').val(arr[i]);
                        }
                        var str = '';
                        if(arr[i]==6){
                            for(var n=0;n<=4;n++){
                                str += '<i '+a+' class="level_hollow"></i>';
                            }
                            $(v).parents('li').find('input').prop('disabled',true)
                        }else{
                            $(v).parents('li').find('input').prop('checked',true)
                            for(var n=0;n<arr[i];n++){
                                str += '<i '+a+' class="level_solid"></i>';
                            }
                            for(var n=0;n<(5-arr[i]);n++){
                                str += '<i '+a+' class="level_hollow"></i>';
                            }
                        }
                        $(v).html(str);
                        $(v).next().html(degree[arr[i]]);

                    })


                    create_show(119);
                }else{
                    ui.error(data.msg,2000);
                }
            }
        })
    }
    //提交点评
    function addComment3(){
        $.ajax({
            url:'/siteMessage/commentinterview',
            type:'post',
            data:$('form[name="comment"]').serialize(),
            dataType:'json',
            success:function(data){

            }

        })
    }

    $(function(){
        //点星星
        $(document).on('click','i[cjmark]',function(){
            var num = $(this).index();
            var pmark = $(this).parents('.revinp');
            var mark = pmark.prevAll('input');
			var iname="";
			iname=$(this).attr("name");
             $("input[name="+iname+"]").each(function() {  
            	 $(this).attr("txt","");
	        	Content+=$(this).val()+",";                       	//记录商品个数
			}); 
             $(this).attr("txt",(num+1));
             
             
            if(mark.prop('checked')) return false;

            var list = $(this).parent().find('i');
            
            for(var i=0;i<=num;i++){
            	
                list.eq(i).attr('class','level_solid');
            }
            for(var i=num+1,len=list.length-1;i<=len;i++){
                list.eq(i).attr('class','level_hollow');
            }
            $(this).parent().next().html(degree[num+1]);

        })
        //点击星星
       

    })
</script>


<script>
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
</html>