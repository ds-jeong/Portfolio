package com.inface.infaceCBP.mapper;

import com.inface.infaceCBP.vo.FacilityOperationManagementVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FacilityOperationManagementMapper {
    //시설내역정보를 수정
    void siteFacilityUpdate(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception;
    //시설내역의 상세 정보
    List<FacilityOperationManagementVO> getFacilityInfoDetail(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception;
    //현장의시설등록
    void siteFacilityRegist(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception;
    //시설정보 리스트
    List<FacilityOperationManagementVO> getFacilityInfoList(FacilityOperationManagementVO facilityOperationManagementVO) throws Exception;
}
