<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ page import ="java.util.Calendar, java.util.Scanner" %>
<%@ page import = "java.util.Random" %>
<%@ page trimDirectiveWhitespaces="true" %><!-- jsp 코드 삭제(빈칸삭제) -->
<%!
	//선언부
	//메소드 또는 변수 선언
    public int sum(int a, int b){
	   	int hap = a + b;
	   	return hap;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{background-color : pink;}
</style>
</head>
<body>
<h1>JSP START....</h1>
<%
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);//년
	int month = now.get(Calendar.MONTH)+1; //월
	int day = now.get(Calendar.DAY_OF_MONTH); //일
%>
<h1>오늘은 <%= year %>년 <%=month %>월 <%=day %>일 입니다.</h1>
<hr/>
<%  //스크립틀릿
    int a = 100;
	int b = 4123;
    String name ="홍길동";
    //out내장객체 : client에게 정보를 보냄(response)
    out.write(name);
    int result = sum(a, b);
    out.write("<br/>result = " + result);
    out.write("<br>"+a + "+ " + b+ "=" + sum(a,b));

%>

<br>
<%= a+4 %>-
<%= b %>=
<%= sum(a,b) %>


<hr/>
<%
    out.write("<h1>AAAAAAA</h1>");
    out.write("<img src='img/001.png'");
%>
</body>
</html>