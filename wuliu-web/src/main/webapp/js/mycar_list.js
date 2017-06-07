 $(function () {
        query();
        
    });
    //我的车库查询方法
	function query(){
		var carNo = $('#carNo2').val();
		var city = $('#city').val();
		//首先置空分页标签
		$('#example').html('');
		 $.ajax({
		      url: "mycar/getMyCarData",
		      datatype: 'json',
		      type: "Post",
		      data: {city:city,carNo:carNo,page:1},
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
		       		  html += '<td>'+item.carLineDesc;
		   		 	  html += '</td>';
		   			  html += '<td>'+item.carTypeName;
		   		 	  html += '</td>';
		   		      html += '<td>'+item.carLocationCity;
		   		 	  html += '</td>';
		   		  	  html += '<td>'+item.carLocationTime;
		   		 	  html += '</td>';
		   		 	  html += '<td>'
		   		   	  html += '<a href=\"javascript:void(0);\" onclick=\"delCarAndRelative(\''+item.id+'\',\''+item.carId+'\')\"    style=\"cursor: pointer;\"><span>删除</span></a>';
 		   		   	  html += '|'
 		   		   	  html += '<a href=\"javascript:void(0);\" onclick=\"publish(\''+item.carId+'\')\"    style=\"cursor: pointer;\"><span>车源发布</span></a>';
		       		  html += '</td>';
		        	  html += '</tr>';
		        	
		          });
		          $("#msgtable").html(html);
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
		            	      url: "mycar/getMyCarData",
		            	      datatype: 'json',
		            	      type: "Post",
		            	      data: {city:city,carNo:carNo,page:page},
		            	      success: function (data) {
		            	        if (data != null) {
		            	        	data = $.parseJSON(data);  
		            	        	  var html='';
		            	             $.each(data.list, function (index, item) { //遍历返回的json
		            	           	  html += '<tr>';
		        		        	  html += '<td>'+item.carNo;
		        		        	  html += '</td>';
		        		       		  html += '<td>'+item.carOwner;
		        		       		  html += '</td>';0
		        		       		  html += '<td>'+item.carLineDesc;
		        		   		 	  html += '</td>';
		        		   			  html += '<td>'+item.carTypeName;
		        		   		 	  html += '</td>';
		        		   		      html += '<td>'+item.carLocationCity;
		        		   		 	  html += '</td>';
		        		   		  	  html += '<td>'+item.carLocationTime;
		        		   		 	  html += '</td>';
		        		   			  html += '<td>'
		        			   		  html += '<a href=\"javascript:void(0);\" onclick=\"delCarAndRelative(\''+item.id+'\',\''+item.carId+'\')\"    style=\"cursor: pointer;\"><span>删除</span></a>';
 		        			   		  html += '|'
 		        				      html += '<a href=\"javascript:void(0);\" onclick=\"publish(\''+item.carId+'\')\"   style=\"cursor: pointer;\"><span>快捷发布</span></a>';
		        			   		  html += '</td>';
		        		        	  html += '</tr>';
		            	           	
		            	             });
		            	             $("#msgtable").html(html);
		            	        }
		            	      }
		            	 });
		            }
		          };
			      if(data.pageCount > 0){
			          $('#example').bootstrapPaginator(options);
			      }
		        }
		     
		      }
		    });
	}
	//弹出
	function add() {
		
				document.getElementById("mycaradd").style.display = "block";
				$('#mycaradd2').load('mycar/add');
		}
	//快捷发布
	function publish(id){
		//document.getElementById("mycaradd").style.display = "block";
		//$('#mycaradd2').load('mycar/publish');
		//alert(id);
			  $.ajax({
		      url: "mycar/getLastCheyuanCot",
		      datatype: 'json',
		      type: "Post",
		      data: {carId:id},
		      async: false,//使用同步的方式,true为异步方式
		      success: function (data) {
		   			if(data.tag == 1){
		   		       $.modalDialog({
		   	            title : '车源发布',
		   	            width : 1280,
		   	            height : 620,
		   	            href : 'infopublish/loadCheyuan?id='+id
		   	       	 	});
		   			}
		   			else{
		   				$.messager.alert('提示', "与此车辆相关车源信息未过期，不能再次发布!", 'info');
		   			}
		      }
		    });
	
	}
	//隐藏
	function closeInfo() {
			document.getElementById("mycaradd").style.display = "none";
			
		}
	//删除关联车辆
	function delCarAndRelative(id,carId){
		  $.ajax({
		      url: "mycar/delCarAndRelative",
		      datatype: 'json',
		      type: "Post",
		      data: {id:id,carId:carId},
		      async: false,//使用同步的方式,true为异步方式
		      success: function (data) {
		        if (data != null) { 
		            $.bootstrapGrowl("删除成功!", {
		            	  type: 'success', // (null, 'info', 'danger', 'success')
		            	  align: 'center', // ('left', 'right', or 'center')
		            	  offset: {from: 'top', amount:288}, // 'top', or 'bottom'
		            	  width: 140, // (integer, or 'auto')
		            	  delay: 300, 
		            	  allow_dismiss: false, // If true then will display a cross to close the popup.
		            });
		        	 query();
				}
		      }
		    });
	}