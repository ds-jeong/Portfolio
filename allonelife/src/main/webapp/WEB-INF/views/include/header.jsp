<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>얼라이프</title>
<head>
<title>home</title>
<link rel="stylesheet" href="./css/normalize.css">
<link rel="stylesheet" href="./css/main.css">
<script src="./js/vendor/modernizr.custom.min.js"></script>
<script src="./js/vendor/jquery-1.10.2.min.js"></script>
<script src="./js/vendor/jquery-ui-1.10.3.custom.min.js"></script>
<script src="./js/main.js"></script>

</head>
</html>

<style>

@import
	url('https://fonts.googleapis.com/css?family=Gothic+A1&display=swap&subset=korean')
	;
#header {

	width: 85%;	height: 50px;	margin: 10px auto;
	max-width: 1200px;	min-width: 800px;
	font-family: 'Gothic A1', sans-serif;
}
#header > * {
	float: left;	padding: 0;
}
#header li {
	display: inline;	padding-left: 15px;
	text-align: center; font-weight: bold;
}
#header input[type=text], #header input[type=password]{
	width: 100px; height: 18px;
}
/* #header {
	
	width: 85%;	height: 50px;	margin: 10px auto;
	max-width: 1200px;	min-width: 800px;
	font-family: 'Gothic A1', sans-serif;

}

#header li {
	display: inline;
	text-align: center;
	line-height: 30px;
	padding-left: 140px;
	font-weight: bold;
}

#header input[type=text], #header input[type=password] {
	width: 100px;
	height: 18px;
	border: 1px solid #002e5d;
	border-radius: 3px 3px 3px 3px;
	color: #FFFFF;
	background-color: #2f2e30;
}

#header ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	background-color: #002e5d;
}

#header ul:after {
	content: '';
	display: block;
	clear: both;
}

#header > * {
	float: left;	padding: 0;
}

#header li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

#header li a:hover {
	background-color: #111;
	border-radius: 10px 10px 10px 10px;
	width: 100px;
	height: 40px;
}

#header li a:active {
	background-color: #1780a4;
	border-radius: 10px 10px 10px 10px;
}

#header li a:visited {
	background-color: #1780a4;
	border-radius: 10px 10px 10px 10px;
}

#headerl {
	width: 100%;
	margin-bottom: 100px;
}

#headerl p {
	margin-top: 50px;
	padding-left: 1200px;
	color: #FFFFFF;
}

#header li:first-child  a:hover {
	background-color: #111;
	border-radius: 10px 10px 10px 10px;
	width: 200px;
	height: 40px;
}

#header li:first-child  a:active {
	background-color: #1780a4;
	border-radius: 10px 10px 10px 10px;
}

#header li:first-child a:visited {
	background-color: #1780a4;
	border-radius: 10px 10px 10px 10px;
} */
</style>

	<div id="header">
		<a onclick="location='home'"><img src="img/logo06.png" style="width: 180px; height: 30px;"></a>
		<ul>
			<li><a onclick="location='list.no'">공지사항</a></li>
			<li><a onclick="location='list.re'">레시피</a></li>
			<li><a onclick="location='list.ex'">물물교환</a></li>
			<li><a onclick="location='list.ti'">팁&노하우</a></li>
			<li><a onclick="location='aa.fb'">자유게시판</a></li>
			<li><a onclick="location='list.it'">상품페이지</a></li>
		</ul>
		

<!-- 로그인한 경우 -->
<!-- <div id="headerl" style="background-color: #000000"> -->

	<c:if test="${!empty login_info}">
		<p style="float: right; font-size: 20px; color: #000000">
			${login_info.nickname} 님 환영합니다!!! <a onclick="location='mypage'"
				class="btn-fill">마이페이지</a> <a onclick="go_logout()" class="btn-fill">로그아웃</a>
			<!-- 관리자로 로그인시만 수정/삭제 가능 -->
			<c:if test="${login_info.admin eq 'Y' }">
				<a onclick="location='customer_manager'" class="btn-fill">고객관리</a>
				<a onclick="location='item_list'" class="btn-fill">상품신청 목록</a>
			</c:if>
			<input type="hidden" value="${login_info.userid}" name="userid">
			<input type="hidden" value="${login_info.userpwd}" name="userpwd">
		</p>
	</c:if>



	<!-- 로그인하지 않은 경우 -->
	<c:if test="${empty login_info}">
		<p style="float: right;">

			<input id="userid" type="text" placeholder="아이디" /> <input
				id="userpwd" onkeypress="if( event.keyCode==13 ){ go_login() }"
				type="password" placeholder="비밀번호" /> <a onclick="go_login()"
				class="btn-fill">로그인</a> <a class="btn-fill"
				onclick="location='member'">회원가입</a>

		</p>

	</c:if>
	</div>



<c:if test="${!empty login_info}">
	<script type="text/javascript">
		(function logins() {
			$.ajax({
				url : 'login',
				data : {
					userid : $('[name=userid]').val(),
					userpwd : $('[name=userpwd]').val()
				},
				success : function(data) {
					if (data) {
					} else {
					}

				},
				error : function(req, text) {
					alert(text + ": " + req.status);
				}
			});
		})
	</script>
</c:if>
<!-- <div id="sub">
	<div class="submenu"></div>
	<div class="submenu"></div>
	<div class="submenu"></div>
	<div class="submenu"></div> -->
<!--  	<div class="submenu">
		<ul><li>약국정보</li>
			<li>유기동물정보</li>
		</ul>
	</div>
	<div class="submenu">
		<ul><li><a onclick="location='employee.vi'">사원수</a></li>
			<li><a onclick="location='hirement.vi'">채용인원</a></li>
		</ul>
	</div> -->






<script>
	/* $(document).on('mouseover', '#header ul li', function(){
	 //마우스올린 카테고리의 서브메뉴클래스에 자식이 있으면 처리
	 if( $('.submenu:eq('+ $(this).index() +')').children().length > 0 ){
	 //마우스올린 카테고리 서브메뉴 보이게
	 $('#sub, .submenu:eq('+ $(this).index() +')').css('display', 'block');
	 //서브메뉴의 시작위치를 header 카테고리 시작위치로
	 $('.submenu').css('left', Math.floor($(this).children().offset().left) );
	
	
	 $('.submenu:not( :eq('+ $(this).index() +') )').css('display', 'none');
	
	
	 }else {
	 $('#sub').css('display', 'none');
	 }
	 }).on('mouseleave', '#sub', function() {
	 $('#sub').css('display', 'none');
	 })
	 ; */

	function go_logout() {
		$.ajax({
			url : 'logout',
			success : function() {
				location.reload();
			},
			error : function(req, text) {
				alert(text + ": " + req.status);
			}
		});
	}

	function go_login() {
		$.ajax({
			url : 'login',
			data : {
				userid : $('#userid').val(),
				userpwd : $('#userpwd').val()
			},
			success : function(data) {
				if (data) {
					location.reload();
				} else {
					alert('아이디나 비밀번호가 일치하지 않습니다!');
					$('#userid').focus();
				}

			},
			error : function(req, text) {
				alert(text + ": " + req.status);
			}
		});
	}

	function go_logins() {
		$.ajax({
			url : 'login',
			data : {
				userid : $('[name=userid]').val(),
				userpwd : $('[name=userpwd]').val()
			},
			success : function(data) {
				if (data) {
					location.reload();
				} else {
				}

			},
			error : function(req, text) {
				alert(text + ": " + req.status);
			}
		});
	}
</script>

</body>



