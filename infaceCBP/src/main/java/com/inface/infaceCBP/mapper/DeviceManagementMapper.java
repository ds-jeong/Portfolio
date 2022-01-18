package com.inface.infaceCBP.mapper;

import com.inface.infaceCBP.vo.CompanyManagementVO;
import com.inface.infaceCBP.vo.DeviceManagementVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceManagementMapper {
    //무선장비 수정
    void wirelessEquipmentUpdate(DeviceManagementVO deviceManagementVO) throws Exception;
    //무선장비 상세 정보
    List<DeviceManagementVO> getWirelessEquipmentDetail(DeviceManagementVO deviceManagementVO) throws Exception;
    //무선장비 등록
    void wirelessEquipmentRegist(DeviceManagementVO deviceManagementVO) throws Exception;
    //무선장비 통신사 리스트
    List<DeviceManagementVO> getWirelessEquipmentKindList(DeviceManagementVO deviceManagementVO) throws Exception;
    //무선장비 리스트
    List<DeviceManagementVO> getWirelessEquipmentList(DeviceManagementVO deviceManagementVO) throws Exception;
    //단말기 수정
    void deviceUpdate(DeviceManagementVO deviceManagementVO) throws Exception;
    //단말기 상세
    List<CompanyManagementVO> getDeviceDetail(DeviceManagementVO deviceManagementVO) throws Exception;
    //단말기 등록
    void deviceRegist(DeviceManagementVO deviceManagementVO) throws Exception;
    //단말기 종류 리스트
    List<DeviceManagementVO> getDeviceKindList(DeviceManagementVO deviceManagementVO) throws Exception;
    //단말기 리스트
    List<DeviceManagementVO> getDeviceList(DeviceManagementVO deviceManagementVO) throws Exception;
}
