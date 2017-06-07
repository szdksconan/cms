$(function(){
	
		
		//手机号验证
		$.validator.addMethod("isMobile", function(value, element) {
			var length = value.length;
			var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
		}, "请正确填写您的手机号码");
		
		
		//表单验证
		$("#comAddForm").validate({
			errorElement: "em",
//	        success: function(em) {
//	            em.text("ok").addClass("success");//验证通过的动态CSS
//	        },
	        submitHandler:function() {
	        	ajaxSbtForm();
	        },
			rules:{
				username:"required",
				addressDetail:"required",
				phone:{
					required:true,
					isMobile:true
				    },
				postCode:{
					number:true
				},
				telArea:{
					number:true
				},
				telNumber:{
					number:true
				}
			},
			messages:{
				username:"请填写收货人姓名",
				phone:{
					required:"请填写电话号码"
				},
				addressDetail:"请填写详细街道地址"
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent().next());
			},

		});
		
});

function ajaxSbtForm(){
	//ajax提交保存表单
//	$("#addSbt").click(function(){
		var username=$("input[name='username']").val();
		//收货地址省市县
		var addressProvince="新疆区";
		var addressCity="喀什地区";
		var addressCounty="莎车县";
		var postCode=$("input[name='postCode']").val();
		var addressDetail=$("textarea[name='addressDetail']").val();
		var tel=$("input[name='tel1']").val()+"-"+$("input[name='telArea']").val()
                  "-"+$("input[name='telNumber']").val();
		var phone=$("input[name='phone']").val();
		var isDefault=$("input[name='isDefault']").val();
        var param= "username="+username+"&addressProvince="+addressProvince+"&addressCity="+addressCity+
        "&addressCounty="+addressCounty+"&postCode="+postCode+"&addressDetail="+addressDetail+"&tel="+tel+
        "&phone="+phone+"&isDefault="+isDefault;
		$.ajax({
            cache: true,
            type: "POST",
            url:"/user-center-web/sysUserAddressPer/saveComeAds",
            data:param,
            async: false,
            error: function(request) {
                alert("出问题啦，产贸送员工正在紧张地抢修！！！");
            },
            success: function(data) {
					alert(data.success);
				//刷新地址列表
				window.location.reload();						
            }
//        });
	});
}

	
	//ajax删除
function deleteAds(url){
		if(confirm("你确认删除吗？")){
			$.get(url,function(data){
				alert(data.success);
				//刷新地址列表
				window.location.reload();
			});
		}
	}