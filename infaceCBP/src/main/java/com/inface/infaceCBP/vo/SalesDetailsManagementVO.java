package com.inface.infaceCBP.vo;

import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.web.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class SalesDetailsManagementVO extends BaseVO {

    //sales_detail 테이블블
   private int salDtNo; //테이블상세번호
   private int siteNo; //현장번호
   private String siteName; //현장명
   private String salDtBusinessNo; //사업자등록번호
   private String salDtApprovalNumber; //승인번호
   private String salDtIssueDate; //발급일자
   private String salDtSumAccount; //합계금액
   private String salDtSupplyPrice; //공급가액
   private String salDtTaxPrice; //세액
   private String salDtElectronicTaxInvoiceKind; //전자세금계산서종류
   private String salDtElectronicTaxInvoiceClassification; //전자세금계산서분류
   private String salDtType; //발급유형
   private String salDtEmail; //이메일
   private String salDtItemNm; //품목명
   private String salDtItemQuantity; //품목수량
   private String salDtItemUnitPrice; //품목단가
   private String salDtItemSupplyPrice; //품목공금가액
   private String salDtItemTaxAmount; //품목세액
   private String salDtItemCost; //품목비고

    //deposit_detail 테이블
    private int depositDtNo; //입금상세번호
    private String depositDt; //입금일
    private String depositAccount; //입금액
    private String depositContent; //입금내용
    private String depositBank; //거래점명

    //ValueObjects
    private int companyNo; //업체번호
    private String companyName;//업체명
    private String Dyear;//연도
    private String Dmm;//월
    private String Ddd;//일
    private String Dtime;//시간
    private String siteCnt; //총 현장 수
    private String companyCnt; //총 업체 수
    private int sumAccount; //년도기준업체별매출
    private int unpaidAmount; //미수금
    private int cumulativeSum; //미수금누적합계금액
    private int m1; //각 월
    private int m2;
    private int m3;
    private int m4;
    private int m5;
    private int m6;
    private int m7;
    private int m8;
    private int m9;
    private int m10;
    private int m11;
    private int m12;
    private int totalSum;//현장별 년도 전체 매출


    //searchValue
    /*int 의 경우는 primitive Type인데, primitive Type은 기본값이 있기때문에 null이 존재하지않아 null체크에 해당 되지않는다.*/
    private Integer searchCompanyNo; // 업체번호검색
    private String searchCompanyName; // 업체번호검색
    private String searchYear; // 년도별검색
    private String searchMonth; // 월별검색


    List<CommonVO> siteList;

}
