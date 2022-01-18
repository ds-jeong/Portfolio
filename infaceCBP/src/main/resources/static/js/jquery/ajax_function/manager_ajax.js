/*
* 한 화면에서 리스트와 등록 및 수정 처리를 구현하기 위해 function별로 나눠서 처리함. *
*/


//operationSiteDetail : 매니저 등록 부분처리
function managerTableInsertJs(idx) {

    let addHtml = "";
    addHtml = addHtml +
        "<tr id='listTrTop" + idx + "'>" +
        "<th><input type=\"radio\" value=\"Y\" className=\"t_inp\" id=\"useStateY\" name='useState" + idx + "'>" +
        "<label htmlFor=\"useStateY\">사용</label>" +
        "<input type=\"radio\" value=\"N\" className=\"t_inp\" id=\"useStateN\" name='useState" + idx + "'>" +
        "<label htmlFor=\"useStateN\">종료</label>" +
        "</th>" +
        "<th><input type=\"text\" className=\"t_inp\" name='managerNm" + idx + "'/></th>" +
        "<th><input type=\"text\" className=\"t_inp\" name='managerPosition" + idx + "'/></th>" +
        "<th className=\"hp\">" +
        "<input type=\"text\" className=\"t_inp\" name='tel1" + idx + "' onkeydown='return checkNumber(event);'/>" +
        "<input type=\"text\" className=\"t_inp\" name='tel2" + idx + "' onkeydown='return checkNumber(event);'/>" +
        "<input type=\"text\" className=\"t_inp\" name='tel3" + idx + "' onkeydown='return checkNumber(event);'/>" +
        "</th>" +
        "<th><input type=\"text\" className=\"t_inp\" name='email" + idx + "' class='email'/></th>" +
        "<th><input type=\"checkbox\" value=\"Y\" name='taxChk" + idx + "'>발행</th>" +
        "<th class='labelBtn'>" +
        "<label for='goCancel" + idx + "'><input id='goCancel" + idx + "' type=\"button\"  class='goCancel'>취소</label>" +
        "<label for='goRegist" + idx + "'><input id='goRegist" + idx + "' type=\"button\"  class='goRegist'>저장</label>" +
        "</th>" +
        "</tr>";
    $("#tablet thead").append(addHtml);
    //취소버튼을 눌렀을때,실행
    $("#goCancel" + idx + "").on("click", function () {
        $(".listTrTop:eq(" + idx + ")").load(location.href + " .listTrTop:eq(" + idx + ")");
    });
    //저장버튼을 눌렀을때,실행
    $("#goRegist" + idx + "").on("click", function () {
        if (!$("input[name='useState" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if (!$("input[name='managerNm" + idx + "']").val()) {
            alert("담당자명을 입력해주세요.");
            return false;
        } else if (!$("input[name='tel1" + idx + "']").val() || !$("input[name='tel2" + idx + "']").val() || !$("input[name='tel3" + idx + "']").val()) {
            alert("연락처를 전부 입력해주세요.");
            return false;
        } else if (!$("input[name='email" + idx + "']").val()) {
            alert("이메일을 입력해주세요.");
            return false;
        } else {
            let clientManagerState = $("input[name='useState" + idx + "']:checked").val();
            let clientManagerNm = $("input[name='managerNm" + idx + "']").val();
            let clientManagerPosition = $("input[name='managerPosition" + idx + "']").val();
            let clientManagerEmail = $("input[name='email" + idx + "']").val();
            let clientManagerPhone = $("input[name='tel1" + idx + "']").val().concat("-", $("input[name='tel2" + idx + "']").val()).concat("-", $("input[name='tel3" + idx + "']").val());
            let taxChk = $("input[name='taxChk" + idx + "']:checked").val();
            let siteNo = $("input[name='siteNo']").val();
            //이메일 형식을 체크
            if (checkEmail(clientManagerEmail) == false) {
                alert("이메일을 다시 입력해주세요.")
                return false;
            }
            $.ajax({
                url     : "/siteManagerRegist",
                type    : "post",
                data    : {
                    clientManagerState   : clientManagerState,
                    clientManagerNm      : clientManagerNm,
                    clientManagerPosition: clientManagerPosition,
                    clientManagerEmail   : clientManagerEmail,
                    clientManagerPhone   : clientManagerPhone,
                    taxChk               : taxChk,
                    siteNo               : siteNo
                },
                success : function (data) {
                    $("#listTrTop" + idx + "").load(location.href + " #listTrTop" + idx + "");
                    $("#tablet tbody").load(location.href + " .listTr");
                }, error: function () {
                    alert("error");
                }
            });
        }
    });
}

//operationSiteDetail : 매니저 수정 부분처리
function managerTableUpdateJs(idx) {
    //수정버튼을 누르고 현재 데이터를 가져온다.
    let siteNo = $(".goUpdateManager:eq(" + idx + ")").attr("siteNo"); //현장번호
    let clientManagerNo = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerNo"); //관리자번호
    let clientManagerState = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerState"); //관리자사용여부
    let clientManagerNm = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerNm"); //관리자명
    let clientManagerPosition = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerPosition"); //관리자직위
    let clientManagerPhone = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerPhone"); //관리자연락처
    let phone = clientManagerPhone.split('-');
    let clientManagerEmail = $(".goUpdateManager:eq(" + idx + ")").attr("clientManagerEmail"); //관리자이메일
    let taxChk = $(".goUpdateManager:eq(" + idx + ")").attr("taxChk"); //세금계산서발행여부
    //html을 입력이 가능하게 바꿔주고, 데이터를 뿌려줌.
    let addHtml2 = "";
    addHtml2 += "<td><span><input type='radio' value='Y' name='clientManagerState" + idx + "' class='stateY" + idx + "'" + ((clientManagerState.replace(" ", "") == "Y") ? "checked" : "") + "/>사용</span>"
        + "<span><input type='radio' value='N' name='clientManagerState" + idx + "' class='stateN" + idx + "'" + ((clientManagerState.replace(" ", "") == "N") ? "checked" : "") + "/>종료</span></td>"
        + "<td><input type='text' value='" + clientManagerNm + "' name='clientManagerNm" + idx + "'/></td>"
        + "<td><input type='text' value='" + clientManagerPosition + "' name='clientManagerPosition" + idx + "' /></td>"
        + "<td><input type='text' value='" + phone[0] + "' name='tel1" + idx + "' onkeydown='return checkNumber(event);'/>"
        + "<input type='text' value='" + phone[1] + "' name='tel2" + idx + "' onkeydown='return checkNumber(event);'/>"
        + "<input type='text' value='" + phone[2] + "' name='tel3" + idx + "' onkeydown='return checkNumber(event);'/>"
        + "</td>"
        + "<td><input type='text' value='" + clientManagerEmail + "' name='clientManagerEmail" + idx + "'/></td>"
        + "<td><input type='checkbox' value='" + taxChk + "' name='taxChk" + idx + "'" + ((taxChk.replace(" ", "") == "Y") ? "checked" : "") + "/>발행</td>"
        + "<td class='labelBtn'>"
        + "<label><input type='button' value='취소' id='goUpdateCancel" + idx + "'/></label>"
        + "<label><input type='button' value='저장' id='goUpdateSubmit" + idx + "'/></label>"
        + "</td>";

    $(".listTr:eq(" + idx + ")").find('td').hide();
    $(".listTr:eq(" + idx + ")").append(addHtml2);

    /*$("#registManager").on("click", function () {
        $("#thead tr:eq(1)").empty();
        alert("수정 중에 담당자추가를 할 수 없습니다.");
        location.reload();
    });*/

    //취소버튼을 클릭하면, 실행
    $("#goUpdateCancel" + idx + "").on("click", function () {
        $(".listTr:eq(" + idx + ")").load(location.href + " .listTr:eq(" + idx + ") td");
    });
    //수정처리를 저장하면, 실행
    $("#goUpdateSubmit" + idx + "").on("click", function () {
        if (!$("input[name='clientManagerState" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if (!$("input[name='clientManagerNm" + idx + "']").val()) {
            alert("담당자명을 입력해주세요.");
            return false;
        } else if (!$("input[name='tel1" + idx + "']").val() || !$("input[name='tel2" + idx + "']").val() || !$("input[name='tel3" + idx + "']").val()) {
            alert("연락처를 전부 입력해주세요.");
            return false;
        } else if (!$("input[name='clientManagerEmail" + idx + "']").val()) {
            alert("이메일을 입력해주세요.");
            return false;
        } else {

            let clientManagerState = $("input[name='clientManagerState" + idx + "']:checked").val();
            let clientManagerNm = $("input[name='clientManagerNm" + idx + "']").val();
            let clientManagerPosition = $("input[name='clientManagerPosition" + idx + "']").val();
            let clientManagerPhone = $("input[name='tel1" + idx + "']").val().concat('-', $("input[name='tel2" + idx + "']").val()).concat('-', $("input[name='tel3" + idx + "']").val());
            let clientManagerEmail = $("input[name='clientManagerEmail" + idx + "']").val();
            let uTaxChk = "";

            if ($("input[name='taxChk" + idx + "']").is(':checked')) {
                uTaxChk = 'Y';
            } else {
                uTaxChk = 'N';
            }
            //let email = $("input[name='clientManagerEmail" + idx + "']").val(); //이메일체크를 위한 변수
            if (checkEmail(clientManagerEmail) == false) {
                alert("이메일을 다시 입력해주세요.")
                return false;
            }

            $.ajax({
                url     : "/siteManagerModify",
                type    : "post",
                data    : {
                    clientManagerState     : clientManagerState
                    , clientManagerNm      : clientManagerNm
                    , clientManagerPosition: clientManagerPosition
                    , clientManagerPhone   : clientManagerPhone
                    , clientManagerEmail   : clientManagerEmail
                    , taxChk               : uTaxChk
                    , siteNo               : siteNo
                    , clientManagerNo      : clientManagerNo
                },
                success : function (data) {
                    $(".listTr:eq(" + idx + ")").load(location.href + " .listTr:eq(" + idx + ") td");
                    //$("#tablet tbody").load(location.href + " .listTrDeviceTop");
                }, error: function () {
                    alert("error");
                }

            });
        }
    });
}
