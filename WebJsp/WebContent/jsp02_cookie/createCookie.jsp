<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
    document.cookie = "food=pizza; path=/; expires=2021";
    document.cookie = "notice=test";

</script>
</head>
<body>
	<button onclick="location.href='/WebJsp/jsp02_cookie/cookieView.jsp'">쿠기 확인하러 가기</button>
</body>
</html>

<%
    //jsp에서 사용자 컴퓨터에 쿠키 저장하기
    //                     변수,데이터
    Cookie coo = new Cookie("userid","goguma");
    coo.setMaxAge(1*60); //쿠키 소멸 주기(초단위) 1년:365*24*60*60
    response.addCookie(coo);

%>