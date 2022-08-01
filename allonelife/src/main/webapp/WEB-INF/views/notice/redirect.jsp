<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<form method="post" action="list.no">
<input type="text" name="curPage" value="${page.curPage}"/>
<input type="text" name="search" value="${page.search}"/>
<input type="text" name="keyword" value="${page.keyword}"/>
<input type="text" name="id" value="${id}"/>
</form>
<script>
if( ${view eq 'detail'} ){
	$('form').attr('action', 'detail.no');	
}
$('form').submit();
</script>