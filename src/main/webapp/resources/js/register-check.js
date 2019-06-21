$(function() {
	var uid = $('#uid');
	var uid_pattern = /^[a-z]+[a-z0-9]{4,11}$/g;
	var password = $('#password');
	var password2 = $('#password2');
	var password_pattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	var name = $('#name');
	var hp = $('#hp');
	var hp_pattern = /[^0-9]/g;
	var email = $('#email');
	var email_pattern = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;
	
	
		$('#register').click(function (){
		if (uid.val() == '' || uid.val() == null) {
	   		alert("아이디를 입력하세요.");
	   		uid.focus();
	       	
	       	return false;	
    	}
		
  	if (password.val() == '' || password.val() == null) {
   		alert("비밀번호를 입력하세요.");
   		password.focus();
       	
       	return false;	
  	}
  	
  	if (password2.val() == '' || password2.val() == null) {
   		alert("비밀번호를 확인하세요.");
   		password2.focus();
       	
       	return false;	
  	}
  	
  	if (name.val() == '' || name.val() == null) {
   		alert("이름을 입력하세요.");
   		name.focus();
       	
       	return false;	
  	}
  	
  	if (hp.val() == '' || hp.val() == null) {
   		alert("전화번호를 입력하세요.");
   		hp.focus();
       	
       	return false;	
  	}
  	
  	if (email.val() == '' || email.val() == null) {
   		alert("이메일을 입력하세요.");
   		email.focus();
       	
       	return false;	
  	}
		
		if (idCheck == 0) {
			alert('아이디 중복 체크를 해주세요.');
			location.href = '/prototype-become-developer/member/register';
			
			return false;
		}
		
		alert('회원가입되었습니다.');
	});
		
	$('#uid').change(function() {
		if (uid_pattern.test(uid.val()) == false) {
			alert("아이디 형식이 알맞지 않습니다.");
			uid.val('');
			$('#uid').focus();
			
			return false;
		}
	});
	
	$('#password').change(function() {
		if (password_pattern.test(password.val()) == false) {
			alert("특수문자, 영문 대문자를 포함하여야 합니다.");
			password.val('');
			$('#password').focus();
	
			return false;
		}
	});
	
	$('#hp').change(function() {
		if (hp_pattern.test(hp.val()) == true) {
			alert("숫자만 입력 가능합니다.");
			hp.val('');
			$('#hp').focus();
			
			return false;
		}
	});
	
	$('#email').change(function() {
		if (email_pattern.test(email.val()) == false) {
			alert("이메일 형식이 알맞지 않습니다.");
			email.val('');
			$('#email').focus();
			
			return false;
		}
	});
	
	$('#password2').change(function (){
  	if (password.val() !=  password2.val()) {
   		alert("비밀번호가 일치하지 않습니다.");
   		password2.val('');
   		password2.focus();
       	
       	return false;	
  	}
	});
	
	$('#idCheck').click(function() {
		var idCheck = 0;
		var uid = $('#uid').val();
		
		$.ajax({
			type : 'POST',
			data : uid,
			url : '/prototype-become-developer/member/existUid',
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				if (data.count > 0) {
					alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					$('#uid').val('');
					$('#uid').focus();
					return false;
				}
				
				alert("사용가능한 아이디입니다.");
				$('#password').focus();
					
				idCheck = 1;
			},
			
			error:function(request,status,error) {
				alert("code = "+ request.status + " message = " + request.responseText + " error = " + error);
		    }
			
		});
	});
		
});