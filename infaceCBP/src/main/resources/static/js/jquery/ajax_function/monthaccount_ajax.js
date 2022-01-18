/*
* 한 화면에서 리스트와 등록 및 수정 처리를 구현하기 위해 function별로 나눠서 처리함. *
*/

//operationSiteDetail : 월사용료 등록부분
function monthAccountTableInsertJs(idx) {
    let addHtml = "";
    addHtml = addHtml +
        "<tr class='listTrMonthAccountTop'>" +
        "<th><input type='text' className='t_inp' name='systemAccount" + idx + "' onkeyup='inputNumberFormat(this)'/>원</th>" +
        "<th><input type='text' className='t_inp' name='deviceAccount" + idx + "' onkeyup='inputNumberFormat(this)'/>원</th>" +
        "<th><input type='text' className='t_inp' name='internetAccount" + idx + "' onkeyup='inputNumberFormat(this)'/>원</th>" +
        "<th><input type='text' className='t_inp' name='taxAccountDt" + idx + "' onkeyup='inputNumberFormat(this)'/>일</th>" +
        "<th class='labelBtn'>" +
        "<label for='goCancelMonthAccount" + idx + "'><input type='button' id='goCancelMonthAccount" + idx + "' class='goCancelMonthAccount'>취소</label>" +
        "<label for='goRegistMonthAccount" + idx + "'><input type='button' id='goRegistMonthAccount" + idx + "' class='goRegistMonthAccount'>저장</label>" +
        "</th>" +
        "</tr>";
    $("#tableMonthAccount thead").append(addHtml);
    //취소버튼을 눌렀을때, 실행
    $("#goCancelMonthAccount" + idx + "").on("click", function () {
        $(".listTrMonthAccountTop:eq(" + idx + ")").load(location.href + " .listTrMonthAccountTop:eq(" + idx + ")");
    });
    //저장버튼을 눌렀을때, 실행
    $("#goRegistMonthAccount" + idx + "").on("click", function () {

        let systemAccount = $("input[name='systemAccount" + idx + "']").val();
        let deviceAccount = $("input[name='deviceAccount" + idx + "']").val();
        let internetAccount = $("input[name='internetAccount" + idx + "']").val();
        let taxAccountDt = $("input[name='taxAccountDt" + idx + "']").val();
        let siteNo = $("input[name='siteNo']").val();


        $.ajax({
            url     : "/siteMonthAccountRegist",
            type    : "post",
            data    : {
                systemAccount    : systemAccount
                , deviceAccount  : deviceAccount
                , internetAccount: internetAccount
                , taxAccountDt   : taxAccountDt
                , siteNo         : siteNo
            },
            success : function (data) {
               /* $(".listTrMonthAccountTop:eq(" + idx + ")").load(location.href + " .listTrMonthAccountTop:eq(" + idx + ")");
                $("#tableMonthAccount tbody").load(location.href + " .listTrMonthAccount");
                $("#registMonthAccount").load(location.href + " #registMonthAccount");*/
                location.reload();
            }, error: function () {
                alert("error");
            }
        });
    });
}

//operationSiteDetail : 월사용료 수정 부분처리
function monthAccountTableUpdateJs(idx) {
    //수정버튼을 누르고 현재 데이터를 가져온다.
    let siteNo = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("siteNo"); //현장번호
    let siteMonthAccountNo = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("siteMonthAccountNo"); //월사용료 상세번호
    let systemAccount = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("systemAccount"); //시스템사용료
    let deviceAccount = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("deviceAccount"); //단말기사용료
    let internetAccount = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("internetAccount"); //무선인터넷사용료
    let taxAccountDt = $(".goUpdateMonthAccount:eq(" + idx + ")").attr("taxAccountDt"); //세금계산서발행일
    //html을 입력이 가능하게 바꿔주고, 데이터를 뿌려줌.
    let addHtml2 = "";
    addHtml2 += "<td><input type='text' value='" + systemAccount + "' name='systemAccount" + idx + "'/></td>"
        + "<td><input type='text' value='" + deviceAccount + "' name='deviceAccount" + idx + "'/></td>"
        + "<td><input type='text' value='" + internetAccount + "' name='internetAccount" + idx + "'/></td>"
        + "<td><input type='text' value='" + taxAccountDt + "' name='taxAccountDt" + idx + "'/></td>"
        + "<td class='labelBtn'>"
        + "<label><input type='button' value='취소' onclick='location.reload();'/></label>"
        + "<label><input type='button' value='저장' id='goUpdateMonthAccount" + idx + "'/></label>"
        + "</td>";

    $(".listTrMonthAccount:eq(" + idx + ")").find('td').hide();
    $(".listTrMonthAccount:eq(" + idx + ")").append(addHtml2);

    /*$("#registMonthAccount").on("click", function () {
        $("#thead tr:eq(1)").empty();
        alert("수정 중에 담당자추가를 할 수 없습니다.");
        location.reload();
    });*/
    //수정처리를 저장하면, 실행
    $("#goUpdateMonthAccount" + idx + "").on("click", function () {
        let systemAccount = $("input[name='systemAccount" + idx + "']").val();
        let deviceAccount = $("input[name='deviceAccount" + idx + "']").val();
        let internetAccount = $("input[name='internetAccount" + idx + "']").val();
        let taxAccountDt = $("input[name='taxAccountDt" + idx + "']").val();

        $.ajax({
            url     : "/siteMonthAccountModify",
            type    : "post",
            data    : {
                siteNo              : siteNo
                , siteMonthAccountNo: siteMonthAccountNo
                , systemAccount     : systemAccount
                , deviceAccount     : deviceAccount
                , internetAccount   : internetAccount
                , taxAccountDt      : taxAccountDt
            },
            success : function (data) {
                $(".listTrMonthAccount:eq(" + idx + ")").load(location.href + " .listTrMonthAccount:eq(" + idx + ") td");
            }, error: function () {
                alert("error");
            }

        });
    });
}

