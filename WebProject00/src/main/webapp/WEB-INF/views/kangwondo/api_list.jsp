<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>강원도 관광정보</h3>
<div style="float: right;">
	<a class="btn-fill" onclick="location='new.kangwondo'">글쓰기</a>
	<a class="btn-fill" onclick="car_list()">자동차조회</a>
	<div id="list-top" style="display:none;"></div>
<div id="data-list" 
style="margin:0 auto; padding-top: 20px;"></div>
</div>
</body>
<script>
function car_list(){
	$('#list-top').css('display', 'none');
	$.ajax({
		url: 'data/kangwondo',
		success: function(data){
			var tag = "<table>"
					+ "<tr><th>1</th>"
					+ "<th>2</th>"
					+ "<th>3</th>"
					+ "</tr>";
			$(data).find('item').each(function(){
				var xy = $(this).find('address').text() + ","
						+ $(this).find('address').text() + ","
						+ "'" + $(this).find('address').text() + "'" 
				tag += '<tr>'
					+ '<td>'+ $(this).find('address').text() +'</a></td>'
					+ '<td>'+ $(this).find('address').text() +'</td>'
					+ '<td class="left">'+ $(this).find('address').text() +'</td>'
					+ '</tr>';
			});		
			tag += "</table>";
			$('#data-list').html(tag);
			
		},error: function(req, text){
			alert(text+":"+req.status);			
		}
	});
}
</script>
</html>