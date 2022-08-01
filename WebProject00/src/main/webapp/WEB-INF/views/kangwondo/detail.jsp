<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#download{
cursor: pointer;

}
table {
 background-color: white;
}
table tr, table td{
	border: 2px solid silver;	
}
h1 {
 font-size: 21px;
 color: #ffffff;
}
</style>

</head>
<body>
<h1>상세페이지입니다. :D</h1>


	<table>
		<tr>
			<th style="width: 120px;">지역</th>
			<td colspan="9" class="left">${vo.sido}</td>
		</tr>
		<tr>
			<th style="width: 120px;">제목</th>
			<td colspan="9" class="left">
				${vo.title}</td>
		</tr>
		<tr>
			<th>작성자</th>
						<td colspan="4" class="left">${vo.name}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td  class="left">${vo.writedate}</td>
			<th>조회수</th>
			<td  class="left">${vo.readcnt}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="9" class="left"><label id="preview"></label>
			<c:if test="${ !empty vo.filename }">
					<br>
					<br>
				</c:if> ${fn: replace(vo.content, crlf, '<br>')}</td>
		</tr>
		<tr>
			
			<th>첨부파일</th>
			<td colspan="9" class="left"><label id="download">${vo.filename}${empty vo.filename ? '' 
		: '<img id="download" class="btn-img" src="img/download.png" />' }
			</label>
			</td>
		</tr>

	</table>
		<br><br>
		<a class="btn-fill" onclick="go_list()">목록으로</a>
		<a class="btn-fill" onclick="go_modify()">수정</a>
		<a class="btn-fill"
			onclick="if( confirm('정말 삭제하시겠습니까??') ) { location='delete.kangwondo?no=${vo.no}' }">삭제</a>

	<form method="post" action="list.kangwondo">
		<input type="hidden" name="no" value="${vo.no}" /> <input
			type="hidden" name="curPage" value="${page.curPage}" /> <input
			type="hidden" name="search" value="${page.search}" /> <input
			type="hidden" name="keyword" value="${page.keyword}" />
	</form>
		<script type="text/javascript">
$(function(){
	if( ${ !empty vo.filename } ){
		showAttachedImage('${vo.filename}', 'preview');
	}
	//a.b.c.jpg, abd.hwp
	function showAttachedImage(filename, tag){
		var ext = filename.substring( 
				filename.lastIndexOf('.')+1 ).toLowerCase();
		var imgs=[ 'jpg', 'png', 'jpeg', 'bmp', 'gif', 'svg' ];
		if( imgs.indexOf(ext) > -1 ){
			var path='${fn:replace(vo.filepath, "\\", "/")}'
			var img 
			= '<img class="'  
			+ (tag==='preview' ? 'btn-img2' : 'popup-img') 
			+ '" id="preview-img" src= "<c:url value='' />' + path + '" />';
			$('#'+ tag).html(img);
			console.log(img);
		}
	}
	
	$('#preview-img').click(function(){
		$('#popup, #popup-background').css('display', 'block');
		showAttachedImage('${vo.filename}', 'popup');
	});
	
});

function go_modify(){
	$('form').attr('action', 'modify.kangwondo');
	$('form').submit();
}

function go_list(){
	$('form').submit();
}

$('#download').click(function(){
	location="download.kangwondo?no=${vo.no}";
});
</script>
</body>
</html>