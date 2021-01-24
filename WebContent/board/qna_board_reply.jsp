<!-- 답변글을 작성하는 화면을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.BoardBean"%>

<%	// 답변할 대상 글에 대한 정보를 가진 request 영역에 article이라는 이름으로 공유되어 있는 속성값을 BoardBean 클래스 타입으로 얻어옴.
	// 이 속성은 BoardReplyFormAction 클래스의 request.setAttribute("article", article);에서 공유된다.
	// 새글 작성하는 화면과 답글을 작성하는 화면의 형태는 동일하지만 답글을 작성할 때는 답글을 달 대상 글의 정보가 요청에 전송된다는 차이점이 있다.
	BoardBean article=(BoardBean)request.getAttribute("article");
	// 답변을 달 대상 글이 존재하던 페이지 번호를 request 영역에서 얻어옴.
	// 이 속성은 BoardReplyFormAction 클래스의 request.setAttribute("page", nowPage); 부분에서 공유된다.
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>QnA 게시판</title>
<style type="text/css">
a, a:hover {
	color: #000000;
	text-decoration: none;
}
		
#writeForm {
	width: 500px;
	height: 500px;
	border: 1px solid gray;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_center {
	text-align: center;
	width: 150px;
	background: LightBlue;
}

.td_right {
	width: 350px;
	background: SeaShell;
}

#buttonList {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 답변 -->
	<section id="writeForm">
		<h2>답변글쓰기</h2>
		<form action="boardReplyPro.bo" method="post" name="boardform">
			<!-- 답변을 달 대상 글의 정보를 hidden 타입의 입력상자의 value 속성으로 설정하여 답변하기 요청의 파라미터 값으로 전송. -->
			<input type="hidden" name="page" value="<%=nowPage %>" />
			<input type="hidden" name="BOARD_NUM" value="<%=article.getBOARD_NUM() %>">
			<input type="hidden" name="BOARD_RE_REF" value="<%=article.getBOARD_RE_REF() %>">
			<input type="hidden" name="BOARD_RE_LEV" value="<%=article.getBOARD_RE_LEV() %>">
			<input type="hidden" name="BOARD_RE_SEQ" value="<%=article.getBOARD_RE_SEQ() %>">
			<table>
				<tr>
					<td class="td_center"><label for="BOARD_NAME">글쓴이</label></td>
					<td class="td_right"><input type="text" name="BOARD_NAME" id="BOARD_NAME" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_PASS">비밀번호</label></td>
					<td class="td_right"><input name="BOARD_PASS" type="password" id="BOARD_PASS" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="50" rows="15"></textarea></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_FILE">파일첨부</label></td>
					<td class="td_right"><input name="BOARD_FILE" type="file" id="BOARD_FILE" /></td>
				</tr>
			</table><br>
			<section id="buttonList">
				<input type="button" value="뒤로" onclick="history.back()">&nbsp;<input type="submit" value="등록">
			</section>
		</form>
	</section>
</body>
</html>