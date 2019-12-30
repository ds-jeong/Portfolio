<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
table td{
	padding: 20px;
	color: #000000;
}
table th{
	padding: 20px;
	color: #000000;
}
body{
background-color: #d3ddde;
font-size: 15px;
}
.f{
	font-size: 30px;
	
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
	<img src="img/modify.png"/><br>
	<hr>
<br>

	<c:forEach items="${list}" var="vo">
	<table style="width: 50%;" >
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
function showPopup() { window.open("http://localhost/allonelife/update_nickname", "a", "width=400, height=200, left=100, top=50, location=no,status=no, toolbar=no,scrollbars=no");}
function showPopups() { window.open("http://localhost/allonelife/update_userpwd", "a", "width=500, height=250, left=100, top=50"); }
</script>
</html>