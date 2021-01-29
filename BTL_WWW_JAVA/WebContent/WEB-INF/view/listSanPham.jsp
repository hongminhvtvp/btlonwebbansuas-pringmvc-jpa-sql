<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List San Pham</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>ID san Pham</th>
			<th>Ten San Pham</th>
			<th>Mo ta</th>
			<th>So luong</th>
			<th>Don gia</th>
			<th>Ngay san Xuat</th>
			<th>Han Su Dung</th>
			<th>Loai San pham</th>
			<th>Nha San Xuat</th>
			<th>Image</th>
		</tr>
		<tr>
			<c:forEach items="${ds }" var="item">
				<td>${item.idSanPham }</td>
				<td>${item.tenSanPham }</td>
				<td>${item.moTa }</td>
				<td>${item.soLuong }</td>
				<td>${item.donGia }</td>
				<td>${item.ngaySanXuat }</td>
				<td>${item.hanSuDung }</td>
				<td>${item.loaiSanPham.idLoaiSanPham }</td>
				<td>${item.nhaSanXuat.idNhaSanXuat }</td>
				<td><img alt="" src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}">
			</c:forEach>
		</tr>
	</table>

</body>
</html>