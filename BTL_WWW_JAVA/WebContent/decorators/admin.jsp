<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">	
<link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/admin/css/sb-admin.css'/>" rel="stylesheet" type="text/css">

<script src="<c:url value='template/admin/js/jquery-3.5.1.min.js'/>"></script>

</head>
<body class="no-skin">

	<%@ include file="/common/admin/header.jsp" %>
	
	<div class="main-container" id="main-container">

		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->

	<sitemesh-decorator:body></sitemesh-decorator:body>
	
	</div>
		
	<%@ include file="/common/admin/footer.jsp" %>
	
  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value='template/admin/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<c:url value='template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

  <!-- Core plugin JavaScript-->
  <script src='<c:url value="template/admin/vendor/jquery-easing/jquery.easing.min.js"/>'></script>

  <!-- Page level plugin JavaScript-->

  <script src="<c:url value='template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
  <script src="<c:url value='template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

  <!-- Custom scripts for all pages-->
  <script src="<c:url value='template/admin/js/sb-admin.min.js'/>"></script>

  <!-- Demo scripts for this page-->
  <script src="<c:url value='template/admin/js/demo/datatables-demo.js'/>"></script>
 <%--  <script src="<c:url value='template/admin/js/demo/chart-area-demo.js'/>"></script> --%>

</body>
</html>