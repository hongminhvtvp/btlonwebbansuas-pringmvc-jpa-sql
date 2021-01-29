<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

	<a class="navbar-brand mr-1" href="${pageContext.request.contextPath }/admin">Start Bootstrap</a>

	<!-- <button class="btn btn-link btn-sm text-white order-1 order-sm-0"
		id="sidebarToggle" href="#collapsibleNavbar">
		<i class="fas fa-bars"></i>
	</button> -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> QL san Pham </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="admin-themSanPham">Them San Pham</a> <a
						class="dropdown-item" href="admin-loaiSanPham">QL Loai San Pham</a> <a
						class="dropdown-item" href="admin-nhaSanXuat">QL Nha San Xuat</a>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link" href="admin-thanhToan">QL Thanh Toan</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		</ul>
	</div>


	<!-- Navbar Search -->
	<form
		class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search for..."
				aria-label="Search" aria-describedby="basic-addon2">
			<div class="input-group-append">
				<button class="btn btn-primary" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</div>
	</form>

	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
				class="badge badge-danger">9+</span>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="alertsDropdown">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Something else here</a>
			</div></li>
		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
				class="badge badge-danger">7</span>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="messagesDropdown">
				<a class="dropdown-item" href="#">Action</a> <a
					class="dropdown-item" href="#">Another action</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Something else here</a>
			</div></li>
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
			</div>
		</li>
			<li class="nav-item">
          	<c:if test="${pageContext.request.userPrincipal.name != null }">
          		<a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
          	</c:if>
          	<c:if test="${pageContext.request.userPrincipal.name == null }">
          		<a class="nav-link" href="${pageContext.request.contextPath }/login">Login</a>
          	</c:if>
          </li>
	</ul>

</nav>