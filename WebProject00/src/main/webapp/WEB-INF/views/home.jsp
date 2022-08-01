<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<style type="text/css">
body {
width: 100%;
	position: static;
}
            h1{
    font-weight: bold;
    text-transform: uppercase;
    text-align: center;
    color: #FFF;
}
.login-form{
    position: relative;
    top: 0px;
    left: 30%;
    width: 40%;
}
 
.login{
    background: #FFF;
    padding: 80px; 
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.4);
}
.login .form-control {
    box-shadow: none;
    padding: 30px;
    border: 1px solid #e8e8e8;
    background: #e8e8e8;
}
 
.login .btn{ 
    background: #b88cd2;
    border: none;
    color: #FFF; 
    text-transform: uppercase;
    border-radius: 0;
    font-size: 16px;
    height: 50px;
    width: 100%;
}
.btn-fill{
	border: 1px solid #000000;
	 background: #000000;
	 color: white;
	 font-size: 23px;
	 font-weight: bold;
}
.form-control1{
 box-shadow: none;
    padding: 30px;
    border: 1px solid #000000;
    background: #000000;
}
</style>
</head>
<body>
<!-- 로그인 안 한 경우 -->
<div class="login-form">
<c:if test="${empty login_info}">
   <div class="container">
     <div class="row">
       <h1>LOGIN FORM</h1>
         <div class="col-lg-6 col-lg-offset-3">
           <form class="login">
             <div class="form-group">
             <input id="userid"	 class="form-control"	
			type="text" placeholder="아이디" />
             </div>
             <div class="form-group">
             <input  class="form-control" id="userpwd" 
			onkeypress="if( event.keyCode==13 ){ go_login() }"
			type="password" placeholder="비밀번호" />
             </div>
             
        <p class="form-control1" style="width: 80%">
		<a  onclick="go_login()" class="btn-fill">로그인</a>
		</p>
       <!--  <p class="form-control1"  style="width: 80%">
		<a class="btn-fill" onclick="location='member'">회원가입</a>
		</p> -->
           </form>
         </div>
      </div>   
   </div> 
   </c:if>  
</div>    
<div class="login-form">
	<c:if test="${!empty login_info}">
	<form class="login">
	<p class="form-control"	style="font-size: 20px;">
			${login_info.userid}<br> ${login_info.name} 님 환영합니다! :D
			<br><br>
			<a onclick="go_logout()" class="btn-fill" style="font-size: 15px;">로그아웃</a>
			<a onclick="location='mypage'" class="btn-fill" style="font-size: 15px;">마이페이지</a>
		</p>
	</form>
	</c:if>
</div>
<%-- <!-- 로그인한 경우 -->
	<c:if test="${!empty login_info}">
	<tr>
<td>
		<p>
			${login_info.userid} ( ${login_info.name} 님 환영합니다! )
			<br><br>
			<a onclick="go_logout()" class="btn-fill">로그아웃</a>
		</p>
</td>
</tr>
	</c:if>

<!-- 로그인하지 않은 경우 -->
	<c:if test="${empty login_info}">
	<tr>
	<td>
	<span style="width:150px; height: 50px;  ">
		<input id="userid"		
			type="text" placeholder="아이디" />
		<input id="userpwd" 
			onkeypress="if( event.keyCode==13 ){ go_login() }"
			type="password" placeholder="비밀번호" />
	</span>
		<p>
		<a onclick="go_login()" class="btn-fill">로그인</a>
		<a class="btn-fill" onclick="location='member'">회원가입</a>
	</p>
	</td>
</tr>
	</c:if>
 --%>

</body>
<script type="text/javascript">
function go_logout(){
	$.ajax({
		url: 'logout',
		success: function(){
			location.reload();
		},error: function(req, text){
			alert(text+": "+req.status);
		}
	});	
}

function go_login(){
	$.ajax({
		url: 'login',
		data: { userid: $('#userid').val(), 
				userpwd: $('#userpwd').val() },
		success: function(data){
			if( data ){
				location.reload();
			}else{
				alert('아이디나 비밀번호가 일치하지 않습니다!');
				$('#userid').focus();
			}
			
		},error: function(req, text){
			alert(text+": "+req.status);
		}
	});
}

</script>
</html>
