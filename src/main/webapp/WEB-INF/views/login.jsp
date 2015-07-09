<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>
	<form action="action">
		<center>
			<h2>Hello World</h2>
			<h2>${message}</h2>
			<ul>
				<li>User name: <input name="username" type="text" /></li>
				<li>Pass word: <input name="password" type="password" /></li>
			</ul>
			<input type="submit" value="login"/>
		</center>
	</form>
</body>
</html>