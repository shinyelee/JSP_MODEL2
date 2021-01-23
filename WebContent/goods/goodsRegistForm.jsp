<!-- 상품 등록 정보를 입력하는 jsp 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#registForm{
		width: 500px;
		height: 610px;
		border : 1px solid gray; 
		margin:auto; 
	}   
	h2{
		text-align: center;
	}
	table{
		margin:auto;
		width: 450px;
	}
	.td_left{
		width: 150px;
		background:LightBlue;
	}
	.td_right{
		width: 300px;
		background:SeaShell;
	}
	#commandCell{
		text-align: center;
	}
</style>
</head>
<body>
<section id = "registForm">
	<header>
		<h2>상품정보등록</h2>
	</header>
	<!-- 등록 요청에 파일 업로드 요청이 존재하므로 enctype="multipart/form-data"를 지정해야 함. -->
		<form action="goodsRegist.go" method="post" name = "writeForm" enctype="multipart/form-data">

	<table>
	<tr><!-- 목록보기 요청 링크. -->
		<td colspan="2"><a href="goodsList.go">목록보기</a></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "name">상품명 : </label></td>
		<td class = "td_right"><input type = "text" name = "name" id ="name" required="required"/></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "category">대분류 : </label></td>
		<td class = "td_right"><input type = "text" name = "category" id ="category"/></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "price">가격 : </label></td>
		<td class = "td_right"><input type = "text" name = "price" id ="price"/></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "category2">소분류 : </label></td>
		<td class = "td_right"><input type = "text" name = "category2" id ="category2"/></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "version">버전 : </label></td>
		<td class = "td_right"><input type = "text" name = "version" id ="version"/></td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "content">내용 : </label></td>
		<td class = "td_right">
			<textarea name="content" id="content" rows="13" cols="40" wrap="off"></textarea>
		</td>
	</tr>
	<tr>
		<td class = "td_left"><label for = "image">이미지 : </label></td>
		<td class = "td_right"><input type = "file" name = "image" id ="image"/></td>
	</tr>
	<tr>
		<td colspan="2" id = "commandCell"> 
			<input type = "submit" value = "상품등록"/>      
			<input type = "reset" value = "다시작성"/>      
			<input type = "button" value = "상품목록보기" onClick="window.location.href='goodsList.go'"/>      
		</td>
	</tr>   
</table>
</form>

</section>
</body>
</html>