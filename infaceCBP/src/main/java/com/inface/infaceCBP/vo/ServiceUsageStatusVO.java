package com.inface.infaceCBP.vo;

import com.inface.infaceCBP.web.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
public class ServiceUsageStatusVO extends BaseVO {

    //site테이블 : 현장정보테이블
    private int companyGroupNo; //그룹번호
    private int companyNo; //업체번호
    private int siteNo; //현장번호
    private int cityNo; //지역번호
    private String siteName; //현장명
    private String covenantorName; //원청명
    private String createDevState; //N:단말기 등록, Y:수기등록
    private String siteTel; //현장연락처
    private String siteFax; //현장팩스
    private String siteDongCode; //현장동코드
    private String siteAddress; //현장구주소
    private String siteRoadAddress; //현장도로명주소
    private String constructionStartdt; //공사시작일
    private String constructionEnddt; //공사준공일
    private String closeSiteYn; //N:진행,Y:종료
    private String deleteYn; //N:미삭제,Y:삭제
    private String day19by8Ne; //19일과8일여부-N:19일
    private String basicInTime; //기본출근시간
    private String basicOutTime; //기본퇴근시간
    private int basicWorkTime; //기본작업시간
    private String acceptInTime; //인정출근시간안에 출근시 기본출근시간 인정
    private String acceptOutTime; //인정출근시간안에 출근시 기본출근시간 인정
    private int amBreakMinute; //오전참
    private int pmBreakMinute; //오후참
    private int lunchMinute; //점심
    private String amBreakCloseTime; //오전참시간
    private String pmBreakCloseTime; //오후참시간
    private String lunchCloseTime; //점심시간
    private int amBreakGongsu; //오전참공수
    private int pmBreakGongsu; //오후참공수
    private int lunchGounsu; //점심공수
    private int notWorkTimeGongsu; //미처리공수
    private Date createDt; //생성날짜
    private String siteState; //현장사용여부 0:예정 1:사용 2:종료
    private String siteManagerName; //현장관리자명
    private String siteManagerFeild; //현장관리자직위
    private String siteStartDate; //현장시작일
    private String siteEndDate; //현장종료일

    //client_site_manager 테이블 : 현장별 담당자테이블(한 현장에 여러 담당자가 존재할 수 있음.)
    private int clientManagerNo; //담당자 테이블 상세번호
    private String clientManagerState; //담당자 사용여부 y, n
    private String clientManagerNm; //담당자명
    private String clientManagerPosition; //담당자직위
    private String clientManagerPhone; //담당자연락처
    private String clientManagerEmail; //담당자이메일
    private String TaxChk; //세금계산서 발행여부 y, n

    //device_history 테이블 : 현장별 단말기 이력 테이블
    private Integer deviceHistoryDtNo; //단말기이력상세번호
    private String deviceHistoryState; //현장단말기사용여부 01:사용 02:종료
    private Integer deviceKindNo; //단말기종류
    private Integer deviceDtNo; //단말기상세번호
    private String deviceHistoryInstallationDate; //단말기설치날짜        
    private String deviceHistoryEndDate; //단말기종료날짜
    private String deviceHistoryDeviceNm;//단말기명

    //wireless_equipment_history 테이블 : 현장별 무선단말기 이력 테이블
    private Integer wirelessEquipmentHistoryDtNo; //무성단말기이력상세번호
    private String wirelessEquipmentHistoryState; //현장무선단말기사용여부 01:사용 02:종료
    private Integer wirelessEquipmentCarrierDtNo; //무선단말기통신사
    private Integer wirelessEquipmentDtNo; //무선단말기상세번호
    private String wirelessEquipmentHistoryInstallationDate; //무선단말기설치날짜
    private String wirelessEquipmentHistoryEndDate; //무선단말기종료날짜

    //site_month_account 테이블 : 현장별 월사용료테이블
    private int siteMonthAccountNo;//월사용료번호
    private String systemAccount;//시스템사용료
    private String deviceAccount;//단말기사용료
    private String internetAccount;//무선인터넷사용료
    private String taxAccountDt;//세금계산서발행일

    //ValueObjects
    private int detailNo; //리스트의 디테일번호
    private String companyName; //업체명
    private String deviceKind; //단말기종류명
    private String deviceSn; //단말기시리얼번호
    private String wirelessEquipmentCarrierKind; //단말기종류명
    private String wirelessEquipmentSn; //단말기시리얼번호
    private Integer beforeDeviceDtNo; //현장이 업데이트 되기전 단말기상세번호
    private Integer beforeWirelessEquipmentDtNo; //현장이 업데이트 되기전 무선단말기상세번호
    private Integer ycnt; //운영중인 현장개수
    private Integer ncnt; //운영중인 현장개수
    private Integer deviceKindNo1; //사용중인 단말기개수 끝에붙은 숫자는 단말기종류번호
    private Integer deviceKindNo2; //사용중인 단말기개수 끝에붙은 숫자는 단말기종류번호
    private Integer deviceKindNo3; //사용중인 단말기개수 끝에붙은 숫자는 단말기종류번호
    private Integer deviceKindNo4; //사용중인 단말기개수 끝에붙은 숫자는 단말기종류번호
    private Integer deviceKindNo5; //사용중인 단말기개수 끝에붙은 숫자는 단말기종류번호
    private Integer wirelessEquipmentcnt1; //사용중인 무선단말기개수 끝에붙은 숫자는 단말기통신사번호
    private Integer wirelessEquipmentcnt2; //사용중인 무선단말기개수 끝에붙은 숫자는 단말기통신사번호
    private Integer wirelessEquipmentcnt3; //사용중인 무선단말기개수 끝에붙은 숫자는 단말기통신사번호

    //searchValue
    private String searchSiteState; // 현장사용여부검색
    private int searchCompanyNo; // 업체번호검색
    private String searchCompanyName; // 업체번호검색

}
