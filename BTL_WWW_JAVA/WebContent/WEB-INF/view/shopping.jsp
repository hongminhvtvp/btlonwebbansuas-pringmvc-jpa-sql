<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping</title>
<style type="text/css">
	*{
		box-sizing: border-box;
	}
	.a{
		width: 200px;
		height: 280px;
		border: 1px solid black;
		padding: 5px;
		margin: 10px;
		float: left;
		text-align: center;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	}
	.hinh{
		width: 140px;
		height: 130px;
	}
</style>
</head>
<body>

	<c:forEach items="${ds }" var="item">
		<div class="a">
			<form:form action="cart/addToCart" method="Post" modelAttribute="cartItemInfo"> 
				<label><form:hidden path="thongTin" value="${item.tenSanPham }"/>${item.tenSanPham }</label>
				<img alt="" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}" class="hinh"><br>
				<label><form:hidden path="donGia" value="${item.donGia }"/>Don Gia: ${item.donGia } VND</label>
				<label><form:input path="soLuong" value="1" size="2"/></label><br>
				<label><form:hidden path="partNumber" value="${item.idSanPham }"/></label>
				<label><input type="hidden" name="action" value="add"></label>
				<label><input type="submit" name="addToCart" value="Add to Cart"></label>
			</form:form>
		</div>
	</c:forEach>

</body>
</html>