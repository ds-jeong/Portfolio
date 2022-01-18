package com.inface.infaceCBP.vo;

import com.inface.infaceCBP.web.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class DeviceManagementVO extends BaseVO {

    //device 테이블
    private Integer siteNo; //현장번호
    private Integer deviceKindNo; //단말기종류번호
    private Integer deviceDtNo;//단말기상세번호
    private String deviceState;//단말기사용여부
    private String deviceSn;//단말기시리얼번호
    private String deviceLoca;//단말기현재위치
    private String devicePurchaseDate;//단말기구매일
    private String deviceRegistDate;//단말기등록일
    private String deviceNote;//비고
    private String deviceInstallationDate;//단말기설치일
    private String deviceEndDate;//단말기종료일
    private String deviceNm;//단말기명

    //wireless_equipment 테이블
    private Integer wirelessEquipmentDtNo; //무선단말기상세번호
    private String wirelessEquipmentState;//무선단말기사용여부 01:사용 02:종료
    private Integer wirelessEquipmentCarrierDtNo;//무선장비통신사상세번호
    private String wirelessEquipmentSubscripNum;//가입번호
    private String wirelessEquipmentSn;//무선단말기시리얼번호
    private String wirelessEquipmentSsn;//유심일련번호
    private String wirelessEquipmentOpenNum;//개통번호
    private String wirelessEquipmentOpenDate;//개통날짜
    private String wirelessEquipmentLoca;//현재위치
    private String wirelessEquipmentNote;//비고

    //ValueObjects
    private String deviceKind;//단말기종류
    private String wirelessEquipmentCarrierKind;//무선장비통신사

    //searchValue
    private Integer searchDeviceKindNo; //단말기종류번호검색
    private String searchDeviceSn; //단말기시리얼번호검색
    private Integer searchWirelessEquipmentCarrierDtNo; //무선장비통신사상세번호검색
    private String searchWirelessEquipmentSn; //무선단말기시리얼번호검색
}
