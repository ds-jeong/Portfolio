package com.inface.infaceCBP.service;

import com.inface.infaceCBP.mapper.CompanyManagementMapper;
import com.inface.infaceCBP.vo.CompanyManagementVO;
import com.inface.infaceCBP.web.BaseService;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CompanyManagementService extends BaseService {

    @Autowired CompanyManagementMapper companyManagementMapper;
    //협력업체 정보 수정
    @Transactional
    public void subCompanyUpdate(CompanyManagementVO companyManagementVO) throws Exception{
        companyManagementMapper.subCompanyUpdate(companyManagementVO);
    }
    //협력업체 상세 정보
    @Transactional
    public List<CompanyManagementVO> getSubCompanyDetail(CompanyManagementVO companyManagementVO) throws Exception{
        return companyManagementMapper.getSubCompanyDetail(companyManagementVO);
    }
    //협력업체등록
    @Transactional
    public void subCompanyRegist(CompanyManagementVO companyManagementVO) throws Exception{
        companyManagementMapper.subCompanyRegist(companyManagementVO);
    };
    //협력업체 리스트
    @Transactional
    public PageListVO<CompanyManagementVO> getSubCompanyList(CompanyManagementVO companyManagementVO) throws Exception{
        List<CompanyManagementVO> list =  companyManagementMapper.getSubCompanyList(companyManagementVO);
        PageListVO<CompanyManagementVO> pageList = makeMapperPageListVO(companyManagementVO, list);
        return pageList;
    };
    //거래처 정보 수정
    @Transactional
    public void clientCompanyUpdate(CompanyManagementVO companyManagementVO) throws Exception{
        companyManagementMapper.clientCompanyUpdate(companyManagementVO);
    };
    //거래처 상세 정보
    @Transactional
    public List<CompanyManagementVO> getClientCompanyDetail(CompanyManagementVO companyManagementVO) throws Exception{
        return companyManagementMapper.getClientCompanyDetail(companyManagementVO);
    };
    //거래처업체등록
    @Transactional
    public void clientCompanyRegist(CompanyManagementVO companyManagementVO) throws Exception{
        companyManagementMapper.clientCompanyRegist(companyManagementVO);
    };
    //거래처 리스트
    @Transactional
    public PageListVO<CompanyManagementVO> getClientCompanyList(CompanyManagementVO companyManagementVO) throws Exception{
        List<CompanyManagementVO> resultList =companyManagementMapper.getClientCompanyList(companyManagementVO);
        PageListVO<CompanyManagementVO> pageList = makeMapperPageListVO(companyManagementVO, resultList);
        return pageList;
    };
}
