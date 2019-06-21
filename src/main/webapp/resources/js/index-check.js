$(function() {
	$('#writeContents').click(function() {
		var seq = 'new';

		$.ajax({
				type : 'POST',
				url : '/prototype-become-developer/member/loginCheck',
				dataType : "json",
				success : function(data) {
					if (data.count < 1) {
						alert("로그인 후에 이용가능합니다.");
						location.href= '/prototype-become-developer/member/login';
					}
					
				},
	
				error : function(request, status, error) {
					alert("code = " + request.status
							+ " message = "
							+ request.responseText
							+ " error = " + error);
				}
									
			});
	});
	
	$('#search').click(function() {
  	var boardSearch = $('#boardSearch');
  	
  	if (boardSearch.val() == '' || boardSearch.val() == null) {
   		alert("검색어를 입력하세요.");
   		boardSearch.focus();
       	
       	return false;	
  	}
  });
	
});