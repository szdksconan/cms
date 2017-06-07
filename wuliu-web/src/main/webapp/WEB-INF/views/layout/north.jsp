<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

    <div class="navbar">
	  <div class="navbar-inner">

		<ul class="nav">
		  <li class="active"><a href="#" onclick="changeDiv('infohall/infohall')" data-toggle="tab">信息中心</a></li>
            <li><a href="#" onclick="changeDiv('infopublish/infopublish')" >发布信息</a></li>
            <li><a href="#" onclick="changeDiv()" >在线车辆</a></li>
            <li><a href="#" onclick="changeDiv()" >我的车库</a></li>
            <li><a href="#" onclick="changeDiv()" >我要投保</a></li>
            <li><a href="#" onclick="changeDiv()" >物流名片</a></li>
            <li><a href="#" onclick="changeDiv()" >身份验证</a></li>
            <li><a href="#"  data-toggle="tab" onclick="changeDiv('vaservice/vaserviceList')">套餐服务</a></li>
      
			</ul>
	  </div>
	</div>
<script type="text/javascript">
	function BackOrder(){
		$('#order').css('color','blue');
		$('#expert').css('color','black');
		$('#rate').css('color','black');
		$('#center').panel('refresh','order.do?f=list');
	}
	function Expert(){
		$('#order').css('color','black');
		$('#expert').css('color','blue');
		$('#rate').css('color','black');
		$('#center').panel('refresh','expert.do?f=list');
	}
	function Rate(){
		$('#order').css('color','black');
		$('#expert').css('color','black');
		$('#rate').css('color','blue');
		$('#center').panel('refresh','rate.do?f=list');
	}
	
</script>

