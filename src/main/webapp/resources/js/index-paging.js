$(function() {
	$('.page').click(function() {
		
		var test = $(".page").attr('value');
		alert(test);
		console.log("test : " + test);
		
		/*$.ajax({
				type : 'get',
				url : '/prototype-become-developer/',
				success : function(data) {
					location.href= '/prototype-become-developer';
				},
	
				error : function(request, status, error) {
					alert("code = " + request.status
							+ " message = "
							+ request.responseText
							+ " error = " + error);
				}
									
			});*/
	});
});