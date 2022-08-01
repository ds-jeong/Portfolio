package common;

public class PageVO {
	private int pageList = 10, blockPage = 10,
			totalList, totalPage, totalBlock,
			curPage, beginList, endList,
			curBlock, beginPage, endPage ;
	private String search, keyword;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getTotalList() {
		return totalList;
	}

	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총페이지수 = 총 목록수 / 페이지당보여질목록수
		totalPage = totalList / pageList;
		if( totalList % pageList > 0 ) ++totalPage;
		
		//총블럭수 = 총 페이지수 / 블럭당보여질페이지수
		totalBlock = totalPage / blockPage;
		if( totalPage % blockPage > 0 ) ++totalBlock;
		
		//각 페이지에서의 끝 목록번호 
		//= 총 목록수 - (현재페이지번호-1)*페이지당보여질목록수
		endList = totalList - (curPage-1)*pageList;
		//시작 목록번호 = 끝 목록번호 - (페이지당보여질목록수-1)
		beginList = endList - (pageList-1);
		
		//현재블럭번호 = 현재페이지번호 / 블럭당보여질페이지수
		curBlock = curPage / blockPage;
		if( curPage % blockPage >0 ) ++curBlock;
		
		//각 블럭에서의 끝 페이지번호
		//= 현재블럭번호 * 블럭당보여질페이지수
		endPage = curBlock * blockPage;
		//시작 페이지번호 = 끝 페이지번호-(블럭당페이지수-1)
		beginPage = endPage - (blockPage-1);
		if( endPage > totalPage ) endPage = totalPage;		
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getBeginList() {
		return beginList;
	}

	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}

	public int getEndList() {
		return endList;
	}

	public void setEndList(int endList) {
		this.endList = endList;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
