<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    


<c:forEach items="${list}" var="vo" varStatus="status">
${status.index eq 0 ? '<hr>' : ''}
<div>${vo.nickname}[ ${vo.writedate }] 
<!-- 로그인한 사용자가 작성한 댓글은 수정/삭제 가능 -->
<c:if test="${vo.userid eq login_info.userid }">
<span style="float: right;">
	<a onclick="go_modify_save(${vo.id})" class="btn-fill-s" id="btn-modify-save-${vo.id }">수정</a>
	<a onclick="go_delete_cancel(${vo.id})" class="btn-fill-s" id="btn-delete-cancel-${vo.id}">삭제</a>
</span>
</c:if>
</div>
<div id="original-${vo.id }">${fn:replace( fn:replace( vo.content, lf, '<br>'), crlf, '<br>')}</div>
<div id="modify-${vo.id }" style="display: none;"></div>
<hr>
</c:forEach>
<script>
function go_delete_cancel(id){
	// 삭제/취소
	if( $('#btn-delete-cancel-'+id).text()=='취소'){
	display(id, 'd');		
	}else{
		if( confirm('정말 삭제하시겠습니까?') ){
			$.ajax({
				url: 'freeboard/comment/delete/'+id,
				success: function(){
					comment_list();
				}, error: function(){
					alert(text+": "+req.status);
				}
			});
		}
	}
}
function go_modify_save(id){
	if( $('#btn-modify-save-'+id).text()=='수정'){		
		var tag = "<textarea id='comment-modify-"+ id +"' style='margin-top:5px; width:99%; height:40px;'>"
				+$('#original-'+id).html().replace(/<br>/g, '\n')
				+"</textarea>";
		$('#modify-'+ id).html(tag);
		display(id, 'm');
	}else{
		var comment = new Object();
		comment.id = id;
		comment.content = $('#comment-modify-'+id).val();
		$.ajax({
			url: 'freeboard/comment/update',
			type: 'post',
			data: JSON.stringify(comment),
			contentType: 'application/json; charset=utf-8',
			success: function(data){
				alert('댓글변경' + data);
				comment_list();
			},error: function(req, text){
				alert(text+": "+req.status);
			}
		});
	}
}
function display(id, mode){
	//변경상태 : 저장/취소 <-> 수정/삭제
	$('#btn-modify-save-'+id).text(mode=='d' ? '수정' : '저장');
	$('#btn-delete-cancel-'+id).text(mode=='d' ? '삭제' : '취소');
	//변경상태 : modify가 보이고, 원래글은 안보이고
	// 		 <-> modify가 안보이고, 원래글 보이게
	$('#modify-'+id).css('display', mode=='d' ? 'none' : 'block');
	$('#original-'+id).css('display', mode=='d' ? 'block' : 'none');
}

</script>