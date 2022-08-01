<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지글 작성</h3>
<form enctype="multipart/form-data" method="post" action="insert.no">
<table>
<tr><th style="width:120px;">제목</th>
	<td><input title="제목" class="need" style="width:98%" type="text" name="title" /></td>
</tr>
<tr><th>작성자</th>
	<td class="left">${login_info.name}</td>
</tr>
<tr><th>내용</th>
	<td><textarea title="내용" class="need" name="content" 
		style="width:99%; height:200px;" onKeyUp="javascript:fnChkByte(this,'2000')"></textarea><span id="byteInfo">0</span> /&nbsp2000자 </td>
</tr>

</table><br>
<a onclick="if( checkInput() ){ $('form').submit() }" class="btn-fill">저장</a>
<a onclick="location='list.no'" class="btn-empty">취소</a>
</form>
<script type="text/javascript" src="js/nullCheck.js"></script>
<script type="text/javascript">

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





