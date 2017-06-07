$(function() {
	$.validator.setDefaults({
		submitHandler : function(form) {
			form.submit();
		}
	});
	// 字符验证
	jQuery.validator.addMethod("stringCheck", function(value, element) {
		return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
	}, "只能包括中文字、英文字母、数字和下划线");
	// 中文字两个字节
	jQuery.validator.addMethod("byteRangeLength", function(value, element,
			param) {
		var length = value.length;
		for (var i = 0; i < value.length; i++) {
			if (value.charCodeAt(i) > 127) {
				length++;
			}
		}
		return this.optional(element)
				|| (length >= param[0] && length <= param[1]);
	}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");

	// 身份证号码验证
	jQuery.validator.addMethod("isIdCardNo", function(value, element) {
		return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
	}, "请正确输入您的身份证号码");
	// 护照编号验证
	jQuery.validator.addMethod("passport", function(value, element) {
		return this.optional(element) || checknumber(value);
	}, "请正确输入您的护照编号");

	// 手机号码验证
	jQuery.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");

	// 电话号码验证
	jQuery.validator.addMethod("isTel", function(value, element) {
		var tel = /^\d{3,4}-?\d{7,9}$/; // 电话号码格式010-12345678
		return this.optional(element) || (tel.test(value));
	}, "请正确填写您的电话号码");

	// 联系电话(手机/电话皆可)验证
	jQuery.validator.addMethod("isPhone", function(value, element) {
		var length = value.length;
		var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		var tel = /^\d{3,4}-?\d{7,9}$/;
		return this.optional(element)
				|| (tel.test(value) || mobile.test(value));

	}, "请正确填写您的联系电话");

	// 邮政编码验证
	jQuery.validator.addMethod("isZipCode", function(value, element) {
		var tel = /^[0-9]{6}$/;
		return this.optional(element) || (tel.test(value));
	}, "请正确填写您的邮政编码");

	// 验证银行卡号
	jQuery.validator.addMethod("isBankNo", function(value, element) {
		return this.optional(element) || checkBankNo(value)
	}, "请输入正确的银行卡号");

	// 开始验证
	$('#sysUserTradeAccountForm').validate({

		rules : {
			phone : {
				required : true,
				isMobile : true
			},
			bankCard : {
				required : true,
				isBankNo : true
			},
			// address : {
			// required : true,
			// stringCheck : true,
			// byteRangeLength : [ 3, 100 ]
			// },

			idCard : {
				required : true,
				isIdCardNo : true

			},

		// passport : {
		// required : true,
		// passport : true
		//
		// }
		},

		messages : {
			// username : {
			// required : "请填写用户名",
			// stringCheck : "用户名只能包括中文字、英文字母、数字和下划线",
			// byteRangeLength : "用户名必须在3-15个字符之间(一个中文字算2个字符)"
			// },
			// email : {
			// required : "<font color=red>请输入一个Email地址</fond>",
			// email : "请输入一个有效的Email地址"
			// },
			bankCard : {
				required : "请输入您的银行卡号",
				isPhone : "请输入正确的银行卡号"
			},
			phone : {
				required : "请输入您的联系电话",
				isPhone : "请输入一个有效的联系电话"
			},
			// address : {
			// required : "请输入您的联系地址",
			// stringCheck : "请正确输入您的联系地址",
			// byteRangeLength : "请详实您的联系地址以便于我们联系您"
			// },
			idCard : {
				required : "请输入身份证号",
				isIdCardNo : "请输入正确的身份证号"
			},
		// passport : {
		// required : "请输入护照编号",
		// passport : "请输入正确的护照编号"
		// }
		},
		focusInvalid : false,
		onkeyup : false,
		errorPlacement : function(error, element) {
			error.appendTo(element.parent().next());
		},
		errorElement : "em",
		
		error : function(label) {
			label.text(" ").addClass("error");
		}
	});
	
	//根据银行卡的bin码得到银行名称
	$("#bankCard").on("blur",function(){
		var temp = $("#bankCard").val();
		 var temp1 = temp.trim();
		 var num = temp1.substring(0,6);
		 
		 $.get("/user-center-web/js/bankData.json",function(data){
			 $.each(data,function(i,v){
//				 console.debug(arguments);
				 console.debug(v.bin);
				 if(num==v.bin){
					 console.debug("银行类别:"+num);
					 console.debug("银行名称:"+v.bankName);
				 }
//				 
				 
			 })
		 },"json");
	});
	$(".acc-tratime-ul li").click(function(){
		$(this).addClass("acc-trad-current").siblings().removeClass("acc-trad-current");
	});
	
	
	
})
