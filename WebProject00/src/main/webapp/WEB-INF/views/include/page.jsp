<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.page-on, .page-off, .page-last, .page-next, .page-first, .page-prev{
	display: inline-block;
	width: 30px;
	line-height: 28px;
}
.page-on{
	border: 1px solid gray;
	background-color: gray;
	font-weight: bold;
	color: #fff;
}
.page-next, .page-last, .page-first, .page-prev{
	border: 1px solid gray;
	text-indent: -999999px;
}
.page-first{
	background: url("img/page_first.jpg") center no-repeat;
}
.page-prev{
	background: url("img/page_prev.jpg") center no-repeat;
}
.page-next {
	background: url("img/page_next.jpg") center no-repeat;
}
.page-last {
	background: url("img/page_last.jpg") center no-repeat;
}
</style>
<p id="page-list">
<c:if test="${page.curBlock > 1}">
	<a class="page-first" onclick="go_page(1)">처음</a>
	<a class="page-prev" onclick="go_page(${page.beginPage - page.blockPage})">이전</a>
</c:if>
<c:forEach var="no" begin="${page.beginPage }" end="${page.endPage }">
	<c:if test="${no eq page.curPage }">
	<span class="page-on">${no }</span>
	</c:if>
	<c:if test="${no ne page.curPage }">
	<a onclick="go_page(${no})" class="page-off">${no }</a>
	</c:if>
</c:forEach>
<c:if test="${page.curBlock lt page.totalBlock}">
	<a class="page-next" onclick="go_page(${page.endPage+1})">다음</a>
	<a class="page-last" onclick="go_page(${page.totalPage})">마지막</a>
</c:if>
</p>
<script>
function go_page(no){
	$('[name=curPage]').val(no);
	$('#list').submit();
}
</script>