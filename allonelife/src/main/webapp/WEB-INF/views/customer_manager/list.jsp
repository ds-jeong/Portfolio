<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td:nth-child(2) {
	text-align: left;
}
table{
	
	border: 2px solid #000000;
	border-radius: 1px;
	
	
}
table td, table th{
	padding: 20px;
	color: #000000;
	border-bottom: 1px solid #cad3de;
	
}

body{
background-color: #d3ddde;
font-size: 15px;
}
h3{
	font-size: 25px;

}
</style>
</head>
<body>
	
<h3>고객관리</h3>
<form id="list" method="post" >
	<input type="hidden" name="curPage" value="1"/>
	<input type="hidden" name="id" />
	<input type="hidden" name="read" value="false"/>
<p id="list-top" style="width: 70%">
	<span style="float: left;">
		<select name="search">
			<option ${page.search eq 'all' ? 'selected': '' } value="all">전체</option>
			<option ${page.search eq 'nickname' ? 'selected': '' } value="nickname">닉네임</option>
			<option ${page.search eq 'email' ? 'selected': '' } value="email">이메일</option>
		</select>
		<input type="text" name="keyword" value="${page.keyword}"/>
		<a onclick="$('form').submit()" class="btn-fill">검색</a>
	</span>	
</p>
</form>
<table>

<tr>
	<th style="width: 60px">번호</th>
	<th style="width: 60px">닉네임</th>
	<th style="width: 100px">이메일</th>
</tr>
<c:forEach items="${page.list}" var="vo">
<tr>
	<td>${vo.no }</td>
	<td><a onclick="location='detail.cm?id=${vo.userid}'">${vo.nickname }</a></td>
	<td>${vo.email }</td>
</tr>
</c:forEach>
</table><br>
<script type="text/javascript">

</script>
<jsp:include page="/WEB-INF/views/include/page.jsp"/>
</body>
</html>