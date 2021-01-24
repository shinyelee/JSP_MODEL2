<!-- 글을 새로 작성하는 화면을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>QnA 게시판</title>
<style type="text/css">
/* 글쓰기 폼 영역의 스타일을 정의. */
#registForm {
	width: 500px;
	height: 610px;
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

/* 글쓰기 테이블 셀에 적용될 스타일을 지정. */
.td_left {
	width: 150px;
	background: LightBlue;
}

.td_right {
	width: 300px;
	background: SeaShell;
}

/* 등록 버튼이나 다시쓰기 버튼이 출력되는 영역의 스타일을 지정. */
#commandCell {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판글등록. -->
	<section id="writeForm">
		<h2>글쓰기</h2>
		<!-- 게시판 글 등록 시 파일업로드 기능도 처리하므로 enctype="multipart/form-data" 부분을 지정. 이 entype 속성이 지정되어야 업로드하는 파일이 서버로 제대로 전송된다. -->
		<form action="boardWritePro.bo" method="post" enctype="multipart/form-data" name="boardform">
			<!-- 각 입력상자마다 label 태그를 사용하여 레이블을 클릭할 때 레이블에 해당하는 데이터를 입력하는 입력상자로 커서가 이동하게 처리. -->
			<!-- required 속성이 주어진 입력 상자에 아무 값도 입력하지 않고 등록 버튼을 클릭하면 요청이 전송되지 않게 처리. -->
			<table>
				<tr>
					<td class="td_left"><label for="BOARD_NAME">글쓴이</label></td>
					<td class="td_right"><input type="text" name="BOARD_NAME" id="BOARD_NAME" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_PASS">비밀번호</label></td>
					<td class="td_right"><input name="BOARD_PASS" type="password" id="BOARD_PASS" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="40" rows="15" required="required"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_FILE">파일첨부</label></td>
					<td class="td_right"><input name="BOARD_FILE" type="file" id="BOARD_FILE" /></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input type="reset" value="다시쓰기" />
			</section>
		</form>
	</section>
</body>
</html>