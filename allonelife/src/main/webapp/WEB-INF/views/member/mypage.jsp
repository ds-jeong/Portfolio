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
<style>
body{
background-color: #ffffff;

}

table{
		width:60%;
		border: 1px solid #ffffff;
		border-radius: 1px;
		background-color: #ffffff;
		border-collapse: collapse;
		margin: 0 auto;		
		
}

table td:hover{
cursor: pointer;
}
	
table td{
	width: 300px;
	height: 400px;	
	/* font-family: 'Gothic A1', sans-serif; */
	font-family: 'Sunflower', sans-serif;
	font-size: 40px;
	color: #000000;
	border-bottom: 1px solid #ffffff;
	background-color: #ffffff;
	
	}

table th{ 
	border: 1px solid #000000;
	background-color: #ffffff;
	font-size: 30px;
	color: #000000;
}


#mypage {
	width: 1000px;
	height: 50px;
	margin-top: 150px;
	margin-left: 450px;
	border-radius: 10px 10px 10px 10px;
	color:#FFFFFF;
	background-color:#002e5d;
	padding:5px;
	padding-top: 13px;
	font-weight: bold;
	font-size: xx-large;
	text-align: center;  
}


</style>

</head>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Gothic+A1&display=swap" rel="stylesheet">
<body>

<br><br>
<img src="img/mypage.png">
<br>

<table style="margin-top: 70px;">
	<tr>
	
	<td onclick="location='mypage_info'"><img src="img/22.PNG"/><br>내 정보 수정</td>
	<td  onclick="location='mypage_write'"><img src="img/44.PNG"/><br>내가 쓴 글</td>
	</tr>
	<tr>
	
	
	<td onclick="location='mypage_point'"><img src="img/11.PNG"/><br>얼 상세조회</td>
	<td onclick="location='mypage_delete'"><img src="img/33.PNG"/><br>회원 탈퇴</td>
	</tr>

</table>




</body><br>
</html>