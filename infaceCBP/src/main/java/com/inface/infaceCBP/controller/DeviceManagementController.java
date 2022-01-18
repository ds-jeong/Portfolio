package com.inface.infaceCBP.controller;

import com.inface.infaceCBP.common.CommonService;
import com.inface.infaceCBP.exception.AlertPageException;
import com.inface.infaceCBP.service.DeviceManagementService;
import com.inface.infaceCBP.vo.CompanyManagementVO;
import com.inface.infaceCBP.vo.DeviceManagementVO;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
public class DeviceManagementController {

    public final String URL_PRIFIX = "deviceManagement";

    @Autowired
    CommonService commonService;
    @Autowired
    DeviceManagementService deviceManagementService;

    //무선장비 수정
    @RequestMapping("/wirelessEquipmentUpdate")
    @ResponseBody
    public void wirelessEquipmentUpdate(HttpServletRequest httpServletRequest,
                             DeviceManagementVO deviceManagementVO) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("deviceManagementVO : {}" + deviceManagementVO);
            deviceManagementService.wirelessEquipmentUpdate(deviceManagementVO);
        }

    }

    //무선장비 상세 정보
    @RequestMapping("/wirelessEquipmentDetail")
    public String wirelessEquipmentDetail(HttpServletRequest httpServletRequest,
                               DeviceManagementVO deviceManagementVO,
                               Model model) throws Exception {

        try {
            List<DeviceManagementVO> wirelessEquipmentKindlist = deviceManagementService.getWirelessEquipmentKindList(deviceManagementVO);
            model.addAttribute("wirelessEquipmentKindlist", wirelessEquipmentKindlist);

            List<DeviceManagementVO> list = deviceManagementService.getWirelessEquipmentDetail(deviceManagementVO);
            model.addAttribute("list", list);
            model.addAttribute("searchParam", deviceManagementVO);
            model.addAttribute("detailNo", Integer.parseInt(httpServletRequest.getParameter("detailNo")));
            model.addAttribute("wirelessEquipmentDtNo", httpServletRequest.getParameter("wirelessEquipmentDtNo"));

        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/popup/wirelessEquipmentDetail";
    }

    //무선장비 등록
    @RequestMapping("/wirelessEquipmentRegist")
    public String wirelessEquipmentRegist(HttpServletRequest httpServletRequest,
                               DeviceManagementVO deviceManagementVO,
                               Model model) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("deviceManagementVO : {}" + deviceManagementVO);
            deviceManagementService.wirelessEquipmentRegist(deviceManagementVO);
        }

        List<DeviceManagementVO> wirelessEquipmentKindlist = deviceManagementService.getWirelessEquipmentKindList(deviceManagementVO);
        model.addAttribute("wirelessEquipmentKindlist", wirelessEquipmentKindlist);

        return URL_PRIFIX + "/popup/wirelessEquipmentRegist";

    }

    //무선장비 리스트
    @RequestMapping("/wirelessEquipmentManagement")
    public String wirelessEquipmentManagement(DeviceManagementVO deviceManagementVO,
                                   Model model) throws Exception {
        try {
            List<DeviceManagementVO> wirelessEquipmentKindlist = deviceManagementService.getWirelessEquipmentKindList(deviceManagementVO);
            model.addAttribute("wirelessEquipmentKindlist", wirelessEquipmentKindlist);

            PageListVO<DeviceManagementVO> pageList = deviceManagementService.getWirelessEquipmentList(deviceManagementVO);
            model.addAttribute("pageList",pageList);
            model.addAttribute("searchParam", deviceManagementVO);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/wirelessEquipmentManagement";

    }

    //단말기 수정
    @RequestMapping("/deviceUpdate")
    @ResponseBody
    public void deviceUpdate(HttpServletRequest httpServletRequest,
                             DeviceManagementVO deviceManagementVO) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("deviceManagementVO : {}" + deviceManagementVO);
            deviceManagementService.deviceUpdate(deviceManagementVO);
        }

    }

    //단말기 상세 정보
    @RequestMapping("/deviceDetail")
    public String deviceDetail(HttpServletRequest httpServletRequest,
                               DeviceManagementVO deviceManagementVO,
                               Model model) throws Exception {

        try {
            List<DeviceManagementVO> deviceKindlist = deviceManagementService.getDeviceKindList(deviceManagementVO);
            model.addAttribute("deviceKindlist", deviceKindlist);

            List<CompanyManagementVO> list = deviceManagementService.getDeviceDetail(deviceManagementVO);
            model.addAttribute("list", list);
            model.addAttribute("searchParam", deviceManagementVO);
            model.addAttribute("detailNo", Integer.parseInt(httpServletRequest.getParameter("detailNo")));
            model.addAttribute("deviceDtNo", httpServletRequest.getParameter("deviceDtNo"));
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/popup/deviceDetail";
    }

    //단말기 등록
    @RequestMapping("/deviceRegist")
    public String deviceRegist(HttpServletRequest httpServletRequest,
                               DeviceManagementVO deviceManagementVO,
                               Model model) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("deviceManagementVO : {}" + deviceManagementVO);
            deviceManagementService.deviceRegist(deviceManagementVO);
        }

        List<DeviceManagementVO> deviceKindlist = deviceManagementService.getDeviceKindList(deviceManagementVO);
        model.addAttribute("deviceKindlist", deviceKindlist);

        return URL_PRIFIX + "/popup/deviceRegist";

    }

    //단말기 리스트
    @RequestMapping("/deviceManagement")
    public String deviceManagement(DeviceManagementVO deviceManagementVO,
                                   Model model) throws Exception {

        try {
            List<DeviceManagementVO> deviceKindlist = deviceManagementService.getDeviceKindList(deviceManagementVO);
            model.addAttribute("deviceKindlist", deviceKindlist);

            PageListVO<DeviceManagementVO> pageList = deviceManagementService.getDeviceList(deviceManagementVO);
            model.addAttribute("pageList", pageList);
            model.addAttribute("searchParam", deviceManagementVO);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/deviceManagement";

    }

}