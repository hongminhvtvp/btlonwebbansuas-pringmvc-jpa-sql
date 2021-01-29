<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div class="row mt-4">
		<div class="col-sm" align="center">
			<h2>Update San Pham</h2>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<form:form action="${pageContext.request.contextPath }/admin-updateSP" method="POSt" modelAttribute="sanPhamInfo" enctype="multipart/form-data">
				<div class="form-group row">
					<label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<form:input path="idSanPham" class="form-control" placeholder="Id san pham" value="${sp.idSanPham }" readonly="true"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ten </label>
					<div class="col-sm-10">
						<form:input path="tenSanPham" class="form-control" placeholder="Ten San Pham" value="${sp.tenSanPham }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Mo Ta </label>
					<div class="col-sm-10">
						<form:input path="moTa" class="form-control" placeholder="Mo ta" value="${sp.moTa }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">So luong </label>
					<div class="col-sm-10">
						<form:input path="soLuong" class="form-control" placeholder="So luong san pham" value="${sp.soLuong }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">DOn gia </label>
					<div class="col-sm-10">
						<form:input path="donGia" class="form-control" placeholder="Don gia" value="${sp.donGia }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Ngay San xuat </label>
					<div class="col-sm-10">
						<form:input path="ngaySanXuat" class="form-control" placeholder="Id san pham" type="Date" value="${sp.ngaySanXuat }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Han Su Dung </label>
					<div class="col-sm-10">
						<form:input path="hanSuDung" class="form-control" placeholder="Han su Dung" type="Date" value="${sp.hanSuDung }"/>
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword3" class="col-sm-2 col-form-label">Loai San pham </label>
					<div class="col-sm-10">
							<form:select path="loaiSanPham.idLoaiSanPham" class="custom-select mr-sm-2">
								<c:forEach items="${dsLoaiSP }" var="item">
									<form:option value="${item.idLoaiSanPham }" label="${item.tenLoaiSanPham }"></form:option>
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
				<button type="submit" class="btn btn-primary">Update</button>
			</form:form>
		</div>
		<div class="col-sm-3"></div>
	</div>

</body>
</html>