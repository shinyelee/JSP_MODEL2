<!-- 인덱스 페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<!-- 게시판 -->
	<a href="boardList.bo">게시판</a>
	
	<!-- 쇼핑몰 -->
	<a href="mdList.md">MD샵</a>
	
	<!-- 로그인/로그아웃 -->
<%	// 현재 세션 영역에 "id"라는 이름으로 저장돼 있는 속성 값을 얻어옴.
	String id = (String)session.getAttribute("id");
	// 현재 세션 영역에 "id"라는 이름의 속성 값이 저장이 안 돼 있으면(=로그아웃 상태) "로그인" 링크 출력.
	if(id != null) {
%>
	<a href="logout">로그아웃</a>
<%
	} // "id"라는 이름의 속성 값이 저장되어 있으면(=로그인 상태) "로그아웃" 링크 출력.
	else {
%>
	<a href="loginForm.html">로그인</a>
<%
	}
%>

</body>
</html>