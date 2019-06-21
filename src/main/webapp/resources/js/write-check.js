$(function() {
	$('#write').click(function() {
		var subject = $('#subject');
    var contents = $('#contents');
    	
    if (subject.val() == '' || subject.val() == null) {
	  	alert("제목을 입력하세요.");
	  	subject.focus();
	       	
	     	return false;	
    }
    if (contents.val() == '' || contents.val() == null) {
	  	alert("내용을 입력하세요.");
	  	contents.focus();
	      	
	     	return false;	
    }
        
   });
	
	$('#subject').keyup(function() {
		if ($(this).val().length > 40) {
			alert('제목은 40자 이내로 작성 가능합니다.');
			$(this).val($(this).val().substring(0,40));
		}
	});
	
	$('#contents').keyup(function() {
		if ($(this).val().length > 2500) {
			alert('글자 수  2500자 이내로 작성 가능합니다.');
			$(this).val($(this).val().substring(0,2500));
		}
  });
	
	$("input[name='file']").change(function() {
		var maxSize = 7340032;
		var fileSize = this.files[0].size;

		if (fileSize > maxSize) {
			alert("첨부파일 사이즈는 7MB 이내로 업로드 가능합니다.");
			$(this).val('');
			
			return false;
		}
  });
	
});