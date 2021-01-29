<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>

	<section>
		<article>
			<h2 style="text-align: center;">YOUR SHOPPING CART</h2>
			<table class="table">
				<tr bgcolor="#29293d" class="tr-th">
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Total</th>
					<th>Remove</th>
					<th>Update Cart</th>
				</tr>
				<tr>
					<c:if test="${cart.lineItemCount==0 }">
						<td colspan="6">Cart is currently empty</td>
					</c:if>
				</tr>

				<c:forEach items="${cart.listAllCartItem }" var="cartItem"
					varStatus="counter">
					<form:form name="item" method="post" action="action" modelAttribute="cartItemInfo">
						<tr>
							<form:hidden path="partNumber" value="${cartItem.partNumber }"/>
							<td><c:out value="${cartItem.partNumber }"></c:out></td>
							<td><c:out value="${cartItem.thongTin }"></c:out></td>
							<td><c:out value="${cartItem.donGia }"></c:out>
							<td>
								<form:input path="soLuong" size="2" value="${cartItem.soLuong }"/>
							</td>
							<td><input type="hidden" name="itemIndex"
								value="<c:out value="${counter.count }"></c:out>"> <c:out
									value="${cartItem.thanhTien }"></c:out></td>
							<td><input type="submit" name="action" value="Remove"></td>
							<td><input type="submit" name="action" value="UpdateCart"></td>
						</tr>
					</form:form>
				</c:forEach>

				<tr>
					<td colspan="4" style="text-align: right;">Total Price:</td>
					<td colspan="2"><c:out value="${cart.tongTien }"></c:out>
						(VND)</td>
				</tr>
			</table>
			<div class="a4">
				<c:url var="checkOut_link" value="checkOut">
					<c:param name="total" value="${cart.tongTien }"></c:param>
				</c:url>
				<a href="${checkOut_link }"><button>Check Out</button></a> 
				<a href="${pageContext.request.contextPath }/shopping"><button>ContinueShopping</button></a>
			</div>
		</article>

	</section>

</body>
</html>