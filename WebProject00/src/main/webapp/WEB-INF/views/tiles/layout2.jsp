<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정다슬사이트</title>
<link rel="icon" type="imga/x-icon" href="img/hanul.ico">
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%= new java.util.Date().getTime()%>">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>


</body>
</html>