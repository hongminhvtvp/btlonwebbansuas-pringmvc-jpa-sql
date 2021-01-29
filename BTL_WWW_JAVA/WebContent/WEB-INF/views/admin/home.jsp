<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="<c:url value='BTL_WWW_JAVA/WEB-INF/guicss/foradmin.css'  />" > 
</head>
<body >

	<form:form modelAttribute="sanPhamInfo" method="Get">
		<table>
			<tr>
				<th>ID</th>
				<th>Ten san Pham</th>
				<th>Mo Ta</th>
				<th>So Luong</th>
				<th>Don gia</th>
				<th>Ngay san xuat</th>
				<th>Han su dung</th>
				<th>Nha san Xuat</th>
				<th>Loai San Pham</th>
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${ds }" var="item">
				<tr>
					<td>${item.idSanPham }</td>
					<td>${item.tenSanPham }</td>
					<td>${item.moTa }</td>
					<td>${item.soLuong }</td>
					<td>${item.donGia }</td>
					<td>${item.ngaySanXuat }</td>
					<td>${item.hanSuDung }</td>
					<td>${item.nhaSanXuat.tenNhaSanXuat }</td>
					<td>${item.loaiSanPham.tenLoaiSanPham }</td>
					<td><img alt=""
						src="${pageContext.request.contextPath }/sanPhamImage?idSanPham=${item.idSanPham}"
						width="135px" height="120px"></td>
					<td>
						<%-- <button type="button" class="btn btn-primary passingID" data-toggle="modal" data-target="#myModal" data-id="${item.idSanPham }">Edit</button> --%>
						<a href="admin-editSP?idSanPham=${item.idSanPham }"><button
								type="button" class="btn btn-primary">Edit</button> </a>
					</td>
					<td>
						<button type="button" class="btn btn-primary passingID"
							data-toggle="modal" data-target="#myModal"
							data-id="${item.idSanPham }">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>

	<!-- The Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Canh bao xoa !</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form:form action="admin-deleteSP" method="POST"
						modelAttribute="sanPhamInfo">


						<div class="form-group row">
							<label class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<form:input path="idSanPham" name="idkl" id="idkl"
									value="" placeholder="id san pham" class="form-control"
									readonly="true" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-10 col-form-label">Ban co chac chan
								muon xoa. </label>
						</div>
						<button type="submit" class="btn btn-primary">Delete</button>
					</form:form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>

				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(".passingID").click(function() {
			var ids = $(this).attr('data-id');
			$("#idkl").val(ids);
			$('#myModal').modal('show');
		});
	</script>
</body>
</html>
