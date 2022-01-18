package com.inface.infaceCBP.controller;

import com.inface.infaceCBP.common.CommonService;
import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.exception.AlertPageException;
import com.inface.infaceCBP.service.SalesDetailsManagementService;
import com.inface.infaceCBP.vo.SalesDetailsManagementVO;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;


@Slf4j
@Controller
public class SalesDetailsManagementController {

    public static final String URL_PRIPIX = "salesDetailsManagement";

    @Autowired
    SalesDetailsManagementService salesDetailsManagementService;
    @Autowired
    CommonService commonService;

    //매출명세서 저장
    @RequestMapping("/depositExcelSubmit")
    @ResponseBody
    public void depositExcelSubmit(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO) throws Exception {
        salesDetailsManagementVO.setDepositDtNo(Integer.parseInt(httpServletRequest.getParameter("depositDtNo")));
        salesDetailsManagementVO.setCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        salesDetailsManagementService.depositExcelSubmit(salesDetailsManagementVO);
    }

    //입금내역 삭제
    @RequestMapping("/depositExcelDelete")
    @ResponseBody
    public void depositExcelDelete(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO) throws Exception {
        salesDetailsManagementVO.setDepositDtNo(Integer.parseInt(httpServletRequest.getParameter("depositDtNo")));
        salesDetailsManagementService.depositExcelDelete(salesDetailsManagementVO);
    }

    //입금내역 파일업로드
    @RequestMapping("/depositExcelUpload")
    @ResponseBody
    public void depositExcelUpload(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        //log.debug("업로드 진행");
        MultipartFile excelFile = multipartHttpServletRequest.getFile("depositExcelUpload");
        if (excelFile == null || excelFile.isEmpty()) {
            throw new RuntimeException("엑셀파일을 선택해 주세요");
        }
        File destFile = new File("C:\\upload\\" + excelFile.getOriginalFilename());
        try {
            //내가 설정한 위치에 내가 올린 파일을 만들고
            excelFile.transferTo(destFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        //업로드를 진행하고 다시 지우기
        salesDetailsManagementService.depositExcelUpload(destFile);

        destFile.delete();

    }

    //입금내역 조회
    @RequestMapping("/depositRegistManagement")
    public String depositRegistManagement(
            HttpServletRequest httpServletRequest,
            CommonVO commonVO,
            SalesDetailsManagementVO salesDetailsManagementVO,
            Model model) throws Exception {

        if (httpServletRequest.getParameter("companyNo") != null && !httpServletRequest.getParameter("companyNo").equals("")) {
            salesDetailsManagementVO.setSearchCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        }
        if (httpServletRequest.getParameter("fd_year") != null && !httpServletRequest.getParameter("fd_year").equals("")) {
            salesDetailsManagementVO.setSearchYear(httpServletRequest.getParameter("fd_year"));
        }
        if (httpServletRequest.getParameter("fd_month") != null  && !httpServletRequest.getParameter("fd_month").equals("")) {
            salesDetailsManagementVO.setSearchMonth(httpServletRequest.getParameter("fd_month"));
        }

        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        try {
            PageListVO<SalesDetailsManagementVO> pageList = salesDetailsManagementService.getDepositDetailList(salesDetailsManagementVO);
            model.addAttribute("pageList", pageList);
            model.addAttribute("searchParam", salesDetailsManagementVO);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIPIX + "/depositRegistManagement";
    }

    //매출명세서 저장
    @RequestMapping("/salesExcelSubmit")
    @ResponseBody
    public void salesExcelSubmit(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO) throws Exception {
        salesDetailsManagementVO.setSalDtNo(Integer.parseInt(httpServletRequest.getParameter("salDtNo")));
        salesDetailsManagementVO.setSiteNo(Integer.parseInt(httpServletRequest.getParameter("siteNo")));
        salesDetailsManagementService.salesExcelSubmit(salesDetailsManagementVO);
    }

    //매출명세서 삭제
    @RequestMapping("/salesExcelDelete")
    @ResponseBody
    public void salesExcelDelete(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO) throws Exception {
        salesDetailsManagementVO.setSalDtNo(Integer.parseInt(httpServletRequest.getParameter("salDtNo")));
        salesDetailsManagementService.salesExcelDelete(salesDetailsManagementVO);
    }

    //매출명세서 파일업로드
    @RequestMapping("/salesExcelUpload")
    @ResponseBody
    public void salesExcelUpload(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        //log.debug("업로드 진행");
        MultipartFile excelFile = multipartHttpServletRequest.getFile("excelUpload");
        if (excelFile == null || excelFile.isEmpty()) {
            throw new RuntimeException("엑셀파일을 선택해 주세요");
        }
        File destFile = new File("C:\\upload\\" + excelFile.getOriginalFilename());
        try {
            //내가 설정한 위치에 내가 올린 파일을 만들고
            excelFile.transferTo(destFile);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        //업로드를 진행하고 다시 지우기
        salesDetailsManagementService.excelUpload(destFile);

        destFile.delete();

    }

    //매출명세서 조회
    @RequestMapping("/salesStatusRegistManagement")
    public String salesStatusRegistManagement(
            HttpServletRequest httpServletRequest,
            CommonVO commonVO,
            SalesDetailsManagementVO salesDetailsManagementVO,
            Model model) throws Exception {

        if (httpServletRequest.getParameter("companyNo") != null && !httpServletRequest.getParameter("companyNo").equals("")) {
            salesDetailsManagementVO.setSearchCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        }
        if (httpServletRequest.getParameter("fd_year") != null) {
            salesDetailsManagementVO.setSearchYear(httpServletRequest.getParameter("fd_year"));
        }
        if (httpServletRequest.getParameter("fd_month") != null) {
            salesDetailsManagementVO.setSearchMonth(httpServletRequest.getParameter("fd_month"));
        }
        List<CommonVO> companyList = commonService.getCommonCompanyList(commonVO);
        model.addAttribute("companyList", companyList);

        //매출명세서의 현장등록 시 현장조회
        List<CommonVO> siteList = commonService.getCommonSiteList(commonVO);
        model.addAttribute("siteList", siteList);

        try {
            PageListVO<SalesDetailsManagementVO> pageList = salesDetailsManagementService.getSalesDetailList(salesDetailsManagementVO);
            model.addAttribute("pageList", pageList);
            model.addAttribute("searchParam", salesDetailsManagementVO);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIPIX + "/salesStatusRegistManagement";
    }

    //현장별 매출현황 상세
    @RequestMapping("/companySiteSales")
    public String companySiteSales(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO, Model model) throws Exception {

        salesDetailsManagementVO.setSalDtIssueDate(httpServletRequest.getParameter("year"));
        salesDetailsManagementVO.setCompanyName(httpServletRequest.getParameter("companyName"));

        List<SalesDetailsManagementVO> list = salesDetailsManagementService.getSiteSalesDetail(salesDetailsManagementVO);
        model.addAttribute("list", list);
        model.addAttribute("companyName", salesDetailsManagementVO.getCompanyName());
        model.addAttribute("year", salesDetailsManagementVO.getSalDtIssueDate());

        return URL_PRIPIX + "/companySiteSales";
    }

    //업체별 입금내역 상세
    @RequestMapping("/companyDepositDetail")
    public String companyDepositDetail(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO, Model model) throws Exception {

        salesDetailsManagementVO.setCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        salesDetailsManagementVO.setDyear(httpServletRequest.getParameter("year"));

        if (httpServletRequest.getParameter("fd_month") != null  && !httpServletRequest.getParameter("fd_month").equals("")) {
            salesDetailsManagementVO.setSearchMonth(httpServletRequest.getParameter("fd_month"));
        }

        List<SalesDetailsManagementVO> list = salesDetailsManagementService.getCompanyDepositDetailList(salesDetailsManagementVO);
        model.addAttribute("list", list);
        model.addAttribute("searchParam", salesDetailsManagementVO);
        model.addAttribute("companyNo", salesDetailsManagementVO.getCompanyNo());
        model.addAttribute("year", salesDetailsManagementVO.getDyear());

        return URL_PRIPIX + "/companyDepositDetail";
    }

    //매출현황상세
    @RequestMapping("/companySalesDetailList")
    public String companySalesDetailList(HttpServletRequest httpServletRequest, SalesDetailsManagementVO salesDetailsManagementVO, Model model) throws Exception {

        salesDetailsManagementVO.setCompanyNo(Integer.parseInt(httpServletRequest.getParameter("companyNo")));
        salesDetailsManagementVO.setCompanyName(httpServletRequest.getParameter("companyName"));

        List<SalesDetailsManagementVO> list = salesDetailsManagementService.getCompanySalesDetailList(salesDetailsManagementVO);

        //입금액과 매출액이 동일한 년도에 발생한 데이터가 없을 경우, listNotEmpty를 view에 출력하고,
        //데이터가 있다면 list데이터를 출력한다.
        if (list.isEmpty()) {
            List<SalesDetailsManagementVO> listNotEmpty = salesDetailsManagementService.getCompanySalesDetailListNotEmpty(salesDetailsManagementVO);
            model.addAttribute("list", "NoData");
            model.addAttribute("listNotEmpty", listNotEmpty);
        } else {
            model.addAttribute("list", list);
        }

        model.addAttribute("companyName", salesDetailsManagementVO.getCompanyName());

        return URL_PRIPIX + "/companySalesDetailList";
    }

    //매출현황조회
    @RequestMapping("/companySalesList")
    public String companySalesList(SalesDetailsManagementVO salesDetailsManagementVO, Model model) throws Exception {

        List<SalesDetailsManagementVO> list = salesDetailsManagementService.getCompanySalesListTop(salesDetailsManagementVO);
        model.addAttribute("list", list);

        try {
            PageListVO<SalesDetailsManagementVO> pageList = salesDetailsManagementService.getCompanySalesList(salesDetailsManagementVO);
            model.addAttribute("pageList", pageList);
        } catch (Exception e) {
            throw AlertPageException.builder()
                    .alertMsg(e.getMessage())
                    .historyBack(true)
                    .build();
        }
        return URL_PRIPIX + "/companySalesList";
    }
}
