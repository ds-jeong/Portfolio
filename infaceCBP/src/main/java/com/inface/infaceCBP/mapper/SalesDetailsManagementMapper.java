package com.inface.infaceCBP.mapper;

import com.inface.infaceCBP.vo.SalesDetailsManagementVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface SalesDetailsManagementMapper {
   //입금내역 저장
   void depositExcelSubmit(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //입금내역 삭제
   void depositExcelDelete(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //입금내역 파일 업로드
   void insertDepositDtExcel(Map<String, Object> paramMap) throws Exception;
   //입금내역 조회
   List<SalesDetailsManagementVO> getDepositDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //매출명세서 저장
   void salesExcelSubmit(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //매출명세서 삭제
   void salesExcelDelete(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //매출명세서 파일 업로드
   void insertSalesDtExcel(Map<String, Object> paramMap) throws Exception;
   //매출명세서 조회
   List<SalesDetailsManagementVO> getSalesDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //현장별매출 상세조회
   List<SalesDetailsManagementVO> getSiteSalesDetail(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //업체별 입금내역 상세조회
   List<SalesDetailsManagementVO> getCompanyDepositDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //업체별매출 상세조회가 없을때, 해당쿼리를 탄다.
   List<SalesDetailsManagementVO> getCompanySalesDetailListNotEmpty(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //업체별매출 상세조회
   List<SalesDetailsManagementVO> getCompanySalesDetailList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //매출현황 조회 Top
   List<SalesDetailsManagementVO> getCompanySalesListTop(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;
   //매출현황 조회
   List<SalesDetailsManagementVO> getCompanySalesList(SalesDetailsManagementVO salesDetailsManagementVO) throws Exception;

}
