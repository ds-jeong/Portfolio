<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
	prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>  
	  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*
table tr:nth-child(2)  th:nth-child(3),
table tr:nth-child(2)  td:nth-child(4) {
	width: 100px;
}
table tr:nth-child(2) th:nth-child(5), 
table tr:nth-child(2) td:nth-child(6) {
 	width: 80px;
}
*/
</style>
</head>
<script type="text/javascript">
$(function(){
	$('table tr:eq(1) th:eq(1), table tr:eq(1) td:eq(1)').css('width', '120px');
	$('table tr:eq(1) th:eq(2), table tr:eq(1) td:eq(2)').css('width', '80px');
	
});

</script>
<body>



<h3>공지사항 안내</h3>
<table>
<tr><th style="width:120px;">제목</th>
	<td colspan="9" class="left">${vo.title}</td>
</tr>
<tr>
			<th>작성자</th>
						<td colspan="5" class="left">${vo.writer}</td>
	<th>작성일자</th>
	<td>${vo.writedate}</td>
	<th>조회수</th>
	<td>${vo.readcnt}</td>
</tr>
<tr><th>내용</th>
	<td colspan="5" class="left">${fn: replace(vo.content, crlf, '<br>')}</td>
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
	<br><br>
<a class="btn-fill" onclick="go_list()">목록으로</a>

<!-- 관리자로 로그인시만 수정/삭제 가능 -->
<c:if test="${login_info.admin eq 'Y' }">
<a class="btn-fill" onclick="go_modify()">수정</a>
<a class="btn-fill" onclick="if( confirm('정말 삭제하시겠습니까??') ) { location='delete.no?id=${vo.id}' }">삭제</a>
</c:if>

<form method="post" action="list.no">
	<input type="hidden" name="id" value="${vo.id}"/>
	<input type="hidden" name="curPage" value="${page.curPage}"/>
	<input type="hidden" name="search" value="${page.search}" />
	<input type="hidden" name="keyword" value="${page.keyword}" />
</form>
<script type="text/javascript">
function go_modify(){
	$('form').attr('action', 'modify.no');
	$('form').submit();
}

function go_list(){
	$('form').submit();
}

</script>
</body>
</html>