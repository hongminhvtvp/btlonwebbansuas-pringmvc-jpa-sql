<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">	
<link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/admin/css/sb-admin.css'/>" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>
<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
      	<form:form method="POSt" action="register" modelAttribute="khachHangInfo">
        	<div class="form-group">
            	<div class="form-row">
              		<div class="col-md-6">
              	 		<div class="form-label-group">
                  			<form:input path="nameKhachHang" type="text" id="firstName" class="form-control" placeholder="First name" required="required" autofocus="autofocus"></form:input>
                  			<label for="firstName">Ten</label>
                		</div>
              		</div>
	              	<div class="col-md-6">
	                	<div class="form-label-group">
	                  		<form:input path="diaChi" type="text" id="diaChi" class="form-control" placeholder="Dia chi" required="required"></form:input>
	                  		<label for="diaChi">Dia chi</label>
	                	</div>
	              	</div>
          	 	 </div>
          	</div>
          	<div class="form-group">
            	<div class="form-row">
              		<div class="col-md-6">
              	 		<div class="form-label-group">
                  			<form:input path="sdt" type="tel" id="sdt" class="form-control" placeholder="SO dien thoai" required="required" autofocus="autofocus"></form:input>
                  			<label for="sdt">So dien thoai</label>
                		</div>
              		</div>
	              	<div class="col-md-6">
	              		 <div class="form-check-inline" style="padding-top: 10px;">
	              		 	<div class=" form-check-inline">
	                		 <label class="form-check-label" for="radio1">Gioi Tinh:
	                		 	<form:radiobutton path="gioiTinh" id="radio1" value="Nam" label="Nam"/>
	                		 </label>
	                		</div>
	              		 </div>
	                	 <div class="form-check-inline">
	              		 	<div class=" form-check-inline">
	                		 <label class="form-check-label" for="radio2">
	                		 	<form:radiobutton path="gioiTinh" value="Nu" label="Nu" id="radio2"/>
	                		 </label>
	                		</div>
	              		 </div>
	              	</div>
          	 	 </div>
          	</div>
          	<div class="form-group">
           	 <div class="form-label-group">
              	<form:input path="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required="required"></form:input>
             	 <label for="inputEmail">Email address</label>
          	  </div>
     	   </div>
     	   <div class="form-group">
           	 <div class="form-label-group">
              	<form:input path="ngaySinh" type="date" id="birthday" class="form-control" placeholder="Ngay Sinh" required="required"></form:input>
             	 <label for="birthday">Ngay Sinh</label>
          	  </div>
     	   </div>
     	   <div class="form-group">
           	 <div class="form-label-group">
              	<form:input path="taiKhoanInfo.username" type="text" id="userName" class="form-control" placeholder="User name" required="required"></form:input>
             	 <label for="userName">User Name</label>
          	  </div>
     	   </div>
       	   <div class="form-group">
           <div class="form-row">
				<div class="col-md-6">
                	<div class="form-label-group">
                		  <form:input path="taiKhoanInfo.password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="required"></form:input>
                  		<label for="inputPassword">Password</label>
                	</div>
              	</div>
			<div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required">
                  <label for="confirmPassword">Confirm password</label>
                </div>
              </div>
            </div>
          </div>
          <button type="submit" class="btn btn-primary btn-block">Register</button>
          
        </form:form>
          
        <div class="text-center">
          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/login">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>

<!-- Bootstrap core JavaScript-->
 <script src="<c:url value='template/admin/vendor/jquery/jquery.min.js'/>"></script>
 <script src="<c:url value='template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

 <!-- Core plugin JavaScript-->
 <script src='<c:url value="template/admin/vendor/jquery-easing/jquery.easing.min.js"/>'></script>

</body>
</html>