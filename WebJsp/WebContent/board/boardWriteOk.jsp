<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bitcamp.board.BoardDAO"%>

<!-- 게시판 입력폼에 입력한 데이터를 db에 저장-->
<!-- 폼데이터 request +vo 에 담는다.
	폼의 name속성값과 vo에 있는 멤버변수명이 같은데이터를 뽑아낸다.
-->
<!-- 
	BoardVO vo = new BoardVO();
	객체생성							생명주기  request, page, session, application
 -->
 <%
 	request.setCharacterEncoding("UTF-8");
 %>
 
<jsp:useBean id="vo" class="com.bitcamp.board.BoardVO" scope="page"/>
<jsp:setProperty name="vo" property="*"/>

<% 
	//session의 글쓰기 아이디를 vo에 대입한다.
	vo.setUserid((String)session.getAttribute("logId"));

	//글쓴이 아이피를 넣는다.
	vo.setIp(request.getRemoteAddr());
	
	BoardDAO dao = new BoardDAO();
	int result = dao.insertBoard(vo);
	
	if(result>0){//글등록
		response.sendRedirect(request.getContextPath()+ "/board/boardList.jsp");
	}else{//글등록실패
		%>
		<script>
			alert("글등록이 실패하였습니다.");
			history.back(): //history.go(-1);
		</script>
		<%
	}
%>