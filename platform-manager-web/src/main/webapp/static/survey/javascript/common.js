//设置cookie
function setCookie(name,value){
	var Days =30;
	var exp =new Date();
	exp.setTime(exp.getTime()+Days*24*60*60*1000);
	document.cookie = name +"="+encodeURIComponent(value)+";expires="+exp.toUTCString();
}

//获取cookie
function getCookie (name){
	var arr,reg =new RegExp("(^|)"+name+"=([^;]*)(;|$)");
	if(arr = document.cookie.match(reg)){
		return decodeURIComponent(arr[2]);
	}else{
		return null;
	}
}
//删除cookie
function delCookie(name){
	var exp =new Date();
	exp.setTime(exp.getTime()-1);
	var cval =getCookie(name);
	if(cval!=null){
		document.cookie = name+ "="+cval+";expires="+exp.toUTCString();
	}
}

// url 参数
var getArgs = function (){
	var args = new Object(); 
	var query = window.location.search.substring(1); 
	var pairs = query.split("&"); 
	for(var i = 0; i < pairs.length; i++) {
		var pos = pairs[i].indexOf('=');
		if (pos == -1) continue; 
		var argname = pairs[i].substring(0,pos);
		var value = pairs[i].substring(pos+1); 
		value = decodeURIComponent(value); 
		args[argname] = value; 
	}
	return args; 
}

function getByClass(oParent,sClass){
	var aEle = oParent.getElementsByTagName('*');
	var arr = [];
	for(var i=0;i<aEle.length;i++){
		if( sClass == aEle[i].className ){
			arr.push( aEle[i] );
		}
	}
	return arr;
}

//弹框
function ReminderArert(text,callBack)
{
	var openDiv = $("<div class='ReminderArert box-pack'></div>");
	var openDiv1 = $("<div class='ReminderBox'></div>");
	var openDiv2 = $("<h1>提示</h1>");
	var openDiv3 = $("<h2>"+text+"</h2>");
	var openDiv4 = $("<h3>确定</h3>");
	openDiv.append(openDiv1);
	openDiv1.append(openDiv2);
	openDiv1.append(openDiv3);
	openDiv1.append(openDiv4);
 	$("body").append(openDiv);
	if(!callBack){
		$(".ReminderBox").find("h3").click(function(){
			$(this).parent().parent().remove();	
		});
	}else{
		$(".ReminderBox").find("h3").click(function(){
			callBack();
			$(this).parent().parent().remove();
		});
	}	
}

	



//问卷试题
function researchExam(researchId){  
	var reqUrl = '/mi_message/researchExam';
	var reqData = {'researchId':researchId};
	$.ajax({
		url:reqUrl,
		type : 'post',
		data:reqData,
		dataType : "json",
		success: function(data){  
			var checkboxHtml = '';
			if(data.head.rspCode=='0'){
				var exam = data.body.exam;
				var selection = data.body.selection;
				var researchId = data.body.researchId;  //问卷ID
				//$('header p').html(data.body.description);
				$('header h3').html(data.body.title);
				$('#p1').html(data.body.pubTime);
				$('#p2').html(data.body.description);
				for(var i=0;i<exam.length;i++){
					if(exam[i].type=='2'){
						checkboxHtml += '<dl class="checkoxs">';
					}else{
						checkboxHtml += '<dl class="radios">';
					}
					checkboxHtml += '<dt>'+exam[i].description+'</dt>';
					for(var j=0;j<selection.length;j++){
						if(selection[j].examId==exam[i].id){
							checkboxHtml += '<dd>';
							checkboxHtml += '	<span name="'+selection[j].grade+'_'+selection[j].id+'"><i></i></span>';
							checkboxHtml += '	<label>'+selection[j].description+'</label>';
							checkboxHtml += '</dd>';
						}
					}
					checkboxHtml += '</dl>';
				}
				$('#surveList').html(checkboxHtml);
				$('.checkoxs span').click(function(){
					if($(this).hasClass('checked_list')){
						$(this).removeClass('checked_list');		
					}else{
						$(this).addClass('checked_list');
					}
				});

				$('.radios span').click(function(){
					$('.radios').removeClass('checked_parent');
					$(this).parent().parent().addClass('checked_parent');
					$('.checked_parent span').removeClass('checked_list');
					$(this).addClass('checked_list');
				});

				var oList = document.getElementById('surveList'); 
				$('.surveBtn').click(function(){
					var aCheckedList = getByClass(oList,'checked_list');
					for(var i=0;i<aCheckedList.length;i++){
						var grade = aCheckedList[i].getAttribute('name').split('_')[0];
						var selectionId = aCheckedList[i].getAttribute('name').split('_')[1];
						var oJsons = {'selectionId':selectionId,'grade':grade};
						answer.push(oJsons);
					}
					submitFn(researchId,answer,communityId,roomId,userId);
				});

			}else{
				ReminderArert(data.head.rspMsg);
			}
		}
	});
}

function submitFn(researchId,answer,communityId,roomId,userId){
	var reqUrl = '/mi_message/answerResearch';
	var reqData = {'researchId':researchId,'communityId':communityId,'roomId':roomId,'userId':userId,'answer':JSON.stringify(answer)};
	$.ajax({
		url : reqUrl,
		type : 'post',
		data : reqData,
		dataType : 'json',
		success:function(data){
			if(data.head.rspCode == '0'){
//				ReminderArert(data.head.rspMsg);
				ReminderArert("提交成功",function(){
					location.href="app://back";
				});
			}else{
				ReminderArert(data.head.rspMsg);
			}
		}
	});
}
