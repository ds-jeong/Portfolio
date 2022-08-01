<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.f{
	font-size: 30px;
	
}
table{width: 40%;
	background-color: black;
	color: white;}
table tr, table td{
border: 2px solid silver;
padding-bottom: 10px;
}

#my {
	width: 1000px;
	height: 50px;
	margin-top: 100px;
	margin-left: 450px;
	border-radius: 10px 10px 10px 10px;
}

.invisible{
	clear:none;
	border: 0px none;
	float: none;
	background-color: #ffffff;
    font-size: 30px;
}

</style>
<script src="js/join_validator.js?v=<%=new java.util.Date().getTime()%>"></script>
</head>
<body>
	<h1>내 정보수정 페이지입니다 :D</h1>


	<c:forEach items="${list}" var="vo">
	<table >
		<tr>
			<td><STRONG>아이디</STRONG></td>

			<td>${login_info.userid}</td>
		</tr>
		<tr>
			<td><strong>이름</strong></td>
			<td>${login_info.name}</td>
		</tr>
		<tr>
			<td><strong>이메일</strong></td>
			<td>${login_info.email}</td>
		</tr>
		<tr>
			<td><strong>닉네임</strong></td>
			<td>${vo.nickname}<img style="margin-left: 5px;  float: right;" width="20px" height="20px" src="img/70390.png" onclick="showPopup(); "></td>
		</tr>
		<tr>
			<td><strong>비밀번호</strong></td>
			<td><input id="userpwd" type="password" value="${vo.userpwd}" class="invisible" readonly/><img style="margin-left: 5px; float: right;" width="20px" height="20px" src="img/70390.png" onclick="showPopups();"></td>
		</tr>
	
	</table>
	</c:forEach>
</body>
<script type="text/javascript">
function showPopup() { window.open("http://localhost:8080/web/update_nickname", "a", "width=400, height=200, left=100, top=50, location=no,status=no, toolbar=no,scrollbars=no");}
function showPopups() { window.open("http://localhost:8080/web/update_userpwd", "a", "width=500, height=250, left=100, top=50"); }
</script>
</html>