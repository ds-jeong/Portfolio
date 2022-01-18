package com.inface.infaceCBP.web;

public class BaseMapper {

	/**
	 *
	 * sqlSession 을 getSqlSession() 으로 가져올 수 있음. 페이징 메소드 포함
	 *
	 */

//	@Autowired
//
//	@Qualifier("sqlSessionTemplate")
//
//	private SqlSessionTemplate sqlSessionTemplate;
//
//	@Autowired
//
//	@Qualifier("sqlSessionFactory")
//
//	private SqlSessionFactory sqlSessionFactory;
//
//	public SqlSession getSqlSession() {
//
//		return sqlSessionTemplate;
//
//	}
//
//	protected SqlSessionFactory getSqlSessionFactory() {
//
//		return sqlSessionFactory;
//
//	}
//
//	/**
//	 *
//	 * sql id 로부터 레코드수를 조회하는 sql id 를 가져온다.
//	 *
//	 *
//	 *
//	 * @param sqlId
//	 *
//	 * @return sqlId + "Count" 반환
//	 *
//	 */
//
//	public String getCountSqlId(String sqlId) {
//
//		return sqlId + "Count";
//
//	}
//
//	/**
//	 *
//	 * 페이징처리할 수 있는 메타정보를 담고 있는 PageVO 객체를 가져온다.
//	 *
//	 *
//	 *
//	 * @param sqlId      조회할 sql id
//	 *
//	 * @param countSqlId 전체 레코드수를 조회할 sql id, 없으면 sqlId 의 결과 중 처음 엘리먼트에서
//	 *
//	 *                   totalRecordCount 로 조회한다.
//	 *
//	 * @param requestDto 쿼리수행 parameter class
//	 *
//	 * @param curPage    조회할 페이지번호
//	 *
//	 * @param pageSize   조회할 페이지의 레코드 수
//	 *
//	 * @return
//	 *
//	 */
//
//	public <T> PageListVO<T> selectPageList(String sqlId, String countSqlId, Object requestDto, int curPage, int pageSize) {
//
//		return selectPageList(sqlId, countSqlId, requestDto, curPage, pageSize, true);
//
//	}
//
//	public <T> PageListVO<T> selectPageList(String sqlId, String countSqlId, Object requestDto, int curPage, int pageSize,
//			boolean totalProcess) {
//
//		// validate
//
//		int realPage = (curPage < 1) ? 1 : curPage;
//
//		int realPageSize = (pageSize < 1) ? PageListVO.DEFAULT_PAGE_SIZE : pageSize;
//
//		Object realRequestDto = (requestDto == null) ? new Object() : requestDto;
//
//		// calculate page data
//
//		realRequestDto.setStartRownum((realPage - 1) * realPageSize + 1);
//
////realRequestDto.setEndRownum(realPage * realPageSize);
//
//		int endRownum = realRequestDto.useMoreView() ? (realPage * realPageSize + 1) : (realPage * realPageSize);
//
//		realRequestDto.setEndRownum(endRownum);
//
//		//
//
//		List<T> resultList = getSqlSession().selectList(sqlId, realRequestDto);
//
//		// 총 레코드 수 totalRecordCount
//
//		int realTotalCount = 0;
//
//		if (countSqlId != null) {
//
//			// countSqlId 가 있으면 쿼리 결과값 사용
//
//			realTotalCount = (Integer) getSqlSession().selectOne(countSqlId, realRequestDto);
//
//		} else if (resultList != null && resultList.size() > 0) {
//
//			// countSqlId 가 없으면 resultList 에서 추출
//
//			realTotalCount = ((Object) resultList.get(0)).getTotalRecordCount();
//
//		}
//
//		boolean hasNext = false;
//
//		if (resultList != null && resultList.size() > 0) {
//
//			hasNext = resultList.size() > realPageSize ? true : false;
//
//		}
//
//		if (realRequestDto.useMoreView() && hasNext) {
//
//			resultList = resultList.subList(0, realPageSize);
//
//		}
//
//		PageListVO<T> pageDto = new PageListVO<T>(resultList, realPage, realPageSize, realTotalCount, hasNext);
//
//		if (totalProcess) {
//
//			pageDto.validatePagedInfo();
//
//		}
//
//		return pageDto;
//
//	}
//
//	/**
//	 *
//	 * 페이징처리할 수 있는 메타정보를 담고 있는 PageVO 객체를 가져온다.
//	 *
//	 *
//	 *
//	 * @param sqlId
//	 *
//	 * @param countSqlId
//	 *
//	 * @param curPage
//	 *
//	 * @param pageSize
//	 *
//	 * @return
//	 *
//	 * @see BaseDao#selectPageList(String, String, Object, int, int)
//	 *
//	 */
//
//	public <T> PageListVO<T> selectPageList(String sqlId, String countSqlId, int curPage, int pageSize) {
//
//		return selectPageList(sqlId, countSqlId, (Object) null, curPage, pageSize);
//
//	}
//
//	/**
//	 *
//	 * 페이징처리할 수 있는 메타정보를 담고 있는 PageVO 객체를 가져온다.
//	 *
//	 *
//	 *
//	 * @param sqlId
//	 *
//	 * @param requestDto
//	 *
//	 * @param curPage
//	 *
//	 * @param pageSize
//	 *
//	 * @return
//	 *
//	 * @see BaseDao#selectPageList(String, String, Object, int, int)
//	 *
//	 */
//
//	public <T> PageListVO<T> selectPageList(String sqlId, Object requestDto, int curPage, int pageSize) {
//
//		return selectPageList(sqlId, (String) null, requestDto, curPage, pageSize);
//
//	}
//
//	public <T> PageListVO<T> selectPageListNoneTotalCount(String sqlId, Object requestDto, int curPage, int pageSize) {
//
//		return selectPageList(sqlId, (String) null, requestDto, curPage, pageSize, false);
//
//	}
//
//	/**
//	 *
//	 * 페이징처리할 수 있는 메타정보를 담고 있는 PageVO 객체를 가져온다.
//	 *
//	 *
//	 *
//	 * @param sqlId
//	 *
//	 * @param curPage
//	 *
//	 * @param pageSize
//	 *
//	 * @return
//	 *
//	 * @see BaseDao#selectPageList(String, String, Object, int, int)
//	 *
//	 */
//
//	public <T> PageListVO<T> selectPageList(String sqlId, int curPage, int pageSize) {
//
//		return selectPageList(sqlId, (String) null, (Object) null, curPage, pageSize);
//
//	}

}
