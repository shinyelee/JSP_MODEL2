<!-- 상품 목록을 출력해주는 jsp 페이지 -->
<%@page import="java.util.HashMap"%>
<%@page import="vo.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL core 파트의 기능을 하용하기 위해 커스텀 태그의 접두사를 지정. -->
<!-- core 파트의 태그를 사용하려면 c 접두사로 시작하면 됨. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 스타일 정의 태그. -->
<style type="text/css">
	#listForm{
		width:500px;
		height:610px;
		border:1px solid gray;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:450px;
	}

	.div_empty{
		background-color:LightBlue;
		width: 100%;
		height: 100%;
		text-align: center;
	}

	#todayImageList{
		text-align: center;
	}
	#productImage{
		width: 150px;
		height: 150px;
		border: none;
	}
	#todayImage{
		width: 100px;
		height: 100px;
		border: none;
	}
</style>
</head>
<body>
<section id = "listForm">
<!-- 조회한 상품이 존재할 때 상품 정보를 출력. -->
<c:if test="${goodsList != null}">
<h2>상품 목록  <a href="goodsRegistForm.go">상품등록</a></h2>
<table>
	<tr><!-- 조회한 상품 개수만큼 반복하면서 정보를 출력. -->
		<!-- goodsList ArrayList 객체에 요소로 추가돼 있는 상품 정보를 하나씩 goods 변수에 할당하면서 반복문 실행. -->
		<!-- goodsList 객체는 request 영역에 goodsList라는 이름으로 공유돼 있는 속성에 접근한 것이다. -->
		<!-- status 객체에는 forEach문의 실행 정보가 저장됨. -->
		<c:forEach var = "goods" items="${goodsList}" varStatus="status">
		<td><!-- 각 상품의 이미지를 출력하면서 상품 자세히 보기 요청을 링크함. -->
			<!-- 상품 자세히 보기 요청에서는 해당 상품을 구분할 수 있도록 id값을 파라미터로 전송. -->
			<a href="goodsView.go?id=${goods.id}">
			<img src="images/${goods.image}" id="productImage"/>
			</a>
			상품명:${goods.name}<br>
			가격:${goods.price}<br>
		</td><!-- 상품을 출력할 때 한 줄에 4개씩만 출력되도록 처리. -->
		<c:if test="${((status.index+1) mod 4)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</c:if><!-- 조회된 상품 정보가 없을 때 출력. -->
<c:if test="${goodsList==null }">
	<div class="div_empty">
	상품이 없습니다.
	</div>
</c:if><!-- 쿠키에 저장돼 있는 오늘 본 상품 이미지 출력. -->
<c:if test="${todayImageList !=null }">
<div id ="todayImageList">
	<h2>오늘 본 상품 목록</h2>
<table>
	<tr>
		<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
		<td>
			<img src="images/${todayImage}" id="todayImage"/>
		</td>
			<c:if test="${((status.index+1) mod 4)==0 }">
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