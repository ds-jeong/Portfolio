package com.inface.infaceCBP.web;

/**
 *
 * 기본 VO. 페이징정보 포함.
 *
 */
public class BaseVO {

	/**
	 * 레코드의 rownum
	 */
	private transient int rnum;

	/**
	 * 페이지번호
	 */
	private transient int page;

	/**
	 * 페이지당 레코드수
	 */
	private transient int pageSize;

	/**
	 * 총 페이지 레코드 수
	 */
	private transient int totalRecordCount;

	/**
	 * 더보기 여부. 전체페이지 정보없이 다음 row 가 있는지 여부만 확인.
	 */
	private transient boolean moreView;

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getPage() {
		return page <= 0 ? PageListVO.DEFAULT_PAGE : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize <= 0 ? PageListVO.DEFAULT_PAGE_SIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRownum() {
		return (getPage() - 1) * getPageSize() + 1;
	}

	public int getEndRownum() {
		return getPage() * getPageSize() + (moreView ? 1 : 0);
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public boolean isMoreView() {
		return moreView;
	}

	public void setMoreView(boolean moreView) {
		this.moreView = moreView;
	}

}