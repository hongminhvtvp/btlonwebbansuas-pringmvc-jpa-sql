<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">	
<link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/admin/css/sb-admin.css'/>" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>
<body class="bg-dark">
	
	<sitemesh-decorator:body></sitemesh-decorator:body>
	
	
	<!-- Bootstrap core JavaScript-->
  <script src="<c:url value='template/admin/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<c:url value='template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

  <!-- Core plugin JavaScript-->
  <script src='<c:url value="template/admin/vendor/jquery-easing/jquery.easing.min.js"/>'></script>
  
</body>
</html>