package com.inface.infaceCBP.service;

import com.inface.infaceCBP.mapper.DeviceManagementMapper;
import com.inface.infaceCBP.vo.CompanyManagementVO;
import com.inface.infaceCBP.vo.DeviceManagementVO;
import com.inface.infaceCBP.web.BaseService;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class DeviceManagementService extends BaseService {

    @Autowired
    DeviceManagementMapper deviceManagementMapper;

    //무선장비 수정
    public void wirelessEquipmentUpdate(DeviceManagementVO deviceManagementVO) throws Exception{
        deviceManagementMapper.wirelessEquipmentUpdate(deviceManagementVO);
    };
    //무선장비 상세 정보
    @Transactional
    public List<DeviceManagementVO> getWirelessEquipmentDetail(DeviceManagementVO deviceManagementVO) throws Exception{
        return deviceManagementMapper.getWirelessEquipmentDetail(deviceManagementVO);
    };
    //무선장비 등록
    @Transactional
    public void wirelessEquipmentRegist(DeviceManagementVO deviceManagementVO) throws Exception{
        deviceManagementMapper.wirelessEquipmentRegist(deviceManagementVO);
    };
    //무선장비 통신사 리스트
    @Transactional
    public List<DeviceManagementVO> getWirelessEquipmentKindList(DeviceManagementVO deviceManagementVO) throws Exception{
        return deviceManagementMapper.getWirelessEquipmentKindList(deviceManagementVO);
    };
    //무선장비 리스트
    @Transactional
    public PageListVO<DeviceManagementVO> getWirelessEquipmentList(DeviceManagementVO deviceManagementVO) throws Exception{

        List<DeviceManagementVO> list = deviceManagementMapper.getWirelessEquipmentList(deviceManagementVO);
        PageListVO<DeviceManagementVO> pageList = makeMapperPageListVO(deviceManagementVO, list);

        return pageList;
    };
    //단말기 수정
    @Transactional
    public void deviceUpdate(DeviceManagementVO deviceManagementVO) throws Exception{
        deviceManagementMapper.deviceUpdate(deviceManagementVO);
    };
    //단말기 상세
    @Transactional
    public List<CompanyManagementVO> getDeviceDetail(DeviceManagementVO deviceManagementVO) throws Exception{
        return deviceManagementMapper.getDeviceDetail(deviceManagementVO);
    };
    //단말기 등록
    @Transactional
    public void deviceRegist(DeviceManagementVO deviceManagementVO) throws Exception{
        deviceManagementMapper.deviceRegist(deviceManagementVO);
    };
    //단말기 종류 리스트
    @Transactional
    public List<DeviceManagementVO> getDeviceKindList(DeviceManagementVO deviceManagementVO) throws Exception{
        return deviceManagementMapper.getDeviceKindList(deviceManagementVO);
    };
    //단말기 리스트
    @Transactional
    public PageListVO<DeviceManagementVO> getDeviceList(DeviceManagementVO deviceManagementVO) throws Exception{

        List<DeviceManagementVO> list = deviceManagementMapper.getDeviceList(deviceManagementVO);
        PageListVO<DeviceManagementVO> pageList = makeMapperPageListVO(deviceManagementVO, list);

        return pageList;
    };
}
