<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>

		<section class="jumbotron text-center">
		    <div class="container">
		        <h1 class="jumbotron-heading">E-COMMERCE CART</h1>
		     </div>
		</section>
		
		<div class="container mb-4">
		    <div class="row">
		        <div class="col-12">
		            <div class="table-responsive">
		                <table class="table table-striped">
		                    <thead>
		                        <tr>
		                            <th scope="col"> </th>
		                            <th scope="col">San Pham</th>
		                            <th scope="col">Don gia</th>
		                            <th scope="col" class="text-center">So luong</th>
		                            <th scope="col" class="text-right">Thanh Tien</th>
		                            <th> </th>
		                            <th> </th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    	<tr>
									<c:if test="${cart.lineItemCount==0 }">
										<td colspan="8">Gio hang hien dang trong.</td>
									</c:if>
								</tr>
								<c:forEach items="${cart.listAllCartItem }" var="cartItem" varStatus="counter">
									<form:form name="item" method="post" action="action" modelAttribute="cartItemInfo">
										<tr>
											<form:hidden path="partNumber" value="${cartItem.partNumber }"/>
											<td><img class="card-img-top" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${cartItem.partNumber}" alt="Card image cap" style="height: 50px;width: 50px"></td>
											<td><c:out value="${cartItem.thongTin }"></c:out></td>
											<td><c:out value="${cartItem.donGia }"></c:out>
											<td>
												<form:input path="soLuong" size="2" value="${cartItem.soLuong }" class="form-control"/>
											</td>
											<td class="text-right"><input type="hidden" name="itemIndex" value="<c:out value="${counter.count }"></c:out>"> 
												<c:out value="${cartItem.thanhTien } VND"></c:out>
											</td>
											<td class="text-right"><input type="submit" name="action" value="UpdateCart" class="btn btn-info"></td>
											<td class="text-right"><input type="submit" name="action" value="Remove" class="btn btn-danger"></td>
										</tr>
									</form:form>
								</c:forEach>
		                        <tr>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td></td>
		                            <td><strong>Total</strong></td>
		                            <td class="text-right"><strong><c:out value="${cart.tongTien }"></c:out> VND</strong></td>
		                        </tr>
		                    </tbody>
		                </table>
		            </div>
		        </div>
		        <div class="col mb-2">
		            <div class="row">
		                <div class="col-sm-12  col-md-6">
		                   	<a href="${pageContext.request.contextPath }/trang-chu"><button class="btn btn-block btn-light">Continue Shopping</button></a>
		                </div>
		                <div class="col-sm-12 col-md-6 text-right">
		                	<a href="${pageContext.request.contextPath }/checkOut"><button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button></a>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>

</body>
</html>