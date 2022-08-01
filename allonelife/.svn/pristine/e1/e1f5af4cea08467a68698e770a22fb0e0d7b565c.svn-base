<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.sido, .category, .purpose{
	width: 120px;
	height: 30px;
}
#attach-file, #delete-file {
	display: none;
}
table th, table td {
	color: #207ea9;
	font-style: normal;
	font-size: 18px;
	background-color: #ffffff;
	border-color: #ffffff; 	
	padding: 10px;
	border-bottom: 1px solid #ffffff;
} 
table th{
	border-bottom: 1px solid;
}

</style>
</head>
<body>
<h3>물물교환 신규 게시글</h3>

<form enctype="multipart/form-data" method="post" id="new">
<table>
<tr><th>지역</th>
	<td class="left">
	<select name="sido" title="지역" class="sido">
    <option value="지역선택">지역선택</option>
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
<tr><th style="width:120px" >소제목</th>
	<td class="left">
	<select name="category" title="카테고리" class="category">
    <option value="카테고리선택">카테고리선택</option>
    <option value="식재료">식재료</option>
    <option value="의류">의류</option>
    <option value="전자기기">전자기기</option>
    <option value="가구">가구</option>
    <option value="기타">기타</option>
    </select>
    
	<select name="purpose" title="목적" class="purpose">
    <option value="목적선택">목적선택</option>
    <option value="팝니다">팝니다</option>
    <option value="삽니다">삽니다</option>
    <option value="교환합니다">교환합니다</option>
    <option value="기타">기타</option>
    </select>
   
	</td>
</tr>
<tr><th style="width:120px" >제목</th>
	<td>
	<input class="need" title="제목" style="width:98%" type="text" name="title" /></td>
</tr>
<tr><th>작성자</th>
	<td class="left">${login_info.nickname}</td>
</tr>
<tr><th>내용</th>
	<td><textarea name="content" 
	class="need" title="내용" 
	style="width:99%; height:200px;" onKeyUp="javascript:fnChkByte(this,'2000')"></textarea><span id="byteInfo">0</span> /&nbsp2000자  </td>
</tr>
<tr><th>첨부파일</th>
	<td class="left">
		<img id="delete-file" class="btn-img" src="img/delete.png" />
		<label id="file-name"></label>
		<label>
			<img class="btn-img" src="img/select.png" />
			<input id="attach-file" type="file" name="file"/>
		</label>
	</td>
</tr>
</table><br>
<a class="btn-fill" 
	onclick="if( checkInputSelect() && checkInput() ){ go_itemone()}">저장</a>
<a class="btn-empty" onclick="location='list.ex'">취소</a>
</form>
<script type="text/javascript" src="js/nullCheck.js"></script>
<script type="text/javascript">
function go_itemone(){
	$('#new').attr('action', 'insert.ex');
	$('#new').submit();
}


$(function(){
	$('#delete-file').click(function(){
		$('#file-name').text('');
		$('#attach-file').val('');
		$('#file-name').css('padding-right', '0px');
		$('#delete-file').css('display', 'none');
	});
	
	$('#attach-file').change(function(){
		$('#file-name').text( this.files[0].name );
		$('#file-name').css('padding-right', '20px');
		$('#delete-file').css('display', 'inline-block');
	});	
});


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