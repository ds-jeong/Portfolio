/*
* 한 화면에서 리스트와 등록 및 수정 처리를 구현하기 위해 function별로 나눠서 처리함. *
*/


//operationSiteDetail : 단말기 추가 부분 처리
function wirelessEquipmentTableInsertJs(idx) {
    //단말기 종류를 SELECT 하면 종류별 단말기가 조회된다
    $("#wirelessEquipmentCarrierDtNo" + idx + "").on("change", function () {
        let wirelessEquipmentCarrierDtNo = $("#wirelessEquipmentCarrierDtNo" + idx + "").val();
        let wirelessEquipmentDtNo = 0;
        $.ajax({
            url     : "/wirelessEquipmentList",
            type    : "post",
            data    : {
                wirelessEquipmentCarrierDtNo: wirelessEquipmentCarrierDtNo,
                wirelessEquipmentDtNo       : wirelessEquipmentDtNo
            },
            success : function (data) {
                $("#wirelessEquipmentDtNo" + idx + " option").remove();
                $("#wirelessEquipmentDtNo" + idx + "").append("<option value='' >S/N</option>");
                //js로 생성한 html에 단말기 리스트를 뿌려준다
                $.each(data, function (index, item) {
                    //console.log(item);
                    $("#wirelessEquipmentDtNo" + idx + "").append("<option value='" + item.wirelessEquipmentDtNo + "'>" + item.wirelessEquipmentSn + "</option>");
                });
            }, error: function () {
                alert("error");
            }
        });
    });

    //취소버튼 클릭시, 실행
    $("#goCancelWirelessEquipment" + idx + "").on("click", function () {
        $(".listTrWirelessEquipmentTop:eq(" + idx + ")").load(location.href + " .listTrWirelessEquipmentTop:eq(" + idx + ")");
    });
    //저장버튼 클릭시, 실행
    $("#goRegistWirelessEquipment" + idx + "").on("click", function () {
        if (!$("input[name='wirelessEquipmentHistoryState" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if ($("select[name='wirelessEquipmentCarrierDtNo" + idx + "']").val() == "") {
            alert("무선단말기의 종류를 선택하세요.");
            return false;
        } else if ($("select[name='wirelessEquipmentDtNo" + idx + "']").val() == "") {
            alert("S/N을 선택하세요.");
            return false;
        } else {
            let wirelessEquipmentHistoryState = $("input[name='wirelessEquipmentHistoryState" + idx + "']:checked").val();
            let wirelessEquipmentCarrierDtNo = $("select[name='wirelessEquipmentCarrierDtNo" + idx + "']").val();
            let wirelessEquipmentDtNo = $("select[name='wirelessEquipmentDtNo" + idx + "']").val();
            let wirelessEquipmentHistoryInstallationDate = $("input[name='wirelessEquipmentHistoryInstallationDate" + idx + "']").val();
            let wirelessEquipmentHistoryEndDate = $("input[name='wirelessEquipmentHistoryEndDate" + idx + "']").val();
            let siteNo = $("input[name='siteNo']").val();

            $.ajax({
                url     : "/siteWirelessEquipmentRegist",
                type    : "post",
                data    : {
                    wirelessEquipmentHistoryState           : wirelessEquipmentHistoryState,
                    wirelessEquipmentCarrierDtNo            : wirelessEquipmentCarrierDtNo,
                    wirelessEquipmentDtNo                   : wirelessEquipmentDtNo,
                    wirelessEquipmentHistoryInstallationDate: wirelessEquipmentHistoryInstallationDate,
                    wirelessEquipmentHistoryEndDate         : wirelessEquipmentHistoryEndDate,
                    siteNo                                  : siteNo
                },
                success : function (data) {
                    $("#listTrWirelessEquipmentTop" + idx + "").load(location.href + " #listTrWirelessEquipmentTop" + idx + "");
                    $("#tableWirelessEquipment tbody").load(location.href + " .listTrWirelessEquipment");
                }, error: function () {
                    alert("error");
                }
            });
        }
    });
};

//operationSiteDetail : 단말기 수정 부분처리
function wirelessEquipmentTableUpdateJs(idx, beforeWirelessEquipmentDtNo) {

    /*$("#registManager").on("click", function () {
        $("#thead tr:eq(1)").empty();
        alert("수정 중에 담당자추가를 할 수 없습니다.");
        location.reload();
    });*/

    //취소버튼을 클릭하면, 실행
    $("#goUpdateCancelWirelessEquipment" + idx + "").on("click", function () {
        $(".listTrWirelessEquipment:eq(" + idx + ")").load(location.href + " .listTrWirelessEquipment:eq(" + idx + ") td");
    });
    //수정처리를 저장하면, 실행
    $("#goUpdateSubmitWirelessEquipment" + idx + "").on("click", function () {
        if (!$("input[name='wirelessEquipmentHistoryStateUp" + idx + "']:checked").val()) {
            alert("사용여부를 체크하여 주세요.");
            return false;
        } else if (!$("select[name='wirelessEquipmentCarrierDtNoUp" + idx + "']").val()) {
            alert("무선단말기의 통신사를 선택하세요.");
            return false;
        } else if (!$("select[name='wirelessEquipmentDtNoUp" + idx + "']").val()) {
            alert("S/N을 선택하세요.");
            return false;
        } else {
            let wirelessEquipmentHistoryState = $("input[name='wirelessEquipmentHistoryStateUp" + idx + "']:checked").val();
            let wirelessEquipmentCarrierDtNo = $("select[name='wirelessEquipmentCarrierDtNoUp" + idx + "']").val();
            let wirelessEquipmentDtNo = $("select[name='wirelessEquipmentDtNoUp" + idx + "'] option:selected").val();
            let wirelessEquipmentHistoryInstallationDate = $("input[name='wirelessEquipmentHistoryInstallationDateUp" + idx + "']").val();
            let wirelessEquipmentHistoryEndDate = $("input[name='wirelessEquipmentHistoryEndDateUp" + idx + "']").val();
            let siteNo = $("input[name='siteNo']").val();
            let wirelessEquipmentHistoryDtNo = $(".goUpdateWirelessEquipment:eq(" + idx + ")").attr("wirelessEquipmentHistoryDtNo"); //단말기이력상세번호
            $.ajax({
                url     : "/siteWirelessEquipmentModify",
                type    : "post",
                data    : {
                    wirelessEquipmentHistoryState           : wirelessEquipmentHistoryState,
                    wirelessEquipmentCarrierDtNo            : wirelessEquipmentCarrierDtNo,
                    wirelessEquipmentDtNo                   : wirelessEquipmentDtNo,
                    wirelessEquipmentHistoryInstallationDate: wirelessEquipmentHistoryInstallationDate,
                    wirelessEquipmentHistoryEndDate         : wirelessEquipmentHistoryEndDate,
                    siteNo                                  : siteNo,
                    wirelessEquipmentHistoryDtNo            : wirelessEquipmentHistoryDtNo,
                    beforeWirelessEquipmentDtNo             : beforeWirelessEquipmentDtNo,
                },
                success : function (data) {
                    $(".listTrWirelessEquipment:eq(" + idx + ")").load(location.href + " .listTrWirelessEquipment:eq(" + idx + ") td");
                    //$("#tableDevice tbody").load(location.href + " .listTrDevice");

                }, error: function () {
                    alert("error");
                }
            });

        }
    });
}
