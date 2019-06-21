package kr.co.prototype.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginDto {
	
	@NotEmpty(message = "아이디를 입력하세요.")
	private String uid;
	
	@NotEmpty(message = "비밀번호를 입력하세요.")
	private String password;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
