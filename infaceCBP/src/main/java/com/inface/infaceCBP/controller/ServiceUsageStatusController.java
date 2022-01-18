package com.inface.infaceCBP.controller;

import com.inface.infaceCBP.common.CommonService;
import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.service.DeviceManagementService;
import com.inface.infaceCBP.service.ServiceUsageStatusService;
import com.inface.infaceCBP.vo.DeviceManagementVO;
import com.inface.infaceCBP.vo.ServiceUsageStatusVO;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class ServiceUsageStatusController {

    public final String URL_PREFIX = "serviceUsageStatus";

    @Autowired
    CommonService commonService;
    @Autowired
    ServiceUsageStatusService serviceUsageStatusService;
    @Autowired
    DeviceManagementService deviceManagementService;

    //현장의 월사용료정보 수정
    @RequestMapping("/siteMonthAccountModify")
    @ResponseBody
    public void siteMonthAccountModify(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        serviceUsageStatusService.siteMonthAccountModify(serviceUsageStatusVO);
    }

    //현장의 월사용료정보 등록
    @RequestMapping("/siteMonthAccountRegist")
    @ResponseBody
    public void siteMonthAccountRegist(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        serviceUsageStatusService.siteMonthAccountRegist(serviceUsageStatusVO);
    }

    //현장의 무선단말기 수정
    @RequestMapping("/siteWirelessEquipmentModify")
    @ResponseBody
    public void siteWirelessEquipmentModify(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        //log.debug("serviceUsageStatusVO" + serviceUsageStatusVO);
        serviceUsageStatusService.siteWirelessEquipmentModify(serviceUsageStatusVO);
    }

    //현장의 무선단말기 추가
    @RequestMapping("/siteWirelessEquipmentRegist")
    @ResponseBody
    public void siteWirelessEquipmentRegist(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //log.debug("serviceUsageStatusVO"+serviceUsageStatusVO);
        //현장의 무선단말기를 추가
        serviceUsageStatusService.siteWirelessEquipmentRegist(serviceUsageStatusVO);
    }

    //현장의 단말기 수정
    @RequestMapping("/siteDeviceModify")
    @ResponseBody
    public void siteDeviceModify(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        //log.debug("serviceUsageStatusVO" + serviceUsageStatusVO);
        serviceUsageStatusService.siteDeviceModify(serviceUsageStatusVO);
    }

    //현장의 단말기 추가
    @RequestMapping("/siteDeviceRegist")
    @ResponseBody
    public void siteDeviceRegist(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception{
        //log.debug("serviceUsageStatusVO"+serviceUsageStatusVO);
        serviceUsageStatusService.siteDeviceRegist(serviceUsageStatusVO);
    }

    //현장의 담당자정보 수정
    @RequestMapping("/siteManagerModify")
    @ResponseBody
    public void siteManagerModify(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {

        if (httpServletRequest.getParameter("taxChk") == null && httpServletRequest.getParameter("taxChk") == "" && !httpServletRequest.getParameter("taxChk").equals("Y")) {
            serviceUsageStatusVO.setTaxChk("N");
        } else {
            serviceUsageStatusVO.setTaxChk(httpServletRequest.getParameter("taxChk"));
        };
        serviceUsageStatusService.siteManagerModify(serviceUsageStatusVO);
    }

    //현장의 담당자등록
    @RequestMapping("/siteManagerRegist")
    @ResponseBody
    public void siteManagerRegist(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {

        if (httpServletRequest.getParameter("taxChk") == null || httpServletRequest.getParameter("taxChk") == "" || !httpServletRequest.getParameter("taxChk").equals("Y")) {
            serviceUsageStatusVO.setTaxChk("N");
        } else {
            serviceUsageStatusVO.setTaxChk(httpServletRequest.getParameter("taxChk"));
        };
        serviceUsageStatusService.siteManagerRegist(serviceUsageStatusVO);
    }

    //현장에 등록되지않은 무선단말기리스트
    @RequestMapping("/wirelessEquipmentList")
    @ResponseBody
    public List<DeviceManagementVO> wirelessEquipmentList(HttpServletRequest httpServletRequest,
                                               DeviceManagementVO deviceManagementVO) throws Exception {
        return serviceUsageStatusService.getWirelessEquipmentList(deviceManagementVO);
    }

    //현장에 등록되지않은 단말기리스트
    @RequestMapping("/deviceList")
    @ResponseBody
    public List<DeviceManagementVO> deviceList(HttpServletRequest httpServletRequest,
                                               DeviceManagementVO deviceManagementVO) throws Exception {
        return serviceUsageStatusService.getDeviceList(deviceManagementVO);
    }

    //등록된 현장의 상세정보
    @RequestMapping("/operationSiteDetail")
    public String operationSiteDetail(HttpServletRequest httpServletRequest,
                                      ServiceUsageStatusVO serviceUsageStatusVO,
                                      DeviceManagementVO deviceManagementVO,
                                      Model model) throws Exception {

        serviceUsageStatusVO.setSiteNo(Integer.parseInt(httpServletRequest.getParameter("siteNo")));
        serviceUsageStatusVO.setDetailNo(Integer.parseInt(httpServletRequest.getParameter("detailNo")));

        List<ServiceUsageStatusVO> list = serviceUsageStatusService.getOperationSiteListDetail(serviceUsageStatusVO);
        model.addAttribute("list", list);
        model.addAttribute("siteNo", serviceUsageStatusVO.getSiteNo());

        List<ServiceUsageStatusVO> siteManagerList = serviceUsageStatusService.getSiteManagerList(serviceUsageStatusVO);
        model.addAttribute("siteManagerList", siteManagerList);

        List<ServiceUsageStatusVO> siteDeviceHistoryList = serviceUsageStatusService.getDeviceHistoryList(serviceUsageStatusVO);
        model.addAttribute("siteDeviceHistoryList", siteDeviceHistoryList);

        List<ServiceUsageStatusVO> siteWirelessEquipmentHistoryList = serviceUsageStatusService.getWirelessEquipmentHistoryList(serviceUsageStatusVO);
        model.addAttribute("siteWirelessEquipmentHistoryList", siteWirelessEquipmentHistoryList);

        List<ServiceUsageStatusVO> siteMonthAccount = serviceUsageStatusService.getMonthAccountList(serviceUsageStatusVO);
        model.addAttribute("siteMonthAccount", siteMonthAccount);

        List<DeviceManagementVO> deviceKindlist = deviceManagementService.getDeviceKindList(deviceManagementVO);
        model.addAttribute("deviceKindlist", deviceKindlist);

        List<DeviceManagementVO> devicelist = serviceUsageStatusService.getDeviceList(deviceManagementVO);
        model.addAttribute("devicelist", devicelist);

        List<DeviceManagementVO> wirelessEquipmentCarrierList = deviceManagementService.getWirelessEquipmentKindList(deviceManagementVO);
        model.addAttribute("wirelessEquipmentCarrierList", wirelessEquipmentCarrierList);

        List<DeviceManagementVO> wirelessEquipmentList = serviceUsageStatusService.getWirelessEquipmentList(deviceManagementVO);
        model.addAttribute("wirelessEquipmentList", wirelessEquipmentList);

        return URL_PREFIX + "/operationSiteDetail";
    }
    //현장정보 수정
    @RequestMapping("/siteInfoModify")
    @ResponseBody
    public void siteInfoModify(HttpServletRequest httpServletRequest, ServiceUsageStatusVO serviceUsageStatusVO) throws Exception {
        //log.debug("serviceUsageStatusVO" + serviceUsageStatusVO);
        serviceUsageStatusService.siteInfoModify(serviceUsageStatusVO);
    }
    //현장등록
    @RequestMapping("/siteRegist")
    public String siteRegist(HttpServletRequest httpServletRequest, CommonVO commonVO, ServiceUsageStatusVO serviceUsageStatusVO, Model model) throws Exception {

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        if (httpServletRequest.getParameter("siteName") != null && !httpServletRequest.getParameter("siteName").equals("")) {
            //log.debug("serviceUsageStatusVO" + serviceUsageStatusVO);
            serviceUsageStatusService.siteRegist(serviceUsageStatusVO);
        }

        return URL_PREFIX + "/popup/siteRegist";
    }

    @RequestMapping("/operationSiteManagement")
    public String operationSiteManagement(HttpServletRequest httpServletRequest, CommonVO commonVO, ServiceUsageStatusVO serviceUsageStatusVO, Model model) throws Exception {

        if (httpServletRequest.getParameter("searchSiteState") != null) {
            serviceUsageStatusVO.setSearchSiteState(httpServletRequest.getParameter("searchSiteState"));
        }
        if (httpServletRequest.getParameter("searchCompanyNo") != null) {
            serviceUsageStatusVO.setSearchCompanyNo(Integer.parseInt(httpServletRequest.getParameter("searchCompanyNo")));
        }

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        PageListVO<ServiceUsageStatusVO> pageList = serviceUsageStatusService.getOperationSiteList(serviceUsageStatusVO);
        model.addAttribute("pageList", pageList);
        model.addAttribute("searchParam", serviceUsageStatusVO);

        return URL_PREFIX + "/operationSiteManagement";
    }

    @RequestMapping("/overallUsageStatus")
    public String serviceUsageStatus(ServiceUsageStatusVO serviceUsageStatusVO, Model model) throws Exception{

        PageListVO<ServiceUsageStatusVO> pageList = serviceUsageStatusService.getAllUseInfo(serviceUsageStatusVO);
        model.addAttribute("pageList", pageList);
        //전체이용내역현황 상단 단말기조회
        List<ServiceUsageStatusVO> deviceTotalCountTop = serviceUsageStatusService.getDeviceTotalCountTop(serviceUsageStatusVO);
        model.addAttribute("deviceTotalCountTop",deviceTotalCountTop);
        //전체이용내역현황 상단 무선단말기조회
        List<ServiceUsageStatusVO> wirelessEquipmentTotalCountTop= serviceUsageStatusService.getWirelessEquipmentTotalCountTop(serviceUsageStatusVO);
        model.addAttribute("wirelessEquipmentTotalCountTop",wirelessEquipmentTotalCountTop);

        return URL_PREFIX + "/overallUsageStatus";
    }
}
