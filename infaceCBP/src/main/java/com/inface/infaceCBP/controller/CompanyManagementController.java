package com.inface.infaceCBP.controller;

import com.inface.infaceCBP.common.CommonService;
import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.exception.AlertPageException;
import com.inface.infaceCBP.service.CompanyManagementService;
import com.inface.infaceCBP.vo.CompanyManagementVO;
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
public class CompanyManagementController {

    public final String URL_PRIFIX = "companyManagement";

    @Autowired
    CommonService commonService;
    @Autowired
    CompanyManagementService companyManagementService;

    //협력업체 정보 수정
    @RequestMapping("/subCompanyUpdate")
    @ResponseBody
    public void subCompanyUpdate(HttpServletRequest httpServletRequest,
                                    CompanyManagementVO companyManagementVO) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("companyManagementVO : {}" + companyManagementVO);
            companyManagementService.subCompanyUpdate(companyManagementVO);
        }
    }

    //협력업체 상세 정보
    @RequestMapping("/subCompanyDetail")
    public String subCompanyDetail(HttpServletRequest httpServletRequest,
                                   CompanyManagementVO companyManagementVO,
                                   Model model) throws Exception {

        try {
            List<CompanyManagementVO> list = companyManagementService.getSubCompanyDetail(companyManagementVO);
            model.addAttribute("list", list);
            model.addAttribute("searchParam", companyManagementVO);
            model.addAttribute("detailNo", Integer.parseInt(httpServletRequest.getParameter("detailNo")));
            model.addAttribute("subcontractorCmNo", Integer.parseInt(httpServletRequest.getParameter("subcontractorCmNo")));
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/popup/subCompanyDetail";
    }

    //협력업체 등록
    @RequestMapping("/subCompanyRegist")
    public String subCompanyRegist(HttpServletRequest httpServletRequest,
                                   CompanyManagementVO companyManagementVO) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("companyManagementVO" + companyManagementVO);
            companyManagementService.subCompanyRegist(companyManagementVO);
        }

        return URL_PRIFIX + "/popup/subCompanyRegist";
    }

    //협력업체 리스트
    @RequestMapping("/subCompanyManagerment")
    public String subCompanyManagerment(CommonVO commonVO,
                                        HttpServletRequest httpServletRequest,
                                        CompanyManagementVO companyManagementVO,
                                        Model model) throws Exception {

        if (httpServletRequest.getParameter("searchBusinessNo") != null) {
            companyManagementVO.setSearchBusinessNo(httpServletRequest.getParameter("searchBusinessNo"));
        }
        if (httpServletRequest.getParameter("searchCompanyNo") != null) {
            companyManagementVO.setSearchCompanyNo(Integer.parseInt(httpServletRequest.getParameter("searchCompanyNo")));
        }

        List<CommonVO> subCompanyList = commonService.getCommonSubCompanyList(commonVO);
        model.addAttribute("subCompanyList", subCompanyList);
        model.addAttribute("searchParam", companyManagementVO);

        try {
            PageListVO<CompanyManagementVO> pageList = companyManagementService.getSubCompanyList(companyManagementVO);
            model.addAttribute("pageList", pageList);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIFIX + "/subCompanyManagerment";
    }

    //거래처 정보 수정
    @RequestMapping("/clientCompanyUpdate")
    @ResponseBody
    public void clientCompanyUpdate(HttpServletRequest httpServletRequest,
                                    CompanyManagementVO companyManagementVO) throws Exception {

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("companyManagementVO : {}" + companyManagementVO);
            companyManagementService.clientCompanyUpdate(companyManagementVO);
        }
    }

    //거래처 상세 정보
    @RequestMapping("/clientCompanyDetail")
    public String clientCompanyDetail(HttpServletRequest httpServletRequest,
                                      CommonVO commonVO,
                                      CompanyManagementVO companyManagementVO,
                                      Model model) throws Exception {

        try {
            List<CompanyManagementVO> list = companyManagementService.getClientCompanyDetail(companyManagementVO);
            model.addAttribute("list", list);
            model.addAttribute("searchParam", companyManagementVO);
            model.addAttribute("detailNo", Integer.parseInt(httpServletRequest.getParameter("detailNo")));
            model.addAttribute("companyNo", Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }

        return URL_PRIFIX + "/popup/clientCompanyDetail";
    }

    //거래처 업체등록
    @RequestMapping("/clientCompanyRegist")
    public String clientCompanyRegist(CommonVO commonVO,
                                      HttpServletRequest httpServletRequest,
                                      CompanyManagementVO companyManagementVO,
                                      Model model) throws Exception {

        List<CommonVO> groupList = commonService.getCommonGroupList(commonVO);
        model.addAttribute("groupList", groupList);

        if (httpServletRequest.getParameter("nullChkValue") != null && !httpServletRequest.getParameter("nullChkValue").equals("")) {
            //log.debug("companyManagementVO : {}" + companyManagementVO);
            companyManagementService.clientCompanyRegist(companyManagementVO);
        }

        return URL_PRIFIX + "/popup/clientCompanyRegist";
    }

    //거래처리스트
    @RequestMapping("/clientCompanyManagement")
    public String clientManagement(HttpServletRequest httpServletRequest,
                                   CommonVO commonVO,
                                   CompanyManagementVO companyManagementVO,
                                   Model model) throws Exception {

        if (httpServletRequest.getParameter("searchBusinessNo") != null) {
            companyManagementVO.setSearchBusinessNo(httpServletRequest.getParameter("searchBusinessNo"));
        }
        if (httpServletRequest.getParameter("searchCompanyNo") != null) {
            companyManagementVO.setSearchCompanyNo(Integer.parseInt(httpServletRequest.getParameter("searchCompanyNo")));
        }

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);
        model.addAttribute("searchParam", companyManagementVO);

        try {
            PageListVO<CompanyManagementVO> pageList = companyManagementService.getClientCompanyList(companyManagementVO);
            model.addAttribute("pageList", pageList);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIFIX + "/clientCompanyManagement";
    }
}