<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="addThanhToan" method="POST" modelAttribute="thanhToanInfo">
			<table>
				<tr>
					<td>Kieu Thanh Toan</td>
					<td><form:input path="hinhThucTT"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Them"></td>
				</tr>
			</table>
	</form:form>

</body>
</html>