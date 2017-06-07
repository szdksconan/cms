
$(function(){
	//企业账户基本信息JavaScript
	
//账户名，真实姓名，证件类型，证件号码”不支持修改
var uname=$("input[name='uname']").val();
var realname=$("input[name='realname']").val();
var certType=$("#certType").html();
var certNum=$("input[name='certNum']").val();
if(uname==null||uname==undefined||uname.length==""){
	$("input[name='uname']").attr("disabled",false);
}
if(realname==null||realname==undefined||realname.length==""){
	$("input[name='realname']").attr("disabled",false);
}
if(certNum==null||certNum==undefined||certNum.length==""){
	$("input[name='certNum']").attr("disabled",false);
}
if( certType!=null){
	//移除点击事件
	$("#certType").off("click");
}
	//手机号验证
	$.validator.addMethod("isMobile", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, "请正确填写您的手机号码");
	
	
	//身份证号验证
	 $.validator.addMethod("isIdCardNo", function (value, element) {
	        return this.optional(element) || isIdCardNo(value);
	    }, "请正确输入您的身份证号码");
	 
	//基本信息提交表单验证
	$("#basicInfoForm").validate({
		errorElement: "em",
        success: function(em) {
//            em.text("ok").addClass("success");//验证通过的动态CSS
        },
        submitHandler:function() {
        	ajaxSbuForm();
        },
		rules:{
			uname:"required",
			realname:"required",
			certType:"required",
			certNum:{
			    required:true,
			    number:true,
			    isIdCardNo:true
			    },
			phone:{
				required:true,
				isMobile:true
			    },
			contactPersonPhone:{
				isMobile:true
			},
			email:{
				email:true
			}
		},
		messages:{
			uname:"请填写用户名",
			realname:"请填写您的真实姓名",
			certType:"请选择你的身份类型"
		}
	});
});


function ajaxSbuForm(){
	//ajax提交保存表单
//	$("#basicInfoSub").click(function(){
		var uid=$("input[name='uid']").val();
		var uname=$("input[name='uname']").val();
		var realname=$("input[name='realname']").val();
		var certType=$("#certType").html();
		var certNum=$("input[name='certNum']").val();
		var phone=$("input[name='phone']").val();
		var tel=$("input[name='tel']").val();
		var email=$("input[name='email']").val();
		var contactPersonName=$("input[name='contactPersonName']").val();
		var contactPersonSex=$("input[name='contactPersonSex']:checked").val();
		var contactPersonDepart=$("#contactPersonDepart").html();
		var contactPersonPosition=$("#contactPersonPosition").html();
		var contactPersonPhone= $("#contactPersonPhoneArea").html()+$("input[name='contactPersonPhone']").val();
		var contactPersonTel=$("input[name='contactTel']").val()+"-"+$("input[name='contactTelArea']").val()+"-"
		                      +$("input[name='contactTelNumber']").val();
		var contactPersonCertType=$("#contactPersonCertType").html();
		var contactPersonCertNum=$("input[name='contactPersonCertNum']").val();
		var param="uid="+uid+"&uname="+uname+"&realname="+realname+"&certType="+certType+"&certNum="+certNum
		+"&phone="+phone+"&tel="+tel+"&email="+email+"&contactPersonName="+contactPersonName+"&contactPersonSex="+contactPersonSex
		+"&contactPersonDepart="+contactPersonDepart+"&contactPersonPosition="+contactPersonPosition+"&contactPersonPhone="+contactPersonPhone
		+"&contactPersonTel="+contactPersonTel+"&contactPersonCertType="+contactPersonCertType+"&contactPersonCertNum="+contactPersonCertNum
		$.ajax({
	       cache: true,
	       type: "POST",
	       url:"/user-center-web/accountCom/saveBasicInfo",
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
	   });
//	});
}


//增加身份证验证
function isIdCardNo(num) {
    var factorArr = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1);
    var parityBit = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
    var varArray = new Array();
    var intValue;
    var lngProduct = 0;
    var intCheckDigit;
    var intStrLen = num.length;
    var idNumber = num;
    // initialize
    if ((intStrLen != 15) && (intStrLen != 18)) {
        return false;
    }
    // check and set value
    for (i = 0; i < intStrLen; i++) {
        varArray[i] = idNumber.charAt(i);
        if ((varArray[i] < '0' || varArray[i] > '9') && (i != 17)) {
            return false;
        } else if (i < 17) {
            varArray[i] = varArray[i] * factorArr[i];
        }
    }

    if (intStrLen == 18) {
        //check date
        var date8 = idNumber.substring(6, 14);
        if (isDate8(date8) == false) {
            return false;
        }
        // calculate the sum of the products
        for (i = 0; i < 17; i++) {
            lngProduct = lngProduct + varArray[i];
        }
        // calculate the check digit
        intCheckDigit = parityBit[lngProduct % 11];
        // check last digit
        if (varArray[17] != intCheckDigit) {
            return false;
        }
    }
    else {        //length is 15
        //check date
        var date6 = idNumber.substring(6, 12);
        if (isDate6(date6) == false) {
            return false;
        }
    }
    return true;
}
function isDate6(sDate) {
    if (!/^[0-9]{6}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    if (year < 1700 || year > 2500) return false
    if (month < 1 || month > 12) return false
    return true
}

function isDate8(sDate) {
    if (!/^[0-9]{8}$/.test(sDate)) {
        return false;
    }
    var year, month, day;
    year = sDate.substring(0, 4);
    month = sDate.substring(4, 6);
    day = sDate.substring(6, 8);
    var iaMonthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year < 1700 || year > 2500) return false
    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) iaMonthDays[1] = 29;
    if (month < 1 || month > 12) return false
    if (day < 1 || day > iaMonthDays[month - 1]) return false
    return true
}