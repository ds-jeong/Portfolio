<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allonelife</title>
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
	border: 2px solid #000000;
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
	function validate(tag) {
		var value = $('[name=' + tag + ']').val();
		if (tag == 'nickname') {
			value = validator.nickname_status(value);
		}
		if (value) {
			$('#' + tag + '_status').text(value.desc);
			$('#' + tag + '_status').removeClass('valid')
					.removeClass('invalid');
			$('#' + tag + '_status').addClass(
					value.code == 'valid' ? 'valid' : 'invalid');
		}

		return value;
	}
	function usables() {
		var data = validate('nickname');
		if (data.code != 'valid') { //중복확인 불필요
			alert(data.desc);
			return;
		}
		$.ajax({
			type : 'post',
			data : {
				nickname : $('[name=nickname]').val(),
				userid : $('[name=userid]').val()
			},
			url : 'nick_usable',
			success : function(data) {
				data = validator.nickname_usable(data);
				if (data) {
					$('#nick_usable').val(data.code);
					$('#nickname_status').text(data.desc);
					$('#nickname_status').removeClass('valid').removeClass(
							'invalid');
					$('#nickname_status').addClass(
							data.code == 'usable' ? 'valid' : 'invalid');
				}

			},
			error : function(req, text) {
				alert(text + ": " + req.status);
			}
		})
	}
</script>
<script src="js/join_validator.js?v=<%=new java.util.Date().getTime()%>"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<h4></h4><br>
<form method="post" action="nick_update">
<input type="hidden" id="nick_usable" value="n"/>

<input type="hidden" value="${login_info.userid}" name="userid">
<input type="hidden" value="${login_info.userpwd}" name="userpwd">
	<a style="font-size: 20px; font-weight: bold;">닉네임</a>  <input onkeyup="$('#nick_usable').val('n'); validate('nickname')"
		type="text" name="nickname" />
	<a id="btn-usables" onclick="usables()" class="btn-fill">중복확인</a>
	<br>
	<div style="font-size: 13px;" class="valid" id="nickname_status">닉네임을 입력하세요</div>
	<br>
<a class="btn-fill" onclick="go_submit();">저장</a>
<a class="btn-empty" 
	onclick='self.close()'>취소</a>
</form>
<script type="text/javascript">
function go_submit() {
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
	opener.location.reload();
	window.close();
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