..<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>alert("로그아웃 완료");</script>
	
	<% session.invalidate(); %>
	
	<%@ include file="/index.html" %>

</body>
</html>