<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>账户管理-账户信息</title>
<link href="${ctx}/css/account-mana.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/bootstrap.min.css" />
<style type="text/css">
.error {
	color: red;
}
.modal.in .modal-dialog {
    -webkit-transform: translate(0,0);
    -ms-transform: translate(0,0);
    -o-transform: translate(0,0);
    transform: translate(0,0);
    z-index: 9992;
}
.modal-dialog {
    width: 632px;
    margin: 30px auto;
}
.acc-upfile{
	position: relative;
	left: -65px;
	top: 0;
	color: #3C8AD8;
	cursor: pointer;
	font-weight: bold;
	margin-left:74px;
}
</style>
<!--[if lt IE 9]>
<script src="${ctx}js/html5shiv.js"></script>
<script src="${ctx}js/respond.min.js"></script>
<![endif]-->
</head>
<div class="acc-info">
	<ul class="nav nav-tabs" role="tablist" id="tab-list">
		<li class="active"><a href="#tab-basicinfo" role="tab"
			data-toggle="tab">基本信息</a></li>
		<li><a href="#tab-perphoto" role="tab" data-toggle="tab">个人头像</a></li>
		<li><a href="#tab-perinfo" role="tab" data-toggle="tab">个人信息</a></li>
		<!-- <li><a href="#tab-workexp" role="tab" data-toggle="tab">工作经历</a></li>
	    <li><a href="#tab-eduexp" role="tab" data-toggle="tab">教育经历</a></li>-->
	</ul>
	<div class="tab-content">
		<!--基本信息-->
		<div class="tab-pane active" id="tab-basicinfo">
			<p class="acc-mes-p">*表示该项必填</p>
			<form action="${ctx}/sysUserSingelInfo/update_basicinfo"
				method="post" id="basicinfoForm">
				<table class="acc-basicinfo-table">
					<tr>
						<td align="right" width="10%">
							<p class="padding-r-15">
								<span>*</span>真实姓名:
							</p>
							<p class="acc-null"></p>
						</td>
						<td width="90%">
							<p>
								<input type="text" name="realname" value="${loginUser.realname}"
									id="realname" /><span class="margin-l-10">[已认证]</span>
							</p>

							<p>
								<a href="javascipt:;" target="_blank" class="color-999999">点此进入个人实名认证</a>
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">
								<span>*</span>性别:
							</p>
						</td>
						<td>
							<p>
								<input type="radio" name="sex" value="男"
									${loginUser.sex=='男'?'checked':'' } />先生 <input type="radio"
									name="sex" value="女" ${loginUser.sex=='女'?'checked':'' } />女士
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">
								<span>*</span>会员身份:
							</p>
							<p class="acc-null"></p>
						</td>
						<td>
							<p>
								<c:if test="${loginUser.user_type=='2'}">个人</c:if>
								<a href="javascript:;" class="color-000000">我要升级为企业用户</a>
							</p>
							<p>
								<span class="color-999999">说明：个人用户可升级为企业用户</span>
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">业务联系手机:</p>
							<p class="acc-null"></p>
						</td>
						<td>
							<p>
								${loginUser.phone} <a
									href="${ctx}/sysUserSingelInfo/update_page"
									class="color-999999 margin-l-10">修改</a>
							</p>
							<p>
								<input type="radio" name="visibleStatus" value="2"
									${loginUser.visible_status=='2'?'checked':'' } />手机所有人可见 <input
									type="radio" name="visibleStatus" value="1"
									${loginUser.visible_status=='1'?'checked':'' } />手机仅产贸送会员可见
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">业务联系邮箱:</p>
						</td>
						<td>
							<p>
								${loginUser.email}<a href="${ctx}/sysUserSingelInfo/email_page"
									class="color-999999">修改</a>
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">固定电话:</p>
						</td>
						<td>
							<p>
								<input type="text" class="w-50" value="${loginUser.telphone0}"
									name="tel1" />&nbsp;- <input type="text" class="w-70"
									name="tel2" value="${loginUser.telphone1}" placeholder="区号" />&nbsp;-
								<input type="text" value="${loginUser.telphone2}" name="tel3"
									placeholder="电话号码" />
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">传真:</p>
						</td>
						<td>
							<p class="margin-t-10">
								<input type="text" class="w-50" value="${loginUser.fax0}"
									name="fax1" />&nbsp;- <input type="text" class="w-70"
									value="${loginUser.fax1}" placeholder="区号" name="fax2" />&nbsp;-
								<input type="text" placeholder="传真号码" value="${loginUser.fax2}"
									name="fax3" />
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15 padding-b-10">
								<span>*</span>联系地址:
							</p>
							<p class="acc-null"></p>
						</td>
						<td>
							<p class="margin-t-10">
								<select class="w-90"><option value="中国">中国</option></select> <select
									class="w-90" name="companyAddressProvince" id="s_province"><option
										value="">请选择</option></select> <select class="w-170"
									name="companyAddressCity" id="s_city"><option value="">请选择</option></select>
								<select class="w-170" name="companyAddressCounty" id="s_county"><option
										value="">请选择</option></select>
							</p>
							<p class="margin-t-20">
								<input type="text" value="${loginUser.company_address_detail}"
									placeholder="请输入详细街道地址" name="companyAddressDetail"
									value="${loginUser.companyAddressDetail}" />
							</p>
						</td>
					</tr>
					<tr>
						<td align="right">
							<p class="padding-r-15">邮编:</p>
						</td>
						<td>
							<p class="margin-t-10">
								<input type="text" name="postcode" value="${loginUser.postcode}"
									placeholder="请输入邮政编码">
							</p>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="acc-savebtn" value="保存"></td>
					</tr>
				</table>
			</form>
		</div>
		<!--个人头像-->
		<div class="tab-pane" id="tab-perphoto">
			<table class="acc-perphoto-table">
				<tr>
					<td width="10%">
						<div class="acc-photo-div">
							<img
								src="http://192.168.2.213/${sysUserSingelInfo.profile_image}"
								id="headimg"
								style="width: 132px; height: 131px; margin: 2px;" alt="用户没有上传图片,请您上传图片" />
						</div>
						<p class="margin-l-20 margin-t-5">您当前的头像</p>
					</td>
					<td width="90%" class="padding-l-20">
						<div class="acc-photodiv">
							<span class="fn-left font-bold">您目前还没有头像，请&nbsp;</span> 
							<span
								class="acc-upfile" id="upfile" > 点此上传</span>
<!-- 								 <input type="file" -->
<!-- 								class="acc-file" name="ImgFile" id="uploadfile" -->
<!-- 								onchange="return checkData()"> -->
						</div> <!-- 							<div class="fn-left font-bold"><input type="submit" value="上传" ></div> -->
						<div class="fn-left font-bold">上传图片要求：</div>
						<div class="fn-left margin-t-20" style="text-align: left;">请使用真实头像，展示风格支持JPG,JPEG,GIF,PNG风格，支持2M以内的图片。</div>
					</td>
				</tr>
			</table>
			<!-- 		</form> -->
		</div>
		
		
		
		
			<!--个人信息-->
			<div class="tab-pane" id="tab-perinfo">
				<!--个人信息展示-->
				<!--<div class="acc-perinfoshow show">
				<p class="acc-perinfo-p" align="center">您还没有填写任何个人信息，请<a href="javascript:;" class="acc-perinfolink">点此添加</a></p>
				<table class="acc-perinfo-table">
					<tr>
						<td width="30%" align="right" class="padding-r-15">生日:</td>
						<td width="70%">未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">血型:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">籍贯:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">收入水平:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">学历:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">宗教信仰:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">个人主页:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">兴趣爱好:</td>
						<td>未填写</td>
					</tr>
					<tr>
						<td align="right" class="padding-r-15">自我介绍:</td>
						<td>未填写</td>
					</tr>
				</table>
			</div>-->
				<!--个人信息添加-->

				<div class="acc-perinfoadd show">
					<form action="${ctx}/sysUserSingelInfo/info_save"
						id="sysUserSingelInfoForm" method="post">
						<input type="hidden" name="pid" value="${sysUserSingelInfo.pid}" />
						<table class="acc-perinfoadd-table">
							<tr>
								<td width="10%" align="right" class="padding-r-15">生日:</td>
								<td width="90%">
									<!--对生日信息进行显示选择 --> <%-- 							${sysUserSingelInfo.birthday=='男'?'selected':'' }  --%>
									<select name="year" id="year" onchange="YYYYDD(this.value)">
										<option value="">请选择</option>
								</select>年 <select name="month" id="month" onchange="MMDD(this.value)">
										<option value="">请选择</option>
								</select>月 <select name="day" id="day">
										<option value="">请选择</option>
								</select>日
								</td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">血型:</td>
								<td><span><input type="radio" name="bloodType"
										value="A型" ${sysUserSingelInfo.blood_type=='A型'?'checked':'' } />A型</span>
									<span><input type="radio" name="bloodType" value="B型"
										${sysUserSingelInfo.blood_type=='B型'?'checked':'' } />B型</span> <span><input
										type="radio" name="bloodType" value="AB型"
										${sysUserSingelInfo.blood_type=='AB型'?'checked':'' } />AB型</span> <span><input
										type="radio" name="bloodType" value="O型"
										${sysUserSingelInfo.blood_type=='O型'?'checked':'' } />O型</span> <span><input
										type="radio" name="bloodType" value="RH型"
										${sysUserSingelInfo.blood_type=='RH型'?'checked':'' } />RH型</span></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">籍贯:</td>
								<td><select name="country">
										<option value="">请选择</option>
										<option value="中国"
											${sysUserSingelInfo.country=='中国'?'selected':'' }>中国</option>
								</select> <select name="province" id="province">
										<option value="">请选择</option>
								</select> <select name="city" id="city">
										<option value="">请选择</option>
								</select></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">收入水平:</td>
								<td><input type="text" name="incomeLevel"
									value="${sysUserSingelInfo.income_level}" />元/年</td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">学历:</td>
								<td><select name="degree">
										<option value="本科"
											${sysUserSingelInfo.degree=='本科'?'selected':'' }>本科</option>
										<option value="硕士"
											${sysUserSingelInfo.degree=='硕士'?'selected':'' }>硕士</option>
										<option value="博士"
											${sysUserSingelInfo.degree=='博士'?'selected':'' }>博士</option>
										<option value="高中"
											${sysUserSingelInfo.degree=='高中'?'selected':'' }>高中</option>
										<option value="初中"
											${sysUserSingelInfo.degree=='初中'?'selected':'' }>初中</option>
								</select></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">宗教信仰:</td>
								<td><input type="text" name="religion"
									value="${sysUserSingelInfo.religion}" /></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">个人主页:</td>
								<td><input type="text" name="personalPage"
									placeholder="请输入网址" value="${sysUserSingelInfo.personal_page}" /></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">兴趣爱好:</td>
								<td><input type="text" name="hobby"
									value="${sysUserSingelInfo.hobby}" /></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">自我介绍:</td>
								<td><textarea name="selfEvaluation" id="selfEvaluation"></textarea></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="保存" class="acc-perbtn">
									<a href="javascript:;" class="acc-perdel">删除</a></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<!--工作经历-->
			<div class="tab-pane" id="tab-workexp">
				<div class="padding-t-50" align="center">
					<p class="font-bold">
						您还未填写任何工作经历，请<a href="javascript:;" class="acc-perworklink">点此添加</a>
					</p>
				</div>
			</div>
			<!--教育经历-->
			<div class="tab-pane" id="tab-eduexp">
				<!--教育经历展示-->
				<div class="acc-eduxpshow show">
					<div class="padding-t-50" align="center">
						<p class="font-bold">
							您还未填写任何教育经历，请<a href="javascript:;" class="acc-peredulink">点此添加</a>
						</p>
					</div>
				</div>
				<!--教育经历添加-->
				<div class="acc-eduxpadd hide">
					<div class="acc-edudiv">
						<table class="acc-edutable">
							<tr>
								<td width="30%" align="right" class="padding-r-15"><span>*</span>学习时间</td>
								<td width="70%"><select class="acc-studytime"><option>请选择</option></select>年
									<select class="acc-studytime"><option>请选择</option></select>月&nbsp;-&nbsp;
									<select class="acc-studytime"><option>请选择</option></select>年 <select
									class="acc-studytime"><option>请选择</option></select>月</td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15"><span>*</span>学校名称</td>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15"><span>*</span>学位</td>
								<td><select><option>本科</option></select></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15"><span>*</span>专业</td>
								<td><select><option>工业照明</option></select></td>
							</tr>
							<tr>
								<td align="right" class="padding-r-15">备注</td>
								<td><textarea placeholder="请输入"></textarea>
									<p>
										<span class="acc-numword">0</span>/2000字
									</p></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="button" value="保存" class="acc-perbtn">
									<a href="javascript:;" class="acc-perdel">删除</a></td>
							</tr>
						</table>
					</div>
					<div>
						<input type="button" value="继续添加" class="acc-continueadd">
					</div>
				</div>
			</div>
		</div>
		
							<!-- 		添加头像编辑 -->
	<div class="modal fade" id="headImgModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" width="800px" height="auto">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div style="width: auto; height: 500px; text-align: center">
						<div>
							<p id="swfContainer">
								本组件需要安装Flash Player后才可使用，请从<a
									href="http://www.adobe.com/go/getflashplayer">这里</a>下载安装。
							</p>
						</div>
					</div>

				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
	<script src="${ctx}/js/jquery.1.11.3.min.js"></script>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/account-mana.js"></script>
	<script type="text/javascript"
		src="${ctx}/js/validate/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctx}/js/validate/messages_cn.js"></script>
	<script type="text/javascript"
		src="${ctx}/js/sysUserSingelInfo/address.js"></script>
<script type="text/javascript" src="${ctx}/js/sysUserSingelInfo/fullAvatarImg/swfobject.js"></script>
<script type="text/javascript" src="${ctx}/js/sysUserSingelInfo/fullAvatarImg/fullAcatarEditor.js"></script>
	<script type="text/javascript"
		src="${ctx}/js/sysUserSingelInfo/sysUserSingelInfo.js"></script>
	<script type="text/javascript">
		$(function() {
			$(document).area("s_province", "s_city", "s_county");//调用插件
			$(document).area("province", "city", '');//调用插件
			var self = "${sysUserSingelInfo.self_evaluation}";
			$("#selfEvaluation").html(self);
		});
	</script>
	</script>
</html>



