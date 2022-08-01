<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.image{
	width:300px;
	height:300px;
}
table{
	border-radius: 1px;	
	border-spacing: 2em 1.5em;
}

#introImg {
	margin-top: 30px;

}


#allpoint{
	font-size: x-large;

}



</style>
</head>






<body>
	<br>
<br>
<div id="allpoint">
<img src="img/item.png"/><br><br>

<c:if test="${!empty login_info}">
<c:forEach items="${list}" var="vo">

<h4>${login_info.nickname}님의 현재 보유 얼은 "<fmt:formatNumber value="${vo.point}" groupingUsed="true"/>"얼입니다.</h4>
</c:forEach>
</c:if>



</div>
<form id="item" method="post">
<table style="width: 500px;">
<tr>
<td><img src="img/cgv.jpg" alt="cgv" class="image"/></td>
<td><img src="img/culture.jpg" alt="culture" class="image"/></td>
<td><img src="img/yogiyo.jpg" alt="yogiyo" class="image"/></td>
</tr>
<tr>
<td style="width: 200px;font-size: 20px;"><strong>cgv 영화 30% 할인권</strong> <br><br> 3,000얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('cgv 영화 30% 할인권을 신청하시겠습니까??') ){go_itemone()}">신청</a></c:if>
</td>
<td style="width: 200px;"><strong>문화상품권</strong> <br><br> 5,000얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('문화상품권을 신청하시겠습니까??') ){go_itemtwo()}">신청</a></c:if>
</td>
<td style="width: 200px;"><strong>요기요 3,000원 할인쿠폰</strong> <br><br> 3,000얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('요기요 3,000원 할인쿠폰을 신청하시겠습니까??') ){go_itemthree()}">신청</a></c:if>
</td>

</tr>

<tr>
<td><img src="img/starbucks1.jpg" alt="starbucks1" class="image"/></td>
<td><img src="img/beskin.jpg" alt="beskin" class="image"/></td>
<td><img src="img/cu1.jpg" alt="cu1" class="image"/></td>
</tr>
<tr>
<td style="width: 200px;  font-size: 20px;"><strong>스타벅스 아이스 아메리카노 Tall</strong> <br><br> 4,100얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('스타벅스 아이스 아메리카노 Tall을 신청하시겠습니까??') ){go_item4()}">신청</a></c:if>
</td>
<td style="width: 200px;"><strong>베스킨라빈스 파인트 아이스크림</strong> <br><br> 8,200얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('베스킨라빈스 파인트 아이스크림을 신청하시겠습니까??') ){go_item5()}">신청</a></c:if>
</td>
<td style="width: 200px;"><strong>CU 모바일 상품권</strong> <br><br> 5,000얼 <br><br>
	<c:if test="${empty login_info}"><a class="btn-fill" onclick="alert('로그인후 신청가능합니다.')">신청</a></c:if>
	<c:if test="${!empty login_info}"><a class="btn-fill" onclick="if( confirm('CU 모바일 상품권을 신청하시겠습니까??') ){go_item6()}">신청</a></c:if>
</td>

</tr>
</table>
<br><br>
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
</script>

</form>
<script type="text/javascript">


<c:forEach items="${list}" var="vo">

function go_itemone(){
	 if( ${vo.point} < 3000 ){
		alert('얼이 모자랍니다');
		return;
	}else{
	$('#item').attr('action', 'insert.itemone');
	$('#item').submit();

		alert('cgv 영화 30% 할인권 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');

	}
}
function go_itemtwo(){
	 if( ${vo.point} < 5000 ){
		alert('얼이 모자랍니다');
		return;
	}else{	
	$('#item').attr('action', 'insert.itemtwo');
	$('#item').submit();
		alert('문화상품권 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');
	}
}
function go_itemthree(){
	if( ${vo.point} < 3000 ){
		alert('얼이 모자랍니다');
		return;
	}else{	
	$('#item').attr('action', 'insert.itemthree');
	$('#item').submit();

		alert('요기요 3,000원 할인쿠폰 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');

	}
}
function go_item4(){
	if( ${vo.point} < 4100 ){
		alert('얼이 모자랍니다');
		return;
	}else{	
	$('#item').attr('action', 'insert.item4');
	$('#item').submit();
		alert('스타벅스 아이스 아메리카노 Tall 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');
	}
}
function go_item5(){
	if( ${vo.point} < 8200 ){
		alert('얼이 모자랍니다');
		return;
	}else{	
	$('#item').attr('action', 'insert.item5');
	$('#item').submit();
		alert('베스킨라빈스 파인트 아이스크림 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');
	}
}
function go_item6(){
	if( ${vo.point} < 5000 ){
		alert('얼이 모자랍니다');
		return;
	}else{	
	$('#item').attr('action', 'insert.item6');
	$('#item').submit();
		alert('CU 모바일 상품권 신청이 완료되었습니다. \n2~3일 뒤에 상품은 메일을 통해 발송해드립니다.');

	}
}
</c:forEach>
</script>
</body>
</html>