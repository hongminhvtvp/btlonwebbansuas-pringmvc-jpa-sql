<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	
	<section class="jumbotron text-center">
		 <div class="container">
		     <h1 class="jumbotron-heading">Check Out</h1>
		 </div>
	</section>

	<div class="container mb-4">
		    <div class="row">
		        <div class="col-8">
		        	<form:form action="checkOut" method="post" modelAttribute="donHangInfo">
					<table class="table table-striped">
						<tr>
							<td>Shipping address:</td>
							<td><form:input path="diaChiGiao" class="form-control"/></td>
						</tr>
						<tr>
							<td>Total price:</td>
							<td>
								<form:hidden path="tongTien" value="${cart.tongTien }"/>
								<%-- <input type="text" name="total" readonly="readonly" value="${cart.tongTien }"> --%>
								<form:input path="tongTien" class="form-control" readonly="true" value="${cart.tongTien }"/>
							</td>
						</tr>
						<tr>
							<td>Payment method</td>
							<td>
								<c:forEach items="${ds }" var="item">
									<form:radiobutton path="thanhToan.idThanhToan" value="${item.idThanhToan }" label="${item.hinhThucTT }"/>&nbsp;&nbsp;
								</c:forEach>
							</td> 
						</tr>
						<tr>
							<td>
								<input type="submit" name="action" value="Save" class="btn btn-block btn-light">
								
							<td>
								<input type="submit" name="action" value="Cancel" class="btn btn-lg btn-block btn-success text-uppercase">
							</td>
						</tr>
					</table>
			</form:form>
		        </div>
		    </div>
	</div>	        
				

</body>
</html>