	function addServicePackage(id){
		var tag = $('#salestag').val();
			if(tag != '0'){
				$.ajax({
			        type: "POST",
			        url : 'vaservice/add?id='+id,
			        cache: true,
			        dataType : "json",
			        success: function(data){
			        	//alert('success!')
			        $.bootstrapGrowl("操作成功!", {
		            	  type: 'success', // (null, 'info', 'danger', 'success')
		            	  align: 'center', // ('left', 'right', or 'center')
		            	  offset: {from: 'top', amount:288}, // 'top', or 'bottom'
		            	  width: 140, // (integer, or 'auto')
		            	  delay: 300, 
		            	  allow_dismiss: false, // If true then will display a cross to close the popup.
		            });
			        	changeDiv('vaservice/vaserviceList');
			        }
			   }); 	
			}
			else{
				$.messager.alert('提示', "该套餐不允许购买!", 'info');
			}
	}
	