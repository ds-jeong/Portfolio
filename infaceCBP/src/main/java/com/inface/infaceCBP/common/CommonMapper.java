package com.inface.infaceCBP.common;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonMapper {
   //협력업체조회
   List<CommonVO> getCommonSubCompanyList(CommonVO commonVO) throws Exception;
   //현장조회
   List<CommonVO> getCommonSiteList(CommonVO commonVO) throws Exception;
   //업체조회
   List<CommonVO> getCommonCompanyList(CommonVO commonVO) throws Exception;
   //그룹조회
   List<CommonVO> getCommonGroupList(CommonVO commonVO) throws Exception;
}
