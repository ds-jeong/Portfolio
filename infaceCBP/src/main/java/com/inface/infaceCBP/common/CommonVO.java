package com.inface.infaceCBP.common;

import com.inface.infaceCBP.web.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonVO extends BaseVO {
    private String companyGroupNo; //그룹번호
    private String companyGroupName; //그룹명
    private Integer companyNo; //업체번호
    private String companyName; //업체명
    private String siteNo; //현장번호
    private String siteName; //현장명
    private String siteRoadAddress; //현장별 주소
    private String businessNo; //업체 사업자등록번호
    private String ceoName; //업체대표자명
    private String businessField; //업체종목
    private String tel; //업체연락처
    private String email; //업체이메일
    private String roadAddress; //업체도로명주소
    private int subcontractorCmNo; //협력업체번호
    private String subcontractorCmNm; //협력업체명
    private String subcontractorCmBsinesNum; //협력업체사업자등록번호

}
