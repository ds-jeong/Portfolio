package com.inface.infaceCBP.web;

import java.util.List;

public class BaseService {

	/**
	 * @param <T>
	 * @param paramVO
	 * @param resultList
	 * @return
	 */
	public <T extends BaseVO> PageListVO<T> makeMapperPageListVO(BaseVO paramVO, List<T> resultList) {

		int totalRecordCount = resultList != null && resultList.size() > 0 ? resultList.get(0).getTotalRecordCount() : 0;

		PageListVO<T> pageListVo = new PageListVO<T>(resultList, paramVO.getPage(), paramVO.getPageSize(), totalRecordCount);
		return pageListVo;
	}

}
