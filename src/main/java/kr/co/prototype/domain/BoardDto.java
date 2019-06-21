package kr.co.prototype.domain;

import kr.co.prototype.domain.vo.BoardVo;
import kr.co.prototype.domain.vo.FileVo;

public class BoardDto extends BoardVo {
	private String boardSearch;
	private String select;
	private int numbering;
	private FileVo fileVo;

	private String deleteCheck;

	public String getDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(String deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	public FileVo getFileVo() {
		return fileVo;
	}

	public void setFileVo(FileVo fileVo) {
		this.fileVo = fileVo;
	}

	public int getNumbering() {
		return numbering;
	}

	public void setNumbering(int numbering) {
		this.numbering = numbering;
	}

	public String getBoardSearch() {
		return boardSearch;
	}

	public void setBoardSearch(String boardSearch) {
		this.boardSearch = boardSearch;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public BoardDto() {

	}

	public BoardDto(int seq) {
		super(seq);
	}

	public BoardDto(int seq, Integer boardFileSeq) {
		super(seq, boardFileSeq);
	}

	public BoardDto(int seq, String uid) {
		super(seq, uid);
	}

	@Override
	public String toString() {
		return "BoardDto [boardSearch=" + boardSearch + ", select=" + select + ", numbering=" + numbering + ", fileVo="
				+ fileVo + ", toString()=" + super.toString() + "]";
	}

}
