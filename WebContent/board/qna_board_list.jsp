<!-- 전체 게시판 글목록을 보여주는 뷰페이지. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="vo.BoardBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%	// request 영역에 articleList라는 이름으로 공유되어 있는 속성 값을 ArrayList 타입으로 얻어옴.
	// 이 articleList 객체는 BoardListAction 클래스의 request.setAttribute("articleList",articleList); 부분에서 공유된 것이다.
	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>) request.getAttribute("articleList");
	// request 영역에 pageInfo라는 이름으로 공유되어 있는 페이징 처리 관련 정보를 PageInfo 타입으로 얻어옴.
	// 이 페이징 처리 관련 정보는 BoardListAction의 request.setAttribute("pageInfo",pageInfo); 부분에서 공유된 것이다.
    PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	// 페이징 처리관련 정보를 코드에서 사용하기 편하게 각 변수에 저장.
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>

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
	background: SeaShell;
}

#tr_top {
	background: LightBlue;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>
<body>
	<!-- 게시판 리스트. -->
	<section id="listForm">
		<!-- 글 목록 보기 페이지에서 새로운 글을 등록할 수 있는 요청을 링크. -->
		<h2>글 목록<a href="boardWriteForm.bo">게시판글쓰기</a></h2>
		<table>
		<!-- articleList라는 이름의 속성이 request 영역에 제대로 공유되어 있고, 해당 ArrayList 객체에 요소가 하나라도 있으면 글 목록을 보여 주는 조건문. -->
		<%if (articleList != null && listCount > 0) { %>
			<tr id="tr_top">
				<!-- 출력되는 게시판 글 목록의 각 데이터들의 제목을 출력. 각 데이터의 제목은 상단에 한 번만 출력되면 되기 때문에 for문에 처리하지 않고 for문 밖에서 처리. -->
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<!-- 존재하는 게시판 글 만큼 반복하면서 각 게시판 글의 정보를 출력. -->
			<%for (int i = 0; i < articleList.size(); i++) { %>
			<tr>
					<!-- 게시판 글 번호를 출력. -->
				<td><%=articleList.get(i).getBOARD_NUM() %></td>
					<!-- articleList.get(i).getBOARD_RE_LEV()!=0 조건을 만족할 때 즉, 해당 글이 답변 글일 경우 -->
					<!-- articleList.get(i).getBOARD_RE_LEV()*2 개수만큼 스페이스바를 출력해서 들여쓰기 처리. -->
				<td><%if (articleList.get(i).getBOARD_RE_LEV() != 0) { %>
						<%for (int a = 0; a <= articleList.get(i).getBOARD_RE_LEV() * 2; a++) { %>&nbsp; 
						<%} %> ▶ 
					<!-- 답글이 아닌 경우는 들여쓰기를 처리하지 않고 ▶를 바로 출력. -->
					<%} else { %> ▶ 
					<%} %>
					<!-- 글제목을 출력하면서 해당 글의 제목을 클릭했을 때 글 내용 상세보기 요청을 할 수 있도록 링크. -->
					<!-- 링크를 클릭했을 때 선택된 글 내용을 보여주어야 하기 때문에 파라미터로 글 번호를 전송하며 -->
					<!-- 글 내용을 본 후 목록 보기로 돌아갈 때 원래 보던 페이지로 돌아가야 하기 때문에 페이지 번호도 같이 파라미터로 전송한다. -->
					<a href="boardDetail.bo?board_num=<%=articleList.get(i).getBOARD_NUM() %>&page=<%=nowPage %>">
					<%=articleList.get(i).getBOARD_SUBJECT() %></a></td>
					<!-- 각각 작성자 이름, 작성일, 조회수를 출력. -->
				<td><%=articleList.get(i).getBOARD_NAME() %></td>
				<td><%=articleList.get(i).getBOARD_DATE() %></td>
				<td><%=articleList.get(i).getBOARD_READCOUNT() %></td>
			</tr>
			<%} %>
		</table>
	</section>

	<!-- 페이징 처리를 위해서 페이지 번호를 출력. -->
	<section id="pageList">
		<!-- 현재 페이지 번호가 1페이지 보다 작거나 같으면 즉, 이전 페이지가 존재하지 않으면 이전 문자열을 링크하지 않음. -->
		<%if (nowPage <= 1) { %>
		[이전]&nbsp;
		<!-- 이전 페이지가 존재하면 이전 페이지로 이동할 수 있도록 이전 문자열을 링크 걸어줌. -->
		<%} else { %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
		<%} %>
		
		<!-- 페이지 리스트에 출력될 처음 페이지에서 마지막 페이지까지의 페이지 번호를 출력. -->
		<%for (int a = startPage; a <= endPage; a++) {
			// 페이지 번호로 출력될 번호가 현재 목록 보기 화면에 출력된 페이지 번호와 같지 않으면 페이지 번호를 강조하지 않고 출력.
			if (a == nowPage) { %>
		[<%=a %>]
		<%} else { %>
		
		<a href="boardList.bo?page=<%=a %>">[<%=a %>]
		</a>&nbsp;
			<%} %>
		<%} %>
		<!-- 현재 출력될 페이지 번호가 마지막 페이지 번호보다 크거나 같으면 즉, 다음 페이지가 존재하지 않으면 다음 문자열을 링크하지 않음. -->
		<%if (nowPage >= maxPage) { %>
		[다음]
		<!-- 현재 페이지 번호가 마지막 페이지 번호보다 작으면 다음 문자열을 링크해서 클릭하면 다음 페이지로 이동하게 처리. -->
		<%} else { %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
		<%} %>
	</section>
	<%} else { %>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%} %>
</body>
</html>