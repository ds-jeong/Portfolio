package com.inface.infaceCBP.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired CommonMapper commonMapper;

    //협력업체조회
    public List<CommonVO> getCommonSubCompanyList(CommonVO commonVO) throws Exception{
        return commonMapper.getCommonSubCompanyList(commonVO);
    };
    //현장조회
     public List<CommonVO> getCommonSiteList(CommonVO commonVO) throws Exception{
        return commonMapper.getCommonSiteList(commonVO);
    };
    //업체조회
     public List<CommonVO> getCommonCompanyList(CommonVO commonVO) throws Exception{
         return commonMapper.getCommonCompanyList(commonVO);
    };
    //그룹조회
    public List<CommonVO> getCommonGroupList(CommonVO commonVO) throws Exception{
        return commonMapper.getCommonGroupList(commonVO);
    }
}
