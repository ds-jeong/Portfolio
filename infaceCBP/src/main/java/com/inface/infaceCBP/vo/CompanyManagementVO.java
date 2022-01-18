package com.inface.infaceCBP.vo;

import com.inface.infaceCBP.web.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CompanyManagementVO extends BaseVO {
    
    //subcontractor_company 테이블
    private Integer subcontractorCmNo; //협력업체번호
    private String subcontractorCmNm; //협력업체명
    private String subcontractorCmBsinesNum; //사업자등록번호
    private String subcontractorCmCeoNm; //대표자명
    private String subcontractorCmBsinesAddr; //사업자주소
    private String subcontractorCmPhone; //협력업체 연락처
    private String bankAcountNum; //계좌번호
    private String bankNm; //거래은행
    private String accountHolder; //예금주
    private String createDt; //등록일

    //company 테이블
    private Integer companyGroupNo; // '그룹번호';
    private Integer companyNo;// '본사번호';
    private String companyName; //'본사명';
    private String ceoName;//'대표자명';
    private String businessField;//'주요사업분야';
    private String tel; //'전화';
    private String fax; //'팩스';
    private String email;//'이메일';
    private String homepage;//'홈페이지';
    private String companyKind;//'C:법인,M:사업자,U:유한';
    private String businessNo; //'사업자번호';
    private String corporationNo;//'법인번호';
    private String serviceState; //'서비스 사용 여부 : Y:사용중,N:사용중';
    private String laborYn;//'노무사용여부 : Y:사용중,N:사용중';
    private String siteModifyGongsuAuth;//'현장공수 권한 : Y:하도급,N:직영';
    private String businessType; //'업태';
    private String industry;//'종목';
    private String businessLicense;//'사업자등록증';
    private String comapnyLogo; //'회사로고';
    private String licenseOriginFilename; //'사업자등록증원본명';
    private String logoOriginFilename;//'회사로고파일원본명';
    private String cpApplyGongsuCs; //'본사확정공수권한여부-C:본사';
    private String jibunAddress;//'본점지번주소';
    private String roadAddress;//'본점도로명주소';
    private String placeAddress;//'사업장지번주소';
    private String placeRoadAddress;//'사업장도로명주소';
    private String dongCode;//'동코드';
    private String deleteYn;//'N:미삭제,Y:삭제';
    private String basicInTime;//'기본출근시간';
    private String basicOutTime;//'기본퇴근시간';
    private Integer basicWorkTime;//'기본근무시간';
    private String acceptInTime;//'인정출근시간안에 출근시 기본출근시간 인정';
    private String acceptOutTime;//'인정출근시간안에 출근시 기본출근시간 인정';
    //private String createDt;//'본사생성일자';
    private String companyRefNo;//'본사연동번호';
    private Integer branchOfficeWhethe;//'지점여부번호=0:본사, 1:지점';

    //ValueObjects
    private Integer detailNo; //글목록상세번호
    private String tel1; //전화번호 value
    private String tel2;
    private String tel3;

    //searchValue
    private String searchSiteState; // 현장사용여부검색
    private int searchCompanyNo; // 업체번호검색
    private String searchCompanyName; // 업체명검색
    private String searchBusinessNo; // 사업자등록번호검색
}
