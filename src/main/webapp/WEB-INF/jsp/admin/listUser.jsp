<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>后台</title>
<!-- Bootstrap Styles-->
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->

<!-- Custom Styles-->
<link href="../assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='https://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link href="../assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default top-navbar" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listCategory">粤茶旅</a>
			</div>
		</nav>

		<!--/. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">

					<li><a href="listCategory"><i class="fa fa-bars"></i> 分类管理</a>
					</li>
					<li><a class="active-menu" href="listUser"><i
							class="fa fa-user"></i> 用户管理</a></li>
					<li><a href="listOrder"><i class="fa fa-list-alt"></i>
							订单管理</a></li>
					<li><a href="listLink"><i class="fa fa-link"></i> 推荐链接管理</a></li>
				</ul>
			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							用户管理 <small></small>
						</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">用户管理表</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>用户id</th>
												<th>用户名</th>
												<th>修改用户密码</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${users}" var="u">
												<tr>
													<td>${u.id}</td>
													<td>${u.name}</td>
													<td><a href="editUser?id=${u.id}"><span
															class="glyphicon glyphicon-edit"></span></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>

			</div>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="../assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="../assets/js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="../assets/js/jquery.metisMenu.js"></script>
	<!-- DATA TABLE SCRIPTS -->
	<script src="../assets/js/dataTables/jquery.dataTables.js"></script>
	<script src="../assets/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
	<!-- Custom Js -->
	<script src="../assets/js/custom-scripts.js"></script>


</body>
</html>
