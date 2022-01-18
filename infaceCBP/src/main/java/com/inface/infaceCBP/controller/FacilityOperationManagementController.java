package com.inface.infaceCBP.controller;

import com.inface.infaceCBP.common.CommonService;
import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.exception.AlertPageException;
import com.inface.infaceCBP.service.CompanyManagementService;
import com.inface.infaceCBP.service.FacilityOperationManagementService;
import com.inface.infaceCBP.vo.FacilityOperationManagementVO;
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
public class FacilityOperationManagementController {

    public final String URL_PRIFIX = "facilityOperationManagement";

    @Autowired
    CommonService commonService;
    @Autowired
    CompanyManagementService companyManagementService;
    @Autowired
    FacilityOperationManagementService facilityOperationManagementService;

    //시설등록화면에서 업체 별 현장리스트
    @RequestMapping("/siteFacilityRegistSiteList")
    @ResponseBody
    public List<CommonVO> siteFacilityRegistSiteList(
            HttpServletRequest httpServletRequest,
            CommonVO commonVO,
            Model model) throws Exception {

        if (httpServletRequest.getParameter("companyNo") != null && !httpServletRequest.getParameter("companyNo").equals("")) {
            commonVO.setCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
            List<CommonVO> siteList = commonService.getCommonSiteList(commonVO);
            model.addAttribute("siteList", siteList);
            return siteList;
        }

        return null;
    }

    //현장의 시설등록
    @RequestMapping("/siteFacilityRegist")
    public String siteFacilityRegist(
            HttpServletRequest httpServletRequest,
            CommonVO commonVO,
            FacilityOperationManagementVO facilityOperationManagementVO,
            Model model) throws Exception {

        if (httpServletRequest.getParameter("companyNo") != null && !httpServletRequest.getParameter("companyNo").equals("")) {
            //log.debug("facilityOperationManagementVO : " + facilityOperationManagementVO);
            facilityOperationManagementService.siteFacilityRegist(facilityOperationManagementVO);
        }

        //업체 select 리스트
        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);
        model.addAttribute("searchParam", facilityOperationManagementVO);

        //협력업체 select 리스트
        List<CommonVO> subCompanyList = commonService.getCommonSubCompanyList(commonVO);
        model.addAttribute("subCompanyList", subCompanyList);

        return URL_PRIFIX + "/popup/siteFacilityRegist";
    }

    //시설내역 상세
    @RequestMapping("/siteFacliltyDetail")
    public String siteFacliltyRegistDetail(HttpServletRequest httpServletRequest,
                                           CommonVO commonVO,
                                           FacilityOperationManagementVO facilityOperationManagementVO,
                                           Model model) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("facilityOperationManagementVO : " + facilityOperationManagementVO);
            facilityOperationManagementService.siteFacilityUpdate(facilityOperationManagementVO);
        }

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        List<CommonVO> siteList = commonService.getCommonSiteList(commonVO);
        model.addAttribute("siteList", siteList);

        List<CommonVO> subCompanyList = commonService.getCommonSubCompanyList(commonVO);
        model.addAttribute("subCompanyList", subCompanyList);

        try {
            List<FacilityOperationManagementVO> list = facilityOperationManagementService.getFacilityInfoDetail(facilityOperationManagementVO);
            model.addAttribute("list", list);
            model.addAttribute("searchParam", facilityOperationManagementVO);
            model.addAttribute("detailNo", Integer.parseInt(httpServletRequest.getParameter("detailNo")));
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIFIX + "/popup/siteFacliltyDetail";
    }

    //시설내역 리스트
    @RequestMapping("/siteFacility")
    public String siteFacility(CommonVO commonVO,
                               FacilityOperationManagementVO facilityOperationManagementVO,
                               Model model) throws Exception {

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        try {
            PageListVO<FacilityOperationManagementVO> pageList = facilityOperationManagementService.getFacilityInfoList(facilityOperationManagementVO);
            model.addAttribute("pageList", pageList);
            model.addAttribute("searchParam", facilityOperationManagementVO);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/siteFacility";
    }
}
