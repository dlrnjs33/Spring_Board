package kr.co.prototype.domain.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	private int member_seq;

	@NotEmpty(message = "아이디를 입력하세요.")
	@Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$")
	private String uid;

	@NotEmpty(message = "비밀번호를 입력하세요.")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
	private String password;

	@NotEmpty(message = "이름을 입력하세요.")
	private String name;

	private int gender;

	@NotEmpty(message = "전하번호를 입력하세요.")
	@Pattern(regexp = "^[0-9]+$")
	private String hp;

	@NotEmpty(message = "이메일을 입력하세요.")
	@Pattern(regexp = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$")
	private String email;

	private String addr1;
	private String addr2;
	private String regdate;

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberVO [member_seq=" + member_seq + ", uid=" + uid + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", hp=" + hp + ", email=" + email + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", regdate=" + regdate + "]";
	}

}
