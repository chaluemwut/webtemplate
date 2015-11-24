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
		<div class="page-header">
			<h1>รายการลูกค้า</h1>
		</div>
		<button type="button" class="btn btn-primary"
			onclick="location.href='<%=request.getContextPath()%>/customer/add';">เพิ่มลูกค้า</button>
		<table class="table">
			<thead>
				<tr>
					<th>รหัสลูกค้า</th>
					<th>ชื่อ</th>
					<th>เส้นทาง</th>
					<th>ที่อยู่</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>

						<td><a href="/kimserver/customer/edit?id=${customer.id}">${customer.csCustomerId}</a></td>
						<td>${customer.csCustomerName}</td>
						<td>${customer.csRoute}</td>
						<td>${customer.csAddress}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>