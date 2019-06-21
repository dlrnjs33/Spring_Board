$(function() {
    $('#login').click(function() {
    	var loginUid = $('#loginUid');
    	var loginPassword = $('#loginPassword');
    	
    	if (loginUid.val() == '' || loginUid.val() == null) {
	   		alert("아이디를 입력하세요.");
	   		loginUid.focus();
	       	
	       	return false;
    	}
    	
    	if (loginPassword.val() == '' || loginPassword.val() == null) {
	   		alert("비밀번호를 입력하세요.");
	   		loginPassword.focus();
	       	
	       	return false;
    	}
    	
    	var data = {
				"uid" : loginUid.val(),
				"password" : loginPassword.val()
		}
    	
    	$.ajax({
    		type : 'POST',
    		data : data,
			url : '/prototype-become-developer/member/login',
			success : function(data){
				if(data.name != null) {
					alert(data.name + '님 반갑습니다.');
					location.href= '/prototype-become-developer';
					return false;
				}
				
				alert('일치하는 회원이 없습니다.');
				location.href= '/prototype-become-developer/member/login';
			}
		});
    	
    });
});