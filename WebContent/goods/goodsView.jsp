<!-- 상품 하나의 상세 정보를 출력해주는 jsp 페이지 -->
<%@page import="vo.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#listForm{
		width:640px;
		border:1px solid red;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	img{
		width: 280px;
		height: 280px;
		border: none;
	}
	#content_main{
		height:300px;
	}
	#content_left{
		width: 300px;
		float:left;
	}
	#content_right{
		width: 340px;
		float:left;
	}
	#commandList{
		text-align: center;
	}
	#desc{
		height:170px;
		background: skyblue;
	}
</style>
</head>
<body>
<section id = "listForm">
<h2>${goods.kind}의 상세정보</h2>

	<section id="content_main">
		<section id = "content_left">
			<img src="images/${goods.image}"/>
		</section>
		<section id = "content_right">
			<b>제품 : </b> ${goods.name}<br>
			<b>가격 : </b> ${goods.price}<br>
			<b>대분류 : </b> ${goods.category}<br>
			<b>소분류 : </b> ${goods.category2}<br>
			<b>버전 : </b> ${goods.version}<br>
			<p id="desc">
			<b>내용 : </b> ${goods.content}<br>
			</p>
		</section>
		<div style="clear:both"></div>
		<nav id = "commandList">
			<a href="goodsList.go">쇼핑계속하기</a>
			<a href="goodsCartAdd.go?id=${goods.id}">장바구니에담기</a>
		</nav>
	</section>
</section>
</body>
</html>