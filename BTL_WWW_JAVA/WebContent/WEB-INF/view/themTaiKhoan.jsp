<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tao Tai Khoan</title>
</head>
<body>

	<form:form action="addTaiKhoan" method="Post" modelAttribute="khachHangInfo">
		<table>
			<tr>
				<td>Ten Day Du</td>
				<td><form:input path="nameKhachHang"/></td>
			</tr>
			<tr>
				<td>Dia Chi</td>
				<td><form:input path="diaChi"/></td>
			</tr>
			<tr>
				<td>So dien thoai</td>
				<td><form:input path="sdt"/></td>
			</tr>
			<tr>
				<td>Gioi tinh:</td>
				<td>
					<form:radiobutton path="gioiTinh" value="Nam" label="Nam"/>
					<form:radiobutton path="gioiTinh" value="Nu" label="Nu"/>
				</td>	
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" type="email"/></td>
			</tr>
			<tr>
				<td>Ngay Sinh</td>
				<td><form:input path="ngaySinh" type="date"/></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input path="taiKhoanInfo.username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="taiKhoanInfo.password" type="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Tao tai khoan"></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>