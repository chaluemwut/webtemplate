<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container" style="position: relative; padding-top: 70px;">
	<p class="navbar-text">การเพิ่มลูกค้า</p>
		<form action="<%=request.getContextPath()%>/customer/save">
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="csCustomerId"
					placeholder=รหัสลูกค้า>
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg"
					name="csCustomerName" placeholder=ชื่อลูกค้า>
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="csRoute"
					placeholder=เส้นทาง สายที่ :>
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="csAddress"
					placeholder=ที่อยู่>
			</div>
			<input type="submit" class="btn btn-primary" value="บันทึก" />
		</form>
	</div>
</body>
</html>