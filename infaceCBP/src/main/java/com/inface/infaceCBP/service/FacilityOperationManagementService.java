package com.inface.infaceCBP.service;

import com.inface.infaceCBP.mapper.FacilityOperationManagementMapper;
import com.inface.infaceCBP.vo.FacilityOperationManagementVO;
import com.inface.infaceCBP.web.BaseService;
import com.inface.infaceCBP.web.PageListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacilityOperationManagementService extends BaseService {

    @Autowired FacilityOperationManagementMapper facilityOperationManagementMapper;

    //시설내역정보를 수정
    @Transactional
    public void siteFacilityUpdate(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception{

        List<FacilityOperationManagementVO> list = facilityOperationManagementMapper.getFacilityInfoList(facilityOperationManagementVO);
        PageListVO<FacilityOperationManagementVO> pageList = makeMapperPageListVO(facilityOperationManagementVO, list);

        facilityOperationManagementMapper.siteFacilityUpdate(facilityOperationManagementVO);

    };
    //시설내역 상세 정보
    @Transactional
    public List<FacilityOperationManagementVO> getFacilityInfoDetail(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception {
        return facilityOperationManagementMapper.getFacilityInfoDetail(facilityOperationManagementVO);
    };
    //현장의시설등록
    @Transactional
    public void siteFacilityRegist(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception{
        facilityOperationManagementMapper.siteFacilityRegist(facilityOperationManagementVO);
    };
    //시절정보 리스트
    @Transactional
    public PageListVO<FacilityOperationManagementVO> getFacilityInfoList(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception{

        List<FacilityOperationManagementVO> list = facilityOperationManagementMapper.getFacilityInfoList(facilityOperationManagementVO);
        PageListVO<FacilityOperationManagementVO> pageList = makeMapperPageListVO(facilityOperationManagementVO, list);

        return  pageList;
    };

}
