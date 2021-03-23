<!-- 지시부 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.Calendar, java.util.Scanner" %>
<%@ page import ="java.util.Random" %>
<%@ page trimDirectiveWhitespaces="true" %> <!-- jsp 빈자리 삭제 -->
<%! //선언부
	//메소드 또는 변수선언
	public int sum(int a, int b){ //지역변수가 됨
		int total = a+b;
		return total;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		background-color: pink;
	}
</style>
<script>
	//document.write("javaScript...")
</script>
</head>
<body>
<%@ include file="jsp04_include/jspf_header.jspf" %>
<h2>session.ID : <%= session.getId() %></h2>
	<h1>jsp start!!!</h1>
	<!-- jsp 영역 > java 영역이 된다. 서버에서만 실행됨 out 통한 데이터만 보냄 jsp소스는 보여지지 않는다.
	 	jsp > tomcat이 바꿔줌 > servlet(java) : class랑 java file이 생성
	 -->
	<%
		//calendar 객체 사용하기 > utile에 있기 때문에 import가 필요하다. 위(지시부)에서 import
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		
	%>
	<h1>오늘은 <%=year %>년 <%=month %>월 <%=day %>일 입니다.</h1>
	<hr/>
	<h1>jstl태그</h1>
	<!-- 
		http://archive.apache.org/dist/jakarta/taglibs/standard에서
		jakarta-taglibs-standard-1.1.2.zip을 다운로드후
		
		현재 프로젝트 WEB-INF/lib에
		jstl.jar, standard.jar를 복사한다.
	 -->
	<ol>
		<li><a href="jstl/jstl01_setTag.jsp">set Tag : 변수의 선언 및 삭제</a></li>
		<li><a href="jstl/jstl02_ifTap.jsp?name=이순신&age=28">if Tag : 조건문</a></li>
		<li><a href="jstl/jstl03_forEachTag.jsp">forEach Tag : 반복문</a></li>
		<li><a href="jstl/jstl04_forTokensTag.jsp">forTokens Tag : 문자열 조각내기</a></li>
		<li><a href="jstl/jstl05_urlTag.jsp">url Tag</a></li>
		<li><a href="jstl/jstl06_chooseTag.jsp?username=홍길동2&age=15">choose태그 : if~else문 , switch문</a></li>
		<li><a href="jstl/jstl07_redirectTag.jsp">redirectTag태그 : url주소로 보내기 </a></li>
		<li>많이쓰는jstl문 :  if문, for문, </li>
	</ol>
	
	<hr/>
	<% //스크립트릿 
		int a = 1234;
		int b = 5678;
		String name = "gil-dong hong";
		out.write(name); //out 내장객체 > 사용자(클라이언트)에게 데이터를 보냄(response)
		int result = sum(b, a);
		out.write("<br/>result = "+result);
		out.write("<br/>"+a+"+"+b+"="+sum(a, b));
	%>
	
	<br/>
	<!-- 단순 출력과 단순계산은 아래와 같은 방법으로 가능 
		 이때, %랑 =은 붙어있어야 한다.
	-->
	<%= a %>,
	<%= a+4 %>, 
	<%=b %>, 
	<%=sum(a,b) %>
	
	<hr/>
	<%
		out.write("<h1>jsp에서 문자로 테그 입력하는 중...</h1>");
		out.write("<img src='img/img1.jpg'/>");
	%>
</body>
</html>

<!--
	jsp의 내장객체들...form tag(submit)에서 데이터를 받아옴(받아 오기 전에 js, jq에서 유효성 검사 후)
	
		- request : 서버에서 클라이언트의 정보를 받아옴 (form, client IP, file, path, ...) > form tag, a tag를 통해서 가져 올 수 있음 > DB검색 
		
		- response
		
		- session
		
		- cookie
		
		- error


-->