<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them San Pham</title>
</head>
<body>

	<form:form action="addSanPham" method="POST" modelAttribute="sanPhamInfo" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Id san pham:</td>
				<td><form:input path="idSanPham"/></td>
			</tr>
			<tr>
				<td>Ten san Pham:</td>
				<td><form:input path="tenSanPham"/></td>
			</tr>
			<tr>
				<td>Mo Ta</td>
				<td><form:input path="moTa"/></td>
			</tr>
			<tr>
				<td>So luong:</td>
				<td><form:input path="soLuong"/></td>
			</tr>
			<tr>
				<td>Don Gia:</td>
				<td><form:input path="donGia"/></td>
			</tr>
			<tr>
				<td>Ngay San Xuat:</td>
				<td><form:input path="ngaySanXuat" type="date"/></td>
			</tr>
			<tr>
				<td>Han Su Dung:</td>
				<td><form:input path="hanSuDung" type="date"/></td>
			</tr>
			<tr>
				<td>Nha San Xuat</td>
				<td>
					<form:select path="nhaSanXuat">
						<c:forEach items="${dsNhaSX }" var="item">
							<form:option value="${item.idNhaSanXuat }">${item.tenNhaSanXuat }</form:option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Loai San Pham</td>
				<td>
					<form:select path="loaiSanPham">
						<c:forEach items="${dsLoaiSP }" var="item">
							<form:option value="${item.idLoaiSanPham }">${item.tenLoaiSanPham }</form:option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Up Load Image</td>
				<td><form:input path="fileData" type="file" class="custom-file-label" for="validatedCustomFile"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Them"> </td>
			</tr>
		</table>
		
	</form:form>

</body>
</html>