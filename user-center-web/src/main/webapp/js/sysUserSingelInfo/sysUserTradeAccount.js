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
				required : "<font color=red>请输入您的银行卡号</fond>",
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

	// 根据银行卡的bin码得到银行名称
	$("#bankCard").on("blur", function() {
		var temp = $("#bankCard").val();
		var temp1 = temp.trim();
		var num = temp1.substring(0, 6);

		$.get("/user-center-web/js/bankData.json", function(data) {
			$.each(data, function(i, v) {
				// console.debug(arguments);
				console.debug(v.bin);
				if (num == v.bin) {
					console.debug("银行类别:" + num);
					console.debug("银行名称:" + v.bankName);
					// 得到银行卡名称进行设置
					$("#bank").html(v.bankName);
					$("#bank").attr("value", v.bankName);
					;
				}
			})
		}, "json");
	});

	$(".acc-tratime-ul li").click(
			function() {
				$(this).addClass("acc-trad-current").siblings().removeClass(
						"acc-trad-current");
				var temp = $(this).html();
				if (temp == "最近") {
					$("#inp1").val("");
					$("#inp12").val("");
					$("#searchForm").append(
							"<input type='hidden' name='lately' value=" + temp
									+ ">");
					$("#searchForm").submit();				
				}
				if (temp == "1周") {
					$("#inp1").val("");
					$("#inp12").val("");
					$("#searchForm").append(
							"<input type='hidden' name='week' value=" + temp
									+ ">");
					$("#searchForm").submit();					
				}
				if (temp == "1个月") {
					$("#inp1").val("");
					$("#inp12").val("");
					$("#searchForm").append(
							"<input type='hidden' name='latelymonth' value=" + temp
									+ ">");
					$("#searchForm").submit();	
				}

			});
	//	
	
	$(".acc-trad-select").on("change",function(value){
		var temp = $(this).val()
		$("#inp1").val("");
		$("#inp12").val("");
		$("#searchForm").append(
				"<input type='hidden' name='month' value=" + temp
						+ ">");
		$("#searchForm").submit();
	});
	// 对日期数据进行处理
	$("#queryId").on("click", function() {
		
		$("#searchForm").submit();
	});
	
	//根据query进行判断
});
	$(".acc-trad-okbtn").on("click",function(){
		var holder = $(".margin-l-20").html();
		$("#sysUserTradeAccountForm").append("<input type='hidden' name='cardholder' value="+holder+"/>");
		$("#sysUserTradeAccountForm").submit();
	});
J(function() {
	J('#inp1').calendar();
	J("#inp12")
	J('#img').calendar({
		id : 'inp3'
	});
	J('#inp4').calendar({
		btnBar : false
	});
	J('#inp5').calendar({
		format : 'yyyy年MM月dd日 HH时mm分ss秒'
	});
	J('#inp6').calendar({
		format : 'yyyy年MM月dd日',
		real : 'realInp'
	});
	J('#inp7').calendar({
		minDate : '2011-04-10',
		maxDate : '2011-05-27'
	});
	J('#inp8').calendar({
		maxDate : '%y-%M-%d'
	});
	J('#inp9').calendar({
		minDate : '%y-%M-%d'
	});
	J('#inp10').calendar({
		minDate : '%y-04-%d',
		maxDate : '%y-%M-25'
	});
	J('#inp11').calendar({
		maxDate : '#inp12'
	});
	J('#inp12').calendar({
		minDate : '#inp11'
	});
	J('#inp13').calendar({
		maxDate : '#inp14',
		format : 'yyyyMMdd',
		targetFormat : 'yyyy年MM月dd日'
	});
	J('#inp14').calendar({
		minDate : '#inp13',
		format : 'yyyy年MM月dd日',
		targetFormat : 'yyyyMMdd'
	});
	J('#inp15').calendar({
		disWeek : '6'
	});
	J('#inp16').calendar({
		disWeek : '0,4'
	});
	J('#inp17').calendar({
		disDate : [ '5$' ]
	});
	J('#inp18').calendar({
		disDate : [ '^19' ]
	});
	J('#inp19').calendar({
		disDate : [ '2011-05-05', '2011-05-24' ]
	});
	J('#inp20').calendar({
		disDate : [ '2011-..-04', '2011-05-29' ]
	});
	J('#inp21').calendar({
		disDate : [ '200[0-8]-05-01', '2011-05-29' ]
	});
	J('#inp22').calendar({
		disDate : [ '....-..-07', '%y-%M-%d' ]
	});
	J('#inp23').calendar({
		disDate : [ '5$' ],
		enDate : true
	});
	J('#inp24').calendar({
		onSetDate : function() {
			alert(this.inpObj.value);
		}
	});
	J('#inp25').calendar(
			{
				onSetDate : function() {
					alert('日期框原来的值为:' + this.inpObj.value + ',要用新选择的值:'
							+ this.getDateStr('date') + '覆盖吗?');
				}
			});
});
