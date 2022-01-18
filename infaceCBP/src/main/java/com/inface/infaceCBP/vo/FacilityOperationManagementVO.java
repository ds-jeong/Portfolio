package com.inface.infaceCBP.vo;

import com.inface.infaceCBP.common.CommonVO;
import com.inface.infaceCBP.web.BaseVO;
import com.inface.infaceCBP.web.PageListVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
public class FacilityOperationManagementVO extends BaseVO {

    //facility_info 테이블
    private Integer companyNo; //업체번호
    private Integer siteNo; //현장번호
    private Integer subcontractorCmNo; //협력업체번호
    private String facilityUseState; //시설의 진행상태 00:예정 01:완료 02:취소
    private String facilityReqContent; //시설요청내용
    private String facilityReqDate; //시설요청날짜
    private String facilityManager; //담당자
    private String facilityManagerPhone; //연락처
    private Integer facilityAccount; //시설비용
    private Integer paymentAccount; //지급비용
    private String createDt; //시설정보등록일

    //ValueObjects
    private String companyName;//업체명
    private String siteName;//현장명
    private String subcontractorCmNm;//협력업체명
    private String Dyear;//연도
    private String Dmm;//월
    private String Ddd;//일
    private String Dtime;//시간
    private int detailNo; // 글목록의 상세번호

    //searcValue
    private String searchFacilityUseState; // 시설의 진행상태 검색
    private String searchYear; // 시설 요청일 년도 검색
    private String searchMonth; // 시설 요청일 월별 검색
    private int searchCompanyNo; // 업체번호검색
}
