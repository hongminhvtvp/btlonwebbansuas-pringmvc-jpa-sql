<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them Loai San Pham</title>
</head>
<body>

	<form:form action="addLoaiSanPham" method="Post" modelAttribute="loaiSanPhamInfo">
		<table>
			<tr>
				<td>Ten Loai San Pham</td>
				<td><form:input path="tenLoaiSanPham"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Them"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>