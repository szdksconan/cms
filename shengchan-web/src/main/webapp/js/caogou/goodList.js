//商品列表
//商品列表
jQuery.fn.extend({
	listGoods:function(opts){
		opts = jQuery.extend({
        	type:1,
        	rows:10,
            callback:function(){}	//回调函数
      	}, opts || {});
      	var innerHtml='',smImg='',url='',pagelist='';
      	switch(opts.type){
			case 1:
				url= _commonUrl+'/recommend/getPurchaseRecommendList';
				break;
			case 2:
				url= _commonUrl+'/recommend/getSupplyRecommendList';
				break;
			default:
				break;
		}
      	
      	ajaxLoad=function(num,rows){
      		$.ajax({
	            type: "POST",     //提交方式
	            dataType: "json",     //类型
	            async:false, 
	            url: url,    //提交的页面，方法名
	            data:{page:num,rows:opts.rows},    //参数，如果没有，可以为null
	            success: function (data) {
	        		loadlist(data.list);
	        		if(data.page != '0'){
	        			pagelist.show();
		        		$.jqPaginator('#pagination', {
		        		    totalPages: data.totalPage,
		         		    visiblePages: opts.rows,
		        		    currentPage: 1,
		        		    onPageChange: function (num, type) {
		        		    	if(type == 'change'){
		        		    		ajaxLoad(num,opts.rows);
		        		    	}
		        		    }
		        		});
	        		}
	        		else{
	        			pagelist.hide();
	        		}
	           	
	            }
	        });
      	}
      	loadlist=function(data){
      		$.each(data,function(index){
	      		innerHtml += '<div class="col-sm-6 col-md-3">';
				innerHtml += '	<div class="thumbnail commodity">';
				innerHtml += '		<a href="javascript:;" class="commodity-lg-img"><img src="'+data[index].imgList[0].img+'"></a>';
				innerHtml += '		<div class="commodity-sm-img">';
				$.each(data[index].imgList, function(i) {
					if(i==0)
						smImg = '<a href="javascript:;" class="opt" title="'+data[index].imgList[i].goodsname+'" data-price="'+data[index].imgList[i].price+'" data-count="'+data[index].imgList[i].count+'" onclick="variation(this)"><img src="'+data[index].imgList[i].img+'"/></a>';
					else
						smImg = '<a href="javascript:;" title="'+data[index].imgList[i].goodsname+'" data-price="'+data[index].imgList[i].price+'" data-count="'+data[index].imgList[i].count+'" onclick="variation(this)"><img src="'+data[index].imgList[i].img+'"/></a>';
					innerHtml += smImg;
				});
				innerHtml += '		</div>';
				innerHtml += '		<div class="commodity-pull clearfix">';
				innerHtml += '			<span class="pull-left pull-price">￥'+parseFloat(data[index].imgList[0].price).toFixed(2)+'</span>';
				innerHtml += '			<span class="pull-right pull-deal">库存'+data[index].imgList[0].count+'</span>';
				innerHtml += '		</div>';
				innerHtml += '		<a href="javascript:;" class="commodity-name" title="'+data[index].imgList[0].goodsname+'">'+data[index].imgList[0].goodsname+'</a>';
				innerHtml += '		<div class="commodity-company">';
				innerHtml += '			<a href="javascript:;">'+data[index].companyname+'</a>';
				innerHtml += '		</div>';
				innerHtml += '		<div class="commodity-address clearfix">';
				innerHtml += '			 <span>'+data[index].address+'</span>';
				innerHtml += '		</div>';
				innerHtml += '	</div>';
				innerHtml += '</div>';
	      	});
	      	var commlist = $('<div class="row" id="commodity"></div>');
			var pagelistbox = $('<div class="sc_gym"></div>');
	        pagelist = $('<ul class="pagination"></ul>');
	        pagelistbox.append(pagelist);
	        commlist.append(innerHtml);
			$(this).append(commlist);
			$(this).append(pagelistbox);
      	}
		variation=function(obj){
			var price = $(obj).attr('data-price'), count = $(obj).attr('data-count'), goodsname = $(obj).attr('title'), imgurl = $(obj).find('img').attr('src');
			$(obj).addClass("opt").siblings().removeClass("opt");
			$(obj).parent().prev().children().attr('src',imgurl);
			$(obj).parent().next().find('.pull-price').html('￥'+parseFloat(price).toFixed(2));
			$(obj).parent().next().find('.pull-deal').html('库存'+count);
			$(obj).parent().siblings('.commodity-name').html(goodsname);
			$(obj).parent().siblings('.commodity-name').attr('title',goodsname);
		}
		opts.callback();
		ajaxLoad(1,opts.rows);
	}

})
//商品筛选列表
jQuery.fn.extend({
	listFilterGoods:function(opts){
		opts = jQuery.extend({
        	data : '',			//数据
        	onClick:function(value,obj){},	//点击事件
            callback:function(){}	//回调函数
      	}, opts || {});
      	var data=opts.data,html = '';
      	$.each(data,function(index){
      		html += '<dl class="filter-list clearfix">';
      		html += '	<dt>'+data[index].name+'</dt>';
      		html += '	<div class="filter-list-li">';
      		$.each(data[index].list, function(i) {
      			if(data[index].list[i].value)
      			html +='<dd class="select-filter" title='+data[index].list[i].name+' value=\''+data[index].list[i].value+'\' onclick="getValue(\''+data[index].list[i].value+'\',this)">'+data[index].list[i].name+'</dd>';
      			else
      			html +='<dd class="select-filter'+(data[index].list[i].choose?' pitch':'')+'" code="'+data[index].list[i].code+'" title='+data[index].list[i].name+' onclick="getValue(\''+data[index].list[i].code+'\',this)">'+data[index].list[i].name+'</dd>';
      		});
      		html += '	</div>';
      		html += '</dl>';
      	});
		$(this).append(html);
		getValue=function(value,obj){
			$(obj).addClass('pitch').siblings().removeClass('pitch');
			opts.onClick(value,obj);
		}
		opts.callback();
	}
})
//企业列表
jQuery.fn.extend({
	companyList:function(opts){
		opts = jQuery.extend({
			data:'',					//数据
			isClick:false,				//是否需要点击选中事件
            isAttention:true,
			yes:function(_this,data){}, //选中事件
			no:function(_this,data){},	//取消事件
			attention:function(_this,data){},//关注
			callback:function(){}		//回调函数
		},opts || {});
		var data=opts.data,html = '',_this=$(this);
		$.each(data, function(index) {
			var product='';
            var _randDivId='Div_'+Math.round(Math.random()*10000);
            data[index].randDivId=_randDivId;
			var warpDiv = $('<div id="'+_randDivId+'" class="company-warp"></div>');
			var name = $('<div><a href="javascript:;" class="company-title">'+data[index].companyName+'</a></div>');
			var logo = $('<div class="company-logo"><img src="'+data[index].logo+'"></div>');
			var list = $('<ul class="companyList"></ul>');
			 $.each(data[index].product, function(i) {
	        	if(i==data[index].product.length-1){
	        		product += data[index].product[i].name;
	        	}else{
	        		product += data[index].product[i].name+',';
	        	}
	        });
			html = '<li><span>所属行业：</span><span>'+data[index].industry+'</span></li>'+
	       		   '<li><span>企业性质：</span><span>'+data[index].nature+'</span></li>'+
	        	   '<li><span>主加工产品：</span><span>'+product+'</span></li>'+
	        	   '<li><span>所在地区：</span><span>'+data[index].address+'</span></li>'+
	        	   '<li><span>经营模式：</span><span>'+data[index].model+'</span></li>';
	        var gzbtn = $('<button class="btn btn-xs btn-blue btn-attention">关注</button>');
	        list.append(html);
	        warpDiv.append(name);
	        warpDiv.append(logo);
	        warpDiv.append(list);
            if (opts.isAttention){
                warpDiv.append(gzbtn);
            }
	    	_this.append(warpDiv);
	    	if(opts.isClick){
	    		warpDiv.on('click',function(){
	    			onClick(this,data[index]);
	    		})
	    	}
	    	gzbtn.on('click',function(){
	    		opts.attention(this,data[index]);
	    	})
		});
		onClick=function(obj,data){
			var opt = '';
			opt ='<i class="pitch"></i>';
			if($(obj).find('.pitch').length==0){
				$(obj).append(opt);
                $(obj).attr('check',true);
				opts.yes(obj,data);
			}else{
				$(obj).find('.pitch').remove();
                $(obj).removeAttr('check');
				opts.no(obj,data);
			}
		}
		opts.callback(data);
	}
})
