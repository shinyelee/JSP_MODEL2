<%@page import="java.util.HashMap"%>
<%@page import="vo.Md"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a, a:hover {
	color: #000000;
	text-decoration: none;
}

#listForm {
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

.div_empty{
	width: 100%;
	height: 100%;
	text-align: center;
}

#todayImageList {
	text-align: center;
}

#productImage {
	width: 150px;
	height: 150px;
	border: none;
}

#todayImage {
	width: 80px;
	height: 80px;
	border: none;
}
</style>
</head>
<body>
	<section id = "listForm">
		<c:if test="${mdList != null}">
		<h2>상품 목록  <a href="mdRegistForm.md">상품 등록</a></h2>
			<table>
				<tr>
					<c:forEach var="md" items="${mdList}" varStatus="status">
					<td><a href="mdView.md?mdid=${md.mdid}">
						<img src="images/${md.image}" id="productImage"/>
						</a>
						상품명 ${md.item}<br>
						가 격 ${md.price}<br>
					</td>
					<c:if test="${((status.index+1) mod 4) == 0}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		<c:if test="${mdList == null}">
			<div class="div_empty">
				<h2>등록된 상품이 없습니다</h2>
			</div>
		</c:if>
		<c:if test="${todayImageList != null }">
			<div id ="todayImageList">
				<h2>오늘 본 상품</h2>
				<table>
					<tr>
						<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
						<td>
							<img src="images/${todayImage}" id="todayImage"/>
						</td>
						<c:if test="${((status.index+1) mod 4) == 0}">
					</tr>
					<tr>
						</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</c:if>
	</section>
</body>
</html>