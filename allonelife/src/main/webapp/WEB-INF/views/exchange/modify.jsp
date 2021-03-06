<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sido, .category, .purpose{
	width: 80px;
	height: 30px;
}
input[name=title]{
	width:98%
}
textarea[name=content]{
	width: 99%; height: 200px;
}
#delete-file, #attach-file{
	display: none;
}

</style>
</head>
<body>
<h3>물물교환 게시글 수정</h3>
<form enctype="multipart/form-data" method="post" action="update.ex">
<table>
<tr><th style="width:120px">지역</th>
	<td class="left" colspan="5">
	<select name="sido" title="지역" class="sido">
    <option value="${vo.sido}" selected="selected">${vo.sido}</option>
    <option value="서울">서울</option><option value="부산">부산</option><option value="대구">대구</option>
    <option value="인천">인천</option><option value="광주">광주</option><option value="대전">대전</option>
    <option value="울산">울산</option><option value="세종">세종</option><option value="경기">경기</option>
    <option value="강원">강원</option><option value="충북">충북</option><option value="충남">충남</option>
    <option value="전북">전북</option><option value="전남">전남</option><option value="경북">경북</option>
    <option value="경남">경남</option><option value="제주">제주</option><option value="해외">해외</option>
    <option value="기타">기타</option>
	</select>	
	</td>
</tr>
<tr><th style="width:120px">제목</th>
	<td class="left" colspan="5"><input class="need" title="제목"
		type="text" name="title" value="${vo.title}"/></td>
</tr>
<tr><th style="width:120px" >소제목</th>
	<td class="left" colspan="5">
	<select name="category" title="카테고리" class="category">
    <option value="${vo.category}" selected="selected">${vo.category}</option>
    <option value="식재료">식재료</option>
    <option value="의류">의류</option>
    <option value="전자기기">전자기기</option>
    <option value="가구">가구</option>
    <option value="기타">기타</option>
    </select>
    
	<select name="purpose" title="목적" class="purpose">
    <option value="${vo.purpose}" selected="selected">${vo.purpose}</option>
    <option value="팝니다">팝니다</option>
    <option value="삽니다">삽니다</option>
    <option value="교환합니다">교환합니다</option>
    <option value="기타">기타</option>
    </select>
   
	</td>
</tr>
<tr><th>작성자</th>
	<td class="left" >${vo.name}</td>
	<th style="width:120px">작성일자</th>
	<td style="width:120px">${vo.writedate}</td>
	<th style="width:70px">조회수</th>
	<td style="width:70px">${vo.readcnt}</td>
</tr>
<tr><th>내용</th>
	<td class="left" 
		colspan="5"><textarea class="need" title="내용" 
					name="content" onKeyUp="javascript:fnChkByte(this,'2000')">${vo.content}</textarea><span id="byteInfo">0</span> /&nbsp2000자  </td>
</tr>
<tr><th>첨부파일</th>
	<td class="left" colspan="5">
		<img id="delete-file" src="img/delete.png" class="btn-img" />
		<label id="file-name">${vo.filename}</label>
		<label>
			<img src="img/select.png" class="btn-img" />
			<input id="attach-file"  type="file" name="file"/>
		</label>
	</td>
</tr>
</table><br>
<input type="hidden" name="delete" value="0"/>
<input type="hidden" name="id" value="${vo.id}" />
<a class="btn-fill" 
	onclick="if( checkInput() ){ $('form').submit() }">저장</a>
<a class="btn-empty" 
	onclick= "$('form').attr('action', 'detail.ex'); $('form').submit()">취소</a>
</form>
<script type="text/javascript" src="js/nullCheck.js"></script>
<script type="text/javascript">
$(function(){
	if( ${ !empty vo.filename} ){
		whenFileSelected(1);
	}
	
	$('#attach-file').change(function(){
		$('#file-name').text( this.files[0].name );
		whenFileSelected(1);
	});
	
	$('#delete-file').click(function(){
		$('[name=delete]').val(1);
		$('#file-name').text('');
		$('#attach-file').val('');
		whenFileSelected(0);
	});
});

function whenFileSelected(mode){
	$('#file-name').css('padding-right', mode==0 ? '0px' : '20px');	
	$('#delete-file').css('display', mode==0 ? 'none' : 'inline-block');
}

function fnChkByte(obj, maxByte)
{
    var str = obj.value;
    var str_len = str.length;

    var rbyte = 0;
    var rlen = 0;
    var one_char = "";
    var str2 = "";

    for(var i=0; i<str_len; i++)
    {
        one_char = str.charAt(i);
        if(escape(one_char).length > 4)
        {
            rbyte += 2;                                         //한글2Byte
        }
        else
        {
            rbyte++;                                            //영문 등 나머지 1Byte
        }

        if(rbyte <= maxByte)
        {
            rlen = i+1;                                          //return할 문자열 갯수
        }
     }

     if(rbyte > maxByte)
     {
  // alert("한글 "+(maxByte/2)+"자 / 영문 "+maxByte+"자를 초과 입력할 수 없습니다.");
  alert("입력 내용은 최대 " + maxByte + "자를 초과할 수 없습니다.")
  str2 = str.substr(0,rlen);                                  //문자열 자르기
  obj.value = str2;
  fnChkByte(obj, maxByte);
     }
     else
     {
        document.getElementById('byteInfo').innerText = rbyte;
     }
}


</script>

</body>
</html>