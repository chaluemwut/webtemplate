<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>King iceman center</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/home/login">
		<!--login modal-->
		<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="text-center">ลงชื่อเข้าใช้</h1>
					</div>
					<div class="modal-body">
						<form class="form col-md-12 center-block">
							<div class="form-group">
								<input type="text" class="form-control input-lg" name="username"
									placeholder="ชื่อผู้ใช้">
							</div>
							<div class="form-group">
								<input type="password" class="form-control input-lg"
									name="password" placeholder="รหัสผ่าน">
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-lg btn-block">ตกลง</button>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<div class="col-md-12">
							<!--
          <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        -->
						</div>
					</div>
					<div class="form-group" style="position: relative;padding-left: 20px;">
						<a href="<c:url value="/resources/app/app-release.apk" />">Download
							App</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>