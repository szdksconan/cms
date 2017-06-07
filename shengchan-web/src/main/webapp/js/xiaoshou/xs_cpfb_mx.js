//图片预览
var number = parseInt(100*Math.random());
var imgList = ' #uploadList';
//$('#'+_randomId+' ul[name=uploadList]').attr("id",imgList);
$('#'+_randomId+" button[name=uploadBtn]").uploadPreview({ListId:'#'+_randomId+imgList,fileId:'fileId'+number});
//发布类型加载
/*$('#'+_randomId+' #unitId').multiselect('dataprovider', _zNodes);*/
$('#'+_randomId+' #unitBox').cxSelect({
        data:_zNodes,
        selects:['unit']
    });

$('#'+_randomId+' #btn_addconfig').live('click',function() {
	var tipcon = '<div class="collocate" id="'+number+'">'+
            		'<span>参数名称：<input type="text" id="configName2"  class="cmao_inplg" placeholder="如：体重"/></span>'+
            		'<span class="collocate-tow">参数值： <input type="text" id="configValue2" class="cmao_inplg" placeholder="如：50kg"/></span>'+
            		'<a href="javascript:;" onclick=delConfig(this)>删除</a>'+
            	'</div>';
    $('#'+_randomId+' #configArea').append(tipcon);
});

function delConfig(obj){
	$(obj).parent().remove();
}

$("#"+_randomId+ " input[city=true]").click(function (e) {
    SelCity(this,e,{
        positions:'fixed'
    });
});

$("#"+_randomId+' #ipoTime').val(laydate.now());