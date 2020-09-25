<!-- 삭제 요청 시 글의 비밀번호를 입력하는 화면을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int board_num=(Integer)request.getAttribute("board_num");
    String nowPage = (String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>MVC 게시판</title>
<style>

#passForm {
	width: 400px;
	margin: auto;
	border : 1px solid orange;
}
	
</style>
</head>
<body>
	<section id="passForm">
		<form name="deleteForm" action="boardDeletePro.bo?board_num=<%=board_num %>" method="post">
			<input type="hidden" name="page" value="<%=nowPage %>"/>
				<table>
				<tr>
					<td><label>글 비밀번호 : </label></td>
					<td><input name="BOARD_PASS" type="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="삭제"/>&nbsp;&nbsp; <input type="button" value="돌아가기" onClick="javascript:history.go(-1)"/></td>
				</tr>
		</table>
		</form>
	</section>
</body>
</html>