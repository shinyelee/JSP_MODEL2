<!-- 특정 게시판 글 하나의 상세정보를 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="vo.BoardBean"%>

<%	// 글 하나에 대한 상세 정보를 저장하고 있는 request 영역에 공유되어 있는 article이라는 이름의 속성 값을 BoardBean 클래스 타입으로 얻어옴.
	BoardBean article = (BoardBean)request.getAttribute("article");
	// request 영역에 공유되어 잇는 혀재 페이지 번호를 저장하고 있는 page 속성 값을 얻어옴.
	// 이 속성은 BoardDetailAction 클래스의 request.setAttribute("page",page); 부분에서 공유된다.
	// 이 page 값은 답변하기, 삭제하기 요청을 할 때 요청의 파라미터로 전송하여 요청 처리가 끝난 후 목록 보기 페이지로 되돌아갈 때 원래 보던 페이지로 되돌아 갈 수 있게 처리하기 위해서 얻어옴.
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>MVC 게시판</title>
<style type="text/css">
#articleForm {
	width: 500px;
	height: 500px;
	border: 1px solid gray;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	height: 40px;
	text-align: center;
}

#articleContentArea {
	background: LightBlue;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<!-- 해당 게시판 글의 기본 데이터를 출력하는 영역이다. 글 내용 부분은 내용이 많아질 수 있으므로 별도의 섹션을 구분하여 출력한다. -->
		<section id="basicInfoArea">
			제 목 :
			<%=article.getBOARD_SUBJECT() %>
			첨부파일 :
			<%if(!(article.getBOARD_FILE() == null)) { %>
			<a href="file_down?downFile=<%=article.getBOARD_FILE() %>"><%=article.getBOARD_FILE() %></a>
			<%} %>
		</section>
		<!-- 이 부분은 스타일시트에서 overflow: auto; 속성을 지정하여 지정한 영역의 크기 이상이 출력되면 스크롤 처리하였다. -->
		<section id="articleContentArea">
			<%=article.getBOARD_CONTENT() %>
		</section>
	</section>
	<section id="commandList">
		<!-- 답변 요청을 링크. 파라미터로 답변할 대상 글의 번호와 페이지 번호를 전송한다. -->
		<a href="boardReplyForm.bo?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">[답변]</a>
		<!-- 수정 요청을 링크. 수정 처리 대상이 되는 글의 번호를 파라미터 값으로 전송한다. -->
		<a href="boardModifyForm.bo?board_num=<%=article.getBOARD_NUM() %>">[수정]</a>
		<!-- 삭제 요청을 링크. 삭제할 글의 번호와 현재 페이지 번호를 파라미터 값으로 전송한다. -->
		<a href="boardDeleteForm.bo?board_num=<%=article.getBOARD_NUM() %>&page=<%=nowPage%>">[삭제]</a>
		<!-- 목록 요청을 링크. -->
		<a href="boardList.bo?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>