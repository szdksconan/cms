$(document).ready(function() {
	success_OK();
})

function success_OK(){
	if(userid!=""){
		$.ajax({
			url:context+"/addr/select_user_address?uId="+userid,
			type:"get",
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$(".addr_info_user").html("");
				$.each(data.listData,function(i,n){
					html+="<div class=\"xf_gekaid\" style=\"font-size: 13px;\">";
					html+="<div class=\"xf_gerendi\">";
					if(n.aStates==1){
						html+="&nbsp;<i class=\"fa fa-check-circle active\" aria-hidden=\"true\"></i>&nbsp;";
						html+="默认地址 <span style=\"float: right;cursor: pointer;\">";
					}else{
						html+="&nbsp;<i class=\"fa fa-check-circle\" aria-hidden=\"true\"></i>&nbsp;";
						html+="默认地址 <span style=\"float: right;cursor: pointer;\">";
					}
					html+="<a class=\"eadit_btn\" data-toggle=\"modal\"  data-target=\"#myModal\">编辑</a>&nbsp;";
					html+="<span style=\"cursor: pointer\" onclick=\"del_Ok('"+n.addrId+"');\">删除</span>&nbsp;</span>";
					html+="<input type=\"text\" class=\"adr_id\" value="+n.addrId+" style=\"display: none;\"></div>";
					html+="<p class=\"contactname\" style=\"font-size: 22px;margin-top: 20px;\">"+n.contactName+"</p>";
					html+="<p class=\"address\">"+n.addressProvince+"-"+n.addressCity+"-"+n.addressCounty+"</p>";
					html+="<p class=\"xxaddess\">"+n.addressDetail+"</p>";
					html+="<p class=\"ybnum\">"+n.postCode+"</p>";
					html+="<P>电话:<span  class=\"tel\">"+n.aPhone+"</span></P>";
					html+="</div>";
				});
				$(".addr_info_user").append(html);
				/*点击编辑额，获取地址详情并赋值给弹窗input*/				
				$(".eadit_btn").click(function(){
					var name=$(this).parents(".xf_gekaid").find(".contactname").text();//姓名
					var address=$(this).parents(".xf_gekaid").find(".address").text();//地区
					var xxaddress=$(this).parents(".xf_gekaid").find(".xxaddess").text();//详细地址
					var ybnum=$(this).parents(".xf_gekaid").find(".ybnum").text();//邮编
					var tel=$(this).parents(".xf_gekaid").find(".tel").html();//电话
					var id=$(this).parents(".xf_gekaid").find(".adr_id").val();//电话
					
					$(".update_model .user_input2").val(name);
					$(".update_model .city_input2").val(address);
					$(".update_model .jd_input2").val(xxaddress);
					$(".update_model .yznum2").val(ybnum);
					$(".update_model .tel_input2").val(tel);
					$(".update_model .id_input2").val(id);
					
				})
				$("div.holder").jPages({
					containerID: "addr_info_user",
					perPage: 6
				});
			}
		})
	}
}

function del_Ok(id){
	if(confirm("确认删除吗")){
		if(id!=null&&id!=""){
			$.ajax({
				url:context+"/addr/deleteOderByIdGetUser?id="+id,
				type:"get",
				contentType : "application/jsonp",
				dataType:"jsonp",
				jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
				jsonpCallback:"cms_2_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
				success:function(data){
					alert("删除成功");
					refresh();
				}
			})
		}else{
			alert("删除失败!");
		}
	}else{
		return;
	}
}

/*function update_dz_btn(){
	var name = $(".update_model .user_input2").val();
	var address = $(".update_model .city_input2").val();
	var xxaddress = $(".update_model .jd_input2").val();
	var ybnum = $(".update_model .yznum2").val();
	var tel = $(".update_model .tel_input2").val();
	alert("名称："+name+"地址："+address+"街道："+xxaddress+"邮编："+ybnum+"联系："+tel);
}*/

function refresh(){
	window.location.reload();//刷新当前页面.
}

var ok1=false;
var ok2=false;
var ok3=false;
var ok4=false;
var ok5=false;
//姓名
function user_input(){
	if($(".user_input").val()==null||$(".user_input").val()==""){
		$(".user_input_lable").removeClass("hide");
	    $(".user_input_lable").html("请输入姓名");
	    ok1=false;
	}else{
		var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
		 if(names.test(($(".user_input").val()))){
             $(".user_input_lable").addClass("hide");
           ok1=true;
         }else{
            $(".user_input_lable").removeClass("hide");
            $(".user_input_lable").html("姓名输入有误");
            ok1=false;
          }
	}
}
//地区
function city_input(){
	 if($(".city_input").val()==null||$(".city_input").val()==""||$(".city_input").val()=="请选择地区"){
			$(".city_input_lable").removeClass("hide");
			 ok2=false;
			}else{
				$(".city_input_lable").addClass("hide");
				ok2=true;
			}
}
//街道地址
function jd_input(){
	 if($(".jd_input").val()==null||$(".jd_input").val()==""){
		$(".jd_input_lable").removeClass("hide");
		 ok3=false;
		}else{
			$(".jd_input_lable").addClass("hide");
			ok3=true;
		}
}
//邮政编码
function yznum(){
	  if($(".yznum").val()==null||$(".yznum").val()==""){
			$(".yznum_lable").removeClass("hide");
		    $(".yznum_lable").html("请输入邮编");
		    ok4=false;
		}else{
			var yznums=  /^[1-9][0-9]{5}$/;
			 if(yznums.test(($(".yznum").val()))){
                 $(".yznum_lable").addClass("hide");
              ok4=true;
             }else{
                $(".yznum_lable").removeClass("hide");
                $(".yznum_lable").html("邮编开头不能为0，共6位");
                ok4=false;
              }
		}
}
//电话号码
function  tel_input(){
	  if($(".tel_input").val()==null||$(".tel_input").val()==""){
			$(".tel_input_lable").removeClass("hide");
			$(".tel_input_lable").html("请输入手机号");
			 ok5=false;
		}else{
			var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
			 if(tel_zz.test(($(".tel_input").val()))){
                $(".tel_input_lable").addClass("hide");
               ok5=true;
            }else{
               $(".tel_input_lable").removeClass("hide");
               $(".tel_input_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
               ok5=false;
           }
		}
  }

//新增地址
function add_dz_btn(){
	user_input();
	city_input();
	jd_input();
	yznum();
	tel_input();
	if(ok1&&ok2&&ok3&&ok4&&ok5){
		/*alert("通过");
		//添加属性  data-dismiss="modal"  关闭弹窗 
	  $(".add_dz_btn").attr("data-dismiss","modal");*/
		var name = $(".user_input").val();
		var provinceName = $("#hcity").val();
		var regionName = $("#hproper").val();
		var cityName = $("#harea").val();
		var det = $(".jd_input").val();
		var yb = $(".yznum").val();
		var tel = $(".tel_input").val();
		if(userid!=""){
			$.ajax({
				url:context+"/addr/addUserAddress",
				type:"post",
				data:{contactName:name,addressProvince:provinceName,addressCity:regionName,addressCounty:cityName,
					addressDetail:det,postCode:yb,aPhone:tel},
				dataType:"json",
				success:function(data){
					refresh();
				}
	  		})
		}else{
			window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
		}
	}else{
		//取消关闭弹窗
		 $(".add_dz_btn").attr("data-dismiss","");    
		alert("未通过");
	}
}

var ok11=false;
var ok12=false;
var ok13=false;
var ok14=false;
var ok15=false;
//姓名
function user_input2(){
	if($(".user_input2").val()==null||$(".user_input2").val()==""){
		$(".user_input_lable2").removeClass("hide");
	    $(".user_input_lable2").html("请输入姓名");
	    ok11=false;
	}else{
		var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
		 if(names.test(($(".user_input2").val()))){
             $(".user_input_lable2").addClass("hide");
           ok11=true;
         }else{
            $(".user_input_lable2").removeClass("hide");
            $(".user_input_lable2").html("姓名输入有误");
            ok11=false;
          }
	}
}
//地区
function city_input2(){
	 if($(".city_input2").val()==null||$(".city_input2").val()==""||$(".city_input2").val()=="请选择地区"){
			$(".city_input_lable2").removeClass("hide");
			 ok12=false;
			}else{
				$(".city_input_lable2").addClass("hide");
			ok12=true;
			}
}
//街道地址
function jd_input2(){
	 if($(".jd_input2").val()==null||$(".jd_input2").val()==""){
		$(".jd_input_lable2").removeClass("hide");
		 ok13=false;
		}else{
			$(".jd_input_lable2").addClass("hide");
			ok13=true;
		}
}
//邮政编码
function yznum2(){
	  if($(".yznum2").val()==null||$(".yznum2").val()==""){
			$(".yznum_lable2").removeClass("hide");
		    $(".yznum_lable2").html("请输入邮编");
		    ok14=false;
		}else{
			var yznums=  /^[1-9][0-9]{5}$/;
			 if(yznums.test(($(".yznum2").val()))){
                 $(".yznum_lable2").addClass("hide");
              ok14=true;
             }else{
                $(".yznum_lable2").removeClass("hide");
                $(".yznum_lable2").html("邮编开头不能为0，共6位");
                ok14=false;
              }
		}
}
//电话号码
function  tel_input2(){
	  if($(".tel_input2").val()==null||$(".tel_input2").val()==""){
			$(".tel_input_lable2").removeClass("hide");
			$(".tel_input_lable2").html("请输入手机号");
			 ok15=false;
		}else{
			var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
			 if(tel_zz.test(($(".tel_input2").val()))){
                $(".tel_input_lable2").addClass("hide");
               ok15=true;
            }else{
               $(".tel_input_lable2").removeClass("hide");
               $(".tel_input_lable2").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
               ok15=false;
           }
		}
  }
//修改地址
function update_dz_btn(){
	user_input2();
	city_input2();
	jd_input2();
	yznum2();
	tel_input2();
  	if(ok11&&ok12&&ok13&&ok14&&ok15){
		//添加属性  data-dismiss="modal"  关闭弹窗 
	  //$(".update_dz_btn").attr("data-dismiss","modal"); 
  		var name = $(".update_model .user_input2").val();
  		var address = $(".update_model .city_input2").val().split("-");//
  		var xxaddress = $(".update_model .jd_input2").val();
  		var ybnum = $(".update_model .yznum2").val();
  		var tel = $(".update_model .tel_input2").val();
  		var id = $(".update_model .id_input2").val();
  		var s_s = "";
  		var s_h = "";
  		var q_x = "";
  		for (var i = 0; i < address.length; i++) {
			s_s=address[0];
			s_h=address[1];
			q_x=address[2];
		}
  		$.ajax({
			url:context+"/addr/updateUserAndGoodsAndAddressId",
			type:"post",
			data:{addrId:id,contactName:name,addressProvince:s_s,addressCity:s_h,addressCounty:q_x,
				addressDetail:xxaddress,postCode:ybnum,aPhone:tel},
			dataType:"json",
			success:function(data){
				refresh();
			}
  		})
	}else{
		//取消关闭弹窗
		 $(".update_dz_btn").attr("data-dismiss","");    
		alert("未通过");
	}
}