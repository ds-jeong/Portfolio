package com.inface.infaceCBP.mapper;

import com.inface.infaceCBP.vo.CompanyManagementVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyManagementMapper {
    //협력업체 정보 수정
    void subCompanyUpdate(CompanyManagementVO companyManagementVO) throws Exception;
    //협력업체 상세정보
    List<CompanyManagementVO> getSubCompanyDetail(CompanyManagementVO companyManagementVO) throws Exception;
    //협력업체등록
    void subCompanyRegist(CompanyManagementVO companyManagementVO) throws Exception;
    //협력업체 리스트
    List<CompanyManagementVO> getSubCompanyList(CompanyManagementVO companyManagementVO) throws Exception;
    //거래처 정보 수정
    void clientCompanyUpdate(CompanyManagementVO companyManagementVO) throws Exception;
    //거래처업체 상세정보
    List<CompanyManagementVO> getClientCompanyDetail(CompanyManagementVO companyManagementVO) throws Exception;
    //거래처업체 등록
    void clientCompanyRegist(CompanyManagementVO companyManagementVO) throws Exception;
    //거래처 리스트
    List<CompanyManagementVO> getClientCompanyList(CompanyManagementVO companyManagementVO) throws Exception;
}
