<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="form.css">
<title>Login</title>
</head>
<body>
<h2>Login Here</h2>
<form action="verifyLogin" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
	<p style="color: red;">${error}</p>
	<p style="color: red;">${emptymsg}</p>
</body>
</html>