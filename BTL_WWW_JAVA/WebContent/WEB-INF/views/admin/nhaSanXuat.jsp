<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	<div class="row">
		<div class="col-sm" align="center">
			<h1>Them Nha San Xuat</h1>
		</div>
	</div>
	<div class="container mt-4">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-7">
				<form:form action="admin-addNhaSX" method="Post"
					modelAttribute="nhaSanXuatInfo">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Ten</label>
						<div class="col-sm-10">
							<form:input path="tenNhaSanXuat" class="form-control"
								placeholder="Ten nha san xuat" />
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Them</button>
				</form:form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>

	<div class="row mt-4">
		<div class="col-sm" align="center">
			<h1>Danh Sach Nha San Xuat</h1>
		</div>
	</div>
	<div class="row mt-2">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<form:form action="" method="POST" modelAttribute="nhaSanXuatInfo">
				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Ten</th>
							<td scope="col">Edit</td>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ds }" var="item">
							<tr>
								<td><form:hidden path="idNhaSanXuat" />
									${item.idNhaSanXuat }</td>
								<td>${item.tenNhaSanXuat }</td>
								<td>
									<button type="button" class="btn btn-primary passingID"
										data-toggle="modal" data-target="#myModal"
										data-id="${item.idNhaSanXuat }">Edit</button>
								</td>
								<td>
									<button class="btn btn-primary passingIDDelete"
										type="button" data-toggle="modal" data-target="#myModalDelete"
										data-idDelete="${item.idNhaSanXuat }">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form:form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	
	<!-- The Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Edit Nha San Xuat</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form:form action="admin-updateNhaSX" method="POST"
						modelAttribute="nhaSanXuatInfo">


						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<form:input path="idNhaSanXuat" name="idkl" id="idkl" value=""
									placeholder="Ten nha san xuat" class="form-control"
									readonly="true" />
							</div>
						</div>

						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">Ten
							</label>
							<div class="col-sm-5">
								<form:input path="tenNhaSanXuat" class="form-control"
									placeholder="Ten nha san xuat"/>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Update</button>
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

	<!-- The Modal -->
	<div class="modal fade" id="myModalDelete" role="dialog">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Canh bao xoa !</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form:form action="admin-deleteNhaSX" method="POST"
						modelAttribute="nhaSanXuatInfo">


						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-2 col-form-label">ID
							</label>
							<div class="col-sm-5">
								<form:input path="idNhaSanXuat" name="idkl" id="idklDelete" value=""
									placeholder="Ten loai San Pham" class="form-control"
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
		$(".passingIDDelete").click(function() {
			var idsDelete = $(this).attr('data-idDelete');
			$("#idklDelete").val(idsDelete);
			$('#myModalDelete').modal('show');
		});
	</script>
</body>
</html>