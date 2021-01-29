<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
<style type="text/css">
	*{
		box-sizing: border-box;
	}
	.a{
		width: 200px;
		height: 280px;
		border: 1px solid black;
		padding: 5px;
		margin: 10px;
		float: left;
		text-align: center;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	}
	.hinh{
		width: 140px;
		height: 130px;
	}
	article{
		float:left;
		margin: 10px 20px;
		width: 65%;
	}
	.a1{
		width: 30%;
		float: left;
		margin-top: 10px;
		
	}
	sestion{
		width: 70%;
		float: left;
	}
	.a1x1{
		width: 100%;
		text-align: left;
		background-color: silver;
		padding: 10px;
	}
	.a1x11{
		padding-left: 10px;
	}
	.a2{
		padding-top: 10px;
		width: 100%;
	}
	.a2x1{
		margin-left: 10px;
	}
	.menu{
		text-decoration: none;
		padding: 5px 25px;
		text-align: center;
		background-color: gray;
		margin-right: 5px;
		color: white;
		border-radius: 3px;
	}
	h1{
		padding: 5px 30px;
		background-color: gray;
		width: auto;
		margin: 5px;
		float: left;
	}
	nav{
		float:right;
		margin-top: 50px;
		margin-right: 5px;
	}
	header{
		height: 100px;
		background-color: silver;
		color: white;
	}
	.a2 {
		padding-top: 10px;
		width: 100%;
	}
	
	.a2x1 {
		margin-left: 10px;
	}	
	*{
		box-sizing: border-box;
	}
	.b{
		width: 300px;
		height: 380px;
		border: 1px solid black;
		text-align: center;
		padding: 10px;
	}
	.hinhDetail{
		padding-top:5px;
		width: 100%;
		height: 280px;
	}
	.tr-th{
		color: white;
	}
	.table{
		width: 100%;
		border: 2px solid black;
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid black;
		border-collapse: collapse;
	}
	.a3{
		margin: 5px auto;
		text-align: center;
	}
	.a4{
		margin-top:10px;
		float: left;
	}
</style>
</head>
<body>

	<section>
		<article>
			<form:form action="checkOut" method="post" modelAttribute="donHangInfo">
				<%-- <input type="hidden" name="cart" value="${cart }"> --%>
					<table class="table">
						<tr>
							<td>Shipping address:</td>
							<td><form:input path="diaChiGiao"/></td>
						</tr>
						<tr>
							<td>Total price:</td>
							<td>
								<form:hidden path="tongTien" value="${cart.tongTien }"/>
								<input type="text" name="total" readonly="readonly" value="${cart.tongTien }">
							</td>
						</tr>
						<tr>
							<td>Payment method</td>
							<td>
								<c:forEach items="${ds }" var="item">
									<form:radiobutton path="thanhToan.idThanhToan" value="${item.idThanhToan }" label="${item.hinhThucTT }"/>
								</c:forEach>
							</td> 
						</tr>
						<tr>
							<td>
								<input type="submit" name="action" value="Save">
							</td>
							<td>
								<input type="submit" name="action" value="Cancel">
							</td>
						</tr>
					</table>
			</form:form>
		</article>
	</section>

</body>
</html>