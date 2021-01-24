<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="vo.Cart"%>
<%@page import="vo.Goods"%>
<%@page import="dao.GoodsDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
	width: 640px;
	border: 1px gray solid;
	margin: auto;

}

h2 {
	text-align: center;
}

table {
	width: 550px;
	margin: auto;
}

.tr_top {
	background-color: LightBlue;
}

.div_empty {
	text-align: center;
	background-color: SeaShell;
}

.td_command {
	text-align: right;
}
#todayImageList{
	text-align: center;
}
#productImage{
	width:150px;
	height:150px;
	border:none;
}
#cartImage{
	width:70px;
	height:70px;
	border:none;
}
#select{
	text-align: right;
}
#commandList{
	text-align: center;
}
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}
</style>
<script>
/*	장바구니 항목 삭제 요청을 할 때 삭제할 항목을 체크 박스로 선택한다.
	체크박스를 하나씩 체크할 수도 있지만 전체선택(상단 체크박스 하나로 모든 하위 체크박스 선택 및 해제) 기능도 필요하기 때문에 자바스크립트 처리함.
	이 함수 영역은 onclick="checkAll(this.form)"부분에서 allCheck 체크박스를 클릭할 때 실행함.
	checkAll 함수를 호출하면서 form 객체를 인자값으로 전송. */
	function checkAll(theForm){
	/*	장바구니 항목이 하나가 출력되었을 경우 처리되는 부분.
		theForm은 인자로 전달된 form 객체이며 remove는 각 장바구니 항목을 선택하는 체크박스.
		페이지에 remove라는 이름의 체크 박스가 하나 출력되면 단일 객체로 인식하지만 여러 개가 출력되면 배열 객체로 인식.
		length 속성은 자바스크립트에서 배열 객체에 지원되는 속성이므로 theForm.remove.length==undefined라는 조건을 만족할 경우
		remove 객체가 배열 객체가 아님 -> remove 체크 박스가 하나 출력됐다는 의미. */	
		if(theForm.remove.length == undefined){
		/*	체크박스가 선택되었으면 true, 아니면 false 반환. */
			theForm.remove.checked = theForm.allCheck.checked;
	/*	장바구니 항목을 선택하는 체크박스가 여러 개 출력(장바구니 항목이 여러개)됐을 경우 처리. */
		}else{
			for(var i=0;i<theForm.remove.length;i++){
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
/*	장바구니 항목 수량 감소 요청을 할 때 현재 수량이 1이 아닐 경우(1에서 0으로 줄이려면 -> 삭제)만 수량 감소 요청을 하게 처리한 함수. */
	function checkQty(name,qty){
		if(qty != 1){
			location.href="goodsCartQtyDown.go?name="+ encodeURIComponent(name);
		}
	}
</script>
</head>
<body>
<!-- 검색에 사용되는 startMoney 값과 endMoney 값을 속성으로 설정. -->
<!-- null값인 경우(검색 작업을 하지 않고 목록포기 페이지가 실행됨) NullPointerException이 발생하지 않도록 처리. -->
<c:if test="${startMoney !=null }">
	<c:set var="startMoney" value="${startMoney}"></c:set>
</c:if>
<c:if test="${endMoney !=null }">
	<c:set var="endMoney" value="${endMoney}"></c:set>
</c:if>
<section id="listForm">
	<c:if test="${cartList !=null && cartList.size()>0 }">
   <h2>장바구니 목록</h2>
<form method="post">
	<table>
		<!-- 가격별 검색부분 처리. -->
		<tr id="select">
			<td colspan="6">
			<select id = "startMoney" name="startMoney">
				<option>=최하=</option>
				<c:choose>
					<c:when test="${startMoney==1000 }">
						<option selected="selected">1000</option>
						<option>2000</option>
						<option>3000</option>
						<option>4000</option>
					</c:when>
					<c:when test="${startMoney==2000 }">
						<option>1000</option>
						<option selected="selected">2000</option>
						<option>3000</option>
						<option>4000</option>
					</c:when>
					<c:when test="${startMoney==3000 }">
						<option>1000</option>
						<option>2000</option>
						<option selected="selected">3000</option>
						<option>4000</option>
					</c:when>
					<c:when test="${startMoney==4000 }">
						<option>1000</option>
						<option>2000</option>
						<option>3000</option>
						<option selected="selected">4000</option>
					</c:when>
					<c:otherwise>
						<option>1000</option>
						<option>2000</option>
						<option>3000</option>
						<option>4000</option>
					</c:otherwise>
				</c:choose>
			</select>
			<select id = "endMoney" name="endMoney">
				<option>=최고=</option>
				<c:choose>
					<c:when test="${endMoney==1000 }">
						<option selected="selected">1000</option>
						<option>2000</option>
						<option>3000</option>
	    				<option>4000</option>
					</c:when>
					<c:when test="${endMoney==2000 }">
						<option>1000</option>
						<option selected="selected">2000</option>
						<option>3000</option>
						<option>4000</option>
					</c:when>
					<c:when test="${endMoney==3000 }">
						<option>1000</option>
						<option>2000</option>
						<option selected="selected">3000</option>
						<option>4000</option>
					</c:when>
					<c:when test="${endMoney==4000 }">
						<option>1000</option>
						<option>2000</option>
						<option>3000</option>
	    				<option selected="selected">4000</option>
					</c:when>
					<c:otherwise>
						<option>1000</option>
						<option>2000</option>
						<option>3000</option>
						<option>4000</option>
					</c:otherwise>
				</c:choose>
			</select>
			<input type="submit" value="검색" formaction="goodsCartSearch.go"/>
			</td>
		</tr>
		<tr class = "tr_top">
			<td><input type="checkbox" id = "allCheck" name="allCheck" onclick="checkAll(this.form)"/></td>
			<td>번호</td>
			<td>이미지</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
		</tr>
		<c:forEach var="cart" items="${cartList }" varStatus="status">
		<tr>
			<td><input type="checkbox" id="remove" name="remove" value="${cart.name }"/></td>
			<!-- 번호값계산 -> status.index 속성을 하용하면 forEach 문이 실행되는 인덱스 번호 반환. -->
			<!-- 한 번 실행될 때 0, 두 번째 실행될 때 1 반환. -->
			<td>${status.index+1}</td>
			<td><img src = "images/${cart.image }" id ="cartImage"/></td>
			<td>${cart.name }</td>
			<td>${cart.price }</td>
			<td><!-- 장바구니 항목 수량 증가 요청. -->
				<a href="goodsCartQtyUp.go?name=${cart.encodingName }"><img src="images/up.jpg" id = "upImage" border=0/></a><br>
				${cart.qty }<br>
				<!-- 장바구니 항목 수량 감소 요청. -->
				<a href="javascript:checkQty('${cart.name}',${cart.qty})"><img src="images/down.jpg" id = "downImage" border=0/></a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="text-align:center;">총 금액 : ${totalMoney}원</td>
		</tr>
		<tr>
			<td colspan="5" style="text-align:center;"><input type="submit" value="삭제" formaction="goodsCartRemove.go"/></td>
		</tr>
	</table>
</form>
	</c:if>
	<c:if test="${cartList == null }">
		<section class="div_empty">정보가 없습니다.</section>
	</c:if>
	<nav id="commandList"><a href="goodsList.go">쇼핑 계속하기</a></nav>
</section>
</body>
</html>