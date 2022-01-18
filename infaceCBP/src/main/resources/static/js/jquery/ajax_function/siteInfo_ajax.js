/*
* 한 화면에서 리스트와 등록 및 수정 처리를 구현하기 위해 function별로 나눠서 처리함. *
*/


//operationSiteDetail : 운영현장의 정보수정처리
function siteTableUpdateJs(idx) {

    //수정버튼을 누르고 현재 데이터를 가져온다.
    let siteState = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteState"); //현장의 운영상태
    let companyName = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("companyName"); //현장의 업체명
    let siteName = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteName"); //현장의 현장명
    let siteStartDate = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteStartDate"); //현장의 현장명
    let siteEndDate = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteEndDate"); //현장의 현장명
    let siteAddress = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteAddress"); //현장주소
    let siteRoadAddress = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteRoadAddress"); //현장도로명주소
    let siteNo = $(".goUpdateSiteInfo:eq(" + idx + ")").attr("siteNo"); //현장번호
    console.log(siteStartDate);
    //html을 입력이 가능하게 바꿔주고, 데이터를 뿌려줌.
    let addHtml2 = "";
    addHtml2 += "<td><span><input type='radio' value='01' name='siteStateUp" + idx + "' class='stateY" + idx + "'" + ((siteState.replace(" ", "") == "01") ? "checked" : "") + "/>운영</span>"
        + "<span><input type='radio' value='02' name='siteStateUp" + idx + "' class='stateN" + idx + "'" + ((siteState.replace(" ", "") == "02") ? "checked" : "") + "/>종료</span></td>"
        + "<td><input type='text' value='" + companyName + "' name='companyNameUp" + idx + "' disabled/></td>"
        + "<td><input type='text' value='" + siteName + "' name='siteNameUp" + idx + "' /></td>"
        + "<td><input type='date' value='" + siteStartDate + "' name='siteStartDateUp" + idx + "' /></td>"
        + "<td><input type='date' value='" + siteEndDate + "' name='siteEndDateUp" + idx + "' /></td>"
        + "<td><input type='text' value='" + ((siteAddress != null) ? siteAddress : siteRoadAddress) + "' name='siteAddressUp" + idx + "' /></td>"
        + "<td class='labelBtn'>"
        + "<label><input type='button' value='취소' id='goUpdateSiteInfoCancelUp" + idx + "'/></label>"
        + "<label><input type='button' value='저장' id='goUpdateSiteInfoSubmitUp" + idx + "'/></label>"
        + "</td>";

    $(".listTrSiteInfo:eq(" + idx + ")").find('td').hide();
    $(".listTrSiteInfo:eq(" + idx + ")").append(addHtml2);

    /*$("#registManager").on("click", function () {
       $("#thead tr:eq(1)").empty();
       alert("수정 중에 담당자추가를 할 수 없습니다.");
       location.reload();
   });*/

    //취소버튼을 클릭하면, 실행
    $("#goUpdateSiteInfoCancelUp" + idx + "").on("click", function () {
        $(".listTrSiteInfo:eq(" + idx + ")").load(location.href + " .listTrSiteInfo:eq(" + idx + ") td");
    });
    //수정처리를 저장하면, 실행
    $("#goUpdateSiteInfoSubmitUp" + idx + "").on("click", function () {
        if (!$("input[name='siteStateUp" + idx + "']:checked").val()) {
            alert("운영여부를 체크하여 주세요.");
            return false;
        } else if (!$("input[name='companyNameUp" + idx + "']").val()) {
            alert("업체명을 입력해주세요.");
            return false;
        } else if (!$("input[name='siteNameUp" + idx + "']").val()) {
            alert("현장명을 입력해주세요.");
            return false;
        } else {
            let siteState = $("input[name='siteStateUp" + idx + "']:checked").val();
            //let companyName = $("input[name='companyNameUp" + idx + "']").val();
            let siteName = $("input[name='siteNameUp" + idx + "']").val();
            let siteStartDate = $("input[name='siteStartDateUp" + idx + "']").val();
            let siteEndDate = $("input[name='siteEndDateUp" + idx + "']").val();
            let siteAddress = $("input[name='siteAddressUp" + idx + "']").val();
            let siteNo = $("input[name='siteNo']").val();

            $.ajax({
                url     : "/siteInfoModify",
                type    : "post",
                data    : {
                    siteState      : siteState
                    , siteName     : siteName
                    , siteStartDate: siteStartDate
                    , siteEndDate  : siteEndDate
                    , siteAddress  : siteAddress
                    , siteNo       : siteNo
                },
                success : function (data) {
                    $(".listTrSiteInfo:eq(" + idx + ")").load(location.href + " .listTrSiteInfo:eq(" + idx + ") td");
                    //$("#tablet tbody").load(location.href + " .listTrDeviceTop");
                }, error: function () {
                    alert("error");
                }

            });
        }
    });
};