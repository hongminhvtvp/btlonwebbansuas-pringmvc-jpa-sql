<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${ds }" var="item">
			<tr>
				<td>ID:</td>
				<td>${item.idLoaiSanPham }</td>
			</tr>
			<tr>
				<td>Ten Loai San Pham</td>
				<td>${item.tenLoaiSanPham }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>