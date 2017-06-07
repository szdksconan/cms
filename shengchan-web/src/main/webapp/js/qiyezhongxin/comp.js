function addContact() {
	var compBaseId = $('#compId').val();
	var id = $('#ywid').val();
	var contactPerson = $('#relianxi').val();
	var businessType = $('#yewu_type').val();
	var phone = $('#gudingdianhua').val();
	var tel = $('#recellphone').val();
	var email = $('#emial2').val();
	if (contactPerson == null || contactPerson == undefined
			|| contactPerson == "") {
		msg({
			texts : '联系人不能为空！'
		});
		return false;
	}
	if (phone == null || phone == undefined || phone == "") {
		msg({
			texts : '固定电话不能为空！'
		});
		return false;
	}
	if (tel == null || tel == undefined || tel == "") {
		msg({
			texts : '手机号不能为空！'
		});
		return false;
	}
	if (email == null || email == undefined || email == "") {
		msg({
			texts : '邮箱不能为空！'
		});
		return false;
	}
	$.ajax({
		url : "/shengchan-web/comp/saveContact",
		type : "POST",
		dataType : "json",
		data : {
			"compBaseId" : compBaseId,
			"id" : id,
			"contactPerson" : contactPerson,
			"businessType" : businessType,
			"phone" : phone,
			"tel" : tel,
			"email" : email
		},
		success : function(data) {
			if (data.success) {
				msg({
					texts : '保存成功！'
				});
				$('#ywid').val("");
				$('#relianxi').val("");
				var yewu_type = $('#yewu_type').val();
				$('#yewu_type').multiselect('deselect', yewu_type);
				$('#gudingdianhua').val("");
				$('#recellphone').val("");
				$('#emial2').val("");
				refreshTab();
				initComp1("1312312313");
			} else {
				msg({
					texts : '保存失败！'
				});
			}
		}
	})
}
function delContact(obj, compid) {
	var id = obj;
	$.ajax({
		url : "/shengchan-web/comp/delContact",
		type : "POST",
		dataType : "json",
		data : {
			"id" : id,
			"compid" : compid
		},
		success : function(data) {
			if (data.success) {
				msg({
					texts : '删除成功！'
				});
				refreshTab();
				initComp1("1312312313");

			} else {
				msg({
					texts : '删除失败！'
				});
			}
		}
	})
}
function initComp1(compId) {
	$
			.ajax({
				url : "/shengchan-web/comp/initCompById",
				data : {
					"compId" : compId
				},
				type : "POST",
				dataType : "json",
				success : function(data, textStatus) {
					if (data.success) {
						var yelianxi = $('.ywlianxi');
						yelianxi.empty();
						$
								.each(
										data.list.contact,
										function(i, v) {
											if (i < 4) {

												var lianxi = "<div class='lianxi-l1'>"
														+ "<input type='hidden' name='ywid' value="
														+ v.id
														+ ">"
														+ "<div class='yelianxi_text'>&emsp;&emsp;联系人：<span>"
														+ v.contactPerson
														+ "</span></div>"
														+ "<div class='yelianxi_text'>&emsp;业务类型：<span>"
														+ v.businessType
														+ "</span></div>"
														+ "<div class='yelianxi_text'>&emsp;固定电话：<span>"
														+ v.tel
														+ "</span></div>"
														+ "<div class='yelianxi_text'>&emsp;&emsp;&emsp;手机：<span>"
														+ v.phone
														+ "</span></div>"
														+ "<div class='yelianxi_text'>&emsp;电子邮箱：<span>"
														+ v.email
														+ "</span></div>"
														+ "</div>";
												yelianxi.append(lianxi);

											}

										});

					} else {
						// alert('初始化失败!');
					}
				}

			});

}
function updateContact(obj, compid) {
	var id = obj;
	$.ajax({
		url : "/shengchan-web/comp/updateContact",
		type : "POST",
		dataType : "json",
		data : {
			"id" : id,
			"compid" : compid
		},
		success : function(data) {
			if (data.success) {
				$('#ywid').val(data.list.id);
				$('#relianxi').val(data.list.contactPerson);
				$('#yewu_type').val(data.list.businessType);
				$('#gudingdianhua').val(data.list.phone);
				$('#recellphone').val(data.list.tel);
				$('#emial2').val(data.list.email);
			} else {
				msg({
					texts : '查询失败！'
				});
			}
		}
	})
}
function updateCompBase() {

	var compid = $('#compId').val();
	var options = {
		url : "/shengchan-web/comp/uploadContactPic?compid=" + compid,
		dataType : 'json',
		success : function(data) {

			if (data.success) {

				var compid = $('#compId').val();
				var address = $('#addr').val();
				var weixinNo = $('#weixin').val();
				var tel = $('#retel').val();
				var fax = $('#refax').val();
				var post = $('#repost').val();
				var email = $('#reemail').val();

				var delFileKey = $("#delContactFileKeys").val();
				$.ajax({
					url : "/shengchan-web/comp/updateCompBase",
					type : "POST",
					dataType : "json",
					data : {
						"compid" : compid,
						"delFileKey" : delFileKey,
						"address" : address,
						"weixinNo" : weixinNo,
						"tel" : tel,
						"fax" : fax,
						"post" : post,
						"email" : email

					},
					success : function(data) {
						if (data.success) {
							msg({
								texts : '修改成功！'
							});
							initComp2("1312312313");
						} else {
							msg({
								texts : '修改失败！'
							});
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						// alert(errorThrown);
					}
				});
			}
		}
	};
	// 提交表单
	$('#contactform').ajaxSubmit(options);

}
function deleteAtta(obj, compid) {
	var id = obj;
	$.ajax({
		url : "/shengchan-web/comp/deleteAtta",
		type : "POST",
		dataType : "json",
		data : {
			"id" : id,
			"compid" : compid

		},
		success : function(data) {
			if (data.success) {
				msg({
					texts : '删除成功！'
				});
			} else {
				msg({
					texts : '删除失败！'
				});
			}
		}
	})

}

function saveS3() {
	$.ajaxFileUpload({
		url : '/shengchan-web/comp/saveS3?compId=' + $('#compId').val(),
		secureuri : false,
		fileElementId : 'test3',
		dataType : 'json',
		success : function(data, status) {

		},
		error : function(data, status, e) {
			msg({
				texts : '图片上传失败，请从新上传，或刷新网络！'
			});
		}
	});
	return false;
}

function initComp2(compId) {
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				// 联系
				$('#mainAddress').html(data.list.base.address);
				$('#qyweixin').html(data.list.base.weixinNo);
				$('#tel').html(data.list.base.tel);
				$('#fax').html(data.list.base.fax);
				$('#post').html(data.list.base.post);
				$('#email').html(data.list.base.email);
				var qy = $('#qy');
				$('#qy').empty();

				$.each(data.list.attach, function(i, att) {

					if (att.relType == "3") {
						var html = '<div class="swiper-slide" data="fangda">'
								+ '<img src=' + att.attaUrl
								+ ' onclick="openImg(this)"></div>';
						qy.append(html);
					}
				});

			} else {
				// alert('初始化失败!');
			}
		}

	});

}

function resetContact() {

	$('#ywid').val("");
	$('#relianxi').val("");
	var yewu_type = $('#yewu_type').val();
	$('#yewu_type').multiselect('deselect', yewu_type);
	$('#gudingdianhua').val("");
	$('#recellphone').val("");
	$('#emial2').val("");

}

function initComp3(compId) {

	$
			.ajax({
				url : "/shengchan-web/comp/initCompById",
				data : {
					"compId" : compId
				},
				type : "POST",
				dataType : "json",
				success : function(data, textStatus) {
					if (data.success) {
						$('#mainProduct').html(data.list.base.mainProductDesc);
						$('#serviceYear').html(data.list.base.serviceYear);
						$('#factoryArea').html(data.list.base.factoryArea);
						$('#number').html(data.list.base.employeeNum);
						$('#ability').html(data.list.base.outputAbilityInfo);
						$('#shebei_intro').html(data.list.base.equipmentInfo);

						var jia = $('#jiagong');

						$
								.each(
										data.list.attach,
										function(i, att) {
											// 车间加工
											if (att.relType == "2") {
												// jia.empty();
												var jiagong = "<div class='swiper-slide' data='fangda'><img src="
														+ att.attaUrl
														+ ' data='
														+ att.id
														+ ' onclick="openImg(this)"> </div>';
												jia.append(jiagong);
											}
										});

					} else {
						// alert('初始化失败!');
					}
				}

			});

}

function initComp4(compId) {
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				$("#companyName").text(data.list.base.companyName);
				$(".qy_name").text(data.list.base.companyName);
				$("#address").text(data.list.base.address);
				$("#compType").text(data.list.base.compType);
				$("#setupTime").text(data.list.base.setupTime);
				$("#registMoney").text(data.list.base.registMoney);
				$("#owners").text(data.list.base.owners);
				$("#homePage").text(data.list.base.homePage);
				$("#registNo").text(data.list.base.registNo);
				$("#taxNo").text(data.list.base.taxNo);
				$("#organization").text(data.list.base.organization);
				$("#credit").text(data.list.base.credit);
				$("#customMade").text(data.list.base.customMade);
				$("#mainIndustry").text(data.list.base.mainIndustry);
				$('#comp_intro').html(data.list.base.compIntro);
				$('#pinpai_intro').html(data.list.base.brandIntro);
				$('#jy_type').html(data.list.base.businessModel);
				$('#sheng_id').val(data.list.base.shengId);
				$('#city_id').val(data.list.base.cityId);
				$('#xian_id').val(data.list.base.xianId);
				
				ShowMap(data.list.base.compZuobiao, data.list.base.companyName,
						data.list.base.address, data.list.base.tel,
						data.list.base.fax, '15');
				var qy = $('#qy');

				$.each(data.list.attach, function(i, att) {
					if (att.relType == "6") {
						$(".qy_logo img").attr('src', att.attaUrl);
					}

				});

			} else {
				// alert('初始化失败!');
			}
		}

	});

}
function initComp5(compId) {
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				$("#companyName").text(data.list.base.companyName);
				$.each(data.list.attach, function(i, att) {
					if (att.relType == "5") {
						$(".img-desc img").attr('src', att.attaUrl);
						$("#qiattachId").val(att.id);

					}
				});

			} else {
				// alert('初始化失败!');
			}
		}

	});

}
function initComp6(compId) {
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				ShowMap(data.list.base.compZuobiao, data.list.base.companyName,
						data.list.base.address, data.list.base.tel,
						data.list.base.fax, '20');
			} else {
				// alert('初始化失败!');
			}
		}

	});

}
function initComp7(compId) {
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				showMagnifyMap(data.list.base.compZuobiao,
						data.list.base.companyName, data.list.base.address,
						data.list.base.tel, data.list.base.fax, '15');
			} else {
				// alert('初始化失败!');
			}
		}

	});

}
function editBaseInfo() {
	var compid = "1312312313";
	var companyName = $('#qyname').val();
	var address = $('#jingyingdizhi').val();
	var compType = $('#type option:selected').text();
	var jinyingmoshi = $('#jingyingmoshi option:selected').text();
	var setupTime = $('#createTime').val();
	var registMoney = $('#remoney').val();
	var owners = $('#qyowner').val();
	var homePage = $('#reHomePage').val();
	var registNo = $('#gongshang').val();
	var taxNo = $('#RetaxNO').val();
	var organization = $('#orgNO').val();
	var credit = $('#recridet').val();
	var mainIndustry = $('#zhuying').val();
	var compIntro = checkTextArea('qy_intr');
	var brandIntro = checkTextArea('brand_in');
	var compZuobiao = $('#zuobiao').val();
	var deletelogo = $('#deletelogo').val();
	var dizi = $('#jingyingdizhi').attr('data-id');
	
	alert(dizi);
	var temp = '';
	var shengId = '';
	var cityId = '';
	var xianId = '';
	if(dizi){
		 temp= dizi.split('-');
	}else{
		shengId = $('#re_shengId').val();
		cityId = $('#re_cityId').val();
		xianId = $('#re_xianId').val();
	}
	
	if (temp.length > 0) {
		shengId = temp[0];
	}
	if (temp.length > 1) {
		cityId = temp[1];
	}
	if (temp.length > 2) {
		xianId = temp[2];
	}
	if (deletelogo) {
		deletelogo = deletelogo.substring(0, deletelogo.length - 1);
	} else {
		deletelogo = 1;
	}

	if (!compZuobiao) {
		compZuobiao = $('#rezuobiao').val();
	}
	var customMade = $("#customde input:checked").val();
	/* console.debug($('input[type="radio"] :checked')); */
	$.ajax({
		type : "post",
		url : "/shengchan-web/qiye/changeBaseInfo",
		dataType : "json",
		data : {
			"compid" : compid,
			"companyName" : companyName,
			"compType" : compType,
			"customMade" : customMade,
			"setupTime" : setupTime,
			"registMoney" : registMoney,
			"mainIndustry" : mainIndustry,
			"owners" : owners,
			"homePage" : homePage,
			"registNo" : registNo,
			"taxNo" : taxNo,
			"organization" : organization,
			"credit" : credit,
			"address" : address,
			"compIntro" : compIntro,
			"brandIntro" : brandIntro,
			"compZuobiao" : compZuobiao,
			"deletelogo" : deletelogo,
			"businessModel" : jinyingmoshi,
			"shengId":shengId,
			"cityId":cityId,
			"xianId":xianId
		},
		success : function(data) {
			if (data.success) {
				msg({
					texts : '提交成功！'
				});
				refreshTab();
				initComp4("1312312313");
			} else {
				msg({
					texts : '提交失败！'
				});
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			// alert(errorThrown);
		}
	});
	var options = {
		url : "/shengchan-web/qiye/uploadpic?compid=" + compid,
		dataType : 'json',
		success : function(data) {
		}
	};
	// 提交表单
	$('#cpxsform').ajaxSubmit(options);

}

function updatezizhi() {
	var result = "1";
	var delFileKey = $("#zizhiFileKeys").val();
	var addFileName = "";
	var breakmark = true;
	$.each($("input[name='zizhi']"), function(index) {
		var zizhiname = $(this).next().find("input ").val();

		if (zizhiname == null || zizhiname == undefined || zizhiname == "") {
			breakmark = false;
			return false;

		}
		addFileName += zizhiname + "^^";
	});
	if (!breakmark) {
		msg({
			texts : '请输入名称'
		});
		return false;
	}
	var compid = $('#compId').val();
	var options = {
		url : "/shengchan-web/comp/uploadZiZhiPic",
		dataType : 'json',
		data : {
			compid : compid,
			addFileName : addFileName,
			delFileKey : delFileKey
		},
		success : function(data) {

			if (data.success) {
				initComp8();
				msg({
					texts : '修改成功！'
				});

			} else {

				msg({
					texts : '修改失败！'
				});
			}
		}
	};
	// 提交表单
	$('#zizhiform').ajaxSubmit(options);
	return result;

}

function initComp8() {
	var compid = $('#compId').val();
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compid
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {

				var zizhi = $('#zizhi');

				$.each(data.list.attach, function(i, att) {

					if (att.relType == "4") {
						var html = '<div class="swiper-slide" data="fangda">'
								+ '<div class="qy_img">' + '<img src='
								+ att.attaUrl
								+ ' onclick="openImg(this)" /></div>'
								+ '<p class="qy_text">' + att.typeName
								+ '</p></div>';
						zizhi.append(html);
					}

				});

			} else {
				// alert('初始化失败!');
			}
		}

	});

}
