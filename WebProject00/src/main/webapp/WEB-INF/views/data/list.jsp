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
</style>
</head>
<body>
<h3>공공데이터 정보</h3>
<a class="btn-fill" onclick="pharmacy_list()">약국정보조회</a>
<a class="btn-fill" onclick="animal_sido()">유기동물조회</a>
<a class="btn-fill" onclick="car_list()">자동차조회</a>
<a class="btn-fill" onclick="kangwondo_sido()">지역코드조회</a>
<a class="btn-fill" onclick="kangwondo_list_detail()">상세</a>
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
	kangwondo_sigungu();
}).on('change', '#sigungu', function(){
	kangwondo_list();
});

function animal_kind(){
	$('#data-list').html('');
	$('#list-top').find('#kind').remove();
	if( $('#upkind').val()=='')return;
	$.ajax({
		data: { upkind: $('#upkind').val() },
		url: 'data/animal/kind',
		success: function(data){
			var tag = '<select id="kind" style="width:200px">'
				+'<option value="">품종선택</option>';
				$(data).each(function(idx, item){
					tag += '<option value="'+item.kindCd 
						+'">' + item.KNm +'</option>';
				});
			tag += '</select>';
			$('#list-top').find('#upkind').after(tag);
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}

function animal_shelter(){
	$('#data-list').html('');
	$('#list-top').find('#shelter').remove();
	if( $('#sigungu').val() =='') return;
	$.ajax({
		data: { sido: $('#sido').val(),
			  	sigungu: $('#sigungu').val() },
		url: 'data/animal/shelter',
		success: function(data){
			var tag = '<select id="shelter" style="width:200px">'
				+ '<option value="">보호소선택</option>';
			$(data).each(function(idx, item){
				tag += '<option value="'+ item.careRegNo +'">'
						+ item.careNm +'</option>';
			});
			tag += '</select>';
			$('#list-top').find('#sigungu').after(tag);
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}
function animal_type(){
	var tag = '<select id="upkind" style="width:90px">'
				+'<option value="">축종선택</option>'
				+'<option value="417000">개</option>'
				+'<option value="422400">고양이</option>'
				+'<option value="429900">기타</option>'
				+'</select>';
		$('#list-top').find('#sido').after(tag);
}
function animal_sigungu(){
	$('#data-list').html('');
	$('#list-top').find('#sigungu', '#shelter').remove();
	if( $('#sido').val()=='' ) return;
	$.ajax({
		url: 'data/animal/sigungu',
		data: { sido: $('#sido').val() },
		success: function(data){
			var tag = '<select id="sigungu" style="width:120px;">'
				+ '<option value="">시군구선택</option>';
			$(data).each(function(idx, item){
				tag += '<option value="'+ item.orgCd + '">'
						+ item.orgdownNm +'</option>';
			});				
			tag += '</select>';
			$('#list-top').find('#sido').after(tag);
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}
function animal_sido(){
	$('#data-list').html('');
	$('#list-top').css('display', 'block');
	
	$.ajax({
		url: 'data/animal/sido',
		success: function(data){
			var tag = '<select id="sido" style="width:130px">'
					+ '<option value="">시도선택</option>';
			$(data).find('item').each(function(){
				tag += '<option value="'+ $(this).find('orgCd').text() +'">'
				+ $(this).find('orgdownNm').text() +'</option>';
			});
			tag += '</select>';
			tag += '<a onclick=c" style="float:right" class="btn-fill">조회</a>'
			$('#list-top').html(tag);
			animal_type();
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}
function animal_list(){
	$('#data-list').html('');
	
	var animal = new Object();
	animal.sido = $('#sido').val();
	animal.sigungu = $('#sigungu').length>0 ? $('#sigungu').val() : '';
	animal.shelter = $('#shelter').length>0 
					? $('#shelter').val() : '';
	animal.upkind = $('#upkind').val();
	animal.kind = $('#kind').length>0 ? $('#kind').val():'';
	$.ajax({
		contentType: 'application/json; charset=utf-8',
		type: 'post',
		data: JSON.stringify(animal), 
		url: 'data/animal/list',
		success: function(data){
			console.log(data);
			var tag = '<table style="width:85%">';
			if( data.length==0){
				tag += '<tr><td>해당 유기동물이 없습니다.</td></tr>';
			}else{
						
			$(data).each(function(idx, item){
				//보호소를 선택한 경우는
				//보호소 정보를 따로 한 번만 출력
				if(animal.shelter != '' && idx==0 ){
					tag += '<tr><td>' + item.careNm +'</td>'
						+'<td>' + item.careAddr + '</td>'
						+'<td>' + item.careTel + '</td>'
						+'</tr></table>'
						+'<table style="width:85%"; margin-top:15px;>';
				}
				
tag += '<tr>'
+ '<td rowspan="3"><img src="'+ item.filename +'" /></td>'
+ '<th>성별</th><td>'+ item.sexCd +'</td>'
+ '<th>나이</th><td>' + item.age + '</td>'
+ '<th>체중</th><td>' + item.weight + '</td>'
+ '<th>색상</th><td>' + item.colorCd + '</td>'
+ '<th>접수일자</th><td>' + item.happenDt + '</td>'
+ '</tr>';

tag += '<tr><th>특징</th><td colspan="9" class="left">'+ item.specialMark + '</td></tr>'
+ '<tr><th>발견장소</th><td colspan="8" class="left">'+ item.happenPlace + '</td>'
+ '<td>'+ item.processState + '</td>'
+ '</tr>';
if( animal.shelter == ''){	
//유기동물보호소
tag += '<tr><td colspan="2">'+ item.careNm +'</td>'
+ '<td colspan="7" class="left">'+ item.careAddr +'</td>'
+ '<td colspan="2">'+ item.careTel +'</td>'
+ '</tr>';
}
			
			});
			}
			tag += '</table>';
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}

function pharmacy_list(){
	$('#list-top').css('display', 'none');
	$.ajax({
		url: 'data/pharmacy',
		success: function(data){
			var tag = "<table >"
					+ "<tr><th>약국명</th>"
					+ "<th>전화번호</th>"
					+ "<th>주소</th>"
					+ "</tr>";
			$(data).find('item').each(function(){
				var xy = $(this).find('YPos').text() + ","
						+ $(this).find('XPos').text() + ","
						+ "'" + $(this).find('yadmNm').text() + "'" 
				tag += '<tr>'
					+ '<td><a onclick="show_map('+ xy +')">'+ $(this).find('yadmNm').text() +'</a></td>'
					+ '<td>'+ $(this).find('telno').text() +'</td>'
					+ '<td class="left">'+ $(this).find('addr').text() +'</td>'
					+ '</tr>';
			});		
			tag += "</table>";
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);			
		}
	});
}
function show_map(lat, lon, name){
	$('#popup, #popup-background').css('display', 'block');
	var xy = {lat: lat, lng: lon};
	var map = new google.maps.Map(
		      document.getElementById('popup'), 
		      {zoom: 15, center: xy});
	var marker = new google.maps.Marker(
			 {position: xy, map: map, title: name});
}


function kangwondo_list(){
	$('#data-list').html('');
	
	var kangwondo = new Object();
	kangwondo.sido = $('#sido').val();
	kangwondo.sigungu = $('#sigungu').length>0 ? $('#sigungu').val() : '';
	
	$.ajax({
		contentType: 'application/json; charset=utf-8',
		type: 'post',
		data: JSON.stringify(kangwondo), 
		url: 'data/kangwondo/list',
		success: function(data){
			console.log(data);
			var tag = '<table style="width:85%">';
			if( data.length==0){
				tag += '<tr><td>해당 유기동물이 없습니다.</td></tr>';
			}else{
						
			$(data).each(function(idx, item){
tag += '<td style="border-style: none; float:left; width:20%; height:250px; margin: 5px 13px;" colspan="2"><img style="width:190px; height: 150px; margin: 0 auto;" src="'+ item.firstimage2 +'" /><br>'+ item.title +'</td>';
								
				
/* tag += '<tr>'
+ '<td rowspan="3"><img src="'+ item.filename +'" /></td>'
+ '<th>성별</th><td>'+ item.sexCd +'</td>'
+ '<th>나이</th><td>' + item.age + '</td>'
+ '<th>체중</th><td>' + item.weight + '</td>'
+ '<th>색상</th><td>' + item.colorCd + '</td>'
+ '<th>접수일자</th><td>' + item.happenDt + '</td>'
+ '</tr>';

tag += '<tr><th>특징</th><td colspan="9" class="left">'+ item.specialMark + '</td></tr>'
+ '<tr><th>발견장소</th><td colspan="8" class="left">'+ item.happenPlace + '</td>'
+ '<td>'+ item.processState + '</td>'
+ '</tr>'; */

			
			});
			}
			tag += '</table>';
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}

function kangwondo_sigungu(){
	$('#data-list').html('');
	$('#list-top').find('#sigungu', '#shelter').remove();
	if( $('#sido').val()=='' ) return;
	$.ajax({
		url: 'data/kangwondo/sigungu',
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
function kangwondo_sido(){
	$('#data-list').html('');
	$('#list-top').css('display', 'block');
	
	$.ajax({
		url: 'data/kangwondo/sido',
		success: function(data){
			var tag = '<select id="sido" style="width:130px">'
					+ '<option value="">시도선택</option>';
			$(data).find('item').each(function(){
				tag += '<option value="'+ $(this).find('code').text() + '">'
				+ $(this).find('name').text() + '</option>';
			});
			tag += '</select>';
			tag += '<a onclick="kangwondo_list()" style="float:right" class="btn-fill">조회</a>'
			$('#list-top').html(tag);
			 kangwondo_sigungu();
		},error: function(req, text){
			alert(text+":"+req.status);
		}
	});
}
function kangwondo_list_detail(){
	$('#list-top').css('display', 'none');
	$.ajax({
		url: 'data/kangwondo/detail',
		success: function(data){
			console.log(data);
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
			console.log(data);
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);			
		}
	});
}
//자동차조회
function car_list(){
	$('#list-top').css('display', 'none');
	$.ajax({
		url: 'data/kangwondo',
		success: function(data){
			var tag = "<table style='width:80%; border-style: none;'>"
				
			$(data).find('item').each(function(){
				tag += '<td style="border-style: none; float:left; width:20%; height:250px; margin: 5px 13px;" colspan="2"><img style="width:190px; height: 150px; margin: 0 auto;" src="'+ $(this).find('firstimage').text() +'" /><br>'+ $(this).find('title').text() +'</td>';
				
			});		
			tag += "</table>";
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);			
		}
	});
}
function show_map(lat, lon, name){
	$('#popup, #popup-background').css('display', 'block');
	var xy = {lat: lat, lng: lon};
	var map = new google.maps.Map(
		      document.getElementById('popup'), 
		      {zoom: 15, center: xy});
	var marker = new google.maps.Marker(
			 {position: xy, map: map, title: name});
}
</script>
</body>
</html>