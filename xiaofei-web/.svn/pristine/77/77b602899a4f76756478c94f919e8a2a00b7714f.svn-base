$(document).ready(function() {
	
	var servNLhtml="";
	var shopJJhtml="";
	var zizhixinxihtml="";
	var zuobiao="";
	/*$.ajax({
			url:"/shopData/getQualif",
			data:{"id":3},
			dataType:"json",
			type:"post",
			success:function(data){
				//alert(data.Qualif.imageType);
				$.each(data.Qualif,function(i,n){
					alert(n.imageType);
				});
		        
		        
		        
			}
		});*/
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var shopId=GetQueryString("shopId");
	//var shopId=23;
	
	var barhtml="";
	barhtml+="<ul>";
	barhtml+=" <li >";
	barhtml+="<a href=\"dianx.jsp?shopId="+shopId+"\" target=\"_self\">店铺首页</a>";
	barhtml+=" </li>";
	barhtml+="<li>";
	barhtml+=" <a href=\"zmu.jsp?shopId="+shopId+"\" target=\"_self\" >商品</a>";
	barhtml+="</li>";
	barhtml+="<li>";
	barhtml+=" <a href=\"javascript:void(0);\" target=\"_self\" >招募信息</a>";
	barhtml+="</li>";
	barhtml+="<li >";
	barhtml+="<a href=\"dian_xinxi.jsp?shopId="+shopId+"\" target=\"_self\" class=\"active\"> 店铺信息</a>";
	barhtml+="</li>";
	barhtml+=" </ul>";
	$("#bar").html(barhtml);
	
	$.ajax({
		url:context+"/shopData/getServInfo",
		data:{"id":shopId},
		dataType:"json",
		type:"post",
		success:function(data){
			zuobiao=data.EnterpriseToOutBean.enterpriseInfo.regAddAl;
			$.each(data.EnterpriseToOutBean.networks,function(i,n){
				var region;
				if(n.region!=null)
					 region="服务区域："+n.region;
		        if(n.type==1&&n.description!=null){
		        	servNLhtml+=" <span class=\" xf_dianv \">";
		        	servNLhtml+="商品配送 <br/>";
		        	servNLhtml+=n.description+"<br/>";
					servNLhtml+=region;
					servNLhtml+="  </span>";
		        }else if(n.type==2&&n.description!=null){
		        	servNLhtml+=" <span class=\" xf_dianv \">";
		        	servNLhtml+="商品安装 <br/>";
		        	servNLhtml+=n.description+"<br/>";
					servNLhtml+=region;
					servNLhtml+="  </span>";
		        }else if(n.type==3&&n.description!=null){
		        	servNLhtml+=" <span class=\" xf_dianv \">";
		        	servNLhtml+="商品维修 <br/>";
		        	servNLhtml+=n.description+"<br/>";
					servNLhtml+=region;
					servNLhtml+="  </span>";
		        }else if(n.type==4&&n.description!=null){
		        	servNLhtml+=" <span class=\" xf_dianv \">";
		        	servNLhtml+="仓库服务 <br/>";
		        	servNLhtml+=n.description+"<br/>";
					servNLhtml+=region;
					servNLhtml+="  </span>";
		        }
				
	        });
			
			
			/*servNLhtml="";
			servNLhtml+="<span class=\"xf_dianv\">";
			servNLhtml+="商品配送<br/>";
			servNLhtml+="提供商品送货上门服务 覆盖范围成都市主城区及";
			servNLhtml+="龙泉、双流<br/>";
			servNLhtml+="说明：距离店铺2公里范围内，配送时间 09：00";
			servNLhtml+="-21：00。";
			servNLhtml+="  </span>";
			servNLhtml+=" <span class=\" xf_dianv \">";
			servNLhtml+="上门安装 <br/>";
			servNLhtml+="提供商品上门安装服务  覆盖范围成都市主城区<br/>";
			servNLhtml+="说明：有专业安装人员。";
			servNLhtml+=" </span>";*/
			
			$("#servNL").html("");
			$("#servNL").html(servNLhtml);
			
			shopJJhtml+="<div class=\"xf_cplab\">";
			shopJJhtml+="<span>店铺简介</span>";
			shopJJhtml+=" </div>";
			shopJJhtml+=" <div  class=\"xf_diann\">";
			shopJJhtml+=data.EnterpriseToOutBean.enterpriseInfo.briefIntroduction;
			shopJJhtml+=" </div>";
	        
	        $("#shopJJ").html("");
	        $("#shopJJ").html(shopJJhtml);
	        
	        
	        zizhixinxihtml+="<div id=\"demo01\" class=\"flexslider\" style=\"width: 199px;height:300px;\">";
	        zizhixinxihtml+="<ul class=\"slides\">";
	        var ij=0;
	        $.each(data.EnterpriseToOutBean.enterQualifs,function(i,n){
		        $.each(n.images,function(j,m){
		        	/*ij为图片显示张数   只显示5张图片*/
		        	if(m.path!=null)
		        	ij++;
		        	if(ij<6&&m.path!=null)
		        		zizhixinxihtml+="<li ><div ><img id="+ij+" width=\"199\" name='"+n.name+"' time='"+n.validTime+"' height=\"241\"  src=\""+m.path+"\"  /></div></li>";
		       
		        });
	        });
	        zizhixinxihtml+="</ul></div>";
	        	zizhixinxihtml+="<table width=\"350\" border=\"0\">";
		        zizhixinxihtml+="<tr>";
		        zizhixinxihtml+="  <td width=\"85\" align=\"right\">&nbsp;</td>";
		        zizhixinxihtml+="  <td width=\"255\">&nbsp;</td>";
		        zizhixinxihtml+=" </tr>";
		        /*zizhixinxihtml+=" <tr>";
		        zizhixinxihtml+="   <td align=\"right\"> 有效期 : </td>";
		        zizhixinxihtml+="   <td>validTime</td>";
		        zizhixinxihtml+="  </tr>";
		        zizhixinxihtml+=" <tr>";*/
		        zizhixinxihtml+="  <td align=\"right\" valign=\"top\">经营范围 :</td>";
		        zizhixinxihtml+="  <td>"+data.EnterpriseToOutBean.enterpriseInfo.businessScope+"</td>";
		        zizhixinxihtml+=" </tr>";
		        zizhixinxihtml+=" <tr>";
		        zizhixinxihtml+="   <td align=\"right\" valign=\"top\">主营商品 :</td><td>";
		        
		        var obj = JSON.parse(data.EnterpriseToOutBean.enterpriseInfo.product); 
		        $.each(obj,function(i,m){
		        	//alert(m.name);
		        	zizhixinxihtml+=m.name+"  &nbsp; &nbsp; &nbsp;";
		        });
		        zizhixinxihtml+=" </td></tr>";
		        zizhixinxihtml+="</table>";
		        $("#zizhixinxi").html("");
		        $("#zizhixinxi").html(zizhixinxihtml);
	        
	        
	        //manaAddAl
	        $("#address").html("经营场址：<br/>"+data.EnterpriseToOutBean.enterpriseInfo.manaAddAc);
	        
	        $(function(){

		        $('#demo01').flexslider({
		            animation: "slide",
		            direction:"horizontal",
		            easing:"swing"
		        });

		        $('#demo02').flexslider({
		            animation: "slide",
		            direction:"vertical",
		            easing:"swing"
		        });
		       
		    });
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
	        
	        
		    
		    
		 
		    /*地图数据*/
		 // JavaScript Document
			var sContent = "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>"+data.EnterpriseToOutBean.enterpriseInfo.name+"</h4>" +
				"<div style='margin:140;float:right;'><p style='margin:0;line-height:1.5;font-size:13px'>地址:"+data.EnterpriseToOutBean.enterpriseInfo.manageDetail+"</br>邮编:"+data.EnterpriseToOutBean.enterpriseInfo.postcode+"<br />联系人:"+data.EnterpriseToOutBean.enterpriseInfo.contactPerson+"<br />联系方式:"+data.EnterpriseToOutBean.enterpriseInfo.contactTel+"<br /></p></div>" +
				"</div>";
			var map = new BMap.Map("allmap");
			var arrzuobiao = data.EnterpriseToOutBean.enterpriseInfo.regAddAl.split(',');
			var point = new BMap.Point(arrzuobiao[0], arrzuobiao[1]);    /*经纬度*/
			var marker = new BMap.Marker(point);
			var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
			map.centerAndZoom(point, 15);
			map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
			map.addControl(new BMap.NavigationControl({ anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL }));  //右上角，仅包含平移和缩放按钮
			map.addControl(new BMap.NavigationControl({ anchor: BMAP_ANCHOR_BOTTOM_LEFT, type: BMAP_NAVIGATION_CONTROL_PAN }));  //左下角，仅包含平移按钮
			map.addControl(new BMap.NavigationControl({ anchor: BMAP_ANCHOR_BOTTOM_RIGHT, type: BMAP_NAVIGATION_CONTROL_ZOOM }));  //右下角，仅包含缩放按钮
			map.addOverlay(marker);
			marker.addEventListener("click", function () {
				this.openInfoWindow(infoWindow);
				//图片加载完毕重绘infowindow
				//document.getElementById('imgDemo').onload = function () {
				//    infoWindow.redraw();
				//}
			});
			marker.openInfoWindow(infoWindow);
		    
		    
		    
		    
	        
		}
		
		
		
	});
	
		
		
		
		

	
	 
	


	
})