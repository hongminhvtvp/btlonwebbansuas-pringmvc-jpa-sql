<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chu</title>
</head>
<body>

	<div class="container">

		<!-- Heading Row -->
		<div class="row align-items-center my-5">
			<div class="col-lg-7">
				<img class="img-fluid rounded mb-4 mb-lg-0"
					src="http://placehold.it/900x400" alt="">
			</div>
			<!-- /.col-lg-8 -->
			<div class="col-lg-5">
				
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			<c:forEach items="${ds }" var="item">
				<form:form action="addToCart" method="Post" modelAttribute="cartItemInfo">
					<div class="col-md-4 mb-5">
						<div class="card h-100 text-center" style="width: 300px">
							<div class="card-header">
								<h2 class="card-title"><form:hidden path="thongTin" value="${item.tenSanPham }"/>${item.tenSanPham }</h2>
							</div>
							<div class="card-body">
								<img class="card-img-top" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}" alt="Card image cap" style="height: 220px">
								<p class="card-text text-center" style="padding-top: 5px">
									  	<form:hidden path="donGia" value="${item.donGia }"/>
									    <span class="input-group-text">Don Gia : ${item.donGia } VND</span>
								</p>
								<div class="input-group" style="margin-bottom: 5px">
								  <div class="input-group-prepend">
								    <span class="input-group-text">So luong</span>
								  </div>
								  <form:input path="soLuong" value="1" size="2" class="form-control" aria-label="Amount"/>
								</div>
								<form:hidden path="partNumber" value="${item.idSanPham }"/>
								<div class="alert alert-dark" style="margin: 0px">
								    <strong><a href="">Chi tiet san pham</a></strong>
								  </div>
							</div>
							<div class="card-footer">
								<input type="submit" value="Add To Cart" class="btn btn-primary btn-sm">
							</div>
						</div>
					</div>
				</form:form>
			</c:forEach>

			<!-- /.col-md-4 -->
			<!-- <div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Card Two</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Quod tenetur ex natus at dolorem enim! Nesciunt
							pariatur voluptatem sunt quam eaque, vel, non in id dolore
							voluptates quos eligendi labore.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary btn-sm">More Info</a>
					</div>
				</div>
			</div> -->
			<!-- /.col-md-4 -->
			<!-- <div class="col-md-4 mb-5">
				<div class="card h-100">
					<div class="card-body">
						<h2 class="card-title">Card Three</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Rem magni quas ex numquam, maxime minus quam
							molestias corporis quod, ea minima accusamus.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary btn-sm">More Info</a>
					</div>
				</div>
			</div> -->
			<!-- /.col-md-4 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

</body>
</html>