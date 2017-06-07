$.post('common/getAreaInfo', function(data) {
    try{
        province = new Array();
        city={};
        area={};
    }catch (e){}
	if (data.province.length!=0){
		data.province.forEach(function(obj){
			province.push({"id":obj.id,"name":obj.name,"provinceAreaId":obj.provinceAreaId});
		});
	}
	if (data.area.length!=0){
		data.area.forEach(function(obj){
			city[obj.pid]={"ids":obj.ids,"names":obj.names};
		});
	}
	if (data.city.length!=0){
		data.city.forEach(function(obj){
			area[obj.pid]={"ids":obj.ids,"names":obj.names};
		});
	}
}, 'JSON');