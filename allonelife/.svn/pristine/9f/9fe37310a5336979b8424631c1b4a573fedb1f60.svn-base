<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
label a:hover {te
	
}

label {
	cursor: pointer;
}
</style>
<body>
	<form id="list" method="post">
		<input type="hidden" name="curPage" value="1" />
		<p id="list-top" style="width: 70%"></p>
		<input type="hidden" name="id" />
	</form>
	<form id="item" method="post" action="send_item">
		<table>

			<tr>
				<th>닉네임</th>
				<th>이메일</th>
				<th>신청상품</th>
				<th>신청일자</th>
			</tr>
			<c:forEach items="${page.list}" var="vo">
				<tr>
					<td width="250px">${vo.nickname }</td>
					<td width="450px"><label
						onclick="if( confirm('${vo.email}로 상품을보낼까요?') ) {go_email(${vo.id })}"><a>${vo.email }</a>
							<img width="25px" height="25px" src="img/send.png"></label></td>
					<td width="350px"><c:set var="item" value="${vo.itemid}" /> 
					<c:if test="${item eq'1'}">상품구매(문화상품권)</c:if> 
					<c:if test="${item eq'2'}">상품구매(요기요 할인쿠폰)</c:if> 
					<c:if test="${item eq'3'}">상품구매(CGV 할인쿠폰)</c:if> 
					<c:if test="${item eq'7'}">상품구매(스타벅스 아메리카노)</c:if> 
					<c:if test="${item eq'8'}">상품구매(베스킨라빈스 파인트)</c:if> 
					<c:if test="${item eq'9'}">상품구매(CU 모바일 상품권)</c:if> 
							<input type="hidden" value="${vo.name }" name="name"> 
							<input type="hidden"value="${vo.email }" name="email"> 
							<input type="hidden"value="${vo.id }" name="id"> 
							<input type="hidden"value="${vo.userid }" name="userid"> 
						<input type="hidden"value="${vo.pointh }" name="pointh">
						<input type="hidden" value="${ vo.no}" name="no">
						<input type="hidden" value="${ vo.itemid}" name="itemid">
					<td width="250px">${vo.pdate }
				</tr>
			</c:forEach>
		</table>
		<br>
	</form>
<%-- 	<jsp:include page="/WEB-INF/views/include/page.jsp" /> --%>
	<script type="text/javascript">
		/* function go_detail(id){
		 $('[name=id]').val(id);
		 $('#list').attr('action', 'detail.fb');
		 $('#list').submit();
		 } */
		function go_email(id) {
				$('[name=id]').val(id);	
				$('[name=read]').val(true);
			$('#item').submit();
		}
	</script>
</body>
</html>