<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap -->


<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> -->
<!-- 로그인쪽 문제 -->
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic:700|Noto+Sans+KR&display=swap"
	rel="stylesheet">
<!-- <script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->


<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>

</head>
<body>


	<img src="img/notice.png" />
	<br>
	<form id="list" method="post">
		<input type="hidden" name="curPage" value="1" /> <input type="hidden"
			name="id" />
		<p id="list-top">
			<span style="float: left;"> <select name="search">
					<option ${page.search eq 'all' ? 'selected': '' } value="all">전체</option>
					<option ${page.search eq 'title' ? 'selected': '' } value="title">제목</option>
					<option ${page.search eq 'content' ? 'selected': '' }value="content">내용</option>
					<option ${page.search eq 'writer' ? 'selected': '' } value="writer">작성자</option>
			</select> <input type="text" name="keyword" value="${page.keyword}"
				style="width: 350px; vertical-align: top;" /> <a
				onclick="$('form').submit()" class="btn-fill">검색</a>
			</span>
			<!-- 관리자로 로그인한 경우 글쓰기 가능 -->
			<c:if test="${login_info.admin eq 'Y'}">
				<a onclick="location='new.no'" style="float: right;"
					class="btn-fill">글쓰기</a>
			</c:if>
		</p>
	</form>
	

<table>
<tr>
	<th style="width: 60px">번호</th>
	<th >제목</th>
	<th style="width: 100px">작성자</th>
	<th style="width: 150px">작성일자</th>
	<th style="width:80px;">조회수</th>
</tr>
<tr>
	<c:forEach items="${page.list}" var="vo">
					<tr class="line2">
						<td class="li_no">${vo.no}</td>
						<td style="text-align: left;" class="li_ti"><a onclick="go_detail(${vo.id})">${vo.title}</a></td>
						<td class="li_wr">${vo.writer}</td>
						<td class="li_wd">${vo.writedate}</td>
						<td class="li_rc">${vo.readcnt}</td>					
				</c:forEach>
</tr>
</table><br>






	<!--  pagination 부분 -->
	<%-- <nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
    <c:if test="${page.curBlock gt 1}">
      <a onclick="go_page(${page.beginPage-page.blockPage})" class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">«</span>
        <span class="sr-only">Previous</span>
        </c:if>
      </a>
    </li>
    <c:forEach var="no" begin="${page.beginPage}" end="${page.endPage }">
    <c:if test="${no eq page.curPage}">
    <li class="page-item active"><a class="page-link" href="#">${no}</a></li>
  	</c:if>
  	<c:if test="${no ne page.curPage}">
    <li class="page-item"><a onclick="go_page(${no})" class="page-link" href="#">${no}</a></li>
    </c:if>	
    <li class="page-item">
    
    </c:forEach>
    
    <c:if test="${page.curBlock lt page.totalBlock}">
      <a onclick="go_page(${page.endPage+1})" class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">»</span>
        <span class="sr-only">Next</span>
        </c:if>
      </a>
    </li>
  </ul>
</nav> --%>










	<%-- 	<table id="table">
		<tr class="header">
			<th class="no" style="width: 60px;">번호</th>
			<th class="title">제목</th>
			<th class="writer" style="width: 100px;">작성자</th>
			<th class="date" style="width: 100px;">작성일자</th>
			<th class="cnt" style="width: 80px;">조회수</th>
		</tr>

		<c:forEach items="${page.list}" var="vo">
			<tr>
				<td>${vo.no}</td>
				<td class="left"><a onclick="go_detail(${vo.id})">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.writedate}</td>
				<td>${vo.readcnt}</td>
			</tr>
		</c:forEach>

	</table>
	<br> --%>

	<script type="text/javascript">
function go_detail(id){
	$('[name=id]').val(id);
	$('#list').attr( 'action', 'detail.no');
	$('#list').submit();
}

function go_page(no){
	$('[name=curPage]').val(no);
	$('#list').submit();
}


</script><br><br>
<script>
   function random_imglink(){
   var myimages=new Array()

      /* 각각의 이미지 경로 지정 */
      myimages[1]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad18405cd5c.jpg";
      myimages[2]="http://pds18.egloos.com/pds/201910/21/81/c0128481_5dad86deeffa0.jpg";
      myimages[3]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad83b48de16.jpg";
      myimages[4]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad83bd741c0.jpg";
      myimages[5]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad8a0533179.jpg";
      myimages[6]="http://pds18.egloos.com/pds/201910/21/81/c0128481_5dad1787d4ea8.jpg";
      
      /* 각각의 이미지 링크 지정 */
      var imagelinks=new Array()
      imagelinks[1]="http://www.callofduty.com/ko/"
      imagelinks[2]="http://www.cgv.co.kr/"
      imagelinks[3]="http://pubg.game.daum.net/pubg/index.daum"
      imagelinks[4]="https://www.samsung.com/sec/"
      imagelinks[5]="http://www.lotteria.com/"
      imagelinks[6]="http://www.yogiyo.co.kr/mobile/#/"

   var ry=Math.floor(Math.random()*myimages.length)
   if (ry==0)
   ry=1

   document.write('<a href='+'"'+imagelinks[ry]+'"'+' target=_blank><img src="'+myimages[ry]+'" border=0></a>')
   }
   random_imglink()
</script><br><br>

<jsp:include page="/WEB-INF/views/include/page.jsp" />
</body>
</html>






