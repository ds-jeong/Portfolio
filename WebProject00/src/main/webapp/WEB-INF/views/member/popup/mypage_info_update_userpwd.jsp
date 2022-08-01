<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@charset "UTF-8";
body {
	margin: 0 auto;
	text-align: center;
	font-family: MalgunGothic, sans-serif;
	
}

h3 {
	padding: 20px 0;
}

table {
	margin: 0 auto;
	width: 80%;
	border: 1px solid #ffffff;
	border-collapse: collapse;
}

table th, table td {
	border: 1px solid;
	padding: 5px 10px;
}

table a:hover {
	cursor: pointer;
	font-weight: bold;
}

a:hover {
	cursor: pointer;
}

.btn-fill, .btn-empty{
	text-align: center;
	padding: 3px 5px;
	border: 1px solid #000000;
	border-radius: 1px;
	background-color: #ffffff;
	
}

.btn-fill{	
	color: #000000;	
	padding: 8px;
	font-size: 13px;
	font-weight: bold;
}

.btn-empty{
	color: #000000;	
	padding: 8px;
	font-size: 13px;
	font-weight: bold;
}

.btn-fill-s, btn-empty-s{
	text-align: center;
	padding: 2px 6px;
	border: 1px solid #000000;
	border-radius: 5px;
	
	
}
.btn-fill-s{
	background-color: #207ea9;
	color: #fff;
	font-size: 13px;
	
}

.btn-empty-s{
	background-color: #fff;
	color: #78aeff;
}



.left { text-align: left; }
.center { text-align: center; }
.right { text-align: right; }

input[type=text], input[type=password] {
	height: 22px;
	padding-left: 5px;
	padding-right: 5px;
}

.btn-img {
	width: 22px;
	vertical-align: middle;
	cursor: pointer;
}

#list-top {
	padding-left: 10%;
	padding-bottom: 30px;
}

#list-top select[name=search] {
	height: 28px;
	width: 82px;
}

#list-top input[name=keyword] {
	width: 300px;
	vertical-align: top;
}

.valid, .invalid {
	font-size: 13px;
	font-weight: bold;
}

.valid {
	color: #000000;
}

.invalid {
	color: red
}
</style>

<script type="text/javascript">
function validate(tag){
	var value = $('[name=' + tag + ']').val();
	if( tag == 'userpwd'){
		value = validator.userpwd_status(value);
	}else if( tag=='userpwd_ck'){
		value = validator.userpwd_ck_status(
					value, $('[name=userpwd]').val());
	}
	if(value){
		$('#' + tag + '_status' ).text( value.desc );
		$('#' + tag + '_status' )
			.removeClass('valid').removeClass('invalid');
		$('#' + tag + '_status' )
			.addClass( value.code=='valid'? 'valid': 'invalid');
	}
	
	return value;
}
</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="js/join_validator.js?v=<%=new java.util.Date().getTime()%>"></script>
</head>
<body>
	<h4></h4><br>
<form method="post" action="userpwd_update">

<input type="hidden" value="${login_info.userid}" name="userid">
<input type="hidden" value="${login_info.userpwd}" name="userpwd1">
<table>
<tr><th style="font-size: 20px;">비밀번호</th>
	<td><input onkeyup="validate('userpwd')" type="password" name="userpwd" /><br>
		<div style="font-size: 13px;" class="valid" id="userpwd_status">비밀번호를 입력하세요<br>(영문 대/소문자, 숫자 , 6글자이상)</div>
	</td>
</tr>
<tr><th style="font-size: 20px;">비밀번호확인</th>
	<td><input onkeyup="validate('userpwd_ck')" type="password" name="userpwd_ck" /><br>
		<div style="font-size: 13px;" class="valid" id="userpwd_ck_status">비밀번호를 다시 입력하세요</div>
	</td>
</tr>
</table><br>
<a class="btn-fill" onclick="go_submit();">저장</a>
<a class="btn-empty" 
	onclick='self.close()'>취소</a>
</form>
<script type="text/javascript">

function go_submit() {

	if( !item('userpwd') ){
		return;
	}
	else if( !item('userpwd_ck') ) {
		return;
	}
	$('form').submit();
	
	opener.location.reload();
	window.close();
}

function item(tag){
	var data = validate(tag);
	if( data.code != 'valid' ){
		alert(data.desc);
		$('[name='+ tag +']').focus();
		return false;
	}else{	return true;
	}
	
}


</script>
</body>
</html>