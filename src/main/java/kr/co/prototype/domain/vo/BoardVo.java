package kr.co.prototype.domain.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BoardVo {

	private int seq;

	@NotEmpty(message = "제목을 입력하세요.")
	@Length(min = 1, max = 40, message = "40자이하로 입력하세요.")
	private String subject;

	@NotEmpty(message = "내용을 입력하세요.")
	@Length(min = 1, max = 2500, message = " 2500자 이하로 입력하세요.")
	private String contents;

	@NotEmpty(message = "아이디를 입력하세요.")
	@Pattern(regexp = "^[0-9a-zA-Z]*$", message = "영문, 숫자만 입력하세요.")
	private String uid;
	private String regDate;
	private String updateDate;
	private Integer boardFileSeq;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegdate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getBoardFileSeq() {
		return boardFileSeq;
	}

	public void setBoardFileSeq(Integer boardFileSeq) {
		this.boardFileSeq = boardFileSeq;
	}

	public BoardVo() {

	}

	public BoardVo(int seq) {
		this.seq = seq;
	}

	public BoardVo(int seq, Integer boardFileSeq) {
		this.seq = seq;
		this.boardFileSeq = boardFileSeq;
	}

	public BoardVo(int seq, String uid) {
		this.seq = seq;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", subject=" + subject + ", contents=" + contents + ", uid=" + uid + ", regDate="
				+ regDate + ", updateDate=" + updateDate + ", boardFileSeq=" + boardFileSeq + "]";
	}

}
