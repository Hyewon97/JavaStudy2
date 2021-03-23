<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//1. db연결
	// 	 context객체 생성
	Context ctx = new InitialContext();
	Context envCtx = (Context)ctx.lookup("java:comp/env");
	//	 DataSource 객체 
	DataSource ds = (DataSource)envCtx.lookup("jdbc/myoracle");
	
	Connection conn = ds.getConnection();
	
	String sql="select no, subject, userid, hit, writedate from board order by no desc";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style>
	ul, li{margin:0; padding:0; list-style-type:none}
	li{float:left; height:40px; line-height:40px; width:10%;}
	li:nth-chil(5n+2){width:60%;}
	
	.wordCut{white-space:no-wrap; overflow:hidden; text-overflow:ellipsis;}
</style>
</head>
<body>
	<div class="container">
		<H1>게시판 목록</H1>
		<ul>
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>
			
			<%while(rs.next()){ %>
			<li><%=rs.getInt(1) %></li>
			<li class="wordCut"><%=rs.getString(2) %></li>
			<li><%=rs.getString(3) %></li>
			<li><%=rs.getInt(4) %></li>
			<li class="wordCut"><%=rs.getString(5) %></li>
			<%} 
				try{
					rs.close();
					pstmt.close();
					conn.close();
				}catch(Exception e){
					System.out.println("db닫기 실패 -->" + e.getMessage());
				}
			%>
		</ul>
	</div>
</body>
</html>

<!-- 
		DBCP(커넥션 풀: DataBase connection pool)
		
		1)프레임 워크 준비하기
		http://commons.apache.org
		1) pool - commons-pool2-2.9.0-bin.zip
		2) dbcp - commons-dbcp2-2.8.0-bin.zips
		3) collections - commons-collections4-4.4-bin.zip
		
		2.oracle.com에서  ojdbc8.jar를 다운로드
		
		3. 이클립스의 WEB-INF/lib복사, 톰캣의 lib에다가 복사
		commons-dbcp2-2.8.0.jar
		commons-collections4-4.4.jar
		commons-pool2-2.9.0.jar
		
		4.환경변수에 classpath설정
		ojdbc8.jar
		commons-dbcp2.8.0.jar
		commos-collections4-4.4.jar
		coomons-pool .jar
		
		5. 톰켓서버의 conf/server.xml의 <GlobalNamingResources>사이에 추가
		
		<Resource
		name="jdbc/myoracle"
		auto="Container"
		type="javax.sql.DataSource"
		driverClassName="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe"
		username="c##scott"
		password="tiger"
		maxActive="20"
		maxIdle="10"
		maxWait="-1"/>
		
		6. 톰캣서버의 conf/context.xml내에 추가하기
		
		<Context reloadable="true">
			<ResourceLink
				global="jdbc/myoracle"
				name="jdbc/myoracle"
				type="javax.sql.DataSource"
			/>
			
		7. 이클립스의 WEB-INF/web.xml파일의 <web-app>태그에 추가
		
		<resource-ref>
	  		<description>Oracle Datasource example</description>
	  		<res-ref-name>jdbc/myoracle</res-ref-name>
	  		<res-type>javax.sql.DataSource</res-type>
	  		<res-auth>Container</res-auth>
  		</resource-ref>
		
		8. 톰캣서버에 conf/context.xml 파일을 이클립스의 META-INF에 복사한다.
			conf/server.xml에 입력된 <Resource>를 복사하여 이클립스의 META_INF/context.xml에 추가한다.
 -->