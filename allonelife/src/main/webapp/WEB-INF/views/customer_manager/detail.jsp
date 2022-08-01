<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	margin-top: 70px;
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
.nick{
	font-size: 25px;

}
h3{
margin-top: 50px;

}
</style>
</head>
<body>
<h3> <a class="nick">${vo.nickname}</a> 님의 고객정보</h3>
<table style="width: 20%">
<tr><th style="width: 150px">유저아이디</th>
	<td>${vo.userid}</td>
</tr>
<tr><th>이름</th>
	<td>${vo.name}</td>
</tr>
<tr><th>이메일</th>
	<td>${vo.email}</td>
</tr>
<tr><th>얼</th>
	<td>${vo.point}</td>
</tr>

</table><br>
<a class="btn-fill" onclick="location='customer_manager'">고객목록</a>
<a class="btn-fill" onclick="if(confirm('[ ${vo.nickname} ]님을 정말 탈퇴시키겠습니까?')){location='delete.cm?id=${vo.userid}'}">탈퇴시키기</a>
</body>
</html>