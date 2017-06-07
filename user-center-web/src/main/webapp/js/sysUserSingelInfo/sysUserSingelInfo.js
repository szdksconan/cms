$(function() {
	jQuery.validator.addMethod("phonenumber", function(value, element) {
		var temp = checknum(value)
		return this.optional(element)
				|| /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(temp);
	}, "请输入正确的电话号码");
	jQuery.validator.addMethod("isZipCode", function(value, element) {
		var tel = /^[0-9]{6}$/;
		return this.optional(element) || (tel.test(value));
	}, "请正确填写您的邮政编码");
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
	$("#basicinfoForm").validate({
		rules : {
			realname : {
				required : true
			// 这儿可以使remote进行远程验证
			// 真实姓名进行认证
			// remote:"sysUserSingelInfo/approve"
			},
			sex : {
				required : true
			},
			email : "email",
			companyAddressProvince : {
				required : true
			},
			companyAddressCity : {
				required : true
			},
			companyAddressCounty : {
				required : true
			},
			companyAddressDetail : {
				required : true,
				stringCheck : true,
				byteRangeLength : [ 3, 100 ]
			},
			tel1 : {
				phonenumber : true
			},
			tel2 : {
				number : true
			},
			tel3 : {
				number : true
			},
			fax1 : {
				phonenumber : true
			},
			fax2 : {
				number : true
			},
			fax3 : {
				number : true
			},
			postcode : {
				isZipCode : true
			}
		},
		messages : {
			realname : '请输入真实姓名',
			tel1 : '请输入正确的电话号码',
			tel2 : '请输入正确的电话号码',
			tel3 : '请输入正确的电话号码',
			sex : '请选择性别',
			companyAddressProvince : '请选择省份',
			companyAddressCity : '请选择城市',
			companyAddressCounty : '请选择区域',
			companyAddressDetail : {
				required : "请输入您的联系地址",
				stringCheck : "请正确输入您的联系地址",
				byteRangeLength : "请详实您的联系地址以便于我们联系您"
			},
			fax1 : '请输入正确的传真号码',
			fax2 : '请输入正确的传真号码',
			fax3 : '请输入正确的传真号码'
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		}
	});
	// 对个人信息模块进行js验证
	$("#sysUserSingelInfoForm").validate({
		rules : {
			year : {
				required : true
			},
			month : {
				required : true
			},
			day : {
				required : true
			},
			bloodType : {
				required : true
			},
			country : {
				required : true
			},
			province : {
				required : true
			},
			city : {
				required : true
			},
			incomeLevel : {
				required : true,
				number : true
			},
			degree : {
				required : true
			},
			personalPage : {
				url : "url"
			},
		},
		messages : {
			personalPage : "请输入正确的网址",
			year : "请选择年",
			month : "请选择月",
			day : "请选择天",
			bloodType : "请选择血型",
			country : "请选择国家",
			province : "请选择省份",
			city : "请选择城市",
			degree : "请填写学位",
			incomeLevel : "请正确填写收入水平"
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent());
		},
		error : function(label) {
			label.text(" ").addClass("error");
		}
	});
	// 处理个人头像这儿的ajax请求处理头像上传功能

	// 给生日信息中的年月日加上信息
	var year = $("#year");
	var month = $("#month");
	var y = new Date().getFullYear();
	for (var i = y; i >= y - 120; i--) {
		// 以今年的时间为准向前面的时间推120年
		year.append('<option value=' + i + '>' + i + '</option');
	}
	// 对月份进行处理
	for (var i = 1; i < 13; i++) {
		// 对月份进行数据处理
		month.append("<option value=" + i + ">" + i + "</option>");
	}

	// 对一些不能进行修改的信息进行判断
	var realname = $("#realname").val();
	if (realname) {
		$("#realname").attr("disabled", "disabled");// disabled="disabled"
	}
	// 对生日信息进行回显处理
	$.get("/user-center-web/sysUserSingelInfo/info", function(data) {
		$("#year option[value=" + data.year + "]").attr("selected", true);
		$("#month [value=" + data.month + "]").attr("selected", true);
		$("#day").append(
				"<option value=" + data.day + " selected='selected'>"
						+ data.day + "</option>");
		// 对个人信息中的地址信息进行处理
		$("#province option[value=" + data.province + "]").attr("selected",
				true);
		$("#city").append(
				"<option value=" + data.city + " selected='selected'>"
						+ data.city + "</option>");

		// 对基本信息中的地址信息进行处理;
		$("#s_province option[value=" + data.provincebase + "]").attr(
				"selected", true);
		$("#s_city").append(
				"<option value=" + data.cityBase + " selected='selected'>"
						+ data.cityBase + "</option>");
		$("#s_county").append(
				"<option value=" + data.country + " selected='selected'>"
						+ data.country + "</option>");
	}, "json")

	// 处理图像编辑
	$("#upfile").on("click", function() {
		$("#headImgModal").modal('show')
	});

});
// 开始对图片进行裁剪
swfobject
		.addDomLoadEvent(function() {
			// 以下两行代码正式环境下请删除
			if (location.href.indexOf('http://') == -1)
				alert('请于WEB服务器环境中查看、测试！\n\n既 http://*/simpleDemo.html\n\n而不是本地路径 file:///*/simpleDemo.html的方式');
			var swf = new fullAvatarEditor(
					"/user-center-web/js/sysUserSingelInfo/fullAvatarImg/fullAvatarEditor.swf",
					"/user-center-web/js/sysUserSingelInfo/fullAvatarImg/expressInstall.swf",
					"swfContainer",
					{
						id : 'swf',
						upload_url : '/user-center-web/sysUserSingelInfo/ImgUpload', // 上传接口

						method : 'post', // 传递到上传接口中的查询参数的提交方式。更改该值时，请注意更改上传接口中的查询参数的接收方式
						Field : '__avatar1',
						src_upload : 2, // 是否上传原图片的选项，有以下值：0-不上传；1-上传；2-显示复选框由用户选择
						avatar_sizes : '162*162'
					}, function(msg) {
						switch (msg.code) {
						case 1:
							;
							break;
						case 2:
							// alert("已成功加载图片到编辑面板。");
							// document.getElementById("upload").style.display =
							// "inline";
							break;
						case 3:
							if (msg.type == 0) {
								alert("摄像头已准备就绪且用户已允许使用。");
							} else if (msg.type == 1) {
								alert("摄像头已准备就绪但用户未允许使用！");
							} else {
								alert("摄像头被占用！");
							}
							break;
						case 5:
							if (msg.type == 0) {
								if (msg.content.sourceUrl) {
									alert("原图已成功保存至服务器，url为：\n"
											+ msg.content.sourceUrl
											+ "\n\n"
											+ "头像已成功保存至服务器，url为：\n"
											+ msg.content.avatarUrls
													.join("\n\n")
											+ "\n\n传递的userid="
											+ msg.content.userid + "&username="
											+ msg.content.username);
								} else {
									// 可以在这儿执行方法对页面进行关闭
									// alert("执行到这儿");
									var avatarUrls = msg.content.avatarUrls;
									$("#headimg").attr(
											"src",
											"http://192.168.2.213/"
													+ avatarUrls);
									$("#headImgModal").modal("hide");
								}
							}
							break;
						}
					});
			// document.getElementById("upload").onclick=function(){
			// swf.call("upload");
			// };
		});
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
			: " http://");
	document
			.write(unescape("%3Cscript src='"
					+ _bdhmProtocol
					+ "hm.baidu.com/h.js%3F5f036dd99455cb8adc9de73e2f052f72' type='text/javascript'%3E%3C/script%3E"));
	
	
	function IsPinYear(year)// 判断是否闰平年
	{
		return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
	}
	
	var getyear;
	function YYYYDD(value) {
		getyear = value;
	}
	
	// 判断每个月的天数
	function MMDD(str) {
		// 对得到地年份和月份进行判断
	
		if (str == -1 || getyear == -1) {
			return;
		}
		var days = $("#day")
		days.html("");
		days.append("<option value ='-1'>请选择</option>");
		var tempDays = checkDays(str, getyear);
		var number = parseInt(tempDays);
		var temp = number + 1;
		for (var i = 1; i < temp; i++) {
			days.append("<option value=" + i + ">" + i + "</option>");
		}
	}
	
	// 根据月份判断每个月的天数
	function checkDays(str, getyear) {
		if (str == 2) {
			if (IsPinYear(getyear)) {
				return "29";
			} else {
				return "28";
			}
		} else {
			if (str == 1 || str == 3 || str == 5 || str == 7 || str == 8
					|| str == 10 || str == 12) {
				return "31";
			} else {
				return "30";
			}
		}
	}
	
	
	// js用于判断 电话号码 和传真号码的js验证
	function checknum(value) {
		if (value) {
			var first = value.substring(0, 1);
			if (first == '+') {
				return value.substring(1, 5);
			} else {
				cosole.debug(value);
				return value;
			}
		}
		return '';
	
	}
