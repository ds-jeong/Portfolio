package com.inface.infaceCBP.service;

import com.inface.infaceCBP.mapper.ServiceUsageStatusMapper;
import com.inface.infaceCBP.vo.DeviceManagementVO;
import com.inface.infaceCBP.vo.ServiceUsageStatusVO;
import com.inface.infaceCBP.web.BaseService;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ServiceUsageStatusService extends BaseService {
    
    @Autowired ServiceUsageStatusMapper serviceUsageStatusMapper;

    //현장의 월사용료 수정
    @Transactional
    public void siteMonthAccountModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        serviceUsageStatusMapper.siteMonthAccountModify(serviceUsageStatusVO);
    };
    //현장의 월사용료 조회
    @Transactional
    public List<ServiceUsageStatusVO> getMonthAccountList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getMonthAccountList(serviceUsageStatusVO);
    };
    //현장의 월사용료정보 등록
    @Transactional
    public void siteMonthAccountRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        serviceUsageStatusMapper.siteMonthAccountRegist(serviceUsageStatusVO);
    };
    //현장의 무선단말기정보 수정
    @Transactional
    public void siteWirelessEquipmentModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //현장의 무선단말기정보 수정
        serviceUsageStatusMapper.siteWirelessEquipmentModify(serviceUsageStatusVO);
        //무선단말기테이블에 데이터의 현장번호를 업데이트
        serviceUsageStatusMapper.wirelessEquipmentInfoUpdate(serviceUsageStatusVO);
        if(serviceUsageStatusVO.getBeforeWirelessEquipmentDtNo() != serviceUsageStatusVO.getWirelessEquipmentDtNo()) {
            //무선단말기테이블에 수정 전 데이터의 현장번호를 다시 null로 만듬
            serviceUsageStatusMapper.beforeWirelessEquipmentInfoUpdate(serviceUsageStatusVO);
        }
    };
    //현장의 무선단말기정보 등록
    @Transactional
    public void siteWirelessEquipmentRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //현장의 무선단말기정보 등록
        serviceUsageStatusMapper.siteWirelessEquipmentRegist(serviceUsageStatusVO);
        //무선단말기테이블에 데이터의 현장번호를 업데이트
        serviceUsageStatusMapper.wirelessEquipmentInfoUpdate(serviceUsageStatusVO);
    };
    //현장의 무선단말기정보 조회
    @Transactional
    public List<ServiceUsageStatusVO> getWirelessEquipmentHistoryList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getWirelessEquipmentHistoryList(serviceUsageStatusVO);
    };
    //현장의 단말기정보 수정
    @Transactional
    public void siteDeviceModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //현장의 단말기정보 수정
        serviceUsageStatusMapper.siteDeviceModify(serviceUsageStatusVO);
        //단말기테이블에 데이터의 현장번호를 업데이트
        serviceUsageStatusMapper.deviceInfoUpdate(serviceUsageStatusVO);
        if(serviceUsageStatusVO.getBeforeDeviceDtNo() != serviceUsageStatusVO.getDeviceDtNo()) {
            //단말기테이블에 수정 전 데이터의 현장번호를 다시 null로 만듬
            serviceUsageStatusMapper.beforeDeviceInfoUpdate(serviceUsageStatusVO);
        }
    };
    //현장의 단말기정보 등록
    @Transactional
    public void siteDeviceRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //현장의 단말기를 추가
        serviceUsageStatusMapper.siteDeviceRegist(serviceUsageStatusVO);
        //단말기테이블에 데이터의 현장번호를 업데이트
        serviceUsageStatusMapper.deviceInfoUpdate(serviceUsageStatusVO);
    };
    //현장에 등록되지 않은 무선단말기리스트
    @Transactional
    public List<DeviceManagementVO> getWirelessEquipmentList(DeviceManagementVO deviceManagementVO) throws Exception{
        return  serviceUsageStatusMapper.getWirelessEquipmentList(deviceManagementVO);
    };
    //현장에 등록되지 않은 단말기리스트
    @Transactional
    public List<DeviceManagementVO> getDeviceList(DeviceManagementVO deviceManagementVO) throws Exception{
        return serviceUsageStatusMapper.getDeviceList(deviceManagementVO);
    };
    //현장의 단말기정보 조회
    @Transactional
    public List<ServiceUsageStatusVO> getDeviceHistoryList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getDeviceHistoryList(serviceUsageStatusVO);
    };
    //현장의 담당자정보 수정
    @Transactional
    public void siteManagerModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        serviceUsageStatusMapper.siteManagerModify(serviceUsageStatusVO);
    };
    //현장의 담당자정보 조회
    @Transactional
    public List<ServiceUsageStatusVO> getSiteManagerList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getSiteManagerList(serviceUsageStatusVO);
    };
    //현장의 담당자정보 등록
    @Transactional
    public void siteManagerRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        serviceUsageStatusMapper.siteManagerRegist(serviceUsageStatusVO);
    };
    //운영현장상세리스트
    @Transactional
    public List<ServiceUsageStatusVO> getOperationSiteListDetail(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getOperationSiteListDetail(serviceUsageStatusVO);
    };
    //현장정보 수정
    @Transactional
    public void siteInfoModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        serviceUsageStatusMapper.siteInfoModify(serviceUsageStatusVO);
    };
    //현장등록
    @Transactional
    public void siteRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        serviceUsageStatusMapper.siteRegist(serviceUsageStatusVO);
    };
    //업체검색리스트
    @Transactional
    public List<ServiceUsageStatusVO> getSearchList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getOperationSiteList(serviceUsageStatusVO);
    };
    //운영현장리스트
    @Transactional
    public PageListVO<ServiceUsageStatusVO> getOperationSiteList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        List<ServiceUsageStatusVO> list = serviceUsageStatusMapper.getOperationSiteList(serviceUsageStatusVO);
        PageListVO<ServiceUsageStatusVO> pageList = makeMapperPageListVO(serviceUsageStatusVO, list);
        return pageList;
    };
    //전체이용내역현황 상단 단말기조회
    @Transactional
    public List<ServiceUsageStatusVO> getDeviceTotalCountTop(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getDeviceTotalCountTop(serviceUsageStatusVO);
    };
    //전체이용내역현황 상단 무선단말기조회
    @Transactional
    public List<ServiceUsageStatusVO> getWirelessEquipmentTotalCountTop(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        return serviceUsageStatusMapper.getWirelessEquipmentTotalCountTop(serviceUsageStatusVO);
    };
    //전체이용내역현황
    public PageListVO<ServiceUsageStatusVO> getAllUseInfo(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        List<ServiceUsageStatusVO> list = serviceUsageStatusMapper.getAllUseInfo(serviceUsageStatusVO);
        PageListVO<ServiceUsageStatusVO> pageList = makeMapperPageListVO(serviceUsageStatusVO, list);
        return pageList;
    };
}
