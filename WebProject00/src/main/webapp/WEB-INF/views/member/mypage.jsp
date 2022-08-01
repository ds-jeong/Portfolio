<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" 
	src="js/join_validator.js?v=<%=new java.util.Date().getTime()%>"></script>
<style type="text/css">

table tr, table td{ border: 2px solid silver;
					}
table{ width: 60%;
		margin: 0 auto;
		background-color: #4d4d4d;
		color: white;
		font-size: 30px;
		 }
 table td{
 	width: 250px;
 	height: 500px;
 	cursor: pointer;
 }
 h1 {
 font-size: 21px;
 color: #ffffff;
}
</style>
</head>

<body>

<h1>마이페이지입니다 :D</h1>
<table style="margin-top: 70px;">
	<tr>	
	<td onclick="location='mypage_info'">내 정보 수정</td>		
	<td onclick="location='mypage_delete'">회원 탈퇴</td>			
	<td  onclick="location='mypage_write'">내가 쓴 글</td>		
	
	</tr>

</table>




</body><br>
</html>