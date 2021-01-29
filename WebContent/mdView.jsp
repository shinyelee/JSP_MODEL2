<%@ page import="vo.Md"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	margin:auto;
}

h2 {
	text-align:center;
}

img {
	width: 270px;
	height: 270px;
	border: none;
}
#content_main {
		height:300px;
	}
#content_left {
	width: 300px;
	height: 300px;
	float:left;
	background: LightBlue;
}
#content_right {
	width: 200px;
	height: 300px;
	float:left;
	background: SeaShell;
}
	
#commandList {
	text-align: center;
}

#desc {
	height:100px;
	background: SeaShell;
}
</style>
</head>
<body>
	<section id = "listForm">
	<!-- 상품명 -->
	<h2>${md.item} (상품명)</h2>
		<section id="content_main">
			<section id = "content_left">
				<img src="images/${md.image}"/>
			</section>
			<section id = "content_right">
				<b>상품명</b> ${md.item}<br>
				<b>가&nbsp;&nbsp;격</b> ${md.price}<br>
				<b>대분류</b> ${md.cate1}<br>
				<b>중분류</b> ${md.cate2}<br>
				<b>소분류</b> ${md.cate3}<br>
				<p id="desc">
				<b>내&nbsp;&nbsp;용 </b> ${md.content}<br>
				</p>
			</section>
			<div style="clear:both"></div>
			<nav id = "commandList">
				<br><a href="mdList.md"><button>목록으로</button></a>
				<a href="mdCartAdd.md?id=${md.id}"><button>장바구니</button></a>
			</nav>
		</section>
	</section>
</body>
</html>