<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {
 font-size: 21px;
 color: #ffffff;
}
table tr{
	border-bottom: 2px solid silver;
	background-color: white;
}
table tr:first-child {
	background-color: #4d4d4d;
	color: white;
}
</style>
</head>
<body>
<h1>게시판 페이지입니다. <br> 로그인 후 글쓰기도 가능하고 수정 및 삭제도 가능합니다 :D</h1>
<hr>
<form id="list" method="post">
<input type="hidden" name="curPage" value="1" />
<input type="hidden" name="no" />
<input type="hidden" name="read" value="false"/>
<p id="list-top">
	<span style="float: left;">
		<select name="search">
			<option ${page.search eq 'all' ? 'selected' : ''}  value="all">전체</option>
			<option ${page.search eq 'title' ? 'selected' : ''}  value="title" >제목</option>
			<option ${page.search eq 'category' ? 'selected' : ''}  value="category">카테고리</option>
			<option ${page.search eq 'content' ? 'selected' : ''} value="content">내용</option>
			<option ${page.search eq 'writer' ? 'selected' : ''} value="writer">작성자</option>
		</select>
		<input type="text" name="keyword" value="${page.keyword}"
			style="width:350px; vertical-align: top;"/>	
		<a onclick="$('form').submit()" class="btn-fill">검색</a>
	</span>
	<!-- 로그인한 경우 글쓰기 가능 -->
<c:if test="${ !empty login_info }"> 
		<a style="float: right;" class="btn-fill" onclick="location='new.kangwondo'">글쓰기</a>
</c:if>
</p>
</form>

<table>
<tr><th style="width:60px;">번호</th>
	<th style="width:60px;">지역</th>
	<th>제목</th>
	<th style="width:100px;">작성자</th>
	<th style="width:130px;">날짜</th>
	<th style="width:80px;">첨부파일</th>	
	<th style="width:80px;">조회수</th>
</tr>

<c:forEach items="${page.list}" var="vo">
<tr><td>${vo.no}</td>
	<td class="left">${vo.sido}</td>
	<td class="left"><a onclick="go_detail(${vo.no})"> ${vo.title}	 
	 </a></td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${empty vo.filename ? ""
		: "<img class='btn-img' src='img/attach.png'/>"}</td>
			<td>${vo.readcnt}</td>
</tr>
</c:forEach>

</table><br>


<script type="text/javascript">
function go_detail(no){
	$('[name=no]').val(no);	
	$('[name=read]').val(true);
	$('#list').attr( 'action', 'detail.kangwondo');
	$('#list').submit();
}

</script>
<br><br>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</body>
</html>