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
table td { text-align: left }
{
	width:50px; text-align: center;
}
table{
	margin-top: 50px;

}
	table tr td:nth-child(2) {
	text-align: left;
}
table{
	margin-top: 100px;
	
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
	margin-left: 450px;
	border-radius: 10px 10px 10px 10px;
}
</style>
<style type="text/css">
.valid, .invalid { font-size: 13px; font-weight: bold; }
.valid { color: blue }
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

<br><br>
	<div id="my"
style="color:#FFFFFF; background-color:#002e5d; padding:5px; padding-bottom:5px; font-weight: bold; font-size: xx-large;">
	회원가입
</div>
<form method="post" action="join">
<input type="hidden" id="id_usable" value="n"/>
<input type="hidden" id="nick_usable" value="n"/>
<input type="hidden" id="mail_usable" value="n"/>
<table style="width:30%">
<tr><th style="width:150px">* 성명</th>
	<td><input type="text" name="name" /></td>
</tr>
<tr><th>* 아이디</th>
	<td><input onkeyup="$('#id_usable').val('n'); validate('userid')" type="text" name="userid" />
		<a id="btn-usable" onclick="usable()" class="btn-fill">중복확인</a><br>
		<div class="valid" id="userid_status">아이디를 입력하세요<br>(영문소문자,숫자만)</div>	
	</td>
</tr>
<tr><th>* 비밀번호</th>
	<td><input onkeyup="validate('userpwd')" type="password" name="userpwd" /><br>
		<div class="valid" id="userpwd_status">비밀번호를 입력하세요<br>(영문 대/소문자, 숫자 , 6글자이상)</div>
	</td>
</tr>
<tr><th>* 비밀번호확인</th>
	<td><input onkeyup="validate('userpwd_ck')" type="password" name="userpwd_ck" /><br>
		<div class="valid" id="userpwd_ck_status">비밀번호를 다시 입력하세요</div>
	</td>
</tr>
<tr><th>* 이메일</th>
	<td><input onkeyup="$('#mail_usable').val('n'); validate('email')" type="text" name="email" />
		<a id="btn-usabled" onclick="usabled()" class="btn-fill">중복확인</a><br>
		<div class="valid" id="email_status">이메일을 입력하세요</div>	
	</td>
</tr>
<tr><th>* 닉네임</th>
	<td><input onkeyup="$('#nick_usable').val('n'); validate('nickname')" type="text" name="nickname" />
		<a id="btn-usables" onclick="usables()" class="btn-fill">중복확인</a><br>
		<div class="valid" id="nickname_status">닉네임을 입력하세요</div>	
	</td>
</tr>
</table><br>
<a class="btn-fill" onclick="go_submit()">회원가입</a>
<a class="btn-empty" 
	onclick='location="<c:url value='/'/>"'>취소</a>
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