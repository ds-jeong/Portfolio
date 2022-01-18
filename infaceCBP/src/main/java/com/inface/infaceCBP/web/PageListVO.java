package com.inface.infaceCBP.web;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Getter
@Setter
public class PageListVO<T> implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 페이지 결과와 메타정보를 담는 객체
	 */
	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int DEFAULT_PAGE_NAVI_SIZE = 10;

	private List<T> resultList;
	private int curPage;
	private int pageSize;
	private int totalCount;
	private int pageNaviSize;
	private boolean next;

	/**
	 * @param resultList
	 * @param curPage
	 * @param pageSize
	 * @param totalCount
	 */
	public PageListVO(List<T> resultList, int curPage, int pageSize, int totalCount) {
		this(resultList, curPage, pageSize, totalCount, false);
	}

	/**
	 * @param resultList
	 * @param curPage
	 * @param pageSize
	 * @param totalCount
	 * @param next
	 */
	public PageListVO(List<T> resultList, int curPage, int pageSize, int totalCount, boolean next) {
		this.resultList = resultList;
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pageNaviSize = PageListVO.DEFAULT_PAGE_NAVI_SIZE;
		this.next = next;
		// validatePagedInfo();
	}

	/**
	 * 설정된 property validate 및 계산값 처리
	 */
	public final void validatePagedInfo() {
		int totalPage = getTotalPage();
		curPage = Math.max(1, Math.min(curPage, totalPage));
		if (pageSize < 1) {
			pageSize = PageListVO.DEFAULT_PAGE_SIZE;
		}
		if (totalCount < 0) {
			totalCount = 0;
		}
	}

	/**
	 * 화면 목록에 표시되는 레코드번호 조회
	 *
	 * @param curRecordOffset 현재 페이지내에서의 레코드위치(offset)
	 * @param isZeroBase      0-base 인지 여부, true 이면 레코드표시번호가 0 부터 시작하는 것으로 간주한다.
	 * @return
	 */
	public int getDispRecordNo(int curRecordOffset, boolean isZeroBase) {
		int realCurRecordOffset = curRecordOffset < 0 ? 0 : curRecordOffset;
		return this.totalCount - ((this.curPage - 1) * this.pageSize) - (realCurRecordOffset - (isZeroBase ? 0 : 1));
	}

	/**
	 * 총 페이지 수
	 *
	 * @return
	 */
	public int getTotalPage() {
		return (totalCount - 1) / pageSize + 1;
	}

	/**
	 * 현재 page navi 에서의 첫 페이지 번호
	 *
	 * @return
	 */
	public int getStartPage() {
		return ((curPage - 1) / pageNaviSize) * pageNaviSize + 1;
	}

	/**
	 * 현재 page navi 에서의 마지막 페이지 번호
	 *
	 * @return
	 */
	public int getEndPage() {
		return Math.min((((curPage - 1) / pageNaviSize) + 1) * pageNaviSize, getTotalPage());
	}

	/**
	 * 이전 page navi 의 마지막 페이지 번호
	 *
	 * @return
	 */
	public int getPrevNaviLastPage() {
		int startPage = getStartPage();
		return (startPage == 1) ? startPage : startPage - 1;
	}

	/**
	 * 다음 page navi 의 처음 페이지 번호
	 *
	 * @return
	 */
	public int getNextNaviFirstPage() {
		int endPage = getEndPage();
		int totalPage = getTotalPage();
		int startPage = getStartPage();
		return (endPage == totalPage) ? startPage + 1 : endPage + 1;
	}

	/**
	 * 페이징용 파라미터 생성. ex 페이지번호 제거
	 *
	 * @param queryString
	 * @return
	 */
	public String makeSearchCondParam(Map<String, String> paramMap) {
		String retStr = "";

		if (paramMap != null && !paramMap.isEmpty()) {
			for (Entry<String, String> entry : paramMap.entrySet()) {
				if (!"page".equals(entry.getKey())) {
					retStr += (retStr.length() > 0 ? "&" : "") + entry.getKey() + "=" + entry.getValue();
				}
			}
		}

		return retStr;
	}

}
