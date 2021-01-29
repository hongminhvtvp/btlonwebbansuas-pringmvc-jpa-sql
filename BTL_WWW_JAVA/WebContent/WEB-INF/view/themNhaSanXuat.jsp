<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Them Nha San Xuat</title>
</head>
<body>

	<form:form action="addNhaSanXuat" method="POST" modelAttribute="nhaSanXuatInfo">
		<table>
			<tr>
				<td>Ten Nha San Xuat</td>
				<td><form:input path="tenNhaSanXuat"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Them"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>