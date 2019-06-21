$(function() {
	$('#modify').click(function() {
		var form = $("#form");
		var formData = form.serializeArray();
		var seq = form.data("seq");
		var boardFileSeq = form.data("boardFileSeq");
		var deleteCheck = $("#file").val();
		
		formData.push({"name":"seq","value":seq})
		formData.push({"name":"boardFileSeq","value":boardFileSeq});
		formData.push({"name":"deleteCheck","value":deleteCheck});
		
		var data = {};
		
		$.map(formData, function(n, i){
			data[n['name']] = n['value'];
		});
		
		$.ajax({
				type : 'PUT',
				url : '/prototype-become-developer/board/' + seq,
				data : JSON.stringify(data),
				dataType : "text",
				contentType: "application/json",
				success : function(data) {
					if (data == "success") {
						alert(data);
						if (boardFileSeq == null || deleteCheck != null) {
							location.href = '/prototype-become-developer/board/' + seq;
							
							return false;
						}
						location.href = '/prototype-become-developer/board/' + seq + '?boardFileSeq=' + boardFileSeq;
						return false;
					} else if(data == "fail") {
						alert("제목과 내용이 없습니다.");
						location.href = '/prototype-become-developer/board/' + seq;
						return false;
					}
						alert(data);
						location.href = '/prototype-become-developer';
					
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