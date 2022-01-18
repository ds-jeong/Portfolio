package com.inface.infaceCBP.service;

import com.inface.infaceCBP.mapper.SalesDetailsManagementMapper;
import com.inface.infaceCBP.utils.ExcelRead;
import com.inface.infaceCBP.utils.ExcelReadOption;
import com.inface.infaceCBP.vo.SalesDetailsManagementVO;
import com.inface.infaceCBP.web.BaseService;
import com.inface.infaceCBP.web.PageListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class SalesDetailsManagementService extends BaseService{

    @Autowired SalesDetailsManagementMapper salesDetailsManagementMapper;

    //입금내역 저장
    @Transactional
    public void depositExcelSubmit(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        salesDetailsManagementMapper.depositExcelSubmit(salesDetailsManagementVO);
    };
    //입금내역 삭제
    @Transactional
    public void depositExcelDelete(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        salesDetailsManagementMapper.depositExcelDelete(salesDetailsManagementVO);
    };
    //입금내역 엑셀파일업로드
    @Transactional
    public void depositExcelUpload(File destFile) throws Exception{
        ExcelReadOption excelReadOption = new ExcelReadOption();

        //파일경로 추가
        excelReadOption.setFilePath(destFile.getAbsolutePath());

        //추출할 컬럼명 추가
        excelReadOption.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG");

        //시작행
        excelReadOption.setStartRow(3);

        List<Map<String, String>> depositExcelContent  = ExcelRead.read(excelReadOption);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("depositExcelContent", depositExcelContent);

        System.out.println("ExcelutilService : " + paramMap);
        try {
            salesDetailsManagementMapper.insertDepositDtExcel(paramMap);
        }catch(Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
    //입금내역 조회
    @Transactional
    public PageListVO<SalesDetailsManagementVO> getDepositDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        List<SalesDetailsManagementVO> list =salesDetailsManagementMapper.getDepositDetailList(salesDetailsManagementVO);
        PageListVO<SalesDetailsManagementVO> pageList = makeMapperPageListVO(salesDetailsManagementVO, list);
        return pageList;
    };
    //매출명세서 저장
    @Transactional
    public void salesExcelSubmit(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        salesDetailsManagementMapper.salesExcelSubmit(salesDetailsManagementVO);
    };
    //매출명세서 삭제
    @Transactional
    public void salesExcelDelete(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        salesDetailsManagementMapper.salesExcelDelete(salesDetailsManagementVO);
    };
    //매출명세서 엑셀파일업로드
    @Transactional
    public void excelUpload(File destFile) throws Exception{
        ExcelReadOption excelReadOption = new ExcelReadOption();

        //파일경로 추가
        excelReadOption.setFilePath(destFile.getAbsolutePath());

        //추출할 컬럼명 추가
        excelReadOption.setOutputColumns("A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG");

        //시작행
        excelReadOption.setStartRow(3);

        List<Map<String, String>> excelContent  = ExcelRead.read(excelReadOption);

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("excelContent", excelContent);

        System.out.println("ExcelutilService : " + paramMap);
        try {
            salesDetailsManagementMapper.insertSalesDtExcel(paramMap);
        }catch(Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
    //매출명세서 조회
    @Transactional
    public PageListVO<SalesDetailsManagementVO> getSalesDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        List<SalesDetailsManagementVO> list =salesDetailsManagementMapper.getSalesDetailList(salesDetailsManagementVO);
        PageListVO<SalesDetailsManagementVO> pageList = makeMapperPageListVO(salesDetailsManagementVO, list);
        return pageList;
    };
    //현장별 매출현황 상세
    @Transactional
    public List<SalesDetailsManagementVO> getSiteSalesDetail(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        return salesDetailsManagementMapper.getSiteSalesDetail(salesDetailsManagementVO);
    }
    //업체별 입금내역상세조회
    @Transactional
    public List<SalesDetailsManagementVO> getCompanyDepositDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        return salesDetailsManagementMapper.getCompanyDepositDetailList(salesDetailsManagementVO);
    };
    //업체별 매출상세조회가 null일때의 경우, 다른 쿼리를 날린다.
    @Transactional
    public List<SalesDetailsManagementVO> getCompanySalesDetailListNotEmpty(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        return salesDetailsManagementMapper.getCompanySalesDetailListNotEmpty(salesDetailsManagementVO);
    };
    //업체별 매출상세조회
    @Transactional
    public List<SalesDetailsManagementVO> getCompanySalesDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        return salesDetailsManagementMapper.getCompanySalesDetailList(salesDetailsManagementVO);
    };
    //매출현황 조회 Top
    @Transactional
    public List<SalesDetailsManagementVO> getCompanySalesListTop(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        return salesDetailsManagementMapper.getCompanySalesListTop(salesDetailsManagementVO);
    };
    //매출현황 조회
    @Transactional
    public PageListVO<SalesDetailsManagementVO> getCompanySalesList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception{
        List<SalesDetailsManagementVO> list =salesDetailsManagementMapper.getCompanySalesList(salesDetailsManagementVO);
        PageListVO<SalesDetailsManagementVO> pageList = makeMapperPageListVO(salesDetailsManagementVO, list);
        return pageList;
    };




}
