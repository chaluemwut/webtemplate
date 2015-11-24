<!-- Fixed navbar -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<span class="navbar-brand">King iceman center</span>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="<%=request.getContextPath()%>/home/landing">หน้าแรก</a></li>
				<li><a href="<%=request.getContextPath()%>/product/list">สินค้า</a></li>
				<li><a href="<%=request.getContextPath()%>/customer/list">ร้านค้า</a></li>
				<li><a href="<%=request.getContextPath()%>/truck/list">รถ</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>