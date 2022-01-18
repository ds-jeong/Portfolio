package com.inface.infaceCBP.mapper;

import com.inface.infaceCBP.vo.DeviceManagementVO;
import com.inface.infaceCBP.vo.ServiceUsageStatusVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceUsageStatusMapper {
    //현장의 월사용료정보 수정
    void siteMonthAccountModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 월사용료정보 조회
    List<ServiceUsageStatusVO> getMonthAccountList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 월사용료정보 수정
    void siteMonthAccountRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 무선단말기정보 수정
    void siteWirelessEquipmentModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 무선단말기정보 등록
    void siteWirelessEquipmentRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //무선단말기테이블에 데이터의 현장번호를 업데이트
    void wirelessEquipmentInfoUpdate(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //무선단말기테이블에 수정 전 데이터의 현장번호를 다시 null로 만듬
    void beforeWirelessEquipmentInfoUpdate(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 무선단말기정보 조회
    List<ServiceUsageStatusVO> getWirelessEquipmentHistoryList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 단말기정보 수정
    void siteDeviceModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 단말기정보 등록
    void siteDeviceRegist(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //단말기테이블에 데이터의 현장번호를 업데이트
    void deviceInfoUpdate(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //단말기테이블에 수정 전 데이터의 현장번호를 다시 null로 만듬
    void beforeDeviceInfoUpdate(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장에 등록되지 않은 무선단말기리스트
    List<DeviceManagementVO> getWirelessEquipmentList(DeviceManagementVO deviceManagementVO) throws Exception;
    //현장에 등록되지 않은 단말기리스트
    List<DeviceManagementVO> getDeviceList(DeviceManagementVO deviceManagementVO) throws Exception;
    //현장의 단말기정보 조회
    List<ServiceUsageStatusVO> getDeviceHistoryList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 담당자정보 수정
    void siteManagerModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현자의 담당자정보 조회
    List<ServiceUsageStatusVO> getSiteManagerList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장의 담당자정보 등록
    void siteManagerRegist(ServiceUsageStatusVO serviceUsageStatusVO);
    //운영현장 상세리스트
    List<ServiceUsageStatusVO> getOperationSiteListDetail(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장정보 수정
    void siteInfoModify(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //현장등록
    void siteRegist(ServiceUsageStatusVO serviceUsageStatusVO)throws Exception;
    //운영현장리스트
    List<ServiceUsageStatusVO> getOperationSiteList(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //전체이용내역현황 상단 단말기조회
    List<ServiceUsageStatusVO> getDeviceTotalCountTop(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //전체이용내역현황 상단 무선단말기조회
    List<ServiceUsageStatusVO> getWirelessEquipmentTotalCountTop(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;
    //전체이용내역현황
    List<ServiceUsageStatusVO> getAllUseInfo(ServiceUsageStatusVO serviceUsageStatusVO) throws Exception;

}
