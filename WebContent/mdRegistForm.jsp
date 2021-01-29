<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<style type="text/css">
a, a:hover {
	color: #000000;
	text-decoration: none;
}

#registForm {
	width: 500px;
	height: 580px;
	border: 1px solid gray;
	margin:auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
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
	<section id = "registForm">
		<h2>상품 등록</h2>
		<form action="mdRegist.md" method="post" name="writeForm" enctype="multipart/form-data">
			<table>
				<tr>
					<td class="td_left"><label for="item">상품명</label></td>
					<td class="td_right"><input type="text" name="item" id="item" required="required"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="price">가 격</label></td>
					<td class="td_right"><input type="text" name="price" id="price"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="cate1">대분류</label></td>
					<td class="td_right"><input type="text" name="cate1" id="cate1"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="cate2">중분류</label></td>
					<td class="td_right"><input type="text" name="cate2" id="cate2"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="cate3">소분류</label></td>
					<td class="td_right"><input type="text" name="cate3" id="cate3"/></td>
				</tr>
				<tr>
					<td class="td_left"><label for="content">내 용</label></td>
					<td class="td_right"><textarea name="content" id="content" rows="15" cols="50" wrap="off"></textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="image">이미지</label></td>
					<td class="td_right"><input type="file" name="image" id="image"/></td>
				</tr>
			</table><br>
			<section id="buttonList"> 
				<input type="submit" value="등록"/>      
				<input type="reset" value="리셋"/>      
				<input type="button" value="목록" onClick="window.location.href='mdList.md'"/>
			</section><br>
		</form>
	</section>
</body>
</html>