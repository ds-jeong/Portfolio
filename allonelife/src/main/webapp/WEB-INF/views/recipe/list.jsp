<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">



#guide {
 	color: #207eb1;
 	font-size: small;
	text-align: left;
	margin-left: 290px;
}




</style>
</head>
<body><br><br>


<img src="img/recipe.png"/><br>
<div id = guide>
<br>
- <strong>카테고리는</strong> 식사 / 안주 / 간식 / 기타 로만 검색됩니다.<br>
</div>




<form id="list" method="post">
<input type="hidden" name="curPage" value="1" />
<input type="hidden" name="id" />
<input type="hidden" name="read" value="false"/>
<p id="list-top" style="width:70%">
	<span style="float:left;">
		<select name="search">
			<option ${page.search eq 'all' ? 'selected' : ''}  value="all">전체</option>
			<option ${page.search eq 'title' ? 'selected' : ''}  value="title" >제목</option>
			<option ${page.search eq 'category' ? 'selected' : ''}  value="category">카테고리</option>
			<option ${page.search eq 'content' ? 'selected' : ''} value="content">내용</option>
			<option ${page.search eq 'writer' ? 'selected' : ''} value="writer">작성자</option>
		</select>
		<input type="text" name="keyword" value="${page.keyword}"
			style="width:350px; vertical-align: top;"/>	
		<a onclick="$('form').submit()" class="btn-fill">검색</a>
	</span>
	<!-- 로그인한 경우 글쓰기 가능 -->
<c:if test="${ !empty login_info }"> 
		<a onclick="location='new.re'" style="float:right;" class="btn-fill">글쓰기</a>
</c:if>	
</p>
</form>

<table>
<tr><th style="width:60px;">번호</th>
	<th>제목</th>
	<th style="width:100px;">작성자</th>
	<th style="width:130px;">작성일자</th>
	<th style="width:80px;">첨부파일</th>	
	<th style="width:80px;">조회수</th>
</tr>

<c:forEach items="${page.list}" var="vo">
<tr><td>${vo.no}</td>
	<td class="left"><a onclick="go_detail(${vo.id})">[ ${vo.category} ] ${vo.title}
	${vo.comments == 0 ? "" 
	  : [vo.comments]}
	${vo.comments == 0 ? "" 
	  : "<img src='img/comment.png' />"}
	</a></td>
	<td>${vo.name}</td>
	<td>${vo.writedate}</td>
	<td>${empty vo.filename ? ""
		: "<img class='btn-img' src='img/attach.png'/>"}</td>
			<td>${vo.readcnt}</td>
</tr>
</c:forEach>

</table><br>


<script type="text/javascript">
function go_detail(id){
	$('[name=id]').val(id);	
	$('[name=read]').val(true);
	$('#list').attr( 'action', 'detail.re');
	$('#list').submit();
}
</script>
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
</script><br><br>

<jsp:include page="/WEB-INF/views/include/page.jsp" />
</body>
</html>