<!-- 수정글을 작성하는 화면을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.BoardBean"%>

<%	// 수정할 대상 글의 정보를 가지고 있는 article이라는 이름의 속성 값을 request 영역에서 얻어옴.
	// 이 속성 값은 BoardModifyFormAction 클래스의 request.setAttribute("article", article); 부분에서 공유된다.
	// 수정 데이터 작성 폼은 글 쓰기 작성 폼과 형태는 같지만 수정 폼에서는 이전에 등록된 글을 보여 주는 차이점이 있다.
	// 수정 데이터를 입력하는 각 입력 상자의 value 속성 값으로 등록되어 있는 정보들을 지정한다.
	BoardBean article = (BoardBean)request.getAttribute("article");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>QnA 게시판</title>
<script type="text/javascript">
function modifyboard() {
	modifyform.submit();
}
</script>
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

#fileInfoArea {
	border: 1px solid white;
	margin: auto;
	background: SeaShell;
	height: 24px;
	text-align: left;
}

#buttonList {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 등록 -->
	<section id="writeForm">
		<h2>글수정</h2>
		<form action="boardModifyPro.bo" method="post" name="modifyform">
			<input type="hidden" name="BOARD_NUM" value="<%=article.getBOARD_NUM() %>" />
			<table>
				<tr>
					<td class="td_center"><label for="BOARD_NAME">글쓴이</label></td>
					<td class="td_right"><input type="text" name="BOARD_NAME" id="BOARD_NAME" value="<%=article.getBOARD_NAME() %>" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_PASS">비밀번호</label></td>
					<td class="td_right"><input name="BOARD_PASS" type="password" id="BOARD_PASS" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" value="<%=article.getBOARD_SUBJECT() %>" /></td>
				</tr>
				<tr>
					<td class="td_center"><label for = "BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="50" rows="15"><%=article.getBOARD_CONTENT() %></textarea></td>
				</tr>
				<tr>
					<td class="td_center"><label for="BOARD_FILE">파일첨부</label></td>
					<td id="fileInfoArea">
						<%if(!(article.getBOARD_FILE() == null)) { %>
						<a href="file_down?downFile=<%=article.getBOARD_FILE() %>"><%=article.getBOARD_FILE() %></a>
						<%} %>
					</td>
				</tr>
			</table><br>
			<section id="buttonList">
				<input type="button" value="뒤로" onclick="history.back()">&nbsp;<input type="submit" value="수정">
			</section>
		</form>
	</section>
</body>
</html>