package kr.co.prototype.domain.vo;

public class FileVo {
	private Integer seq = null;
	private String originalFileName;
	private String storedFileName;
	private int fileSize;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public FileVo() {

	}

	public FileVo(String originalFileName, String storedFileName, int fileSize) {
		this.originalFileName = originalFileName;
		this.storedFileName = storedFileName;
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileVo [seq=" + seq + ", originalFileName=" + originalFileName + ", storedFileName=" + storedFileName
				+ ", fileSize=" + fileSize + "]";
	}

}
