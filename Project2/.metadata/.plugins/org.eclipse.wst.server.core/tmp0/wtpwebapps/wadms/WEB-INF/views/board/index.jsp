<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<html>
<head>
<title>Index</title>
</head>
<link href="/resources/css/index.css" rel="stylesheet">
<style>
th, td {
  text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		//업체별 현장리스트를 불러온다.
		$(document).on( 'change', '#company', function() {
			$.ajax({
				type : 'post',
				data : {
					comapany_no : $(this).val()
				},
				dataType : 'json',
				async : false,
				url : '/siteList',
				//contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
				success : function(data) {
					
					$("#site option").remove();
					$("#site").append("<option value=\"\" >현장명</option>");
					$(data).each(function(index) {
						$("#site").append( "<option value=\""+data[index].site_no+"\">" + data[index].site_name + "</option>");
					});
				},
				error : function(req, text) {
					alert(text + ":" + req.status);
				}
			});
		});
		//현장별 팀리스트를 불러온다.
		$(document).on( 'change', '#site', function() {
			$.ajax({
				type : 'post',
				data : {
					site_no : $(this).val()
				},
				dataType : 'json',
				async : false,
				url : '/teamList',
				success : function(data) {
					$("#team option").remove();
					$("#team").append("<option value=\"\" >팀명</option>");
					for (var i = 0; i < data.length; i++) {
						$("#team").append( "<option value=\""+data[i].team_no+"\">" + data[i].team_name + "</option>");
					}
				},
				error : function(req, text) {
					alert(text + ":" + req.status);
				}
			});
		});

		$("#boardSubmit").on("click",function(){
			
			if(!$("#company option:selected").val()){
				alert("업체를 선택해 주세요.");
				return false;
			}else if (!$("#site option:selected").val()){
				alert("현장을 선택해 주세요.");
				return false;
			}else if (!$("#team option:selected").val()){
				alert("팀을 선택해 주세요.");
				return false;
			}else if(!$("#startDt").val()){
				alert("근무시작일을 입력해주세요.");
				return false;
			}else if(!$("#endDt").val()){
				alert("근무 종료일을 입력해주세요.");
				return false;
			}else if(!$("#searchType option:selected").val()){
				alert("검색 조건을 선택해 주세요.");
				return false;
			}else if(!$("#searchText").val()){
				alert("검색조건의 텍스트를 입력해주세요.");
				return false;
			}else{
				$("#search").append("<input type='hidden' name='companyName' value='"+$("#company option:selected").text()+"'>");
				$("#search").append("<input type='hidden' name='siteName' value='"+$("#site option:selected").text()+"'>");
				
				$("#search").submit();
			}

		});
	
	});
	
</script>
<body>
	<form id="search" action="/list" method="post">
		<select id="company" name="company_no">
			<option id = "optionCompany" value=""  ${empty baseInfo.company_no ? "selected" : ""}>업체명</option>
			<c:forEach items="${company_list}" var="boardVO">
				<option id = "optionCompany"  value="${boardVO.company_no}" ${baseInfo.company_no == boardVO.company_no ? "selected" : "" } >
					${boardVO.company_name}
				</option>
			</c:forEach>
		</select> 
		<select id="site" name="site_no">
			<option value=""  ${empty baseInfo.site_no ? 'selected' : ''}>현장명</option>
			<c:if test="${siteList != null}">
				<c:forEach items="${siteList}" var="siteList">
					<option value="${siteList.site_no}"  ${siteList.site_no == baseInfo.site_no ? 'selected' : ''}>${siteList.site_name}</option>
				</c:forEach>
			</c:if>
		</select> 
		<select id="team" name="team_no">
			<option id = "optionTeam" value="" ${empty baseInfo.team_no ? 'selected' : ''}>팀명</option>
			<c:if test="${teamList != null}">
				<c:forEach items="${teamList}" var="teamList">
					<option value="${teamList.team_no}" ${teamList.team_no == baseInfo.team_no ? 'selected' : ''}>${teamList.team_name}</option>
				</c:forEach>
			</c:if>
		</select> 
		근무시작일 : <input id="startDt" type="text" name="startDt" value="${baseInfo.startDt}"/>
		근무종료일 : <input id="endDt" type="text" name="endDt" value="${baseInfo.endDt}" /> 
		
		
		<select id="searchType" name="searchType">
			<option value="">검색조건</option>
			<option value="1" ${ baseInfo.searchType == "1" ? 'selected' : ''}>등록번호</option>
			<option value="2" ${ baseInfo.searchType == "2" ? 'selected' : ''}>근로자명</option>
		</select>
		<input id="searchText" type="text" name="searchText" value="${baseInfo.searchText}" />
		
		<a id="boardSubmit" class="btn" href=#NONE" >검색</a>
		<table>
			<thead>
				<tr>
					<th>업체명</th>
					<th>현장명</th>
				</tr>
			</thead>

			<tr>
				<td>${baseInfo.company_name}</td>
				<td>${baseInfo.site_name}</td>
			</tr>

		</table>

		<p
			style="width: 90%; text-align: left; margin-left: 100px; margin-top: 30px;">*검색기간
			: ${baseInfo.startDt} ~ ${baseInfo.endDt}</p>

		<table>
			<thead>
				<tr>
					<th>No</th>
					<th>날짜</th>
					<th>팀명</th>
					<th>등록번호</th>
					<th>근로자명</th>
					<th>출근시간</th>
					<th>퇴근시간</th>
					<th>출근사진</th>
					<th>퇴근사진</th>
				</tr>
			</thead>
			<c:forEach items="${search_list}" var="boardVO">
				<tr>
					<td></td>
					<td>
					<fmt:formatDate value="${boardVO.attendance_day}" pattern="yyyy-MM-dd"/>
					</td>
					<td>${boardVO.team_name}</td>
					<td>${boardVO.badgenumber}</td>
					<td>${boardVO.name}</td>
					<td>${boardVO.startTime}</td>
					<td>${boardVO.endTime}</td>
					<td><img width="240" height= "320" src="http://192.168.0.25${boardVO.startTimePhoto}"/></td>
					<td><img width="240" height= "320" src="http://192.168.0.25${boardVO.endTimePhoto}"/></td>
				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>
