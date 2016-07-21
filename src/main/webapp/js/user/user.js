$(function(){
	$("#searchUser").click(function(){
		$("#sform").submit();
	});
	
	$("#editUser").click(function(){
		$("#eform").submit();
	});
	
	$("#restful").click(function(){
		var id = 1;
		$.ajax({
			type : "post",
			dataType : "json",
			url : "/springMVCdemo/web/user/toRest/" + id,
			success : function(data){
				alert(1);
			}	
		});
	});
});