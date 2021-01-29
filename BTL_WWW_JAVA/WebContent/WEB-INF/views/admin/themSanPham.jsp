<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them san pham</title>
</head>
<body>
	
	
	<div class="row">
		<div class="col-sm" align="center">
			<h1>Them San Pham</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<form:form action="admin-addSanPham" method="POSt" modelAttribute="sanPhamInfo" enctype="multipart/form-data">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<form:input path="idSanPham" class="form-control" placeholder="Id san pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ten </label>
					<div class="col-sm-10">
						<form:input path="tenSanPham" class="form-control" placeholder="Ten San Pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Mo Ta </label>
					<div class="col-sm-10">
						<form:input path="moTa" class="form-control" placeholder="Mo ta"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">So luong </label>
					<div class="col-sm-10">
						<form:input path="soLuong" class="form-control" placeholder="So luong san pham"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">DOn gia </label>
					<div class="col-sm-10">
						<form:input path="donGia" class="form-control" placeholder="Don gia"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ngay San xuat </label>
					<div class="col-sm-10">
						<form:input path="ngaySanXuat" class="form-control" placeholder="Id san pham" type="Date"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Han Su Dung </label>
					<div class="col-sm-10">
						<form:input path="hanSuDung"  class="form-control" placeholder="Han su Dung" type="Date"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Loai San pham </label>
					<div class="col-sm-10">
							<form:select path="loaiSanPham.idLoaiSanPham" class="custom-select mr-sm-2">
								<c:forEach items="${dsLoaiSP }" var="item">
									<form:option value="${item.idLoaiSanPham }"  label ="${item.tenLoaiSanPham }"></form:option>
								</c:forEach>
							</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Nha San Xuat </label>
					<div class="col-sm-10">
						<form:select path="nhaSanXuat.idNhaSanXuat" class="custom-select mr-sm-2">
								<c:forEach items="${dsNhaSX }" var="item">
									<form:option value="${item.idNhaSanXuat }" label="${item.tenNhaSanXuat }"></form:option>
								</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">File Image </label>
					<div class="col-sm-10">
						<form:input path="fileData" type="file"/>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Them</button>
			</form:form>
		</div>
		<div class="col-sm-3"></div>
	</div>


</body>
</html>