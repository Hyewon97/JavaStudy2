<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 에러가 발생하면 실행 페이지 -->
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>홈페이지 에러가 발생하였습니다. 클릭하시면 홈페이지로 이동합니다.</h1>
		<a href="<%=request.getContextPath()%>"><img src="../img/1.jpg"/></a>
		<h2>
			에러메세지 : <%= exception.getMessage() %>
		</h2>
	</div>
</body>
</html>