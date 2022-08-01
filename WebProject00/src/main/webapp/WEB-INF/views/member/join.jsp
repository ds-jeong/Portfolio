<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
border: 1px solid silver;
text-align: left;
font-size: 20px;
}
input, table td a, td .valid, td .invalid {
float: left;
text-align: left;
}
table td a{
	margin-left: 10px;

}
input[type=text], input[type=password]{
 width: 400px;
 height: 40px;
}
.btn-fills, .btn-emptys{
text-align: center;
font-size: 15px;
width: 80px;
height: 45px;
line-height: 45px;
background-color: black;
color: #ffffff;

}

input[name=name], input[name=userpwd], input[name=userpwd_ck]{
	 width: 500px;
 height: 40px;
}
h1 {
 font-size: 21px;
 color: #ffffff;
}
.btn {
	display: block;
	width: 400px;
	height: 60px;
	line-height: 60px;
	border: 1px #000000 solid;
	margin: 15px auto;
	background-color: #000000;
	text-align: center;
	cursor: pointer;
	color: #ffffff;
	transition: all 0.9s, color 0.3;
}

.btn:hover {
cursor:pointer;
	color: #ffd21c;
	background: #4d4d4d;
	border: 1px #4d4d4d solid;;
	font-weight: bold;
}
.btn:hover{ 
box-shadow: 0 80px 0 0 rgba(0,0,0,0.0) inset, 0 -80px 0 0 rgba(0,0,0,0.0) inset; 
}
</style>
<style>
.valid, .invalid { font-size: 13px; font-weight: bold; }
.valid { color: #696969; }
.invalid { color: red }
</style>
<script type="text/javascript">
function validate(tag){
	var value = $('[name=' + tag + ']').val();
	if( tag=='userid') {
		value = validator.userid_status(value);
	}else if( tag=='nickname') {
		value = validator.nickname_status(value);
	}else if( tag == 'userpwd'){
		value = validator.userpwd_status(value);
	}else if( tag=='userpwd_ck'){
		value = validator.userpwd_ck_status(
					value, $('[name=userpwd]').val());
	}else if( tag=='email' ){
		value = validator.email_status(value);
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
function usable(){
	var data = validate('userid');
	if( data.code != 'valid' ){ //중복확인 불필요
		alert( data.desc );
		return;
	}
	$.ajax({
		type: 'post',
		data: { userid: $('[name=userid]').val() },
		url: 'id_usable',
		success: function(data){
			data = validator.userid_usable(data);
			if( data ){
				$('#id_usable').val(data.code);
				$('#userid_status').text(data.desc);
				$('#userid_status').removeClass('valid')
								   .removeClass('invalid');
				$('#userid_status').addClass(
					data.code=='usable' ? 'valid' : 'invalid');
			}
			
		},error: function(req, text){
			alert(text+": " + req.status);
		}
	});
	
}
function usables(){
	var data = validate('nickname');
	if( data.code != 'valid' ){ //중복확인 불필요
		alert( data.desc );
		return;
	}
$.ajax({
	type: 'post',
	data: { nickname: $('[name=nickname]').val() },
	url: 'nick_usable',
	success: function(data){
		data = validator.nickname_usable(data);
		if( data ){
			$('#nick_usable').val(data.code);
			$('#nickname_status').text(data.desc);
			$('#nickname_status').removeClass('valid')
							   .removeClass('invalid');
			$('#nickname_status').addClass(
				data.code=='usable' ? 'valid' : 'invalid');
		}
		
	},error: function(req, text){
		alert(text+": " + req.status);
	}
})
}function usabled(){
	var data = validate('email');
	if( data.code != 'valid' ){ //중복확인 불필요
		alert( data.desc );
		return;
	}
$.ajax({
	type: 'post',
	data: { email: $('[name=email]').val() },
	url: 'mail_usable',
	success: function(data){
		data = validator.email_usable(data);
		if( data ){
			$('#mail_usable').val(data.code);
			$('#email_status').text(data.desc);
			$('#email_status').removeClass('valid')
							   .removeClass('invalid');
			$('#email_status').addClass(
				data.code=='usable' ? 'valid' : 'invalid');
		}
		
	},error: function(req, text){
		alert(text+": " + req.status);
	}
})
}
</script>
<script type="text/javascript" 
	src="js/join_validator.js?v=<%=new java.util.Date().getTime()%>"></script>
</head>
<body>
<h1>회원가입페이지입니다.<br>회원가입 후 게시판이용이 가능합니다 :D</h1>
<hr>
<form method="post" action="join">
<input type="hidden" id="id_usable" value="n"/>
<input type="hidden" id="nick_usable" value="n"/>
<input type="hidden" id="mail_usable" value="n"/>
<table style="width:40%">
<tr><th style="width:150px">성명</th>
</tr>
<tr>
	<td><input type="text" name="name" /></td>
</tr>
<tr><th>아이디</th>
</tr>
<tr>
	<td><input onkeyup="$('#id_usable').val('n'); validate('userid')" type="text" name="userid" />
		<a id="btn-usable" onclick="usable()" class="btn-fills">중복확인</a><br>
	</td>
</tr>
<tr>
		<td><div class="valid" id="userid_status">아이디를 입력하세요(영문소문자,숫자만)</div></td>	
</tr>
<tr><th>비밀번호</th>
</tr>
<tr>
	<td><input onkeyup="validate('userpwd')" type="password" name="userpwd" /><br>
	</td>
</tr>
<tr>
<td>

		<div class="valid" id="userpwd_status" >비밀번호를 입력하세요(영문 대/소문자, 숫자 , 6글자이상)</div>
</td>
</tr>
<tr><th>비밀번호확인</th>
</tr>
<tr>
	<td><input onkeyup="validate('userpwd_ck')" type="password" name="userpwd_ck" /><br>
	</td>
</tr>
<tr>
<td>
		<div style="text-align: left;" class="valid" id="userpwd_ck_status">비밀번호를 다시 입력하세요</div>
</td>
</tr>
<tr><th>이메일</th>
</tr>
<tr>
	<td><input onkeyup="$('#mail_usable').val('n'); validate('email')" type="text" name="email" />
		<a id="btn-usabled" onclick="usabled()" class="btn-fills">중복확인</a><br>
	</td>
</tr>
<tr>
<td>
		<div class="valid" id="email_status">이메일을 입력하세요</div>	
</td>
</tr>
<tr><th>닉네임</th>
</tr>
<tr>
	<td><input onkeyup="$('#nick_usable').val('n'); validate('nickname')" type="text" name="nickname" />
		<a id="btn-usables" onclick="usables()" class="btn-fills">중복확인</a><br>
	</td>
</tr>
<tr>
<td>
		<div class="valid" id="nickname_status">닉네임을 입력하세요</div>	
</td>
</tr>
</table><br>
<a style="float: center;" class="btn" onclick="go_submit()">회원가입</a>
</form>
  
<script type="text/javascript">
function go_submit(){
	if( $('[name=name]').val().trim()=='' ){
		alert('성명을 입력하세요');
		$('[name=name]').val('');
		$('[name=name]').focus();
		return;
	}	
	//중복확인 안한경우 유효한지 판단
	if( $('#id_usable').val()=='n' ){
		if( !item('userid') ) return;
		else{
		alert( validator.userid.valid.desc );
		//$('#btn-usable').focus();
			return;
		}
	//중복확인 한경우 이미 사용중인 경우만	
	}else if( $('#id_usable').val()=='unusable' ){
		alert(validator.userid.unusable.desc);
		$('[name=userid]').focus();
		return;
	}
	if( !item('userpwd') ) return;
	if( !item('userpwd_ck') ) return;
	
	if( $('#mail_usable').val()=='n' ){
		if( !item('email') ) return;
		else{
		alert( validator.email.valid.desc );
		//$('#btn-usables').focus();
			return;
		}
	//중복확인 한경우 이미 사용중인 경우만	
	}else if( $('#email_usable').val()=='unusable' ){
		alert(validator.email.unusable.desc);
		$('[name=email]').focus();
		return;
	}
	
	if( $('#nick_usable').val()=='n' ){
		if( !item('nickname') ) return;
		else{
		alert( validator.nickname.valid.desc );
		//$('#btn-usables').focus();
			return;
		}
	//중복확인 한경우 이미 사용중인 경우만	
	}else if( $('#nick_usable').val()=='unusable' ){
		alert(validator.nickname.unusable.desc);
		$('[name=nickname]').focus();
		return;
	}
	
	$('form').submit();
}
function item(tag){
	var data = validate(tag);
	if( data.code != 'valid' ){
		alert(data.desc);
		$('[name='+ tag +']').focus();
		return false;
	}else	return true;
}




</script>

</body>
</html>