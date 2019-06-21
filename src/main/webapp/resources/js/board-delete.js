$(function() {
	$('#delete').click(function() {
		var deleteData = $('#deleteData');
		var seq = deleteData.data("seq");
		var boardFileSeq = deleteData.data("boardFileSeq");
		var uid = deleteData.data("uid");
		var data = {
				"boardFileSeq" : boardFileSeq,
				"uid" : uid
		};
		
		$.ajax({
			type : 'DELETE',
			url : '/prototype-become-developer/board/' + seq,
			data : JSON.stringify(data),
			dataType : 'text',
			contentType : 'application/json',
			success : function(data) {
				alert(data);
				location.href= '/prototype-become-developer';
			},
			
			error : function(request, status, error) {
				alert("code = " + request.status
						+ " message = "
						+ request.responseText
						+ " error = " + error);
			}
			
		});
		
	});
});