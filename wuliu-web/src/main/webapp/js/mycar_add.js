$(function(){
	/**
	 * 初始化省市区
	 */
    if (province.length>0){
        var html='<option value="0"></option>';
        for (var i=0;i<province.length;i++){
            html+='<option value="'+province[i].id+'">'+province[i].name+'</option>';
        }
        $('#begin_cheyuan_province2').append(html);
        $('#end_cheyuan_province2').append(html);
    }


	
	//添加车辆	
$('#carfrom').form({
	url : 'mycar/addCar',
	onSubmit : function() {
		var carNo = $('#carNo').val();
		var carWeigth = $('#carWeigth').val();
		var carOwner = $('#carOwner').val();
		var carTel = $('#carTel').val();
		var carLineDesc = $('#carLineDesc').val();
		if(carNo == undefined || carNo == ''){
			alert('车牌号不能为空!');
			return false;
		}
		if(carTel == undefined || carTel == ''){
			alert('随车电话不能为空!');
			return false;
		}
		if(carWeigth == undefined || carWeigth == ''){
			alert('载重不能为空!');
			return false;
		}
		if(carOwner == undefined || carOwner == ''){
			alert('车主不能为空!');
			return false;
		}
		return true;
	},
	success : function(result) {
		result = $.parseJSON(result);
		if (result.success) {
			$('#carfrom')[0].reset();
			query();
	        $.bootstrapGrowl("添加成功!", {
          	  type: 'success', // (null, 'info', 'danger', 'success')
          	  align: 'center', // ('left', 'right', or 'center')
          	  offset: {from: 'top', amount:288}, // 'top', or 'bottom'
          	  width: 140, // (integer, or 'auto')
          	  delay: 300, 
          	  allow_dismiss: false, // If true then will display a cross to close the popup.
          });
		}else {
			//alert(result.msg);
	        $.bootstrapGrowl("添加失败!", {
          	  type: 'danger', // (null, 'info', 'danger', 'success')
          	  align: 'center', // ('left', 'right', or 'center')
          	  offset: {from: 'top', amount:288}, // 'top', or 'bottom'
          	  width: 140, // (integer, or 'auto')
          	  delay: 300, 
          	  allow_dismiss: false, // If true then will display a cross to close the popup.
          });
		}
	}
});


});

//下拉框联动
function searchAreaStart2(pid,id,name,_provinceAreaId) {

	// 1:拿到select对象：
    var myselect = document.getElementById(pid);
    // 2：拿到选中项的索引：
    var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index

    // 3:拿到选中项options的value：
    var html = '<option value=\'\' ></option>';
   // console.log(_provinceAreaId);
   $('#'+name).val( myselect.options[index].text);  
    if (_provinceAreaId){
        $('#'+_provinceAreaId).val(province[index-1].provinceAreaId);
    }
    for (var i = 0; i < areacity.length; i++) {
        if (areacity[i].pid == myselect.options[index].value) {
            var names = areacity[i].names.split(",");
            var ids = areacity[i].ids.split(",");
            for (var j = 0; j < names.length; j++)

                html += '<option value="' + ids[j] + '">' + names[j]
                + '</option>';
        }

	}
	$('#'+id).html(html);
}
//下拉框联动
function searchCityStart2(pid,id,name){
	   var myselect2 = $('#'+pid).val();
    if (myselect2!=0){
    	var myselect = document.getElementById(pid);
  	  // 2：拿到选中项的索引：
    	var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index
        $('#'+name).val( myselect.options[index].text);  
     
    
        var html = '<option value=\'\' ></option>';
        var city_array=area[myselect2];
        try{
            var ids=city_array.ids.split(',');
            var names=city_array.names.split(',')
            for (var i=0;i<ids.length;i++){
                html+='<option value="'+ids[i]+'">'+names[i]+'</option>';
            }
        }catch (e){}
        $('#'+id).html(html);
    }
}
//下拉框联动
function searchAreaStart3(pid,name){
	 var myselect2 = $('#'+pid).val();
	    if (myselect2!=0){
	    	var myselect = document.getElementById(pid);
	  	  // 2：拿到选中项的索引：
	    	var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index
	        $('#'+name).val( myselect.options[index].text);  
	    }
}
