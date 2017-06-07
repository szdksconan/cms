$(function () {
		query_mycar();
		//加载一些地图配置
		map.centerAndZoom('中国',5);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
		map.enableScrollWheelZoom();
		map.addControl(new BMap.NavigationControl());    
		$('#provinceList').attr("disabled",true);
		$('#areaList').attr("disabled",true); 
		map.setMinZoom(5);
		//移除拖拽查询时间
		map.removeEventListener("dragend",dragend);
	});
	//我的关注列表
	function query_mycar(){
		var carNo = $('#carNo').val();
		$('#example_mycar').html('');
		 $.ajax({
		      url: "caronline/getPageDataMyfocus",
		      datatype: 'json',
		      type: "Post",
		      data: {carNo:carNo,page:1},
		      success: function (data) {
		        if (data != null) {
		        	data = $.parseJSON(data);  
		          var html='';
		          $.each(data.list, function (index, item) { //遍历返回的json
		        	  html += '<tr>';
		        	  html += '<td>'+item.carNo;
		       		  html += '</td>';
		       		  html += '<td>'+item.carOwner;
		       		  html += '</td>';
		       		  html += '<td>'+item.carCondition;
		   		  	  html += '</td>';
		   		   	  html += '<td>'+item.carLineDesc;
		   		  	  html += '</td>';
		       		  html += '<td>';
		       		  html += '<a href=\"javascript:void(0);\" onclick=\"openmarker('+item.carLongitude+','+item.carLatitude+')\" style=\"cursor: pointer;\"><span>定位</span></a>';
		       		  html +='&nbsp;|&nbsp;';
		       		  html += '<a href=\"javascript:void(0);\"  onclick=\"refocus(this,\''+item.id+'\',0)\" style=\"cursor: pointer;\"><span>取消关注</span></a>';
		       		  html +='&nbsp;|&nbsp;';
		       		  html += '<a href=\"javascript:void(0);\" onclick=\"openmsg(\''+item.carNo+'\','+item.carTel+',\''+item.carOwner+'\')\"   data-toggle=\"modal\" data-target=\"#myModal\" style=\"cursor: pointer;\"><span>发送短信</span></a>';
		       		  html += '</td>';
		        	  html += '</tr>';
		        	
		          });
		          $("#data_table_mycar").html(html);
		          searchMap(data.maplist,2);
		          var pageCount = data.pageCount; //取到pageCount的值(把返回数据转成object类型)
		          var currentPage =  data.CurrentPage; //得到urrentPage
		          var options = {
		        	size:'mini',
		            bootstrapMajorVersion: 2, //版本
		            currentPage: currentPage, //当前页数
		            totalPages: pageCount, //总页数
		            itemTexts: function (type, page, current) {
		              switch (type) {
		                case "first":
		                  return "<<";
		                case "prev":
		                  return "<";
		                case "next":
		                  return ">";
		                case "last":
		                  return ">>";
		                case "page":
		                  return page;
		              }
		            },//点击事件，用于通过Ajax来刷新整个list列表
		            onPageClicked: function (event, originalEvent, type, page) {
		            	 $.ajax({
		            	      url: "caronline/getPageDataMyfocus",
		            	      datatype: 'json',
		            	      type: "Post",
		            	      data: {carNo:carNo,page:page},
		            	      success: function (data) {
		            	        if (data != null) {
		            	        	data = $.parseJSON(data);  
		            	        	  var html='';
		            	             $.each(data.list, function (index, item) {
		            	              html += '<tr >';
		           		        	  html += '<td>'+item.carNo;
		           		       		  html += '</td>';
		           		       		  html += '<td>'+item.carOwner;
		           		       		  html += '</td>';
		           		       		  html += '<td>'+item.carCondition;
		           		   		  	  html += '</td>';
		           		   		   	  html += '<td>'+item.carLineDesc;
		           		   		  	  html += '</td>';
		           		       		  html += '<td>';
		           		       		  html += '<a href=\"javascript:void(0);\" onclick=\"openmarker('+item.carLongitude+','+item.carLatitude+')\" style=\"cursor: pointer;\"><span>定位</span></a>';
		           		       		  html +='&nbsp;|&nbsp;';
		           		       	  	  html += '<a href=\"javascript:void(0);\"  onclick=\"refocus(this,\''+item.id+'\',0)\" style=\"cursor: pointer;\"><span>取消关注</span></a>';
	           		       		  	  html +='&nbsp;|&nbsp;';
		           		       		  html += '<a href=\"javascript:void(0);\" onclick=\"openmsg(\''+item.carNo+'\','+item.carTel+',\''+item.carOwner+'\')\"   data-toggle=\"modal\" data-target=\"#myModal\" style=\"cursor: pointer;\"><span>发送短信</span></a>';
		           		       		  html += '</td>';
		           		        	  html += '</tr>';
		            	             });
		            	             $("#data_table_mycar").html(html);
		            	             //Map添加marker
		            	            searchMap(data.maplist,2);
		            	        }
		            	      }
		            	 });
		            }
		          };
		         
		          if(data.pageCount > 0){
		         	 $('#example_mycar').bootstrapPaginator(options);
		          }
		        }
		      }
		    });
	}
	//取消关注
    function refocus(obj,id,state){  
    	//$(obj).parent().parent().remove();    
    	changeFocus(id,state);
    	query_mycar();
    }  