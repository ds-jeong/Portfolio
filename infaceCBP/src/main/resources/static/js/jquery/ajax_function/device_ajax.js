/*
* 한 화면에서 리스트와 등록 및 수정 처리를 구현하기 위해 function별로 나눠서 처리함. *
*/


//operationSiteDetail : 단말기 추가 부분 처리
function deviceTableInsertJs(idx) {
    //단말기 종류를 SELECT 하면 종류별 단말기가 조회된다
    $("#deviceKindNo" + idx + "").on("change", function () {
        let deviceKindNo = $("#deviceKindNo" + idx + "").val();
        let deviceDtNo = 0;
        $.ajax({
            url     : "/deviceList",
            type    : "post",
            data    : {deviceKindNo: deviceKindNo, deviceDtNo: deviceDtNo},
            success : function (data) {
                $("#deviceDtNo" + idx + " option").remove();
                $("#deviceDtNo" + idx + "").append("<option value='0' >S/N</option>");
                //js로 생성한 html에 단말기 리스트를 뿌려준다
                $.each(data, function (index, item) {
                    //console.log(item.deviceDtNo);
                    $("#deviceDtNo" + idx + "").append("<option value='" + item.deviceDtNo + "'>" + item.deviceSn + "</option>");
                });
            }, error: function () {
                alert("error");
            }
        });
    });

    //취소버튼 클릭시, 실행
    $("#goCancelDevice" + idx + "").on("click", function () {
        $(".listTrDeviceTop:eq(" + idx + ")").load(location.href + " .listTrDeviceTop:eq(" + idx + ")");
    });
    //저장버튼 클릭시, 실행
    $("#goRegistDevice" + idx + "").on("click", function () {
        if (!$("input[name='deviceHistoryState" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if (!$("select[name='deviceKindNo" + idx + "']").val()) {
            alert("단말기의 종류를 선택하세요.");
            return false;
        } else if (!$("select[name='deviceDtNo" + idx + "']").val()) {
            alert("S/N을 선택하세요.");
            return false;
        } else {
            let deviceHistoryState = $("input[name='deviceHistoryState" + idx + "']:checked").val();
            let deviceKindNo = $("select[name='deviceKindNo" + idx + "']").val();
            let deviceDtNo = $("select[name='deviceDtNo" + idx + "']").val();
            let deviceHistoryInstallationDate = $("input[name='deviceHistoryInstallationDate" + idx + "']").val();
            let deviceHistoryEndDate = $("input[name='deviceHistoryEndDate" + idx + "']").val();
            let deviceHistoryDeviceNm = $("input[name='deviceHistoryDeviceNm" + idx + "']").val();
            let siteNo = $("input[name='siteNo']").val();

            $.ajax({
                url     : "/siteDeviceRegist",
                type    : "post",
                data    : {
                    deviceHistoryState           : deviceHistoryState,
                    deviceKindNo                 : deviceKindNo,
                    deviceDtNo                   : deviceDtNo,
                    deviceHistoryInstallationDate: deviceHistoryInstallationDate,
                    deviceHistoryEndDate         : deviceHistoryEndDate,
                    deviceHistoryDeviceNm        : deviceHistoryDeviceNm,
                    siteNo                       : siteNo
                },
                success : function (data) {
                    $("#listTrDeviceTop" + idx + "").load(location.href + " #listTrDeviceTop" + idx + "");
                    $("#tableDevice tbody").load(location.href + " .listTrDevice");
                }, error: function () {
                    alert("error");
                }
            });
        }
    });
};

//operationSiteDetail : 단말기 수정 부분처리
function deviceTableUpdateJs(idx, beforeDeviceDtNo) {

    /*$("#registManager").on("click", function () {
        $("#thead tr:eq(1)").empty();
        alert("수정 중에 담당자추가를 할 수 없습니다.");
        location.reload();
    });*/

    //취소버튼을 클릭하면, 실행
    $("#goUpdateCancelDevice" + idx + "").on("click", function () {
        $(".listTrDevice:eq(" + idx + ")").load(location.href + " .listTrDevice:eq(" + idx + ") td");
    });
    //수정처리를 저장하면, 실행
    $("#goUpdateSubmitDevice" + idx + "").on("click", function () {
        if (!$("input[name='deviceHistoryStateUp" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if (!$("select[name='deviceKindNoUp" + idx + "']").val()) {
            alert("단말기의 종류를 선택하세요.");
            return false;
        } else if (!$("select[name='deviceDtNoUp" + idx + "']").val()) {
            alert("S/N을 선택하세요.");
            return false;
        } else {
            let deviceHistoryState = $("input[name='deviceHistoryStateUp" + idx + "']:checked").val();
            let deviceKindNo = $("select[name='deviceKindNoUp" + idx + "']").val();
            let deviceDtNo = $("select[name='deviceDtNoUp" + idx + "'] option:selected").val();
            let deviceHistoryInstallationDate = $("input[name='deviceHistoryInstallationDateUp" + idx + "']").val();
            let deviceHistoryEndDate = $("input[name='deviceHistoryEndDateUp" + idx + "']").val();
            let deviceHistoryDeviceNm = $("input[name='deviceHistoryDeviceNmUp" + idx + "']").val();
            let siteNo = $("input[name='siteNo']").val();
            let deviceHistoryDtNo = $(".goUpdateDevice:eq(" + idx + ")").attr("deviceHistoryDtNo"); //단말기이력상세번호

            $.ajax({
                url     : "/siteDeviceModify",
                type    : "post",
                data    : {
                    deviceHistoryState           : deviceHistoryState,
                    deviceKindNo                 : deviceKindNo,
                    deviceDtNo                   : deviceDtNo,
                    deviceHistoryInstallationDate: deviceHistoryInstallationDate,
                    deviceHistoryEndDate         : deviceHistoryEndDate,
                    deviceHistoryDeviceNm        : deviceHistoryDeviceNm,
                    siteNo                       : siteNo,
                    deviceHistoryDtNo            : deviceHistoryDtNo,
                    beforeDeviceDtNo             : beforeDeviceDtNo
                },
                success : function (data) {
                    $(".listTrDevice:eq(" + idx + ")").load(location.href + " .listTrDevice:eq(" + idx + ") td");
                    //$("#tableDevice tbody").load(location.href + " .listTrDevice");

                }, error: function () {
                    alert("error");
                }
            });

        }
    });
}
