<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#popup-background{
	position:absolute;
	width: 100%; height: 100%;	left: 0;	top: 0;
/* 	background-color: #000; opacity: 0.2; */
	background-color: rgba(0,0,0,0.2);
 	display: none; 
}
#popup{
	position:absolute;
	width: 800px;	height: 600px;
	left: 50%;	top: 50%;	transform: translate(-50%, -50%);
	border: 3px solid #666;
 	display: none; 
}
#list-top{
	width: 85%;	padding: 20px 7.5%;
}
#list-top select{
	margin-right: 10px;	float: left; height: 28px;
}
#data-list table img {
	width: 100px; height: 100px;
}
#data-list table th {
width: 120px;
}
h3 {
 font-size: 21px;
 color: #ffffff;
}

</style>
</head>
<body>
<h3>관광지 조회를 할 수 있는 게시판입니다. <br> API를 이용하여 데이터를 불러왔습니다 :D</h3>
<a class="btn-fill" onclick="trip_sido()">지역별로 조회</a>
<!-- <a class="btn-fill" onclick="kangwondo_list_detail()">상세</a> -->
<div id="list-top" style="display:none;"></div>
<div id="data-list" 
style="margin:0 auto; padding-top: 20px;"></div>
<div id="popup-background" 
onclick="$('#popup, #popup-background').css('display', 'none')"></div>
<div id="popup"></div>

<script
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsrerDHJrp9Wu09Ij7MUELxCTPiYfxfBI">
</script>
<script type="text/javascript">
$(document).on('change', '#sido', function(){	
	trip_sigungu();
}).on('change', '#sigungu', function(){
	trip_list();
});
	


function trip_list_detail(){
	$('#list-top').css('display', 'none');
	$(item).each(function(idx, item){
		tag += '<td style="border-style: none; float:left; width:20%; height:250px; margin: 5px 13px;" colspan="2"><a onclick="trip_list_detail()" name="contentid" id="contentid" value="' + item.contentid + '"><img style="width:190px; height: 150px; margin: 0 auto;" src="'+ item.firstimage2 +'" /></a><br>'+ item.title +'</td>';
					item = item;
	$.ajax({
		type: 'post',
		data: { contentid: $('#contentid').val() },
		async:false,
		url: 'data/trip/detail',
		success: function(data){		
			var tag = "<table >"
			$(data).find('item').each(function(){
				tag += "<tr><th>명소</th>"
					+ "<td>"+ $(this).find('title').text() + "</td>"
					+ "</tr>";
				var xy = $(this).find('YPos').text() + ","
						+ $(this).find('XPos').text() + ","
						+ "'" + $(this).find('yadmNm').text() + "'" 
				tag += '<tr>'
					+ '<td colspan="2"><img style="width:80%; height:80%;" src="'+ $(this).find('firstimage2').text() +'" />'+ '</td>'
					+ '</tr>'
				+ '<tr><th>설명</th>'
				+ '<td>'+ $(this).find('overview').text() +'</td>'
				+ '</tr>'
				+ '<tr><th>주소</th>'
				+ '<td>'+ $(this).find('addr1').text() + $(this).find('addr2').text() +'</td>'
				+ '</tr>';
				
			});		
			tag += "</table>";
			
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);			
		}
					});
	});
	
}
var item = new Object(); 



function trip_list(){
	$('#data-list').html('');
	var list = new Object();
	list.sido = $('#sido').val();
	list.sigungu = $('#sigungu').length>0 ? $('#sigungu').val() : '';
	
	$.ajax({
		contentType: 'application/json; charset=utf-8',
		type: 'post',
		data: JSON.stringify(list), 
		async:false,
		url: 'data/trip/list',
		success: function(data){
			var tag = '<form name="testForm" id="testForm"><table style="width:85%">';
			if( data.length==0){
				tag += '<tr><td>해당 유기동물이 없습니다.</td></tr>';
			}else{
						
			$(data).each(function(idx, item){
tag += '<td style="border-style: none; float:left; width:20%; height:250px; margin: 5px 13px;" colspan="2"><a onclick="trip_list_detail()" name="contentid" id="contentid" value="' + item.contentid + '"><img style="width:190px; height: 150px; margin: 0 auto;" src="'+ item.firstimage2 +'" /></a><br>'+ item.title +'</td>';
			data = item.contentid;
			console.log(data);
			});
			}
			tag += '</form></table>';
			$('#data-list').html(tag);
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
	return item;
}

function trip_sigungu(){
	$('#data-list').html('');
	$('#list-top').find('#sigungu', '#shelter').remove();
	if( $('#sido').val()=='' ) return;
	$.ajax({
		url: 'data/trip/sigungu',
		data: { sido: $('#sido').val() },
		success: function(data){
			var tag = '<select id="sigungu" style="width:120px;">'
				+ '<option value="">시군구선택</option>';
			$(data).each(function(idx, item){
				tag += '<option value="'+ item.code + '">'
						+ item.name +'</option>';
			});				
			tag += '</select>';
			$('#list-top').find('#sido').after(tag);
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}
function trip_sido(){
	$('#data-list').html('');
	$('#list-top').css('display', 'block');
	
	$.ajax({
		url: 'data/trip/sido',
		success: function(data){
			var tag = '<select id="sido" style="width:130px">'
					+ '<option value="">시도선택</option>';
			$(data).find('item').each(function(){
				tag += '<option value="'+ $(this).find('code').text() + '">'
				+ $(this).find('name').text() + '</option>';
			});
			tag += '</select>';
			tag += '<a onclick="trip_list()" style="float:right" class="btn-fill">조회</a>'
			$('#list-top').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}


</script>
</body>
</html>