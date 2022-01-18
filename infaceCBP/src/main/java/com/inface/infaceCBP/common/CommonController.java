package com.inface.infaceCBP.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {

    @Autowired CommonService commonService;

    //현장조회
    @RequestMapping("/getCommonSiteList")
    @ResponseBody
    public void getCommonSiteList(CommonVO commonVO) throws Exception{
        commonService.getCommonSiteList(commonVO);
    }

    //업체조회
    @RequestMapping("/getCommonCompanyList")
    public void getCommonCompanyList(CommonVO commonVO) throws Exception{
        commonService.getCommonCompanyList(commonVO);
    }

    @RequestMapping(value = {"/","/main"})
    public static String main(String[] args) {
        return "index";
    }
}
