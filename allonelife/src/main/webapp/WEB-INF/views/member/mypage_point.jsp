<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%>      
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	margin-top: 100px;
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
#my {
	width: 1000px;
	height: 50px;
	margin-top: 100px;
	margin-left: 550px;
	border-radius: 10px 10px 10px 10px;
}

</style>
</head>
<body>

	<img src="img/point.png"/><br>
	<hr>
<br>


<form id="list" method="post">
<input type="hidden" name="curPage" value="1" />
</form>

<table>
<tr>
	<th>내역</th>
	<th>날짜</th>
	<th>얼 적립/사용</th>
	<th>총 얼</th>
</tr>

<c:forEach items="${page.list}" var="vo">
<tr>
	<td><c:set var="name" value="${vo.how}"/>
	<c:set var="item" value="${vo.itemid}"/>
	<c:if test="${name eq '1' && item eq'1'}">상품구매(문화상품권)</c:if>
	<c:if test="${name eq '1' && item eq'2'}">상품구매(요기요 할인쿠폰)</c:if>
	<c:if test="${name eq '1' && item eq'3'}">상품구매(CGV 할인쿠폰)</c:if>
	<c:if test="${name eq '2' && item eq'4'}">레시피 게시글 작성</c:if>
	<c:if test="${name eq '2' && item eq'5'}">물물교환 게시글 작성</c:if>
	<c:if test="${name eq '2' && item eq'6'}">팁 게시글 작성</c:if>
	<c:if test="${name eq '3'}">회원가입 축하 기념 얼 지급</c:if>
	<c:if test="${name eq '4' && item eq'4'}">레시피 게시글 삭제</c:if>
	<c:if test="${name eq '4' && item eq'5'}">물물교환 게시글 삭제</c:if>
	<c:if test="${name eq '4' && item eq'6'}">팁 게시글 삭제</c:if>
	<c:if test="${name eq '1' && item eq'7'}">상품구매(스타벅스 아이스 아메리카노 Tall)</c:if>
	<c:if test="${name eq '1' && item eq'8'}">상품구매(베스킨라빈스 파인트 아이스크림)</c:if>
	<c:if test="${name eq '1' && item eq'9'}">상품구매(CU 모바일 상품권)</c:if>
	</td>
	<td>${vo.pdate}</td>
	<td><fmt:formatNumber value="${vo.pointh}" groupingUsed="true"/></td>
	<td><fmt:formatNumber value="${vo.point}" groupingUsed="true"/></td>

</tr>
</c:forEach>

</table><br>
<jsp:include page="/WEB-INF/views/include/page.jsp" />
</body>
</html>