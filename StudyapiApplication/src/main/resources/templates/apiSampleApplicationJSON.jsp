<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<script language="javascript">

		function enterSearch() {
			if(window.event.keyCode ==13){
				alert("함수실행");
				getAddr();
			}
		}
		function getAddr(){
			// 적용예 (api 호출 전에 검색어 체크)
			if (!checkSearchedWord(document.form.keyword)) {
				return ;
			}
			$.ajax({
				url :"https://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"  //인터넷망
				,type:"post"
				,data:$("#form").serialize()
				,dataType:"jsonp"
				,crossDomain:true
				,success:function(jsonStr){
					console.log(jsonStr); //API의 데이터 객체출력.
					$("#list").html("");
					var errCode = jsonStr.results.common.errorCode;
					var errDesc = jsonStr.results.common.errorMessage;
					if(errCode != "0"){
						alert(errCode+"="+errDesc);
					}else{
						if(jsonStr != null){
							makeListJson(jsonStr);
						}
					}
				}
				,error: function(xhr,status, error){
					alert("에러발생");
				}
			});
		}

		function makeListJson(jsonStr){
			let htmlStr = "";
			htmlStr += "<table border='1' bordercolor='black' width='90%' style='margin: 0 auto; border-collapse:collapse; table-layout: fixed' >";
			htmlStr += "<tr>"
			htmlStr += "<th>시도명</th>"
			htmlStr += "<th>시군구명</th>"
			htmlStr += "<th>읍면동명</th>"
			htmlStr += "<th>법정리명</th>"
			htmlStr += "<th>우편번호</th>"
			htmlStr += "<th>도로명주소</th>"
			htmlStr += "<th>지번주소</th>"
			htmlStr += "<th>도로명주소_영문</th>"
			htmlStr += "<th>상세건물명</th>"
			htmlStr += "</tr>";
			$(jsonStr.results.juso).each(function(){
				htmlStr += "<tr>";
				htmlStr += "<td>"+this.siNm+"</td>";
				htmlStr += "<td>"+this.sggNm+"</td>";
				htmlStr += "<td>"+this.emdNm+"</td>";
				htmlStr += "<td>"+this.liNm+"</td>";
				htmlStr += "<td>"+this.zipNo+"</td>";
				htmlStr += "<td>"+this.roadAddr+"</td>";
				htmlStr += "<td>"+this.jibunAddr+"</td>";
				htmlStr += "<td>"+this.engAddr+"</td>";
				htmlStr += "<td>"+this.bdNm+"<br>"+this.detBdNmList+"</td>";
				htmlStr += "</tr>";
			});
			htmlStr += "</table>";

			let totalCount = "";
			let currentPage = "";
			let pageCnt = "";
			let dataPerPage = "";

			$(jsonStr.results.common).each(function(){
				totalCount = this.totalCount; //총 검색 데이터수
				currentPage = this.currentPage; // 현재 페이지번호
				dataPerPage = 10;//페이지당 출력할 결과 Row수
				pageCnt = 10; // 페이징에 나타날 페이지 수
			});

			//페이징 표시 호출
			paging(totalCount, dataPerPage, pageCnt, currentPage);

			$("#list").html(htmlStr);

		}
		function paging(totalCount, dataPerPage, pageCnt, currentPage) {
			let totalPage = Math.ceil(totalCount / dataPerPage); //총 페이지 수
			if(totalPage<pageCnt){
				 pageCnt=totalPage;
			}

			let pageGroup = Math.ceil(currentPage / pageCnt); // 페이지 그룹
			let last = pageGroup * pageCnt; //화면에 보여질 마지막 페이지 번호
			if (last > totalPage) {
				last = totalPage;
			}

			let first = last - (pageCnt - 1); //화면에 보여질 첫번째 페이지 번호
			let next = last + 1;
			let prev = first - 1;

			let pageHtml = "";

			if (prev > 0) {
				pageHtml += "<li><a href='#' id='prev'> 이전 </a></li>";
			}

			//페이징 번호 표시
			for (let i = first; i <= last; i++) {
				if (currentPage == i) {
					pageHtml +=
							"<li class='on'><a href='#'  value='"+i+"' id='" + i + "'>" + i + "</a></li>";
				} else {
					pageHtml += "<li><a href='#' value='"+i+"'id='" + i + "'>" + i + "</a></li>";
				}
			}
			if (last < totalPage) {
				pageHtml += "<li><a href='#' id='next'> 다음 </a></li>";
			}

			$("#pagingul").html(pageHtml);

			//페이징 번호 클릭 이벤트
			$("#pagingul li a").click(function () {
				let $id = $(this).attr("id");
				let selectedPage = $(this).text();

				if ($id == "next") selectedPage = next;
				if ($id == "prev") selectedPage = prev;

				//전역변수에 선택한 페이지 번호를 담는다...
				currentPage = selectedPage;
				//페이징 표시 재호출
				paging(totalCount, dataPerPage, pageCnt, selectedPage);
				$("input[name='currentPage']").attr("value", currentPage);
				getAddr();
			});

		}
		//특수문자, 특정문자열(sql예약어의 앞뒤공백포함) 제거
		function checkSearchedWord(obj){
			if(obj.value.length >0){
				//특수문자 제거
				var expText = /[%=><]/ ;
				if(expText.test(obj.value) == true){
					alert("특수문자를 입력 할수 없습니다.") ;
					obj.value = obj.value.split(expText).join("");
					return false;
				}

				//특정문자열(sql예약어의 앞뒤공백포함) 제거
				var sqlArray = new Array(
						//sql 예약어
						"OR", "SELECT", "INSERT", "DELETE", "UPDATE", "CREATE", "DROP", "EXEC",
						"UNION",  "FETCH", "DECLARE", "TRUNCATE"
				);

				var regex;
				for(var i=0; i<sqlArray.length; i++){
					regex = new RegExp( sqlArray[i] ,"gi") ;

					if (regex.test(obj.value) ) {
						alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
						obj.value =obj.value.replace(regex, "");
						return false;
					}
				}
			}
			return true ;
		}

	</script>
	<style type="text/css">
		body {
			margin: 0 auto;
			text-align: center;
			padding-top: 100px;
		}
		ul {
			text-align: center;
			display: inline-block;
			border: 1px solid #ccc;
			border-right: 0;
			list-style:none;
		}

		ul li {
			text-align: center;
			float: left;

		}

		ul li a {
			display: block;
			font-size: 14px;
			padding: 9px 12px;
			border-right: solid 1px #ccc;
			box-sizing: border-box;
			color: black;
			text-decoration: none;
		}

		.on {
			background: black;
		}

		ul li.on a {
			color: #fff;
		}

		
	</style>
	<title>Insert title here</title>
</head>
<body>
<form name="form" id="form" method="post">
	<input type="hidden" name="currentPage" value="1"/> <!-- 요청 변수 설정 (현재 페이지. currentPage : n > 0) -->
	<input type="hidden" name="countPerPage" value="10"/><!-- 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100) -->
	<input type="hidden" name="resultType" value="json"/> <!-- 요청 변수 설정 (검색결과형식 설정, json) -->
	<input type="hidden" name="firstSort" value="location"/> <!-- 요청 변수 설정 (검색결과형식 설정, json) -->
	<input type="hidden" name="confmKey" value=""/><!-- 요청 변수 설정 (승인키) -->
	<input type="text" name="keyword" value="" onkeypress="if(event.keyCode ==13){getAddr();}"/><!-- 요청 변수 설정 (키워드) -->
	<input type="button" onClick="getAddr();" value="주소검색하기"/>
	<div id="list" style="margin-top: 100px;"></div><!-- 검색 결과 리스트 출력 영역 -->
	<div>
		<ul id="pagingul" ></ul>
	</div><!-- 페이징 출력 영역 -->
</form>
</body>
</html>
