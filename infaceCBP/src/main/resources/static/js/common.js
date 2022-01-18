/**
 * 팝업 닫기
 */
function fnWindowPopupClose(){
    self.close();
}

/**
 * 팝업 띄우기
 * 사용여부 ( yes 또는 no )
 * fullscreen : 팝업 전체화면 출력 여부 ( IE에서만 작동 )
 * toolbar : 상단 도구창 출력 여부 ( IE, FireFox 에서만 작동 )
 * location : 메뉴 아이콘 출력여부 ( Opera 에서만 작동 )
 * resizeable : 팝업창 리사이즈 가능여부 ( 크롬에서는 작동 안함)
 * scrollbars : 팝업 스크롤바 사용 여부
 * menubar : 메뉴 출력 여부
 * 사이즈 정의( 픽셀 px )
 * width : 팝업창의 가로 길이
 * height : 팝업창의 세로 길이
 * top : 창의 화면 위에서부터의 팝업 위치 지정
 * left : 창의 화면 왼쪽에서부터의 팝업 위치 지정
 * @param url
 * @param popupName
 * @param width
 * @param height
 */
function fnWindowPopupOpen(url, popupName, width, height, scrollbars){
    if (!scrollbars){ scrollbars ="no"}
    window.open(url, popupName, "width="+width+", height="+height+", scrollbars="+scrollbars+", resizable=no")
}

// Date 개체를 입력받아 yyyyMMdd 형식으로 반환
//    dateFormat() : 현재시간을 yyyyMMdd 형식으로 출력
//    dateFormat(null, "/", false, -30) : 30일 이전 날짜를 yyyy/MM/dd 형식으로 출력.
//
// dt       : date 객체, dt 가 null 이면 현재 시간.
// delim    : 구분자사용, 지정하지 않으면 yyyyMMdd 형식
// withTime : true 로 지정하면 hh:mm:ss 시간 포함.
// gapDay   : 지정한 날짜만큼 조정된 시간을 사용. ex) 2일 이후 : 2, 12시간 이후 : 0.5
function dateFormat(dt, delim, withTime, gapDay) {
    var dt = dt ? new Date(dt) : new Date();
    dt = gapDay ? new Date(Date.parse(dt) + gapDay * 60 * 60 * 24 * 1000) : dt;
    var delim = delim ? delim : "";

    var yyyy = dt.getFullYear();
    var MM = dt.getMonth()+1;
    var dd = dt.getDate();
    var hh = dt.getHours();
    var mm = dt.getMinutes();
    var ss = dt.getSeconds();

    var ret = yyyy + delim + (MM<10?"0":"") + MM + delim + (dd<10?"0":"") + dd;
    if ( withTime ) {
        ret += " " + (hh<10?"0":"") + hh + ":" + (mm<10?"0":"") + mm + ":" + (ss<10?"0":"") + ss;
    }
    return ret;
}


/////////////// form validate function //////////////////
// 항목이 비어있는지 체크
function isObjEmpty(domObj, errMsg) {
    domObj.value = jQuery.trim(domObj.value);
    if ( domObj.value == "" ) {
         alert(errMsg);
         domObj.focus();
         return false;
     }
    return true;
}

// 항목의 최소,최대값 체크
function isObjNumericMinMax(domObj, minVal, maxVal, errMsg) {
    domObj.value = jQuery.trim(domObj.value);
    if ( domObj.value == "" || !jQuery.isNumeric(domObj.value)
            || ( minVal && parseInt(domObj.value)<minVal )
            || ( maxVal && parseInt(domObj.value)>maxVal ) ) {
         alert(errMsg);
         domObj.focus();
         return false;
     }
    return true;
}
// 입력하면, 자동으로 콤마추가 (가격 input)
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}

//입력받은 value를 0 ~ 9 값이 아니면 return false;
//연락처유효성검사
function checkNumber(event) {
    if(event.key >= 0 && event.key <= 9
        || event.keyCode == 8 //backspace
        || event.keyCode == 37 || event.keyCode == 39 || event.keyCode == 39//방향키 →, ←
        || event.keyCode == 46 //delete키
        || event.keyCode == 16 || event.keyCode == 17 || event.keyCode == 9) {
        return true;
    }else {
        alert("숫자만 입력하세요");
        $(this).value = "";
        return false;
    }
}
//이메일유효성검사
function checkEmail(email){
    let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    if(exptext.test(email)==true){
        return true;
    }else{
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
        alert("이메일형식이 올바르지 않습니다.");
        $(this).value = "";
        return false;
    }
}
//input value가 금액일때, 호출
function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}
function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}
function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}




