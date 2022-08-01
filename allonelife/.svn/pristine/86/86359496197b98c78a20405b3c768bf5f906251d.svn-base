<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- <link rel="stylesheet" type="text/css" href="./style3.css"/> -->
</head>
<head>


<style>
body {
	background-color: #ddebec;
}

#video {
	top: 0px;
	left: 0px;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: auto;
	z-index: -1;
	overflow: hidden;
}

.button {
	width: 100px;
	height: 30px;
	cursor: pointer;
	border-radius: 5px;
	background: #D9E5FF;
}

.button:hover {
	font-weight: bold;
}

/* Animation Canvas */
.animation_canvas {
	overflow: hidden;
	position: relative;
	width: 1903px;
	height: 650px;
	margin: 0 auto;
}

/* Slider Panel */
.slider_panel {
	width: 7612px;
	position: relative;
}

.slider_image {
	float: left;
	width: 1903px;
	height: 650px;
}

.sliders_image {
	width: 1903px;
	height: 150px;
}
/* Slider Text Panel */
.slider_text_panel {
	position: absolute;
	top: 500px;
	left: 50px;
}

.slider_text {
	position: absolute;
	width: 250px;
	height: 150px;
	color: white;
}

/* Control Panel */
.control_panel {
	position: absolute;
	top: 580px;
	left: 270px;
	height: 13px;
	overflow: hidden;
}

.control_button {
	width: 12px;
	height: 46px;
	position: relative;
	float: left;
	cursor: pointer;
	/* background: url('point_button.png'); */
}

.control_button:hover {
	top: -16px;
}

.control_button.active {
	top: -31px;
}

.button {
	float: right;
	position: relative;
}

#hot, #noticeMain {
	width: 1000px;
	height: 30px;
	margin-left: 450px;
	border-radius: 10px 10px 10px 10px;
	color: #FFFFFF;
	background-color: #002e5d;
	padding: 5px;
	padding-top: 13px;
	font-weight: bold;
	font-size: large;
}

#popup {
	position: absolute;
	width: 500px;
	height: 500px;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	border: 3px solid #666;
	display: none;
	z-index: 99999;
	border-radius: 50%;
}



#t1 td a {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 20px;
	display: block;
	width: 330px;
}


#t2 td a{
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 20px;
	text-align : center;
	width: 730px;
}

</style>


</head>
<body>


	<video id="video" preload="auto" autoplay="true" loop="loop"
		muted="muted" volume="0">
		<source src="img/intro.mp4">
	</video>

	<br>
	<br>
	<br>

	<div id="noticeMain"
		style="color: #FFFFFF; background-color: #002e5d; padding: 5px; font-weight: bold; font-size: x-large;">
		얼라이프 공지사항 및 이벤트</div>
	<br>

	<div style="width: 80%; margin-left: 200px;">

		<form id="noticelist" method="post">
			<input type="hidden" name="id" /> <input type="hidden" name="read"
				value="false" />
		</form>


		<table id="t2" style="width: 99%;">


			<tr>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>

			<c:forEach items="${noticelist}" var="vo">
				<tr>
					<td class="vo_ti"><a onclick="go_notice_detail(${vo.id})">${vo.title} </a></td>
					<td>${vo.writedate}</td>
					<td>${vo.readcnt}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<br>
	<br>

	<div id="hot"
style="color:#FFFFFF; background-color:#002e5d; padding:5px; font-weight: bold; font-size: large;">
얼라이프 HOT한 인기글
</div><br>
 

<div style ="width:20%; float:left; margin-left: 200px; ">

<form id="recipelist" method="post">
<input type="hidden" name="id" />
<input type="hidden" name="read" value="false"/>
</form>

<table id="t1" style ="width:99%;">

<tr><th colspan="2">레시피 인기글 BEST3</th>
</tr>
<c:forEach items="${recipelist}" var="vo">

<tr style ="height:300px;" >
	<td colspan="2">
	<c:if test="${empty vo.filename}"><img class='btn-img3' src='img/z.PNG'/></c:if>
	<c:if test="${!empty vo.filename}"><img onclick="go_recipe_detail(${vo.id})" class='btn-img3' src='<c:url value="/"/>${fn:replace(vo.filepath, "\\", "/")}' /></c:if>
	</td>
</tr>

<tr>		
	<td colspan="2"><a onclick="go_recipe_detail(${vo.id})">[ ${vo.category} ] ${vo.title} </a></td>
</tr>
<tr>	
	<td><img style="width: 20px; height: 15px;" src="img/cnt.png" />&nbsp;${vo.readcnt}</td>
	<td><img style="width: 20px; height: 15px;" src="img/good2.png" />&nbsp;${vo.good}</td>		
</tr>
</c:forEach>
</table>
</div>


<div style ="width:20%; float:left;">

<form id="exchangelist" method="post">
<input type="hidden" name="id" />
<input type="hidden" name="read" value="false"/>
</form>

<table id="t1" style ="width:99%;">
<tr><th colspan="2">물물교환 인기 BEST3</th>
</tr>

<c:forEach items="${exchangelist}" var="vo">

<tr style ="height:300px;">
	<td colspan="2">
		<c:if test="${empty vo.filename}"><img class='btn-img3' src='img/z.PNG'/></c:if>
		<c:if test="${!empty vo.filename}"><img onclick="go_exchange_detail(${vo.id})" class='btn-img3' src='<c:url value="/"/>${fn:replace(vo.filepath, "\\", "/")}' /></c:if>
	</td>	
</tr>

<tr>		
	<td colspan="2">
	<a onclick="go_exchange_detail(${vo.id})">${vo.sido} [ ${vo.category} ${vo.purpose} ] ${vo.title} </a></td>
</tr>
<tr>	
	<td><img style="width: 20px; height: 15px;" src="img/cnt.png" />&nbsp;${vo.readcnt}</td>
	<td><img style="width: 20px; height: 15px;" src="img/good2.png" />&nbsp;${vo.good}</td>		
</tr>
</c:forEach>
</table>
</div>

<div style ="width:20%; float:left;">

<form id="tiplist" method="post">
<input type="hidden" name="id" />
<input type="hidden" name="read" value="false"/>
</form>

<table  id="t1" style ="width:99%;">
<tr><th colspan="2">팁&노하우 인기글 BEST3</th>
</tr>

<c:forEach items="${tiplist}" var="vo">

<tr style ="height:300px;">
	<td colspan="2">
		<c:if test="${empty vo.filename}"><img class='btn-img3' src='img/z.PNG'/></c:if>
		<c:if test="${!empty vo.filename}"><a></a><img onclick="go_tip_detail(${vo.id})" class='btn-img3' src='<c:url value="/"/>${fn:replace(vo.filepath, "\\", "/")}' /></c:if>
	</td>	
</tr>

<tr>		
	<td colspan="2"><a onclick="go_tip_detail(${vo.id})">[ ${vo.category} ] ${vo.title} </a></td>
</tr>
<tr>	
	<td><img style="width: 20px; height: 15px;" src="img/cnt.png" />&nbsp;${vo.readcnt}</td>
	<td><img style="width: 20px; height: 15px;" src="img/good2.png" />&nbsp;${vo.good}</td>			
</tr>
</c:forEach>
</table>
</div>



<div style ="width:20%; float:left; margin-bottom: 100px;">

<form id="boardlist" method="post">
<input type="hidden" name="id" />
<input type="hidden" name="read" value="false"/>
</form>

<table id="t1" style ="width:99%;">
<tr><th colspan="2">자유게시판 인기글 BEST3</th>
</tr>

<c:forEach items="${boardlist}" var="vo">

<tr style ="height:300px;">
	<td colspan="2">
		<c:if test="${empty vo.filename}"><img class='btn-img3' src='img/z.PNG'/></c:if>
		<c:if test="${!empty vo.filename}"><img class='btn-img3' src='<c:url value="/"/>${fn:replace(vo.filepath, "\\", "/")}' /></c:if>
	</td>	
</tr>

<tr>		
	<td colspan="2"><a onclick="go_board_detail(${vo.id})">${vo.title} </a></td>
</tr>
<tr style="border-bottom: 1px solid black">	
<td><img style="width: 20px; height: 15px;" src="img/cnt.png" />&nbsp;${vo.readcnt}</td>
	<td><img style="width: 20px; height: 15px;" src="img/good2.png" />&nbsp;${vo.good}</td>
</tr>
</c:forEach>
</table>
</div>
</body>



	<script type="text/javascript">
function go_notice_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#noticelist').attr( 'action', 'detail.no');
	$('#noticelist').submit();
}

function go_recipe_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#recipelist').attr( 'action', 'detail.re');
	$('#recipelist').submit();
}

function go_exchange_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#exchangelist').attr( 'action', 'detail.ex');
	$('#exchangelist').submit();
}

function go_tip_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#tiplist').attr( 'action', 'detail.ti');
	$('#tiplist').submit();
}

function go_board_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#boardlist').attr( 'action', 'detail.fb');
	$('#boardlist').submit();
}




</script>




	<script>
	$(document).ready(function() {
				var imgCnt = $('.slider_panel').children().length;
				var imgIdx = 1; // 처음에 3초 보여주고, setinterval로 3초 후에 2번째 보여줄려고
				var refreshInterval = null;
				var timer = null;

				// 슬라이더를 움직여주는 함수, 3번째 설명
				function moveSlider(index) {
					// 슬라이더를 이동합니다.
					var willMoveLeft = -(index * 1903);
					$('.slider_panel').animate({
						left : willMoveLeft
					}, 'slow'); // fast

					// control_button에 active클래스를 부여/제거합니다.
					$('.control_button[data-index=' + index + ']').addClass('active');
					$('.control_button[data-index!=' + index + ']').removeClass('active');

					// slide_text 글자를 이동합니다.
					$('.slider_text[data-index=' + index + ']').show().animate( {
								left : 0
							}, 'slow');
					$('.slider_text[data-index!=' + index + ']').hide('slow', function() {
								$(this).css('left', -300);
							});
				}
				
				// 타이머로 돌리기 위해
				timer = function() {
					moveSlider(imgIdx);

					if (imgIdx < imgCnt - 1) {
						imgIdx++;
					} else {
						imgIdx = 0;
					}
				};

				$('.animation_canvas').on({ // canvas에 올려놨을때
					mouseenter : function() {
						clearInterval(refreshInterval);
					},
					mouseleave : function() {
						refreshInterval = setInterval(timer, 3000); // 3초마다 이동
					}

				});
				
				// 컨트롤 버튼의 클릭 리스너 지정 및 data-index 할당, 2번째 설명
				$('.control_button').each(function(index) {
					$(this).attr('data-index', index);
				}).click(function() {
					var index = $(this).attr('data-index');
				// alert(index); // 로 확인해봄, moveSlider()하기 전에
					imgIdx =  index; // 꼭 필요한것!, 랜덤하게 클릭했을때 다음 그림으로 이동
					moveSlider(index);
				});

				// 초기 텍스트 위치 지정 및 data-index 할당, 1번째 설명
				$('.slider_text').css('left', -300).each(function(index) {
					$(this).attr('data-index', index); // data-index라는 이름으로 index 할당
				});
				$('.slider_text[data-index=' + 0 + ']').show().animate({
					left : 0
				}, 'slow');
			
				// 초기 컨트롤 0번째를 active로
				$('.control_button[data-index=' + 0 + ']').addClass('active');
				
				refreshInterval = setInterval(timer, 1500);

				/* // 초기 슬라이더 랜덤하게 위치 지정, 4번째 설명
				var randomNumber = Math.round(Math.random() * 4);
					// Math.round : 반올림한 수와 가장 가까운 정수 값을 반환
					// Math.random() : [0, 1]범위(0을 포함하면서 1 보다는 작은)의 난수를 부동소수점(floating-point)으로 반환
				moveSlider(randomNumber); */

				/* setTime(); */

				//moveSlider(0);
			});
</script>
</head>




<head>
<script language="Javascript"> 
<!-- 
function setCookie( name, value, expiredays ) { 
    var todayDate = new Date(); 
        todayDate.setDate( todayDate.getDate() + expiredays ); 
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
    }
function closeWin() { 
    if ( document.notice_form.chkbox.checked ){ 
        setCookie( "maindiv", "done" , 1 ); 
    } 
    document.all['divpop'].style.visibility = "hidden"; 
} 
//-->  
</script>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="0"
	marginwidth="0" marginheight="0">
	<!-- POPUP -->
	<div id="divpop"
		style="position: absolute; left: 100px; top: 100px; z-index: 120; visibility: hidden;">
		<table width=400 height=500 cellpadding=2 cellspacing=0>
			<tr>
				<td style="" align=center bgcolor=white><img
					src="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad8909b87c4.png">
				</td>
			</tr>
			<tr>
				<form name="notice_form">
					<td align=right bgcolor=white><input type="checkbox"
						name="chkbox" value="checkbox">오늘 하루 이 창을 열지 않음 <a
						href="javascript:closeWin();">[닫기]</a></td>
			</tr>
			</form>
		</table>
	</div>
	<script language="Javascript"> 
cookiedata = document.cookie;    
if ( cookiedata.indexOf("maindiv=done") < 0 ){      
    document.all['divpop'].style.visibility = "visible"; 
    } 
    else { 
        document.all['divpop'].style.visibility = "hidden"; 
} 
</script>
<body>

	
	<div class="animation_canvas">
		<div class="slider_panel">
			<a href="http://www.khugnews.co.kr/wp/?p=379" target="_blank"><img src="img/sl1.png" class="slider_image" /></a> 
			<a href="http://www.hani.co.kr/arti/economy/economy_general/790522.html" target="_blank"><img src="img/sl2.png" class="slider_image" /></a> 
			<a href="http://www.khugnews.co.kr/wp/?p=379" target="_blank"><img src="img/sl3.png" class="slider_image" /></a> 
			<a href="https://post.naver.com/viewer/postView.nhn?volumeNo=12007724&memberNo=16296850" target="_blank"><img src="img/sl4.png" class="slider_image" /></a>
		</div>
		<div class="slider_text_panel">
			<div class="slider_text">
				<h1>경희대학교</h1>
				<p style="font-size: small;">혼자 사는 일이 더 이상 특별하지 않은 시대, 우리 사회는
					무엇을 준비해야 하는가? -기사中</p>
			</div>
			<div class="slider_text">
				<h1>한겨례</h1>
				<p style="font-size: small;">65살 이상 1인 가구, 30년 뒤 3배로 폭증 -기사中</p>
			</div>
			<div class="slider_text">
				<h1>여성가족부</h1>
				<p style="font-size: small;">인구특성별 1인가구 현황 및 정책대응 연구中</p>
			</div>
			<div class="slider_text">
				<h1>직방</h1>
				<p style="font-size: small;">아임해피의 뉴스 속 아파트 돋보기 #43. 이제는 나 혼자
					'아파트' 산다? -기사中</p>
			</div>
		</div>
	</div>
	<div class="control_panel">
		<div class="control_button"></div>
		<div class="control_button"></div>
		<div class="control_button"></div>
		<div class="control_button"></div>
	</div>
	
	
	<div style="margin-top: 100px;">
	<script>
   function random_imglink(){
   var myimages=new Array()

      /* 각각의 이미지 경로 지정 */
      myimages[1]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad18405cd5c.jpg";
      myimages[2]="http://pds18.egloos.com/pds/201910/21/81/c0128481_5dad86deeffa0.jpg";
      myimages[3]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad83b48de16.jpg";
      myimages[4]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad83bd741c0.jpg";
      myimages[5]="http://pds20.egloos.com/pds/201910/21/81/c0128481_5dad8a0533179.jpg";
      myimages[6]="http://pds18.egloos.com/pds/201910/21/81/c0128481_5dad1787d4ea8.jpg";
      
      /* 각각의 이미지 링크 지정 */
      var imagelinks=new Array()
      imagelinks[1]="http://www.callofduty.com/ko/"
      imagelinks[2]="http://www.cgv.co.kr/"
      imagelinks[3]="http://pubg.game.daum.net/pubg/index.daum"
      imagelinks[4]="https://www.samsung.com/sec/"
      imagelinks[5]="http://www.lotteria.com/"
      imagelinks[6]="http://www.yogiyo.co.kr/mobile/#/"

   var ry=Math.floor(Math.random()*myimages.length)
   if (ry==0)
   ry=1

   document.write('<a href='+'"'+imagelinks[ry]+'"'+' target=_blank><img src="'+myimages[ry]+'" border=0></a>')
   }
   random_imglink()
</script></div>
	
</html>