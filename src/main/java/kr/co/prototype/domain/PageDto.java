package kr.co.prototype.domain;

public class PageDto {
	private int pageSize;
	private int firstPageNo;
	private int prePageNo;
	private int startPageNo;
	private int pageNo;
	private int endPageNo;
	private int nextPageNo;
	private int finalPageNo;
	private int totalCount;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrePageNo() {
		return prePageNo;
	}

	public void setPrePageNo(int prePageNo) {
		this.prePageNo = prePageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void makePaging() {
		if (this.totalCount == 0) {
			return;
		}
		if (this.pageNo == 0) {
			this.setPageNo(1);
		}
		if (this.pageSize == 0) {
			this.setPageSize(10);
		}

		int finalPage = (totalCount + (pageSize - 1)) / pageSize;
		if (this.pageNo > finalPage) {
			this.setPageNo(finalPage);
		}
		if (this.pageNo < 0) {
			this.pageNo = 1;
		}

		int startPage = ((pageNo - 1) * 10);
		int endPage = startPage + 10 - 1;

		if (endPage > finalPage) {
			endPage = finalPage;
		}

		this.setFirstPageNo(1);
		this.setStartPageNo(startPage);
		this.setEndPageNo(endPage);

		boolean isNowFirst = pageNo == 1 ? true : false;
		boolean isNowFinal = pageNo == finalPage ? true : false;

		if (isNowFirst) {
			this.setPrePageNo(1);
		} else {
			this.setPrePageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1)));
		}

		if (isNowFinal) {
			this.setNextPageNo(finalPage);
		} else {
			this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1)));
		}
		this.setFinalPageNo(finalPage);
	}

	@Override
	public String toString() {
		return "PageVO [pageSize=" + pageSize + ", firstPageNo=" + firstPageNo + ", prePageNo=" + prePageNo
				+ ", startPageNo=" + startPageNo + ", pageNo=" + pageNo + ", endPageNo=" + endPageNo + ", nextPageNo="
				+ nextPageNo + ", finalPageNo=" + finalPageNo + ", totalCount=" + totalCount + "]";
	}

}
