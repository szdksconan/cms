$(document).ready(function() {
	initComp("1312312313");
	$("#compId").val("1312312313");
});
// 初始化企业门户信息
function initComp(compId) {
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
						// 百度地图
						ShowMap(data.list.base.compZuobiao,
								data.list.base.companyName,
								data.list.base.address, data.list.base.tel,
								data.list.base.fax, '15');
						//
						
						$('#rezuobiao').val(data.list.base.compZuobiao);
						$('#comp_intro').html(data.list.base.compIntro);
						$('#pinpai_intro').html(data.list.base.pinpaiIntro);
						$('#mainProduct').html(data.list.base.mainProductDesc);
						$('#serviceYear').html(data.list.base.serviceYear);
						$('#factoryArea').html(data.list.base.factoryArea);
						$('#number').html(data.list.base.employeeNum);
						$('#ability').html(data.list.base.outputAbilityInfo);
						$('#shebei_intro').html(data.list.base.equipmentInfo);
						// 联系
						$('#mainAddress').html(data.list.base.address);
						$('#qyweixin').html(data.list.base.weixinNo);
						$('#tel').html(data.list.base.tel);
						$('#fax').html(data.list.base.fax);
						$('#post').html(data.list.base.post);
						$('#email').html(data.list.base.email);

						var jia = $('#jiagong');
						var yelianxi = $('.ywlianxi');
						var zizhi = $('#zizhi');
						var qy = $('#qy');
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

						$
								.each(
										data.list.attach,
										function(i, att) {
											if (att.relType == "5") {
												$(".img-desc img").attr('src',
														att.attaUrl);
												$("#qiattachId").val(att.id);

											}
											if (att.relType == "6") {
												$(".qy_logo img").attr('src',
														att.attaUrl);
											}
											/*
											 * //产品 if (att.relType == "1") {
											 * var html = '<div
											 * class="swiper-slide">'+ '<img
											 * src='+att.attaUrl+'>'+ '<span
											 * class="thumbtext">'+att.describes+'</span></div>';
											 * $('#qyproduct').append(html); }
											 */
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
											if (att.relType == "4") {
												var html = '<div class="swiper-slide" data="fangda">'
														+ '<div class="qy_img">'
														+ '<img src='
														+ att.attaUrl
														+ ' onclick="openImg(this)" /></div>'
														+ '<p class="qy_text">'
														+ att.typeName
														+ '</p></div>';
												zizhi.append(html);
											}
											if (att.relType == "3") {
												var html = '<div class="swiper-slide" data="fangda">'
														+ '<img src='
														+ att.attaUrl
														+ ' onclick="openImg(this)"></div>';
												qy.append(html);
											}
										});

						$.each(data.list.mainProduct, function(i, main) {
							var html = '<div class="swiper-slide">'
									+ '<img src=' + main.fileurl + '>'
									+ '<span class="thumbtext">'
									+ main.setIntroduce + '</span></div>';
							$('#qyproduct').append(html);
						});

					} else {
						// alert('初始化失败!');
					}
				}

			});

}
// 图片放大
function openImg(obj) {
	var img = $(obj).attr("src");
	var heght = $(obj).height();
	var width = $(obj).width();
	layer.open({
		type : 1,
		title : false,
		area : [ width, heght ],
		skin : 'yourclass',
		content : '<img src="' + img + '"/>'
	});
}