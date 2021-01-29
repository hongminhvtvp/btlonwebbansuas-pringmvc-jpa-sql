<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="container">
		<!-- <div class="col-5 mx-auto"> -->
			<div class="card card-login mx-auto  mt-5">
		      <div class="card-header">Login</div>
		      <div class="card-body">
		        <form:form action="${pageContext.request.contextPath }/j_spring_security_check" method="Post" modelAttribute="taiKhoanInfo">
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="tel" id="inputEmail" name="username" class="form-control" placeholder="User Name" required="required" autofocus="autofocus">
		              <label for="inputEmail">User Name</label>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="form-label-group">
		              <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="required">
		              <label for="inputPassword">Password</label>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="checkbox">
		              <label>
		                <input type="checkbox" value="remember-me">
		                Remember Password
		              </label>
		            </div>
		          </div>
		          <button type="submit" class="btn btn-primary btn-block">Login</button>
		        </form:form>
		        <div class="text-center">
		          <a class="d-block small mt-3" href="${pageContext.request.contextPath }/register">Register an Account</a>
		          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
		        </div>
		      </div>
		    </div>
		<!-- </div> -->
  </div>

</body>
</html>